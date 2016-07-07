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
#    $Id: helper-add.php,v 1.3 2001/07/10 18:44:06 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  8/20/99 - Yann Ramin: Preview features, nicer text, et al                   #
#  9/11/99 - Keith Schoenefeld:	Added stuff for group stuff.                   #
#  9/17/99 - Yann Ramin: ID error checking code                                #
# 11/03/99 - Keith Schoenefeld:	If a normal user or admin enters new tracking  #
#				it will automatically enter their name and     #
#				email address into the help request form.      #
# 11/03/99 - Keith Schoenefeld:	Added the ability for someone to request       #
#				updates to tracking they enter via email.      #
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");
$user = new User($IRMName);
$type = $user->getType();
$IRMemail = $user->getEmail();

if($type != "post-only")
{
	$uname = $IRMName;
	$fname = $user->getFullname();
	$uemail = $IRMemail;
}


if($is_group == "yes")
{
  $query = "select ID from groups where (name = \"$groupname\")";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
  	$ID = $result["ID"];
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
}

if($is_group == "no")
{
	$query = "SELECT name FROM computers WHERE (ID = $ID)";
} else
{
 	$query = "SELECT name FROM groups WHERE (ID = $ID)";
}
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
if ($numRows != 1) 
{
	commonHeader("IRM Tracking - Bad ID Number");
	PRINT "It appears that you have entered an incorrect IRM computer ID or group ID number.  Please <a href=\"$USERPREFIX/helper.php\">try again</a>.<br>";

	commonFooter();
	exit();
}

commonHeader("IRM Tracking - Add Job");
?>

You can use this form to submit a problem report or request help with a computing
resource in your organization.  Please fill out the entire form as clearly as possible.
<hr noshade>
<?php
PRINT "<form method=post action=\"$USERPREFIX/helper-preview.php\">";
?>
<br>
<input type=hidden name=status value=new>

<br>
First, pick how urgent your request is.  If it can wait, pick a low priority.  If you are stuck, pick a high priority.  If you are unsure how important the problem is, leaving it at its present value should be OK.
<br><br>
<strong>Priority:</strong><br><select name=priority>
<option value=5>Very High</option>
<option value=4>High</option>
<option value=3 selected>Normal</option>
<option value=2>Low</option>
<option value=1>Very Low</option>
</select>
<br>
<br>Next, we need to be able to tell who the job came from.  Please enter your name below.
 <br><br><strong>Author:</strong><br>
<?php
PRINT "<input type=text size=15 name=uname value=\"$fname\">";
?>
<br><br>
We need a way to get in contact with you.  Please provide an e-mail address.
<br><br>
<strong>E-Mail:</strong><br>
<?php PRINT "<input type=text name=uemail size=19 value=\"$uemail\">"; ?>
<br>
<?php
if($cfg_userupdates == 1)
{
  PRINT "<input type=checkbox name=emailupdates value=\"yes\" $emailupdates checked>
                I would like to receive email updates as changes such as followups are added to this tracking.<br>";
}
?>

<br>
<br><br><strong>The Computer or Group you are requesting work on:</strong> <br>
<?php
if($is_group == "no")
{
 $query = "SELECT name FROM computers WHERE (ID = $ID)";
} else
{
 $query = "SELECT name FROM groups WHERE (ID = $ID)";
}
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$computername = $result["name"];
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "$computername ($ID) <br>"; 
PRINT "<input type=hidden name=ID value=\"$ID\">";
PRINT "<input type=hidden name=is_group value=\"$is_group\">";
?>
<br><br>
Now you recieve the chance to explain your problem.  Please be as clear as possible, but also keep it short.  Do not simply type 'It doesn't turn on', but instead be more specific, for example, 'When I turn my computer on it makes a really loud grinding noise and nothing else happens.'
<br>
<br><strong>Describe the problem:</strong>
<br>
<?php
PRINT "<textarea cols=50 rows=14 wrap=soft name=contents>$contents</textarea>"; 
?>
<br>
<input type=submit value="Preview Job"> <input type=reset value="Reset"></form>
<?php
commonFooter();
?>
