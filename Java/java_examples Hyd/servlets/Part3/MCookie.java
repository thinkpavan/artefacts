/* Shows cookie basics
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class MCookie extends HttpServlet
{ 
    public void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
		PrintWriter		out;
		// set content type and other response header fields first
        response.setContentType("text/html");
		// then write the data of the response
		out = response.getWriter();
		// get the value from the cookie stored on client browser

		// let us test some of the methods on cookie class
		Cookie[] c= request.getCookies();
		Cookie c1 = new Cookie("UserName","U'r Name");
		Cookie c2 = new Cookie("SomeAttribute","U'r Attributes");
		response.addCookie(c1);
		response.addCookie(c2);		
	
		out.println("<HTML><HEAD><TITLE>");
		out.println(" This output is generated from a Servlet");
		out.println("</TITLE></HEAD><BODY>");
			if(c!=null){
				for(int i =0 ;i<c.length;i++){
					out.println("Cookie Name = "+ c[i].getName()+"<br>");
					out.println("Cookie Value ="+c[i].getValue()+"<br>");
					// we can't rely on some of the below values as some of the browsers
					// may not properly support all of these
					out.println("Cookie Comment = "+ c[i].getComment()+"<br>");
					out.println("Domain Value ="+c[i].getDomain()+"<br>");
					out.println("getMaxAge = "+ c[i].getMaxAge()+"<br>");
					out.println("getPath Value ="+c[i].getPath()+"<br>"+"<br>");
					}
			}

	out.println(" Hi This is from MCookie Servlet ");
	out.println("</BODY></HTML>");
	out.close();
    }
}
