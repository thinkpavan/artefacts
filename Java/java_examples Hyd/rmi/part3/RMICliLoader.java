import java.net.*;
import java.io.*;
import java.util.Properties;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

public class RMICliLoader {

  static RMICliLoader rcl;
  Class    clientClass;
  Runnable client;
  Properties p;
  String clientName="Client";
  URL url;

  public RMICliLoader() throws Exception{

    p = System.getProperties();

    url = new URL(p.getProperty("java.rmi.server.codebase"));

    System.out.println("" + url);

    // Put this information into a property so that the downloaded 
    // client can retrieve it
    System.out.println("Asking for: " + url + " and " + clientName);
    clientClass = RMIClassLoader.loadClass(url,clientName);
    System.out.println("After loading Client Class");
    client = (Runnable)clientClass.newInstance();
    client.run();
  }

  public static void main (String args[]) throws Exception{
    System.setSecurityManager( new java.rmi.RMISecurityManager());
      rcl = new RMICliLoader();

  }  
}  