package io.gideaworx.terraformexporterplugin.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: plugin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExportCommandGrpc {

  private ExportCommandGrpc() {}

  public static final String SERVICE_NAME = "io.gideaworx.tfexportplugin.ExportCommand";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.ExportRequest,
      io.gideaworx.terraformexporterplugin.grpc.ExportResponse> getExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Export",
      requestType = io.gideaworx.terraformexporterplugin.grpc.ExportRequest.class,
      responseType = io.gideaworx.terraformexporterplugin.grpc.ExportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.ExportRequest,
      io.gideaworx.terraformexporterplugin.grpc.ExportResponse> getExportMethod() {
    io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.ExportRequest, io.gideaworx.terraformexporterplugin.grpc.ExportResponse> getExportMethod;
    if ((getExportMethod = ExportCommandGrpc.getExportMethod) == null) {
      synchronized (ExportCommandGrpc.class) {
        if ((getExportMethod = ExportCommandGrpc.getExportMethod) == null) {
          ExportCommandGrpc.getExportMethod = getExportMethod =
              io.grpc.MethodDescriptor.<io.gideaworx.terraformexporterplugin.grpc.ExportRequest, io.gideaworx.terraformexporterplugin.grpc.ExportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Export"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.ExportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExportCommandMethodDescriptorSupplier("Export"))
              .build();
        }
      }
    }
    return getExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty,
      io.gideaworx.terraformexporterplugin.grpc.CommandInfo> getInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Info",
      requestType = io.gideaworx.terraformexporterplugin.grpc.Empty.class,
      responseType = io.gideaworx.terraformexporterplugin.grpc.CommandInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty,
      io.gideaworx.terraformexporterplugin.grpc.CommandInfo> getInfoMethod() {
    io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty, io.gideaworx.terraformexporterplugin.grpc.CommandInfo> getInfoMethod;
    if ((getInfoMethod = ExportCommandGrpc.getInfoMethod) == null) {
      synchronized (ExportCommandGrpc.class) {
        if ((getInfoMethod = ExportCommandGrpc.getInfoMethod) == null) {
          ExportCommandGrpc.getInfoMethod = getInfoMethod =
              io.grpc.MethodDescriptor.<io.gideaworx.terraformexporterplugin.grpc.Empty, io.gideaworx.terraformexporterplugin.grpc.CommandInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Info"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.CommandInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ExportCommandMethodDescriptorSupplier("Info"))
              .build();
        }
      }
    }
    return getInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty,
      io.gideaworx.terraformexporterplugin.grpc.SingleString> getHelpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Help",
      requestType = io.gideaworx.terraformexporterplugin.grpc.Empty.class,
      responseType = io.gideaworx.terraformexporterplugin.grpc.SingleString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty,
      io.gideaworx.terraformexporterplugin.grpc.SingleString> getHelpMethod() {
    io.grpc.MethodDescriptor<io.gideaworx.terraformexporterplugin.grpc.Empty, io.gideaworx.terraformexporterplugin.grpc.SingleString> getHelpMethod;
    if ((getHelpMethod = ExportCommandGrpc.getHelpMethod) == null) {
      synchronized (ExportCommandGrpc.class) {
        if ((getHelpMethod = ExportCommandGrpc.getHelpMethod) == null) {
          ExportCommandGrpc.getHelpMethod = getHelpMethod =
              io.grpc.MethodDescriptor.<io.gideaworx.terraformexporterplugin.grpc.Empty, io.gideaworx.terraformexporterplugin.grpc.SingleString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Help"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.gideaworx.terraformexporterplugin.grpc.SingleString.getDefaultInstance()))
              .setSchemaDescriptor(new ExportCommandMethodDescriptorSupplier("Help"))
              .build();
        }
      }
    }
    return getHelpMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExportCommandStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportCommandStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExportCommandStub>() {
        @java.lang.Override
        public ExportCommandStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExportCommandStub(channel, callOptions);
        }
      };
    return ExportCommandStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExportCommandBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportCommandBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExportCommandBlockingStub>() {
        @java.lang.Override
        public ExportCommandBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExportCommandBlockingStub(channel, callOptions);
        }
      };
    return ExportCommandBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExportCommandFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportCommandFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExportCommandFutureStub>() {
        @java.lang.Override
        public ExportCommandFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExportCommandFutureStub(channel, callOptions);
        }
      };
    return ExportCommandFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ExportCommandImplBase implements io.grpc.BindableService {

    /**
     */
    public void export(io.gideaworx.terraformexporterplugin.grpc.ExportRequest request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.ExportResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportMethod(), responseObserver);
    }

    /**
     */
    public void info(io.gideaworx.terraformexporterplugin.grpc.Empty request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.CommandInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInfoMethod(), responseObserver);
    }

    /**
     */
    public void help(io.gideaworx.terraformexporterplugin.grpc.Empty request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.SingleString> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHelpMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.gideaworx.terraformexporterplugin.grpc.ExportRequest,
                io.gideaworx.terraformexporterplugin.grpc.ExportResponse>(
                  this, METHODID_EXPORT)))
          .addMethod(
            getInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.gideaworx.terraformexporterplugin.grpc.Empty,
                io.gideaworx.terraformexporterplugin.grpc.CommandInfo>(
                  this, METHODID_INFO)))
          .addMethod(
            getHelpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.gideaworx.terraformexporterplugin.grpc.Empty,
                io.gideaworx.terraformexporterplugin.grpc.SingleString>(
                  this, METHODID_HELP)))
          .build();
    }
  }

  /**
   */
  public static final class ExportCommandStub extends io.grpc.stub.AbstractAsyncStub<ExportCommandStub> {
    private ExportCommandStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportCommandStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportCommandStub(channel, callOptions);
    }

    /**
     */
    public void export(io.gideaworx.terraformexporterplugin.grpc.ExportRequest request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.ExportResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void info(io.gideaworx.terraformexporterplugin.grpc.Empty request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.CommandInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void help(io.gideaworx.terraformexporterplugin.grpc.Empty request,
        io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.SingleString> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHelpMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ExportCommandBlockingStub extends io.grpc.stub.AbstractBlockingStub<ExportCommandBlockingStub> {
    private ExportCommandBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportCommandBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportCommandBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.gideaworx.terraformexporterplugin.grpc.ExportResponse export(io.gideaworx.terraformexporterplugin.grpc.ExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.gideaworx.terraformexporterplugin.grpc.CommandInfo info(io.gideaworx.terraformexporterplugin.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.gideaworx.terraformexporterplugin.grpc.SingleString help(io.gideaworx.terraformexporterplugin.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHelpMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExportCommandFutureStub extends io.grpc.stub.AbstractFutureStub<ExportCommandFutureStub> {
    private ExportCommandFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportCommandFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportCommandFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.gideaworx.terraformexporterplugin.grpc.ExportResponse> export(
        io.gideaworx.terraformexporterplugin.grpc.ExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.gideaworx.terraformexporterplugin.grpc.CommandInfo> info(
        io.gideaworx.terraformexporterplugin.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.gideaworx.terraformexporterplugin.grpc.SingleString> help(
        io.gideaworx.terraformexporterplugin.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHelpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT = 0;
  private static final int METHODID_INFO = 1;
  private static final int METHODID_HELP = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExportCommandImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExportCommandImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXPORT:
          serviceImpl.export((io.gideaworx.terraformexporterplugin.grpc.ExportRequest) request,
              (io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.ExportResponse>) responseObserver);
          break;
        case METHODID_INFO:
          serviceImpl.info((io.gideaworx.terraformexporterplugin.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.CommandInfo>) responseObserver);
          break;
        case METHODID_HELP:
          serviceImpl.help((io.gideaworx.terraformexporterplugin.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<io.gideaworx.terraformexporterplugin.grpc.SingleString>) responseObserver);
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

  private static abstract class ExportCommandBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExportCommandBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExportCommand");
    }
  }

  private static final class ExportCommandFileDescriptorSupplier
      extends ExportCommandBaseDescriptorSupplier {
    ExportCommandFileDescriptorSupplier() {}
  }

  private static final class ExportCommandMethodDescriptorSupplier
      extends ExportCommandBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExportCommandMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExportCommandGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExportCommandFileDescriptorSupplier())
              .addMethod(getExportMethod())
              .addMethod(getInfoMethod())
              .addMethod(getHelpMethod())
              .build();
        }
      }
    }
    return result;
  }
}
