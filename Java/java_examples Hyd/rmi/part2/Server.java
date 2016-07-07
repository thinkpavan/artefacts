/* A simple Server which registers all our remote objects
Author : Team -J
Version : 1.0 */

import java.rmi.Naming;
public class Server {
	public Server() {
		try {
			RemoteObject1 ro1 =new RemoteObject1();
			Naming.rebind("rmi://localhost/ro", ro1);
			System.out.println("Registry our object info in register");
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