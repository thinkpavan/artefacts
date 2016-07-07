<TD ALIGN=RIGHT HEIGHT=75%>
<FONT FACE="Verdana, Arial" SIZE=1>

<%

if (iOpened > iClosed) then 
	response.write ("<FONT COLOR=RED>" & iOpened & "<FONT COLOR=BLACK>")
	sColor = "red"
else
	response.write (iOpened)
	sColor = "green"
end if

if iOpened = 0 or iMax = 0 then
	iSize = 5
else
	iSize = (iOpened/iMax * 125)
end if
%>

<BR><IMG SRC="./images/reports/<%=sColor%>.gif" HEIGHT=<%=iSize%> WIDTH=<%=iWidth%> ALIGN=BOTTOM BORDER=1>

</FONT>
</TD>


<TD ALIGN=LEFT HEIGHT=75%>
<FONT FACE="Verdana, Arial" SIZE=1>

<%

if (iOpened > iClosed) then 
	response.write ("<FONT COLOR=RED>" & iClosed & "<FONT COLOR=BLACK>")
	sColor = "yellow"
	sDate_a (X) = ("<FONT COLOR=RED>" & CurrentDate & "<FONT COLOR=BLACK>")

else
	response.write (iClosed)
	sColor = "blue"
	sDate_a (X) = CurrentDate

end if



if iClosed = 0 or iMax = 0 then
	iSize = 5
else
	iSize = (iClosed/iMax * 125)
end if
%>

<BR><IMG SRC="./images/reports/<%=sColor%>.gif" HEIGHT=<%=iSize%> WIDTH=<%=iWidth%> ALIGN=BOTTOM BORDER=1>

</FONT>
</TD>