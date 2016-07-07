
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class  CookieServlet extends HttpServlet 
{
	
    String name1 = null;
	
	private String getCurrentUser(String value) 
	{ 
	    String username = null;
		if (value.equals("564XX892"))
		{
		    username = name1; 
		}        
        return username;
     }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException 
   { 
       int i = 0;
       Cookie[] cookieList = req.getCookies();
	   
	   String user = null;
	   String responseString = null;
	   String name = null;

	   name1 = req.getParameter("data");
	   
	   if ( cookieList != null) 
	   {
	      for (int x=0 ; x < cookieList.length ;  x++) 
		  {
		      name = cookieList[x].getName();

			  if (name.equals("session_id"))  
			  {
			     user = getCurrentUser(cookieList[x].getValue());
				 break;
			  }
	      }
	   }

	   if (user == null)
	   {
	      res.addCookie(new Cookie("session_id","564XX892"));
	  responseString = new String ("<font color=blue size=4><b>Welcome to our site ,we have created a session for you</b></font>");
		  
       } else { 
	       responseString = new String("<font color=red size=3><b>Hello : " + user + "</b></font>");
		  
       }

	   res.setContentType("text/html");
	   PrintWriter out = res.getWriter();
	   out.println("<html>");
       out.println("<head><title> Cookie Example </title></head>");
       out.println("<body>");
	   out.println(responseString);
	   out.println("</body></html>");
	   out.close();
  }
  public String getServletInfo() { 
     return "CookieServlet Information";
  }
}

