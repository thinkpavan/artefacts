<?php
#    IRM - The Information Resource Manager
#    Copyright (C) 1999 Yann Ramin
#
#    This program is free software; you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation; either version 2 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License (in file COPYING) for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program; if not, write to the Free Software
#    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
#
#    $Id: setup-groups.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/16/99 - Keith Schoenefeld:	Added file so we could add groups              #
################################################################################
include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Group Setup");
?>
Welcome to the IRM Group Setup utility.  Here you can change, view, delete, and
add computer groups to the IRM database. <a href="#add">Click here to add
groups.</a> 
<hr noshade>
<?php
$query = "SELECT * FROM groups";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$id = $result["ID"];
  	$groupname = $result["name"];
  	PRINT "<form method=post action=\"$USERPREFIX/setup-groups-update.php\">
			<table width=100% border=1 noshade bordercolor=#000000>
			<tr bgcolor=#CCCCCC><td colspan=2><strong>($id) $groupname
			</strong></td></tr>";
  	PRINT "<tr bgcolor=#DDDDDD>
			<td><font face=\"arial, helvetica\">ID: $id</font></td>\n";
  	PRINT "<td><font face=\"arial, helvetica\">Group Name:
			<br><input type=text size=\"65%\" 
			name=groupname value=\"$groupname\">";
  	PRINT "</font></td>\n</tr>\n";

  	PRINT "<tr bgcolor=#CCCCCC><td valign=center><input type=hidden 
			name=id value=\"$id\"><input type=submit 
			value=Update></form></td><td valign=center><form method=get 
			action=\"$USERPREFIX/setup-groups-del.php\"><input type=hidden 
			name=id value=\"$id\"><input type=hidden name=groupname 
			value=\"$groupname\"><input type=submit 
			value=Delete>&nbsp;&nbsp;<a href=\"$USERPREFIX/setup-groups-members.php?id=$id\">Edit Group Members</a></form></td></tr></table>";
  	PRINT "<br>";
	}
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "<a name=\"add\"></a><hr noshade><h4>Add a Group</h4>";
PRINT "<form method=post action=\"$USERPREFIX/setup-groups-add.php\"><table width=100% 
		border=1 noshade bordercolor=#000000><tr bgcolor=#CCCCCC>
		<td colspan=2><strong>New Group</strong></td></tr>";
PRINT "<tr bgcolor=#DDDDDD> <td><font face=\"arial, helvetica\">Name:<br> 
		<input type=text size=\"65%\" name=groupname></td></tr>";
PRINT "<tr bgcolor=#CCCCCC><td colspan=2><input type=submit value=Add>
		</td></tr></table></form>";

?>
<?php
commonFooter();
?>
