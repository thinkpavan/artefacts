/* A simple remote Object
Author : Team -J
Version : 1.0 */


class RemoteObject1 extends java.rmi.server.UnicastRemoteObject implements RemoteInterface1{
// super class throws remote exceptions
	public RemoteObject1() throws java.rmi.RemoteException {
		super(); 
	}
	public int remotemethod1(int i , int j)throws java.rmi.RemoteException{
		System.out.println(Thread.currentThread());
		return (i+j);
	}
	public String remotemethod(int k , String s)throws java.rmi.RemoteException{
		System.out.println(Thread.currentThread());
		return s;
	}
}

