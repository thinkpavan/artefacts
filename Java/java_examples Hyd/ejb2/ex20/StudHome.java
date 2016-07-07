package cmp;

import javax.ejb.*;
import java.rmi.*;
import java.util.*;
import cmp.StudRemote;


public interface StudHome extends EJBHome {

  public StudRemote create(String id,String name,String oa) 
    throws CreateException, RemoteException;

  public StudRemote findByPrimaryKey(String primaryKey) 
    throws FinderException, RemoteException;

  public Collection findStudents()
    throws FinderException, RemoteException;
}
