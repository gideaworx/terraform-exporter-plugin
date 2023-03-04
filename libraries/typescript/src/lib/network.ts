import os from "os";
import crypto from "crypto";
import path from "path";
import fs from "fs/promises";
import { createServer } from "net";

export const listeningAddress = async (type: "tcp" | "unix", minPort = 1024, maxPort = 65_535): Promise<string> => {
  switch (type) {
    case "unix":
      // eslint-disable-next-line no-case-declarations
      const filename = await mktemp("tfepuds-", ".socket", true);
      return `unix://${filename}`;
    case "tcp":
      return `localhost:${await findOpenPort(minPort, maxPort)}`;
    default:
      throw new Error(`type must be "tcp" or "unix", but it was ${type}`);
  }
};

const mktemp = async (prefix = "", suffix = "", deleteOnExit = false): Promise<string> => {
  const tempdir = os.tmpdir();

  // eslint-disable-next-line no-constant-condition
  while (true) {
    const filename = path.resolve(tempdir, `${prefix ?? ""}${crypto.randomUUID()}${suffix ?? ""}`);
    const now = Date.now();
    try {
      await fs.utimes(filename, now, now);
    } catch (err: any) {
      if ("code" in err && err.code !== "ENOENT") {
        throw err;
      }

      const fh = await fs.open(filename, "a");
      await fh.close();

      if (deleteOnExit) {
        process.on("exit", () => {
          fs.rm(filename, { force: true });
        });
      }

      return filename;
    }
  }
};

const findOpenPort = async (minPort = 1024, maxPort = 65535): Promise<number> => {
  for (let i = minPort; i <= maxPort; i += 100) {
    const promises: Promise<number>[] = [];
    for (let j = 0; j < 100; j++) {
      const port = i + j;
      promises.push(checkPort(port));
    }

    let port = 0;
    try {
      port = await Promise.any(promises);
      return port;
    } catch (err) {
      continue;
    }
  }

  throw new Error(`No ports between ${minPort} and ${maxPort} were available to host the server`);
};

const checkPort = (port: number): Promise<number> => {
  return new Promise((resolve, reject) => {
    const server = createServer();
    server.unref();
    server.on("error", reject);

    server.listen({ port: port, host: "127.0.0.1" }, () => {
      server.close(() => {
        resolve(port);
      });
    });
  });
};
