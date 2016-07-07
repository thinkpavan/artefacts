<html>
<body>
<%@ page import="java.sql.*" %>
<%@page import="oracle.jdbc.driver.*" %>
	<%! int colcount,c; %>
<%
      try
      {
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      out.println("Connecting to Oracle<br>");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.2:1521:tit","scott","tiger");;
      out.println("Connected to Oracle<br>");
      String url="select  empno,ename,job,sal,deptno from emp";
      PreparedStatement stmt=con.prepareStatement(url);
      ResultSet rs=stmt.executeQuery();
      ResultSetMetaData  rsmd=rs.getMetaData();
      colcount=rsmd.getColumnCount();
      c=1;
%>

    <table  bgcolor=lightyellow align=center cellpadding=5 cellspacing=5 border=2>

<%      while(c<=colcount)
      {%>
	<th>
      <%
	out.println(rsmd.getColumnName(c));
	%>
	</th>
      <%
	c++;
      }
	
	while(rs.next())
      {%>
	<tr>
	<%
        c=1;
        while(c<=colcount)
        {
	%>
	<td>
	<%
         out.println(rs.getString(c));
         c++;
        }%>
	</tr>
     <% }
        rs.close();
        con.close();
      }catch(Exception e){e.printStackTrace();}
	%>
</body>
</html>