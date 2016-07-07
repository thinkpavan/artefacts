/* Shows how to store client state by using cookies
* Author : Team -J
* Version : 1.0
* use response.encodeURL() to support session tracking using url rewritting
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class URLFFSession extends HttpServlet
{ 
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	PrintWriter		out;
	// set content type and other response header fields first
        response.setContentType("text/html");
// true to indicate if session is not existing already
    HttpSession session = request.getSession(true);
	// then write the data of the response
	out = response.getWriter();
//get values submitted by the form
String name = request.getParameterValues("name")[0];
String fname = request.getParameterValues("Fname")[0];
// store name and fname on server using sessions
    session.putValue("name", name);
    session.putValue("fname", fname);


// now we need to genetare the second form dynamically from here
	out.print("<html>   <head>     <title>Income tax details -form XXX - Page no -2 </title>");
	out.print("  </head>  <body bgcolor=#ffffff>"); 
	out.print("<form action="+response.encodeURL("/myapp/URLSFSession")+" method=get>");
	out.print("income for this year <input type=text name=income> <BR>");
	out.print(" Tax<input type=text name=tax>");
	out.print("<br><br> <BR><BR><input type=submit  value = submit>");
	out.print("</form> </font>  </body> </html>");
	out.close();
    }
}
