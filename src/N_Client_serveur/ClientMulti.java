package N_Client_serveur;
import java.io.*;
import java.net.*;

public class ClientMulti {
	static void pause(){
		try{
			Thread.currentThread();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		int port,compteur =0; // nombre d'echanges
		String ip;
		Socket socket = null;
		
		if(args.length == 2) {
			ip = args[0];
			port = Integer.parseInt(args[1]);
		}else {	ip = "localhost";
				port = 12345;
		}
		
		try {
			socket = new Socket(ip,port);
			BufferedWriter bostream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader bistream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(bistream.readLine());
			
			while (compteur<10) {
				compteur++;
				String chaine="Je suis le client "+ip+" et j'ai fait "+compteur+" appels";
				bostream.write(chaine+"\n");
				bostream.flush();
				pause(); //pause de 2sec
				System.out.println(bistream.readLine());
			}
			bostream.write("QUIT\n");
			bostream.flush();
			pause(); //pause de 2sec
			System.out.println(bistream.readLine());
			System.out.println("QUIT");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally{
			socket.close();
		}
	}
}