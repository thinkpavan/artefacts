/* To send a html page with login /passwd fileds 
Version : 1.0
Author : Team - J
*/

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class LoginSrv extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException
    {
		PrintWriter		out;
        response.setContentType("text/html");
	  out = response.getWriter();

      out.println("<HTML><HEAD><TITLE>");
	out.println(" Login Form");
	out.println("</TITLE></HEAD><BODY>");
	out.println("<form action=\"/myapp/index.html\" method=GET> name <input type=text name=uname> <BR>password <input type=password name=pwd><BR><input type=submit  value = submit></form> ");
	out.println("</BODY></HTML>");
	out.close();
    }
}

