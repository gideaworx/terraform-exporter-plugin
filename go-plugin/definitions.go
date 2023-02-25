package plugin

import (
	"fmt"
	"strings"

	"github.com/blang/semver/v4"
	"github.com/hashicorp/go-plugin"
)

// ExportPlugin is the interface plugin authors implement
type ExportPlugin interface {
	// Export accepts arguments from the plugin host with the intention
	// that the plugin will create terraform files for a given resource on
	// the local file system. The method returns a list of resource types, names,
	// and IDs. These will be converted by the plugin host into a shell script
	// that, when executed, will run terraform import on the resources in question
	Export(ExportRequest) (ExportResponse, error)
}

// PluginVersion represents a semver.org compliant semantic version
type PluginVersion struct {
	Major         uint64 `json:"major" yaml:"major"`
	Minor         uint64 `json:"minor" yaml:"minor"`
	Patch         uint64 `json:"patch" yaml:"patch"`
	Pre           string `json:"pre" yaml:"pre"`
	BuildMetadata string `json:"meta" yaml:"meta"`
}

func (v PluginVersion) String() string {
	s := &semver.Version{
		Major: v.Major,
		Minor: v.Major,
		Patch: v.Patch,
	}

	if v.Pre != "" {
		s.Pre = []semver.PRVersion{{
			VersionStr: v.Pre,
		}}
	}

	if v.BuildMetadata != "" {
		s.Build = []string{v.BuildMetadata}
	}

	return s.String()
}

// PluginProtocol is a list of plugin versions supported
// by the host
type PluginProtocol uint8

const (
	RPCProtocol  PluginProtocol = 2
	GRPCProtocol PluginProtocol = 3
)

// PluginInformation represents a plugin. The name is used
// as the plugin name when referenced on the command line,
// so it must NOT contain spaces, special characters, or
// unprintable characters
type PluginInformation struct {
	Name        string
	Description string
	Summary     string
	Version     PluginVersion
}

// ExportRequest is sent to the plugin to initiate processing.
// Output files are expected to be written in OutputDirectory, preferably
// without subdirectories. If SkipProviderOutput is false, a "provider.tf"
// file should be written that initializes the terraform provider used to
// manage the newly created files. PluginArgs are a subset of the original
// command line args and can be considered the equivalent of os.Args[1:] if
// the program were executed directly
type ExportRequest struct {
	OutputDirectory    string
	SkipProviderOutput bool
	PluginArgs         []string
}

// ImportDirective represents a recently created resource that should be
// "terraform import"ed into the current state
type ImportDirective struct {
	Resource string
	Name     string
	ID       string
}

// Outputs the directive in a format that can be directly appended to a
// terraform import command line
func (i ImportDirective) String() string {
	return fmt.Sprintf("%s.%s %q", i.Resource, i.Name, i.ID)
}

// ExportResponse should contain all of the resources that were successfully
// created in Export
type ExportResponse struct {
	Directives []ImportDirective
}

// HandshakeConfig is a struct that the plugin host and author must agree
// upon for a successful connection
var HandshakeConfig = plugin.HandshakeConfig{
	MagicCookieKey:   "TF_EXPORTER",
	MagicCookieValue: "exporter-plugin",
}

func FromSemver(s semver.Version) PluginVersion {
	v := PluginVersion{
		Major:         s.Major,
		Minor:         s.Minor,
		Patch:         s.Patch,
		BuildMetadata: strings.Join(s.Build, "."),
	}

	prestr := make([]string, len(s.Pre))
	for i := range s.Pre {
		prestr[i] = s.Pre[i].String()
	}

	v.Pre = strings.Join(prestr, "-")
	return v
}
