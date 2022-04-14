package ReportProblemService;

import java.io.IOException;

import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ReportProblemServer {
	
private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ReportProblemServer ourServer = new ReportProblemServer();
		
		ourServer.start();
		
		

	}

	private void start() throws IOException, InterruptedException {
	
		System.out.println("Starting gRPC server");
		
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new ReportProblemServerImpl()).build().start();
		System.out.println("Our server is running on the port: " + port);
		
		server.awaitTermination();
		
	}
	
	static class ReportProblemServerImpl extends ReportProblemServiceImplBase{
		
		
		
		// unary request - response
		@Override
		public void login(loginRequest request, StreamObserver<loginResponse> responseObserver) {
			
			// ask the client for login details
			
			String loginDetails = request.getRequest();
			System.out.println("Our first request is: " + loginDetails );
			
			// response
			
			loginResponse.Builder responseBuilder = loginResponse.newBuilder();
			
			// adding logic to check login details are correct
			// tested on bloom  -- implemented on client
			
//			if(loginDetails.equalsIgnoreCase("smart-city-ID")) {
//			
//				responseBuilder.setResponse("You have successfully logged in.");
//			
//			} else {
//				
//				responseBuilder.setResponse("Please enter correct details.");
//			}
			
			responseBuilder.setResponse("You have successfully logged in.");
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
		}
		
		// server side streaming
		// server will send multiple messages to the client, in this case
		// request is a problem represented by a number set in the client (1) which will receive multiple
		// numbers (1,2,3) here in the server. These represent different fixes 
		// for example, a problem (1) might mean a problem with a buildings electrical infrastructure
		// and (1,2,3) represent the types of fixes applied 

		@Override
		public void reportProblem(problemType request, StreamObserver<problemFixes> responseObserver  ) {
			// find out content of message from the client
			
			int numberInput = request.getNumber();
			System.out.println("Our problem type request is: " + numberInput );
			
			//response
			
			problemFixes.Builder responseBuilder = problemFixes.newBuilder();
			
			// first returned number fix
			
			responseBuilder.setNumber(1);
			
			responseObserver.onNext(responseBuilder.build());
			// second returned number fix
			responseBuilder.setNumber(2);
			
			responseObserver.onNext(responseBuilder.build());
			// third returned number fix
			responseBuilder.setNumber(3);
			
			responseObserver.onNext(responseBuilder.build());

			responseObserver.onCompleted();
			
		}
		
		// method for client streaming
		// a stream of messages will be sent from the client, with one string 'fix' sent from the server
		// for these messages we need to implement a stream observer
		// which will be passed back to the gPRC library
		
		public StreamObserver<problemType> reportWarning(StreamObserver<problemFix> responseObserver){
			System.out.println("Message to show that we are inside the server, streaming messages from client will follow.\n");
			return new StreamObserver<problemType>() {

				@Override
				public void onNext(problemType value) {
				System.out.println("Message from client: " + value.getNumber());
					
				}

				@Override
				public void onError(Throwable t) {
				
					
				}

				@Override
				public void onCompleted() {
					
					problemFix.Builder responseBuilder = problemFix.newBuilder();
					
					// the fix sent from the server
					responseBuilder.setFix("This will solve the problem.");
					
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();				
					
				}};
		}
		
		// logOut method
		// receives logout message from client, returns nothing (empty)
		
		@Override
		public void logOut(logoutRequest request, StreamObserver<empty> responseObserver) {
			
			// ask the client for login details
			
			String logout = request.getRequest();
			System.out.println("You have logged out: " + logout );
			
			// response
			
			empty.Builder responseBuilder = empty.newBuilder();
			
			
			responseBuilder.build();
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
		}
		
	}// main method
	
	
	


}// class 
