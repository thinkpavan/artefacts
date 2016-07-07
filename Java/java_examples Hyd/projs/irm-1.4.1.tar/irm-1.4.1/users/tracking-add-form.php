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
#    $Id: tracking-add-form.php,v 1.3 2002/06/20 01:34:32 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");

commonHeader("IRM Tracking - Add Job");
?>
To add a job, fill out this handy form.
<hr noshade>
<?php
PRINT "<form method=get action=\"$USERPREFIX/tracking-add.php\">";
?>
<br>
<strong>Date:</strong><br><?php echo date("Y-m-d H:i:s"); ?>
<br><strong>Status:</strong><br><select name=status>
<option value=new selected>New Job</option>
<option value=old>Historical</option>
</select>
<br>
<strong>Priority:</strong><br><select name=priority>
<option value=5>Very High</option>
<option value=4>High</option>
<option value=3 selected>Normal</option>
<option value=2>Low</option>
<option value=1>Very Low</option>
</select>
<br><strong>Author:</strong><br>
<?php echo $IRMName; ?>
<br><strong>Computer:</strong> <br>
<?php $query = "SELECT name FROM computers WHERE (ID = $ID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$computername = $result["name"];
	$sth->finish();
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
?>
<?php
PRINT "$computername ($ID)"; 
PRINT "<input type=hidden name=ID value=\"$ID\">";
PRINT "<input type=hiddem name=uemail value=\"$uemail\">";
?>
<br><strong>Describe the problem/action:</strong>
<br>
<textarea cols=50 rows=14 wrap=soft name=contents></textarea>
<br>
<input type=submit name="Post Job"><input type=reset value="Reset"></form>
<?php
commonFooter();
?>
