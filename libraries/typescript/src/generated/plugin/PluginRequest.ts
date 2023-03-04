// Original file: ../plugin.proto

import type { ExportRequest as _plugin_ExportRequest, ExportRequest__Output as _plugin_ExportRequest__Output } from '../plugin/ExportRequest';

export interface PluginRequest {
  'Name'?: (string);
  'Request'?: (_plugin_ExportRequest | null);
}

export interface PluginRequest__Output {
  'Name': (string);
  'Request': (_plugin_ExportRequest__Output | null);
}
