<!-- 
 In this example we will simply try to connect to oracle database
and fetch the employee records. If u like to see a properly formatted
output u can use html tables. we have simply pulled the code from
one of our jdbc examples.
-->
<%@ page import="java.sql.*"%>
<%@ page import="oracle.jdbc.driver.*"%>

<% 
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
// we have database running on same m/c so we have localhost here.

	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	System.out.println(con);
//	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from Emp");
	while(rs.next()){
		out.println(rs.getString(1));
		out.println(rs.getString(2));
		out.println(rs.getString(3));
		out.println(rs.getString(4));
		out.println("<br>===================================<br>");
	}
	con.close();
}catch(Exception e) { out.println(" exception occurred");}
%>

