<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<logic:notPresent name="USER">
  <logic:forward name="login" />
</logic:notPresent>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
  </head>
  <body>

    <table width="650"
      border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="7">&nbsp;</td>
      </tr>
      <tr bgcolor="#36566E"> 
        <td  colspan="7" height="68" width="48%"> 
          <div align="left">
            <img src="images/hp_logo_wiley.gif"
	      width="220" height="74">
          </div>
        </td>
      </tr>
      <tr>
        <td colspan="7">&nbsp;</td>
      </tr>
    </table>

    <html:errors />

    <table width="650"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th><bean:message key="app.username" /></th>
        <th><bean:message key="app.name" /></th>
        <th><bean:message key="app.phone" /></th>
        <th><bean:message key="app.email" /></th>
        <th><bean:message key="app.department" /></th>
        <th><bean:message key="app.role" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="employee" name="employees">
	<tr align="left">
	  <td>
            <bean:write name="employee" property="username" />
	  </td>
	  <td>
            <bean:write name="employee" property="name" />
	  </td>
	  <td>
            <bean:write name="employee" property="phone" />
	  </td>
	  <td>
            <bean:write name="employee" property="email" />
	  </td>
	  <td>
            <bean:write name="employee" property="department" />
	  </td>
	  <td>
            <bean:write name="employee" property="rolename" />
	  </td>
	  <td>
            <a href="Edit.do?username=<bean:write name="employee"
	      property="username" />">Edit</a>
	    <a href="Delete.do?username=<bean:write name="employee"
	      property="username" />">Delete</a>
	  </td>
	</tr>
      </logic:iterate>
      <tr>
        <td colspan="7">
	  <hr>
	</td>
      </tr>
    </table>
    <font size="-1" face="arial">
      <a href="addemployee.jsp">Add New Employee</a>
    </font>

  </body>
</html>
