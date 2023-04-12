from terraform_exporter_plugin import ExportCommand, ServePlugin, Version
from terraform_exporter_plugin.generated.plugin_pb2 import CommandInfo, ExportRequest, ExportResponse, ImportDirective
from argparse import ArgumentParser
from base64 import b64encode
import os
import hashlib

class Base64LocalFilesCommand(ExportCommand):
    def __init__(self, version: Version) -> None:
        super().__init__()
        self.version = version
        self.parser = ArgumentParser(prog="base64-local-files")
        self.parser.add_argument("-s", "--source-directory", default=".", dest="source_dir")
        self.parser.add_argument("-t", "--target-directory", default=".", dest="target_dir")
        self.tf_installed = 0 == os.system("which terraform > /dev/null")
    
    def Info(self) -> CommandInfo:
        return CommandInfo(
            Name="base64-local-files", 
            Description="Saves files to terraform resources in base64 encoded format", 
            Summary="Uses the terraform 'local' provider to save local files in base64 format",
            Version=self.version
        )
    
    def Help(self) -> str:
        return self.parser.format_help()
    
    def Export(self, request: ExportRequest) -> ExportResponse:
        args = self.parser.parse_args(request.PluginArgs)

        directives = list[ImportDirective]()

        direntries = os.listdir(args.source_dir)
        files = [f for f in direntries if os.path.isfile(f"{args.source_dir}/{f}")]

        for f in files:
            contents = ""
            with open(f, "rb") as fp:
                contents = fp.read()
                fp.close()
            
            hasher = hashlib.sha1()
            hasher.update(contents)
            checksum = hasher.hexdigest()
            outfile = f"{request.OutputDirectory}/local_file_b64_{checksum}"

            with open(outfile, "x") as of:
                contents = f"""
                resource "local_file" "{os.path.basename(f)}" {{
                    content_base64 = "{b64encode(contents).decode("utf-8")}"
                    filename = "{args.target_directory}/{os.path.basename(f)}"
                    file_permission = "{os.stat(f).st_mode}"
                }}
                """
                of.writelines(contents)
                of.close()
                if self.tf_installed:
                    os.system(f"terraform fmt {outfile} >/dev/null")

                directives.append(ImportDirective(Resource="local_file", Name=os.path.basename(f), ID=checksum))
        
        if not request.SkipProviderOutput:
            with open(f"{request.OutputDirectory}/provider.tf", "x") as pf:
                pf.writelines("""
                terraform {
                    required_providers {
                        local = {
                            source = "hashicorp/local"
                            version = "2.4.0"
                        }
                    }
                }

                provider "local" { }
                """)
                pf.close()
                if self.tf_installed:
                    os.system(f"terraform fmt {request.OutputDirectory}/provider.tf >/dev/null")
        
        return ExportResponse(Directives=directives)

if __name__ == "__main__":
    v = Version(Major=0, Minor=0, Patch=1)
    ServePlugin(v, True, Base64LocalFilesCommand(v))