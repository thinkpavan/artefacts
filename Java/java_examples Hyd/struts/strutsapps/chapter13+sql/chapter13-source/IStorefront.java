package com.oreilly.struts.storefront.service;

import java.rmi.RemoteException;
import java.util.List;
import com.oreilly.struts.storefront.catalog.view.ItemDetailView;
import com.oreilly.struts.storefront.customer.view.UserView;
import com.oreilly.struts.storefront.framework.exceptions.*;

/**
 * The Business Interface for the Storefront Session Bean
 */
public interface IStorefront {

  public UserView authenticate(String email, String password)
    throws InvalidLoginException, ExpiredPasswordException,
      AccountLockedException, DatastoreException, RemoteException;

  public List getFeaturedItems() throws DatastoreException, RemoteException;

  public ItemDetailView getItemDetailView( String itemId )
    throws DatastoreException, RemoteException;
}
