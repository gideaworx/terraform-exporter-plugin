package plugin

import (
	"github.com/hashicorp/go-plugin"
)

// ServeRPCPlugin is a convenience method for plugin authors to
// offer a plugin over the net/rpc protocol. Go developers should choose
// this method as it is more performant than GRPC. This is a blocking method
// and, as such, should be the last statement in your main function.
//
// *NOTE* Because the plugin host relies on stdout from the plugin executable,
// ensure that all output from your executable is to standard error
func ServeRPCPlugin(info PluginInformation, p ExportPlugin) {
	impl := newAnnotatedPlugin(info, p)

	plugin.Serve(&plugin.ServeConfig{
		HandshakeConfig: plugin.HandshakeConfig{
			ProtocolVersion:  uint(RPCProtocol),
			MagicCookieKey:   HandshakeConfig.MagicCookieKey,
			MagicCookieValue: HandshakeConfig.MagicCookieValue,
		},
		Plugins: plugin.PluginSet{
			"plugin": &rpcPluginImpl{Impl: impl},
		},
	})
}

// ServeGRPCPlugin is a convenience method for plugin authors to
// offer a plugin over the GRPC protocol. This is a blocking method
// and, as such, should be the last statement in your main function.
//
// *NOTE* Because the plugin host relies on stdout from the plugin executable,
// ensure that all output from your executable is to standard error
func ServeGRPCPlugin(info PluginInformation, p ExportPlugin) {
	impl := newAnnotatedPlugin(info, p)

	plugin.Serve(&plugin.ServeConfig{
		HandshakeConfig: plugin.HandshakeConfig{
			ProtocolVersion:  uint(GRPCProtocol),
			MagicCookieKey:   HandshakeConfig.MagicCookieKey,
			MagicCookieValue: HandshakeConfig.MagicCookieValue,
		},
		Plugins: plugin.PluginSet{
			"plugin": &grpcPluginImpl{Impl: impl},
		},
		GRPCServer: plugin.DefaultGRPCServer,
	})
}
