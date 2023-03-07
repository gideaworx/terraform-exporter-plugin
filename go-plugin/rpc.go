package plugin

import (
	"net/rpc"

	"github.com/hashicorp/go-plugin"
)

type rpcPluginClient struct {
	client *rpc.Client
}

func (p *rpcPluginClient) Export(name string, request ExportCommandRequest) (ExportResponse, error) {
	var resp ExportResponse
	err := p.client.Call("Plugin.Export", ExportPluginRequest{Name: name, Request: request}, &resp)
	return resp, err
}

func (p *rpcPluginClient) Info() (PluginInformation, error) {
	var info PluginInformation
	err := p.client.Call("Plugin.Info", new(interface{}), &info)
	return info, err
}

func (p *rpcPluginClient) Help(name string) (string, error) {
	var resp string
	err := p.client.Call("Plugin.Help", name, &resp)
	return resp, err
}

type rpcPluginServer struct {
	Impl ExportPlugin
}

func (p *rpcPluginServer) Export(r ExportPluginRequest, resp *ExportResponse) error {
	var err error
	*resp, err = p.Impl.Export(r.Name, r.Request)
	return err
}

func (p *rpcPluginServer) Info(_ any, resp *PluginInformation) error {
	var err error
	*resp, err = p.Impl.Info()
	return err
}

func (p *rpcPluginServer) Help(name string, resp *string) error {
	var err error
	*resp, err = p.Impl.Help(name)
	return err
}

type RPCExportPlugin struct {
	Impl ExportPlugin
}

func (p *RPCExportPlugin) Server(*plugin.MuxBroker) (any, error) {
	return &rpcPluginServer{Impl: p.Impl}, nil
}

func (p RPCExportPlugin) Client(_ *plugin.MuxBroker, client *rpc.Client) (any, error) {
	return &rpcPluginClient{client: client}, nil
}
