import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import  java.util.*;
import  database.ProductServlet;
import  database.ProductDetails;
import  database.Product;
public  class   ProductSessionServlet  extends  HttpServlet
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
      out.println("<html><head><title>SessionServlet</title><meta  name=\"sess\"  value=\"SessionServlet\"><body bgcolor=lightyellow>"+
      "<font size=5 color=blue><center>Welcome to  Out ABC Shoppers</center></font>");
      String  prod=req.getParameter("Buy");
      ProductServlet   prodServlet=(ProductServlet)getServletConfig().getServletContext().getServlet("database.ProductServlet");
      if(prod!=null)
      {
         out.println(prod);
         out.println(prodServlet.getItemDetails(prod));
         out.println("<font size=5 color=red><b><i>You just select "+
         prodServlet.getItemDetails(prod).getName()+"from your shopping cart</i></b>");
         trolley.put(prod,prodServlet.getItemDetails(prod).getProdId());
      }
      out.println("<table  bgcolor=\"trendz\" border=2 cellpadding=5 cellspacing=3 align=center>");
      out.println("<th>Product</th><th>Click to choose</th>");
      Product[] prodArray=prodServlet.getSortedItems();
      for(int i=0;i<prodArray.length;i++)
      {
          out.println("<tr>");
          String  prodid=prodArray[i].getProdId();
          out.println("<td><a href=\""+res.encodeUrl("/servlet/DescriptionServlet?prod="+prodid)+
          "\"><strong>"+prodArray[i].getName()+"</strong></a>");
          out.println("<td>"+prodArray[i].getPrice());
          out.println("<td><a href=\""+res.encodeUrl("/servlet/ProductSessionServlet?Buy="+prodid)+
          "\"><strong>BUY</strong></a>");
          out.println("</tr>");      
      }
       out.println("</table>");
       out.println("<br><a href=\""+res.encodeUrl("/servlet/RegisterServlet/")+
       "\"><strong>Register</strong></a>");

      out.close();
    }catch(Exception e){e.printStackTrace();}
 }

}
