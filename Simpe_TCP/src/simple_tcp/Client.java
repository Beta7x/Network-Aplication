package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public Client() throws Exception {
		
		Socket socket = new Socket("localhost",2021);
		System.out.println("Successful connection to the Server.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner input = new Scanner(System.in);
		
		String message = in_socket.readLine();
		System.out.println("Server says " + message);
		System.out.print("Says something to the server: ");
		message = input.nextLine(); // user is prompted to type a message for the server
		out_socket.println(message);
		
		socket.close();
		System.out.println("Socket Closed.");
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
