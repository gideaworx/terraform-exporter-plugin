package plugin

import (
	"net/rpc"

	"github.com/hashicorp/go-plugin"
)

type rpcPluginClient struct {
	client *rpc.Client
}

func (p *rpcPluginClient) Export(request ExportRequest) (ExportResponse, error) {
	resp := ExportResponse{}
	err := p.client.Call("Plugin.Export", request, &resp)
	return resp, err
}

func (p *rpcPluginClient) Info() (PluginInformation, error) {
	var info PluginInformation
	err := p.client.Call("Plugin.Info", new(interface{}), &info)
	return info, err
}

type rpcPluginServer struct {
	Impl AnnotatedPlugin
}

func (p *rpcPluginServer) Export(args ExportRequest, resp *ExportResponse) error {
	var err error
	*resp, err = p.Impl.Export(args)
	return err
}

func (p *rpcPluginServer) Info(_ any, resp *PluginInformation) error {
	var err error
	*resp, err = p.Impl.Info()
	return err
}

type rpcPluginImpl struct {
	Impl AnnotatedPlugin
}

func (p *rpcPluginImpl) Server(*plugin.MuxBroker) (any, error) {
	return &rpcPluginServer{Impl: p.Impl}, nil
}

func (p rpcPluginImpl) Client(_ *plugin.MuxBroker, client *rpc.Client) (any, error) {
	return &rpcPluginClient{client: client}, nil
}
