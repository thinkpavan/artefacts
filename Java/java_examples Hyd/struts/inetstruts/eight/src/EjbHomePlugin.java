/* shows why and how to implement a plug-in for struts.
Version : 1.0
Author : Team -J
*/

import java.io.*;
import javax.servlet.*;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ApplicationConfig;
import org.apache.struts.action.ActionServlet;
import java.util.Vector;

public class EjbHomePlugin implements PlugIn {
	Vector ejbhomes;

  public EjbHomePlugin() {
    System.out.println("In plug-in's constructor");

  }

  public void init(ActionServlet servlet,
    ApplicationConfig applicationConfig)
    throws javax.servlet.ServletException {
	ejbhomes = new Vector();
    System.out.println("In plug-in's init method");
    try {
// here is the code to get ref's to ejb homes and store in vector
      ServletContext context = servlet.getServletContext();
      context.setAttribute("EJB_HOMES",ejbhomes);
// store ref to ejb homes in app object.
    }catch(Exception e) {

      throw new ServletException(e.getMessage());
    }
  }

  public void destroy() {
	ejbhomes=null;
    System.out.println("In plug-in's destroy method");
  }
}