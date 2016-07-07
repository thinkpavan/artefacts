/* A simple remote interface
Author : Team -J
Version : 1.0 */
// remote interface serves as marker interface
class RO2 extends java.rmi.server.UnicastRemoteObject implements  RI2 {
	public RO2() throws java.rmi.RemoteException{
	}
	public String remotemethod(int k , String s)throws java.rmi.RemoteException{
		return new String(" new string from ro2");
	}
}

