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
#    $Id: networking-port-add-form.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  3/17/00 - Yann Ramin: Added file to allow port operations (disconnect, connect)
################################################################################

include("../include/irm.inc");


AuthCheck("tech");

commonHeader("IRM Networking - Add Port");
PRINT "Fill out this simple form to add a port to the device<hr noshade>\n";
?>

<?php
PRINT "<form method=get action=\"$USERPREFIX/networking-port-add.php\">";
PRINT "<table border=1>\n";	

		PRINT "<tr><td>Logical Number:</td><td><input type=text size=5 name=logical_number value=$logical_number></td></tr>";
		PRINT "<tr><td>Name</td><td><input type=text size=20 value=\"$name\" name=name></td></tr>";
		PRINT "<tr><td>Interface</td><td>";
		Dropdown_value("dropdown_iface","iface", $iface);
		
		
		PRINT "</td></tr>";
		PRINT "<tr><td>Interface Address</td><td><input type=text size=20 name=ifaddr value=\"$ifaddr\"></td></tr>";
		PRINT "<tr><td>Interface MAC</td><td><input type=text size=25 name=ifmac value=\"$ifmac\"></td></tr>";
		
		PRINT "<tr><td><input type=hidden name=device value=$device><input type=hidden name=device_type value=$device_type><input type=submit value=Add></td><td><input type=reset value=Clear></td></tr></form>";
PRINT "</table>";
commonFooter();
?>
