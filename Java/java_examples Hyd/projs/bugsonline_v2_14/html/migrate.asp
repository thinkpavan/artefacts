<HTML>

<HEAD>
<TITLE>Bugs Online Database Migration</TITLE>

<STYLE TYPE="text/css">
<!--
A:link { text-decoration: none; }, A:visited { text-decoration: none }
A:hover { text-decoration: underline; color: #FF0000}
-->
</STYLE>

</HEAD>

<BODY BACKGROUND="images/background_folder.gif" LINK="#800080" VLINK="#800080" HLINK="#800080">
<CENTER>
<BR>
<IMG BORDER=1 SRC="images/projects/bugs.gif" BORDER="0" NAME="Bugs_Online" HEIGHT=70 WIDTH=70>
<BR><FONT FACE="Verdana, Arial" SIZE=2 COLOR=NAVY><B>Bugs Online Database Migration Tool</B><BR><BR>

<TABLE WIDTH=50% BORDER=1 BGCOLOR="#FFFFFF">

<TR><TD ALIGN=LEFT>
<FONT FACE="Verdana, Arial" SIZE=0>

<%
'Code for migration goes here
Dim sStep
Dim sql
sStep = "<A HREF='migrate.asp?Step=1'>Click here to perform Step 1</A><BR><BR>"

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""



'Step 1
if request.querystring("Step") = 1 then
	sql = "UPDATE tblBugs SET dtDateEnd = #1/1/1899# WHERE iCurrent=1"
	sStep = "<A HREF='migrate.asp?Step=2'>Click here to perform Step 2</A><BR><BR>"
	
	Conn.Execute sql
	response.write "Step 1 completed successfully!"
	
'Step 2
elseif request.querystring("Step") = 2 then
	sql = "ALTER TABLE tblBugs DROP COLUMN iCurrent"
	sStep = "<A HREF='migrate.asp?Step=3'>Click here to perform Step 3</A><BR><BR>"
	
	Conn.Execute sql
	response.write "Step 2 completed successfully!"
	
'Step 3
elseif request.querystring("Step") = 3 then
	sql = "UPDATE tblBugs SET dtDate = dtDate + dtTime"
	sStep = "<A HREF='migrate.asp?Step=4'>Click here to perform Step 4</A><BR><BR>"
	
	Conn.Execute sql
	response.write "Step 3 completed successfully!"	
	
'Step 4
elseif request.querystring("Step") = 4 then
	sql = "ALTER TABLE tblBugs DROP COLUMN dtTime"
	sStep = "<A HREF='migrate.asp?Step=5'>Click here to perform Step 5</A><BR><BR>"
	
	Conn.Execute sql
	response.write "Step 4 completed successfully!"	
	
'Step 5
elseif request.querystring("Step") = 5 then
	sql = "UPDATE tblBugs SET bOriginal=true WHERE iID in (SELECT min(iID) FROM tblBugs GROUP BY sBug_ID)"
	sStep = "<A HREF='migrate.asp?Step=6'>Click here to perform Step 6</A><BR><BR>"
	
	Conn.Execute sql
	response.write "Step 5 completed successfully!"	
	
'Step 5
elseif request.querystring("Step") = 6 then
	
	Dim sBug_ID
	Dim iID
	
	sql = "SELECT * FROM tblBugs WHERE dtDateEnd is null"
	sStep = "Migration is complete.<BR><BR>"
	
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	response.write rs.recordcount
	
	do while not rs.eof
		sBug_ID = rs("sBug_ID")
		iID = rs("iID")
		sql = "SELECT min(dtDate) as dtNextDate FROM tblBugs WHERE iID > " & iID & " AND sBug_ID = '" & sBug_ID & "'"
		
		Set rs1 = Server.CreateObject("ADODB.Recordset")
		rs1.Open sql, conn, 3, 3
		
		rs("dtDateEnd") = rs1("dtNextDate")
		rs1.close
		set rs1.activeconnection=nothing		
		rs.update
		rs.movenext
	loop
	
	rs.Close
	set rs.activeconnection=nothing
	response.write "Step 6 completed successfully!"		

	
else
	%>
	The database migration tool for <I><B>Bugs Online 2.1</B></I> is a simple 6 step process.<BR><BR>
	To begin the migration simply click the following link. Results of the migration process will appear in this box.

	<%	
end if


Conn.close

%>

</TD></TR>

</TABLE>


<BR>
<FONT FACE="Verdana, Arial" SIZE=0>
<%=sStep%>
</CENTER>

</BODY>


</HTML>