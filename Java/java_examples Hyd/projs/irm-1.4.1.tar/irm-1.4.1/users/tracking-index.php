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
#    $Id: tracking-index.php,v 1.3 2001/07/16 04:39:29 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");

commonHeader("IRM Tracking");
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
if($advanced_tracking == "yes")
{
  PRINT "<form method=\"get\" action=\"$USERPREFIX/tracking-index.php\">";
  PRINT "<select name=\"show\" size=1>";
  PRINT "<option ";
  if($show == "all") 
  { 
    PRINT "selected"; 
  }
  PRINT " value=\"all\"> Show All Tracking</option>";
  PRINT "<option ";
  if($show == "individual") 
  {
    PRINT "selected"; 
  }
  PRINT " value=\"individual\">Show only tracking assigned to you</option>";
  PRINT "<option ";
  if($show == "unassigned")
  { 
    PRINT "selected"; 
  }
  PRINT " value=\"unassigned\">Show only tracking not assigned to 
		anyone</option>";
  PRINT "</select>";
  PRINT "<input type=submit value=\"Show\">";
  PRINT "</form>";
}
PRINT "<br>\n";
?>

This is the IRM tracking system it allows you to view the jobs currently in 
the queue.  In addition, you can click on "more info" next to any piece of 
tracking in order to view more detail or add followup information. 

<hr noshade>
<?php
PRINT "<form method=get action=\"$USERPREFIX/tracking-search.php\">";
?>
Search all of tracking for the following term: <input type=text name=contains size=20> <input type=submit value=Search>
</form>

<?php
$trackingIDs = Tracking::getNotClosed($advanced_tracking, $show, $tracking_order);
$numTrackingIDs = sizeof($trackingIDs);
if($numTrackingIDs != 1)
{
	PRINT "<H3>There are currently $numTrackingIDs Outstanding Jobs</H3>\n";
} else
{
	PRINT "<H3>There is currently $numTrackingIDs Outstanding Job</H3>\n";
}
Tracking::displayHeader();
for($i = 0; $i < $numTrackingIDs; $i++)
{
	$track = new Tracking($trackingIDs[$i]);
	$track->display();
}
Tracking::displayFooter();

commonFooter();
?>
