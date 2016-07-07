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
#    $Id: setup-knowledgebase-del.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/16/99 - Keith Schoenefeld:	Added this file for group stuff                #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Knowledge Base Setup - Category Deleted");
$query = "DELETE FROM kbcategories WHERE (ID = \"$id\")";
$count = $adb->dbh_do($query);
$query = "DELETE FROM kbarticles WHERE ($parentID = \"$id\")";
$count = $adb->dbh_do($query);
?>
Category <?php echo "($id) $categoryname"; ?> Deleted!  Note: All articles under this 
<?php
PRINT "category has been deleted. <a href=\"$USERPREFIX/setup-knowledgebase.php\">Go Back</a>";
commonFooter();
?>
