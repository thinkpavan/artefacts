/* To demonstrate the use of Servlet Context
* Author : Team -J
* Version : 1.0
*/
package net.inet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class STwo extends HttpServlet
{ 
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	PrintWriter		out;
	FileWriter fr;
	ServletContext sc;
	String data="FROM STWO\n";
	sc = getServletContext();
	fr = (FileWriter) sc.getAttribute("anyname");
	fr.write(data,0,data.length());
	fr.flush();
	// set content type and other response header fields first
        response.setContentType("text/html");

	// then write the data of the response
	out = response.getWriter();
	
      out.println("<HTML><HEAD><TITLE>");
	out.println(" This output is generated from a Servlet");
	out.println("</TITLE></HEAD><BODY>");
	out.println(" Hi This is from STwo ");
	out.println("</BODY></HTML>");
	out.close();
    }

public void init(){
	log("In init of two");
}
}
