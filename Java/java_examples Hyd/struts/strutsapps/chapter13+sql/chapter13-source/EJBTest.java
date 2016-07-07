package com.oreilly.struts.storefront.service;

import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import com.oreilly.struts.storefront.catalog.view.ItemDetailView;

public class EJBTest {

  public static void main(String[] args) {
    try {
      InitialContext ic = new InitialContext();
      Object home = ic.lookup("com.oreilly.struts.storefront.service.Storefront");
      StorefrontHome sfHome = (StorefrontHome)
        PortableRemoteObject.narrow(home, StorefrontHome.class);
      Storefront sf = sfHome.create();
      ItemDetailView view = sf.getItemDetailView("123");
      System.out.println(view.getName());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}