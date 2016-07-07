<%
REM//		Define Variables

sBug_ID = request("iBug_ID")			'REM//Number representing specific bug (if any)
sBug_ID = LTrim(RTrim(sBug_ID))

If sBug_ID <> "" Then


REM//		Remove Zeros from Bug ID

Do While Left(sBug_ID, 1) = "0"
	sBug_ID = Right(sBug_ID, Len(sBug_ID) - 1)
Loop


End If


REM//		Determine zero string depending on length of bug id #

Select Case Len(sBug_ID)
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


REM// 		Determine if user is authorized to view bug
if sBug_ID <> "" and session("sProject") <> "Management" then
	sql = "SELECT Count(sBug_ID) AS iCount FROM tblBug_ID "
	sql = sql + "WHERE sBug_ID = '" + sBug_ID + "' AND sProject IN ("
	sql = sql + "SELECT p.sProject_Name FROM tblProjects p, tblAuthorized a "
	sql = sql + "WHERE sUser_Name = '" + session("sUser_Name") + "' AND a.iAuthorized = p.iProject_ID"
	sql = sql + ")"
	
	Set Conn = Server.CreateObject("ADODB.Connection")
	Conn.Open "bugs", , ""
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3 
	if rs("iCount") = 0 then 
		sBug_ID = ""
		imgTitle = "banner_8_2"
		sMessage = ""	
	end if
	rs.close
	set rs.activeconnection=nothing
	Conn.close
end if


REM//		If iBug_ID <> a bug number then user
REM//		is prompted to enter a bug id #

If sBug_ID = "" Then
%>


<!-- #include file="request_bug_id.inc" -->


<%
Else

	imgTitle = "banner_8_3"
	sMessage = sZeros & sBug_ID

	iType=3
%>

<!-- #include file="show_bug.inc" -->

<%
End If
%>