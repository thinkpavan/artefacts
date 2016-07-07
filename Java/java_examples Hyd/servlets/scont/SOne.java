/* To demonstrate the use of Servlet Context
* Author : Team -J
* Version : 1.0
*/
package com.inet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class SOne extends HttpServlet
{ 
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	PrintWriter		out;
	FileWriter fr;
	String cname,address;
	ServletContext sc;
	String data="FROM SONE\n";
	sc = getServletContext();
	fr = (FileWriter) sc.getAttribute("anyname");
	fr.write(data,0,data.length());
	fr.flush();
	cname = sc.getInitParameter("cn");
	address = sc.getInitParameter("addr");
	
	// set content type and other response header fields first
        response.setContentType("text/html");

	// then write the data of the response
	out = response.getWriter();
	
      out.println("<HTML><HEAD><TITLE>");
	out.println(" This output is generated from a Servlet");
	out.println("</TITLE></HEAD><BODY>");
	out.println(" Hi This is from SOne <br>");
	out.println("value of param cn = " +cname+"<br><br>");
	out.println("value of param addr = " +address+"<br><br>");

	out.println("</BODY></HTML>");
	out.close();
    }
public void init(){
	try{
		log("From init of one");
		ServletContext sc = getServletContext();
		FileWriter f = new FileWriter("scontext.txt");
		sc.setAttribute("anyname",f);//store the file ref in app object.
	}catch(Exception e){}
}

}
