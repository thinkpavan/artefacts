<%@page session="true"%>
<head>
<%
	String str1=(String)session.getValue("no1");
	String str2=(String)session.getValue("no2");
	int i=(int)Integer.parseInt(str1);
	int j=(int)Integer.parseInt(str2);
%>
	The Result is <%= i/j %>
</head>
</html>

