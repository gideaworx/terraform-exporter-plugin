// Original file: ../plugin.proto

import type { Version as _plugin_Version, Version__Output as _plugin_Version__Output } from '../plugin/Version';

export interface CommandInfo {
  'Name'?: (string);
  'Description'?: (string);
  'Summary'?: (string);
  'Version'?: (_plugin_Version | null);
}

export interface CommandInfo__Output {
  'Name': (string);
  'Description': (string);
  'Summary': (string);
  'Version': (_plugin_Version__Output | null);
}
