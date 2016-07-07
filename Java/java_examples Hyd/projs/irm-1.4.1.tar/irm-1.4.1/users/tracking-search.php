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
#    $Id: tracking-search.php,v 1.3 2001/07/16 04:39:29 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  11/06/99 - Yann Ramin: Added file for searching			       #
################################################################################

include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM Tracking - Search");
?>
<h3>Search Results</h3>
These are your search results for the query: description contains <?php echo $contains; ?>.
<hr noshade>
<?php
$trackingIDs = Tracking::search("contents", $contains);
$numTrackingIDs = sizeof($trackingIDs);
Tracking::displayHeader();
for($i=0; $i < $numTrackingIDs; $i++)
{
	$track = new Tracking($trackingIDs[$i]);
	$track->display();
}
Tracking::displayFooter();
commonFooter();
?>
