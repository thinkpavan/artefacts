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
#    $Id: computers-groups-batch.php,v 1.3 2002/05/17 04:09:21 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/16/99 - Keith Schoenefeld: Added file for groups code.                    #
################################################################################

require("../include/irm.inc");

AuthCheck("tech");
commonHeader("IRM Computers - Setup computers in groups");
PRINT "Use this utility to Setup computers in groups.<br><hr noshade>";
PRINT "<table width=100% border=1 noshade bordercolor=#000000>\n";
PRINT "<tr bgcolor=#DDDDDD><td colspan=\"2\">\n";
PRINT "Add all computers from previous search to group";
PRINT "<form method=post action=\"$USERPREFIX/computers-groups-batch-add.php\">";
Dropdown_groups("groups", "sID");
PRINT "</td></tr>\n";
PRINT "<tr bgcolor=#CCCCCC><td align=center><form method=post 
		action=\"$USERPREFIX/computers-groups-batch-add.php\"> <input type=hidden 
		name=aquery value=\"a$query\"><input type=submit 
		value=Add></form></td>\n";
PRINT "<td align=center><form method=post 
		action=\"$USERPREFIX/computers-groups-batch-del.php\"><input type=hidden 
		name=aquery value=\"a$query\"><input type=hidden 
		name=sID value=$sID> <input type=submit value=Delete>
		</form></td>\n";
PRINT "</tr></table>";

PRINT "<br>NOTE: Sometimes this may take a while, depending on the number of 
		computers you have (in upwards of 10 seconds).";

commonFooter();
?>
