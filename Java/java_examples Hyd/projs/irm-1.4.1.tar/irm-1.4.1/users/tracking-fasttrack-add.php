<?php
################################################################################
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
#    $Id: tracking-fasttrack-add.php,v 1.3.2.1 2003/02/12 23:25:40 racer Exp $
#
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");

if($IDTYPE != "IRMID" && $IDTYPE != "GROUP")
{
	commonHeader("IRM Tracking - No IRM ID or Group name was selected");
	PRINT "ERROR: You forgot to select a computer or a group.\n";
	commonFooter();
	exit();
}

if($ufname == "")
{
	commonHeader("IRM Tracking - User's name was not entered");
	PRINT "ERROR: You did not enter the User's Name.\n";
	commonFooter();
	exit();
}

if($uemail == "")
{
	commonHeader("IRM Tracking - User's email address was not entered");
	PRINT "ERROR: You did not enter the User's email address.\n";
	commonFooter();
	exit();
}

if($IDTYPE == "IRMID")
{
	$query = "select * from computers where (ID=$ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
	}
	if($numRows != 1)
	{
		commonHeader("IRM Tracking - Bad IRM ID Number");
		PRINT "It appears that you have enetered an invalid IRM computer ID\n";
		commonFooter();
		exit();
	}
	
}

commonHeader("IRM Tracking - Added");

$opendate = date("Y-m-d H:i:s");

if($cfg_userupdates == 1)
{
	$emailupdates = "yes";
} else
{
	$emailupdates = "no";
}

if($status == "old" || $status == "complete")
{
	$closedate = date("Y-m-d H:i:s");
	$emailupdates = "no";
}

if($IDTYPE == "IRMID")
{
	$is_group = "no";
} else if($IDTYPE == "GROUP")
{
	$is_group = "yes";
	$ID = $gID;
}

$contents = "By: $ufname ($uemail)\n" . $contents;
$track = new Tracking();
$track->setDateEntered($opendate);
$track->setCloseDate($closedate);
$track->setStatus($status);
$track->setAuthor($IRMName);
$auth = $track->getAuthor();
$track->setAssign($user);
$track->setComputerID($ID);
$track->setWorkRequest($contents);
$track->setPriority($priority);
$track->setIsGroup($is_group);
$track->setAuthorEmail($uemail);
$track->setEmailUpdatesToAuthor($emailupdates);
if($solution != "")
{
	$follow = new Followup();
	$follow->setDateEntered($opendate);
	$follow->setAuthor($IRMName);
	$follow->setFollowupInfo($solution);
	$track->addFollowup(&$follow);
}
$track->add();
$trackingID = $track->getID();

logevent($ID, "computers", 4, "tracking", "New tracking job opened"); 

PRINT "That tracking job has been placed into the database.\n";
commonFooter();
?>
