/* Shows how to use ejb from servlet, We have just copied the code
developed in earlier examples to this servlet
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import env.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class EJBServlet extends HttpServlet
{ 
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	PrintWriter		out;
	// set content type and other response header fields first
        response.setContentType("text/html");

	// then write the data of the response
	out = response.getWriter();

      out.println("<HTML><HEAD><TITLE>");
	out.println(" This output is generated from a Servlet");
	out.println("</TITLE></HEAD><BODY>");
     try {
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("inetsolv.env.hworld");
           HWorldHome home =(HWorldHome)obj;
// we can now invoke a method on home interface to create EJB Object
           HWorldRemote h = home.create();
	     String res = h.GetMessage("Student");
		out.println(" result from ejb = "+res);
           }
           }catch(Exception e){ out.println(" failed in executing method on EJB");}
	out.println("</BODY></HTML>");
	out.close();
    }
    
    //method to get the initial context specific to bea weblogic, we may
// need to slightly modify the props in order to run this on other
// servers
  static public Context getInitialContext() throws Exception {
    Hashtable h = new Hashtable();
    h.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
    h.put(Context.PROVIDER_URL, "t3://localhost:7001"); //here we are running ejb server
    // and servlet on the same host, if u run them on different machine replace localhost
    // with the name of the host on which u run ejb server.
      h.put(Context.SECURITY_PRINCIPAL, "admin");//user
      h.put(Context.SECURITY_CREDENTIALS, "inetadmin"); //password
    return new InitialContext(h);
  }
}
