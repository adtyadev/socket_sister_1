package com.server;

import java.io.IOException;

public class AdditionOperation extends ConnectionServer {

	AdditionOperation(int port) {
		super(port);	
	}
	

	public void receiveClient() {
		try {
			line = inputStream.readLine();
			System.out.println("We Recived : " + line);

			String[] data = line.split(";");
			Double hasilJumlah = this.count(data);
			outputStream.writeBytes(Double.toString(hasilJumlah));
			/*
			 * if (line.compareTo("Greetings") == 0) {
			 * outputStream.writeBytes(" . . . . and Solutions");
			 * 
			 * } else { outputStream.writeBytes("Sorry, you don't speak my protocol"); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public double count(String[] data) {
		double hasilJumlah = 0.0;
		for (String i : data) {
			if (i.compareTo(" ") == 0)
				i = "0";
			hasilJumlah += Double.parseDouble(i.trim());
		}
		return hasilJumlah;
	}
	
	public void init() {
		this.connection();
		this.inputOutputStream();
		this.receiveClient();
		this.closeConnection();
	}
	

}
