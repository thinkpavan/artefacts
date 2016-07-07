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
#    $Id: networking-add.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

$new_date = date("Y-m-d H:i:s");
$comments = addslashes($comments);
$query = "INSERT INTO networking VALUES (NULL, '$name', '$type', '$ram','$ip','$mac','$location', '$serial', '$otherserial', '$contact', '$contact_num', '$new_date', '$comments')";
$count = $adb->dbh_do($query);

$query = "SELECT ID FROM networking WHERE (datemod = '$new_date')";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$ID = $result["ID"];
	$i = 0;
	$in = 1; /* natural i */
	while ($i < $numports) 
	{
		$query = "INSERT INTO networking_ports VALUES (NULL, $ID, 2, '$ifacetype', '$ip', '$mac', $in, 'Port $in')";
		$count = $adb->dbh_do($query);	
		$i++;
		$in++;
	}
	logevent($ID, "networking", 4, "database", "$IRMName added record");
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
header("Location: $HTTP_REFERER");
?>
