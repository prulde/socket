package prulde.lab3;

import java.net.*;
import java.io.*;

class ServerMain {
	public static void main(String[] args) {
		Server server = new Server();
		try {
			server.start();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}