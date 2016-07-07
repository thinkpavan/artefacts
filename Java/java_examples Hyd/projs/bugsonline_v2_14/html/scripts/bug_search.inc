<%
If request.form("txtType") <> "" or InStr(request.querystring("txtType"), "GO_LINK") <> 0 Then


REM//		Processes form if user presses submit
REM//		button	
%>


<!-- #include file="process_bug_search.inc" -->


<% Else %>


<!-- #include file="header.inc" -->

<!-- #include file="bug_search_form.inc" -->


<% 
End If
%>