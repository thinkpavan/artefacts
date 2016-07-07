<%
REM//		If user not authorized to 
REM//		site administration

If session("sProject") <> "Management" and request.form("CustomReport") <> "true" Then
%>


<TABLE WIDTH="75%" BORDER="1" CELLSPACING="1" ALIGN=CENTER BGCOLOR="#807FFE">


<TR>

<TD WIDTH="85%" ALIGN=CENTER>
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#FFFFFF">
You are not authorized to access site administration with the current login...
</FONT></EM></B>
</TD>

</TR>


</TABLE>


<% 
Else 


If request.form("txtType") <> "" Then


REM//		Processes form if user presses submit
REM//		button	
%>


<!-- #include file="process_site_admin.inc" -->


<% Else %>


<!-- #include file="header.inc" -->

<!-- #include file="site_admin_form.inc" -->


<% 
End If

End If 
%>