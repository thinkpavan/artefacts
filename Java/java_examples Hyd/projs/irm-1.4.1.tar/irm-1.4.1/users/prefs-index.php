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
#    $Id: prefs-index.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("normal");
commonHeader("Your Preferences");

?>
This is the place to make IRM what you, and only you, want it to be.  Here you can change what you see in the computers list view, as well as change your password.
<hr noshade>
<?php
PRINT "<p align=center><a href=\"$USERPREFIX/passwd.php\">Change Your Password</a></p>";
?>
<hr noshade>
Here you can change what fields you see in the Computers list view.
<?php
PRINT "<form method=\"GET\" action=\"$USERPREFIX/prefs-update.php\">";
?>
<?php PRINT "<input type=hidden name=user value=\"$IRMName\">"; ?>


<?php
$query = "SELECT * FROM prefs WHERE (user = '$IRMName')";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
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
	$contact = $result["contact"];
	$contact_num = $result["contact_num"];
	$comments = $result["comments"];
	$date_mod = $result["date_mod"];
	$advanced_tracking = $result["advanced_tracking"];
	$tracking_order = $result["tracking_order"];
	$sth->finish();
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}

$advanced_tracking = Checked($advanced_tracking);
$comments = Checked($comments);
$contact = Checked($contact);
$contact_num = Checked($contact_num);
$date_mod = Checked($date_mod);
$hdspace = Checked($hdspace);
$ip = Checked($ip);
$location = Checked($location);
$mac = Checked($mac);
$network = Checked($network);
$os = Checked($os);
$osver = Checked($osver);
$otherserial = Checked($otherserial);
$processor = Checked($processor);
$processor_speed = Checked($processor_speed);
$ramtype = Checked($ramtype);
$ram = Checked($ram);
$serial = Checked($serial);
$tracking_order = Checked($tracking_order);
$type = Checked($type);

PRINT "<input type=checkbox name=type value=\"yes\" $type> Computer Type<br>";
PRINT "<input type=checkbox name=os value=\"yes\" $os> Operating System<br>";
PRINT "<input type=checkbox name=osver value=\"yes\" $osver> 
		Operating System Version<br>";
PRINT "<input type=checkbox name=processor value=\"yes\" $processor> 
		Processor<br>";
PRINT "<input type=checkbox name=processor_speed value=\"yes\" 
		$processor_speed> Processor Speed<br>";
PRINT "<input type=checkbox name=location value=\"yes\" $location> 
		Location<br>";
PRINT "<input type=checkbox name=serial value=\"yes\" $serial> 
		Serial<br>";
PRINT "<input type=checkbox name=otherserial value=\"yes\" $otherserial> 
		Other Serial Number<br>";
PRINT "<input type=checkbox name=ramtype value=\"yes\" $ramtype> 
		RAM Type<br>";
PRINT "<input type=checkbox name=ram value=\"yes\" $ram> RAM Amount<br>";
PRINT "<input type=checkbox name=network value=\"yes\" $network> 
		Network Card<br>";
PRINT "<input type=checkbox name=ip value=\"yes\" $ip> IP Address<br>";
PRINT "<input type=checkbox name=mac value=\"yes\" $mac> 
		Network/MAC Address<br>";
PRINT "<input type=checkbox name=hdspace value=\"yes\" $hdspace> 
		Hard Drive Space<br>";
PRINT "<input type=checkbox name=contact value=\"yes\" $contact> 
		Contact Person<br>";
PRINT "<input type=checkbox name=contact_num value=\"yes\" $contact_num> 
		Contact Number<br>";
PRINT "<input type=checkbox name=comments value=\"yes\" $comments> 
		Comments<br>";
PRINT "<input type=checkbox name=date_mod value=\"yes\" $date_mod> 
		Date Modified<br>";

PRINT "<hr noshade>";
PRINT "Here you can change what you see in the Tracking view.";
PRINT "<br>";
PRINT "<br>";
PRINT "<input type=checkbox name=advanced_tracking 
		value=\"yes\" $advanced_tracking>Advanced Tracking View<br>";
PRINT "<input type=checkbox name=tracking_order 
		value=\"yes\" $tracking_order>View Oldest Tracking First<br>";
?>
<p><input type=submit value=Change> <input type=reset value=Reset></form>


<?php
commonFooter();
?>
