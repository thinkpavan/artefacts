<% 
REM//		This script creates appropriate links
REM//		to other bugs
%>

<BR><BR>

<TABLE WIDTH="80%" BORDER="0" CELLSPACING="0" ALIGN=CENTER>


<TR>

<TD WIDTH="100%" ALIGN=CENTER>


<%
REM//		Creates links based on 
REM//		number of results from
REM//		search
%>

<B><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Page:
</FONT></B>


<%
iCreate_Links = 0
iCreate_Links_Link = 1


Do While iCreate_Links < iTotal_Results
%>

&nbsp;&nbsp;&nbsp;

<%
REM//		Current Link (will not be referenced)

If iCreate_Links = iStart_Display Then
%>


<B><FONT FACE="Arial" SIZE=3 COLOR="#000000">
<% = iCreate_Links_Link %>
</FONT></B>


<%
REM//		All other reference links

 
Else 

If request.querystring("iStart") = "" Then
	
	sLink = "view_bugs.asp?iBT=9&txtType=GO_LINK&iStart=" & iCreate_Links & "&" & request.form
	
Else

	sLink = "view_bugs.asp?iStart=" & iCreate_Links & "&" & request.querystring

End If

%>


<B><FONT FACE="Arial" SIZE=2 COLOR="#000000">
<A HREF="<% = sLink %>" TARGET="_self"><% = iCreate_Links_Link %></A>
</FONT></B>


<% 
End If


iCreate_Links = iCreate_Links + iShow_Display
iCreate_Links_Link = iCreate_Links_Link + 1


Loop
%>


</TD>

</TR>


</TABLE>