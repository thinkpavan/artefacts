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
#    $Id: setup-fasttrack-add.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");
$templname = htmlspecialchars($templname);
$contents = htmlspecialchars($contents);
$solution = htmlspecialchars($solution);
$query = "INSERT INTO fasttracktemplates VALUES (NULL, '$templname', '$priority', '$contents',
		'$solution')";
$result = $adb->dbh_do($query);

if ($result == 1)
{
  header("Location: $HTTP_REFERER?add=1\n\n");

}
if ($result != 1)
{
  commonHeader("IRM Setup - FastTrack Template Add Error");
}
?>
