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
#	$Id: users-info.php,v 1.6 2002/09/16 03:47:17 racer Exp $    
#

include("../include/irm.inc");

AuthCheck("normal");
commonHeader("IRM User Info on $ID");
PRINT "<a href=\"$HTTP_REFERER\">Go Back</a><hr noshade>\n";

$user = new User($ID);
$fullname = $user->getFullname();
$user->displayLong();


$query = "SELECT tracking_order FROM prefs WHERE (user = '$IRMName')";
$sth = $adb->prepare($query);
if($sth)
{
  $res = $sth->execute();
  $result = $sth->fetchrow_hash();
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

PRINT "<table border=1 width=100%>\n";
PRINT "<tr><th>Requests entered by $fullname</th></th>\n";
PRINT "<tr><td>\n";
$notClosed = Tracking::getNotClosedBy("ASC", $ID);
$notClosedSize = sizeof($notClosed);

PRINT "$fullname has entered $notClosedSize ";
PRINT "request(s) that have not yet been completed.";
if ($cfg_showjobsonlogin == 1)
{
	Tracking::displayHeader();
	for($i=0;$i<$notClosedSize;$i++)
	{
		$track = new Tracking($notClosed[$i]);
		$track->display();
	}
	Tracking::displayFooter();
}
$type = $user->getType();
if(($type == "tech") || ($type == "admin"))
{
	PRINT "<tr><th>Requests assigned to $fullname</th></tr>\n";
	PRINT "<tr><td>\n";
	#
	# Show how many jobs you have assigned to you currently :)
	#
	$notClosed = Tracking::getNotClosed("yes", "individual", $tracking_order, "$ID");
	$notClosedSize = sizeof($notClosed);
		
	PRINT "$fullname has $notClosedSize job(s) assigned to him/her.";
	if ($cfg_showjobsonlogin == 1)
	{
		Tracking::displayHeader();
		for($i=0;$i<$notClosedSize;$i++)
		{
			$track = new Tracking($notClosed[$i]);
			$track->display();
		}
		Tracking::displayFooter();
	}
}	

PRINT "</td></tr></table>\n";
commonFooter();
?>
