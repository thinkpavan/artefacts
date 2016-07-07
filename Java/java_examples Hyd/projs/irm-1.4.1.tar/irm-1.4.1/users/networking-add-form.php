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
#    $Id: networking-add-form.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Networking - Add Form");
PRINT "Fill out this form to add a new networking device.";
  PRINT "<table width=100% border=1 noshade><form method=get
		action=\"$USERPREFIX/networking-add.php\"><tr bgcolor=#CCCCCC><td
		colspan=2><font face=\"Arial, Helvetica\">";

  PRINT "<strong>New Device</strong>";
  PRINT "</font></td></tr>";
  PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial,
		Helvetica\">Name:<br><input type=text name=name
		value=\"$name\" size=24></font></td><td><font face=\"Arial,
		 Helvetica\">Type:<br>";

  Dropdown_value("dropdown_type", "type", $type);

  PRINT "</font></td></tr>";
  PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">
		Location:<br>";

  Dropdown_value("dropdown_locations", "location", $location);

  PRINT "</font></td><td>RAM amount: <br><input type=text name=ram
		value=\"$ram\" size=5>";
  PRINT "</font></td></tr>";
  PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">
		Serial Number:<br><input type=text name=serial size=35
		value=\"$serial\"></font></td><td><font face=\"Arial,
		Helvetica\">Other Serial Number:<br><input type=text
		size=25 name=otherserial value=\"$otherserial\">
		</font></td></tr>";
  PRINT "<tr bgcolor=#DDDDDD><td>IP:<br><input type=text name=ip value=\"$ip\" size=20></td><td>MAC:<br><input
  	type=text size=20 name=mac value=\"$mac\"></td></tr>";
  PRINT "<tr bgcolor=#DDDDDD><td>Contact:<br><input type=text name=contact value=\"$contact\" size=20>";

  PRINT "</td>";
  PRINT "<td>Contact Number:<br><input type=text name=contact_num size=20 value=\"$contact_num\"></td></tr>";
  PRINT "<tr bgcolor=#DDDDDD><td colspan=2><font face=\"Arial,
		Helvetica\">Comments:<br><textarea cols=40 rows=5
		name=comments wrap=soft>$comments</textarea></font></td></tr>";
  PRINT "<tr bgcolor=#CCCCCC><td><input type=submit value=Add>
		
		</td><td>
		<input type=reset value=Clear></td></tr></table>";
  PRINT "<br>";
PRINT "Add <input type=text name=numports size=3 value=8> initial ports of type ";
Dropdown("dropdown_iface", "ifacetype");
PRINT " to device.</form>";
commonFooter();
?>
