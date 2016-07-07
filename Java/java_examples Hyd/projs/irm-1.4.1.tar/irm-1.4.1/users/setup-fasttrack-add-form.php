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
#    $Id: setup-fasttrack-add-form.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Added CHANGELOG                                #
################################################################################


include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Setup - FastTrack Templates Add Form");

if ($add == 1) 
{
  PRINT "<h3>FastTrack Template Added Successfuly</h3>";
  PRINT "<hr noshade>";
}

PRINT "Use this form to add a FastTrack template, or <a href=\"$USERPREFIX/setup-fasttrack.php\">
		Go back to FastTrack templates</a><br>";
PRINT "<table width=100% border=1 noshade><form method=post 
		action=\"$USERPREFIX/setup-fasttrack-add.php\"><tr bgcolor=#CCCCCC>
		<th><font face=\"Arial, Helvetica\">";
$new_date = date("Y-m-d H:i:s");
PRINT "<strong>Add FastTrack Template </th></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><strong>FastTrack Template name: </strong><input type=text name=templname value=\"$templname\" size=40></strong>";
PRINT "</font></td></tr>\n";
PRINT "</table>\n";
PRINT "<br>\n";
PRINT "<FORM METHOD=get ACTION=\"$USERPREFIX/tracking-fasttrack-add.php\">\n";
PRINT "<table border=1 width=100%><tr><th>Computer";
if($cfg_groups == 1)
{
	PRINT "/Group";
}
PRINT " Information</th></tr>";
PRINT "<tr bgcolor=#DDDDDD><TD>";
PRINT "<INPUT TYPE=\"RADIO\" NAME=\"IDTYPE\" VALUE=\"IRMID\"><STRONG> IRM ID: </STRONG><INPUT TYPE=text NAME=ID SIZE=10>&nbsp;&nbsp;\n";
PRINT "<INPUT TYPE=hidden NAME=is_group VALUE=\"no\">\n";
PRINT "<BR>\n";
if($cfg_groups == 1)
{
	PRINT "<INPUT TYPE=\"RADIO\" NAME=\"IDTYPE\" VALUE=\"GROUP\"> ";
	PRINT "<STRONG>Select a group:</STRONG>";
	Dropdown_groups("groups", "gID");
	PRINT "<INPUT TYPE=\"HIDDEN\" NAME=\"is_group\" VALUE=\"yes\">\n";
}
PRINT "</TD>\n";
PRINT "</TR>\n";
PRINT "</TABLE>\n";
PRINT "<BR>\n";
PRINT "<table border=1 width=100%><tr><th>Work Request Information</th></tr>";
PRINT "<tr bgcolor=#DDDDDD><TD>";
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
PRINT "</TABLE>\n";
PRINT "<BR>\n";
PRINT "<table border=1 width=100%><tr><th>Additional Information</th></tr>";
PRINT "<tr bgcolor=#DDDDDD><TD>";
PRINT "<STRONG>Assign to:</STRONG>\n";
$track = new Tracking($ID);
$assign = $track->getAssign();
if($assign != "")
{
	Tech_list($assign, "user");
} else
{
	Tech_list("","user");
}

PRINT "<BR><BR>\n";
PRINT "<STRONG>Set Status to:</STRONG>\n";


PRINT "<SELECT NAME=status SIZE=1>";
PRINT "<OPTION VALUE=\"active\">Active</OPTION>";
PRINT "<OPTION VALUE=\"assigned\">Assigned</OPTION>";
PRINT "<OPTION VALUE=\"complete\">Complete</OPTION>";
PRINT "<OPTION VALUE=\"new\" selected>New</OPTION>";
PRINT "<OPTION VALUE=\"old\">Old</OPTION>";
PRINT "<OPTION VALUE=\"wait\">Wait</OPTION>";
PRINT "</SELECT>";

PRINT "<BR><BR><input type=checkbox name=addtoknowledgebase value=yes ";
PRINT "> If tracking is marked as complete, should it be used to add something to the knowledgebase?</td></tr>\n";
PRINT "</table>";
PRINT "<table border=0 width=100%><TR><TD><input type=submit value=Submit></TD><tr></table>";
PRINT "</form>";
PRINT "<br>";
commonFooter();
?>
