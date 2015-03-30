package TP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServeurDatagram {

	private static DatagramSocket socket;

	public static void main(String[] args) throws IOException {
		/*InetAddress ikhlefrafik;
		 ikhlefrafik = InetAddress.getByAddress("foufa", new byte[] { (byte)225,(byte) 1, (byte)2, (byte)3});
		 System.out.println("voila tona adresse foufiiii : " +ikhlefrafik.getHostAddress());
		 socket = new DatagramSocket(310,ikhlefrafik);
		*/		
	
		//InetAddress ikhlefrafik = InetAddress.getByAddress("foufa", foufa);
		
		DatagramSocket socket = new DatagramSocket(309); 
		byte[] buffer = new byte[1500];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		
		while(true){
			socket.receive(packet);
			
			InetAddress clientAddress = packet.getAddress();
			int port = packet.getPort();
			System.out.println("voila le port de l emetteur : "+ port);
			System.out.println("Reception de : " + clientAddress.getHostName() + " : " + new String(packet.getData(), 0, packet.getLength()));
			
			String g = "PONG"+"voila ton port couchan"+ port;
			byte[] b = g.getBytes();
			DatagramPacket clientPacket = new DatagramPacket(b, b.length, clientAddress, port);
			socket.send(clientPacket);
			socket.setSoTimeout(2000);
			//socket.close();
	}
	

		
		}
}
