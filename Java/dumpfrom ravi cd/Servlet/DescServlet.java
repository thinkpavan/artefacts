import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.util.*;
import  java.io.*;

public  class  DescServlet  extends  HttpServlet
{
 Product prod;
 ShoppingCart cart;
public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
   try
   {
   HttpSession session=req.getSession(true);
   cart=(ShoppingCart)session.getValue(session.getId());
   System.out.println("Session Id "+session.getId());
   if(cart==null)
   {
   cart=new ShoppingCart();
   session.putValue(session.getId(),cart);
   System.out.println("Session Id "+session.getId());
   }
   res.setContentType("text/html");
   PrintWriter out=res.getWriter();
   String id=req.getParameter("id");
   ProductServlet  prod=(ProductServlet)getServletConfig().getServletContext().getServlet("ProductServlet");
   Product p=prod.getDetail(id);
   out.println("<font size=5 color=red><i>");
   out.println(p.getDescription());
   out.println("</i></font></body></html>");
   }catch(Exception e){e.printStackTrace();}
}
}

