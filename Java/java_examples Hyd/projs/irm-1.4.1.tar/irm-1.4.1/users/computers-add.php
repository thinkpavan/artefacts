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
#    $Id: computers-add.php,v 1.2.4.2 2003/02/26 18:31:39 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  8/9/99 - Add code for requesting an IRM ID
#  9/10/99 - Finally worked on software carryover.  Code is horrible ATM,
#		but it seems all I can get to work.
################################################################################

include("../include/irm.inc");

AuthCheck("tech");
if ($flags_server == "yes") 
{
	$flags_server = 1;
} else 
{
	$flags_server = 0;
}

if ($reqID != 0)
{
	$query = "SELECT ID FROM computers WHERE (ID = $reqID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
	if ($numRows == 0) 
	{
		$ID = $reqID;	
	} else 
	{
		commonHeader("Error");
		PRINT "A computer with ID $reqID already exists.  Please pick a new ID";
		commonFooter();
		exit();
	}
}

if ($reqID == 0) 
{
	$ID = "NULL";
}	

$comments = addslashes($comments);
$contact = addslashes($contact);
$query = "INSERT INTO computers (ID, name, type, flags_server, os, osver, 
		processor, processor_speed, location, serial, otherserial, ramtype, ram, 
		network, ip, mac, hdspace, contact, contact_num, comments, date_mod) 
		VALUES ($ID, '$name', '$type','$flags_server', '$os',
		'$osver', '$processor', '$processor_speed','$location',
		'$serial', '$otherserial', '$ramtype', '$ram', '$network',
		'$ip','$mac', '$hdspace', '$contact','$contact_num',
		'$comments', '$date_mod')";
$count = $adb->dbh_do($query);
	
$query = "SELECT ID FROM computers WHERE (date_mod = '$date_mod')";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$cID = $result["ID"];
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
	
logevent($cID, "computers", 4, "database", "$IRMName added record"); 
$query = "SELECT * FROM templ_inst_software WHERE (cID = $templID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();

	if ($iface_do == "yes") 
	{
		$query = "INSERT INTO networking_ports VALUES (NULL, $cID, 1, '$iface', 
			'$ip', '$mac', 1, 'Port 1')";	
		$count = $adb->dbh_do($query);
	}
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
 		$sID = $result["sID"];
		$query = "INSERT INTO inst_software VALUES (NULL, $cID, $sID)";
		$trash = $adb->dbh_do($query);
	}
	$sth->finish();
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}

if(strstr($HTTP_REFERER, "add=1") != FALSE) 
{
	header("Location: $HTTP_REFERER");
} else 
{
	header("Location: $HTTP_REFERER&add=1\n\n");
}

?>
