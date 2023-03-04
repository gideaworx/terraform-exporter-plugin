#!/usr/bin/env bash

packageDir=$(dirname ${BASH_SOURCE[0]})/..
repoDir=${packageDir}/..

JS_PLUGIN=${packageDir}/node_modules/.bin/protoc-gen-js
TS_PLUGIN=${packageDir}/node_modules/.bin/protoc-gen-ts
GRPC_PLUGIN=${packageDir}/node_modules/.bin/grpc_tools_node_protoc_plugin

OUT_DIR=${packageDir}/src/generated
mkdir -p ${OUT_DIR}

protoc \
    --js_out=import_style=commonjs,binary:${OUT_DIR} \
    --grpc_out=grpc_js:${OUT_DIR} \
    --plugin=protoc-gen-grpc=${GRPC_PLUGIN} \
    -I ${repoDir} \
    ${repoDir}/*.proto

# Generate TypeScript code (d.ts)
protoc \
    --plugin=protoc-gen-ts=${TS_PLUGIN} \
    --ts_out=grpc_js:${OUT_DIR} \
    -I ${repoDir} \
    ${repoDir}/*.proto

yarn proto-loader-gen-types --longs=String --enums=String --defaults --oneofs --grpcLib=@grpc/grpc-js --outDir=${OUT_DIR} ${repoDir}/*.proto