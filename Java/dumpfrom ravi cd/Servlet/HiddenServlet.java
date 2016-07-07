import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.io.*;
import  java.util.*;

public class HiddenServlet extends HttpServlet { 
        
        public void init(ServletConfig config) throws ServletException { 
                          super.init(config);
         } 
public void doGet (HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException { 
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<html>"); 
out.println("<head><title> Example </title></head>");
out.println("<body>");
String name = req.getParameter("user");
out.println("Hi !!! " + name + " welcome again ..");
out.println("</body></html>");
out.close();                      
          }           
 public void doPost (HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException { 
 res.setContentType("text/html");
 PrintWriter out = res.getWriter();
 out.println("<html>"); 
 out.println("<head><title> Example </title></head>");
 out.println("<body>");
 out.println("<form action=http://localhost:8080/servlet/HiddenServlet method=GET>");
 String name = req.getParameter("name");
 out.println("<h2>" + name + " , your selected movies are : </h2>" );
 String [] pmt = req.getParameterValues("checkbox");                            
 for(int i=0; i < pmt.length ; i++) { 
                        
  out.println("<b><i>" + pmt[i]  +"</i></b><br>");
    }
  out.println("<input type=checkbox name=user value= " + name + " >");
  out.println("<input type=submit name=submit value=click>");
  out.println("</body></html>");
  out.close();
            }

           public String getServletInfo() { 
                    return "Example Information";
           }
            
      }
         
