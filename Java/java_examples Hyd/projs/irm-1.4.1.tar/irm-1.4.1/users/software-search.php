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
#    $Id: software-search.php,v 1.2.4.1 2003/02/21 05:30:55 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM Software - Search Results");
PRINT "Showing results where $field contains $contains in 
		$style view.<ht noshade>";
if ($style == "full")
{
  $query = "SELECT * FROM software WHERE ($field LIKE '%$contains%') ORDER BY name";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		for($i=0; $i < $goto; $i++)
		{
			$sth->fetchrow_hash();
		}
  	for($i = $goto; $i < $numRows; $i++)
  	{
			$result = $sth->fetchrow_hash();
    	$ID = $result["ID"];
    	showSoftware($ID, 0);
    	if (($numRows - $i) < 5)
    	{
      	break;
    	}
  	}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
  $backgoto = $goto - 5;
  $forgoto = $goto + 5;
  PRINT "<table border=0><tr><td>";
  if ($backgoto > -1)
  {
    PRINT "<form><input type=hidden name=field value=\"$field\"><input 
		type=hidden name=contains value=\"$contains\"><input 
		type=hidden name=style value=\"$style\"><input type=hidden 
		name=goto value=$backgoto><input type=submit 
		value=\"Previous 5\"></form>";
  }
  PRINT "</td><td>";
  PRINT "<form><input type=hidden name=field value=\"$field\"><input 
		type=hidden name=contains value=\"$contains\"><input 
		type=hidden name=style value=\"$style\"><input type=hidden 
		name=goto value=$forgoto><input type=submit 
		value=\"Next 5\"></form>";
  PRINT "</td></tr></table>";
} elseif ($style == "list")
{
  $query = "SELECT * FROM software WHERE ($field LIKE '%$contains%')";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
  	PRINT "<table border=1 width=100%><tr
  	bgcolor=#CCCCCC><th>Name</th><th>Platform</th><th>Licnses</th></tr>";
  	for($i=0; $i < $numRows; $i++)
  	{
			$result = $sth->fetchrow_hash();
    	$ID = $result["ID"];
    	$name = $result["name"];
    	$platform = $result["platform"];
    	$license = $result["license"];
   		PRINT "<tr bgcolor=#DDDDDD><td><a href=\"$USERPREFIX/software-info.php?ID=$ID\">
			$name ($ID)</a></td><td>$platform</td><td>";
   	 
  		$installed = Count_installations($ID);
  		$remaining = $license - $installed;
  		PRINT "<font face=\"Arial, Helvetica\">Installed: <b>$installed</b> Remaining: <b>";
  		if ($remaining <= 0) {
        	PRINT "<font color=red>";
  		}
  		PRINT "$remaining</font></b> Total: <b>$license</b></font></td>";
  		PRINT "</tr>";
  	}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
  PRINT "</table>";
}
commonFooter();
?>
