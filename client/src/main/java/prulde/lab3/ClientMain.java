package prulde.lab3;

import java.net.*;
import java.io.*;

class ClientMain {
	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.startConnection();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}