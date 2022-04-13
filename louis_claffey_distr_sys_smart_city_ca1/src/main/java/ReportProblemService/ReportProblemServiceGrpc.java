package ReportProblemService;

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
    comments = "Source: report_problem.proto")
public final class ReportProblemServiceGrpc {

  private ReportProblemServiceGrpc() {}

  public static final String SERVICE_NAME = "ReportProblemService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ReportProblemService.loginRequest,
      ReportProblemService.loginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = ReportProblemService.loginRequest.class,
      responseType = ReportProblemService.loginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ReportProblemService.loginRequest,
      ReportProblemService.loginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<ReportProblemService.loginRequest, ReportProblemService.loginResponse> getLoginMethod;
    if ((getLoginMethod = ReportProblemServiceGrpc.getLoginMethod) == null) {
      synchronized (ReportProblemServiceGrpc.class) {
        if ((getLoginMethod = ReportProblemServiceGrpc.getLoginMethod) == null) {
          ReportProblemServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<ReportProblemService.loginRequest, ReportProblemService.loginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReportProblemService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.loginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.loginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReportProblemServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReportProblemService.problemType,
      ReportProblemService.problemFixes> getReportProblemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportProblem",
      requestType = ReportProblemService.problemType.class,
      responseType = ReportProblemService.problemFixes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ReportProblemService.problemType,
      ReportProblemService.problemFixes> getReportProblemMethod() {
    io.grpc.MethodDescriptor<ReportProblemService.problemType, ReportProblemService.problemFixes> getReportProblemMethod;
    if ((getReportProblemMethod = ReportProblemServiceGrpc.getReportProblemMethod) == null) {
      synchronized (ReportProblemServiceGrpc.class) {
        if ((getReportProblemMethod = ReportProblemServiceGrpc.getReportProblemMethod) == null) {
          ReportProblemServiceGrpc.getReportProblemMethod = getReportProblemMethod = 
              io.grpc.MethodDescriptor.<ReportProblemService.problemType, ReportProblemService.problemFixes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ReportProblemService", "ReportProblem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.problemType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.problemFixes.getDefaultInstance()))
                  .setSchemaDescriptor(new ReportProblemServiceMethodDescriptorSupplier("ReportProblem"))
                  .build();
          }
        }
     }
     return getReportProblemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReportProblemService.problemType,
      ReportProblemService.problemFix> getReportWarningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportWarning",
      requestType = ReportProblemService.problemType.class,
      responseType = ReportProblemService.problemFix.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ReportProblemService.problemType,
      ReportProblemService.problemFix> getReportWarningMethod() {
    io.grpc.MethodDescriptor<ReportProblemService.problemType, ReportProblemService.problemFix> getReportWarningMethod;
    if ((getReportWarningMethod = ReportProblemServiceGrpc.getReportWarningMethod) == null) {
      synchronized (ReportProblemServiceGrpc.class) {
        if ((getReportWarningMethod = ReportProblemServiceGrpc.getReportWarningMethod) == null) {
          ReportProblemServiceGrpc.getReportWarningMethod = getReportWarningMethod = 
              io.grpc.MethodDescriptor.<ReportProblemService.problemType, ReportProblemService.problemFix>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ReportProblemService", "ReportWarning"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.problemType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.problemFix.getDefaultInstance()))
                  .setSchemaDescriptor(new ReportProblemServiceMethodDescriptorSupplier("ReportWarning"))
                  .build();
          }
        }
     }
     return getReportWarningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReportProblemService.logoutRequest,
      ReportProblemService.empty> getLogOutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogOut",
      requestType = ReportProblemService.logoutRequest.class,
      responseType = ReportProblemService.empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ReportProblemService.logoutRequest,
      ReportProblemService.empty> getLogOutMethod() {
    io.grpc.MethodDescriptor<ReportProblemService.logoutRequest, ReportProblemService.empty> getLogOutMethod;
    if ((getLogOutMethod = ReportProblemServiceGrpc.getLogOutMethod) == null) {
      synchronized (ReportProblemServiceGrpc.class) {
        if ((getLogOutMethod = ReportProblemServiceGrpc.getLogOutMethod) == null) {
          ReportProblemServiceGrpc.getLogOutMethod = getLogOutMethod = 
              io.grpc.MethodDescriptor.<ReportProblemService.logoutRequest, ReportProblemService.empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReportProblemService", "LogOut"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.logoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportProblemService.empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ReportProblemServiceMethodDescriptorSupplier("LogOut"))
                  .build();
          }
        }
     }
     return getLogOutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReportProblemServiceStub newStub(io.grpc.Channel channel) {
    return new ReportProblemServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReportProblemServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReportProblemServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReportProblemServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReportProblemServiceFutureStub(channel);
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static abstract class ReportProblemServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary
     * log into device
     * </pre>
     */
    public void login(ReportProblemService.loginRequest request,
        io.grpc.stub.StreamObserver<ReportProblemService.loginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * problem registered, sent from client to server
     * server returns multiple fixes
     * </pre>
     */
    public void reportProblem(ReportProblemService.problemType request,
        io.grpc.stub.StreamObserver<ReportProblemService.problemFixes> responseObserver) {
      asyncUnimplementedUnaryCall(getReportProblemMethod(), responseObserver);
    }

    /**
     * <pre>
     * client streaming rpc
     * multiple warnings of potential future problems
     * returns one fix message
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ReportProblemService.problemType> reportWarning(
        io.grpc.stub.StreamObserver<ReportProblemService.problemFix> responseObserver) {
      return asyncUnimplementedStreamingCall(getReportWarningMethod(), responseObserver);
    }

    /**
     * <pre>
     * log out of device
     * no message sent back
     * </pre>
     */
    public void logOut(ReportProblemService.logoutRequest request,
        io.grpc.stub.StreamObserver<ReportProblemService.empty> responseObserver) {
      asyncUnimplementedUnaryCall(getLogOutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ReportProblemService.loginRequest,
                ReportProblemService.loginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getReportProblemMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ReportProblemService.problemType,
                ReportProblemService.problemFixes>(
                  this, METHODID_REPORT_PROBLEM)))
          .addMethod(
            getReportWarningMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ReportProblemService.problemType,
                ReportProblemService.problemFix>(
                  this, METHODID_REPORT_WARNING)))
          .addMethod(
            getLogOutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ReportProblemService.logoutRequest,
                ReportProblemService.empty>(
                  this, METHODID_LOG_OUT)))
          .build();
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class ReportProblemServiceStub extends io.grpc.stub.AbstractStub<ReportProblemServiceStub> {
    private ReportProblemServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReportProblemServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportProblemServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReportProblemServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * log into device
     * </pre>
     */
    public void login(ReportProblemService.loginRequest request,
        io.grpc.stub.StreamObserver<ReportProblemService.loginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * problem registered, sent from client to server
     * server returns multiple fixes
     * </pre>
     */
    public void reportProblem(ReportProblemService.problemType request,
        io.grpc.stub.StreamObserver<ReportProblemService.problemFixes> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReportProblemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client streaming rpc
     * multiple warnings of potential future problems
     * returns one fix message
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ReportProblemService.problemType> reportWarning(
        io.grpc.stub.StreamObserver<ReportProblemService.problemFix> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getReportWarningMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * log out of device
     * no message sent back
     * </pre>
     */
    public void logOut(ReportProblemService.logoutRequest request,
        io.grpc.stub.StreamObserver<ReportProblemService.empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogOutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class ReportProblemServiceBlockingStub extends io.grpc.stub.AbstractStub<ReportProblemServiceBlockingStub> {
    private ReportProblemServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReportProblemServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportProblemServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReportProblemServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * log into device
     * </pre>
     */
    public ReportProblemService.loginResponse login(ReportProblemService.loginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server streaming
     * problem registered, sent from client to server
     * server returns multiple fixes
     * </pre>
     */
    public java.util.Iterator<ReportProblemService.problemFixes> reportProblem(
        ReportProblemService.problemType request) {
      return blockingServerStreamingCall(
          getChannel(), getReportProblemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * log out of device
     * no message sent back
     * </pre>
     */
    public ReportProblemService.empty logOut(ReportProblemService.logoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogOutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * rpc stands for remote procedure call
   * </pre>
   */
  public static final class ReportProblemServiceFutureStub extends io.grpc.stub.AbstractStub<ReportProblemServiceFutureStub> {
    private ReportProblemServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReportProblemServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportProblemServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReportProblemServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * log into device
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ReportProblemService.loginResponse> login(
        ReportProblemService.loginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * log out of device
     * no message sent back
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ReportProblemService.empty> logOut(
        ReportProblemService.logoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogOutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_REPORT_PROBLEM = 1;
  private static final int METHODID_LOG_OUT = 2;
  private static final int METHODID_REPORT_WARNING = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReportProblemServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReportProblemServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((ReportProblemService.loginRequest) request,
              (io.grpc.stub.StreamObserver<ReportProblemService.loginResponse>) responseObserver);
          break;
        case METHODID_REPORT_PROBLEM:
          serviceImpl.reportProblem((ReportProblemService.problemType) request,
              (io.grpc.stub.StreamObserver<ReportProblemService.problemFixes>) responseObserver);
          break;
        case METHODID_LOG_OUT:
          serviceImpl.logOut((ReportProblemService.logoutRequest) request,
              (io.grpc.stub.StreamObserver<ReportProblemService.empty>) responseObserver);
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
        case METHODID_REPORT_WARNING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.reportWarning(
              (io.grpc.stub.StreamObserver<ReportProblemService.problemFix>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReportProblemServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReportProblemServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ReportProblemService.ReportProblemServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportProblemService");
    }
  }

  private static final class ReportProblemServiceFileDescriptorSupplier
      extends ReportProblemServiceBaseDescriptorSupplier {
    ReportProblemServiceFileDescriptorSupplier() {}
  }

  private static final class ReportProblemServiceMethodDescriptorSupplier
      extends ReportProblemServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReportProblemServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReportProblemServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReportProblemServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getReportProblemMethod())
              .addMethod(getReportWarningMethod())
              .addMethod(getLogOutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
