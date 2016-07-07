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
#    $Id: setup-fasttrack-edit.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Setup - FastTrack Templates Edit");

$query = "select * from fasttracktemplates where (ID=$ID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$name = $result["name"];
	$priority = $result["priority"];
	$request = $result["request"];
	$response = $result["response"];
}
PRINT "Use this form to edit a FastTrack template, or ";
PRINT "<a href=\"$USERPREFIX/setup-fasttrack.php\"> Go back to FastTrack";
PRINT " templates</a><br>";
PRINT "<table width=100% border=1 noshade><form method=post ";
PRINT " action=\"$USERPREFIX/setup-fasttrack-update.php\"><tr bgcolor=#CCCCCC>";
PRINT "<td colspan=2><font face=\"Arial, Helvetica\">";
$new_date = date("Y-m-d H:i:s");
PRINT "<strong>FastTrack Template Name <input type=text name=templname 
		value=\"$name\" size=40></strong>";
PRINT "</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><TD colspan=2>";
PRINT "<STRONG>Priority:</STRONG> <SELECT NAME=priority>\n";
PRINT "<OPTION VALUE=5";
if($priority == 5)
{
	PRINT " selected";
}
PRINT ">Very High</OPTION>\n";
PRINT "<OPTION VALUE=4";
if($priority == 4)
{
	PRINT " selected";
}
PRINT ">High</OPTION>\n";
PRINT "<OPTION VALUE=3";
if($priority == 3)
{
	PRINT " selected";
}
PRINT ">Normal</OPTION>\n";
PRINT "<OPTION VALUE=2";
if($priority == 2)
{
	PRINT " selected";
}
PRINT ">Low</OPTION>\n";
PRINT "<OPTION VALUE=1";
if($priority == 1)
{
	PRINT " selected";
}
PRINT ">Very Low</OPTION>\n";
PRINT "</SELECT>\n";
PRINT "<BR>\n";
PRINT "<BR>\n";
PRINT "<STRONG>Describe the problem:</STRONG>\n";
PRINT "<BR>\n";
PRINT "<textarea cols=50 rows=4 wrap=soft name=contents>$request</textarea>"; 
PRINT "<BR><BR>\n";
PRINT "<STRONG>Describe the solution (will be added as a followup):</STRONG>\n";
PRINT "<BR>\n";
PRINT "<textarea cols=50 rows=4 wrap=soft name=solution>$response</textarea>\n"; 
PRINT "</TD>\n";
PRINT "</TR>\n";
PRINT "<input type=hidden name=ID value=$ID>";
PRINT "<tr bgcolor=#CCCCCC><td><input type=submit value=Update></td><td>
		<input type=Reset value=Reset></form></td></tr></table>";
PRINT "<br>";
PRINT "<br>";
commonFooter();

?>
