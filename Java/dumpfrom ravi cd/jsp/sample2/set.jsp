<jsp:useBean id="myb" class="mybeans.mybean" scope="session" />

<%
String rname=request.getParameter("hname");
int rsal=Integer.parseInt(request.getParameter("hsal"));
%>


<jsp:setProperty name="myb" property="myname" value="<%=rname%>"/>
<jsp:setProperty name="myb" property="mysal" value="<%=rsal%>"/>

<jsp:getProperty name="myb" property="myname"/>
<jsp:getProperty name="myb" property="mysal"/>

<%="This is from Setjsp Page"%>

