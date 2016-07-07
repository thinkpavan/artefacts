package com.oreilly.struts.storefront.framework.ejb;

import java.io.InputStream;
import java.io.IOException;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;

/**
 * This class implements the EJBHomeFactory pattern. It performs JNDI
 * lookups to locate EJB homes and caches the results for subsequent calls.
 */
public class EJBHomeFactory {
  private Map homes;
  private static EJBHomeFactory singleton;
  private Context ctx;

  private EJBHomeFactory() throws NamingException {
    homes = Collections.synchronizedMap(new HashMap());
    try {
      // load the properties file from the classpath root
      InputStream inputStream = getClass().getResourceAsStream(
        "/jndi.properties" );
      if ( inputStream != null) {
        Properties jndiParams = new Properties();
        jndiParams.load( inputStream );

        Hashtable props = new Hashtable();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
          jndiParams.get(Context.INITIAL_CONTEXT_FACTORY));
        props.put(Context.PROVIDER_URL, jndiParams.get(Context.PROVIDER_URL));
        ctx = new InitialContext(props);
      }
      else {
        // use default provider
        ctx = new InitialContext();
      }
    } catch( IOException ex ){
      // use default provider
      ctx = new InitialContext();
    }
  }

  /**
   * Get the Singleton instance of the class
   */
  public static EJBHomeFactory getInstance() throws NamingException {
    if (singleton == null) {
      singleton = new EJBHomeFactory();
    }
    return singleton;
  }

  /**
   * Specify the JNDI name and class for the desired home interface
   */
  public EJBHome lookupHome(String jndiName, Class homeClass)
   throws NamingException {
    EJBHome home = (EJBHome)homes.get(homeClass);
    if (home == null) {
      home = (EJBHome)PortableRemoteObject.narrow(ctx.lookup(
        jndiName), homeClass);
      // cache the home for repeated use
      homes.put(homeClass, home);
    }
    return home;
  }
}
