package com.client;

import java.io.IOException;

public class GetDataAddition extends ConnectionClient {

	GetDataAddition(String hostName, int port) {
		super(hostName, port);
	}
	
	public void inputUser() {
		try {
			System.out.println("===== Socket Program Penjumlahan ======== ");
			System.out.println("Masukan Input : (a;b)");
			System.out.print("==> ");
			this.user_input = this.input.readLine();
			this.outputStream.writeBytes(user_input + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void recieveServer() {
		try {
			output = inputStream.readLine();
			System.out.println("Hasil : " + output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void init() {
		this.connectionClient();
		this.inputUser();
		this.recieveServer();
		this.closeConnection();
	}
	
	

}
