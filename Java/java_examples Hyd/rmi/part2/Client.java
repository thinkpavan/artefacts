/* A simple Client using remote object
Author : Team -J
Version : 1.0 */

import java.rmi.*;

class Client{
	public static void main(String args[]) throws Exception{
		//get reference to remote object
		Object obj =java.rmi.Naming.lookup("rmi://localhost/ro");
		RemoteInterface1 ro1 = (RemoteInterface1)obj;
		System.out.println(" Remote object is accessed by "+ ro1.getClass());
		System.out.println("Result of remotemethod1 = "+ro1.remotemethod1(20,30));
		System.out.println("Result of remotemethod = "+ro1.remotemethod(20,"SomeString"));
		System.out.println("Add REsult ="+ro1.add(10,20));
	}
}

