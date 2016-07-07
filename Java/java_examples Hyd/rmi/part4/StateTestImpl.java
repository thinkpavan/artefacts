/* A simple remote Object
Author : Team -J
Version : 1.0 */


class StateTestImpl extends java.rmi.server.UnicastRemoteObject implements IStateTest{
	private String cliName;
	public StateTestImpl() throws java.rmi.RemoteException {
		super(); 
	}
	public void setName(String name)throws java.rmi.RemoteException{
		cliName=name;
	}
	public String getName()throws java.rmi.RemoteException{
		return cliName;
	}
}

