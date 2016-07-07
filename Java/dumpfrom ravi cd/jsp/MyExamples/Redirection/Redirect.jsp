<html>
<head>
<body>
<h1> Data From First Page </h1>
<%
	response.setStatus(301);
	response.setHeader("location","http://localhost:8080/app.jsp");
%>


<h2> This is The Conetent after the Redirection </h2>
</body></head></html>

