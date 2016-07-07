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
#    $Id: networking-connecter-3.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  3/17/00 - Yann Ramin: Added file to allow port operations (disconnect, connect)
################################################################################

include("../include/irm.inc");


AuthCheck("tech");
commonHeader("IRM Networking Connector Wizard - Step 3 of 3");

$query = "SELECT * FROM networking_ports WHERE (device_on = $dID) AND (device_type = $device_type) ORDER BY logical_number";
$sth = $adb->prepare($query);
if($sth)
{
	# 1 is computer, 2 networking device
	$res = $sth->execute();
	$numRows = $sth->rows();
	if ($numRows < 1) 
	{
		PRINT "Looks like a lonley device to me.  No ports found.<br>";
		return;
	}
	PRINT "<table border=1 width=100%>";
	PRINT "<tr><th>Port #</th><th>Name</th><th>Interface</th><th>Iface Addr</th><th>If MAC</th><th>Connected to...</th></tr>";
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
		$ID = $result["ID"];
		$name = $result["name"];
		$logical_number = $result["logical_number"];
		$iface = $result["iface"];
		$ifaddr = $result["ifaddr"];
		$ifmac = $result["ifmac"];
		$wquery = "SELECT * FROM networking_wire WHERE (end1 = $ID OR end2 = $ID)";
		$wsth = $adb->prepare($wquery);
		if($wsth)
		{
			$wres = $wsth->execute();
			$wnumRows = $wsth->rows();
			if ($wnumRows > 0) 
			{
				$wresult = $wsth->fetchrow_hash();
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
					$pID = $presult["ID"];
					$pNum = $presult["logical_number"];
					$pOn = $presult["device_on"];
					$pType = $presult["device_type"];
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
			} else 
			{
				$found = 0;
				$pType = 0;
			}
		} else
		{
			PRINT "Could not prepare query: ".$wsth->errstr."<br>\n";
		}
		
		PRINT "<tr><td><a href=\"$USERPREFIX/networking-port.php?ID=$ID\">$logical_number</a></td><td>$name</td><td>$iface</td><td>$ifaddr</td><td>$ifmac</td>";
		PRINT "<td>";
		if ($pType == 1) 
		{
			PRINT "Port <a href=\"$USERPREFIX/networking-port.php?ID=$pID\">$pNum</a> on computer <a href=\"$USERPREFIX/computers-info.php?ID=$nID\">$nname ($nID)</a>.";
		} else if ($pType == 2) 
		{
			PRINT "Port <a href=\"$USERPREFIX/networking-port.php?ID=$pID\">$pNum</a> on network device <a href=\"$USERPREFIX/networking-info.php?ID=$nID\">$nname ($nID)</a>.";
		} else if ($found != 1) 
		{
			PRINT "Port available. <a href=\"$USERPREFIX/networking-connect.php?pID=$ID&pID1=$pID1&go_back=$go_back\">Connect</a>";
		}
		$found = 0;
		$pType=0;
		PRINT "</td></tr>";
	}
	PRINT "</table><br>";
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
commonFooter();
?>


