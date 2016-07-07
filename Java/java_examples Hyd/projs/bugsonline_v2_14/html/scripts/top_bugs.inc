<% REM//	Script used to link user to bug search %>

<SCRIPT LANGUAGE="JavaScript">


function change_project(sProgram, sArea) 

{
	document.frmBug_Search.lstProgram.value = sProgram;
	document.frmBug_Search.lstArea.value = sArea;
	document.frmBug_Search.submit();
}


</SCRIPT>


<FORM NAME="frmBug_Search" ACTION="view_bugs.asp?iBT=9&txtType=GO_LINK" METHOD=POST>


<% 'Input Types for link to bug search %>

<INPUT TYPE="Hidden" NAME="lstProject" VALUE="<% =session("sProject")%>">
<INPUT TYPE="Hidden" NAME="lstProgram">
<INPUT TYPE="Hidden" NAME="lstArea">
<INPUT TYPE="Hidden" NAME="rdDetails" VALUE="None">
<INPUT TYPE="Hidden" NAME="iStart" VALUE="0">
<INPUT TYPE="Hidden" NAME="lstStatus" VALUE="Completed">
<INPUT TYPE="Hidden" NAME="lstStatus" VALUE="Closed">
<INPUT TYPE="Hidden" NAME="lstStatus" VALUE="Program Feature">
<INPUT TYPE="Hidden" NAME="chkStatus" VALUE="True">
<INPUT TYPE="Hidden" NAME="chkCurrent" VALUE="current">

<%
sBackground="card_top"
%>


<CENTER>

<TABLE WIDTH="95%" BORDER=0 CELLSPACING=0 CELLPADDING=0 ALIGN=CENTER>



<TR WIDTH=100% ALIGN=LEFT>


<TD BACKGROUND="images/card_border_top_left.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


<TD COLSPAN=2 BACKGROUND="images/card_border_top.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


<TD BACKGROUND="images/card_border_right.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>

</TR>


<TR ALIGN=LEFT BGCOLOR="#000000">

<TH ALIGN=LEFT WIDTH="34%" BACKGROUND="images/card_header_left.gif">

&nbsp;&nbsp;<IMG SRC="images/text/program.gif" BORDER=0 ALT="" ALIGN=absmiddle>

<FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
[Click to view program bugs]
</FONT>
</TH>

<TH ALIGN=LEFT WIDTH="33%" BACKGROUND="images/card_header.gif">

&nbsp;&nbsp;<IMG SRC="images/text/area.gif" BORDER=0 ALT="" ALIGN=absmiddle>

<FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
[Click to view bugs]
</FONT>
</TH>

<TH ALIGN=LEFT WIDTH="33%" BACKGROUND="images/card_header.gif">

<IMG SRC="images/text/reported_bugs.gif" BORDER=0 ALT="" ALIGN=absmiddle>

</TH>


<TD BACKGROUND="images/card_border_right.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp
</FONT></B>

</TD>


</TR>


<%
REM//			Open Database Connection

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

If rs.eof <> True Then

Do While rs.eof <> True

	If InStr(sAreas, "#" & rs("sArea") & "#") = 0 Or InStr(sPrograms, "#" & rs("sProgram") & "#") = 0 Then 

		sAreas = sAreas & "#" & rs("sArea") & "#"
		sPrograms = sPrograms & "#" & rs("sProgram") & "#"
		iArray_Size = iArray_Size + 1

		ReDim Preserve sAreas_a(iArray_Size)
		sAreas_a(iArray_Size) = rs("sArea")

		ReDim Preserve sPrograms_a(iArray_Size)
		sPrograms_a(iArray_Size) = rs("sProgram")
		
		ReDim Preserve iBugs_a(iArray_Size)
		iBugs_a(iArray_Size) = 1

	Else
	
		For x = 0 To iArray_Size
		
			If sAreas_a(x) = rs("sArea") And sPrograms_a(x) = rs("sProgram") Then
				
				iBugs_a(x) = iBugs_a(x) + 1
				x = iArray_Size
				
			End If
		
		Next

	End If
	rs.movenext

Loop


REM//			Close database connection

rs.Close
set rs.activeconnection=nothing
Conn.close


REM//			Determine Top 3 bug areas corresponding to project

