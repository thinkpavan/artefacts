<%@page session="true"%>
<htmL>
<head>
<%
	String str1=(String)request.getParameter("no1");
	String str2=(String)request.getParameter("no2");
	session.putValue("no1",str1);
	session.putValue("no2",str2);
	int i=Integer.parseInt(str1);
	int j=Integer.parseInt(str2);	
	
%>
	The Result is <%= i+j %>
<form action="http://localhost:8080/Ses2.jsp">
<input type=submit value="mul">
</form>
</head>
</html>

