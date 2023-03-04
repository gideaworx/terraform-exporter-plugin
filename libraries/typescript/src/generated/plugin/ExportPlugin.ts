// Original file: ../plugin.proto

import type * as grpc from '@grpc/grpc-js'
import type { MethodDefinition } from '@grpc/proto-loader'
import type { Empty as _plugin_Empty, Empty__Output as _plugin_Empty__Output } from '../plugin/Empty';
import type { ExportResponse as _plugin_ExportResponse, ExportResponse__Output as _plugin_ExportResponse__Output } from '../plugin/ExportResponse';
import type { PluginInfo as _plugin_PluginInfo, PluginInfo__Output as _plugin_PluginInfo__Output } from '../plugin/PluginInfo';
import type { PluginRequest as _plugin_PluginRequest, PluginRequest__Output as _plugin_PluginRequest__Output } from '../plugin/PluginRequest';
import type { SingleString as _plugin_SingleString, SingleString__Output as _plugin_SingleString__Output } from '../plugin/SingleString';

export interface ExportPluginClient extends grpc.Client {
  Export(argument: _plugin_PluginRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  Export(argument: _plugin_PluginRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  Export(argument: _plugin_PluginRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  Export(argument: _plugin_PluginRequest, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_PluginRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_PluginRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_PluginRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  export(argument: _plugin_PluginRequest, callback: grpc.requestCallback<_plugin_ExportResponse__Output>): grpc.ClientUnaryCall;
  
  Help(argument: _plugin_SingleString, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  Help(argument: _plugin_SingleString, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  Help(argument: _plugin_SingleString, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  Help(argument: _plugin_SingleString, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_SingleString, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_SingleString, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_SingleString, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  help(argument: _plugin_SingleString, callback: grpc.requestCallback<_plugin_SingleString__Output>): grpc.ClientUnaryCall;
  
  Info(argument: _plugin_Empty, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  Info(argument: _plugin_Empty, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  Info(argument: _plugin_Empty, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  Info(argument: _plugin_Empty, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, metadata: grpc.Metadata, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, options: grpc.CallOptions, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  info(argument: _plugin_Empty, callback: grpc.requestCallback<_plugin_PluginInfo__Output>): grpc.ClientUnaryCall;
  
}

export interface ExportPluginHandlers extends grpc.UntypedServiceImplementation {
  Export: grpc.handleUnaryCall<_plugin_PluginRequest__Output, _plugin_ExportResponse>;
  
  Help: grpc.handleUnaryCall<_plugin_SingleString__Output, _plugin_SingleString>;
  
  Info: grpc.handleUnaryCall<_plugin_Empty__Output, _plugin_PluginInfo>;
  
}

export interface ExportPluginDefinition extends grpc.ServiceDefinition {
  Export: MethodDefinition<_plugin_PluginRequest, _plugin_ExportResponse, _plugin_PluginRequest__Output, _plugin_ExportResponse__Output>
  Help: MethodDefinition<_plugin_SingleString, _plugin_SingleString, _plugin_SingleString__Output, _plugin_SingleString__Output>
  Info: MethodDefinition<_plugin_Empty, _plugin_PluginInfo, _plugin_Empty__Output, _plugin_PluginInfo__Output>
}
