import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import  java.util.*;

public  class   RegisterServlet  extends  HttpServlet
{
Hashtable   trolley;
PrintWriter out;
 public  void  doGet(HttpServletRequest  req,HttpServletResponse res)
 {
    try
    {
      HttpSession  session=req.getSession(true);
      trolley=(Hashtable)session.getValue(session.getId());
      System.out.println("Session Id "+session.getId());
      if(trolley==null)
      {
       trolley=new  Hashtable();
       session.putValue(session.getId(),trolley);
      }
      res.setContentType("text/html");
      out=res.getWriter();
      out.println("<html><head><title>RegisterServlet</title>"+
      "<meta http-equiv=\"refresh\" content=\"5;url="+res.encodeUrl("/servlet/SessionServlet")+";\"></head>"+
      "<body bgcolor=\"lightyellow\">"+
      "<center>Register Servlet</center>");
      printTrolley(trolley.elements());
      out.println("</body></html>");
      out.close();
      session.invalidate();
      out.println("<center><font size=5 color=red>This Page automatically resets after 5 secs</font></center>");
    }catch(Exception e){e.printStackTrace();}
 }
  public  void  printTrolley(Enumeration enum)
  {
     while(enum.hasMoreElements())
     {
      out.println("<font color=red size=5>"+enum.nextElement()+"</font><br>");
     }
  }
}
