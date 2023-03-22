#!/usr/bin/env bash

fatal() {
  echo "$@" 1>&2
  exit 1
}

pythons=("python3" "python")
PYTHON=""
for p in ${pythons[@]}; do
  if which $p; then
    PYTHON=$p
    break
  fi
done

if [ -z "$PYTHON" ]; then
  fatal 'Neither "python3" nor "python" is on the $PATH'
fi

$PYTHON -m grpc_tools.protoc -I.. --python_out=generated --pyi_out=generated --grpc_python_out=generated ../plugin.proto