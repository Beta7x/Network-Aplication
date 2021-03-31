package simple_tcp_2;

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
		String user_number;
		
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.print("Server says: Guess a number [1-10]." + '\n' + "Input please: ");
			user_number = input.nextLine();
			out_socket.println(user_number);
		}
		
		System.out.println("You got it!!!.");
		
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
