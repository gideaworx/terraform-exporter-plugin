package shared

import (
	"bytes"
	"flag"
	"log"
	"os"
	"path/filepath"
	"sync"

	"github.com/gideaworx/terraform-exporter-plugin/go-plugin"
)

var Version string = "0.0.1"

const provider = `
terraform {
	required_providers {
		local = {
		source = "hashicorp/local"
		version = "2.3.0"
		}
	}
}

provider "local" {
}
`

type LocalRawFilesCommand struct {
	helpText string
	logger   *log.Logger
}

func NewLocalRawFilesCommand(log *log.Logger) *LocalRawFilesCommand {
	return &LocalRawFilesCommand{
		logger: log,
	}
}

func (l *LocalRawFilesCommand) Export(request plugin.ExportCommandRequest) (plugin.ExportResponse, error) {
	l.logger.Println("hello world")
	sourceDir, matchGlob, err := l.parseFlags(request.PluginArgs)
	if err != nil {
		l.logger.Println(err.Error())
		return plugin.ExportResponse{}, err
	}

	l.logger.Println(sourceDir, matchGlob)

	sourceAbs, err := filepath.Abs(sourceDir)
	if err != nil {
		return plugin.ExportResponse{}, err
	}

	pattern := filepath.Join(sourceAbs, matchGlob)
	l.logger.Println(pattern)
	matchingFiles, err := filepath.Glob(filepath.Join(sourceAbs, matchGlob))
	if err != nil {
		return plugin.ExportResponse{}, err
	}

	l.logger.Printf("%v", matchingFiles)

	workQueue := make(chan string, len(matchingFiles))
	wg := &sync.WaitGroup{}
	wg.Add(len(matchingFiles))

	directives := []plugin.ImportDirective{}
	lock := &sync.Mutex{}

	for i := 0; i < 25; i++ {
		go func() {
			for {
				file, ok := <-workQueue
				if !ok {
					break
				}

				d, err := writeHCL(l.logger, sourceAbs, file, Contents, false, request.OutputDirectory)
				wg.Done()
				if err != nil {
					log.Println(err)
					break
				}

				lock.Lock()
				directives = append(directives, d)
				lock.Unlock()
			}
		}()
	}

	for _, m := range matchingFiles {
		workQueue <- m
	}

	close(workQueue)
	wg.Wait()

	if !request.SkipProviderOutput {
		os.WriteFile(filepath.Join(request.OutputDirectory, "provider.tf"), []byte(provider), 0o666)
	}

	return plugin.ExportResponse{
		Directives: directives,
	}, nil
}

func (l *LocalRawFilesCommand) Help() (string, error) {
	l.parseFlags([]string{})

	return l.helpText, nil
}

func (l *LocalRawFilesCommand) parseFlags(args []string) (string, string, error) {
	var (
		sourceDir string
		matchGlob string
		err       error
	)

	flags := flag.NewFlagSet("raw-files", flag.ContinueOnError)

	flags.StringVar(&sourceDir, "source-dir", ".", "The source dir where the raw files will be read from")
	flags.StringVar(&matchGlob, "matches", "**/*", "The glob pattern to match files for export")

	buf := &bytes.Buffer{}
	flags.SetOutput(buf)
	flags.Usage()

	l.helpText = buf.String()

	err = flags.Parse(args)
	return sourceDir, matchGlob, err
}

func (l *LocalRawFilesCommand) Info() (plugin.CommandInfo, error) {
	return plugin.CommandInfo{
		Name:        "raw-files",
		Description: "Outputs terraform definitions for raw files on the filesystem",
		Summary:     "When using this command, the files will use the 'contents' section of the 'local_files' provider",
		Version:     plugin.FromString(Version),
	}, nil
}
