/* A simple Server which registers all our remote objects
Author : Team -J
Version : 1.0 */

import java.rmi.Naming;
public class Server { 
	public Server() {
		try {
			StateTestImpl sti =new StateTestImpl();
			Naming.rebind("rmi://localhost/name1",sti);
			Naming.rebind("rmi://localhost/name2",sti);
			System.out.println("Registered our object info in register");
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