import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import  java.util.*;
import  database.ProductServlet;
import  database.ProductDetails;
import  database.Product;
public  class   DescriptionServlet  extends  HttpServlet
{
 public  void  doGet(HttpServletRequest  req,HttpServletResponse res)
 {
    try
    {
      HttpSession  session=req.getSession(true);
      //if there is exisinting session returns values
      Hashtable   trolley=(Hashtable)session.getValue(session.getId());
      System.out.println("Session Id "+session.getId());
      //creates new session
      if(trolley==null)
      {
       trolley=new  Hashtable();
       session.putValue(session.getId(),trolley);
       System.out.println(session.getValue(session.getId()));
      }
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      out.println("<html><head><title>DescriptionServlet</title><meta  name=\"sess\"  value=\"SessionServlet\"><body bgcolor=lightyellow>"+
      "<font size=5 color=blue><center>Description</center></font>");
      ProductServlet   prodServlet=(ProductServlet)getServletConfig().getServletContext().getServlet("database.ProductServlet");
      String prod=req.getParameter("prod");
      System.out.println("des"+prod);
         out.println("<font size=5 color=red><b><i>"+
         prodServlet.getItemDetails(prod).getDescription()+"</i></b>");

     }catch(Exception e){e.printStackTrace();}
  }
}
