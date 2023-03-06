package main

import (
	"github.com/gideaworx/terraform-exporter-plugin/examples/golang/shared"
	"github.com/gideaworx/terraform-exporter-plugin/libraries/go-plugin"
)

var Version = plugin.Version{
	Major: 0,
	Minor: 0,
	Patch: 1,
}

func main() {
	plugin.ServeCommands(Version, plugin.RPCProtocol, new(shared.LocalRawFilesCommand))
}
