<?php
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
#    $Id: index.php,v 1.8 2003/01/30 17:14:25 racer Exp $
#
include("../include/irm.inc");
AuthCheck("post-only");
$user = new User($IRMName);
$type = $user->getType();
if ($type == "post-only")
{
 	header("Location: $UPREFIX/users/helper.php\n\n");
 	exit();
}
commonHeader("IRM Command Center");
if($type == "admin" || $type == "tech")
{
	PRINT "Welcome to IRM, the Information Resource Manager!  This is the ";
	PRINT "command center.  The command center is designed to allow a quick ";
	PRINT "look at all work requests assigned to you, as well as an overview ";
	PRINT "of recent changes IRM.  You can navigate to any of the sub modules ";
	PRINT "of IRM by choosing the appropiate entry on the toolbar above.\n";
	PRINT "<p>\n";
	PRINT "<table border=1 width=100%>\n";
	PRINT "<tr><th>Last 5 Events</th></tr>\n";
	PRINT "<tr><td>\n";
	$query = "SELECT * FROM event_log ORDER BY date DESC LIMIT 0,5";
	$sth = $adb->prepare($query);
	show_events($sth);
	
	$query = "SELECT advanced_tracking,tracking_order FROM prefs WHERE (user = '$IRMName')";
	$sth = $adb->prepare($query);
	if($sth)
	{
  	$res = $sth->execute();
  	$result = $sth->fetchrow_hash();
  	$advanced_tracking = $result["advanced_tracking"];
  	$tracking_order = $result["tracking_order"];
  	$sth->finish();
	} else
	{
  	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
	
	if($tracking_order == "yes")
	{
  	$tracking_order = "ASC";
	} else
	{
  	$tracking_order = "DESC";
	}
	
	PRINT "</td></tr>\n";
	PRINT "<tr><th>Tracking</th></tr>\n";
	PRINT "<tr><td>\n";
	#
	# Show how many jobs you have assigned to you currently :)
	#
	$notClosed = Tracking::getNotClosed("yes", "individual", $tracking_order);
	$notClosedSize = sizeof($notClosed);
		
	PRINT "You have $notClosedSize ";
	PRINT "<A HREF=\"$USERPREFIX/tracking-index.php?show=individual\">";
	PRINT "job(s)</A> assigned to you.";
	if ($cfg_showjobsonlogin == 1)
	{
		Tracking::displayHeader();
		for($i=0;$i<$notClosedSize;$i++)
		{
			$track = new Tracking($notClosed[$i]);
			$track->display(1);
		}
		Tracking::displayFooter();
	}
	
	PRINT "</td></tr></table>\n";
}
if($type != "admin" && $type != "tech" && $type == "normal")
{
	PRINT "Welcome to IRM, the Information Resource Manager!  This is the ";
	PRINT "command center.  The command center is designed to allow a quick ";
	PRINT "look at all work requests entered by you, as well as give you ";
	PRINT "access to enter new work requests.  You can navigate to any of ";
	PRINT "the sub modules of IRM by choosing the appropiate entry on the ";
	PRINT "toolbar above.\n";
}
if ($type == "normal" || $type == "tech" || $type == "admin")
{
	PRINT "<table border=1 width=100%>\n";
	PRINT "<tr><th>Open Work Requests</th></tr>\n";
	PRINT "<tr><td>\n";
	$notClosed = Tracking::getNotClosedBy("ASC");
	$notClosedSize = sizeof($notClosed);
		
	PRINT "You have entered $notClosedSize ";
	PRINT "request(s) that have not yet been completed.";
	if ($cfg_showjobsonlogin == 1)
	{
		Tracking::displayHeader();
		for($i=0;$i<$notClosedSize;$i++)
		{
			$track = new Tracking($notClosed[$i]);
			$track->display(1);
		}
		Tracking::displayFooter();
	}
	
	PRINT "</td></tr></table>\n";
}
commonFooter();
?>
