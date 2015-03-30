package TP1;

import java.net.*;
import java.io.*;

public class Serveur {

	
	public static void main(String[] args) throws IOException{
		ServerSocket serveur = null ;
		Socket serveursocket = null ;
		BufferedReader istream = null;
		DataOutputStream bostream=null,bostreamaccueil;
		String chainelue="";
		String chaineenvoie = "";
		int sport=12340;
		//int sport=25;

		boolean connecter=true;
		
		try{
		serveur = new ServerSocket(sport);
		serveursocket = serveur.accept();
		while(true){
		
		bostreamaccueil=new DataOutputStream(serveursocket.getOutputStream());
		bostreamaccueil.writeBytes("bonjour client  : <"+ (serveursocket.getInetAddress()).getHostAddress()+"> : <"+serveursocket.getPort()+">.\n");
		connecter=true;
		while(connecter){
		istream = new BufferedReader(new InputStreamReader(serveursocket.getInputStream()));
		bostream = new DataOutputStream(serveursocket.getOutputStream());
		
			chainelue = istream.readLine();
			chaineenvoie=chainelue.toUpperCase();
			
			if(!chainelue.equals("QUIT")){
				bostream.writeBytes(chaineenvoie +'\n');
				bostream.flush();
			}else{			
			bostream.writeBytes(chaineenvoie +'\n');
			bostream.flush();	
			connecter=false;	
			}
		}
		bostream.close();
		istream.close();
		serveursocket.close();
		serveur.close();
	}		
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch (IOException e) {
           e.printStackTrace();
		}
      }
}
