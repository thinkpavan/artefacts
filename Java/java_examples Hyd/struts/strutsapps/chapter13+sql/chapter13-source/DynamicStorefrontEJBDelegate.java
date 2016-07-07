package com.oreilly.struts.storefront.service;

import java.lang.reflect.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.CreateException;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import com.oreilly.struts.storefront.catalog.view.ItemDetailView;
import com.oreilly.struts.storefront.customer.view.UserView;
import com.oreilly.struts.storefront.framework.ejb.EJBHomeFactory;
import com.oreilly.struts.storefront.framework.exceptions.*;

/**
 * This class is a dynamic proxy implementation of the IStorefrontService
 * interface. It implements two of the IStorefrontService methods itself and
 * delegates the others to the methods declared by the IStorefront Business
 * Interface with the same name.
 */
public class DynamicStorefrontEJBDelegate implements InvocationHandler {

  private IStorefront storefront;
  private Map storefrontMethodMap;

  public DynamicStorefrontEJBDelegate() {
    init();
  }

  private void init() {
    try {
      // get the remote reference to the session bean
      StorefrontHome sfHome = (StorefrontHome)EJBHomeFactory.getInstance().
        lookupHome("com.oreilly.struts.storefront.service.Storefront",
        StorefrontHome.class);
      storefront = sfHome.create();

      // store the Business Interface methods for later lookups
      storefrontMethodMap = new HashMap();
      Method[] storefrontMethods = IStorefront.class.getMethods();
      for (int i=0; i<storefrontMethods.length; i++) {
        storefrontMethodMap.put(storefrontMethods[i].getName(),
          storefrontMethods[i]);
      }
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

  public void logout( String email ) {
    // Do nothing for this example
  }

  public void destroy() {
    // Do nothing for this example
  }

  public Object invoke( Object proxy, Method method, Object[] args )
   throws Throwable{
    try {
      // check for the two methods implemented by this class
      if (method.getName().equals("logout")) {
        logout((String)args[0]);
        return null;
      }
      else if (method.getName().equals("destroy")) {
        destroy();
        return null;
      }
      else {
        // this method should match a method implemented by the
        // session bean that has the same name and argument list
        Method storefrontMethod = (Method)storefrontMethodMap.get(
          method.getName());
        if (storefrontMethod != null) {
          // call the method on the remote interface
          return storefrontMethod.invoke( storefront, args );
        }
        else {
          throw new NoSuchMethodException("The Storefront does not implement "
            + method.getName());
        }
      }
    } catch( InvocationTargetException ex ) {
      if (ex.getTargetException() instanceof RemoteException) {
        // RemoteException isn't declared by the IStorefront method that was
        // called, so we have to catch it and throw something that is
        throw DatastoreException.datastoreError(ex.getTargetException());
      }
      else {
        throw ex.getTargetException();
      }
    }
  }
}
