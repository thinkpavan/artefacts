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
#    $Id: helper-preview.php,v 1.3 2003/01/30 17:14:25 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/20/99 - Yann Ramin: Preview features, nicer text, et al                   #
#  9/11/99 - Keith Schoenefeld:	Added stuff for groups option                  #
# 11/18/99 - Keith Schoenefeld:	Changed it so that <br> stuff wasn't added to  #
#				$contents.  Instead using the nl2br function   #
#				to convert "\n" to "<br>" whenever the         #
#				$contents variable is displayed in a web page. #
# 12/4/99 - Yann Ramin: Fixed bug when adding quotes (") to tracking.
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");
commonHeader("IRM Tracking - Preview");
/* Start error checking */

if ($uname == "") {
	$error = 1;
	PRINT "The following error occured with your request for help: You did not enter a name.<br>";
	}
if ($uemail == "") {
	$error = 1;
	PRINT "The following error occured with your request for help: You did not enter an e-mail address.<br>";
	}
if ($ID < 0) {
	$error = 1;
	PRINT "A very unusual error occured.  Contact your sysadmin.<br>";
	}
if ($contents == "") {
	$error = 1;
	PRINT "The following error occured with your request for help:  You did not enter any problem description.<br>";

	}

/* End error checking */

$contents = htmlspecialchars($contents);

if ($error != 1) {
	PRINT "Please check that the job you are about to submit is correct.  If it is not, use the provided links to re-edit it.";
} else {
	PRINT "<br><b>Errors occured with your request for help.  Your only option is to re-edit the job.</b><br>";
	}
?>
<hr noshade>

<?php
if($emailupdates == "")
{
	$emailupdates = "no";
}
PRINT "<form method=post action=\"$USERPREFIX/helper-add.php\">";
PRINT "<input type=hidden name=status value=new>";
PRINT "<input type=hidden name=uname value=\"$uname\">";  
PRINT "<input type=hidden name=uemail size=19 value=\"$uemail\">"; 
PRINT "<input type=hidden name=emailupdates value=\"$emailupdates\">";
PRINT "<input type=hidden name=ID value=\"$ID\">";
PRINT "<input type=hidden name=is_group value=\"$is_group\">";
PRINT "<input type=hidden name=contents value=\"$contents\">";
?>
<input type=submit value="Re-edit Job"></form> 

<br>
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
PRINT "<br><strong>Priority:</strong> $priority";
PRINT "<br><strong>Your Name: </strong> $uname";
PRINT "<br><strong>Your E-Mail:</strong> $uemail";
PRINT "<br><strong>Computer:</strong> $computername ($ID) <br>";
$htmlcontents = nl2br($contents);
PRINT "<br><strong>Problem Report:</strong><br>$htmlcontents<br>";

if ($error != 1) 
{
	$contents = "By: $uname ($uemail)\n$contents";
	PRINT "<form method=post action=\"$USERPREFIX/tracking-add.php\">";
	PRINT "<input type=hidden name=priority value=\"$priority\">";
	PRINT "<input type=hidden name=ID value=\"$ID\">";
	PRINT "<input type=hidden name=is_group value=\"$is_group\">";
	PRINT "<input type=hidden name=status value=new>";
  PRINT "<input type=hidden name=contents value=\"$contents\">";
	PRINT "<input type=hidden name=uemail value=\"$uemail\">";
	PRINT "<input type=hidden name=emailupdates value=\"$emailupdates\">";
	PRINT "<input type=submit value=\"Add job\"></form>";
}
 
PRINT "<br>";
commonFooter();
?>
