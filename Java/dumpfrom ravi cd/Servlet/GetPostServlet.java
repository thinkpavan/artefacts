import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.io.*;

public  class  GetPostServlet  extends  HttpServlet
{

 public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      out.println("<html><body>You have used GET METHOD</body></html>");
      out.close();
 }
 public  void  doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      out.println("<html><body>You have used POST METHOD</body></html>");
      out.close();
 }
}

