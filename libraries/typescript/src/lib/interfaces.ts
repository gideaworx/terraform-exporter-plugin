import { CommandInfo as pbCommandInfo, ImportDirective as pbImportDirective } from "../generated/plugin_pb";

export type ImportDirective = pbImportDirective.AsObject;
export type CommandInfo = pbCommandInfo.AsObject;

export type exportFunc = (
  outputDirectory: string,
  skipProviderOutput: boolean,
  pluginArgs: Iterable<string>
) => Iterable<ImportDirective> | Promise<Iterable<ImportDirective>>;

export type helpFunc = () => string;

export type infoFunc = () => CommandInfo;
