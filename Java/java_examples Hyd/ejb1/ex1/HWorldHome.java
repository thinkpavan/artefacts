package part1;

import java.rmi.*;
import javax.ejb.*;
import part1.HWorldRemote;

public interface HWorldHome extends EJBHome {
    public HWorldRemote create()throws RemoteException, CreateException;
}