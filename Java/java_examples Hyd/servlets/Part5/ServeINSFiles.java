/* Shows how to serve our own file types using web logic server
* Author : Team -J
* Version : 1.0
*/
package  INetSolv;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class ServeINSFiles extends HttpServlet
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
	out.println(" serving *.ins files");
	out.println("</TITLE></HEAD><BODY>");
	out.println(" Serving *.ins files ");
	out.println("</BODY></HTML>");
	out.close();
    }
}
