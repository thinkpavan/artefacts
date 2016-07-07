/* A simple Server which registers all our remote objects
Author : Team -J
Version : 1.0 */

import java.rmi.Naming;
import java.rmi.registry.*;
public class Server { 
	public Server() {
		try {
			LocateRegistry.createRegistry(1099);
			RemoteObject1 ro1 =new RemoteObject1();
			Naming.rebind("rmi://localhost/ro", ro1);
			System.out.println("Registered our object info in registry");
		 } catch (Exception e)
		{
			 System.out.println("Problem in binding: " + e);
		 }
	} 
	public static void main(String args[]) 
	{ 
		System.setSecurityManager( new java.rmi.RMISecurityManager());
		new Server();
	 } 
}