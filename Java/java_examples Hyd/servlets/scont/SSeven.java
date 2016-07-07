/* To demonstrate the use of Servlet Context
* Author : Team -J
* Version : 1.0
*/
package net.inet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class SSeven extends HttpServlet
{ 
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	PrintWriter		out;
	ServletContext sc;
	sc = getServletContext();
      response.setContentType("text/html");
	out = response.getWriter();
	RequestDispatcher rd = sc.getRequestDispatcher("/six");
log("before forwarding request");
// we can use forward to forward request to another servlet.
	rd.forward(request,response);
log("after forwarding request");
	out.println(" Hi This is from SFive");
	out.println("</BODY></HTML>");
	out.close();
    }
}
