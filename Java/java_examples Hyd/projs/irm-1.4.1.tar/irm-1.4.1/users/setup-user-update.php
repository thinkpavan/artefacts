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
#    $Id: setup-user-update.php,v 1.8 2003/02/09 22:55:58 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("admin");

commonHeader("IRM User Setup - User Update");

if($update == "act")
{
	$query = "UPDATE users SET password = '$password', fullname = '$fullname', email = '$email', location = '$location', phone = '$phone', type = '$type', comments = '$comments' WHERE name = '$username'";

	$count = $adb->dbh_do($query);
	logevent(-1, "IRM", 5, "setup", "$IRMName updated user $username");
	PRINT "Updated $username <a href=\"$USERPREFIX/setup-users.php\">Go back</a>";
} else if($update == "edit")
{
	$user = new User($username);
	$password = $user->getPassword();
	$fullname = $user->getFullname();
	$email = $user->getEmail();
	$location = $user->getLocation();
	$phone = $user->getPhone();
	$type = $user->getType();
	PRINT "<form method=get action=\"$USERPREFIX/setup-user-update.php\">
		<table width=100% border=1 noshade bordercolor=#000000>
		<tr bgcolor=#CCCCCC><td colspan=2><strong>$fullname</strong>
		</td></tr>";
	PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">
		<table width=100% border=0 noshade><tr bgcolor=$CCCCCC>
		<td width=\"50%\">Username: $username</td><td width=\"50%\">Full Name:<input type=text 
		width=40 name=fullname value=\"$fullname\"></td></tr>
		</table><input type=hidden width=20 name=username 
		value=\"$username\"></font></td><td><font face=\"arial, 
		helvetica\">Password:<br> <input type=password width=20 
		name=password value=\"$password\"></td></tr>";
	PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">E-mail: 
		<br><input type=text width=20 name=email value=\"$email\">
		</font></td><td><font face=\"arial, helvetica\">Phone:<br> 
		<input type=text width=20 name=phone value=\"$phone\">
		</td></tr>";
	PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">Location: 
		<br><input type=text width=20 name=location 
		value=\"$location\"></font></td><td><font face=\"arial, 
		helvetica\">User Type:<br>";
	PRINT "<select name=type>\n";
	PRINT "<option value=admin";
	if($type == "admin")
	{
		PRINT " selected";
	}
	PRINT ">Administrator</option>\n";
	PRINT "<option value=normal";
	if($type == "normal")
	{
		PRINT " selected";
	}
	PRINT ">Normal</option>\n";
	PRINT "<option value=post-only";
	if($type == "post-only")
	{
		PRINT " selected";
	}
	PRINT ">Post Only</option>\n";
	PRINT "<option value=tech";
	if($type == "tech")
	{
		PRINT " selected";
	}
	PRINT ">Technician</option>\n";
	PRINT "</select>\n";
	PRINT "<input type=hidden name=update value=\"act\">";
	PRINT "<tr bgcolor=#CCCCCC><td colspan=2 valign=center><input type=submit 
		value=Update></form></td></tr></table>";
	PRINT "<br>";
} else if($update == "delete")
{
 	PRINT "<form method=post action=\"$USERPREFIX/setup-user-del.php\">";
	PRINT "The user $username is about to be deleted from the database, to cancel this action click <A HREF=\"$USERPREFIX/setup-users.php\">here</A>.";
	PRINT "<br>\n";
 	PRINT "<input type=hidden name=username value=\"$username\">";
 	PRINT "<input type=submit value=Delete></form>";
} else
{
	PRINT "Invalid action request for user update <A HREF=\"$USERPREFIX/setup-users.php\">Go Back</A>\n";
}
commonFooter();
?>
