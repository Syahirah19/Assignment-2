package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Controller.OrderProcess;
import Model.Order;

public class ServerApp {

	public static void main(String[] args) {

		System.out.println("Starting HT-POSServerApp");

		try {

			int portNo = 4227;
			int portNo2 = 4220;

			ServerSocket serverSocket = new ServerSocket(portNo);
			ServerSocket serverSocket2 = new ServerSocket(portNo2);

			while (true) {

				Socket clientSocket = serverSocket.accept();
				Socket clientSocket2 = serverSocket2.accept();

				ObjectInputStream ois = 
						new ObjectInputStream(clientSocket.getInputStream());

				Order order = (Order)ois.readObject();
				System.out.println("\nProcessing Order Number: " 
						+ order.getOrderNumber());

				OrderProcess orderprocessing = new OrderProcess();
				order = orderprocessing.calculation(order); 

				//RecordingProcessedOrder controller =
					//	new RecordingProcessedOrder();
				
				//controller.insertOrder(order);
				
				


				ObjectOutputStream oos =
						new ObjectOutputStream(clientSocket.getOutputStream());
				oos.writeObject(order);

				System.out.println("\nSending Processed Order: " 
						+ order.getOrderNumber() 
						+ ", to Cashier (Client-Side Application)");

				ObjectInputStream ois2 = 
						new ObjectInputStream(clientSocket.getInputStream());

				Order processedOrder = (Order)ois2.readObject();

				System.out.println("\nReceived Order Number: " 
						+ processedOrder.getOrderNumber());

				ObjectOutputStream oos2 =
						new ObjectOutputStream(clientSocket2.getOutputStream());
				oos2.writeObject(processedOrder);

				System.out.println("\nSending Processed Order: " 
						+ order.getOrderNumber() 
						+ ", to Barista (Client-Side Application)");

				ois.close();
				oos.close();
				ois2.close();
				oos2.close();

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

}