<%@ Control language="c#" Codebehind="editnntpforum.ascx.cs" AutoEventWireup="false" Inherits="yaf.pages.admin.editnntpforum" %>
<%@ Register TagPrefix="yaf" Namespace="yaf.controls" Assembly="yaf" %>

<yaf:PageLinks runat="server" id="PageLinks"/>

<yaf:adminmenu runat="server">

<table class=content cellSpacing=1 cellPadding=0 width="100%">
	<tr>
		<td class=header1 colspan=2>Edit NNTP Forum</td>
	</tr>
  <tr>
    <td class=postheader width="50%"><b>Server:</b><br/>What server this groups is located.</td>
    <td class=post width="50%"><asp:dropdownlist id="NntpServerID" runat="server"/></td></tr>
 
  <tr>
    <td class=postheader><b>Group:</b><br/>The name of the newsgroup.</td>
    <td class=post><asp:textbox id="GroupName" runat="server"/></td></tr>
    
  <tr>
    <td class=postheader><b>Forum:</b><br/>The forum messages will be inserted into.</td>
    <td class=post><asp:dropdownlist id="ForumID" runat="server"/></td></tr>

	<tr>
		<td class=postfooter align=middle colspan=2>
			<asp:button id=Save runat="server" Text="Save"/>&nbsp; 
			<asp:button id=Cancel runat="server" Text="Cancel"/>
		</td>
	</tr>

</table>

</yaf:adminmenu>

<yaf:savescrollpos runat="server"/>
