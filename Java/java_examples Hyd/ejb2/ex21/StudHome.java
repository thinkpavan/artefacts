package home;

import javax.ejb.*;
import java.rmi.*;
import java.util.*;
import home.StudRemote;


public interface StudHome extends EJBHome {

  public StudRemote create(String id,String name,String oa) 
    throws CreateException, RemoteException;

  public StudRemote findByPrimaryKey(String primaryKey) 
    throws FinderException, RemoteException;
// find students with name
  public Collection findStudentsWithName(String n)
    throws FinderException, RemoteException;
// new to 2.x , home methods.
	public int getNOS() throws RemoteException;
}
