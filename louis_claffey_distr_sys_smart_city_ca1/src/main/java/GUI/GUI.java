package GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ChargingSpotsService.ChargingSpotsServiceGrpc;
import ChargingSpotsService.command;
import ChargingSpotsService.time;
import ChargingSpotsService.ChargingSpotsServiceGrpc.ChargingSpotsServiceBlockingStub;
import ReportProblemService.ReportProblemServiceGrpc;
import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceBlockingStub;
import ReportProblemService.ReportProblemServiceGrpc.ReportProblemServiceStub;
import ReportProblemService.loginRequest;
import ReportProblemService.loginResponse;
import ReportProblemService.problemFix;
import ReportProblemService.problemFixes;
import ReportProblemService.problemType;
import TransportService.TransportServiceGrpc;
import TransportService.TransportServiceGrpc.TransportServiceBlockingStub;
import TransportService.transportType.Transports;
import TransportService.routeRequest;
import TransportService.routes;
import TransportService.times;
import TransportService.transportType;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GUI implements ActionListener{

	
	private JTextField entry1, reply1;
	private JTextField entry1b, reply1c;
	private JTextField entry2a, entry2b, entry2c;
	private JTextField entry3a, entry3b,  reply3;
	private JTextField[] replies1b = new JTextField[3];
	private JTextField[] entries1c = new JTextField[3];
	private JTextField[] replies2 = new JTextField[3];
	private JTextField[] replies2b = new JTextField[3];


	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("S1: Enter Login")	;
		// enter 'smart-city-login' to work
		
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Login");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService1bJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		
		JLabel label = new JLabel("S1: Enter Number")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1b = new JTextField("",10);
		panel.add(entry1b);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Get Fixes");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		replies1b[0] = new JTextField("", 5);
		replies1b[0] .setEditable(false);
		panel.add(replies1b[0] );
		
		replies1b[1] = new JTextField("", 5);
		replies1b[1] .setEditable(false);
		panel.add(replies1b[1] );
		
		replies1b[2] = new JTextField("", 5);
		replies1b[2] .setEditable(false);
		panel.add(replies1b[2] );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService1cJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("S1: Enter Numbers")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entries1c[0] = new JTextField("",5);
		panel.add(entries1c[0]);
		entries1c[1] = new JTextField("",5);
		panel.add(entries1c[1]);
		entries1c[2] = new JTextField("",5);
		panel.add(entries1c[2]);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Get Fix");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1c = new JTextField("", 20);
		reply1c .setEditable(false);
		panel.add(reply1c );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		

		JLabel label = new JLabel("Enter From")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2a = new JTextField("",10);
		panel.add(entry2a);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JLabel label2 = new JLabel("Enter Destination")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2b = new JTextField("",10);
		panel.add(entry2b);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Find Routes");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		replies2[0] = new JTextField("", 30);
		replies2[0].setEditable(false);
		panel.add(replies2[0]);
		
		replies2[1] = new JTextField("", 30);
		replies2[1].setEditable(false);
		panel.add(replies2[1]);
		
		replies2[2] = new JTextField("", 30);
		replies2[2].setEditable(false);
		panel.add(replies2[2]);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService2aJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		

		JLabel label = new JLabel("DART / BUS / LUAS")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2c = new JTextField("",10);
		panel.add(entry2c);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		

		JButton button = new JButton("Get Times");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		replies2b[0] = new JTextField("", 30);
		replies2b[0].setEditable(false);
		panel.add(replies2b[0]);
		
		replies2b[1] = new JTextField("", 30);
		replies2b[1].setEditable(false);
		panel.add(replies2b[1]);
		
		replies2b[2] = new JTextField("", 30);
		replies2b[2].setEditable(false);
		panel.add(replies2b[2]);

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter Time On")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3a = new JTextField("",10);
		panel.add(entry3a);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JLabel label2 = new JLabel("Enter Time Off")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3b = new JTextField("",10);
		panel.add(entry3b);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Automate");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;

	}


	public static void main(String[] args) {

		GUI gui = new GUI();

		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService1bJPanel() );
		panel.add( getService1cJPanel() );
		panel.add( getService2JPanel() );
		panel.add( getService2aJPanel() );
		panel.add( getService3JPanel() );


		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Login")) {
			System.out.println("Enter Login Details to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			ReportProblemServiceBlockingStub bstub = ReportProblemServiceGrpc.newBlockingStub(channel);

			//preparing message to send
			loginRequest message = ReportProblemService.loginRequest.newBuilder().setRequest(entry1.getText()).build();

			//retreving reply from service
			loginResponse response = bstub.login(message);

			reply1.setText(String.valueOf(response));
		
		} else if (label.equals("Get Fixes")) {
			
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			ReportProblemServiceBlockingStub bstub = ReportProblemServiceGrpc.newBlockingStub(channel);

			problemType number = problemType.newBuilder().setNumber(Integer.parseInt(entry1b.getText())).build();
			
			
			Iterator<problemFixes> messages = bstub.reportProblem(number);
			
			ArrayList<problemFixes> fixesArray = new ArrayList<>();
			
			while (messages.hasNext()) {
				
				for (int i=0; i<replies1b.length; i++) {
					fixesArray.add(messages.next());
					replies1b[i].setText(String.valueOf(fixesArray.get(i)));
					
				}
			}
					
		
		} else if (label.equals("Get Fix")) {
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			ReportProblemServiceStub asyncStub = ReportProblemServiceGrpc.newStub(channel);
			
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
			
			StreamObserver<problemType> requestObserver = asyncStub.reportWarning(responseObserver);
			
			ArrayList<problemType> pt = new ArrayList<>();
			
			pt.add(problemType.newBuilder().setNumber(1).build());
			pt.add(problemType.newBuilder().setNumber(2).build());
			pt.add(problemType.newBuilder().setNumber(3).build());
			
			requestObserver.onNext(pt.get(0));
			requestObserver.onNext(pt.get(1));
			requestObserver.onNext(pt.get(2));
			
			for (int i=0; i<entries1c.length; i++) {
				entries1c[i].setText(String.valueOf(pt.get(i)));
			}
			
			problemFix.Builder responseBuilder = problemFix.newBuilder();
			
			// the fix sent from the server
			responseBuilder.setFix("This will solve the problem.");
			
			reply1c.setText(String.valueOf(responseBuilder));
			
			
		
		} else if (label.equals("Find Routes")) {
			System.out.println("Enter Route to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			TransportServiceBlockingStub bstub = TransportServiceGrpc.newBlockingStub(channel);

			//preparing message to send
			routeRequest route = routeRequest.newBuilder().setFrom(entry2a.getText()).setDestination(entry2b.getText()).build();

			//retreving reply from service
			Iterator<routes> routes = bstub.enterRoute(route);
			
			ArrayList<routes> routesArray = new ArrayList<>();
			
			while (routes.hasNext()) {
				
		
				for(int i=0; i<replies2.length; i++) {
				
					routesArray.add(routes.next());
					replies2[i].setText(String.valueOf(routesArray.get(i)));
				
				}
			}

			
			
		} else if (label.equals("Get Times")) {

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			TransportServiceBlockingStub bstub = TransportServiceGrpc.newBlockingStub(channel);

			//preparing message to send
			transportType type = transportType.newBuilder().setTransports(Transports.valueOf(entry2c.getText().toUpperCase())).build();

			//retrieving reply from service
			Iterator<times> times = bstub.checkTimes(type);
			
			ArrayList<times> timesArray = new ArrayList<>();
			
			while (times.hasNext()) {
				
		
				for(int i=0; i<replies2b.length; i++) {
				
					timesArray.add(times.next());
					replies2b[i].setText(String.valueOf(timesArray.get(i)));
				
				}
			}
			
		
		} else if (label.equals("Automate")) {
			System.out.println("Automate to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			ChargingSpotsServiceBlockingStub bstub = ChargingSpotsServiceGrpc.newBlockingStub(channel);

			//preparing message to send
			time selectedTime = time.newBuilder().setTimeOn(Double.parseDouble(entry3a.getText())).setTimeOff(Double.parseDouble(entry3b.getText())).build();

			//retreving reply from service
			command response = bstub.automateTime(selectedTime);

			reply3.setText(String.valueOf(response));
		
		}else{
			
		}

	}

}
