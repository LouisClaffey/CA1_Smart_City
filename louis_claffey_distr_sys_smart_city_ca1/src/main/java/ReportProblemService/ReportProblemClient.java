package ReportProblemService;


import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceBlockingStub;
import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ReportProblemClient {
	
	private static final Logger logger = Logger.getLogger(ReportProblemClient.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
		
		
// 		jmDNS commented out as serviceResolved not working on Windows,
//		This code ran on Linux and worked, see report for output.

		/** uncomment the below block of code
		 * to test on linux, and comment out
		 * int port = 50051
		 */
		
//		ServiceInfo serviceInfo;
//		String service_type = "_grpc._tcp.local.";
//		serviceInfo = SimpleServiceDiscovery.runjmDNS(service_type);
//		int port = serviceInfo.getPort();
		
		
		String host = "localhost";
		int port = 50051;
		
		// creating the managed channel, to pass into our newBlockingStub method
		// building with "localhost" as host and port 50051 passed in 
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();	

		// blocking stub to be used for unary and server side streaming 
		ReportProblemServiceBlockingStub bstub = ReportProblemServiceGrpc.newBlockingStub(newChannel);
		
		// asynchronous stub to be used for client side streaming
		ReportProblemServiceStub asyncStub = ReportProblemServiceGrpc.newStub(newChannel);
		
		
		try {

				
				// create scanner and ask for user details
				System.out.println("Enter details: ");
				Scanner sc = new Scanner(System.in);
				String request = sc.next();
					
				
				// setting and building the login message with user input, to be sent to the server
				loginRequest message = loginRequest.newBuilder().setRequest(request).build();
				
				// setting and building our problem type number to be sent to the server
				problemType number = problemType.newBuilder().setNumber(1).build();
				
				// setting and building our logout message to be sent to the server
				logoutRequest logout = logoutRequest.newBuilder().setRequest("logout").build();
				
				
				loginResponse response = bstub.login(message);
			
			if (request.equalsIgnoreCase("smart-city-id")) { 
				
				System.out.println(response.getResponse());
				
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
					
					// finally before shutting down, we logout. 
					
					empty logOutResponse = bstub.logOut(logout);
			} else {
				System.out.println("Please enter correct details.");
				return;
			}
			
				
		} catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;	
		    
		} finally {
		
			Thread.sleep(5000);
			
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		}
	}

}