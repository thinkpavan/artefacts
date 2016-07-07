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
#    $Id: networking-port.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  3/17/00 - Yann Ramin: Added file to allow port operations (disconnect, connect)
################################################################################

include("../include/irm.inc");


AuthCheck("normal");

commonHeader("IRM Networking - Port");
PRINT "This is where you can connect ports together, disconnect them, change their properties, etc.<hr noshade>\n";
?>

<?php
PRINT "<form method=get action=\"$USERPREFIX/networking-port-update.php\">";
PRINT "<table border=1>\n";	
$query_port = "SELECT * FROM networking_ports WHERE ID = $ID";
$sth_port = $adb->prepare($query_port);
if($sth_port)
{
	$res_port = $sth_port->execute();
	$result_port = $sth_port->fetchrow_hash();
	$ID = $result_port["ID"];
	$name = $result_port["name"];
	$logical_number = $result_port["logical_number"];
	$iface = $result_port["iface"];
	$device_on = $result_port["device_on"];
	$device_type = $result_port["device_type"];
	$ifaddr = $result_port["ifaddr"];
	$ifmac = $result_port["ifmac"];
 	$wquery = "SELECT * FROM networking_wire WHERE (end1 = $ID OR end2 = $ID)";
	$sth2 = $adb->prepare($wquery);
	if($sth2)
	{	
		$res2 = $sth2->execute();
		$numRows2 = $sth2->rows();
		if ($numRows2 > 0) 
		{
			$wresult = $sth2->fetchrow_hash();
			$wID = $wresult["ID"];
			$wend1 = $wresult["end1"];
			$wend2 = $wresult["end2"];
			if ($wend1 == $ID) 
			{
				$pquery = "SELECT * FROM networking_ports WHERE (ID = $wend2)";
			} else 
			{
				$pquery = "SELECT * FROM networking_ports WHERE (ID = $wend1)";
			}
			$psth = $adb->prepare($pquery);
			if($psth)
			{
				$pres = $psth->execute();
				$presult = $psth->fetchrow_hash();
				$pID = $psth["ID"];
				$pNum = $psth["logical_number"];
				$pOn = $psth["device_on"];
				$pType = $psth["device_type"];
			} else
			{
				PRINT "Could not prepare query: ".$psth->errstr."<br>\n";
			}
			if ($pType == 1) 
			{
				$nquery = "SELECT ID,name FROM computers WHERE (ID = $pOn)";
			} else if ($pType == 2) 
			{
				$nquery = "SELECT ID,name FROM networking WHERE (ID = $pOn)";
			}
			$nsth = $adb->prepare($nquery);
			if($nsth)
			{
				$nres = $nsth->execute();
				$nresult = $nsth->fetchrow_hash();
				$nname = $nresult["name"];
				$nID = $nresult["ID"];
				$found = 1;
			} else
			{
				PRINT "Could not prepare query: ".$nsth->errstr."<br>\n";
			}
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth2->errstr."<br>\n";
	}
	PRINT "<tr><td>Logical Number:</td><td><input type=text size=5 name=logical_number value=$logical_number></td></tr>";
	PRINT "<tr><td>Name</td><td><input type=text size=20 value=\"$name\" name=name></td></tr>";
	PRINT "<tr><td>Interface</td><td>";
	Dropdown_value("dropdown_iface","iface", $iface);
	PRINT "</td></tr>";
	PRINT "<tr><td>Interface Address</td><td><input type=text size=20 name=ifaddr value=\"$ifaddr\"></td></tr>";
	PRINT "<tr><td>Interface MAC</td><td><input type=text size=25 name=ifmac value=\"$ifmac\"></td></tr>";
	PRINT "<tr><td>Connection</td><td>";
	if ($pType == 1) 
	{
		PRINT "Port <a href=\"$USERPREFIX/networking-port.php?ID=$pID\">$pNum</a> on computer <a href=\"$USERPREFIX/computers-info.php?ID=$nID\">$nname ($nID)</a> | <a href=\"$USERPREFIX/networking-port-discon.php?ID=$ID\">Disconnect</a>.";
	} else if ($pType == 2) 
	{
		PRINT "Port <a href=\"$USERPREFIX/networking-port.php?ID=$pID\">$pNum</a> on network device <a href=\"$USERPREFIX/networking-info.php?ID=$nID\">$nname ($nID)</a> | <a href=\"$USERPREFIX/networking-port-discon.php?ID=$ID\">Disconnect</a>.";
	} else if ($found != 1) 
	{
		PRINT "Nothing Connected. <a href=\"$USERPREFIX/networking-connecter.php?ID=$ID\">Connect</a>";
	}
	PRINT "</td></tr>";
	PRINT "<tr><td><input type=hidden name=device value=$device_on><input type=hidden name=device_type value=$device_type><input type=hidden name=ID value=$ID><input type=submit value=Update></td></form><form method=get action=\"$USERPREFIX/networking-port-del.php\"><input type=hidden name=ID value=$ID><td><input type=submit value=Remove></td></tr></form>";
	PRINT "</table>";
} else
{
	PRINT "Could not prepare query: ".$sth_port->errstr."<br>\n";
}
commonFooter();
?>
