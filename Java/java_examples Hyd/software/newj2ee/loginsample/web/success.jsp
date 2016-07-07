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
<H2><h:output_text value="#{jsfloginBundle.successLabel}" /></H2>

<p>&nbsp;</p>
<h:form id="successForm">

<table border="1">

 <tr>
  <td>Return button to Login Page with literal value</td>
  <td><h:command_button id="buttonback" action="return" value="Back to Login Page" /></td>
 </tr>

 <tr>
   <td>Return button to Login Page using label from resource bundle</td>
   <td><h:command_button id="buttonlabelback" action="return" value="#{jsfloginBundle.backLabel}"  /></td>
</tr>


</table>  

</h:form>
</f:view>


</body>
</html>
