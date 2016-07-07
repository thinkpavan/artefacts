/* Shows details of using init parameters
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Init extends HttpServlet
{ 
	PrintWriter		out;

    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {
	out = response.getWriter();

	Enumeration e = getInitParameterNames(); //this is a method on config
	String paramname;
	for(int i = 0 ; e.hasMoreElements();i++){
		paramname = (String) e.nextElement() ;
		out.println( getInitParameter(paramname));
	}

	out.println(" This output is generated from Init  Servlet");
	out.close();
    }
 public  void init(ServletConfig config) throws ServletException{
// commet the below stmt and see
	super.init(config);// this has to be called so that config object 
		//is available or other methods also
	// here you can carry out initialization tasks.
 }


}
