// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('@grpc/grpc-js');
var plugin_pb = require('./plugin_pb.js');

function serialize_plugin_CommandInfo(arg) {
  if (!(arg instanceof plugin_pb.CommandInfo)) {
    throw new Error('Expected argument of type plugin.CommandInfo');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_CommandInfo(buffer_arg) {
  return plugin_pb.CommandInfo.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_plugin_Empty(arg) {
  if (!(arg instanceof plugin_pb.Empty)) {
    throw new Error('Expected argument of type plugin.Empty');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_Empty(buffer_arg) {
  return plugin_pb.Empty.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_plugin_ExportRequest(arg) {
  if (!(arg instanceof plugin_pb.ExportRequest)) {
    throw new Error('Expected argument of type plugin.ExportRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_ExportRequest(buffer_arg) {
  return plugin_pb.ExportRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_plugin_ExportResponse(arg) {
  if (!(arg instanceof plugin_pb.ExportResponse)) {
    throw new Error('Expected argument of type plugin.ExportResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_ExportResponse(buffer_arg) {
  return plugin_pb.ExportResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_plugin_PluginInfo(arg) {
  if (!(arg instanceof plugin_pb.PluginInfo)) {
    throw new Error('Expected argument of type plugin.PluginInfo');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_PluginInfo(buffer_arg) {
  return plugin_pb.PluginInfo.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_plugin_PluginRequest(arg) {
  if (!(arg instanceof plugin_pb.PluginRequest)) {
    throw new Error('Expected argument of type plugin.PluginRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_PluginRequest(buffer_arg) {
  return plugin_pb.PluginRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_plugin_SingleString(arg) {
  if (!(arg instanceof plugin_pb.SingleString)) {
    throw new Error('Expected argument of type plugin.SingleString');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_plugin_SingleString(buffer_arg) {
  return plugin_pb.SingleString.deserializeBinary(new Uint8Array(buffer_arg));
}


var ExportCommandService = exports.ExportCommandService = {
  export: {
    path: '/plugin.ExportCommand/Export',
    requestStream: false,
    responseStream: false,
    requestType: plugin_pb.ExportRequest,
    responseType: plugin_pb.ExportResponse,
    requestSerialize: serialize_plugin_ExportRequest,
    requestDeserialize: deserialize_plugin_ExportRequest,
    responseSerialize: serialize_plugin_ExportResponse,
    responseDeserialize: deserialize_plugin_ExportResponse,
  },
  info: {
    path: '/plugin.ExportCommand/Info',
    requestStream: false,
    responseStream: false,
    requestType: plugin_pb.Empty,
    responseType: plugin_pb.CommandInfo,
    requestSerialize: serialize_plugin_Empty,
    requestDeserialize: deserialize_plugin_Empty,
    responseSerialize: serialize_plugin_CommandInfo,
    responseDeserialize: deserialize_plugin_CommandInfo,
  },
  help: {
    path: '/plugin.ExportCommand/Help',
    requestStream: false,
    responseStream: false,
    requestType: plugin_pb.Empty,
    responseType: plugin_pb.SingleString,
    requestSerialize: serialize_plugin_Empty,
    requestDeserialize: deserialize_plugin_Empty,
    responseSerialize: serialize_plugin_SingleString,
    responseDeserialize: deserialize_plugin_SingleString,
  },
};

exports.ExportCommandClient = grpc.makeGenericClientConstructor(ExportCommandService);
var ExportPluginService = exports.ExportPluginService = {
  export: {
    path: '/plugin.ExportPlugin/Export',
    requestStream: false,
    responseStream: false,
    requestType: plugin_pb.PluginRequest,
    responseType: plugin_pb.ExportResponse,
    requestSerialize: serialize_plugin_PluginRequest,
    requestDeserialize: deserialize_plugin_PluginRequest,
    responseSerialize: serialize_plugin_ExportResponse,
    responseDeserialize: deserialize_plugin_ExportResponse,
  },
  help: {
    path: '/plugin.ExportPlugin/Help',
    requestStream: false,
    responseStream: false,
    requestType: plugin_pb.SingleString,
    responseType: plugin_pb.SingleString,
    requestSerialize: serialize_plugin_SingleString,
    requestDeserialize: deserialize_plugin_SingleString,
    responseSerialize: serialize_plugin_SingleString,
    responseDeserialize: deserialize_plugin_SingleString,
  },
  info: {
    path: '/plugin.ExportPlugin/Info',
    requestStream: false,
    responseStream: false,
    requestType: plugin_pb.Empty,
    responseType: plugin_pb.PluginInfo,
    requestSerialize: serialize_plugin_Empty,
    requestDeserialize: deserialize_plugin_Empty,
    responseSerialize: serialize_plugin_PluginInfo,
    responseDeserialize: deserialize_plugin_PluginInfo,
  },
};

exports.ExportPluginClient = grpc.makeGenericClientConstructor(ExportPluginService);
