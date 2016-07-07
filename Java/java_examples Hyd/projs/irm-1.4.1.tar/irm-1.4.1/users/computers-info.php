<?php
#    IRM - The Information Resource Manager
#    Copyright (C) 1999,2000 Yann Ramin
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
#    $Id: computers-info.php,v 1.4 2001/07/16 04:39:29 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  9/11/99 - Keith Schoenefeld:	Changed query so it did proper searching to    #
#			display group tracking.                                #
#  1/26/00 - Yann Ramin: Forgot to add changelog.  Added SNMP, fixed group     #
#			 query bug.  Enjoy! q				       #
#  2/25/00 - Yann Ramin: Networking prelim support		
#  2/29/00 - Keith Schoenefeld: Fixed query so that it returned only distinct  ##                               ID's in the select statement.                  #################################################################################

include("../include/irm.inc");


AuthCheck("normal");

commonHeader("IRM Computers - Info");
PRINT "<form method=get action=\"$USERPREFIX/computers-info.php\">";
PRINT "<input type=hidden name=ID value=$ID>";
?>
<select name=showfollowups size=1>
<option value=1>Show Followups</option>
<option value=0 selected>Hide Followups</option>
</select>
<input type=submit value=Show></form>
<?php
showComputer($ID, 1);
showPortsOnDevice($ID, 1);

$inGroup = computerInGroup($ID);
if($inGroup == 1)
{
	$query = "SELECT DISTINCT(ID) FROM tracking,comp_group WHERE ((tracking.computer = $ID AND tracking.is_group = \"no\") OR (tracking.computer = comp_group.comp_id AND tracking.computer = $ID AND tracking.is_group = \"yes\")) ORDER BY date DESC";
} else
{
	$query = "SELECT DISTINCT(ID) FROM tracking WHERE (tracking.computer = $ID and tracking.is_group = \"no\") ORDER BY date DESC";
}
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	if ($numRows == 0)
	{
  	PRINT "<i>No Tracking Found</i>";
	} else
	{
		Tracking::displayHeader();
  	for ($i = 0; $i < $numRows; $i++)
  	{
			$result = $sth->fetchrow_hash();
    	$IDjob = $result["ID"];
			$track2 = new Tracking($IDjob);
			$track2->display($showfollowups);
  	}
		Tracking::displayFooter();
	}
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "<br><br>";
compsoftShow($ID);

PRINT "</center><br>";
if ($cfg_groups == 1) 
{
	PRINT "<br><b>Group Memberships</b><p>	";

	$query = "SELECT * FROM comp_group where comp_id = $ID";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		for ($i = 0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
			$gID = $result["group_id"];
			$q2 = "SELECT * FROM groups WHERE id = $gID";
			$sth2 = $adb->prepare($q2);
			if($sth2)
			{
				$res2 = $sth2->execute();
				$result2 = $sth2->fetchrow_hash();
				$gname = $result2["name"];
			} else
			{
				PRINT "Could not prepare query: ".$sth2->errstr."<br>\n";
			}
			PRINT "<a href=\"$USERPREFIX/setup-groups-members.php?id=$gID\">$gname</a><br>";
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
}
commonFooter();
?>
