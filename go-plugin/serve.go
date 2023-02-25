package plugin

import (
	"github.com/hashicorp/go-plugin"
)

func ServeCommands(version Version, protocol PluginProtocol, commands ...ExportCommand) {
	impl := NewExportPlugin(version, commands...)

	switch protocol {
	case GRPCProtocol:
		plugin.Serve(&plugin.ServeConfig{
			HandshakeConfig: plugin.HandshakeConfig{
				ProtocolVersion:  uint(GRPCProtocol),
				MagicCookieKey:   HandshakeConfig.MagicCookieKey,
				MagicCookieValue: HandshakeConfig.MagicCookieValue,
			},
			Plugins: plugin.PluginSet{
				"plugin": &GRPCExportPlugin{Impl: impl},
			},
			GRPCServer: plugin.DefaultGRPCServer,
		})
	default:
		plugin.Serve(&plugin.ServeConfig{
			HandshakeConfig: plugin.HandshakeConfig{
				ProtocolVersion:  uint(RPCProtocol),
				MagicCookieKey:   HandshakeConfig.MagicCookieKey,
				MagicCookieValue: HandshakeConfig.MagicCookieValue,
			},
			Plugins: plugin.PluginSet{
				"plugin": &RPCExportPlugin{Impl: impl},
			},
		})
	}
}
