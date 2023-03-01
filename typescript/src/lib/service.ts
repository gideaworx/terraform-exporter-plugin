import { sendUnaryData, ServerUnaryCall, UntypedHandleCall } from "@grpc/grpc-js";
import { reflect, ReflectedTypeRef } from "typescript-rtti";
import { CommandInfo as pbCommandInfo } from "../generated/plugin/CommandInfo";
import { Empty__Output } from "../generated/plugin/Empty";
import { ExportPluginHandlers } from "../generated/plugin/ExportPlugin";
import { ExportRequest__Output } from "../generated/plugin/ExportRequest";
import { ExportResponse } from "../generated/plugin/ExportResponse";
import { ImportDirective as pbImportDirective } from "../generated/plugin/ImportDirective";
import { PluginInfo } from "../generated/plugin/PluginInfo";
import { PluginRequest__Output } from "../generated/plugin/PluginRequest";
import { SingleString, SingleString__Output } from "../generated/plugin/SingleString";
import { ExportFuncKey, ExportPluginCommandKey, HelpFuncKey } from "./annotations";
import { CommandInfo, exportFunc, helpFunc, ImportDirective } from "./interfaces";
import { asGRPC, asVersion, Version, Versionish } from "./version";

type ctorType<T> = { new (): T };
type infoish = CommandInfo | undefined | (() => CommandInfo | undefined);
type ctorWithOptions<T> = [ctor: ctorType<T>, options: { useValue?: T; info?: infoish }];

export type command<T = any> = ctorType<T> | ctorWithOptions<T> | providedCommand;

interface providedCommand {
  export: exportFunc;
  help: helpFunc;
  info: infoish;
}

interface normalizedCommand {
  export: exportFunc;
  help: helpFunc;
  info: CommandInfo | undefined;
}

const reflectedExportParameters = reflect<Parameters<exportFunc>>();
const reflectedExportReturnType = reflect<ReturnType<exportFunc>>();
const reflectedCommandInfo = reflect<CommandInfo>();

type commandMap = { [name: string]: normalizedCommand | undefined };

const commandMap: commandMap = {};
let pluginVersion: Version;

const exportFn = async (name: string, request: ExportRequest__Output | null): Promise<Iterable<ImportDirective>> => {
  const cmd = commandMap[name];
  if (cmd && request) {
    return await Promise.resolve(cmd.export(request.OutputDirectory, request.SkipProviderOutput, request.PluginArgs));
  }

  throw new Error(`command with ${name} is not registered or it was sent an invalid request`);
};

const helpFn = (name: string): string => {
  const cmd = commandMap[name];
  if (cmd) {
    return cmd.help();
  }

  throw new Error(`command with ${name} is not registered`);
};

const infoFn = (): PluginInfo => {
  const cmdInfos: pbCommandInfo[] = [];
  for (const cmd of Object.values(commandMap)) {
    const ci = cmd?.info;
    if (ci) {
      cmdInfos.push({ Name: ci.name, Description: ci.description, Summary: ci.summary, Version: asGRPC(ci.version) });
    }
  }

  return {
    Version: asGRPC(pluginVersion),
    Provides: cmdInfos,
  };
};

export class ExportPluginServiceImpl implements ExportPluginHandlers {
  [name: string]: UntypedHandleCall;

  constructor(version: Versionish, ...commands: command[]) {
    pluginVersion = asVersion(version);
    for (const cmd of commands) {
      const pnc = buildImpl(cmd);
      if (pnc.export && pnc.help && pnc.info) {
        commandMap[pnc.info.name] = pnc as normalizedCommand;
      }
    }
  }

  public Export(call: ServerUnaryCall<PluginRequest__Output, ExportResponse>, callback: sendUnaryData<ExportResponse>) {
    exportFn(call.request.Name, call.request.Request)
      .then((directives) => {
        const newDirectives = Array.of(...directives).map((d) => {
          return {
            Resource: d.resource,
            Name: d.name,
            ID: d.id,
          } as pbImportDirective;
        });

        const er: ExportResponse = {
          Directives: newDirectives,
        };

        callback(null, er);
      })
      .catch((e) => {
        callback(new Error(e));
      });
  }

  public Help(call: ServerUnaryCall<SingleString__Output, SingleString>, callback: sendUnaryData<SingleString>) {
    try {
      const helpText = helpFn(call.request.Value);
      callback(null, {
        Value: helpText,
      });
    } catch (e: any) {
      callback(new Error(e));
    }
  }

  public Info(call: ServerUnaryCall<Empty__Output, PluginInfo>, callback: sendUnaryData<PluginInfo>) {
    const info = infoFn();
    callback(null, {
      Version: asGRPC(pluginVersion),
      Provides: info.Provides,
    });
  }
}

function buildImpl(cmd: command): Partial<normalizedCommand> {
  if (isProvidedCommand(cmd)) {
    if (cmd.info instanceof Function) {
      return {
        export: cmd.export,
        help: cmd.help,
        info: cmd.info(),
      };
    }

    return cmd as normalizedCommand;
  }

  let receiver: any | undefined;
  let ctor: ctorType<any>;
  if (isCtorWithOptions(cmd)) {
    ctor = cmd[0];
    receiver = cmd[1].useValue;
  } else {
    ctor = cmd;
  }

  if (ctor && !receiver) {
    receiver = new ctor();
  }

  return {
    export: findFunction(receiver, ctor, reflectedExportParameters, reflectedExportReturnType, ExportFuncKey),
    help: findFunction(receiver, ctor, reflect<[]>(), reflect<string>(), HelpFuncKey),
    info: findCommandInfo(receiver, ctor),
  };
}

function findCommandInfo<T>(receiver: any, constructor: ctorType<T>): CommandInfo | undefined {
  let info: CommandInfo | undefined = Reflect.getMetadata(ExportPluginCommandKey, constructor) as CommandInfo;
  if (!info) {
    const methods = reflect(constructor).methods;
    for (const m of methods) {
      if (m.parameters.length === 0) {
        const reflectedReturnType = reflect<ReturnType<typeof m.func>>();
        if (reflectedCommandInfo.equals(reflectedReturnType)) {
          info = m.func.apply(receiver);
          break;
        }
      }
    }
  }

  return info;
}

// eslint-disable-next-line @typescript-eslint/ban-types
function findFunction<C extends { new (): any }, R extends Function>(
  receiver: any,
  ctor: C | undefined,
  expectedParameterTypes: ReflectedTypeRef,
  expectedReturnType: ReflectedTypeRef,
  metadataKey: any
): R | undefined {
  if (ctor) {
    const fn: any = Reflect.getMetadata(metadataKey, ctor);
    if (fn && fn in receiver) {
      return receiver[fn].bind(receiver);
    } else {
      const methods = reflect(ctor).methods;
      for (const m of methods) {
        const rp = reflect<Parameters<typeof m.func>>();
        const rr = reflect<ReturnType<typeof m.func>>();

        if (rp.equals(expectedParameterTypes) && rr.equals(expectedReturnType)) {
          return m.func.bind(receiver);
        }
      }

      return undefined;
    }
  } else {
    if (metadataKey in receiver) {
      const fn = receiver[metadataKey];
      if (fn instanceof Function) {
        return fn.bind(receiver);
      }
    }
  }
}

const isCtorType = (c: command): c is ctorType<any> => {
  return "new" in c;
};

const isCtorWithOptions = (c: command): c is ctorWithOptions<any> => {
  return "length" in c && !isCtorType(c) && isCtorType(c[0]);
};

const isProvidedCommand = (c: any): c is providedCommand => {
  return "export" in c && "help" in c && "info" in c;
};
