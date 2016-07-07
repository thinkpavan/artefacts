<%@page import="HelloBean"%>
<jsp:useBean id="Hello" scope="session" class="HelloBean" />
<jsp:setProperty name="Hello" property="*" />
<html>
<body><title>JspBean Demo</title>

<h1> Getting Using getProperty tag</h1>

<h2>Name<jsp:getProperty  name="Hello" property="name" /></h2>
<h2>ID<jsp:getProperty  name="Hello" property="id" /></h2>

<h1> Getting Using Expression tag</h1>

<h2>Name=<%=Hello.getName()%>
<h2>Number=<%=Hello.getId()%>
</body>
</html>
