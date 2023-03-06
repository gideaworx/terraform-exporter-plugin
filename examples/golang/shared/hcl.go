package shared

import (
	"crypto/sha1"
	"encoding/base64"
	"encoding/hex"
	"fmt"
	"os"
	"path/filepath"
	"strings"

	"github.com/gideaworx/terraform-exporter-plugin/libraries/go-plugin"
	"github.com/hashicorp/hcl/v2/hclwrite"
	"github.com/zclconf/go-cty/cty"
)

type OutputType int

const (
	Contents OutputType = iota
	ContentsBase64
)

func writeHCL(sourceDir, sourceFile string, outputType OutputType, sensitive bool, outputDir string) (plugin.ImportDirective, error) {
	hclwriter := hclwrite.NewEmptyFile()

	contents, err := os.ReadFile(sourceFile)
	if err != nil {
		return plugin.ImportDirective{}, err
	}

	resType := "local_file"
	if sensitive {
		resType = "local_sensitive_file"
	}

	idCalc := sha1.New()
	idBytes := idCalc.Sum(contents)
	id := hex.EncodeToString(idBytes)

	contentAttr := "content"
	if outputType == ContentsBase64 {
		contentAttr = "content_base64"
		encoded := make([]byte, base64.StdEncoding.EncodedLen(len(contents)))
		base64.StdEncoding.Encode(encoded, contents)

		contents = encoded
	}

	resBlock := hclwriter.Body().AppendNewBlock("resource", []string{resType, filepath.Base(sourceFile)})
	resBlock.Body().SetAttributeValue(contentAttr, cty.StringVal(string(contents)))
	resBlock.Body().SetAttributeValue("filename", cty.StringVal(fmt.Sprintf("${var.outputDir}%s", strings.TrimPrefix(sourceFile, sourceDir))))
	resBlock.Body().SetAttributeValue("directory_permission", cty.StringVal("0777"))
	resBlock.Body().SetAttributeValue("file_permission", cty.StringVal("0666"))
	resBlock.Body().SetAttributeValue("id", cty.StringVal(id))

	outputFile, err := os.Create(filepath.Join(sourceDir, fmt.Sprintf("%s_%s.tf", resType, id)))
	if err != nil {
		return plugin.ImportDirective{}, err
	}
	defer outputFile.Close()

	_, err = hclwriter.WriteTo(outputFile)
	if err != nil {
		return plugin.ImportDirective{}, err
	}

	return plugin.ImportDirective{
		Resource: resType,
		Name:     filepath.Base(sourceFile),
		ID:       id,
	}, nil
}
