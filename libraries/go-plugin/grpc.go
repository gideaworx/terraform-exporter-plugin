package plugin

import (
	"context"
	"errors"

	"github.com/gideaworx/terraform-exporter-plugin/libraries/go-plugin/proto"
	"github.com/hashicorp/go-plugin"
	"google.golang.org/grpc"
)

type grpcPluginClient struct {
	client proto.ExportPluginClient
}

func (g *grpcPluginClient) Info() (PluginInformation, error) {
	resp, err := g.client.Info(context.Background(), &proto.NoArgs{})
	if err != nil {
		return PluginInformation{}, err
	}

	info := PluginInformation{
		Version:  FromProtoVersion(resp.GetVersion()),
		Provides: make([]CommandInfo, 0, len(resp.GetProvides())),
	}

	for _, protoProvides := range resp.GetProvides() {
		if protoProvides == nil {
			continue
		}

		info.Provides = append(info.Provides, CommandInfo{
			Name:        protoProvides.GetName(),
			Description: protoProvides.GetDescription(),
			Summary:     protoProvides.GetSummary(),
			Version:     FromProtoVersion(protoProvides.GetVersion()),
		})
	}

	return info, nil
}

func (g *grpcPluginClient) Export(name string, request ExportRequest) (ExportResponse, error) {
	resp, err := g.client.Export(context.Background(), &proto.PluginRequest{
		Name: name,
		Request: &proto.ExportRequest{
			OutputDirectory:    request.OutputDirectory,
			SkipProviderOutput: request.SkipProviderOutput,
			PluginArgs:         request.PluginArgs,
		},
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
	proto.UnimplementedExportPluginServer
	Impl ExportPlugin
}

func (g *grpcPluginServer) Info(context.Context, *proto.NoArgs) (*proto.PluginInfo, error) {
	info, err := g.Impl.Info()
	if err != nil {
		return nil, err
	}

	pi := &proto.PluginInfo{
		Version:  ToProtoVersion(info.Version),
		Provides: make([]*proto.CommandInfo, 0, len(info.Provides)),
	}

	for _, ci := range info.Provides {
		pi.Provides = append(pi.Provides, &proto.CommandInfo{
			Name:        ci.Name,
			Description: ci.Description,
			Summary:     ci.Summary,
			Version:     ToProtoVersion(ci.Version),
		})
	}

	return pi, nil
}

func (g *grpcPluginServer) Export(_ context.Context, req *proto.PluginRequest) (*proto.ExportResponse, error) {
	if req == nil || req.Name == "" || req.Request == nil {
		return nil, errors.New("invalid request")
	}
	realRequest := ExportRequest{
		OutputDirectory:    req.Request.OutputDirectory,
		SkipProviderOutput: req.Request.SkipProviderOutput,
		PluginArgs:         req.Request.PluginArgs,
	}

	realResponse, err := g.Impl.Export(req.Name, realRequest)
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

func (g *grpcPluginServer) Help(_ context.Context, req *proto.SingleString) (*proto.SingleString, error) {
	if req == nil {
		return nil, errors.New("invalid request")
	}

	realResponse, err := g.Impl.Help(req.GetValue())
	if err != nil {
		return nil, err
	}

	return &proto.SingleString{Value: realResponse}, nil
}

type GRPCExportPlugin struct {
	plugin.Plugin
	Impl ExportPlugin
}

func (p *GRPCExportPlugin) GRPCServer(_ *plugin.GRPCBroker, s *grpc.Server) error {
	proto.RegisterExportPluginServer(s, &grpcPluginServer{Impl: p.Impl})
	return nil
}

func (p *GRPCExportPlugin) GRPCClient(_ context.Context, _ *plugin.GRPCBroker, c *grpc.ClientConn) (any, error) {
	return &grpcPluginClient{client: proto.NewExportPluginClient(c)}, nil
}
