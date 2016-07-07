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
#    $Id: setup-templates-edit.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Setup - Templates Editor");


$query = "SELECT * FROM templates WHERE (ID = $ID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$ID = $result["ID"];
	$templname = $result["templname"];
	$name = $result["name"];
	$type = $result["type"];
	$os = $result["os"];
	$osver = $result["osver"];
	$processor = $result["processor"];
	$processor_speed = $result["processor_speed"];
	$location = $result["location"];
	$serial = $result["serial"];
	$otherserial = $result["otherserial"];
	$ramtype = $result["ramtype"];
	$ram = $result["ram"];
	$network = $result["network"];
	$ip = $result["ip"];
	$mac = $result["mac"];
	$hdspace = $result["hdspace"];
	$comments = $result["comments"];
	$flags_server = $result["flags_server"];
	$new_date = date("Y-m-d H:i:s");
	$iface = $result["iface"];
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}

PRINT "Use this form to edit template \"$templname\".  
		<a href=\"$USERPREFIX/setup-templates.php\">Back to Templates</a><br>";
PRINT "<table width=100% border=1 noshade><form method=post 
		action=\"$USERPREFIX/setup-templates-update.php\"><tr bgcolor=#CCCCCC>
		<td colspan=2><font face=\"Arial, Helvetica\">";
$new_date = date("Y-m-d H:i:s");
PRINT "<strong>Editing Template <input type=hidden name=ID value=\"$ID\">
		<input type=text name=templname value=\"$templname\" 
		size=40></strong>";

PRINT "</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">Name:<br>
		<input type=text name=name value=\"$name\" size=24></font>
		</td><td><font face=\"Arial, Helvetica\">Type:<br>";
Dropdown_value("dropdown_type", "type", $type);
PRINT "</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">Location:<br>";
Dropdown_value("dropdown_locations", "location", $location);
PRINT "</font></td><td><font face=\"Arial, Helvetica\">OS:<br>";
Dropdown_value("dropdown_os", "os", $os);
PRINT "</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">OS Version:
		<br><input type=text size=5 name=osver value=\"$osver\">
		</font></td><td><font face=\"Arial, Helvetica\">Processor:<br>";
Dropdown_value("dropdown_processor", "processor", $processor);

PRINT "</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">Processor 
		Speed:<br><input type=text name=processor_speed size=4 
		value=\"$processor_speed\"></font></td><td><font face=\"Arial, 
		Helvetica\">Serial Number:<br><input type=text name=serial 
		size=35 value=\"$serial\"></font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">Other Serial 
		Number:<br><input type=text size=25 name=otherserial 
		value=\"$otherserial\"></font></td><td><font face=\"Arial, 
		Helvetica\">Hard Drive Space (in gigabytes):<br>
		<input type=text name=hdspace size=5 value=\"$hdspace\">
		</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">RAM Type:<br>";
Dropdown_value("dropdown_ram", "ramtype", $ramtype);
PRINT "</font></td><td><font face=\"Arial, Helvetica\">RAM Amount (in MB):
		<br><input type=text name=ram value=\"$ram\" size=5>
		</font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">
		Network Card Brand/Type:<br>";
Dropdown_value("dropdown_network", "network", $network);
PRINT "</font></td><td><font face=\"Arial, Helvetica\">IP Address:<br>
		<input type=text name=ip value=\"$ip\" size=16></font>
		</td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">
		MAC/Network Address:<br><input type=text name=mac 
		value=\"$mac\"></font></td><td>Comments:<br><textarea cols=20 
		rows=5 name=comments wrap=soft>$comments</textarea></font>
		</td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td><font face=\"Arial, Helvetica\">Contact 
		Person:<br><input type=text name=contact size=20 
		value=\"$contact\"></font></td><td><font face=\"Arial, 
		Helvetica\">Contact Number:<br><input type=text 
		name=contact_num value=\"$contact_num\"></font></td></tr>";
PRINT "<tr bgcolor=#DDDDDD><td colspan=2><font face=\"Arial, Helvetica\"> Network Interface: ";
Dropdown_value("dropdown_iface", "iface", $iface);
PRINT "</td></tr>"; 
  PRINT "<tr bgcolor=#DDDDDD><td colspan=2><font face=\"Arial, Helvetica\">
  		Flags: ";
  if ($flags_server == 1) {
  	PRINT "<input type=checkbox name=flags_server value=yes checked>";
  } else {
  	PRINT "<input type=checkbox name=flags_server value=yes>";
  }

  PRINT " Server (constant running)</font></td></tr>";

PRINT "<tr bgcolor=#CCCCCC><td><input type=submit value=Update></td>
		<td><input type=Reset value=Reset></form></td></tr></table>";
PRINT "<br>";
templcompsoftShow($ID);
PRINT "<br>";	
?>
