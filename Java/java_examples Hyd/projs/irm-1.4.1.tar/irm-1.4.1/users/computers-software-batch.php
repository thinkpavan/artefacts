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
#    $Id: computers-software-batch.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld: Cleaned up code, converted all IF(): to if(){. #
################################################################################

require("../include/irm.inc");

AuthCheck("tech");
commonHeader("IRM Computers - Batch Add Software");
	PRINT "Use this utility to batch add software.  NOTE: Currently you can't add more than 1 software item at a time<br><hr noshade>";
	PRINT "<font color=red size=+2>This has been disabled until it
		 can be rewritten to support License tracking</font>";
#	PRINT "<form method=post action=\"$USERPREFIX/computers-software-batch-add.php\"><input type=hidden name=query value=\"$query\">Add software ";
#	SoftwareDropdown();
#	PRINT " to all computers from the previous search.  <input type=submit value=Add></form>";
	PRINT "<br>NOTE: Sometimes this may take a while, depending on the number of computers you have (in upwards of 10 seconds).";

commonFooter();
?>
