import type * as grpc from '@grpc/grpc-js';
import type { MessageTypeDefinition } from '@grpc/proto-loader';

import type { ExportCommandClient as _plugin_ExportCommandClient, ExportCommandDefinition as _plugin_ExportCommandDefinition } from './plugin/ExportCommand';
import type { ExportPluginClient as _plugin_ExportPluginClient, ExportPluginDefinition as _plugin_ExportPluginDefinition } from './plugin/ExportPlugin';

type SubtypeConstructor<Constructor extends new (...args: any) => any, Subtype> = {
  new(...args: ConstructorParameters<Constructor>): Subtype;
};

export interface ProtoGrpcType {
  plugin: {
    CommandInfo: MessageTypeDefinition
    Empty: MessageTypeDefinition
    ExportCommand: SubtypeConstructor<typeof grpc.Client, _plugin_ExportCommandClient> & { service: _plugin_ExportCommandDefinition }
    ExportPlugin: SubtypeConstructor<typeof grpc.Client, _plugin_ExportPluginClient> & { service: _plugin_ExportPluginDefinition }
    ExportRequest: MessageTypeDefinition
    ExportResponse: MessageTypeDefinition
    ImportDirective: MessageTypeDefinition
    PluginInfo: MessageTypeDefinition
    PluginRequest: MessageTypeDefinition
    SingleString: MessageTypeDefinition
    Version: MessageTypeDefinition
  }
}

