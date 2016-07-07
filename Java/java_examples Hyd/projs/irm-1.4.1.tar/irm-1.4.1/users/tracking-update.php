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
#    $Id: tracking-update.php,v 1.0 
#
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");

$badperms = false;
$datenow = date("Y-m-d H:i:s");
$user2 = new User($IRMName);
$type = $user2->getType();
$permissions = $user2->permissionCheck("tech");
$track = new Tracking($tID);
$isStat = $track->isStatus($status);
$isAssign = $track->isAssign($user);

if($permissions)
{
	if(!$isStat)
	{
		$track->setStatus($status);
	}
	if(!$isAssign)
	{
		$track->setAssign($user);
	}
} else
{
	if((!$isStat) || (!$isAssign))
	{
		$badperms = true;
	}
}

$trimmedFollowup = trim($newfollowup);

if($trimmedFollowup != "")
{
	$follow = new Followup();
	$follow->setAuthor($IRMName);
	$follow->setFollowupInfo($newfollowup);
	$follow->setDateEntered($date);
	$track->addFollowup($follow);
}
$track->commit();

if($status == "complete" && $addtoknowledgebase == "yes" && $permissions)
{
	header("Location: $USERPREFIX/knowledgebase-article-add.php?from_tracking=$tID");
} else
{
	commonHeader("IRM Tracking - Update Information");
	PRINT "<a href=\"$HTTP_REFERER\">Go Back</a><hr noshade><br>";
	if($badperms)
	{
		PRINT "Since you are not a technician or administrator, you can not change";
		PRINT "the status of this work request, nor who it is assigned to.<BR> You are $IRMName\n";
	}
	PRINT "<H4>Tracking $tID has been updated</H4>\n";
	commonFooter();
}
logevent($tID, "computers", 4, "tracking", "Tracking job modified");
?>
