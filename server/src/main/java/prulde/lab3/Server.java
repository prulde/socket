package prulde.lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void start() throws IOException {
		Scanner input = new Scanner(System.in);
		int port = input.nextInt();
		input.close();

		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			if (".".equals(inputLine)) {
				System.out.print("shut down server");
				out.println("shut down server");
				break;
			}
			System.out.print("message received: ");
			System.out.println(inputLine);

			String response = changeString(inputLine);
			out.println(response);
		}
		out.println(inputLine);
	}

	String changeString(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); ++i) {
			Character c = input.charAt(i);
			if (i % 2 == 0) {
				continue;
			}

			if (c.equals('-')) {
				sb.append("(*)");
				continue;
			}

			sb.append(c);
		}

		return sb.toString();
	}

	// public void stop() throws IOException {
	// in.close();
	// out.close();
	// clientSocket.close();
	// serverSocket.close();
	// }
}
