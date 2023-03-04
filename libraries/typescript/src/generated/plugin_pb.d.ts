// package: plugin
// file: plugin.proto

import * as jspb from "google-protobuf";

export class ExportRequest extends jspb.Message {
  getOutputdirectory(): string;
  setOutputdirectory(value: string): void;

  getSkipprovideroutput(): boolean;
  setSkipprovideroutput(value: boolean): void;

  clearPluginargsList(): void;
  getPluginargsList(): Array<string>;
  setPluginargsList(value: Array<string>): void;
  addPluginargs(value: string, index?: number): string;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): ExportRequest.AsObject;
  static toObject(includeInstance: boolean, msg: ExportRequest): ExportRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: ExportRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): ExportRequest;
  static deserializeBinaryFromReader(message: ExportRequest, reader: jspb.BinaryReader): ExportRequest;
}

export namespace ExportRequest {
  export type AsObject = {
    outputdirectory: string,
    skipprovideroutput: boolean,
    pluginargsList: Array<string>,
  }
}

export class ImportDirective extends jspb.Message {
  getResource(): string;
  setResource(value: string): void;

  getName(): string;
  setName(value: string): void;

  getId(): string;
  setId(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): ImportDirective.AsObject;
  static toObject(includeInstance: boolean, msg: ImportDirective): ImportDirective.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: ImportDirective, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): ImportDirective;
  static deserializeBinaryFromReader(message: ImportDirective, reader: jspb.BinaryReader): ImportDirective;
}

export namespace ImportDirective {
  export type AsObject = {
    resource: string,
    name: string,
    id: string,
  }
}

export class Version extends jspb.Message {
  getMajor(): number;
  setMajor(value: number): void;

  getMinor(): number;
  setMinor(value: number): void;

  getPatch(): number;
  setPatch(value: number): void;

  hasPre(): boolean;
  clearPre(): void;
  getPre(): string;
  setPre(value: string): void;

  hasBuildmetadata(): boolean;
  clearBuildmetadata(): void;
  getBuildmetadata(): string;
  setBuildmetadata(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Version.AsObject;
  static toObject(includeInstance: boolean, msg: Version): Version.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Version, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Version;
  static deserializeBinaryFromReader(message: Version, reader: jspb.BinaryReader): Version;
}

export namespace Version {
  export type AsObject = {
    major: number,
    minor: number,
    patch: number,
    pre: string,
    buildmetadata: string,
  }
}

export class CommandInfo extends jspb.Message {
  getName(): string;
  setName(value: string): void;

  getDescription(): string;
  setDescription(value: string): void;

  getSummary(): string;
  setSummary(value: string): void;

  hasVersion(): boolean;
  clearVersion(): void;
  getVersion(): Version | undefined;
  setVersion(value?: Version): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CommandInfo.AsObject;
  static toObject(includeInstance: boolean, msg: CommandInfo): CommandInfo.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: CommandInfo, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CommandInfo;
  static deserializeBinaryFromReader(message: CommandInfo, reader: jspb.BinaryReader): CommandInfo;
}

export namespace CommandInfo {
  export type AsObject = {
    name: string,
    description: string,
    summary: string,
    version?: Version.AsObject,
  }
}

export class PluginInfo extends jspb.Message {
  hasVersion(): boolean;
  clearVersion(): void;
  getVersion(): Version | undefined;
  setVersion(value?: Version): void;

  clearProvidesList(): void;
  getProvidesList(): Array<CommandInfo>;
  setProvidesList(value: Array<CommandInfo>): void;
  addProvides(value?: CommandInfo, index?: number): CommandInfo;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): PluginInfo.AsObject;
  static toObject(includeInstance: boolean, msg: PluginInfo): PluginInfo.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: PluginInfo, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): PluginInfo;
  static deserializeBinaryFromReader(message: PluginInfo, reader: jspb.BinaryReader): PluginInfo;
}

export namespace PluginInfo {
  export type AsObject = {
    version?: Version.AsObject,
    providesList: Array<CommandInfo.AsObject>,
  }
}

export class ExportResponse extends jspb.Message {
  clearDirectivesList(): void;
  getDirectivesList(): Array<ImportDirective>;
  setDirectivesList(value: Array<ImportDirective>): void;
  addDirectives(value?: ImportDirective, index?: number): ImportDirective;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): ExportResponse.AsObject;
  static toObject(includeInstance: boolean, msg: ExportResponse): ExportResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: ExportResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): ExportResponse;
  static deserializeBinaryFromReader(message: ExportResponse, reader: jspb.BinaryReader): ExportResponse;
}

export namespace ExportResponse {
  export type AsObject = {
    directivesList: Array<ImportDirective.AsObject>,
  }
}

export class Empty extends jspb.Message {
  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Empty.AsObject;
  static toObject(includeInstance: boolean, msg: Empty): Empty.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Empty, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Empty;
  static deserializeBinaryFromReader(message: Empty, reader: jspb.BinaryReader): Empty;
}

export namespace Empty {
  export type AsObject = {
  }
}

export class SingleString extends jspb.Message {
  getValue(): string;
  setValue(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): SingleString.AsObject;
  static toObject(includeInstance: boolean, msg: SingleString): SingleString.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: SingleString, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): SingleString;
  static deserializeBinaryFromReader(message: SingleString, reader: jspb.BinaryReader): SingleString;
}

export namespace SingleString {
  export type AsObject = {
    value: string,
  }
}

export class PluginRequest extends jspb.Message {
  getName(): string;
  setName(value: string): void;

  hasRequest(): boolean;
  clearRequest(): void;
  getRequest(): ExportRequest | undefined;
  setRequest(value?: ExportRequest): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): PluginRequest.AsObject;
  static toObject(includeInstance: boolean, msg: PluginRequest): PluginRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: PluginRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): PluginRequest;
  static deserializeBinaryFromReader(message: PluginRequest, reader: jspb.BinaryReader): PluginRequest;
}

export namespace PluginRequest {
  export type AsObject = {
    name: string,
    request?: ExportRequest.AsObject,
  }
}

