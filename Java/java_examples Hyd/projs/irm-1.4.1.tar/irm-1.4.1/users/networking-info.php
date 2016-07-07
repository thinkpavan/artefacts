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
#    $Id: networking-info.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  4/9/200 - Added file  Sort of adhoc - I really want tracking on these thins. #
################################################################################
include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM Networking - Device Information");

$query = "SELECT ID FROM networking WHERE (ID = $ID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$ID = $result["ID"];
  	showNetworking($ID);
	}
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
commonFooter();
?>
