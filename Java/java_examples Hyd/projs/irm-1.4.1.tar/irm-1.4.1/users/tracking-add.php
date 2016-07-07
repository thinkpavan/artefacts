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
#    $Id: tracking-add.php,v 1.3 2001/07/10 18:44:06 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, added CHANGELOG               #
#  7/22/99 - Keith Schoenefeld:	Added email to cfg_newtrackingemail            #
# 11/03/99 - Keith Schoenefeld:	Added email to $uemail if $cfg_userupdates is  #
#				configured in irm.inc and the user selected    #
#				to receive email updates when the tracking was #
#				entered.                                       #
# 3/17/00 - Yann Ramin: Fixed a serious bug in adding tracking not with a      #
#				group.  is_group got left blank in the db causing
#				tracking not to appear in comp-info
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");
commonHeader("IRM Tracking - Added");
$date = date("Y-m-d H:i:s");
if ($is_group == "") 
{
	$is_group = "no";
}

#$contents = AddSlashes($contents);

$track = new Tracking();
$track->setDateEntered($date);
$track->setStatus($status);
$track->setAuthor($IRMName);
$track->setComputerID($ID);
$track->setWorkRequest($contents);
$track->setPriority($priority);
$track->setIsGroup($is_group);
$track->setAuthorEmail($uemail);
$track->setEmailUpdatesToAuthor($emailupdates);
$track->add();

logevent($ID, "computers", 4, "tracking", "New tracking job opened"); 
?>
That tracking job has been placed into the database.  

<?php
commonFooter();
?>
