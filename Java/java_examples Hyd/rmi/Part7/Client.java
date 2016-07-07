/* A simple Client using remote object
Author : Team -J
Version : 1.0 */

class Client{
	public static void main(String args[]) throws Exception{
		//get reference to remote object
		Object obj =java.rmi.Naming.lookup("rmi://localhost/remoteobj1");
		RI1 ro1 = (RI1)obj;
		System.in.read();
		System.out.println(" Remote object is accessed by "+ ro1.getClass());
		RI2 r = ro1.getRO();
		System.out.println("Result of getro = "+r);
		System.out.println("Result of remotemethod = "+ro1.getString());
		System.out.println("About to execute the method on RO2 object");
		System.out.println(" Result of ri2.remotemethod() "+ r.remotemethod(10,"some string"));
	}
}

