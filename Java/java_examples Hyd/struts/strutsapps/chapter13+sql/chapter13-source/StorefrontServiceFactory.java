package com.oreilly.struts.storefront.service;

import java.lang.reflect.Proxy;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.struts.action.PlugIn;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ApplicationConfig;
import com.oreilly.struts.storefront.framework.util.IConstants;

/**
 * A factory for creating Storefront Service Implementations. The specific
 * service to instantiate is determined from the initialization parameter
 * of the ServiceContext. Otherwise, a default implementation is used.
 * @see com.oreilly.struts.storefront.service.StorefrontDebugServiceImpl
 */
public class StorefrontServiceFactory implements IStorefrontServiceFactory, PlugIn{
  // Hold onto the servlet for the destroy method
  private ActionServlet servlet = null;

  /**
   * Hard-coded implementation to support dynamic proxy testing
   */
  public IStorefrontService createService(){
    Class[] serviceInterface = new Class[] { IStorefrontService.class };
    IStorefrontService proxy = (IStorefrontService)Proxy.newProxyInstance(
      Thread.currentThread().getContextClassLoader(), serviceInterface,
      new DynamicStorefrontEJBDelegate() );
    return proxy;
  }

  public void init(ActionServlet servlet, ApplicationConfig config)
    throws ServletException{
    // Store the servlet for later
    this.servlet = servlet;

    /* Store the factory for the application. Any Storefront service factory
     * must either store itself in the ServletContext at this key, or extend
     * this class and don't override this method. The Storefront application
     * assumes that a factory class that implements the IStorefrtonServiceFactory
     * is stored at the proper key in the ServletContext.
     */
    servlet.getServletContext().setAttribute( IConstants.SERVICE_FACTORY_KEY, this );
  }

  public void destroy(){
    // Destroy the factory
    IStorefrontServiceFactory factory =
      (IStorefrontServiceFactory)servlet.getServletContext().getAttribute(IConstants.SERVICE_FACTORY_KEY);
    if ( factory != null ){
      factory.destroy();
    }
  }
}