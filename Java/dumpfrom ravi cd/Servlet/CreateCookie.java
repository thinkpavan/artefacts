import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.io.*;

public  class  CreateCookie  extends  HttpServlet
{
   public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
           res.setContentType("text/html");
           PrintWriter  out=res.getWriter();
           out.println("<html><head><title>CreateCookie</title></head>"+
           "<body  bgcolor=lightyellow>"+
           "<form  action=\"http://localhost:8080/servlet/CreateCookie\"  method=\"post\">"+
           "Name<input type=text  name=\"user\"  size=10><br>"+
           "Value<input type=text  name=\"val\"  size=10><br>"+
           "Age<input type=text name=\"age\" size=5><br>"+
           "<input type=submit value=submit><input type=reset value=reset>"+
           "</form></body></html>");
   }
   public void  doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
           res.setContentType("text/html");
           PrintWriter  out=res.getWriter();
           out.println("<html><head><title>CreateCookie</title></head>"+
           "<body  bgcolor=lightyellow>");
           String p=req.getParameter("user");
           String p1=req.getParameter("val");
           int p2=Integer.parseInt(req.getParameter("age"));
           out.println(p+""+p1+""+p2);
           Cookie  cookie=new  Cookie(p,p1);
//           cookie.setMaxAge(p2);
//           cookie.setPath("/servlet/");
           res.addCookie(cookie);
           out.println("<font color=red size=5>Cookie added to browser</font></body></html>");
           out.close();
   }
}
