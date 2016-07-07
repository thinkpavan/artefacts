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
#    $Id: tracking-fasttrack-autofill.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################
include("../include/irm.inc");

AuthCheck("admin");

commonHeader("IRM FastTrack - Auto Fill");
?>
Welcome to the IRM FastTrack Automatic Tracking Filler utility. 
<hr noshade>
<?php
$query = "SELECT * FROM fasttracktemplates";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
 	PRINT "<table width=100% border=1 noshade><tr><th><strong>Auto Fill Selections</strong></th></tr>";
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
		$ID = $result["ID"];
  	$name = $result["name"];
		$name_enc = str_replace(" ","%20",$name);
		PRINT "<tr bgcolor=\"#DDDDDD\"><td>\n";
		PRINT " <A HREF=\"$USERPREFIX/tracking-fasttrack.php?AUTOFILL=$ID\">";
  	PRINT "$name</A>";
		PRINT "</TD>\n";
		PRINT "</TR>\n";
	}
	PRINT "</TABLE>";
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
commonFooter();
?>
