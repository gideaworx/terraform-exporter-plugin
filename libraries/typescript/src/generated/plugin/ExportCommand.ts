// Original file: ../plugin.proto

import type * as grpc from '@grpc/grpc-js'
import type { MethodDefinition } from '@grpc/proto-loader'
import type { CommandInfo as _plugin_CommandInfo, CommandInfo__Output as _plugin_CommandInfo__Output } from '../plugin/CommandInfo';
import type { Empty as _plugin_Empty, Empty__Output as _plugin_Empty__Output } from '../plugin/Empty';
import type { ExportRequest as _plugin_ExportRequest, ExportRequest__Output as _plugin_ExportRequest__Output } from '../plugin/ExportRequest';
import type { ExportResponse as _plugin_ExportResponse, ExportResponse__Output as _plugin_ExportResponse__Output } from '../plugin/ExportResponse';
import type { SingleString as _plugin_SingleString, SingleString__Output as _plugin_SingleString__Output } from '../plugin/SingleString';

export interface ExportCommandClient extends grpc.Client {
  Export(argument: _plugin_ExportRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  Export(argument: _plugin_ExportRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  Export(argument: _plugin_ExportRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  Export(argument: _plugin_ExportRequest, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_ExportRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_ExportRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_ExportRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_ExportRequest, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  
  Help(argument: _plugin_Empty, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  Help(argument: _plugin_Empty, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  Help(argument: _plugin_Empty, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  Help(argument: _plugin_Empty, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_Empty, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_Empty, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_Empty, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_Empty, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  
  Info(argument: _plugin_Empty, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  Info(argument: _plugin_Empty, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  Info(argument: _plugin_Empty, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  Info(argument: _plugin_Empty, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, callback: grpc.requestCallback<_plugin_CommandInfo__Output>): grpc.ClientUnaryCall;
  
}

export interface ExportCommandHandlers extends grpc.UntypedServiceImplementation {
  Export: grpc.handleUnaryCall<_plugin_ExportRequest__Output, _plugin_ExportResponse>;
  
  Help: grpc.handleUnaryCall<_plugin_Empty__Output, _plugin_SingleString>;
  
  Info: grpc.handleUnaryCall<_plugin_Empty__Output, _plugin_CommandInfo>;
  
}

export interface ExportCommandDefinition extends grpc.ServiceDefinition {
  Export: MethodDefinition<_plugin_ExportRequest, _plugin_ExportResponse, _plugin_ExportRequest__Output, _plugin_ExportResponse__Output>
  Help: MethodDefinition<_plugin_Empty, _plugin_SingleString, _plugin_Empty__Output, _plugin_SingleString__Output>
  Info: MethodDefinition<_plugin_Empty, _plugin_CommandInfo, _plugin_Empty__Output, _plugin_CommandInfo__Output>
}
