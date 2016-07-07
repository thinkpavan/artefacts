<html>
<body>
<h3>JSP Example on Declaration ,Expression and Scriptlets </h3>
<%@page import="java.util.Date" %>
<%! int i; %>
<% for(i=0;i<10;i++){ %>
Date ::<%=new Date()%><br>
<%}%>
</body>
</html>
