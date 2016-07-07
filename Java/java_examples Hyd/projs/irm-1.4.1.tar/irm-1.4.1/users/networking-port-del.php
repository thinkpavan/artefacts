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
#    $Id: networking-port-del.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  3/17/00 - Yann Ramin: Added file to allow port operations (disconnect, connect)
################################################################################

include("../include/irm.inc");


AuthCheck("tech");
$query = "SELECT device_on,device_type FROM networking_ports WHERE (ID = $ID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$back = $result["device_on"];
	$back_t = $result["device_type"];
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
$query = "DELETE FROM networking_ports WHERE (ID = $ID)";
$result = $adb->dbh_do($query);
$query = "DELETE FROM networking_wire WHERE (end1 = $ID OR end2 = $ID)";
$result = $adb->dbh_do($query);
logevent($back, "networking", 4, "port", "$IRMName removed port $ID");
if ($back_t == 1) {
header("Location: $USERPREFIX/computers-info.php?ID=$back");
} else {
header("Location: $USERPREFIX/networking-info.php?ID=$back");
}
?>
