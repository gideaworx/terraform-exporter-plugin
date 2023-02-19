package plugin

import (
	"crypto/sha256"
	"crypto/sha512"
	"encoding/hex"
	"fmt"
	"hash"
	"os"
	"os/exec"
	"path/filepath"
	"strings"

	"github.com/hashicorp/go-hclog"
	"github.com/hashicorp/go-plugin"
)

var hashMap = map[string]hash.Hash{
	"SHA256": sha256.New(),
	"SHA512": sha512.New(),
}

// NewPluginClient loads a plugin for use. This should only be used by a plugin host, and not
// a client
func NewPluginClient(pluginExecutable string, logger hclog.Logger) (*plugin.Client, error) {
	var alg string
	var file string
	var sum string

	baseName := filepath.Base(pluginExecutable)

	sumFile, err := os.Open(fmt.Sprintf("%s.asc", pluginExecutable))
	if err != nil {
		return nil, fmt.Errorf("cannot load checksum file: %w", err)
	}
	defer sumFile.Close()

	fmt.Fscanf(sumFile, "%s %s = %s", &alg, &file, &sum)
	file = strings.Map(func(r rune) rune {
		if r == '(' || r == ')' {
			return -1
		}

		return r
	}, file)

	hasher, ok := hashMap[alg]
	if !ok {
		return nil, fmt.Errorf("invalid hashing algorithm %q. Supported algorithms are SHA256 and SHA512", alg)
	}

	if file != baseName {
		return nil, fmt.Errorf("expected checksum for %s, but found checksum for %s", baseName, file)
	}

	checksum, err := hex.DecodeString(sum)
	if err != nil {
		return nil, fmt.Errorf("%s is an invalid checksum", sum)
	}

	return plugin.NewClient(&plugin.ClientConfig{
		HandshakeConfig: HandshakeConfig,
		VersionedPlugins: map[int]plugin.PluginSet{
			int(RPCProtocol): {
				"plugin": &rpcPluginImpl{},
			},
			int(GRPCProtocol): {
				"plugin": &grpcPluginImpl{},
			},
		},
		AllowedProtocols: []plugin.Protocol{plugin.ProtocolNetRPC, plugin.ProtocolGRPC},
		Logger:           logger,
		Cmd:              exec.Command(pluginExecutable),
		SecureConfig: &plugin.SecureConfig{
			Checksum: checksum,
			Hash:     hasher,
		},
	}), nil
}
