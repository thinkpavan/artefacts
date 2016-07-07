/* Shows how to store client state by using cookies
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class FFCookie extends HttpServlet
{ 
    public void doGet (HttpServletRequest request,HttpServletResponse	response) throws ServletException, IOException
    {
		PrintWriter		out;
		// set content type and other response header fields first
        
		response.setContentType("text/html");
	
		// then write the data of the response
		out = response.getWriter();
		//get values submitted by the form
		String name = request.getParameter("name");
		String fname = request.getParameter("Fname");

		// create a cookie to store the values of name and fname
		Cookie c1 = new Cookie("name",name);
		Cookie c2 = new Cookie("fname",fname);
		response.addCookie(c1);
		response.addCookie(c2);
		// now we need to genetare the second form dynamically from here
		out.print("<html>   <head>     <title> Income tax details -form XXX - Page no -2 </title>");
		out.print("</head><body bgcolor=#ffffff>"); 
		out.print("<form action=\"\SFCookie\" method=get>");
		out.print("income for this year <input type=text name=income> <BR>");
		out.print(" Tax<input type=text name=tax>");
		out.print("<br><br> <BR><BR><input type=submit  value = submit>");
		out.print("</form></font></body></html>");
		out.close();
    }
}
