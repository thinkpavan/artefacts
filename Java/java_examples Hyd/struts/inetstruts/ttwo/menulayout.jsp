<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%-- Layout component 
  menu, content
--%>
<TABLE height="407" cellSpacing="0" cellPadding="0" width="785" border="0" ms_2d_layout="TRUE">
	<TR vAlign="top">
		<TD width="17" height="11"></TD>
		<TD width="768"></TD>
	</TR>
	<TR vAlign="top">
		<TD height="396"></TD>
		<TD>
			<TABLE id="Table1" height="395" cellSpacing="1" cellPadding="1" width="767" align="left" bgColor="blue" border="1">
				<TR>
					<TD align="left" width="155" bgColor="aqua"><tiles:insert attribute="menu" /></TD>
					<TD align="left" bgColor="aqua"><tiles:insert attribute="content" /></TD>
				</TR>
			</TABLE>
		</TD>
	</TR>
</TABLE>
