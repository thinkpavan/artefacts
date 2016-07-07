/* A simple Server which registers all our remote objects
Author : Team -J
Version : 1.0 */
import java.security.Policy;
class Server{
	public static void main(String args[]) throws Exception{
System.setSecurityManager( new java.rmi.RMISecurityManager());

RO1 ro1 =new RO1();

// register this object to with rmi registry
//	java.rmi.server.UnicastRemoteObject.exportObject(ro1); // we can reexport an object

		java.rmi.Naming.rebind("remoteobj1",ro1); // bind can also be used here !!!
System.out.println(" bound to registry");
	//	java.rmi.Naming.unbind("remoteobj1");
	}
}

