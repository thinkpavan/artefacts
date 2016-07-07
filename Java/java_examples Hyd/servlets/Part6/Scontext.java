/* shows how to use servlet context to store the global
  info that can be shared between multiple servlets.
 * version :1.0
 * Author : Team -J. 
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Enumeration;


public class Scontext extends HttpServlet { 
  
  public void doGet (HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
  {
    res.setContentType("text/html");    
    // then write the data of the response
    PrintWriter out = res.getWriter();
	ServletConfig sconf = getServletConfig();
	ServletContext sc = sconf.getServletContext();
	String srv =sc.getServerInfo();
   	out.println("<HEAD><TITLE>  using servlet context </TITLE></HEAD><BODY>");
   	out.println(" now we are using " +srv+" engine<br>");
	sc.setAttribute("attrib1"," this a some global data");
   	out.println(" we can use set/getattribute to store/retrieve global data<br>");	
	java.util.Enumeration enum =sc.getAttributeNames();
	while(enum.hasMoreElements())
		out.println(enum.nextElement()+"<br>");	
	out.println("*****************<br>");
	enum=sc.getInitParameterNames();	
	while(enum.hasMoreElements())
		out.println(enum.nextElement()+"<br>");	
   	out.println(" </body></html>");
    out.close();
  }
  

}
