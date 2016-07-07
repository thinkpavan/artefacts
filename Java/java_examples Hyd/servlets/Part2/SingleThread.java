/* Shows how to mark a servlet to be executed from a single thread
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class SingleThread extends HttpServlet implements SingleThreadModel 
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
	out.println(" Hi This is from Servlet ");
	out.println("</BODY></HTML>");
	out.close();
    }
}
