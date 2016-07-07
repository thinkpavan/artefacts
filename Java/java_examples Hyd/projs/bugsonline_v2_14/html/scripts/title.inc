<%
REM//			This script displays either the
REM//			bug details relating to a bug, or
REM//			the inputs necessary to submit a bug
REM//			or add a detail.  It accepts the following
REM//			values

REM//			iTitle = 1 :	Shows Bug Header and Details
REM//			iTitle = 2 :	Creates form necessary to Submit a new bug
REM//			iTitle = 3 :	Creates form necessary to Add a bug detail
REM//			iTitle = 4 :	Search results for bug header and most recent detail
REM//			iTitle = 5 :	Search results for bug header and all details


REM//		Determine zero string depending on length of bug id #

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


REM//		Add Bug Detail

If iTitle = 3 Then
%>


<FORM NAME="frmAdd_Bug_Detail" ACTION="view_bugs.asp?iBT=10&iBug_ID=<%=sBug_ID%>" METHOD=POST>

<%
ElseIf iTitle = 2 Then
%>


<SCRIPT LANGUAGE="Javascript">


function change_project() {
	document.frmSubmit_New_Bug.submit();
	}


</SCRIPT>


<FORM NAME="frmSubmit_New_Bug" ACTION="view_bugs.asp?iBT=10" METHOD=POST>

<INPUT TYPE="Hidden" NAME="txtProject" VALUE="<% =sProject_Name %>">


<% Else %>


<FORM NAME="frmAdd_Detail" ACTION="javascript: open_help('view_bugs.asp?iBT=10&iBug_ID=<% = sBug_ID %>', 300, 500)" METHOD=POST>


<% End If %>


<CENTER>



<TABLE WIDTH="95%" CELLSPACING=0 CELLPADDING=0 BORDER=0 ALIGN=CENTER>


<% REM//		Top Borders %>

<TR WIDTH=100%>


<% 
REM//		Memo top border %>

<TD COLSPAN=2 BACKGROUND="images/memo_border_top_left.gif" HEIGHT=5>
&nbsp;
</TD>

<TD BACKGROUND="images/card_border_right.gif" HEIGHT=5 WIDTH=5>
&nbsp;
</TD>


<% REM//		Center spacer cell %>

<TD BACKGROUND="images/background.gif" WIDTH=75>
&nbsp;
</TD>


<% REM//		1st Detail top border %>

<TD BACKGROUND="images/card_border_top_left.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


<TD BACKGROUND="images/card_border_top.gif">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


</TR>



<% REM//		Titles %>

<TR WIDTH=100%>


<% REM//		Memo Title %>

<TD COLSPAN=2 BACKGROUND="images/memo_border_left.gif" ALIGN=CENTER VALIGN=TOP>

&nbsp;&nbsp;<IMG SRC="images/text/memo_bug_information.gif" BORDER=0 ALT="" ALIGN="absmiddle">

</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>
&nbsp;
</TD>


<% REM//		Center spacer cell %>

<TD BACKGROUND="images/background.gif" WIDTH=75>
&nbsp;
</TD>


<% REM//		1st Detail Title %>


<%
REM//		Submit New Bug

If iTitle = 2 Then
%>

<TD COLSPAN=2 BACKGROUND="images/card_header_left.gif" ALIGN=LEFT VALIGN=TOP>

&nbsp;&nbsp;<IMG SRC="images/text/detail_detail.gif" BORDER=0 ALT="" ALIGN="absmiddle">


<%
REM//		Add Bug Detail

ElseIf iTitle = 3 Then
%>

<TD BACKGROUND="images/card_header_left.gif" ALIGN=LEFT VALIGN=TOP>

&nbsp;&nbsp;<IMG SRC="images/text/detail_detail.gif" BORDER=0 ALT="" ALIGN="absmiddle">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=2>
Bug # <%= sZeros & sBug_ID %>
</FONT></B>


<% 
REM//		Other

Else 
%>


<TD BACKGROUND="images/card_header_left.gif" ALIGN=LEFT VALIGN=TOP>

&nbsp;&nbsp;<IMG SRC="images/text/detail_current_detail.gif" BORDER=0 ALT="" ALIGN="absmiddle">

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=2>
1 of <% = rs1.recordcount %>
</FONT></B>

</TD>

<TD BACKGROUND="images/card_header.gif" ALIGN=RIGHT VALIGN=TOP>

<INPUT TYPE="Image" SRC="images/buttons/new.gif" BORDER=0 VALUE="View" ALT="Click here to add a new detail to Bug # <%=sZeros & sBug_ID %>.">&nbsp;&nbsp;

<% End If %>


</TD>


<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=1>
&nbsp;
</FONT></B>

</TD>


</TR>



<% REM//		1st Line (Bug # & Current Detail #) %>


<% REM//			Bug # %>

<TD BACKGROUND="images/memo_border_left.gif" ALIGN=LEFT>

<BR>
&nbsp;&nbsp;<IMG SRC="images/text/memo_bug.gif" BORDER=0 ALT="" ALIGN="absmiddle">

</TD>


<TD BACKGROUND="images/memo_background.gif" ALIGN=RIGHT>

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=2>

<% 
REM//			HREF if Search results header only (iTitle = 4)

If iTitle = 4 Then %>

<A HREF="view_bugs.asp?iBT=8&iBug_ID=<%=rs("sBug_ID") %>"><%=sZeros & rs("sBug_ID") %></A>

<% Else %>

<%=sZeros & rs("sBug_ID") %>&nbsp;&nbsp;

<% End If %>


</FONT></B>

</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>
&nbsp;
</TD>


<% REM//		Center spacer cell %>

<TD BACKGROUND="images/background.gif" WIDTH=75>
&nbsp;
</TD>


<% REM//		Posted By	 %>

<TD BACKGROUND="images/card_top.gif" ALIGN=LEFT VALIGN=MIDDLE>

<BR>
&nbsp;&nbsp;<IMG SRC="images/text/detail_posted.gif" BORDER=0 ALT="" ALIGN="absmiddle">

</TD>

<% rs1.movefirst %>

<TD BACKGROUND="images/card_top.gif" ALIGN=RIGHT VALIGN=MIDDLE>

&nbsp;&nbsp;

</TD>


<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>


</TR>




<% REM//		Bottem Border %>

<TR WIDTH=100%>


<% REM//		Memo Bottem Border %>

<TD COLSPAN=2 BACKGROUND="images/card_border_bottem.gif" ALIGN=CENTER>&nbsp;</TD>


<TD BACKGROUND="images/corner.gif" WIDTH=5>&nbsp;</TD>


<% REM//		Center spacer cell %>

<TD BACKGROUND="images/background.gif" HEIGHT=5 WIDTH=75>&nbsp;</TD>


<% REM//		Detail Bottem Border %>

<TD COLSPAN=2 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>


<TD BACKGROUND="images/corner.gif" WIDTH=5>&nbsp;</TD>


</TR>



</TABLE>

</CENTER>

</FORM>