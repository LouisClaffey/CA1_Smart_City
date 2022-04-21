package TransportService;


import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import TransportService.TransportServiceGrpc.TransportServiceBlockingStub;
import TransportService.TransportServiceGrpc.TransportServiceStub;
import TransportService.transportType.Transports;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class TransportServiceClient {
	
	private static final Logger logger = Logger.getLogger(TransportServiceClient.class.getName());
	
	public static void main(String[] args) throws InterruptedException {

// 		jmDNS commented out as serviceResolved not working on Windows,
//		This code ran on Linux and worked, see report for output.

		
		/** uncomment the below block of code
		 * to test on linux, and comment out
		 * int port = 50052
		 */

		
//		ServiceInfo serviceInfo;
//		String service_type = "_grpc._tcp.local.";
//		serviceInfo = SimpleServiceDiscovery.runjmDNS(service_type);
//		int port = serviceInfo.getPort();

		
		String host = "localhost";
		int port = 50052;
		
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		// blocking stub used for server-side streaming methods
		TransportServiceBlockingStub bstub = TransportServiceGrpc.newBlockingStub(newChannel);
		
		// asynchronous stub used for bi-directional methods
		TransportServiceStub aSyncStub = TransportServiceGrpc.newStub(newChannel);
		
		try {
			
			// declaring the requested route by the client
			routeRequest route = routeRequest.newBuilder().setFrom("Clontarf").setDestination("City-Center").build();
			
			// declaring the requested transport type by the client
			transportType type = transportType.newBuilder().setTransports(Transports.DART).build();
			
			
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
		
		} catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;	
		    
		} finally {
		
		
			Thread.sleep(5000);
			
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		}
		
		
	}

}
