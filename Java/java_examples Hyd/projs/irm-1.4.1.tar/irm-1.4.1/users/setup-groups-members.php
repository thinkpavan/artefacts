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
#    $Id: setup-groups-members.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  12/30/1999 Yann Ramin:	Added to allow editting of group members       #
################################################################################
include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Group Members");
?>
Welcome to the IRM Group Setup utility.  Here you can edit members of a specified group.
You may also <a href="#add">add computers to a group.</a>
<hr noshade>
<?php
$query = "SELECT * FROM groups WHERE ID = $id";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$name = $result["name"];
	PRINT "Group: <b>$name</b> ($id)<br>\n";
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
$query = "SELECT * FROM comp_group where group_id = $id";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	PRINT "<table border=0 width=100%>";
	for ($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$comp_id = $result["comp_id"];
  	$q2 = "SELECT ID,name FROM computers WHERE (ID = $comp_id)";
		$sth2 = $adb->prepare($q2);
		if($sth2)
		{
			$res2 = $sth2->execute();
			$result2 = $sth2->fetchrow_hash();
  		$cname = $result2["name"];
		} else
		{
			PRINT "Could not prepare query: ".$sth2->errstr."<br>\n";
		}
  	PRINT "<tr><td width=50%>$cname ($comp_id)</td><td><a href=\"$USERPREFIX/setup-groups-members-del.php?group_id=$id&comp_id=$comp_id\">[Delete]</a></td></tr>\n"; 		
	}
PRINT "</table>";
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "<a name=\"add\"></a><hr noshade><h4>Add a Computer to Group</h4>";
PRINT "<form method=post action=\"$USERPREFIX/setup-groups-members-add.php\"><input type=hidden name=group_id value=$id>";
PRINT "Computer ID: <input type=text name=comp_id size=4> <input type=submit value=Add></form>";
?>
<?php
commonFooter();
?>
