package TransportService;

import java.io.IOException;
import java.util.*;

import ChargingSpotsService.SimpleServiceRegistration;
import TransportService.TransportServiceGrpc.TransportServiceImplBase;
import TransportService.TransportServiceServer;
import TransportService.transportType.Transports;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class TransportServiceServer {
	
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		TransportServiceServer ourServer = new TransportServiceServer();
		
		ourServer.start();
		
		
	}
	
	private void start() throws IOException, InterruptedException {
		
		System.out.println("Starting gRPC server");
		
		int port = 50052;
		String service_type = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		server = ServerBuilder.forPort(port).addService(new TransportServiceServerImpl()).build().start();
		System.out.println("Our server is running on the port: " + port);
		
		server.awaitTermination();
		
	}
	

	// method designed to simulate the randomized returned routes and services
	// This example will only handle one example route of Clontarf - City Center
	public static String showRoute(routeRequest request) {
		
		String services[] =  {"DART ", "BUS ", "LUAS "};
		String route = request.getFrom() + " - " + request.getDestination();
		Random rnd = new Random();
		
		int randomNum = rnd.nextInt(3);
		
		if(request.getFrom().equalsIgnoreCase("clontarf")) {
			// exclude transport type which does not
			// service this area
			randomNum = rnd.nextInt(2);
		}
		
		
		if(randomNum == 0) {
			return "The " + services[0] + "route is: " + route;
		} else if(randomNum == 1) {
			return "The " + services[1] + "route is: " + route;
		} else {
			return "The " + services[2] + "route is: " + route;
		}
		
	} 
	
	static class TransportServiceServerImpl extends TransportServiceImplBase{
		
		// server-side streaming
		// request from client of a route, server sends multiple route options
		
		@Override
		public void enterRoute(routeRequest request, StreamObserver<routes> responseObserver  ) {
			
			

			// find out content of message from the client
			
			String requestedRoute = request.getFrom() + " " + request.getDestination();
			System.out.println("Our requested route is: " + requestedRoute );
			
			//response
			
			routes.Builder responseBuilder = routes.newBuilder();
			
			// first returned route 
			
			responseBuilder.setResponse(showRoute(request));
			
			responseObserver.onNext(responseBuilder.build());
			// second returned route
			responseBuilder.setResponse(showRoute(request));
			
			responseObserver.onNext(responseBuilder.build());
			// third returned route
			responseBuilder.setResponse(showRoute(request));
			
			responseObserver.onNext(responseBuilder.build());

			responseObserver.onCompleted();
			
		}
		
		// server-side streaming 
		// client sends transport type and wishes to receive multiple times for this transport
		// time based on current time
		
		@Override
		public void checkTimes(transportType type, StreamObserver<times> responseObserver  ) {
			
			Calendar now = Calendar.getInstance();
			
			now.add(Calendar.MINUTE, 10);
			Date time1 = now.getTime();
			now.add(Calendar.MINUTE, 10);
			Date time2 = now.getTime();
			now.add(Calendar.MINUTE, 15);
			Date time3 = now.getTime();

			// find out content of message from the client
			
			Transports requestedType = type.getTransports();
			System.out.println("Our requested transport type is: " + requestedType );
			
			//response
			
			times.Builder responseBuilder = times.newBuilder();
			
			// first returned route 
			
			
			responseBuilder.setTime(requestedType + " " +  time1.toString());
	
			
			responseObserver.onNext(responseBuilder.build());
			// second returned route
			
			responseBuilder.setTime(requestedType + " " + time2.toString());
		
			
			responseObserver.onNext(responseBuilder.build());
			// third returned route
			
			responseBuilder.setTime(requestedType + " " + time3.toString());
		
			
			responseObserver.onNext(responseBuilder.build());

			responseObserver.onCompleted();
			
		}
		
		
		// bi-directional streaming
		// Handles receiving multiple messages from the client and sends multiple responses.
		// In this case, client reports delays in public transport and receives verification of logged report.
		
		@Override
		public StreamObserver<chatRequest> chat(StreamObserver<chatResponse> responseObserver){
			
			return new StreamObserver<chatRequest>() {

				@Override
				public void onNext(chatRequest chat) {
					System.out.println("Receiving the message: " + chat.getRequest());
					chatResponse response = chatResponse.newBuilder().setReponse("Delay has been logged. Enter next message: ").build();
					responseObserver.onNext(response);
					
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
					
				}

				@Override
				public void onCompleted() {
					System.out.println("Chat completed.");
					responseObserver.onCompleted();
					
				}
				
				
			};
		}
		
	}
}