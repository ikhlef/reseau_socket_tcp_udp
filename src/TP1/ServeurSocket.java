package TP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(25);
		Socket client = server.accept();
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String ligne;
		try {
			while ((ligne = reader.readLine()) != null) {
				System.out.println(ligne);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
			client.close();
			server.close();
		}
	}
}
