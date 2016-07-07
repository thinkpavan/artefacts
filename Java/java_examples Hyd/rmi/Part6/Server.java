/* A simple Server which registers all our remote objects
Author : Team -J
Version : 1.0 */
import java.security.Policy;
class Server{
	public static void main(String args[]) throws Exception{
System.out.println(Policy.getPolicy().getClass());
System.setSecurityManager( new java.rmi.RMISecurityManager());
System.out.println(Policy.getPolicy().getClass());

//System.setSecurityManager( new MySecMan());
RemoteObject1 ro1 =new RemoteObject1();
java.rmi.server.UnicastRemoteObject.exportObject(ro1); 
java.rmi.Naming.rebind("remoteobj1",ro1); // bind can also be used here !!!
System.out.println(" bound to registry");
	//	// make this object available as remote object
	//	java.rmi.Naming.unbind("remoteobj1");
	}
}

