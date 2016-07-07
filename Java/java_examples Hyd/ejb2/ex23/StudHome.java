package oto;

import javax.ejb.*;
import java.rmi.*;
import java.util.*;
import oto.StudRemote;


public interface StudHome extends EJBHome {

  public StudRemote create(String id,String name,String oa) 
    throws CreateException, RemoteException;

  public StudRemote findByPrimaryKey(String primaryKey) 
    throws FinderException, RemoteException;
}
