package TP1;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws IOException {
		BufferedReader bistream=null;
		BufferedWriter bostream=null;
		InetAddress ip;
		String chaine,line = null;
		int port;
		boolean connecter=true;
		Socket s=null;
			if(args.length!=2){
				//ip="localhost";
				ip= InetAddress.getLocalHost();
				port=12340;
				//ip="smtp.dauphine.fr";
				 //port=25;
			}else{
				ip=InetAddress.getByName(args[0]);
				port = Integer.parseInt(args[1]);
			}
			
		try{
			s= new Socket(ip,port);	
			
			bostream = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bistream = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			BufferedReader lireclavier=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("voila ce que je viens de lire depuis le serveur : " + bistream.readLine());
         	
		while(connecter){
			System.out.println("saisi un texte svp");
			chaine =lireclavier.readLine();	
		    bostream.write(chaine +'\n');
		    bostream.flush();
		    
		    if(!chaine.equals("QUIT")){
		    line = bistream.readLine();
		    System.out.println(line);
		    
		    }else{
			connecter=false;
			line = bistream.readLine();
			System.out.println(line+". je dois fermer les portes. a bientot");
		    }
		}
		bostream.close();
		bistream.close();
		s.close();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
