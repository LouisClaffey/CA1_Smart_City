package TransportService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * rpc stands for remote procedure call
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: transport.proto")
public final class TransportServiceGrpc {

  private TransportServiceGrpc() {}

  public static final String SERVICE_NAME = "TransportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<TransportService.routeRequest,
      TransportService.routes> getEnterRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnterRoute",
      requestType = TransportService.routeRequest.class,
      responseType = TransportService.routes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<TransportService.routeRequest,
      TransportService.routes> getEnterRouteMethod() {
    io.grpc.MethodDescriptor<TransportService.routeRequest, TransportService.routes> getEnterRouteMethod;
    if ((getEnterRouteMethod = TransportServiceGrpc.getEnterRouteMethod) == null) {
      synchronized (TransportServiceGrpc.class) {
        if ((getEnterRouteMethod = TransportServiceGrpc.getEnterRouteMethod) == null) {
          TransportServiceGrpc.getEnterRouteMethod = getEnterRouteMethod = 
              io.grpc.MethodDescriptor.<TransportService.routeRequest, TransportService.routes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TransportService", "EnterRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TransportService.routeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TransportService.routes.getDefaultInstance()))
                  .setSchemaDescriptor(new TransportServiceMethodDescriptorSupplier("EnterRoute"))
                  .build();
          }
        }
     }
     return getEnterRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TransportService.transportType,
      TransportService.times> getCheckTimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckTimes",
      requestType = TransportService.transportType.class,
      responseType = TransportService.times.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<TransportService.transportType,
      TransportService.times> getCheckTimesMethod() {
    io.grpc.MethodDescriptor<TransportService.transportType, TransportService.times> getCheckTimesMethod;
    if ((getCheckTimesMethod = TransportServiceGrpc.getCheckTimesMethod) == null) {
      synchronized (TransportServiceGrpc.class) {
        if ((getCheckTimesMethod = TransportServiceGrpc.getCheckTimesMethod) == null) {
          TransportServiceGrpc.getCheckTimesMethod = getCheckTimesMethod = 
              io.grpc.MethodDescriptor.<TransportService.transportType, TransportService.times>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TransportService", "CheckTimes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TransportService.transportType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TransportService.times.getDefaultInstance()))
                  .setSchemaDescriptor(new TransportServiceMethodDescriptorSupplier("CheckTimes"))
                  .build();
          }
        }
     }
     return getCheckTimesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TransportService.chatRequest,
      TransportService.chatResponse> getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Chat",
      requestType = TransportService.chatRequest.class,
      responseType = TransportService.chatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<TransportService.chatRequest,
      TransportService.chatResponse> getChatMethod() {
    io.grpc.MethodDescriptor<TransportService.chatRequest, TransportService.chatResponse> getChatMethod;
    if ((getChatMethod = TransportServiceGrpc.getChatMethod) == null) {
      synchronized (TransportServiceGrpc.class) {
        if ((getChatMethod = TransportServiceGrpc.getChatMethod) == null) {
          TransportServiceGrpc.getChatMethod = getChatMethod = 
              io.grpc.MethodDescriptor.<TransportService.chatRequest, TransportService.chatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TransportService", "Chat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TransportService.chatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TransportService.chatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransportServiceMethodDescriptorSupplier("Chat"))
                  .build();
          }
        }
     }
     return getChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransportServiceStub newStub(io.grpc.Channel channel) {
    return new TransportServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransportServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransportServiceFutureStub(channel);
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static abstract class TransportServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * server side streaming
     * </pre>
     */
    public void enterRoute(TransportService.routeRequest request,
        io.grpc.stub.StreamObserver<TransportService.routes> responseObserver) {
      asyncUnimplementedUnaryCall(getEnterRouteMethod(), responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * client send transport type request
     * multiple times returned
     * </pre>
     */
    public void checkTimes(TransportService.transportType request,
        io.grpc.stub.StreamObserver<TransportService.times> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckTimesMethod(), responseObserver);
    }

    /**
     * <pre>
     * bi-direction streaming
     * client can send multiple messages and receive multiple
     * messages back from server
     * chat service
     * </pre>
     */
    public io.grpc.stub.StreamObserver<TransportService.chatRequest> chat(
        io.grpc.stub.StreamObserver<TransportService.chatResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnterRouteMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                TransportService.routeRequest,
                TransportService.routes>(
                  this, METHODID_ENTER_ROUTE)))
          .addMethod(
            getCheckTimesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                TransportService.transportType,
                TransportService.times>(
                  this, METHODID_CHECK_TIMES)))
          .addMethod(
            getChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                TransportService.chatRequest,
                TransportService.chatResponse>(
                  this, METHODID_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class TransportServiceStub extends io.grpc.stub.AbstractStub<TransportServiceStub> {
    private TransportServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransportServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransportServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * server side streaming
     * </pre>
     */
    public void enterRoute(TransportService.routeRequest request,
        io.grpc.stub.StreamObserver<TransportService.routes> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getEnterRouteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * client send transport type request
     * multiple times returned
     * </pre>
     */
    public void checkTimes(TransportService.transportType request,
        io.grpc.stub.StreamObserver<TransportService.times> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckTimesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * bi-direction streaming
     * client can send multiple messages and receive multiple
     * messages back from server
     * chat service
     * </pre>
     */
    public io.grpc.stub.StreamObserver<TransportService.chatRequest> chat(
        io.grpc.stub.StreamObserver<TransportService.chatResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class TransportServiceBlockingStub extends io.grpc.stub.AbstractStub<TransportServiceBlockingStub> {
    private TransportServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransportServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransportServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server side streaming
     * </pre>
     */
    public java.util.Iterator<TransportService.routes> enterRoute(
        TransportService.routeRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getEnterRouteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server streaming
     * client send transport type request
     * multiple times returned
     * </pre>
     */
    public java.util.Iterator<TransportService.times> checkTimes(
        TransportService.transportType request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckTimesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class TransportServiceFutureStub extends io.grpc.stub.AbstractStub<TransportServiceFutureStub> {
    private TransportServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransportServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransportServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ENTER_ROUTE = 0;
  private static final int METHODID_CHECK_TIMES = 1;
  private static final int METHODID_CHAT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENTER_ROUTE:
          serviceImpl.enterRoute((TransportService.routeRequest) request,
              (io.grpc.stub.StreamObserver<TransportService.routes>) responseObserver);
          break;
        case METHODID_CHECK_TIMES:
          serviceImpl.checkTimes((TransportService.transportType) request,
              (io.grpc.stub.StreamObserver<TransportService.times>) responseObserver);
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
        case METHODID_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chat(
              (io.grpc.stub.StreamObserver<TransportService.chatResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TransportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return TransportService.TransportServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransportService");
    }
  }

  private static final class TransportServiceFileDescriptorSupplier
      extends TransportServiceBaseDescriptorSupplier {
    TransportServiceFileDescriptorSupplier() {}
  }

  private static final class TransportServiceMethodDescriptorSupplier
      extends TransportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransportServiceFileDescriptorSupplier())
              .addMethod(getEnterRouteMethod())
              .addMethod(getCheckTimesMethod())
              .addMethod(getChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
