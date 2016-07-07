/* A simple Client using remote object
Author : Team -J
Version : 1.0 */

class Client2{
	public static void main(String args[]) throws Exception{
		//get reference to remote object
	//	Object obj =java.rmi.Naming.lookup("rmi://localhost/remoteobj1");
		Object obj =java.rmi.Naming.lookup("rmi://localhost/remoteobj2");
		RemoteInterface1 ro1 = (RemoteInterface1)obj;
		System.out.println(" Remote object is accessed by "+ ro1.getClass());
		System.out.println("Result of remotemethod1 = "+ro1.remotemethod1(20,30));
		System.out.println("Result of remotemethod = "+ro1.remotemethod(20,"Suresh"));
		ro1.setvar(20);
		System.in.read();
		System.out.println(".... var = "+ro1.getvar());
	}
}

