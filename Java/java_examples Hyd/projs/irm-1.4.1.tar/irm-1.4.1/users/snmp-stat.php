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
#    $Id: snmp-stat.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
# 1/1/00 - Yann Ramin: Created file to browse SNMP MIBS.		       #
################################################################################

include("../include/irm.inc");


AuthCheck("normal");

commonHeader("IRM Computers - SNMP Status");

$query = "SELECT * FROM computers WHERE ID = $ID";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$ip = $result["ip"];
	$name = $result["name"];
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}

PRINT "<table border=1 width=100%>\n";
PRINT "<tr><th>Name</th><th>Status</th><th>Uptime*</th><th>IP</th></tr>";

$hstatus = SNMPHTMLping($ID);
$uptime = SNMPgetComputerObject($ID, "system.sysUpTime.0");
$uptime_p = explode(" ",$uptime);
PRINT "<tr><td>$name ($ID)</td><td>$hstatus</td><td>$uptime_p[2]</td><td>$ip</td></tr>";
PRINT "</table>";
PRINT "<p><h3>Browse MIBS</h3>";
PRINT "<a href=\"$USERPREFIX/snmp-browse.php?browse=system&ID=$ID\">System</a><br>";
PRINT "<a href=\"$USERPREFIX/snmp-browse.php?browse=interfaces&ID=$ID\">Network Interfaces</a><br>";
PRINT "<a href=\"$USERPREFIX/snmp-browse.php?browse=ip&ID=$ID\">IP Stats</a><br>";
PRINT "<a href=\"$USERPREFIX/snmp-browseall.php?ID=$ID>Browse all common MIBS</a\">";

PRINT "<p><i>* Uptime here relfects SNMP agent uptime, not computer uptime!</i>";
commonFooter();
?>
