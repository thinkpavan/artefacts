<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example on jsp page directive
in this example we will show some of the page directives. Page directive can be kept
at any part of the file but it would be better to place it at the begining of the file.
-->

<%@ page info=" This directive is used to give information about the page" %>
<%@ page language="unknown"%>
<!-- we need not include this since java is assumed to be the default language, buit
this is primarily intended to allow tool vendors to provide support for other languages
also. (microsoft asp uses the same thing).

Below is the directive to import a class.
--->
<%@ page import="java.util.Date"%>
<HTML>
<HEAD>
<TITLE>First Jsp Example</TITLE>
</HEAD>

<BODY>
<H2>Hello World</H2>
	Date :: <%=new Date()%> 
<br><br> Date is generated by using an expression in jsp file <br><br>
	This file is generated by INteSolv Students. <br><br><br>
Thanks for visiting us !!!!
</BODY>
</HTML>