/* Shows cookie basics
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class FCookie extends HttpServlet
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
	// create a cookie
	Cookie c1 = new Cookie("CName1","Cookie Value1");
	Cookie c2 = new Cookie("CName2","Cookie Value2");
	response.addCookie(c1);
	response.addCookie(c2);
      out.println("<HTML><HEAD><TITLE>");
	out.println(" This output is generated from a Servlet");
	out.println("</TITLE></HEAD><BODY>");
	out.println(" This has set 2 Cookies");
	out.println("</BODY></HTML>");
	out.close();
    }
}
