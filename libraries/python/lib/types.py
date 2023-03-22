from generated.plugin_pb2_grpc import ExportPluginServicer
from generated.plugin_pb2 import ExportRequest, ExportResponse, PluginRequest, CommandInfo, PluginInfo, NoArgs, Version, SingleString
from typing import TypedDict

class ExportCommand(object):
    """
    An abstract class that all commands to be served by this plugin must inherit and implement
    """
    def __init__(self) -> None:
        pass

    def Export(self, request: ExportRequest) -> ExportResponse:
        raise "Not Implemented"

    def Help(self, commandName: str) -> str:
        raise "Not Implemented"

    def Info(self) -> CommandInfo:
        raise "Not Implemented"


class ExportPlugin(ExportPluginServicer):
    def __init__(self, pluginVersion: Version, *args: ExportCommand) -> None:
        super().__init__()
        self.pluginVersion = pluginVersion
        self.commands = dict[str, ExportCommand]()
        for cmd in args:
            self.commands[cmd.Info().Name] = cmd

    def Export(self, request: PluginRequest, context) -> ExportResponse:
        if request.Name in self.commands:
            return self.commands[request.Name].Export(request.Request)

        raise f"Command {request.Name} not found"

    def Info(self, request: NoArgs, context) -> PluginInfo:
        infos = list(map(lambda cmd: cmd.Info(), self.commands.values()))
        return PluginInfo(Version=self.pluginVersion, Provides=infos)

    def Help(self, request: SingleString, context) -> SingleString:
        if request.Value in self.commands:
            return SingleString(Value=self.commands[request.Value].Help(request.Value))

        raise f"Command {request.Value} not found"
