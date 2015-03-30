package N_Client_serveur;
import java.net.*;
import java.io.*;


public class ThreadServer extends Thread {

	private DataOutputStream out;
	private BufferedReader in;
	private Socket socket = null;
	public int clientNo;
	public int reqcount = 0;

	String sentenceFromServer;
	 
	   public ThreadServer ( Socket socket , int no ){ 
	     super("ThreadClient");
	     this.socket = socket;
	     this.clientNo = no ;
	   }
	   private String message_suivant() { 
	       reqcount ++;
	       switch ( reqcount %5) {
	           case 0 : return new String ( " phrase 0 " ) ;
	           case 1 : return new String ( " phrase 1 " ) ;
	           case 2 : return new String ( " phrase 2 " ) ;
	           case 3 : return new String ( " phrase 3 " ) ;
	           case 4 : return new String ( " phrase 4 " ) ;
	       }
	     return new String ( " ca n'arrive jamais " ) ; //defaults
	   }
	   void pause () {
	     try {
	         Thread.currentThread() ;
	         Thread.sleep (1000) ;
	     }
	     catch (InterruptedException e ) {}
	   }
	   
	   public void run() {
		   try {
				InetAddress ip=socket.getInetAddress();
				int port=socket.getPort();
				out = new DataOutputStream(socket.getOutputStream());	
				in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
			    	
				out.writeBytes("Bienvenue Client Numero "+clientNo+ " IP + "+ip+": Port  "+port+'\n');
				out.flush();
				
				while (!(in.readLine()).equals("QUIT")) {
			        	
					out.writeBytes(message_suivant()+'\n');
			        out.flush();
				}   
				out.writeBytes("je ferme la connexion pour le client "+clientNo+"\n");
				out.flush();
			    out.close();
			    in.close();
			    socket.close();  
			     
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
