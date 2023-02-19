package plugin

import (
	"context"

	"github.com/gideaworx/terraform-exporter-plugin/proto"
	"github.com/hashicorp/go-plugin"
	"google.golang.org/grpc"
)

type grpcPluginClient struct {
	client proto.AnnotatedExportPluginClient
}

func (g *grpcPluginClient) Info() (PluginInformation, error) {
	resp, err := g.client.Info(context.Background(), &proto.Empty{})
	if err != nil {
		return PluginInformation{}, err
	}

	return PluginInformation{
		Name:        resp.GetName(),
		Description: resp.GetDescription(),
		Summary:     resp.GetSummary(),
		Version: PluginVersion{
			Major:         resp.GetVersion().GetMajor(),
			Minor:         resp.GetVersion().GetMinor(),
			Patch:         resp.GetVersion().GetPatch(),
			Pre:           resp.GetVersion().GetPre(),
			BuildMetadata: resp.GetVersion().GetBuildMetadata(),
		},
	}, nil
}

func (g *grpcPluginClient) Export(request ExportRequest) (ExportResponse, error) {
	resp, err := g.client.Export(context.Background(), &proto.ExportRequest{
		OutputDirectory:    request.OutputDirectory,
		SkipProviderOutput: request.SkipProviderOutput,
		PluginArgs:         request.PluginArgs,
	})

	if err != nil {
		return ExportResponse{}, err
	}

	if resp == nil {
		return ExportResponse{}, nil
	}

	response := ExportResponse{
		Directives: make([]ImportDirective, 0, len(resp.GetDirectives())),
	}

	for _, directive := range resp.GetDirectives() {
		response.Directives = append(response.Directives, ImportDirective{
			Resource: directive.Resource,
			Name:     directive.Name,
			ID:       directive.ID,
		})
	}

	return response, nil
}

type grpcPluginServer struct {
	proto.UnimplementedAnnotatedExportPluginServer
	Impl AnnotatedPlugin
}

func (g *grpcPluginServer) Info(context.Context, *proto.Empty) (*proto.PluginInfo, error) {
	info, err := g.Impl.Info()
	if err != nil {
		return nil, err
	}

	pversion := &proto.PluginInfo_PluginVersion{
		Major:         info.Version.Major,
		Minor:         info.Version.Minor,
		Patch:         info.Version.Patch,
		Pre:           nil,
		BuildMetadata: nil,
	}

	if info.Version.Pre != "" {
		pversion.Pre = &info.Version.Pre
	}

	if info.Version.BuildMetadata != "" {
		pversion.BuildMetadata = &info.Version.BuildMetadata
	}

	return &proto.PluginInfo{
		Name:        info.Name,
		Description: info.Description,
		Summary:     info.Summary,
		Version:     pversion,
	}, nil
}

func (g *grpcPluginServer) Export(_ context.Context, req *proto.ExportRequest) (*proto.ExportResponse, error) {
	realRequest := ExportRequest{
		OutputDirectory:    req.OutputDirectory,
		SkipProviderOutput: req.SkipProviderOutput,
		PluginArgs:         req.PluginArgs,
	}

	realResponse, err := g.Impl.Export(realRequest)
	if err != nil {
		return nil, err
	}

	protoResponse := &proto.ExportResponse{
		Directives: make([]*proto.ImportDirective, 0, len(realResponse.Directives)),
	}

	for _, realDirective := range realResponse.Directives {
		protoResponse.Directives = append(protoResponse.Directives, &proto.ImportDirective{
			Resource: realDirective.Resource,
			Name:     realDirective.Name,
			ID:       realDirective.ID,
		})
	}

	return protoResponse, nil
}

type grpcPluginImpl struct {
	plugin.Plugin
	Impl AnnotatedPlugin
}

func (p *grpcPluginImpl) GRPCServer(_ *plugin.GRPCBroker, s *grpc.Server) error {
	proto.RegisterAnnotatedExportPluginServer(s, &grpcPluginServer{Impl: p.Impl})
	return nil
}

func (p *grpcPluginImpl) GRPCClient(_ context.Context, _ *plugin.GRPCBroker, c *grpc.ClientConn) (any, error) {
	return &grpcPluginClient{client: proto.NewAnnotatedExportPluginClient(c)}, nil
}
