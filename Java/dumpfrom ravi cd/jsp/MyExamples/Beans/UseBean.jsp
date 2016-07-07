<%@page import="test.UseBean" %>
<jsp:useBean id="bean" class="test.UseBean" scope="session"/>
<jsp:setProperty name="bean" property="uname" value="prasad"/>
Validate::<jsp:getProperty name="bean" property="uname"/>


