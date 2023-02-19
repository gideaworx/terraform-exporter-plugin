package plugin

// AnnotatedPlugin implements the core ExportPlugin functionality
// as well as the ability to return information about the Plugin.
// The plugin developer need not implement this interface directly,
// as it is created by the ServeRPCPlugin and ServeGRPCPlugin functions
type AnnotatedPlugin interface {
	ExportPlugin

	// Info returns information about the plugin, include the name
	// that is used by the client, its version, and its description.
	Info() (PluginInformation, error)
}

type annotatedPluginImpl struct {
	i PluginInformation
	p ExportPlugin
}

func (a annotatedPluginImpl) Export(args ExportRequest) (ExportResponse, error) {
	return a.p.Export(args)
}

func (a annotatedPluginImpl) Info() (PluginInformation, error) {
	return a.i, nil
}

func newAnnotatedPlugin(info PluginInformation, p ExportPlugin) AnnotatedPlugin {
	return &annotatedPluginImpl{
		i: info,
		p: p,
	}
}
