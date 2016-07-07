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
#    $Id: computers-software-add.php,v 1.3 2001/07/16 04:39:29 racer Exp $
#

require("../include/irm.inc");

AuthCheck("tech");

$installs = Count_installations($sID);
$licenses = Count_licenses($sID);
$lID = find_license($sID);
if($lID > 0 or $force==1) 
{	# This block is run if we have found a license for our goal or
	# If we did not find a license for our goal and are installing
	# something else or forcing the install. In the later 2 cases
	# $gID is defined (from the form generated below) while in the 
	# first case $gID is not defined and should be our $sID.
	
	if (! $gID) { $gID = $sID; }; 
	$query = "INSERT INTO inst_software VALUES (NULL, $cID,$sID,$lID,$gID)";
	$count = $adb->dbh_do($query);
	if ( $force==1 ) {
		header("Location: $ORIG_REFERER");
	} else { 
		header("Location: $HTTP_REFERER");
	}
} else {
	commonHeader("Searching for Licenses");
	# We couldn't find any direct licenses for the product so
	# lets check for any software bundles that contain the product.
	$query = "SELECT software.name FROM software
					WHERE ID=$sID";
	$sth = $adb->prepare($query);
	if ($sth) {
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$sname = $result[name];
	}
	$sth->finish();
	$query = "SELECT software_bundles.bID, software.name 
		  FROM software_bundles 
		  LEFT JOIN software ON software.ID=software_bundles.bID
		  WHERE software_bundles.sID='$sID' 
		  ORDER BY software_bundles.bID";
	$sth = $adb->prepare($query);
	if ($sth) {
		$res = $sth->execute();
		$numRows = $sth->rows();
		print "I found the following ($numRows) Software
			bundles that contain the program you were
			looking for. You can either select the software you were 
			trying to install or you can select a bundle. Please note
			that this will force an installation even if there is no
			available license. This will also use goals to allow going
			back to see what license you wanted as opposed to which one
you
			installed.";
				$installs = Count_installations($sID);
				$licenses = Count_licenses($sID);
				$available = $licenses - $installs;

		print "\n<form action=computers-software-add.php method=post>
			<TABLE border=1 size=100%>
			<TR BGCOLOR=#BBBBBB><TD>&nbsp</TD><TD>Software</TD>
			<TD><B>Licenses</B> Available Installed/Licenses</TD></TR>
			<TR BGCOLOR=#DDDDDD><TD><input type=radio name=sID value=$sID></TD>
				<TD>$sname</TD>
				<TD>$available ($installs/$licenses)</TD><TR>";
		for ($i=0;$i<$numRows;$i++) {
			$result = $sth->fetchrow_hash();
			$name = $result[name];
			$bID = $result[bID];
			print "\n<TR BGCOLOR=#DDDDDD><TD>
				<input type=radio name=sID value=$bID>
				</TD><TD>$name ($bID)</TD>";
				
				$installs = Count_installations($bID);
				$licenses = Count_licenses($bID);
				$available = $licenses - $installs;
				print "<TD>$available ($installs/$licenses)</TD>
					</TR>";

		}

		print "</table><input type=submit  value=ADD>
			<input type=hidden name=cID value=$cID>
			<input type=hidden name=ORIG_REFERER value=$HTTP_REFERER >
			<input type=hidden name=gID value=$sID>
			<input type=hidden name=force value=1></form>\n\n";
	} else {
		print "Could not prepare query $sth->errstr $query ";
	}	
}


?>
