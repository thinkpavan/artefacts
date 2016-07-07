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
#    $Id: software-bundle-add-software.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
#	This file created by Mica Currie. March 14th, 2001.

include("../include/irm.inc");
AuthCheck("admin");
#
# First we need to make sure it's ok to Add/Delete software
# AKA we are not allowed to do it if we have any installed licenses.
#
$query = "select * from inst_software WHERE sID=$bID ORDER BY sID";
$count = $adb->dbh_do($query);
if ($count==0) {
	$query = "INSERT INTO software_bundles  
		( sID, bID ) VALUES 	('$sID','$bID')";

	$count = $adb->dbh_do($query);

	header("Location: $HTTP_REFERER");
	
} else {
	commonHeader("Software Bundle: Add Software Error");
	print "We have copies of this bundle installed. You may not alter
		    the software included with this bundle. <BR>
			<a href=$HTTP_REFERER>Return to Previous Screen</A>";
	commonFooter();
}

?>
