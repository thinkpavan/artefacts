/* A simple Server which registers all our remote objects
Author : Team -J
Version : 1.0 */

import java.rmi.Naming;
public class Server { 
	public Server() {
		try {
			FactImpl sti =new FactImpl ();
			Naming.rebind("rmi://localhost/factory",sti);
			System.out.println("Registered our factory info in register");
		 } catch (Exception e)
		{
			 System.out.println("Problem in binding: " + e);
		 }
	} 
	public static void main(String args[]) 
	{ 
		new Server();
	 } 
}