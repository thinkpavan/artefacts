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
#    $Id: software-index.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################
include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM Software");
?>
Welcome to the IRM Software section.  This where you keep information about all
<?php
PRINT "of your software. <a href=\"$USERPREFIX/software-add-form.php\">";
?>
Click here to add software</a>
<p>Or you might want to search through the software:
<br>
<?php
PRINT "<form method=get action=\"$USERPREFIX/software-search.php\"><select name=\"field\" size=1>";
?>
<option value="ID">IRM ID</option>
<option value="name">Name</option>
<option value="platform">Platform</option>
<option value="license">Number of Licenses</option>
<option value="comments">Comments</option>
<option value="class">Class</option>
</select> where that field contains 
<input type=text size=30 name="contains"> and then show in <select name=style>
<option value=list selected>list view</option>
<option value=full>full view</option>
</select>. <input type=submit value="Search"></form>
<hr noshade>
<?php
$query = "SELECT * FROM software ORDER BY class,name";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	PRINT "<table border=1 width=100%><tr bgcolor=#CCCCCC>
	<th>Class</th>
	<th>Name</th><th>Platform</th><th>Licenses</th></tr>";
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$ID = $result["ID"];
  	$name = $result["name"];
  	$class = $result["class"];
  	$platform = $result["platform"];
  	$license = Count_licenses($ID);
  	PRINT "<tr bgcolor=#DDDDDD>
		<TD>$class</TD>
		<td><a href=\"$USERPREFIX/software-info.php?ID=$ID\">
		$name ($ID)</a></td><td>$platform</td><td>";
  	$installed = Count_installations($ID);
  	$remaining = $license - $installed;
  	PRINT "<font face=\"Arial, Helvetica\">Installed: <b>$installed</b> Remaining: <b>";
  	if ($remaining < 0) 
		{
			PRINT "<font color=red>";
  	} else if ($remaining == 0) 
		{
			PRINT "<font color=blue>";
		} else 
		{
			PRINT "<font color=black>";
		}

		PRINT "$remaining</font></b> Total: <b>$license</b></font></td>";
		PRINT "</tr>";
	}
	$sth->finish();
} else
{
	PRINT "Could not prepare query: ".$sth2->errstr."<br>\n";
}
PRINT "</table>";
commonFooter();
?>
