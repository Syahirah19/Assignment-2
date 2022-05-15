package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import Model.Order;
import View.CashierFrame;


public class CashierApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		CashierFrame frame = new CashierFrame();
		frame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader
				(new InputStreamReader(socket.getInputStream()));
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}