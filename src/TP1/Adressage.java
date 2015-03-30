package TP1;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Adressage {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) {
		try{
		InetAddress adresseLocal = InetAddress.getLocalHost();
		System.out.println("voici le nom local du hote ainsi que l 'adress IP :"+ adresseLocal.getHostName()+" : "+ adresseLocal.getHostAddress());
		// un exemple d'un serveur par nom 
		InetAddress adressServeur = InetAddress.getByName("www.siteduzero.com");
		System.out.println("voici le nom du hote ainsi que son adressIp : "+ adressServeur.getHostName()+" : "+adressServeur.getHostAddress());
		}catch (UnknownHostException e) {
            
           e.printStackTrace();
       }
		
	}
}
