package N_Client_serveur;
import java.net.*;
import java.io.*;


public class ServerMulti {
	public static void main(String[] args) {		
		int idClient=0;
		int port=12345;	
			System.out.println("server sur le prort : "+port);
			ServerSocket SocketServer = null;
			Socket socket=null;
			try{
			
				SocketServer=new ServerSocket(port);
				while(true){	
				 socket=SocketServer.accept();
				//pour chque client, la prise en charge est ssurée par un thread
				ThreadServer thread=new ThreadServer(socket,idClient++);
				thread.start();
				}
				
			}
			catch(IOException e){
				System.err.println("Erreur : "+e);
			}
		}	
}
