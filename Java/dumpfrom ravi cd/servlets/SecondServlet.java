import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class SecondServlet extends HttpServlet{
Connection con=null;
public void init(){
        try{
                DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
                con=DriverManager.getConnection("jdbc:odbc:7am","system","manager");
        }catch(Exception e){}
}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        try{
        PreparedStatement pstmt=null;
        String sal=req.getParameter("sal");
        double salary=Double.parseDouble(sal);
        pstmt=con.prepareStatement("select eno,ename from emp where sal>?");
        pstmt.setDouble(1,salary);
        ResultSet rs=pstmt.executeQuery();
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        out.println("<html><body bgcolor=yellow><font color=red size=7> Welcome To Servlets</font>");
        while(rs.next()){
        out.println("Eno="+rs.getString(1)+"Ename="+rs.getString(2));
        }
        out.println("</body></html>");
        }catch(Exception e){

        }
}
}
