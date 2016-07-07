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
#    $Id: computers-groups-batch-add.php,v 1.3 2002/05/17 04:09:21 theatrus Exp $
#

require("../include/irm.inc");

AuthCheck("tech");
commonHeader("IRM Computers - Add to Group Completed");
$aquery = stripslashes($aquery);
$aquery = stripslashes($aquery);
$sth = $adb->prepare($aquery);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
		$cID = $result["ID"];
		$query3 = "INSERT INTO comp_group VALUES ($cID, $sID)";
		$result3 = $adb->dbh_do($query3);
	}
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "The add to group operation has been completed.";
commonFooter();
?>
