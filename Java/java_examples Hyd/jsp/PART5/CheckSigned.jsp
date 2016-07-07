<!-- 
This page is included in the jsp pages to make a check
on whether the user has signed in or not.
Show another place where we can use include tag
-->
<!-- here our technique is simple and straight forward for checking whether
the user has signed in or not, we have purposfully introduced a bug here,
rectify the bug
-->
<% 
 Boolean isloggedin = (Boolean)session.getValue("isloggedin");
	if (  isloggedin.booleanValue()!= true)
		throw new Exception(" You have to log on to see these pages");
%>

