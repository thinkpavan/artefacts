/* A simple remote Object
Author : Team -J
Version : 1.0 */


class FactImpl extends java.rmi.server.UnicastRemoteObject implements IFact{
	public FactImpl() throws Exception{
		super();
	}
	public IStateTest create() throws java.rmi.RemoteException{
		System.out.println("Creating new Object");
		IStateTest ist = new StateTestImpl();
		return ist;
	}
}

