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
#    $Id: computers-groups-setup.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/16/99 - Keith Schoenefeld: Added file for group code.                     #
################################################################################

require("../include/irm.inc");

AuthCheck("tech");
connectDB();
commonHeader("IRM Computers - Setup computers in groups");
PRINT "Use this utility to add computers to groups, or to remove 
		computers from groups.<br><hr noshade>";
PRINT "<form method=post action=\"$USERPREFIX/computers-groups-batch-add.php\">
		<input type=hidden name=query value=\"$query\">
		Add all computers from previous search to group";
Dropdown_groups("groups", "sID");
PRINT "<input type=submit value=Add></form>";
PRINT "<br>NOTE: Sometimes this may take a while, depending on the number of 
		computers you have (in upwards of 10 seconds).";

commonFooter();
?>
