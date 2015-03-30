package TP1;

import java.io.*;
import java.net.*;
 
public class Sendy {
  public static void main(String[] args) throws IOException
  {
    Socket comm = null;
    InputStream is = null;
 
    try
    {
      System.out.println("hello word");
    	//comm = new Socket("localhost", 10080);
    	comm = new Socket("smtp.dauphine.fr", 25);
 
      comm.getOutputStream().write("Ceci est mon message\n\n".getBytes());
      is = comm.getInputStream();
      int c;
      while((c = is.read()) != -1)
        System.out.write(c);
    }
    catch(Exception e)
    {
      System.err.println("Exception " + e.toString());
    }
    finally
    {
      if (is!=null)
         is.close();
      if (comm!=null)
         comm.close();
    }
  }
}