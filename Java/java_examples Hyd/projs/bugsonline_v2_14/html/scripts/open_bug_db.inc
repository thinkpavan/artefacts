<%
sql = "SELECT tblBug_ID.sBug_ID, tblBug_ID.sProject, tblBug_ID.sProgram, tblBug_ID.sArea, "
sql = sql & "tblBug_ID.sDescription	FROM tblBug_ID "
sql = sql & "WHERE tblBug_ID.sBug_ID='" & sBug_ID & "'"
		
sql1 = "SELECT tblBugs.dtDate, tblBugs.sStatus, tblBugs.iPriority, tblBugs.iAssigned_To, "
sql1 = sql1 & "tblBugs.sSeverity, tblBugs.sComments, tblUsers.sFirst_Name, "
sql1 = sql1 & "tblUsers.sLast_Name FROM tblUsers LEFT JOIN tblBugs ON tblUsers.iID = tblBugs.iPosted_By "
sql1 = sql1 & "WHERE tblBugs.sBug_ID='" & sBug_ID & "'"
sql1 = sql1 & " ORDER BY tblBugs.dtDate DESC "

sql2 = "SELECT tblUsers.sFirst_Name, tblUsers.sLast_Name "
sql2 = sql2 & "FROM tblUsers "


REM//		Open database connection for
REM//		Current Bug Detail information

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3


REM//		Open database connection for
REM//		all bug details

Set Conn1 = Server.CreateObject("ADODB.Connection")
Conn1.Open "bugs", , ""
Set rs1 = Server.CreateObject("ADODB.Recordset")
rs1.Open sql1, conn1, 3, 3


If rs.eof = True or rs1.eof = True Then


iStop = 5 
%>


<%
Else

rs1.movefirst
iLoc = 1
iDetails = rs1.recordcount		REM//Number of Bug Details
rs1.movelast

End If
%>