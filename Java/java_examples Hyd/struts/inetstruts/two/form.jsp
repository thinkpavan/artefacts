<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html>
<head>
	<title>registration-form</title>
</head>
<body>
    <html:form action="/processinput.do">
        <h2>Input Form</h2>
        <html:errors />
	<b>First name:</b>
	<html:text property="fname" />
	<b>Last name:</b>
	<html:text property="lname" />
	<html:submit property="submit"/>
    </html:form>
</body>
</html:html>


