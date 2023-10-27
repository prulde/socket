package prulde.lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void startConnection() throws IOException, UnknownHostException {
		Scanner input = new Scanner(System.in);
		int port = input.nextInt();

		clientSocket = new Socket("127.0.0.1", port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		while (true) {
			System.out.print("send message: ");
			String str = input.next();
			System.out.print("server response: ");
			String response = sendMessage(str);
			System.out.println(response);
			if (str.equals("."))
				break;
		}
		input.close();
	}

	public String sendMessage(String msg) throws IOException {
		out.println(msg);
		String resp = in.readLine();
		return resp;
	}

	// public void stopConnection() throws IOException {
	// in.close();
	// out.close();
	// clientSocket.close();
	// }
}
