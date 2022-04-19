package ChargingSpotsService;

import java.util.concurrent.TimeUnit;

import ChargingSpotsService.ChargingSpotsServiceGrpc.ChargingSpotsServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChargingSpotsClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
		
		time selectedTime = time.newBuilder().setTimeOn(14.00).setTimeOff(14.30).build();
		
		
		ChargingSpotsServiceBlockingStub bstub = ChargingSpotsServiceGrpc.newBlockingStub(newChannel);
		
		command response = bstub.automateTime(selectedTime);
		System.out.println(response.getCommand());
		
		Thread.sleep(5000);
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
