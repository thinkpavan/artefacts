/* Shows how to store client state by using cookies
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class SHid extends HttpServlet
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
String income = request.getParameter("income");
String tax = request.getParameter("tax");
String name = request.getParameter("name");
String fname= request.getParameter("Fname");
// here we can use jdbc to store the values in database


	out.print("<html>   <head>     <title>Income tax details</title>");
	out.print("  </head>  <body bgcolor=#ffffff>"); 
	out.print("Thanks for submitting income tax form<br>");
	out.print(" following information is stored in our database");
	out.print(income+"<br>"+ tax +"<br>" +name+"<br>"+fname+"<br>");

	out.print("</body> </html>");
	out.close();
    }
}
