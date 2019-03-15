package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionClient {
	public int port;
	public String hostName;
	public Socket client = null;
	public BufferedReader inputStream = null;
	public DataOutputStream outputStream = null;
	public BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public String user_input = null;
	public String output = null;

	ConnectionClient(String hostName, int port) {
		this.hostName = hostName;
		this.port = port;
	}

	public void connectionClient() {
		try {
			client = new Socket(hostName, port);
			inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			outputStream = new DataOutputStream(client.getOutputStream());
		} catch (UnknownHostException e) {
			System.out.println("Unknown Host : " + e);
		} catch (IOException e0) {
			e0.printStackTrace();
		}

	}


	public void closeConnection() {
		try {
			inputStream.close();
			outputStream.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
