import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class InboxServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        HttpSession session=req.getSession(false);
       out.println("<html><body bgcolor=red><font color=yellow size=6>");
        if(session!=null){
        String uname=(String)session.getAttribute("user");
        String passwd=(String)session.getAttribute("pass");
        out.println("Uname="+uname);
        out.println("Passwd="+passwd+"<br>");
        out.println("<a href=http://localhost:8080/examples/servlet/LogOutServlet> Log Out</a>");
        }
        else{
                out.println("Please Log in First");
        }
        

        out.println("</font></body></html>");
}
}
