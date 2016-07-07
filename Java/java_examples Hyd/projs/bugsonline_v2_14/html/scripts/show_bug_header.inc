<% REM//		Open DB Connections %>

<!-- #include file="open_bug_db.inc" -->


<%
REM//		If DB is able to locate bug id then
REM//		Bug information is displayed

If iStop <> 5 Then
%>


<% 
REM//		If 1st bug header has already been shown then
REM//		displays title image

If iStart = 1 Or iStart = 2 Then

%>


<BR>
<TABLE WIDTH=70 HEIGHT=70 BORDER=0 CELLSPACING=0 ALIGN=CENTER>

<TR>

<TD ALIGN=CENTER VALIGN=TOP BACKGROUND="images/memo.gif">

<B><FONT FACE="Georgia, Arial" Size=2 COLOR="#000000">
Results<BR><%=iLoc_Display + 1 %> of <%=iTotal_Results %>
</FONT></B>

</TD>

</TR>

</TABLE>

<% Else %>


<!-- #include file="header.inc" -->
<BR>

<% End If %>


<%
REM//		Define remainder of sql statement

Select Case Len(rs("sBug_ID"))
	Case 1
		sZeros = "0000"
	Case 2
		sZeros = "000"
	Case 3
		sZeros = "00"
	Case 4
		sZeros = "0"
	Case Else
		sZeros = ""
End Select


%>



<% REM//		Image JavaScript%>


<SCRIPT LANGUAGE="Javascript">


{
	var l_button = new Array(1);

 	l_button[0]= new Image ();
  	l_button[0].src="images/reg/new_detail.jpg";
  	l_button[1]= new Image ();
  	l_button[1].src="images/sel/new_detail.jpg";
	
}

function on_img(loc,img) {
	loc.src=l_button[img].src;
	}


</SCRIPT>


<TABLE WIDTH=50% BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<% REM//		Bug ID Number Info%>

<TR>


<TD WIDTH="48%" ALIGN=LEFT COLSPAN=2 BACKGROUND="images/memo_border_top_left.gif">
<B><FONT FACE="Georgia, Arial" Size=2 COLOR="#000000">
<BR>
&nbsp;&nbsp;Bug #:&nbsp;&nbsp;

<% If iDetail_Type = 2 And iDetails <> 1 Then %>

<A HREF="view_bugs.asp?iBT=8&iBug_ID=<%=rs("sBug_ID") %>"><%=sZeros & rs("sBug_ID") %></A>

</FONT>
<FONT FACE="Georgia, Arial" Size=0 COLOR="#000000"><BR>[Click to view all details]

<% Else %>

<%=sZeros & rs("sBug_ID") %>

<% End If %>


</FONT></B>
<BR>
</TD>

<TD WIDTH=48% ALIGN=RIGHT COLSPAN=2 BACKGROUND="images/memo_border_top.gif">
<B><FONT FACE="Georgia, Arial" Size=2 COLOR="#000000">
<BR>
Title:&nbsp;&nbsp;

<% = rs("sDescription") %>
&nbsp;&nbsp;
<BR>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Project and Program Information%>

<TR>


<TD WIDTH="48%" ALIGN=RIGHT COLSPAN=2 BACKGROUND="images/memo_border_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">


<%
If session("sProject") <> "Management" Then
	response.write "Program:&nbsp;&nbsp;"
Else
	response.write "Project/ Program:&nbsp;&nbsp;"
End If
%>


</FONT></B>
</TD>

<TD WIDTH="48%" ALIGN=LEFT COLSPAN=2 BACKGROUND="images/memo_background.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">


<%
If session("sProject") <> "Management" Then
	response.write rs("sProgram")
Else
	response.write rs("sProject") & "/ " & rs("sProgram")
End If
%>


</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Program Area Information%>

<TR>

<TD WIDTH="48%" ALIGN=RIGHT COLSPAN=2 BACKGROUND="images/memo_border_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Program Area:&nbsp;&nbsp;
</FONT></B>
</TD>

<TD WIDTH="48%" ALIGN=LEFT COLSPAN=2 BACKGROUND="images/memo_background.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%=rs("sArea")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Posted By Information%>

<TR>

<TD WIDTH="48%" ALIGN=RIGHT COLSPAN=2 BACKGROUND="images/memo_border_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Posted By:&nbsp;&nbsp;
</FONT></B>
</TD>

<TD WIDTH="48%" ALIGN=LEFT COLSPAN=2 BACKGROUND="images/memo_background.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("sFirst_Name") & " " & rs1("sLast_Name")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Date and time information%>

<TR>

<TD WIDTH="48%" ALIGN=RIGHT COLSPAN=2 BACKGROUND="images/memo_border_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Date/ Time:&nbsp;&nbsp;
</FONT></B>
</TD>

<TD WIDTH="48%" ALIGN=LEFT COLSPAN=2 BACKGROUND="images/memo_background.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("dtDate")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD COLSPAN=4 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>

<TD BACKGROUND="images/corner.gif">&nbsp;</TD>

</TR>

</TABLE>


<%
rs1.movefirst

iStart = 2



End If


REM//		Close Database Connections %>

<!-- #include file="close_bug_db.inc" -->