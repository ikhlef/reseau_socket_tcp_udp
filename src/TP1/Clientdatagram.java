package TP1;

import java.io.IOException;
import java.net.*;

public class Clientdatagram {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getLocalHost();
		//InetAddress serverAddress = InetAddress.getByName("foufa");		
		//InetAddress ikhlefrafik = InetAddress.getByAddress(new byte[] { (byte)225,(byte) 1, (byte)2, (byte)3});
		
		int port = 309;
		
		String g = "Coucou";
		byte[] bG = g.getBytes();
		DatagramPacket packet = new DatagramPacket(bG, bG.length, serverAddress, port);
		packet.setData("Coucou".getBytes());
		//packet.setData(bG);
		socket.send(packet);

		byte[] buffer = new byte[1500];
		DatagramPacket pong = new DatagramPacket(buffer, buffer.length, serverAddress, port);
	
		//on met un timeout
		socket.setSoTimeout(5000);
		socket.receive(pong);
		System.out.println("Client a recu : " + new String(pong.getData(), 0, pong.getLength()));
		socket.close();

	

}
}
