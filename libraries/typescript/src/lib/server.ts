import { Server, ServerCredentials } from "@grpc/grpc-js";
import health from "grpc-health-check/health";
import { ExportPluginService } from "../generated/plugin_grpc_pb";
import { command, ExportPluginServiceImpl } from "./service";
import { Versionish } from "./version";
import { listeningAddress } from "./network";
import { AllowedProtocols, AppProtocol, MagicKey, MagicValue, PluginProtocol } from "./constants";

export class PluginServer {
  private server: Server;
  private minPort = 1024;
  private maxPort = 65535;

  constructor(version: Versionish, private readonly listenerType: "tcp" | "unix" = "tcp", ...commands: command[]) {
    this.server = new Server();
    this.server.addService(ExportPluginService, new ExportPluginServiceImpl(version, ...commands));
    this.server.addService(health.service, new health.Implementation());
    this.verifyEnvironment();
  }

  public async run(): Promise<void> {
    let address = await listeningAddress(this.listenerType, this.minPort, this.maxPort);
    return new Promise((_, reject) => {
      this.server.bindAsync(address, ServerCredentials.createInsecure(), (err: Error | null) => {
        if (err) {
          reject(err);
        }

        if (this.listenerType == "unix") {
          address = address.substring("unix://".length);
        }

        this.server.start();
        process.stdout.write(`${PluginProtocol}|${AppProtocol}|${this.listenerType}|${address}|grpc\n`);
      });
    });
  }

  private verifyEnvironment(): void {
    let dothrow = false;
    if (!process.env[MagicKey] || process.env[MagicKey] !== MagicValue) {
      dothrow = true;
    }

    if (!dothrow) {
      dothrow =
        (process.env[AllowedProtocols] ?? "")
          .split(",")
          .map(parseInt)
          .filter((v) => v === AppProtocol).length > 0;
    }

    if (!dothrow) {
      this.minPort = parseInt(process.env.PLUGIN_MIN_PORT ?? "1024");
      this.maxPort = parseInt(process.env.PLUGIN_MAX_PORT ?? "65535");
    }

    if (dothrow) {
      throw new Error(`Startup verification failed`);
    }
  }
}
