package io.gideaworx.terraformexporterplugin.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: plugin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExportPluginGrpc {

  private ExportPluginGrpc() {}

  public static final String SERVICE_NAME = "io.gideaworx.tfexportplugin.ExportPlugin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.PluginRequest,
      io.gideaworx.terraformexporterplugin.grpc.ExportResponse> getExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Export",
      requestType = io.gideaworx.terraformexporterplugin.grpc.PluginRequest.class,
      responseType = io.gideaworx.terraformexporterplugin.grpc.ExportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.PluginRequest,
      io.gideaworx.terraformexporterplugin.grpc.ExportResponse> getExportMethod() {
    io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.PluginRequest, io.gideaworx.terraformexporterplugin.grpc.ExportResponse> getExportMethod;
    if ((getExportMethod = ExportPluginGrpc.getExportMethod) == null) {
      synchronized (ExportPluginGrpc.class) {
        if ((getExportMethod = ExportPluginGrpc.getExportMethod) == null) {
          ExportPluginGrpc.getExportMethod = getExportMethod =
              io.grpc.MethodDescriptor.<io.gideaworx.terraformexporterplugin.grpc.PluginRequest, io.gideaworx.terraformexporterplugin.grpc.ExportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Export"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.PluginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.ExportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExportPluginMethodDescriptorSupplier("Export"))
              .build();
        }
      }
    }
    return getExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.SingleString,
      io.gideaworx.terraformexporterplugin.grpc.SingleString> getHelpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Help",
      requestType = io.gideaworx.terraformexporterplugin.grpc.SingleString.class,
      responseType = io.gideaworx.terraformexporterplugin.grpc.SingleString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.SingleString,
      io.gideaworx.terraformexporterplugin.grpc.SingleString> getHelpMethod() {
    io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.SingleString, io.gideaworx.terraformexporterplugin.grpc.SingleString> getHelpMethod;
    if ((getHelpMethod = ExportPluginGrpc.getHelpMethod) == null) {
      synchronized (ExportPluginGrpc.class) {
        if ((getHelpMethod = ExportPluginGrpc.getHelpMethod) == null) {
          ExportPluginGrpc.getHelpMethod = getHelpMethod =
              io.grpc.MethodDescriptor.<io.gideaworx.terraformexporterplugin.grpc.SingleString, io.gideaworx.terraformexporterplugin.grpc.SingleString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Help"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.SingleString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.SingleString.getDefaultInstance()))
              .setSchemaDescriptor(new ExportPluginMethodDescriptorSupplier("Help"))
              .build();
        }
      }
    }
    return getHelpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty,
      io.gideaworx.terraformexporterplugin.grpc.PluginInfo> getInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Info",
      requestType = io.gideaworx.terraformexporterplugin.grpc.Empty.class,
      responseType = io.gideaworx.terraformexporterplugin.grpc.PluginInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty,
      io.gideaworx.terraformexporterplugin.grpc.PluginInfo> getInfoMethod() {
    io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty, io.gideaworx.terraformexporterplugin.grpc.PluginInfo> getInfoMethod;
    if ((getInfoMethod = ExportPluginGrpc.getInfoMethod) == null) {
      synchronized (ExportPluginGrpc.class) {
        if ((getInfoMethod = ExportPluginGrpc.getInfoMethod) == null) {
          ExportPluginGrpc.getInfoMethod = getInfoMethod =
              io.grpc.MethodDescriptor.<io.gideaworx.terraformexporterplugin.grpc.Empty, io.gideaworx.terraformexporterplugin.grpc.PluginInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Info"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.PluginInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ExportPluginMethodDescriptorSupplier("Info"))
              .build();
        }
      }
    }
    return getInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExportPluginStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportPluginStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExportPluginStub>() {
        @java.lang.Override
        public ExportPluginStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExportPluginStub(channel, callOptions);
        }
      };
    return ExportPluginStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExportPluginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportPluginBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExportPluginBlockingStub>() {
        @java.lang.Override
        public ExportPluginBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExportPluginBlockingStub(channel, callOptions);
        }
      };
    return ExportPluginBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExportPluginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportPluginFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExportPluginFutureStub>() {
        @java.lang.Override
        public ExportPluginFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExportPluginFutureStub(channel, callOptions);
        }
      };
    return ExportPluginFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ExportPluginImplBase implements io.grpc.BindableService {

    /**
     */
    public void export(io.gideaworx.terraformexporterplugin.grpc.PluginRequest request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.ExportResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportMethod(), responseObserver);
    }

    /**
     */
    public void help(io.gideaworx.terraformexporterplugin.grpc.SingleString request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.SingleString> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHelpMethod(), responseObserver);
    }

    /**
     */
    public void info(io.gideaworx.terraformexporterplugin.grpc.Empty request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.PluginInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.gideaworx.terraformexporterplugin.grpc.PluginRequest,
                io.gideaworx.terraformexporterplugin.grpc.ExportResponse>(
                  this, METHODID_EXPORT)))
          .addMethod(
            getHelpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.gideaworx.terraformexporterplugin.grpc.SingleString,
                io.gideaworx.terraformexporterplugin.grpc.SingleString>(
                  this, METHODID_HELP)))
          .addMethod(
            getInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.gideaworx.terraformexporterplugin.grpc.Empty,
                io.gideaworx.terraformexporterplugin.grpc.PluginInfo>(
                  this, METHODID_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class ExportPluginStub extends io.grpc.stub.AbstractAsyncStub<ExportPluginStub> {
    private ExportPluginStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportPluginStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportPluginStub(channel, callOptions);
    }

    /**
     */
    public void export(io.gideaworx.terraformexporterplugin.grpc.PluginRequest request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.ExportResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void help(io.gideaworx.terraformexporterplugin.grpc.SingleString request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.SingleString> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHelpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void info(io.gideaworx.terraformexporterplugin.grpc.Empty request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.PluginInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ExportPluginBlockingStub extends io.grpc.stub.AbstractBlockingStub<ExportPluginBlockingStub> {
    private ExportPluginBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportPluginBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportPluginBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.gideaworx.terraformexporterplugin.grpc.ExportResponse export(io.gideaworx.terraformexporterplugin.grpc.PluginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.gideaworx.terraformexporterplugin.grpc.SingleString help(io.gideaworx.terraformexporterplugin.grpc.SingleString request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHelpMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.gideaworx.terraformexporterplugin.grpc.PluginInfo info(io.gideaworx.terraformexporterplugin.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExportPluginFutureStub extends io.grpc.stub.AbstractFutureStub<ExportPluginFutureStub> {
    private ExportPluginFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportPluginFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportPluginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.gideaworx.terraformexporterplugin.grpc.ExportResponse> export(
        io.gideaworx.terraformexporterplugin.grpc.PluginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.gideaworx.terraformexporterplugin.grpc.SingleString> help(
        io.gideaworx.terraformexporterplugin.grpc.SingleString request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHelpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.gideaworx.terraformexporterplugin.grpc.PluginInfo> info(
        io.gideaworx.terraformexporterplugin.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT = 0;
  private static final int METHODID_HELP = 1;
  private static final int METHODID_INFO = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExportPluginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExportPluginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXPORT:
          serviceImpl.export((io.gideaworx.terraformexporterplugin.grpc.PluginRequest) request,
              (io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.ExportResponse>) responseObserver);
          break;
        case METHODID_HELP:
          serviceImpl.help((io.gideaworx.terraformexporterplugin.grpc.SingleString) request,
              (io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.SingleString>) responseObserver);
          break;
        case METHODID_INFO:
          serviceImpl.info((io.gideaworx.terraformexporterplugin.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.PluginInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExportPluginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExportPluginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExportPlugin");
    }
  }

  private static final class ExportPluginFileDescriptorSupplier
      extends ExportPluginBaseDescriptorSupplier {
    ExportPluginFileDescriptorSupplier() {}
  }

  private static final class ExportPluginMethodDescriptorSupplier
      extends ExportPluginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExportPluginMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExportPluginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExportPluginFileDescriptorSupplier())
              .addMethod(getExportMethod())
              .addMethod(getHelpMethod())
              .addMethod(getInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
