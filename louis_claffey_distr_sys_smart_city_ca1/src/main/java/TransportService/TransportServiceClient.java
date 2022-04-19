package TransportService;


import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import TransportService.TransportServiceGrpc.TransportServiceBlockingStub;
import TransportService.TransportServiceGrpc.TransportServiceStub;
import TransportService.transportType.Transports;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class TransportServiceClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		
		// declaring the requested route by the client
		routeRequest route = routeRequest.newBuilder().setFrom("Clontarf").setDestination("City-Center").build();
		
		// declaring the requested transport type by the client
		transportType type = transportType.newBuilder().setTransports(Transports.DART).build();
		
		// blocking stub used for server-side streaming methods
		TransportServiceBlockingStub bstub = TransportServiceGrpc.newBlockingStub(newChannel);
		
		// asynchronous stub used for bi-directional methods
		TransportServiceStub aSyncStub = TransportServiceGrpc.newStub(newChannel);
		
		
		System.out.println("The requested route is: " + route);
		System.out.println("The routes are as follows:\n ");
		
		// iterate through the routes declared in server -- server side streaming
		Iterator<routes> routes = bstub.enterRoute(route);
		
		while (routes.hasNext()) {
			
			routes routeResponse = routes.next();
			System.out.println(routeResponse.getResponse());
		}
		
		System.out.println();
		System.out.println("The requested transport type is: " + Transports.DART);
		System.out.println("The times are as follows:\n ");
		
		
		// iterate through the times declared in server -- server side streaming
		Iterator<times> times = bstub.checkTimes(type);
		
		while(times.hasNext()) {
			
			times timeResponse = times.next();
			System.out.println(timeResponse.getTime());
		}
		
		// bi-directional streaming
		// handling the stream of responses sent by server
		
		StreamObserver<chatResponse> responseObserver = new StreamObserver<chatResponse>() {

			@Override
			public void onNext(chatResponse value) {
				// getting the response
				System.out.println(value.getReponse());
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println("The chat has now ended.");
				
			}
			
		};
		
		
		
		
		// declaring the stream of client requests
		StreamObserver<chatRequest> requestObserver = aSyncStub.chat(responseObserver);
			Scanner sc = new Scanner(System.in);
		try {
			
			System.out.println("Enter details of delay: ");
			String delay1 = sc.nextLine();
			requestObserver.onNext(chatRequest.newBuilder().setRequest(delay1).build());
			String delay2 = sc.nextLine();
			requestObserver.onNext(chatRequest.newBuilder().setRequest(delay2).build());
			String delay3 = sc.nextLine();
			requestObserver.onNext(chatRequest.newBuilder().setRequest(delay3).build());
			String delay4 = sc.nextLine();
			requestObserver.onNext(chatRequest.newBuilder().setRequest(delay4).build());
			String delay5 = sc.nextLine();
			requestObserver.onNext(chatRequest.newBuilder().setRequest(delay5).build());
			
			// ending the requests
			requestObserver.onCompleted();


			// Sleep for 2 seconds before sending the next one.
			Thread.sleep(2000);
			
		} catch (RuntimeException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
		Thread.sleep(5000);
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
