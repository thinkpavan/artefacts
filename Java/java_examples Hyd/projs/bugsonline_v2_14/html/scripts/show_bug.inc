<% REM//	Show Bug Header %>

<!-- #include file="show_bug_header.inc" -->



<% REM//	If unable to locate bug

If iStop = 5 Then 
	
	imgTitle = "banner_8_2"
	sMessage = ""
%>

<!-- #include file="request_bug_id.inc" -->


<% 
Else 


REM//	Show Bug Details 
%>

<!-- #include file="show_bug_detail.inc" -->


<% End If %>