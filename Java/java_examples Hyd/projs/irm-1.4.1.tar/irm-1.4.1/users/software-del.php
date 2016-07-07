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
#    $Id: software-del.php,v 1.3 2001/07/16 04:39:29 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################
include("../include/irm.inc");

AuthCheck("tech");

if ( $ORIG_REFERER) { $ORIG_REFERER = $HTTP_REFERER; }
$query = "SELECT * FROM software WHERE ID=$ID";
$sth = $adb->prepare($query);
if ($sth) {
  $res = $sth->execute();
  $result = $sth->fetchrow_hash();
  $name = $result[name];
  $class = $result["class"];
  $platform = $result["platform"];
}
$sth->finish();
#$installations = Count_installations($ID);
#$licenses = Count_licenses($ID);
if ($force==1) {
  $query = "DELETE FROM software WHERE (ID = \"$ID\")";
  $adb->dbh_do($query);
  $query = "DELETE FROM inst_software WHERE (sID = \"$ID\")";
  $adb->dbh_do($query);
  $query = "DELETE FROM templ_inst_software WHERE (sID = \"$ID\")";
  $adb->dbh_do($query);
  $query = "DELETE FROM software_bundles
      WHERE (sID = '$ID') OR (gID = '$ID')";
  $adb->dbh_do($query);
  $query = "DELETE FROM software_licenses
      WHERE (sID = '$ID')";
  $adb->dbh_do($query);
  header("Location: $UPREFIX/users/software-index.php");
} else {
  commonHeader("IRM Software - Deleted");
  print " <table align=right width=50%>
        <tr BGCOLOR=#DDDDDD><td>Name</td><td>$name</td></tr>
        <tr BGCOLOR=#DDDDDD><td>Class</td><td>$class</td></tr>
        <tr BGCOLOR=#DDDDDD><td>Platform</td><td>$platform</td></tr>
        <tr BGCOLOR=#DDDDDD><td>Installations</td><td>$installations</td></tr>
        <tr BGCOLOR=#DDDDDD><td>Licenses</td><td>$licenses</td></tr>
        <tr BGCOLOR=#DDDDDD><td>Bundles</TD><TD>$bundles</TD></tr>
        </table>";
  print "<p align=left>
       Deleting this package will result in the removal of all
         Associated Records. Are you sure you want to delete this
         package. Remember you will loose the following Information
       about this package:<ul><li>Installations<li>Licenses
       <li>Comments<li>Templates<li>Bundles. </ul>
  <BR>
  <a href=\"$ORIG_REFERER\">
  <font face=\"arial,helvetica\" size=+2>No</font></a>
&nbsp;&nbsp;&nbsp;
  <a href=\"$REQUEST_URI?ID=$ID&force=1&ORIG_REFERER=$HTTP_REFERER\">
  <font face=\"arial,helvetica\" size=+2>Delete</a> </font>
  <BR CLEAR=ALL>";
}
commonFooter();
?>
