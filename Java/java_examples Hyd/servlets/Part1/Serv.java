/* Shows details of service method
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class Serv extends HttpServlet
{ 
// dangerous in some servlet exec environments !!!!!
	PrintWriter		out; // this data item may be corrupted as more
// than one method may be calling this at a time.
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	out.println(" This output is generated from a Servlet");
	out.println(" Hi This is from Serv Servlet ");
	out.close();
    }
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		out = res.getWriter();
		super.service(req,res);

            out.println("hai raja ");
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	//	super.service(req,resp);
	//	doGet(req,resp);
	out.println("..... This output is generated from a Servlet");
	out.println("..... Hi This is from Serv Servlet ");
	}


}
