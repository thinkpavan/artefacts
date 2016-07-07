package tagpack;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.IOException;

public class DataTag extends TagSupport
{
   String table;
   String username;
   String password;
   String dsn;

   public void setTable(String table) {
       this.table = table;
     }
   public void setUsername(String username){
       this.username = username;
     }
   public void setPassword(String password){
       this.password = password;
     }
   public void setDsn(String dsn){
       this.dsn = dsn;
     }

   Connection con;
   PreparedStatement pst;
   ResultSet rs;
   ResultSetMetaData rmd;

   public int doStartTag() throws JspException{
      try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:"+dsn,username,password);
            pst = con.prepareStatement("select * from  "+table);

            return EVAL_BODY_INCLUDE;
       }catch(Exception e)
         {
          throw new JspException(e.getMessage());
         }
    }
   public int doEndTag() throws JspException
    {
      int i=1;
        try
         {
            rs = pst.executeQuery();
            rmd = rs.getMetaData();
            pageContext.getOut().print("<table border=1>");

            // Displaying Table Colun Names...

            pageContext.getOut().print("<tr>");
              for(i=1;i<rmd.getColumnCount();i++)
                 pageContext.getOut().print("<th>"+rmd.getColumnName(i)+"</th>");
            pageContext.getOut().print("</tr>");

            while(rs.next())
              {
             pageContext.getOut().print("<tr>");
              for(i=1;i<rmd.getColumnCount();i++)
                 pageContext.getOut().print("<td>"+rs.getString(i)+"</td>");
            pageContext.getOut().print("</tr>");
              }
           pageContext.getOut().print("</table>");
            return EVAL_PAGE;
         } catch(Exception e)
           {
            throw new JspException(e.getMessage());
           }
    }
}



