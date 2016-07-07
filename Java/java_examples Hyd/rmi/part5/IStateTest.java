/* A simple remote interface
Author : Team -J
Version : 1.0 */
// remote interface serves as marker interface
interface IStateTest extends java.rmi.Remote{
	void setName(String name)throws java.rmi.RemoteException;
	String getName()throws java.rmi.RemoteException;
}

