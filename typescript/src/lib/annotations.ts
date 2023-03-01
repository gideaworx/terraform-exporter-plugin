/* eslint-disable @typescript-eslint/no-unused-vars */
import "reflect-metadata";
import { CommandInfo, exportFunc, helpFunc } from "./interfaces";

import { Versionish, asVersion, DefaultVersion } from "./version";

export const ExportPluginCommandKey = Symbol.for("ExportPluginCommandInfo");
export const ExportFuncKey = Symbol.for("ExportFunction");
export const HelpFuncKey = Symbol.for("CommandHelpFunction");

export function ExportPluginCommand(
  name = "",
  version: Versionish = DefaultVersion,
  description = "",
  summary = ""
): ClassDecorator {
  version = asVersion(version);
  const info: CommandInfo = { name, version, description, summary };

  // eslint-disable-next-line @typescript-eslint/ban-types
  return (target: Function) => {
    Reflect.defineMetadata(ExportPluginCommandKey, info, target);
  };
}

export function ExportFunction(): MethodDecorator {
  return <exportFunc>(target: object, propertyKey: string | symbol, _: TypedPropertyDescriptor<exportFunc>) => {
    if (!Reflect.hasMetadata(ExportPluginCommandKey, target)) {
      throw new Error(
        "Methdods decorated with @ExportFunction() must be members of classes or subclasses decorated with @ExportPluginCommand"
      );
    }

    Reflect.defineMetadata(ExportFuncKey, propertyKey, target);
  };
}

export function HelpFunction(): MethodDecorator {
  return <helpFunc>(target: object, propertyKey: string | symbol, _: TypedPropertyDescriptor<helpFunc>) => {
    if (!Reflect.hasMetadata(ExportPluginCommandKey, target)) {
      throw new Error(
        "Methdods decorated with @HelpFunction() must be members of classes or subclasses decorated with @ExportPluginCommand"
      );
    }

    Reflect.defineMetadata(HelpFuncKey, propertyKey, target);
  };
}
