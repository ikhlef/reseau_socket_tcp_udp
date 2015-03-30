package TP1;

import java.io.*;
import java.net.*;
 
public class Dumpy {
  public static void main(String[] args) throws IOException{
    ServerSocket conn = null;
    Socket comm = null;
    InputStream is = null;
 
    try
    {
      conn = new ServerSocket(10080);
      comm = conn.accept();
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
      if (conn!=null)
         conn.close();
    }
  }
}
