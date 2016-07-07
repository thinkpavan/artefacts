/* A simple remote interface
Author : Team -J
Version : 1.0 */
// remote interface serves as marker interface
interface RI2 extends java.rmi.Remote{
	String remotemethod(int k , String s)throws java.rmi.RemoteException;
}

