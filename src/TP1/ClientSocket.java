package TP1;

import java.net.*;
import java.io.*;
public class ClientSocket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Socket s = new Socket("www.developpez.com", 80);
		Socket s = new Socket("smtp.dauphine.fr", 25);

		String g = "GET / HTTP/1.1\n" +"Host: www.developpez.com\n\n";
	
		BufferedWriter bostream = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader bistream = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
		try{
			//ecriture dans le flux de sortie
			bostream.write(g);
			//bostream.flush();//force l envoi au serveur
		String ligne;
		while((ligne=bistream.readLine())!=null){
		System.out.println(ligne);		
		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			bostream.close();
			bistream.close();
		
		s.close();
		}
	}
}
