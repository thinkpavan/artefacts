<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example on how to use java beans to write business logic
-->

<%@ page info=" This directive is used to give information about the page" %>
<%@ page language="java"%>
<%@ page errorPage="errpage.jsp"%>
<%@ page import="ourpack.*"%>
<HTML>
<HEAD>
<TITLE>UseBean Example</TITLE>
</HEAD>


<BODY>
<H2>shows how to use java bean from jsp</H2>
<!-- Check the output servlet generated by the jsp engine to see what happens 
under the hood.
id is the name of the bean , scope can be application,session page and
class is the name of the java bean class.
-->

	<jsp:useBean id="beanvar" scope="session" class="ourpack.ourbean" />

   <% 
	out.println(" We will set the property of bean to 10 now <br>");
	beanvar.setProp1(10);
	out.println(" property stored in bean = "+ beanvar.getProp1()+"<br>");
	out.println(" out put of method on bean ="+ beanvar.someMethod(22));
	
    %>	
	<br>This file is generated by INteSolv Students. <br><br><br>
Thanks for visiting us !!!! <br><br>

<%@ include file="copyright.html" %> 

</BODY>
</HTML>