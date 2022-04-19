package ChargingSpotsService;

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
    comments = "Source: charging_spots.proto")
public final class ChargingSpotsServiceGrpc {

  private ChargingSpotsServiceGrpc() {}

  public static final String SERVICE_NAME = "ChargingSpotsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ChargingSpotsService.coordinates,
      ChargingSpotsService.chargingSpots> getTrackLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackLocation",
      requestType = ChargingSpotsService.coordinates.class,
      responseType = ChargingSpotsService.chargingSpots.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ChargingSpotsService.coordinates,
      ChargingSpotsService.chargingSpots> getTrackLocationMethod() {
    io.grpc.MethodDescriptor<ChargingSpotsService.coordinates, ChargingSpotsService.chargingSpots> getTrackLocationMethod;
    if ((getTrackLocationMethod = ChargingSpotsServiceGrpc.getTrackLocationMethod) == null) {
      synchronized (ChargingSpotsServiceGrpc.class) {
        if ((getTrackLocationMethod = ChargingSpotsServiceGrpc.getTrackLocationMethod) == null) {
          ChargingSpotsServiceGrpc.getTrackLocationMethod = getTrackLocationMethod = 
              io.grpc.MethodDescriptor.<ChargingSpotsService.coordinates, ChargingSpotsService.chargingSpots>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChargingSpotsService", "TrackLocation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChargingSpotsService.coordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChargingSpotsService.chargingSpots.getDefaultInstance()))
                  .setSchemaDescriptor(new ChargingSpotsServiceMethodDescriptorSupplier("TrackLocation"))
                  .build();
          }
        }
     }
     return getTrackLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChargingSpotsService.chargingSpots,
      ChargingSpotsService.prices> getCheckPricesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckPrices",
      requestType = ChargingSpotsService.chargingSpots.class,
      responseType = ChargingSpotsService.prices.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ChargingSpotsService.chargingSpots,
      ChargingSpotsService.prices> getCheckPricesMethod() {
    io.grpc.MethodDescriptor<ChargingSpotsService.chargingSpots, ChargingSpotsService.prices> getCheckPricesMethod;
    if ((getCheckPricesMethod = ChargingSpotsServiceGrpc.getCheckPricesMethod) == null) {
      synchronized (ChargingSpotsServiceGrpc.class) {
        if ((getCheckPricesMethod = ChargingSpotsServiceGrpc.getCheckPricesMethod) == null) {
          ChargingSpotsServiceGrpc.getCheckPricesMethod = getCheckPricesMethod = 
              io.grpc.MethodDescriptor.<ChargingSpotsService.chargingSpots, ChargingSpotsService.prices>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChargingSpotsService", "CheckPrices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChargingSpotsService.chargingSpots.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChargingSpotsService.prices.getDefaultInstance()))
                  .setSchemaDescriptor(new ChargingSpotsServiceMethodDescriptorSupplier("CheckPrices"))
                  .build();
          }
        }
     }
     return getCheckPricesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChargingSpotsService.time,
      ChargingSpotsService.command> getAutomateTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AutomateTime",
      requestType = ChargingSpotsService.time.class,
      responseType = ChargingSpotsService.command.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChargingSpotsService.time,
      ChargingSpotsService.command> getAutomateTimeMethod() {
    io.grpc.MethodDescriptor<ChargingSpotsService.time, ChargingSpotsService.command> getAutomateTimeMethod;
    if ((getAutomateTimeMethod = ChargingSpotsServiceGrpc.getAutomateTimeMethod) == null) {
      synchronized (ChargingSpotsServiceGrpc.class) {
        if ((getAutomateTimeMethod = ChargingSpotsServiceGrpc.getAutomateTimeMethod) == null) {
          ChargingSpotsServiceGrpc.getAutomateTimeMethod = getAutomateTimeMethod = 
              io.grpc.MethodDescriptor.<ChargingSpotsService.time, ChargingSpotsService.command>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChargingSpotsService", "AutomateTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChargingSpotsService.time.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChargingSpotsService.command.getDefaultInstance()))
                  .setSchemaDescriptor(new ChargingSpotsServiceMethodDescriptorSupplier("AutomateTime"))
                  .build();
          }
        }
     }
     return getAutomateTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChargingSpotsServiceStub newStub(io.grpc.Channel channel) {
    return new ChargingSpotsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChargingSpotsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChargingSpotsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChargingSpotsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChargingSpotsServiceFutureStub(channel);
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static abstract class ChargingSpotsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ChargingSpotsService.coordinates> trackLocation(
        io.grpc.stub.StreamObserver<ChargingSpotsService.chargingSpots> responseObserver) {
      return asyncUnimplementedStreamingCall(getTrackLocationMethod(), responseObserver);
    }

    /**
     */
    public void checkPrices(ChargingSpotsService.chargingSpots request,
        io.grpc.stub.StreamObserver<ChargingSpotsService.prices> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckPricesMethod(), responseObserver);
    }

    /**
     */
    public void automateTime(ChargingSpotsService.time request,
        io.grpc.stub.StreamObserver<ChargingSpotsService.command> responseObserver) {
      asyncUnimplementedUnaryCall(getAutomateTimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTrackLocationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ChargingSpotsService.coordinates,
                ChargingSpotsService.chargingSpots>(
                  this, METHODID_TRACK_LOCATION)))
          .addMethod(
            getCheckPricesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ChargingSpotsService.chargingSpots,
                ChargingSpotsService.prices>(
                  this, METHODID_CHECK_PRICES)))
          .addMethod(
            getAutomateTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChargingSpotsService.time,
                ChargingSpotsService.command>(
                  this, METHODID_AUTOMATE_TIME)))
          .build();
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class ChargingSpotsServiceStub extends io.grpc.stub.AbstractStub<ChargingSpotsServiceStub> {
    private ChargingSpotsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChargingSpotsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChargingSpotsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChargingSpotsServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ChargingSpotsService.coordinates> trackLocation(
        io.grpc.stub.StreamObserver<ChargingSpotsService.chargingSpots> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTrackLocationMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void checkPrices(ChargingSpotsService.chargingSpots request,
        io.grpc.stub.StreamObserver<ChargingSpotsService.prices> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckPricesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void automateTime(ChargingSpotsService.time request,
        io.grpc.stub.StreamObserver<ChargingSpotsService.command> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAutomateTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class ChargingSpotsServiceBlockingStub extends io.grpc.stub.AbstractStub<ChargingSpotsServiceBlockingStub> {
    private ChargingSpotsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChargingSpotsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChargingSpotsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChargingSpotsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ChargingSpotsService.prices> checkPrices(
        ChargingSpotsService.chargingSpots request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckPricesMethod(), getCallOptions(), request);
    }

    /**
     */
    public ChargingSpotsService.command automateTime(ChargingSpotsService.time request) {
      return blockingUnaryCall(
          getChannel(), getAutomateTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class ChargingSpotsServiceFutureStub extends io.grpc.stub.AbstractStub<ChargingSpotsServiceFutureStub> {
    private ChargingSpotsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChargingSpotsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChargingSpotsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChargingSpotsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChargingSpotsService.command> automateTime(
        ChargingSpotsService.time request) {
      return futureUnaryCall(
          getChannel().newCall(getAutomateTimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_PRICES = 0;
  private static final int METHODID_AUTOMATE_TIME = 1;
  private static final int METHODID_TRACK_LOCATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChargingSpotsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChargingSpotsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_PRICES:
          serviceImpl.checkPrices((ChargingSpotsService.chargingSpots) request,
              (io.grpc.stub.StreamObserver<ChargingSpotsService.prices>) responseObserver);
          break;
        case METHODID_AUTOMATE_TIME:
          serviceImpl.automateTime((ChargingSpotsService.time) request,
              (io.grpc.stub.StreamObserver<ChargingSpotsService.command>) responseObserver);
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
        case METHODID_TRACK_LOCATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.trackLocation(
              (io.grpc.stub.StreamObserver<ChargingSpotsService.chargingSpots>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChargingSpotsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChargingSpotsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ChargingSpotsService.ChargingSpotsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChargingSpotsService");
    }
  }

  private static final class ChargingSpotsServiceFileDescriptorSupplier
      extends ChargingSpotsServiceBaseDescriptorSupplier {
    ChargingSpotsServiceFileDescriptorSupplier() {}
  }

  private static final class ChargingSpotsServiceMethodDescriptorSupplier
      extends ChargingSpotsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChargingSpotsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChargingSpotsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChargingSpotsServiceFileDescriptorSupplier())
              .addMethod(getTrackLocationMethod())
              .addMethod(getCheckPricesMethod())
              .addMethod(getAutomateTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
