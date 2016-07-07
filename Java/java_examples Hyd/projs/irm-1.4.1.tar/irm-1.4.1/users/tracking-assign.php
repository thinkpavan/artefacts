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
#    $Id: tracking-assign.php,v 1.3 2001/07/10 18:44:06 racer Exp $
#

################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/06/99 - Keith Schoenefeld: Added CHANGELOG to file :)                     #
#  8/06/99 - Keith Schoenefeld: Changed cfg_notifybyemail to                   #
#				cfg_notifyassignedbymeail to better            #
#				distinguish between the email notifications.   #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

# This catch exists because there are two ways of assigning a job.
if ($HTTP_REFERER == "$UPREFIX/users/tracking-assign-form.php?ID=$ID") {
	commonHeader("IRM Tracking - Assigned");
	PRINT "Job number $ID has been assigned to $user.\n<br>\n";
	commonFooter();
} else 
{
	header("Location: $HTTP_REFERER");
}
$track = new Tracking($ID);
$track->setAssign($user);
$track->setStatus("assigned");
$track->commit();
?>
