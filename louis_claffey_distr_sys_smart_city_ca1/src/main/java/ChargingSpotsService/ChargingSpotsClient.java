package ChargingSpotsService;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.jmdns.ServiceInfo;

import ChargingSpotsService.ChargingSpotsServiceGrpc.ChargingSpotsServiceBlockingStub;
import ChargingSpotsService.ChargingSpotsServiceGrpc.ChargingSpotsServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ChargingSpotsClient {
	
	// to log information to server
	private static final Logger logger = Logger.getLogger(ChargingSpotsClient.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
		
// 		jmDNS commented out as serviceResolved not working on Windows,
//		This code ran on Linux and worked, see report for output

		/** uncomment the below block of code
		 * to test on linux, and comment out
		 * int port = 50053
		 */
		
//		ServiceInfo serviceInfo;
//		String service_type = "_grpc._tcp.local.";
//		serviceInfo = SimpleServiceDiscovery.runjmDNS(service_type);
//		int port = serviceInfo.getPort();
		
		
		String host = "localhost";
		int port = 50053;
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		ChargingSpotsServiceBlockingStub bstub = ChargingSpotsServiceGrpc.newBlockingStub(newChannel);
		ChargingSpotsServiceStub aSyncStub = ChargingSpotsServiceGrpc.newStub(newChannel);
		
		try {
			
			// setting client request
			time selectedTime = time.newBuilder().setTimeOn(14.00).setTimeOff(14.30).build();
			// setting client request
			chargingSpots chargingSpot = chargingSpots.newBuilder().setArea("Dublin 1").setStreet("2 St.Marks Road").build();
			
			
			// unary 
			command response = bstub.automateTime(selectedTime);
			System.out.println(response.getCommand());
			
			// server side streaming multiple prices for the requested charging spot 
			
			System.out.println("Returing prices for 30 minute, 45 minute, 1hr charge:\n ");
			
			Iterator<prices> pr = bstub.checkPrices(chargingSpot);
			
			while(pr.hasNext()) {
				
				prices responses = pr.next();
				System.out.println(responses.getPrice());
			}
			
			
			// client side streaming, setting multiple coordinates
			// returning nearest charging spot from server
			
			StreamObserver<chargingSpots> responseObserver = new StreamObserver<chargingSpots>() {
	
				@Override
				public void onNext(chargingSpots value) {
					System.out.println("Charging spot area: " + value.getArea() + "\n" +
										"Charging spot street: " + value.getStreet());
					
				}
	
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
					
				}
	
				@Override
				public void onCompleted() {
					
					
				}};
				
			
				
			StreamObserver<coordinates> requestObserver = aSyncStub.trackLocation(responseObserver);
			
			requestObserver.onNext(coordinates.newBuilder().setLatitude(53.34859858864881).setLongitude(-6.2534041626708925).build());
			requestObserver.onNext(coordinates.newBuilder().setLatitude(53.32796907830007).setLongitude(-6.220962437681668).build());
			requestObserver.onNext(coordinates.newBuilder().setLatitude(53.34645656743808).setLongitude(-6.293086235791194).build());
		
			requestObserver.onCompleted();
		
		} catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;	
		    
		} finally {
		
		
			Thread.sleep(5000);
			
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		}
	}

}
