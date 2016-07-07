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
#    $Id: networking-connecter.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  3/17/00 - Yann Ramin: Added file to allow port operations (disconnect, connect)
################################################################################

include("../include/irm.inc");


AuthCheck("tech");
commonHeader("IRM Networking Connector Wizard - Step 1 of 3");
?>


<?php

PRINT "This is where you can connect a port to another port easily.  To begin, choose which device you wish to connect it to.";
PRINT "<form method=get action=\"$USERPREFIX/networking-connecter-2.php\">";
PRINT "<p>Connect to a computer with <select name=type szie=1><option value=name>name</option><option value=id>ID</option></select>";
PRINT " <input type=text size=20 name=comp><input type=hidden name=pID1 value=$ID><input type=hidden name=go_back value=\"$HTTP_REFERER\"><input type=submit value=\"Continue ->\"></form>";
PRINT "<p><form method=get action=\"$USERPREFIX/networking-connecter-3.php\">Or choose a network device:";
$query = "SELECT ID,name,location from networking";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	PRINT "<select size=1 name=dID>";
	for ($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
		$dID = $result["ID"];
		$name = $result["name"];
		$location = $result["location"];
		
		PRINT "<option value=$dID>$name ($location)</option>";
	}
	PRINT "</select><input type=hidden name=device_type value=2><input type=hidden name=go_back value=\"$HTTP_REFERER\"><input type=hidden name=pID1 value=$ID><input type=submit value=\"Continue ->\"></form>";	
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
commonFooter();
?>


