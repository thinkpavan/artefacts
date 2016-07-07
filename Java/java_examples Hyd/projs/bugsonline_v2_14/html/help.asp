<%
REM//	Use this call to access help files


REM// 	<B><FONT FACE="Arial" SIZE=2>
REM//	<A HREF="#" onClick="open_help('help.asp?sType=Priority','250','400')">[Help]</A>
REM//	</FONT></B>
%>


<%
REM//	Open Database connection for help file


sql = "SELECT * FROM [tblHelp] WHERE tblHelp.sType='" & request.querystring("sType") & "'"
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

%>


<HTML>


<HEAD>


<TITLE>Bugs Online Help : <%=request.querystring("sType")%></TITLE>


</HEAD>



<BODY BACKGROUND="images/background.gif">



<% If rs.eof <> True Then %>

<CENTER>


<TABLE BORDER=0 WIDTH=95%>



<% REM//	Help title %>

<TR WIDTH=95% ALIGN=LEFT>

<TD VALIGN=CENTER>

<FONT FACE="Georgia, Arial" SIZE=3 COLOR="#0000C0"><B>

<IMG SRC="images/projects/bugs.gif" HEIGHT=70 WIDTH=70 ALIGN=BOTTEM>

<% = rs("sTitle") %>
</FONT></B>

</TD>

</TR>



<% REM//	Help content %>

<TR WIDTH=95% ALIGN=LEFT>

<TD>

<BR>
<FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
<% = rs("sHelp") %>
</FONT>

</TD>

</TR>


</TABLE>


</CENTER>


<% Else %>


<FONT FACE="Georgia, Arial" SIZE=3 COLOR="#0000C0"><B>
Help file not found!  Please contact system administrator.
</FONT></B>

<% End If %>


</BODY>


</HTML>


<%
REM//		Close Database Connection

rs.Close
set rs.activeconnection=nothing
Conn.close

%>