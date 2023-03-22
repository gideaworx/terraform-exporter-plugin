from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class CommandInfo(_message.Message):
    __slots__ = ["Description", "Name", "Summary", "Version"]
    DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
    Description: str
    NAME_FIELD_NUMBER: _ClassVar[int]
    Name: str
    SUMMARY_FIELD_NUMBER: _ClassVar[int]
    Summary: str
    VERSION_FIELD_NUMBER: _ClassVar[int]
    Version: Version
    def __init__(self, Name: _Optional[str] = ..., Description: _Optional[str] = ..., Summary: _Optional[str] = ..., Version: _Optional[_Union[Version, _Mapping]] = ...) -> None: ...

class ExportRequest(_message.Message):
    __slots__ = ["OutputDirectory", "PluginArgs", "SkipProviderOutput"]
    OUTPUTDIRECTORY_FIELD_NUMBER: _ClassVar[int]
    OutputDirectory: str
    PLUGINARGS_FIELD_NUMBER: _ClassVar[int]
    PluginArgs: _containers.RepeatedScalarFieldContainer[str]
    SKIPPROVIDEROUTPUT_FIELD_NUMBER: _ClassVar[int]
    SkipProviderOutput: bool
    def __init__(self, OutputDirectory: _Optional[str] = ..., SkipProviderOutput: bool = ..., PluginArgs: _Optional[_Iterable[str]] = ...) -> None: ...

class ExportResponse(_message.Message):
    __slots__ = ["Directives"]
    DIRECTIVES_FIELD_NUMBER: _ClassVar[int]
    Directives: _containers.RepeatedCompositeFieldContainer[ImportDirective]
    def __init__(self, Directives: _Optional[_Iterable[_Union[ImportDirective, _Mapping]]] = ...) -> None: ...

class ImportDirective(_message.Message):
    __slots__ = ["ID", "Name", "Resource"]
    ID: str
    ID_FIELD_NUMBER: _ClassVar[int]
    NAME_FIELD_NUMBER: _ClassVar[int]
    Name: str
    RESOURCE_FIELD_NUMBER: _ClassVar[int]
    Resource: str
    def __init__(self, Resource: _Optional[str] = ..., Name: _Optional[str] = ..., ID: _Optional[str] = ...) -> None: ...

class NoArgs(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class PluginInfo(_message.Message):
    __slots__ = ["Provides", "Version"]
    PROVIDES_FIELD_NUMBER: _ClassVar[int]
    Provides: _containers.RepeatedCompositeFieldContainer[CommandInfo]
    VERSION_FIELD_NUMBER: _ClassVar[int]
    Version: Version
    def __init__(self, Version: _Optional[_Union[Version, _Mapping]] = ..., Provides: _Optional[_Iterable[_Union[CommandInfo, _Mapping]]] = ...) -> None: ...

class PluginRequest(_message.Message):
    __slots__ = ["Name", "Request"]
    NAME_FIELD_NUMBER: _ClassVar[int]
    Name: str
    REQUEST_FIELD_NUMBER: _ClassVar[int]
    Request: ExportRequest
    def __init__(self, Name: _Optional[str] = ..., Request: _Optional[_Union[ExportRequest, _Mapping]] = ...) -> None: ...

class SingleString(_message.Message):
    __slots__ = ["Value"]
    VALUE_FIELD_NUMBER: _ClassVar[int]
    Value: str
    def __init__(self, Value: _Optional[str] = ...) -> None: ...

class Version(_message.Message):
    __slots__ = ["BuildMetadata", "Major", "Minor", "Patch", "Pre"]
    BUILDMETADATA_FIELD_NUMBER: _ClassVar[int]
    BuildMetadata: str
    MAJOR_FIELD_NUMBER: _ClassVar[int]
    MINOR_FIELD_NUMBER: _ClassVar[int]
    Major: int
    Minor: int
    PATCH_FIELD_NUMBER: _ClassVar[int]
    PRE_FIELD_NUMBER: _ClassVar[int]
    Patch: int
    Pre: str
    def __init__(self, Major: _Optional[int] = ..., Minor: _Optional[int] = ..., Patch: _Optional[int] = ..., Pre: _Optional[str] = ..., BuildMetadata: _Optional[str] = ...) -> None: ...
