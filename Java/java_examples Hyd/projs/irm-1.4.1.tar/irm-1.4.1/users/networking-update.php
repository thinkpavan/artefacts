<?php
#    IRM - The Information Resource Manager
#    Copyright (C) 2000 Yann Ramin
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
#    $Id: networking-update.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  4/9/00 - Added								. #
################################################################################

require("../include/irm.inc");

AuthCheck("tech");

$comments = addslashes($comments);
$query = "REPLACE networking VALUES ($ID, '$name', '$type', '$ram','$ip','$mac','$location',
		'$serial', '$otherserial', '$contact', '$contact_num', NOW(), '$comments')";
$count = $adb->dbh_do($query);
logevent($ID, "networking", 4, "database", "$IRMName updated record");
header("Location: $HTTP_REFERER");

?>