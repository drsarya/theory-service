package generated.rating.library;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: FormulaRating.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FormulaRatingServiceGrpc {

  private FormulaRatingServiceGrpc() {}

  public static final String SERVICE_NAME = "generated.rating.library.FormulaRatingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.rating.library.FormulaRatingRequest,
      generated.rating.library.FormulaRatingResponse> getGetFormulaRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFormulaRating",
      requestType = generated.rating.library.FormulaRatingRequest.class,
      responseType = generated.rating.library.FormulaRatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.rating.library.FormulaRatingRequest,
      generated.rating.library.FormulaRatingResponse> getGetFormulaRatingMethod() {
    io.grpc.MethodDescriptor<generated.rating.library.FormulaRatingRequest, generated.rating.library.FormulaRatingResponse> getGetFormulaRatingMethod;
    if ((getGetFormulaRatingMethod = FormulaRatingServiceGrpc.getGetFormulaRatingMethod) == null) {
      synchronized (FormulaRatingServiceGrpc.class) {
        if ((getGetFormulaRatingMethod = FormulaRatingServiceGrpc.getGetFormulaRatingMethod) == null) {
          FormulaRatingServiceGrpc.getGetFormulaRatingMethod = getGetFormulaRatingMethod =
              io.grpc.MethodDescriptor.<generated.rating.library.FormulaRatingRequest, generated.rating.library.FormulaRatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getFormulaRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.rating.library.FormulaRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.rating.library.FormulaRatingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FormulaRatingServiceMethodDescriptorSupplier("getFormulaRating"))
              .build();
        }
      }
    }
    return getGetFormulaRatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.rating.library.FormulaRatingRequest,
      generated.rating.library.FormulaRatingResponse> getAddRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addRating",
      requestType = generated.rating.library.FormulaRatingRequest.class,
      responseType = generated.rating.library.FormulaRatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.rating.library.FormulaRatingRequest,
      generated.rating.library.FormulaRatingResponse> getAddRatingMethod() {
    io.grpc.MethodDescriptor<generated.rating.library.FormulaRatingRequest, generated.rating.library.FormulaRatingResponse> getAddRatingMethod;
    if ((getAddRatingMethod = FormulaRatingServiceGrpc.getAddRatingMethod) == null) {
      synchronized (FormulaRatingServiceGrpc.class) {
        if ((getAddRatingMethod = FormulaRatingServiceGrpc.getAddRatingMethod) == null) {
          FormulaRatingServiceGrpc.getAddRatingMethod = getAddRatingMethod =
              io.grpc.MethodDescriptor.<generated.rating.library.FormulaRatingRequest, generated.rating.library.FormulaRatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.rating.library.FormulaRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.rating.library.FormulaRatingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FormulaRatingServiceMethodDescriptorSupplier("addRating"))
              .build();
        }
      }
    }
    return getAddRatingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FormulaRatingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormulaRatingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormulaRatingServiceStub>() {
        @java.lang.Override
        public FormulaRatingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormulaRatingServiceStub(channel, callOptions);
        }
      };
    return FormulaRatingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FormulaRatingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormulaRatingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormulaRatingServiceBlockingStub>() {
        @java.lang.Override
        public FormulaRatingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormulaRatingServiceBlockingStub(channel, callOptions);
        }
      };
    return FormulaRatingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FormulaRatingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormulaRatingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormulaRatingServiceFutureStub>() {
        @java.lang.Override
        public FormulaRatingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormulaRatingServiceFutureStub(channel, callOptions);
        }
      };
    return FormulaRatingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FormulaRatingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFormulaRating(generated.rating.library.FormulaRatingRequest request,
        io.grpc.stub.StreamObserver<generated.rating.library.FormulaRatingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFormulaRatingMethod(), responseObserver);
    }

    /**
     */
    public void addRating(generated.rating.library.FormulaRatingRequest request,
        io.grpc.stub.StreamObserver<generated.rating.library.FormulaRatingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRatingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFormulaRatingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.rating.library.FormulaRatingRequest,
                generated.rating.library.FormulaRatingResponse>(
                  this, METHODID_GET_FORMULA_RATING)))
          .addMethod(
            getAddRatingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.rating.library.FormulaRatingRequest,
                generated.rating.library.FormulaRatingResponse>(
                  this, METHODID_ADD_RATING)))
          .build();
    }
  }

  /**
   */
  public static final class FormulaRatingServiceStub extends io.grpc.stub.AbstractAsyncStub<FormulaRatingServiceStub> {
    private FormulaRatingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormulaRatingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormulaRatingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFormulaRating(generated.rating.library.FormulaRatingRequest request,
        io.grpc.stub.StreamObserver<generated.rating.library.FormulaRatingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFormulaRatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addRating(generated.rating.library.FormulaRatingRequest request,
        io.grpc.stub.StreamObserver<generated.rating.library.FormulaRatingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRatingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FormulaRatingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FormulaRatingServiceBlockingStub> {
    private FormulaRatingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormulaRatingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormulaRatingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.rating.library.FormulaRatingResponse getFormulaRating(generated.rating.library.FormulaRatingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFormulaRatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.rating.library.FormulaRatingResponse addRating(generated.rating.library.FormulaRatingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRatingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FormulaRatingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FormulaRatingServiceFutureStub> {
    private FormulaRatingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormulaRatingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormulaRatingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.rating.library.FormulaRatingResponse> getFormulaRating(
        generated.rating.library.FormulaRatingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFormulaRatingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.rating.library.FormulaRatingResponse> addRating(
        generated.rating.library.FormulaRatingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRatingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FORMULA_RATING = 0;
  private static final int METHODID_ADD_RATING = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FormulaRatingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FormulaRatingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FORMULA_RATING:
          serviceImpl.getFormulaRating((generated.rating.library.FormulaRatingRequest) request,
              (io.grpc.stub.StreamObserver<generated.rating.library.FormulaRatingResponse>) responseObserver);
          break;
        case METHODID_ADD_RATING:
          serviceImpl.addRating((generated.rating.library.FormulaRatingRequest) request,
              (io.grpc.stub.StreamObserver<generated.rating.library.FormulaRatingResponse>) responseObserver);
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

  private static abstract class FormulaRatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FormulaRatingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.rating.library.FormulaRating.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FormulaRatingService");
    }
  }

  private static final class FormulaRatingServiceFileDescriptorSupplier
      extends FormulaRatingServiceBaseDescriptorSupplier {
    FormulaRatingServiceFileDescriptorSupplier() {}
  }

  private static final class FormulaRatingServiceMethodDescriptorSupplier
      extends FormulaRatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FormulaRatingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FormulaRatingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FormulaRatingServiceFileDescriptorSupplier())
              .addMethod(getGetFormulaRatingMethod())
              .addMethod(getAddRatingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
