<%
REM//		Declare Variables

Dim sPassword
Dim sNew_Password
Dim sConfirm_Password
Dim iFound


REM//		Assign Variables

sPassword = request.form("txtPassword")					'REM//Original Password
sNew_Password = request.form("txtNew_Password")				'REM//New Password
sConfirm_Password = request.form("txtConfirm_Password")			'REM//Confirm New Password


REM//		User enters incorrect password information

If sPassword = "" or sNew_Password = "" or sConfirm_Password = "" or sNew_Password <> sConfirm_Password Then
	session("sLogin_Error") = "Incorrect password information, please try again..."
	response.redirect "change_password.asp"
End If


REM//		Open database connection

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
sql = "SELECT * FROM [tblUsers] "
sql = sql + "WHERE tblUsers.sUser_Name='" & session("sUser_Name") & "' AND tblUsers.sPassword='" & sPassword & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3


REM//		Record found

If rs.eof <> True Then
	rs("sPassword") = sNew_Password
	rs.update
	iFound = 1
End If


REM//		Close Database Connection

rs.Close
set rs.activeconnection=nothing
Conn.close


REM//		Record not found

If iFound <> 1 Then
	session("sLogin_Error") = "Incorrect original password..."
	response.redirect "change_password.asp"
Else


REM//		User forwarded to site

	session("authorized") = "True"
	response.redirect "bug_index.asp"
End If
%>
