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
#    $Id: tracking-followups.php,v 1.5 2003/01/30 17:14:26 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  7/29/99 - Yann Ramin: Redid the entire page, hope you like it :)            #
#  10/31/99- Keith Schoenefeld:	Added an is_group to fix an error that occured #
#				when details were viewed on a group ticket     #
#  11/18/99- Keith Schoenefeld:	Added the nl2br function so that the $contents #
#				variable is properly html-ized.                #
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");

commonHeader("IRM Tracking - More Information");
PRINT "<a href=\"$HTTP_REFERER\">Go Back</a><hr noshade><br>";

PRINT "<FORM METHOD=POST ACTION=\"tracking-update.php\">\n";
$track = new Tracking($ID);
$track->displayDetail();
PRINT "<table border=1 width=100%><tr><th>Knowledge Base System</th></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><input type=checkbox name=addtoknowledgebase value=yes";
#if($status != "complete")
#{
	#PRINT " checked";
#}
PRINT "> If tracking is marked as complete, should it be used to add something to the knowledgebase?</td></tr>\n";
PRINT "</table>";
PRINT "<INPUT TYPE=hidden NAME=tID VALUE=$ID>";
PRINT "<INPUT TYPE=SUBMIT VALUE=\"Update Tracking\"><BR>\n";
PRINT "</form>";
PRINT "<br>";
commonFooter();
?>
