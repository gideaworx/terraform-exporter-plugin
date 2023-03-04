package plugin

import (
	"fmt"
	"sort"
	"strings"

	"github.com/blang/semver/v4"
	"github.com/gideaworx/terraform-exporter-plugin/libraries/go-plugin/proto"
	"github.com/hashicorp/go-plugin"
)

type CommandInfo struct {
	Name        string
	Description string
	Summary     string
	Version     Version
}

type ExportCommand interface {
	Export(ExportRequest) (ExportResponse, error)
	Help() (string, error)
	Info() (CommandInfo, error)
}

// ExportPlugin is the interface plugin authors implement
type ExportPlugin interface {
	// Export accepts arguments from the plugin host with the intention
	// that the plugin will create terraform files for a given resource on
	// the local file system. The method returns a list of resource types, names,
	// and IDs. These will be converted by the plugin host into a shell script
	// that, when executed, will run terraform import on the resources in question
	Export(string, ExportRequest) (ExportResponse, error)
	Help(string) (string, error)
	Info() (PluginInformation, error)
}

// Version represents a semver.org compliant semantic version
type Version struct {
	Major         uint64 `toml:"major"`
	Minor         uint64 `toml:"minor"`
	Patch         uint64 `toml:"patch"`
	Pre           string `toml:"pre"`
	BuildMetadata string `toml:"meta"`
}

func (v Version) String() string {
	s := &semver.Version{
		Major: v.Major,
		Minor: v.Major,
		Patch: v.Patch,
	}

	if v.Pre != "" {
		parts := strings.Split(v.Pre, "-")
		pres := make([]semver.PRVersion, len(parts))
		for i := range parts {
			pres[i] = semver.PRVersion{VersionStr: parts[i]}
		}

		s.Pre = pres
	}

	if v.BuildMetadata != "" {
		s.Build = strings.Split(v.BuildMetadata, ".")
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
	Version  Version       `toml:"version"`
	Provides []CommandInfo `toml:"provides"`
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

func FromSemver(s semver.Version) Version {
	v := Version{
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

func FromString(s string) Version {
	sv, _ := semver.ParseTolerant(s)
	return FromSemver(sv)
}

func FromProtoVersion(p *proto.Version) Version {
	if p == nil {
		return Version{}
	}

	return Version{
		Major:         p.GetMajor(),
		Minor:         p.GetMinor(),
		Patch:         p.GetPatch(),
		Pre:           p.GetPre(),
		BuildMetadata: p.GetBuildMetadata(),
	}
}

func ToProtoVersion(v Version) *proto.Version {
	pversion := &proto.Version{
		Major:         v.Major,
		Minor:         v.Minor,
		Patch:         v.Patch,
		Pre:           nil,
		BuildMetadata: nil,
	}

	if v.Pre != "" {
		pversion.Pre = &v.Pre
	}

	if v.BuildMetadata != "" {
		pversion.BuildMetadata = &v.BuildMetadata
	}

	return pversion
}

type pluginImpl struct {
	version  Version
	commands map[string]ExportCommand
}

func NewExportPlugin(version Version, commands ...ExportCommand) ExportPlugin {
	p := &pluginImpl{
		version:  version,
		commands: make(map[string]ExportCommand),
	}

	for _, c := range commands {
		i, _ := c.Info()
		p.commands[i.Name] = c
	}

	return p
}

func (p *pluginImpl) Export(commandName string, request ExportRequest) (ExportResponse, error) {
	c, ok := p.commands[commandName]
	if !ok {
		return ExportResponse{}, fmt.Errorf("command %s not provided by this plugin", commandName)
	}

	return c.Export(request)
}

func (p *pluginImpl) Info() (PluginInformation, error) {
	i := PluginInformation{
		Version:  p.version,
		Provides: make([]CommandInfo, 0, len(p.commands)),
	}

	for _, cmd := range p.commands {
		info, err := cmd.Info()
		if err != nil {
			return PluginInformation{}, err
		}

		i.Provides = append(i.Provides, info)
	}

	sort.Slice(i.Provides, func(x, y int) bool {
		return strings.Compare(i.Provides[x].Name, i.Provides[y].Name) < 0
	})

	return i, nil
}

func (p *pluginImpl) Help(commandName string) (string, error) {
	c, ok := p.commands[commandName]
	if !ok {
		return "", fmt.Errorf("command %s not provided by this plugin", commandName)
	}

	return c.Help()
}
