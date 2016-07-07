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
#    $Id: software-add-form.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Software - Add Form");
PRINT "Fill out this form to add a new software package.";
PRINT "<table width=100% border=1 noshade><form method=post 
		action=\"$USERPREFIX/software-add.php\">
		<input type=hidden name=ID 
		value=\"$ID\"><tr bgcolor=#CCCCCC><td colspan=3>
		<font face=\"Arial, Helvetica\">";

PRINT "<strong>New Software</strong>";

PRINT "</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">
		Name:<br>
		<input type=text name=name value=\"$name\" size=24>
		</font></td>

		<td><font face=\"Arial, Helvetica\">Platform:<br>";

Dropdown_value("dropdown_os", "platform", $platform);
PRINT "</font></td><td><font face=\"Arial, Helvetica\">Class:<BR>
		<SELECT name=class>
		<OPTION value=Application selected>Application</OPTION>
		<OPTION value=\"Application Bundle\">Application Bundle</OPTION>
		<OPTION value=CAL>Client Access License</OPTION>
		<OPTION value=Server>Server</OPTION>
		<OPTION value=\"Operating System\">Operating System</OPTION>
</SELECT>";

print "</font></td></tr>";

PRINT "<tr bgcolor=#DDDDDD> 
	<td colspan=3><font face=\"Arial,Helvetica\">
		Comments:<br><textarea cols=80 rows=5 name=comments 
		wrap=soft>$comments</textarea></font></td></tr>";
PRINT "<tr bgcolor=#CCCCCC><td colspan=3><input type=submit value=Add>
		<input type=reset value=Reset></form></td></tr></table>";
PRINT "<br>";

commonFooter();
?>
