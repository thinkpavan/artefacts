/* Shows details of using init parameters
* Author : Team -J
* Version : 1.0
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Welcome  extends HttpServlet
{ 
	PrintWriter		out;
	String cn="UNKNOWN";
	String addr="NOT EXISTING";
	String bgcolor="SOMECOLOR";
    public void doGet (
	HttpServletRequest	request,
	HttpServletResponse	response
    ) throws ServletException, IOException
    {

	out = response.getWriter();
	out.println(cn);
	out.println(addr);
	out.close();
    }
 public  void init(ServletConfig config) throws ServletException{
	String pval=null;
	super.init(config);
	pval=getInitParameter("cname");
	if ( pval != null)
		cn=pval;
	pval=null;
	pval=getInitParameter("address");
	if ( pval != null)
		addr=pval;
 }


}
