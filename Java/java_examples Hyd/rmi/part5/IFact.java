/* A simple Factory
Author : Team -J
Version : 1.0 */
// remote interface serves as marker interface
interface IFact extends java.rmi.Remote{
	IStateTest create() throws java.rmi.RemoteException;
}

