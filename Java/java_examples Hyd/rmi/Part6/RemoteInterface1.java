/* A simple remote interface
Author : Team -J
Version : 1.0 */
// remote interface serves as marker interface
interface RemoteInterface1 extends java.rmi.Remote{
	int remotemethod1(int i , int j)throws java.rmi.RemoteException;
	String remotemethod(int k , String s)throws java.rmi.RemoteException;
}

