package TP1;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
/**
 * @author millie
 *
 */
public class TestInetAddress {
	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws Exception {
		InetAddress adress= InetAddress.getLocalHost();
		InetAddress adre= InetAddress.getByName("www.developpez.com");
		System.out.println(adre.getAddress());
		
		System.out.println("l ip n est pas accessible"+adre.isReachable(0));
		System.out.println("voici l adresse ip de deve : "+adre.getHostAddress());
		System.out.println("mon adresse IP est : "+ adress);
		System.out.println("mon nom de hote est : "+ adress.getHostName());
		System.out.println("mon adresse IP pointée est : "+ adress.getHostAddress());
		
		InetAddress ad= InetAddress.getByName("www.developpez.com");
		System.out.println("ladresse ip de www.developpez.com est :"+ad);
		
		//enumère l'ensemble des interfaces réseaux, typiquement une carte réseau
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		
        while (interfaces.hasMoreElements()) {  
           NetworkInterface currentInterface = interfaces.nextElement(); 
           
           //chaque carte réseau peut disposer de plusieurs adresses IP
           Enumeration<InetAddress> addresses = currentInterface.getInetAddresses(); 
           while (addresses.hasMoreElements()) {  
               InetAddress currentAddress = addresses.nextElement();
               System.out.println(currentAddress.getHostAddress());
           }
       }
	}
}