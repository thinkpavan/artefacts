<HTML>


<HEAD>
<TITLE>Exit Bugs Online</TITLE>
</HEAD>


<% If InStr(request.servervariables("HTTP_USER_AGENT"), "Mozilla/3.04") <> 0 or InStr(request.servervariables("HTTP_USER_AGENT"), "Mozilla/4.0") <> 0 or InStr(request.servervariables("HTTP_USER_AGENT"), "Mozilla/4.05") <> 0 Then %>


<SCRIPT LANGUAGE="JAVASCRIPT">

function go_back() {
	document.frmLog_Off.submit();
}


</SCRIPT>


<BODY
	onLoad="go_back()" BGCOLOR="#000000">


<% Else %>


<BODY BGCOLOR="#FFFFFF">


<% End If %>


<P>
<A HREF="<%=session("sRedirect") %>" TARGET="_top">If your page does not automatically exit, please click here...</A>
</P>


<FORM NAME="frmLog_Off" METHOD="get" ACTION="<%=session("sRedirect") %>" TARGET="_top">
	<INPUT TYPE=HIDDEN NAME="">
</FORM>


</BODY>


</HTML>


<% 
If request.querystring("iSame_Page") = 1 Then 
	session("sRedirect") = "Yes" 
Else
	session("sRedirect") = "No"
End If
%>