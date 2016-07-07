<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
  </head>

  <body>
    <table width="500"
      border="0" cellspacing="0" cellpadding="0">
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

    <html:form action="/EditEmployee"
      name="employeeForm"
      type="com.wiley.EmployeeForm"
      scope="request" > 
      <table width="500" border="0">
        <tr>
          <td><bean:message key="app.username" />:</td>
          <td><html:text property="username" /></td>
          <td><bean:message key="app.password" />:</td>
          <td><html:password property="password" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.name" />:</td>
          <td><html:text property="name" /></td>
          <td><bean:message key="app.phone" />:</td>
          <td><html:text property="phone" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.email" />:</td>
          <td><html:text property="email" /></td>
          <td><bean:message key="app.department" />:</td>
	  <td>

	    <html:select property="depid" size="1">
              <html:option value="1">
	        <bean:message key="app.administration" />
	      </html:option>
              <html:option value="2">
	        <bean:message key="app.network" />
	      </html:option>
              <html:option value="3">
	        <bean:message key="app.sales" />
	      </html:option>
              <html:option value="4">
	        <bean:message key="app.engineering" />
	      </html:option>
            </html:select>
          
          </td>
        </tr>
        <tr>
          <td><bean:message key="app.role" />:</td>
	  <td>

	    <html:select property="roleid" size="1">
              <html:option value="1">
	        <bean:message key="app.manager" />
	      </html:option>
              <html:option value="2">
	        <bean:message key="app.employee" />
	      </html:option>
            </html:select>
          
          </td>
          <td colspan="2" align="center">
	    <html:submit />
	    <html:cancel />
	    <html:reset />
	  </td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
