/* A simple remote Object
Author : Team -J
Version : 1.0 */


class RO1 extends java.rmi.server.UnicastRemoteObject implements RI1{
// super class throws remote exceptions
	public RO1() throws Exception{
	}
	public RI2 getRO() throws java.rmi.RemoteException{
		// create an object of type ri2;
		RI2 r = new RO2();
		return(r);
	}
	public String getString() throws java.rmi.RemoteException{
		return new String("string from server");
	}
}

