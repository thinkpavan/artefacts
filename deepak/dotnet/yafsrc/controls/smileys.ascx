<%@ Control Language="c#" AutoEventWireup="false" Codebehind="smileys.ascx.cs" Inherits="yaf.controls.smileys" TargetSchema="http://schemas.microsoft.com/intellisense/ie5"%>
<%@ Register TagPrefix="yaf" Namespace="yaf.controls" Assembly="yaf" %>
<br /><br />

<table class="content" align="center" cellspacing="0" cellpadding="9">
	<tr class="postheader">
		<td class="header" colspan="6"><b>Smilies</b></td>
	</tr>
	<asp:Literal id="SmileyResults" Runat="server" />
</table>

<p class="navlinks" align="center"><yaf:pager runat="server" id="pager"/></p>
