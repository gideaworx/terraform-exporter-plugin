// Original file: ../plugin.proto

import type { Version as _plugin_Version, Version__Output as _plugin_Version__Output } from '../plugin/Version';
import type { CommandInfo as _plugin_CommandInfo, CommandInfo__Output as _plugin_CommandInfo__Output } from '../plugin/CommandInfo';

export interface PluginInfo {
  'Version'?: (_plugin_Version | null);
  'Provides'?: (_plugin_CommandInfo)[];
}

export interface PluginInfo__Output {
  'Version': (_plugin_Version__Output | null);
  'Provides': (_plugin_CommandInfo__Output)[];
}
