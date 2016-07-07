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
#    $Id: setup-users.php,v 1.4 2002/08/28 03:28:37 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################
include("../include/irm.inc");

AuthCheck("admin");

commonHeader("IRM User Setup");
PRINT "Welcome to the IRM User Setup utility.  Here you can ";
if($AUTHSOURCE == "DB")
{
	PRINT "change, view, delete, and add users to the IRM database. \n";
	PRINT "<a href=\"#add\">Click here to add users.</a>\n";
} else
{
	PRINT "view and update users in the IRM database. \n";
	PRINT "<a href=\"./ldapupdate.php\">Click here to update the database information from LDAP.</a>\n";
}
PRINT "<hr noshade>\n";

$user = new User();
$user->displayAllUsers();


PRINT "<a name=\"add\"></a><hr noshade>";
PRINT "<form method=post action=\"$USERPREFIX/setup-user-add.php\"><table width=100% 
		border=1 noshade bordercolor=#000000><tr bgcolor=#CCCCCC>
		<th colspan=2><strong>Add a New User</strong></th></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\"><table width=100$ border=0 bgcolor=#DDDDDD><tr><td width=50%>Username: 
		<br><input type=text width=20 name=username></td><td width=50%>Full Name:<BR><INPUT TYPE=TEXT WIDTH=40 NAME=fullname></td></tr></font></table></td>
		<td><font face=\"arial, helvetica\">Password:<br> 
		<input type=password width=20 name=password></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">E-mail: 
		<br><input type=text width=20 name=email></font></td><td>
		<font face=\"arial, helvetica\">Phone:<br> <input 
		type=text width=20 name=phone></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">Location: 
		<br><input type=text width=20 name=location></font></td>
		<td><font face=\"arial, helvetica\"> User Type:<br>";
		PRINT "<select name=type>\n";
		PRINT "<option value=admin>Administrator</option>\n";
		PRINT "<option value=normal>Normal</option>\n";
		PRINT "<option value=post-only selected>Post Only</option>\n";
		PRINT "<option value=tech>Technician</option>\n";
		PRINT "</select>\n</td></tr>";
PRINT "<tr bgcolor=#CCCCCC><td colspan=2><input type=submit value=Add>
		</td></tr></table></form>";

commonFooter();
?>
