package oto;

import javax.ejb.*;
import java.rmi.*;
import java.util.*;
import oto.AddrRemote;


public interface AddrHome  extends EJBHome {

  public AddrRemote create(String studid,String addr) 
    throws CreateException, RemoteException;

  public AddrRemote findByPrimaryKey(String primaryKey) 
    throws FinderException, RemoteException;
}
