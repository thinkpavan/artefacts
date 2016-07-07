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
#    $Id: networking-del.php,v 1.3 2002/05/17 04:09:21 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################
include("../include/irm.inc");
 
 AuthCheck("tech");
 
 commonHeader("IRM Networking Device - Deleted");
 
 $query = "SELECT id FROM networking_ports WHERE (device_on = '$ID' AND device_type = 2)";
 $sth = $adb->prepare($query);
 $res = $sth->execute();
 $numRows = $sth->rows();
 for ($i=0; $i < $numRows; $i++) {
   $result = $sth->fetchrow_hash();
   $portid = $result["id"];
   $query = "DELETE FROM networking_wire WHERE end1='$portid' OR end2='$portid'";
   $count = $adb->dbh_do($query);
 } 
 
 $query = "DELETE FROM networking WHERE (ID = \"$ID\")";
 $count = $adb->dbh_do($query);
 $query = "DELETE FROM networking_ports WHERE (device_on = \"$ID\" AND device_type = 2)";
 $count = $adb->dbh_do($query);
  ?>
   I have deleted that networking device and all associated ports.  What happened?  Did you break it?
     <?php
     commonFooter();
  ?>
