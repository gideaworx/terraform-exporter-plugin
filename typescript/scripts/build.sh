#!/usr/bin/env bash

set -eo pipefail

# First, get the package root
scriptDir=$(dirname ${BASH_SOURCE[0]})
packageRoot=$(dirname ${scriptDir})

# We'll do everything else from here
pushd ${packageRoot} >/dev/null
  # Compile the typescript
  tsc

  # Because tsc makes empty .d.ts files when we have our, overwrite theirs with ours
  for srcFile in $(find src -name '*.d.ts'); do
    destFile=${srcFile/src/dist}
    cp -v ${srcFile} ${destFile}
  done
popd >/dev/null