package com.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ConnectionServer {

	int port;
	ServerSocket checkServer = null;
	String line;
	BufferedReader inputStream = null;
	DataOutputStream outputStream = null;
	Socket clientSocket = null;

	ConnectionServer(int port) {
		this.port = port;
	}

	public void connection() {
		try {
			checkServer = new ServerSocket(port);
			System.out.println("Simple Server Start . . . . .");

			/*
			 * String s = "1 , 2 , 3"; String[] data = s.split(",");
			 * System.out.println("Name = "+data[0].trim()); //Pankaj
			 * System.out.println("Address = "+data[1].trim()); //New York
			 * System.out.println("Address = "+data[2].trim()); //USA
			 * System.out.println(Integer.parseInt(data[0].trim()) + 5);
			 */

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public void inputOutputStream() {
		try {
			clientSocket = checkServer.accept();
			inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public void closeConnection() {
		try {
			outputStream.close();
			inputStream.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
