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
#    $Id: setup-fasttrack.php,v 1.2.4.1 2003/02/24 16:48:12 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");
AuthCheck("admin");

commonHeader("IRM Setup - FastTrack Templates");
PRINT "Please select a FastTrack template below to edit, delete, or 
		<a href=\"$USERPREFIX/setup-fasttrack-add-form.php\">add one</a>.<br>";
$query = "SELECT * FROM fasttracktemplates";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	PRINT "<table border=1 width=100%>";
	PRINT "<TR><TH colspan=2>FastTrack Templates</TH></TR>";
	for ($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$ID = $result["ID"];
  	$name = $result["name"];
  	PRINT "<tr BGCOLOR=#DDDDDD><td><a href=\"$USERPREFIX/setup-fasttrack-edit.php?ID=$ID\">$name</a></td>
			<td><a href=\"$USERPREFIX/setup-fasttrack-del.php?ID=$ID\">[Delete]</a>
			</td></tr><br>";
	}
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "</table>";
commonFooter();
?>
