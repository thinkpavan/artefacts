<%
REM//		Define Variables

sBug_ID = request.querystring("iBug_ID")			REM//Number representing specific bug (if any)
sBug_ID = LTrim(RTrim(sBug_ID))


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


REM//		If iBug_ID <> a bug number then user
REM//		is prompted to enter a bug id #


REM//		Process Bug Information

If request.form("btnSubmit") = "True" Then
%>


<!-- #include file="process_submit_bug.inc" -->


<%	

	REM//	Add New Bug Info
	
ElseIf sBug_ID = "" Then
%>


<!-- #include file="submit_new_bug.inc" -->


<%
	REM//	Add Bug Detail Info

Else
%>


<!-- #include file="add_bug_detail.inc" -->


<% End If %>