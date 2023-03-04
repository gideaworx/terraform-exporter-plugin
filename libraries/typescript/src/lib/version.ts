import { Version as pbVersion } from "../generated/plugin_pb";
import { Version as gVersion } from "../generated/plugin/Version";

export type Version = pbVersion.AsObject;

export type Versionish = string | Version;

export const DefaultVersion: Version = {
  major: 0,
  minor: 0,
  patch: 0,
  pre: "dev",
  buildmetadata: "",
};

export const asVersion = (vs?: Versionish): Version => {
  if (!vs) {
    return DefaultVersion;
  }

  if (isVersion(vs)) {
    return vs;
  }

  return fromString(vs);
};

const isVersion = (vs: any): vs is Version => {
  return "major" in vs;
};

export const fromString = (str?: string): Version => {
  if (!str) {
    return DefaultVersion;
  }

  const parts = str.split("-", 2);
  const mmp = parts[0].split(".");

  const v: Version = {
    major: parseInt(mmp[0]) || 0,
    minor: parseInt(mmp[1] ?? "0") || 0,
    patch: parseInt(mmp[2] ?? "0") || 0,
    pre: "",
    buildmetadata: "",
  };

  if (parts.length > 1) {
    const prebuild = parts[1].split(".", 2);
    v.pre = prebuild[0];
    v.buildmetadata = prebuild[1] ?? "";
  }

  return v;
};

export const toString = (v?: Version): string => {
  if (!v) {
    return toString(DefaultVersion);
  }

  let str = `${v.major ?? 0}.${v.minor ?? 0}.${v.patch ?? 0}`;
  if (v.pre.length > 0) {
    str = `${str}-${v.pre}`;
  }

  if (v.buildmetadata.length > 0) {
    str = `${str}.${v.buildmetadata}`;
  }

  return str;
};

export const asGRPC = (v?: Version): gVersion | null => {
  if (!v) {
    return asGRPC(DefaultVersion);
  }

  return {
    Major: v.major.toString(),
    Minor: v.minor.toString(),
    Patch: v.patch.toString(),
    Pre: v.pre,
    BuildMetadata: v.buildmetadata,
  };
};
