<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
<head>
<title><bean:message key="page.title"/></title>
<html:base/>
</head>
<body bgcolor="white">

<logic:notPresent name="InputPageForm">
    <logic:redirect href="/form.jsp" />
</logic:notPresent>
<h2>Following data is stored in the database</h2>
<b>First name: </b><bean:write name="InputPageForm" property="fname"/><br/>
<b>Last name: </b><bean:write name="InputPageForm" property="lname"/><br/>
</body>
</html:html>