For x = 0 To iArray_Size

	If iBugs_a(x) > iTop_Areas1_a(0) Then
	
		iTop_Areas1_a(2) = iTop_Areas1_a(1)
		iTop_Areas_a(2) = iTop_Areas_a(1)
		
		iTop_Areas1_a(1) = iTop_Areas1_a(0)
		iTop_Areas_a(1) = iTop_Areas_a(0)		
		
		iTop_Areas1_a(0) = iBugs_a(x)
		iTop_Areas_a(0) = x
		
	ElseIf iBugs_a(x) > iTop_Areas1_a(1) Then
	
		iTop_Areas1_a(2) = iTop_Areas1_a(1)
		iTop_Areas_a(2) = iTop_Areas_a(1)
	
		iTop_Areas1_a(1) = iBugs_a(x)
		iTop_Areas_a(1) = x
		
	ElseIf iBugs_a(x) > iTop_Areas1_a(2) Then
	
		iTop_Areas1_a(2) = iBugs_a(x)
		iTop_Areas_a(2) = x
		
	Else
	End If

Next 


For x = 0 To 2


REM//			Choose background

If x = 0 Then 
	sBackground="card_top"
	
ElseIf InStr(x/2, ".") <> 0 Then
	sBackground="card_mid2"

Else
	sBackground="card_mid1"
	
End If


If iArray_Size - 1 >= x Then
%>


<TR>


<% REM//		Display Progams with button linked to those programs %>

<TD ALIGN=LEFT WIDTH="34%" BACKGROUND="images/<% = sBackground & "_left" %>.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="change_project('<% =sPrograms_a(iTop_Areas_a(x)) %>', '')">
&nbsp;&nbsp;<IMG NAME="b1" SRC="images/buttons/view.gif" BORDER=0 ALT="Click here to view all bugs from the <% = sPrograms_a(iTop_Areas_a(x)) %> program...">
</A>

<% Else %>

&nbsp;&nbsp;<IMG NAME="b1" SRC="images/buttons/view.gif" BORDER=0 onClick="change_project('<% =sPrograms_a(iTop_Areas_a(x)) %>', '')" ALT="Click here to view all bugs from the <% = sPrograms_a(iTop_Areas_a(x)) %> program...">

<% End If %>


<FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=sPrograms_a(iTop_Areas_a(x))%>
</FONT>

</TD>


<% REM//		Display Areas with button linked to those areas %>

<TD ALIGN=LEFT WIDTH="33%" BACKGROUND="images/<% = sBackground %>.gif">

<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="change_project('<% =sPrograms_a(iTop_Areas_a(x)) %>', '<% =sAreas_a(iTop_Areas_a(x)) %>')">
&nbsp;&nbsp;<IMG NAME="b1" SRC="images/buttons/view.gif" BORDER=0 ALT="Click here to view all bugs from the <% = sPrograms_a(iTop_Areas_a(x)) %> program, <% = sAreas_a(iTop_Areas_a(x)) %> area...">
</A>

<% Else %>

&nbsp;&nbsp;<IMG NAME="b1" SRC="images/buttons/view.gif" BORDER=0 onClick="change_project('<% =sPrograms_a(iTop_Areas_a(x)) %>', '<% =sAreas_a(iTop_Areas_a(x)) %>')" ALT="Click here to view all bugs from the <% = sPrograms_a(iTop_Areas_a(x)) %> program, <% = sAreas_a(iTop_Areas_a(x)) %> area...">

<% End If %>


<FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;<%=sAreas_a(iTop_Areas_a(x)) %>
</FONT>


</TD>



<% REM//		# of bugs %>

<TD ALIGN=LEFT WIDTH="33%" BACKGROUND="images/<% = sBackground %>.gif">

<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
<%=iTop_Areas1_a(x)%>
</B></FONT>

</TD>


<% REM//		Right Border %>

<TD BACKGROUND="images/card_border_right.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


</TR>


<%
Else
%>



<TR>

<TD COLSPAN=3 BACKGROUND="images/<% = sBackground %>_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2>
&nbsp;&nbsp;&nbsp;&nbsp;This project does not have any bugs reported for the top <%=x + 1%> catagory...
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp
</FONT></B>

</TD>


</TR>


<%
End If

Next



Else
%>


<TR>

<TD COLSPAN=3 BACKGROUND="images/<% = sBackground %>_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2>
&nbsp;&nbsp;&nbsp;&nbsp;This project does not have any non-completed bugs reported...
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp
</FONT></B>

</TD>


</TR>



<%
End If
%>


<TR WIDTH=100% ALIGN=LEFT>


<TD COLSPAN=3 BACKGROUND="images/card_border_bottem.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


<TD BACKGROUND="images/corner.gif">

&nbsp;

</TD>


</TR>

</TABLE>

</CENTER>