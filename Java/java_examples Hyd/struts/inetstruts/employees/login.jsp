<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
  </head>

  <body>
    <table width="500" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr bgcolor="#36566E"> 
        <td height="68" width="48%"> 
          <div align="left">
            <img src="images/hp_logo_wiley.gif"
	         width="220"
		 height="74">
          </div>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>

    <html:errors />

    <html:form action="Login.do"
      name="loginForm"
      type="com.wiley.LoginForm" > 
      <table width="45%" border="0">
        <tr>
          <td><bean:message key="app.username" />:</td>
          <td><html:text property="username" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.password" />:</td>
          <td><html:password property="password" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><html:submit /></td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
