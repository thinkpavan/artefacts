import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.io.*;

public class  ListCookies  extends   HttpServlet
{
   public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
        res.setContentType("text/html");
        PrintWriter  out=res.getWriter();
        out.println("<html><body bgcolor=lightyellow>");
        Cookie[] cookie=req.getCookies();
        out.println("<table border=2 cellpadding=3 cellspacing=3 align=center>"+
        "<th>Name</th><th>Value</th><th>Age</th>");
        for(int ctr=0;ctr<cookie.length;ctr++)
        {
            out.println("<tr>");
            out.println("<td>"+cookie[ctr].getName());
            out.println("<td>"+cookie[ctr].getValue());
            out.println("<td>"+cookie[ctr].getMaxAge());
   //         out.println("<td>"+cookie[ctr].getDomain());
            out.println("<td>"+cookie[ctr].getPath());
            out.println("</tr>");
        }
         out.println("</table></body></html>");
          out.close();
   }

}
