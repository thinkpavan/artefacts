/* If the user is not logged in send login form otherwise send appropriate form.
Author : Team -J
Version: 1.0
*/


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter
{

    private FilterConfig f = null;
    private ServletContext sc = null;

    public void init(FilterConfig filterConfig)
    {
        f = filterConfig;
	  sc = f.getServletContext();
    }

    public void doFilter(ServletRequest request, 
                         ServletResponse response, 
                         FilterChain chain)
        throws IOException, ServletException
    {
	  java.lang.Boolean isAuth=null;
	  HttpServletRequest hreq = (HttpServletRequest) request;
	  String login_page="/login";
	  String un = hreq.getParameter("uname");
	  String pwd = hreq.getParameter("pwd");
	  sc.log("in filter :"+hreq.getRequestURI());
	  sc.log("in filter :"+hreq.getServletPath());
        HttpSession session = hreq.getSession(true);
	  isAuth = (Boolean)session.getAttribute("canaccess");
		sc.log("uname = " + un + "password = " + pwd +" isauth = " + isAuth);
	  if(isAuth != null){
			sc.log("already authenticated");
			chain.doFilter(request,response);
			return;
	  }
	  if(isAuth == null && un !=null && pwd !=null){
		/* here is the code to check for uname/pwd */
		sc.log("user identified trying to set the information in session");
		session.setAttribute("canaccess",(Boolean)new Boolean(true));
		chain.doFilter(request,response);
		return;
        }else{
		    sc.log("Trying to forward request to login page");
                sc.getRequestDispatcher(login_page).forward(request, response);
		    sc.log("after forwarding request to login page");
                return;
        }        
    }
    
    public void destroy()
    {
        f=null;
    }

}

