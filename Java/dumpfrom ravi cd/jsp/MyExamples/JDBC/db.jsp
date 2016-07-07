<html>
<body>


<%@ page import="java.sql.*,java.io.*" autoFlush="true" %>


<%!
   Connection con;
   Statement st;
   public void jspInit()
     {
       try
        {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:mysql","sa","");
        st = con.createStatement();
        } catch(Exception e)
            {
	    }
     }	
%>


<%
    try
     {
       ResultSet rs = st.executeQuery("select * from emp");
       while(rs.next())
         {
              out.println("<h1>" + rs.getString(1) + "</h1>");
         }

     } catch(Exception e) 
        {
             out.println(e);
        }       
%>

</body>
</html>