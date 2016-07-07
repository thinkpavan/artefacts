<!--
 Copyright 2003 Chris Schalk
 All rights reserved
-->

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %> 

<f:loadBundle basename="jsflogin.Resources" var="jsfloginBundle"/>

<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>JSF Login Sample Application</title>
<link href="css/jdeveloper.css" rel="stylesheet" media="screen"/>
</head>

<body bgcolor="#FFFFFF">
<f:view>
<H2><h:output_text  value="#{jsfloginBundle.bannerLabel}" /></H2>


<h:form id="loginForm">

<table width="50%" border="1" cellspacing="2" cellpadding="2">
  <tr>
    <td><h:output_text value="#{jsfloginBundle.useridLabel}" /></td>
    <td><h:input_text id="userid" size="15" required="true" value="#{LoginServer.userid}" >  <f:validate_length minimum="4" maximum="7" /></h:input_text>  <h:messages id="errors1" for="userid"/>  </td>
  </tr>
  <tr>
    <td><h:output_text  value="#{jsfloginBundle.passwordLabel}"  /></td>
    <td><h:input_secret id="password" size="15" required="true" value="#{LoginServer.password}" ><f:validate_length minimum="4" maximum="7" /></h:input_secret> <h:messages id="errors2" for="password"/> </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td> 
        
    <h:command_button id="submit" action="#{LoginServer.loginAction}" value="#{jsfloginBundle.loginSubmitLabel}"></h:command_button>


    </td>
  </tr>
</table>
	
	
</h:form>
</f:view>

</body>
</html>
