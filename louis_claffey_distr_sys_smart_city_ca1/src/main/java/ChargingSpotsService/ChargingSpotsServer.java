package ChargingSpotsService;

import java.io.IOException;

import ChargingSpotsService.ChargingSpotsServiceGrpc.ChargingSpotsServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChargingSpotsServer {
	
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChargingSpotsServer ourServer = new ChargingSpotsServer();
		ourServer.start();
		
	}
	
	private void start() throws IOException, InterruptedException {
		
		System.out.println("Starting gRPC server");
		
		int port = 50053;
		
		server = ServerBuilder.forPort(port).addService(new ChargingSpotsServerImpl()).build().start();
		System.out.println("Our server is running on the port: " + port);
		
		server.awaitTermination();
		
	}
	
		static class ChargingSpotsServerImpl extends ChargingSpotsServiceImplBase{
			
			// unary method 
			// one time request returns one command message 
			public void automateTime(time time, StreamObserver<command> responseObserver) {
				
				double timeOn = time.getTimeOn();
				double timeOff = time.getTimeOff();
				
				System.out.println("The time on setting begins @: " + time.getTimeOn() + "\n" +
									"The time off setting begins @: " + time.getTimeOff());
				
				command.Builder responseBuilder = command.newBuilder();
				
				if(timeOn + 1 == timeOff) {
				responseBuilder.setCommand("Charging for 1 hour.");
				} else if (timeOn + 0.3 == timeOff) {
					responseBuilder.setCommand("Charging for 30 minutes.");
				} else if (timeOn + 0.45 == timeOff) {
					responseBuilder.setCommand("Charging for 45 minutes.");
				} else {
					responseBuilder.setCommand("Time limit too long.");
				}
				
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted();
				
			}
			
			@Override
			public StreamObserver<coordinates> trackLocation(StreamObserver<chargingSpots> responseObserver){
				System.out.println("In the server, recieving stream of coordinates from client.\n");
			return new StreamObserver<coordinates>() {

				@Override
				public void onNext(coordinates value) {
					System.out.println("The corrdinates are: " + value.getLatitude() + "\n" + value.getLongitude());
					
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
					
				}

				@Override
				public void onCompleted() {
					
					
					chargingSpots.Builder responseBuilder = chargingSpots.newBuilder();
					
					 
					responseBuilder.setArea("The closest area").setStreet("The closest street").build();
					
					
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
					
				}};
			
		
			}
			
			
			public void checkPrices(chargingSpots request, StreamObserver<prices> responseObserver) {
				
				String chargingSpot = request.getArea() + "\n" + request.getStreet();
				System.out.println("The spot selected is: " + chargingSpot);
				
				prices.Builder responseBuilder = prices.newBuilder();
				
				responseBuilder.setPrice(5.00);
				responseObserver.onNext(responseBuilder.build());
				
				responseBuilder.setPrice(10.00);
				responseObserver.onNext(responseBuilder.build());
				
				responseBuilder.setPrice(15.00);
				responseObserver.onNext(responseBuilder.build());

				responseObserver.onCompleted();
			}
			

	}
		
}		
