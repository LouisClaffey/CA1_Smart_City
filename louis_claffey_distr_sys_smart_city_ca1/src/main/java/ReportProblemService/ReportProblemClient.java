package ReportProblemService;


import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceBlockingStub;
import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ReportProblemClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		// create scanner and ask for user details
		System.out.println("Enter details: ");
		Scanner sc = new Scanner(System.in);
		String request = sc.next();
		
		// creating the managed channel, to pass into our newBlockingStub method
		// building with "localhost" name and port 50051 passed in 
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		// setting the login message with user input
		loginRequest message = loginRequest.newBuilder().setRequest(request).build();
		problemType number = problemType.newBuilder().setNumber(1).build();
		
		
		ReportProblemServiceBlockingStub bstub = ReportProblemServiceGrpc.newBlockingStub(newChannel);
		
		loginResponse response = bstub.login(message);
		
		if (request.equalsIgnoreCase("smart-city-id")) {
		System.out.println(response.getResponse());
		} else {
			System.out.println("Please enter correct details.");
		}
		
		System.out.println("The problem type is: " + number);
		System.out.println("The fixes are as follows:\n ");
	
		Iterator<problemFixes> responses = bstub.reportProblem(number);
		
		while (responses.hasNext()) {
			
			problemFixes individualRespose = responses.next();
			System.out.println(individualRespose.getNumber());
		}
	
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

	}
}

