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
#    $Id: reports-index.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  11/06/99 - Yann Ramin: 	Added reports feature. #
################################################################################

include("../include/irm.inc");
include("../include/reports.inc.php");
AuthCheck("normal");
$i = 0;
$count = count($report_list);
commonHeader("IRM Reports");
?>
Welcome to IRM Reports.  This new feature of IRM allows you to gain information
on your organization as a whole.  It is also the first modular section of IRM, allowing
easy integration of third-party report modules.  For information regarding writting
your own modules, take a look at docs/REPORTS in your IRM installation.
<!-- Remove some of that intro after awhile -->
<hr noshade>
Select a report module below:<br>

<?php
while($data = each($report_list)) {
	$val = $data[0];
	$name = $report_list["$val"]["name"];
	$file = $report_list["$val"]["file"];
	PRINT "<a href=\"$USERPREFIX/$file\">$name</a><br>";
	$i++;
	}

commonFooter();
?>
