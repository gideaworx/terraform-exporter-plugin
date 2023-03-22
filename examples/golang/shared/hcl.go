package shared

import (
	"crypto/sha1"
	"encoding/base64"
	"encoding/hex"
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strings"

	"github.com/gideaworx/terraform-exporter-plugin/go-plugin"
	"github.com/hashicorp/hcl/v2"
	"github.com/hashicorp/hcl/v2/hclwrite"
	"github.com/zclconf/go-cty/cty"
)

type OutputType int

const (
	Contents OutputType = iota
	ContentsBase64
)

func writeHCL(log *log.Logger, sourceDir string, sourceFile string,
	outputType OutputType, sensitive bool, outputDir string) (plugin.ImportDirective, error) {
	hclwriter := hclwrite.NewEmptyFile()

	log.Printf("writing %s to HCL", sourceFile)

	contents, err := os.ReadFile(sourceFile)
	if err != nil {
		return plugin.ImportDirective{}, err
	}

	resType := "local_file"
	if sensitive {
		resType = "local_sensitive_file"
	}

	idCalc := sha1.New()
	idCalc.Write(contents)
	idBytes := idCalc.Sum(nil)
	id := hex.EncodeToString(idBytes)

	contentAttr := "content"
	if outputType == ContentsBase64 {
		contentAttr = "content_base64"
		encoded := make([]byte, base64.StdEncoding.EncodedLen(len(contents)))
		base64.StdEncoding.Encode(encoded, contents)

		contents = encoded
	}

	rel, _ := hcl.RelTraversalForExpr(hcl.StaticExpr(cty.StringVal(strings.TrimPrefix(sourceFile, sourceDir)), hcl.Range{}))

	resBlock := hclwriter.Body().AppendNewBlock("resource", []string{resType, filepath.Base(sourceFile)})
	resBlock.Body().SetAttributeValue(contentAttr, cty.StringVal(string(contents)))
	resBlock.Body().SetAttributeTraversal("t", hcl.TraversalJoin(hcl.Traversal{
		hcl.TraverseRoot{Name: "var"},
		hcl.TraverseAttr{Name: "outputDir"},
	}, rel))
	resBlock.Body().SetAttributeValue("filename", cty.StringVal(fmt.Sprintf("{var.outputDir}%s", strings.TrimPrefix(sourceFile, sourceDir))))
	resBlock.Body().SetAttributeValue("directory_permission", cty.StringVal("0777"))
	resBlock.Body().SetAttributeValue("file_permission", cty.StringVal("0666"))
	resBlock.Body().SetAttributeValue("id", cty.StringVal(id))

	outputFile, err := os.Create(filepath.Join(outputDir, fmt.Sprintf("%s_%s.tf", resType, id)))
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
