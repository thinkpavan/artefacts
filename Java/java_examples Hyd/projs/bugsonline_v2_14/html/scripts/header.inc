<CENTER>

<TABLE WIDTH=100% BORDER=0>



<% REM//	This table contains the BUG and Project logos as well
   REM//	as a banner text%>

<TR WIDTH=100% ALIGN=CENTER>


<% REM//	Spacer Column %>

<TD WIDTH=10 ROWSPAN=2>

&nbsp;

</TD>


<% REM//	Bugs Online Logo %>

<TD ALIGN=LEFT WIDTH=70 HEIGHT=70 ROWSPAN=2>
<IMG BORDER=0 SRC="images/projects/bugs.gif" BORDER="0" NAME="Bugs_Online" ALT="click here to exit to login screen..." HEIGHT=70 WIDTH=70><BR>
<A HREF="index.asp">
<FONT FACE="Verdana, Arial" SIZE=0><LEFT><IMG SRC='./images/reports/space.gif' HEIGHT=1 WIDTH=11 ALIGN=BOTTOM BORDER=0>[Logoff]</LEFT></FONT>
</A>

</TD>

<TD>


<% 
'Announcement appears here...


If iBug_Type = 15 Then
%>


<!-- #include file="show_news.inc" -->


<% 
Else

	response.write "&nbsp;"

End If
%>


</TD>


<% REM//	Project Logo %>

<TD ALIGN=RIGHT WIDTH=70 HEIGHT=70 ROWSPAN=2>


<%
REM//		Determine rather or not image
REM//		exists for this project

If request("lstProject") = "" or request("lstProject") = "No Criteria" Then 


On Error resume next
set objText = createobject("Scripting.FileSystemObject")
set objImage = objText.OpenTextFile(request.ServerVariables("APPL_PHYSICAL_PATH") & "\images\projects\" & session("sProject") & ".gif", , True)
sImage = objImage.ReadAll
objImage.close
objText.close

If imgTitle1 <> "" Then
	imgMessage = ": " & session("sProject")
	imgTitle1 = session("sProject")
Else
	imgMessage = ": Management"
	imgTitle1 = "management"
End If

Else 


On Error resume next
set objText = createobject("Scripting.FileSystemObject")
set objImage = objText.OpenTextFile(request.ServerVariables("APPL_PHYSICAL_PATH") & "\images\projects\" & request("lstProject") & ".gif", , True)
imgTitle1 = objImage.ReadAll
objImage.close
objText.close

If imgTitle1 <> "" Then
	imgMessage = ": " & request("lstProject")
	imgTitle1 = request("lstProject")
Else
	imgTitle1 = "management"
End If

End If


'Bugs Online Image
If imgTitle1 = "Bugs Online" Then imgTitle1 = "bugs"

%>

<IMG BORDER=0 SRC="images/projects/<% = imgTitle1 %>.gif" BORDER="0" ALT="<% = "Bugs Online Project" & imgMessage %>" HEIGHT=70 WIDTH=70><BR>
<A HREF='#' onClick='javascript: window.history.back ()'>
<FONT FACE="Verdana, Arial" SIZE=0><RIGHT>[<-Back]<IMG SRC='./images/reports/space.gif' HEIGHT=1 WIDTH=11 ALIGN=BOTTOM BORDER=0></RIGHT></FONT>
</A>

</TD>


<TD WIDTH=10 ROWSPAN=3>

&nbsp;

</TD>


</TR>


<% REM//	Page Banner %>

<TR HEIGHT=35 VALIGN=BOTTOM WIDTH=100% ALIGN=CENTER>


<TD ALIGN=CENTER>
<B><FONT FACE="Verdana, Arial" COLOR="#000000" SIZE=2>


<% If imgTitle <> "" Then %>

<IMG SRC="images/banners/<% = imgTitle %>.gif" BORDER="0" NAME="Bugs_Online" ALT="" ALIGN="absmiddle">

<% End If %>


<%=sMessage %>

</FONT></I></B>
</TD>

</TR>


</TABLE>

</CENTER>