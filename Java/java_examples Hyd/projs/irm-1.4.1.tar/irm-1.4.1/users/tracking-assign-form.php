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
#    $Id: tracking-assign-form.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Tracking - Assign");
PRINT "Please select who you wish to assign this job to below:<br>";

PRINT "<form method=post action=\"$USERPREFIX/tracking-assign.php\">";

$track = new Tracking($ID);
$assign = $track->getAssign();

if($assign != "")
{
	Tech_list($assign, "user");
} else
{
	Tech_list("","user");
}
PRINT "<input type=hidden name=ID value=$ID><input type=submit value=Assign></form>";

commonFooter();

?>
