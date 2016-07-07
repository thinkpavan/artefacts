<?php
#    IRM - The Information Resource Manager
#    Copyright (C) 2000 Yann Ramin
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
#    $Id: networking-index.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################
include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM Networking");
?>
Welcome to the IRM Networking section.  This where you keep information about all
of your networking devices. 
<?php
PRINT "<a href=\"$USERPREFIX/networking-add-form.php\">Click here to add a device</a>";
?>

<hr noshade>
<?php
$query = "SELECT * FROM networking";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	PRINT "<table border=1 width=100%><tr bgcolor=#CCCCCC><th>
			Name</th><th>Location</th><th>Type</th></tr>";
	for ($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$ID = $result["ID"];
  	$name = $result["name"];
  	$location = $result["location"];
  	$type = $result["type"];
  	PRINT "<tr bgcolor=#DDDDDD><td><a href=\"$USERPREFIX/networking-info.php?ID=$ID\">
		$name ($ID)</a></td><td>$location</td><td>";
	
  	PRINT "$type</td>";
  	PRINT "</tr>";
	}
	PRINT "</table>";
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
commonFooter();
?>
