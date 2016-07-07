<% 
REM//		List bug header information 


iSize = 90
%>

<SCRIPT LANGUAGE="Javascript">
	
	
function submit_form() {
	document.frmAdd_Bug_Detail.submit();
	}


</SCRIPT>


<FORM NAME="frmAdd_Bug_Detail" ACTION="view_bugs.asp?iBT=10&iBug_ID=<%=sBug_ID%>" METHOD=POST>


<!-- #include file="open_bug_db.inc" -->

<%
lstProject = rs("sProject")
lstProgram = rs("sProgram")
%>

<!-- #include file="close_bug_db.inc" -->

<!-- #include file="detail_form.inc" -->


<INPUT TYPE="Hidden" NAME="btnSubmit" Value="True">


</FORM>

