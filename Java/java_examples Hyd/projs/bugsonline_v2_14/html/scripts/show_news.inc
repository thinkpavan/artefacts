<%
REM//		Open Database to display new news

sql5 = "SELECT * FROM [tblNews]"
sql5 = sql5 & "WHERE tblNews.dtDate>=#" & session("dtLogin_Date") & "#"


Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql5, conn, 3, 3


If rs.eof <> True Then


Do while rs.eof <> True


REM//		Will only show messages pertaining
REM//		to that users project

If rs("sProject") = "All" or InStr(LCase(rs("sProject")), LCase(session("sProject"))) <> 0 Then
%>


<B><FONT FACE="Verdana, Arial" SIZE=2 COLOR="#FF0000">
<%
If rs("sPosted_By") <> "" Then
	response.write "Announcement from " & rs("sPosted_By") & " : "
End If
%>
</FONT>

<FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000"><MARQUEE BEHAVIOR=Slide LOOP=Infinite>
<%= rs("sMessage") %>
</FONT></B></MARQUEE><BR>


<%
End If


rs.movenext

Loop


rs.movefirst


End If


If rs.eof <> True Then
%>



<%
End If


rs.Close
set rs.activeconnection=nothing
Conn.close
%>