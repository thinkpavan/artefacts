/* To demonstrate the use of Servlet Context
* Author : Team -J
* Version : 1.0
*/
package net.inet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class SFour   extends HttpServlet
{ 
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	PrintWriter		out;
	ServletContext sc;
	sc = getServletContext();
	Servlet s = sc.getServlet("three");
	SThree sthree = (SThree) s;
	int res = sthree.sum(10,20);
	// set content type and other response header fields first
        response.setContentType("text/html");

	// then write the data of the response
	out = response.getWriter();
	
      out.println("<HTML><HEAD><TITLE>");
	out.println(" This output is generated from a Servlet");
	out.println("</TITLE></HEAD><BODY>");
	out.println(" Hi This is from SFour <br>Result of sum = "+ res);
	out.println("</BODY></HTML>");
	out.close();
    }
	public int sum(int a, int b){
		return (a+b);
	}
}
