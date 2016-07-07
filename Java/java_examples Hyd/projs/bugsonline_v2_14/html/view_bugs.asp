<%
REM// Global variables: 
REM//	useSMTP determines rather or not to use emails. You must have the SMTP module as described in the readme for this to work
REM//	returnEmail is the return email address to use when sending emails
REM//	smtpServer is the SMTP server to send the email through. The default is the server on which this system is running

Dim useSMTP
Dim returnEmailAddress
Dim smtpServer
useSMTP=false
returnEmail="DONOTREPLY@busonline.sourceforge.net"
smtpServer="localhost"

REM//		Checks for user authorization
%>

<!-- #include file="scripts/bug.inc" -->


<%
REM//		Check if not opened within proper frame

If InStr(request.servervariables("HTTP_REFERER"), "index.asp") = 0 And InStr(request.servervariables("HTTP_REFERER"), "change_password.asp") = 0 _ 
And request.querystring("iBug_ID") = "" AND request.querystring("iBT") = ""  AND session("Authorized") <> "True" Then
	response.write request.querystring
	session("sLogin_Error") = request.servervariables("HTTP_REFERER")
	session("sRedirect") = "index.asp"
	response.redirect "destroy_frame.asp"
End If
%>


<%
REM//		Establishes variables and evaluates type of page to create
%>

<!-- #include file="scripts/evaluate_page.inc" -->


<HTML>


<HEAD>
<TITLE>Bugs Online  :  <%=sPage_Type %></TITLE>

<STYLE TYPE="text/css">
<!--
A:link { text-decoration: none; }, A:visited { text-decoration: none }
A:hover { text-decoration: underline; color: #FF0000}
-->
</STYLE>

</HEAD>


<BODY BACKGROUND="images/background_folder.gif" LINK="#800080" VLINK="#800080" HLINK="#800080">


<SCRIPT LANGUAGE="JavaScript">


<% REM//		This script opens help window %>

function open_help(sPage, iHeight, iWidth)
{

var x = Math.round(Math.random() * 100) % 1000 + 1;
var sPage_Type = 'toolbar=no,directories=no,Scrollbars=Yes,resizable=No,width=' + iWidth + ',height=' + iHeight;
newwindow = window.open(sPage,x,sPage_Type);

}

 

<% REM//		This script changes project image if none exists
   REM//		for login project
%>

function change_image(loc, img)
  {
	loc.src = img;
  }


</SCRIPT>





<%
REM//			Standard bug pages (New Bugs, Top Bugs, etc.)
REM//			Show Bug Headers According to sql statement

If (iBug_Type <= 7 And iBug_Type <> 2) or iBug_Type = 15 or iBug_Type = 16 Then
%>
	

<!-- #include file="scripts/header.inc" -->

<%
if iBug_Type = 7 then
%>

<!-- #include file='scripts/user_report_form.inc' -->

<%
end if
%>

<!-- #include file="scripts/show_bugs.inc" -->


<%
Else


REM//			Other Site pages



Select Case iBug_Type


	REM//		Top Bugs
	Case 2
	%>
	

<!-- #include file="scripts/header.inc" -->

<!-- #include file="scripts/top_bugs.inc" -->


	<%
	REM//		Bug Detail
	Case 8
	%>
	

<!-- #include file="scripts/bug_detail.inc" -->

	
	<%
	REM//		Bug Search
	Case 9
	%>

	
<!-- #include file="scripts/bug_search.inc" -->
	
	
	<%
	REM//		Submit Bug
	Case 10
	%>
	
	
<!-- #include file="scripts/submit_bug.inc" -->
	
	
	<%
	REM//		Site Admin
	Case 11
	%>
	
	
<!-- #include file="scripts/site_admin.inc" -->


<%			
End Select

End If 
%>


</BODY>


</HTML>