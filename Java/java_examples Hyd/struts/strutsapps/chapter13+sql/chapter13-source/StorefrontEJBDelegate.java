package com.oreilly.struts.storefront.service;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import com.oreilly.struts.storefront.catalog.view.ItemDetailView;
import com.oreilly.struts.storefront.customer.view.UserView;
import com.oreilly.struts.storefront.framework.ejb.EJBHomeFactory;
import com.oreilly.struts.storefront.framework.exceptions.*;

/**
 * This class is a Business Delegate that supports the implementation of the
 * IStorefrontService interface using the Storefront session bean.
 */
public class StorefrontEJBDelegate implements IStorefrontService {

  private IStorefront storefront;

  public StorefrontEJBDelegate() {
    init();
  }

/* The initial implementation of this method requires looking up the home
   on every call
  private void init() {
    try {
      Hashtable props = new Hashtable();
      props.put(Context.INITIAL_CONTEXT_FACTORY,
        "org.jnp.interfaces.NamingContextFactory");
      props.put(Context.PROVIDER_URL, "localhost");

      InitialContext ic = new InitialContext(props);
      Object home = ic.lookup(
        "com.oreilly.struts.storefront.service.Storefront");

      StorefrontHome sfHome = (StorefrontHome)
        PortableRemoteObject.narrow(home, StorefrontHome.class);
      storefront = sfHome.create();
    }
    catch (NamingException e) {
      throw new RuntimeException(e.getMessage());
    }
    catch (CreateException e) {
      throw new RuntimeException(e.getMessage());
    }
    catch (RemoteException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
*/

  private void init() {
    try {
      // get the remote reference to the session bean
      StorefrontHome sfHome = (StorefrontHome)EJBHomeFactory.getInstance().
        lookupHome("com.oreilly.struts.storefront.service.Storefront",
        StorefrontHome.class);
      storefront = sfHome.create();
    }
    catch (NamingException e) {
      throw new RuntimeException(e.getMessage());
    }
    catch (CreateException e) {
      throw new RuntimeException(e.getMessage());
    }
    catch (RemoteException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public UserView authenticate( String email, String password )
   throws InvalidLoginException, ExpiredPasswordException,
     AccountLockedException, DatastoreException {
    try {
      return storefront.authenticate(email, password);
    }
    catch (RemoteException e) {
      throw DatastoreException.datastoreError(e);
    }
  }

  public List getFeaturedItems() throws DatastoreException {
    try {
      return storefront.getFeaturedItems();
    }
    catch (RemoteException e) {
      throw DatastoreException.datastoreError(e);
    }
  }

  public ItemDetailView getItemDetailView( String itemId )
   throws DatastoreException {
    try {
      return storefront.getItemDetailView(itemId);
    }
    catch (RemoteException e) {
      throw DatastoreException.datastoreError(e);
    }
  }

  public void logout( String email ) {
    // Do nothing for this example
  }

  public void destroy() {
    // Do nothing for this example
  }

}
