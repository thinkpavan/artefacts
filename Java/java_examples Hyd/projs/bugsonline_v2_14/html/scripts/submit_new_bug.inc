<SCRIPT LANGUAGE="Javascript">


function change_project() {
	document.frmSubmit_New_Bug.btnSubmit.value = "";
	document.frmSubmit_New_Bug.submit();
	}
	
	
function submit_form() {
	document.frmSubmit_New_Bug.btnSubmit.value = "True";
	document.frmSubmit_New_Bug.submit();
	}


</SCRIPT>


<FORM NAME="frmSubmit_New_Bug" ACTION="view_bugs.asp?iBT=10" METHOD=POST>

	<INPUT TYPE="Hidden" NAME="btnSubmit" Value="">

<%
If request.form("lstProject") <> "" Then 
	sProject_Name = request.form("lstProject")

ElseIf session("sProject") <> "Management" Then
	sProject_Name = session("sProject")
End If


If (session("sProject") = "Management" And request("lstProject") = "") Or (request("lstProject") = "Management") Then
	

If sError_Message = "" Then
	
	imgTitle = "banner_m"
	sMessage = ""
	
End If
%>


<!-- #include file="header.inc" -->


<BR>

<TABLE WIDTH=50% BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<TR>

<TD ALIGN=CENTER>
<%
iSelect_Type = 1
iSelect_Size = 4
sProject = request.form("lstProject")
%>
<!-- #include file="create_select.inc" -->
</TD>

</TR>


</TABLE>


<%
Else
%>


<!-- #include file="header.inc" -->


<INPUT TYPE="Hidden" NAME="lstProject" VALUE="<% = sProject_Name %>">

<TABLE WIDTH=65% BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<% REM//		Name of person submitting bug %>

<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_border_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Posted By:&nbsp;&nbsp;
</FONT></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_border_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%=session("sFirst_Name") & " " & session("sLast_Name")%>
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Date and time information %>

<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Date/ Time:&nbsp;&nbsp;
</FONT></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%=date & "/ " & time %>
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Program Information %>

<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Program:&nbsp;&nbsp;
</FONT></B>
</TD>


<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">

<%
iSelect_Type = 2
iSelect_Size = 3
sProgram = request.form("lstProgram")
sProject = sProject_Name
%>
<!-- #include file="create_select.inc" -->


</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Area Information %>

<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Area:&nbsp;&nbsp;
</FONT></B>
</TD>


<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">

<%
iSelect_Type = 3
iSelect_Size = 1
sProject = sProject_Name
sProgram = request.form("lstProgram")
sArea = request.form("lstArea")
%>
<!-- #include file="create_select.inc" -->

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Title%>

<TR>


<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Title:&nbsp;&nbsp;
</FONT></B>
</TD>


<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<INPUT TYPE="Text" NAME="txtDescription" VALUE="<%=request.form("txtDescription")%>" SIZE=20 MAXLENGTH=25>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD COLSPAN=2 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>

<TD BACKGROUND="images/corner.gif">&nbsp;</TD>

</TR>


</TABLE>


<!-- #include file="detail_form.inc" -->


<% End If %>


</FORM>

