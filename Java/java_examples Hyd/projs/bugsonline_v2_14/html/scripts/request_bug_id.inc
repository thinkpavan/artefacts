<% If iStop <> 5 Then %>


<!-- #include file="header.inc" -->


<% 
Else 

imgTitle = "banner_8_2"
%>


<!-- #include file="header.inc" -->


<% End If %>


<FORM NAME="frmRequest_Bug_ID" ACTION="view_bugs.asp?iBT=8"  METHOD=POST>

<TABLE WIDTH="100%">


<TR>

<TD ALIGN=CENTER>
<INPUT TYPE="text" NAME="iBug_ID" SIZE="20" MAXLENGTH="20">
</TD>

</TR>


<TR>

<TD ALIGN=CENTER>
<INPUT TYPE="Image" SRC="images/buttons/go.gif" NAME="btnSubmit" VALUE="GO!" BORDER=0 ALT="Click here to view bug...">
</TD>

</TR>


</TABLE>