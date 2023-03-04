package shared

import (
	"bytes"
	"flag"
	"path/filepath"
	"sync"

	"github.com/gideaworx/terraform-exporter-plugin/libraries/go-plugin"
)

var Version string = "0.0.1"

type LocalRawFilesCommand struct {
	helpText string
}

func (l *LocalRawFilesCommand) Export(request plugin.ExportRequest) (plugin.ExportResponse, error) {
	sourceDir, matchGlob, err := l.parseFlags(request.PluginArgs)
	if err != nil {
		return plugin.ExportResponse{}, err
	}

	sourceAbs, err := filepath.Abs(sourceDir)
	if err != nil {
		return plugin.ExportResponse{}, err
	}

	matchingFiles, err := filepath.Glob(filepath.Join(sourceAbs, matchGlob))
	if err != nil {
		return plugin.ExportResponse{}, err
	}

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

				d, err := WriteHCL(sourceAbs, file, Contents, false, request.OutputDirectory)
				wg.Done()

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
