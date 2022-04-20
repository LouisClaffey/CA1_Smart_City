package ReportProblemService;


import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceBlockingStub;
import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ReportProblemClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		// create scanner and ask for user details
		System.out.println("Enter details: ");
		Scanner sc = new Scanner(System.in);
		String request = sc.next();
		
		// creating the managed channel, to pass into our newBlockingStub method
		// building with "localhost" name and port 50051 passed in 
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		// setting and building the login message with user input, to be sent to the server
		loginRequest message = loginRequest.newBuilder().setRequest(request).build();
		
		// setting and building our problem type number to be sent to the server
		problemType number = problemType.newBuilder().setNumber(1).build();
		
		// setting and building our logout message to be sent to the server
		logoutRequest logout = logoutRequest.newBuilder().setRequest("logout").build();
		
		// blocking stub to be used for unary and server side streaming 
		ReportProblemServiceBlockingStub bstub = ReportProblemServiceGrpc.newBlockingStub(newChannel);
		
		// asynchronous stub to be used for client side streaming
		ReportProblemServiceStub asyncStub = ReportProblemServiceGrpc.newStub(newChannel);
		
		loginResponse response = bstub.login(message);
		
		if (request.equalsIgnoreCase("smart-city-id")) {
		System.out.println(response.getResponse());
		} else {
			System.out.println("Please enter correct details.");
		}
		
		System.out.println("The problem type is: " + number);
		System.out.println("The fixes are as follows:\n ");
		
		// iterate through the messages declared in server -- server side streaming
		Iterator<problemFixes> messages = bstub.reportProblem(number);
		
		while (messages.hasNext()) {
			
			problemFixes aResponse = messages.next();
			System.out.println(aResponse.getNumber());
		}
		
		// client side streaming
		
		
		StreamObserver<problemFix> responseObserver = new StreamObserver<problemFix>() {

			@Override
			public void onNext(problemFix value) {
				// we will get the fix from our server 
				System.out.println("Final response from the server.\n" + value.getFix());
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("There was an error.");
				t.printStackTrace();
				
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Completed.");
				
			}};
			
			
			// sending the messages from the client via the gRPC library and the new stream observer
			
			
			StreamObserver<problemType> requestObserver = asyncStub.reportWarning(responseObserver);
			
			requestObserver.onNext(problemType.newBuilder().setNumber(1).build());
			requestObserver.onNext(problemType.newBuilder().setNumber(2).build());
			requestObserver.onNext(problemType.newBuilder().setNumber(3).build());
		
			
			System.out.println("client has now sent its messages.\n");
			
			requestObserver.onCompleted();
			
			// 5 seconds
			Thread.sleep(5000);
			
			// finally before shutting down, we logout. 
			
			empty logOutResponse = bstub.logOut(logout);

			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

	}
}

