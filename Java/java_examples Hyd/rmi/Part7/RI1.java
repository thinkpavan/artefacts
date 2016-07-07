/* A simple remote interface
Author : Team -J
Version : 1.0 */
// remote interface serves as marker interface
interface RI1 extends java.rmi.Remote{
	RI2 getRO() throws java.rmi.RemoteException;
	String getString() throws java.rmi.RemoteException;

}

