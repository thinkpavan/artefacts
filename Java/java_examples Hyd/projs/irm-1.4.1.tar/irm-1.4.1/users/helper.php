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
#    $Id: helper.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Added CHANGELOG                                #
#  8/20/99 - Yann Ramin: More search options, limited though                   #
#  9/11/99 - Keith Schoenefeld:	Added group functionality                      #
#  9/11/99 - Keith Schoenefeld:	Set up the configuration option for name       #
#			searches                                               #
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");
commonHeader("IRM Help Desk");
?>
Welcome to the IRM Help Desk.  This is where you can request help with a
computing resource problem. The report a problem, just enter the IRM ID 
<?php if($cfg_trackingbyname == 1){ PRINT " or name "; } ?> of the computer below.
<?php
if($cfg_groups == 1)
{
  PRINT "Alternately, you can report problems with entire groups of \n";
  PRINT "computers by selecting it below.\n";
}
PRINT "<hr noshade>\n";
PRINT "<form method=get action=\"$USERPREFIX/helper-add.php\">\n";
PRINT "IRM ID: <input type=text name=ID size=10>&nbsp;&nbsp;\n";
PRINT "<input type=hidden name=is_group value=\"no\">\n";
PRINT "<input type=submit value=\"Continue with IRM ID\">\n";
PRINT "</form>\n";
PRINT "<br>\n";
if($cfg_usenamesearch == 1)
{
  PRINT "Or, you can enter the name of the computer:<br>";
  PRINT "<form method=get action=\"$USERPREFIX/helper-search.php\">\n";
  PRINT "Name: <input type=text name=name size=15> ";
  PRINT "<input type=submit value=\"Continue with Name\">\n</form>";
  PRINT "<br>\n";
}
if($cfg_groups == 1)
{
  PRINT "Or, you can select a group of computers:<br>";
  PRINT "<form method=get action=\"$USERPREFIX/helper-add.php\">\n";
  Dropdown("groups", "groupname");
  PRINT "<input type=hidden name=is_group value=\"yes\">\n";
  PRINT "<input type=submit value=\"Continue with group selection\">";
  PRINT "</form>";
}
commonFooter();
?>
