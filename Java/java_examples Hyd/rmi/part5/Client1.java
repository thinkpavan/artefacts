/* A simple Client using remote object
Author : Team -J
Version : 1.0 */

import java.rmi.*;

class Client1{
	public static void main(String args[]) throws Exception{
		//get reference to factory and ask it to create an object
		Object obj =java.rmi.Naming.lookup("rmi://localhost/factory");
		IFact fact= (IFact) obj;
		System.out.println(" Factory is accessed by "+ fact.getClass());
		IStateTest ro = (IStateTest)fact.create();
		System.out.println(" Remote object is accessed by "+ ro.getClass());
		ro.setName("Client ***one***");
		System.in.read();
		System.out.println(ro.getName());
	}
}

