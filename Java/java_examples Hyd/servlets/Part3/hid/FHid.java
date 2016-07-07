/* Shows how to store client state by using cookies
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class FHid extends HttpServlet
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
//get values submitted by the form
String name = request.getParameter("name");
String fname = request.getParameter("Fname");


// now we need to genetare the second form dynamically from here
	out.print("<html>   <head>     <title>Income tax details -form XXX - Page no -2 </title>");
	out.print("  </head>  <body bgcolor=#ffffff>"); 
	out.print("<form action=\"SHid\" method=get>");
	out.print("income for this year <input type=text name=income> <BR>");
	out.print(" Tax<input type=text name=tax>");
// here we are writing the data back in the form as hidden fields.
	out.print(" <input type=hidden name=name value ="+ name+">");
	out.print(" <input type=hidden name=Fname value ="+ fname+">");

	out.print("<br><br> <BR><BR><input type=submit  value = submit>");
	out.print("</form> </font>  </body> </html>");
	out.close();
    }
}
