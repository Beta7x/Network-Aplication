package simple_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {
	
	public Receiver() throws Exception {
		
		DatagramSocket socket = new DatagramSocket(2001);
		System.out.println("Receiver is Running.");
		Scanner input = new Scanner(System.in);
		
		byte[] buffer = new byte[1500]; // Maximum Transmission Unit (MTU) = 1500
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(packet); // retreiving sender's messange
		
		String message = new String (buffer).trim();
		System.err.println("Received: " + message);
		
		InetAddress senders_address = packet.getAddress();
		int senders_port = packet.getPort();
		
		System.out.println("Enter Your Message: ");
		message = input.nextLine();
		buffer = message.getBytes();
		packet = new DatagramPacket(buffer, buffer.length, senders_address, senders_port);
		socket.send(packet);
		
		System.out.println("Sent: " + message);
	}
	
	public static void main(String[] args) {
		try {
			new Receiver();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
