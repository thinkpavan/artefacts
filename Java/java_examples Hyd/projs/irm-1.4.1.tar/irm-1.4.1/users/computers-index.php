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
#    $Id: computers-index.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  7/24/99 - Keith Schoenefeld:	Added a link to comp-loc-specific-search.php  #
#				This makes location searches find only exact   #
#				instead I recommend that the location search   #
#				be incorperate into the other search routine   #
#				and that a check box for "contains" or "exact  #
#				phrase" is added.                              #
#  7/24/99 - Keith Schoenefeld:	Added the location option to the drop down     #
#				so that IRM still supports location searches   #
#				based on "contains".                           #
#  7/24/99 - Keith Schoenefeld: Added the ability to specify exact phrase or   #
#				contains searches on any field.  As a result,  #
#				the individual location search was             #
#				incorperated with the other search options.    #
#  7/25/99 - Yann Ramin: Re-added Location: dropdown view.
#  8/16/99 - Keith Schoenefeld:	Redesigned the	display of "Add a computer"    #
################################################################################

include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM Computers");
?>
Welcome to the IRM Computer Tracking utility!  This is where you store
information about your various computers scattered about your organization. 
Below are tools in which you can view your computers, as well as edit and add
entries. 
<hr noshade>
<table border=0 width=100%>
<tr>
<?php
  PRINT "<td align=center><h4><a href=\"$USERPREFIX/computers-add-select.php\">Add a computer";
?>
		</a></h4></td>
</tr>
</table>
<?php
PRINT "<table border=1 width=100%><tr><th>View by Location</th></tr>";
PRINT "<tr bgcolor=#DDDDDD><TD>";
PRINT "<form method=get action=\"$USERPREFIX/computers-search.php\">";
Dropdown( "dropdown_locations",  "contains");
PRINT " and show in <input type=hidden name=field value=location>\n";
PRINT "<select name=style>";
PRINT "<option value=list selected>list view</option>\n";
PRINT "<option value=full>full view</option>\n";
PRINT "</select> sorted by <select name=sort size=1>\n";
PRINT "<option value=\"name\">Name</option>\n";
PRINT "<option value=\"ID\">IRM ID</option>\n";
PRINT "<option value=\"location\">Location</option>\n";
PRINT "<option value=\"type\">Type</option>\n";
PRINT "<option value=\"os\">Operating System</option>\n";
PRINT "<option value=\"osver\">Operating System Version</option>\n";
PRINT "<option value=\"processor\">Processor</option>\n";
PRINT "<option value=\"processor_speed\">Processor Speed</option>\n";
PRINT "<option value=\"serial\">Serial Number</option>\n";
PRINT "<option value=\"otherserial\">Other Number</option>\n";
PRINT "<option value=\"ramtype\">RAM Type</option>\n";
PRINT "<option value=\"ram\">RAM Amount</option>\n";
PRINT "<option value=\"network\">Network Card Type/Brand</option>\n";
PRINT "<option value=\"ip\">IP Address</option>\n";
PRINT "<option value=\"mac\">MAC/Network Address</option>\n";
PRINT "<option value=\"hdspace\">Hard Drive Capacity</option>\n";
PRINT "<option value=\"comments\">Comments</option>\n";
PRINT "<option value=\"contact\">Contact Person</option>\n";
PRINT "<option value=\"contact_num\">Contact Number</option>\n";
PRINT "<option value=\"date_mod\">Date Last Modified</option>\n";
PRINT "</select>.\n";
PRINT "<input type=hidden name=phrasetype value=exact>\n";
PRINT "<input type=submit value=Show></form>\n";
PRINT "</TD>\n";
PRINT "</TR>\n";
PRINT "</TABLE>\n";
PRINT "<BR>\n";
PRINT "<table border=1 width=100%><tr><th>Detailed Search</th></tr>\n";
PRINT "<tr bgcolor=#DDDDDD><TD>";
PRINT "<form method=get action=\"$USERPREFIX/computers-search.php\">";
PRINT "<select name=\"field\" size=1>\n";
PRINT "<option value=\"ID\">IRM ID</option>\n";
PRINT "<option value=\"name\">Name</option>\n";
PRINT "<option value=\"location\">Location</option>\n";
PRINT "<option value=\"type\">Type</option>\n";
PRINT "<option value=\"os\">Operating System</option>\n";
PRINT "<option value=\"osver\">Operating System Version</option>\n";
PRINT "<option value=\"processor\">Processor</option>\n";
PRINT "<option value=\"processor_speed\">Processor Speed</option>\n";
PRINT "<option value=\"serial\">Serial Number</option>\n";
PRINT "<option value=\"otherserial\">Other Number</option>\n";
PRINT "<option value=\"ramtype\">RAM Type</option>\n";
PRINT "<option value=\"ram\">RAM Amount</option>\n";
PRINT "<option value=\"network\">Network Card Type/Brand</option>\n";
PRINT "<option value=\"ip\">IP Address</option>\n";
PRINT "<option value=\"mac\">MAC/Network Address</option>\n";
PRINT "<option value=\"hdspace\">Hard Drive Capacity</option>\n";
PRINT "<option value=\"comments\">Comments</option>\n";
PRINT "<option value=\"contact\">Contact Person</option>\n";
PRINT "<option value=\"contact_num\">Contact Number</option>\n";
PRINT "<option value=\"date_mod\">Date Last Modified</option>\n";
PRINT "</select> where that field \n";
PRINT "<select name=phrasetype>\n";
PRINT "<option value=contains>contains</option>\n";
PRINT "<option value=exact>is the exact phrase</option>\n";
PRINT "</select>\n";
PRINT "<input type=text size=30 name=\"contains\"> \n";
PRINT "and then show in <select name=style>\n";
PRINT "<option value=list selected>list view</option>\n";
PRINT "<option value=full>full view</option>\n";
PRINT "</select> and sort by  <select name=sort size=1>\n";
PRINT "<option value=\"name\">Name</option>\n";
PRINT "<option value=\"ID\">IRM ID</option>\n";
PRINT "<option value=\"location\">Location</option>\n";
PRINT "<option value=\"type\">Type</option>\n";
PRINT "<option value=\"os\">Operating System</option>\n";
PRINT "<option value=\"osver\">Operating System Version</option>\n";
PRINT "<option value=\"processor\">Processor</option>\n";
PRINT "<option value=\"processor_speed\">Processor Speed</option>\n";
PRINT "<option value=\"serial\">Serial Number</option>\n";
PRINT "<option value=\"otherserial\">Other Number</option>\n";
PRINT "<option value=\"ramtype\">RAM Type</option>\n";
PRINT "<option value=\"ram\">RAM Amount</option>\n";
PRINT "<option value=\"network\">Network Card Type/Brand</option>\n";
PRINT "<option value=\"ip\">IP Address</option>\n";
PRINT "<option value=\"mac\">MAC/Network Address</option>\n";
PRINT "<option value=\"hdspace\">Hard Drive Capacity</option>\n";
PRINT "<option value=\"comments\">Comments</option>\n";
PRINT "<option value=\"contact\">Contact Person</option>\n";
PRINT "<option value=\"contact_num\">Contact Number</option>\n";
PRINT "<option value=\"date_mod\">Date Last Modified</option>\n";
PRINT "</select>. <input type=submit value=\"Search\"></form>\n";
PRINT "</TD>\n";
PRINT "</TR>\n";
PRINT "</TABLE>\n";

commonFooter();
?>
