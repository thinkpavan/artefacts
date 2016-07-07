package com.oreilly.struts.storefront.service;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * The home interface for the Storefront Session Bean
 */
public interface StorefrontHome extends EJBHome {
  public Storefront create() throws CreateException, RemoteException;
}
