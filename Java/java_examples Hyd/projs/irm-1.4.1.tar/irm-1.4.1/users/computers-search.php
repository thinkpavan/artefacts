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
#    $Id: computers-search.php,v 1.3 2002/05/17 04:09:21 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  7/24/99 - Keith Schoenefeld: Added in stuff for phrasetype.  In             #
#				comptuers-index.php the user now specifies    #
#				whether they want to do an exact phrase search #
#				or a contains search on the field.  Now the    #
#				% sign on the mysql query is added only if the #
#				user selects contains.                         #
#  7/25/99 - Yann Ramin: Passed phrasetype to the computerListView so 	       #
#			 multi-paged list views search correctly.              #
#  7/27/99 - Yann Ramin: Added 'batch add software' link                       #
#  8/16/99 - Keith Schoenefeld:	Added mods to lab setup.                       #
################################################################################

include("../include/irm.inc");

AuthCheck("normal");
commonHeader("IRM Computers - Search Results");
# If phrase is only a contains search, add the % characters for the mysql query.
if ($phrasetype == "contains")
{
  $newcontains = "%$contains%";
} else
{
  $newcontains = $contains;
}

$tempquery = "SELECT * FROM computers WHERE ($field LIKE '$newcontains') ORDER BY $sort";

PRINT "Showing results where $field contains $contains in $style view 
		sorted by $sort.<br><br>";
PRINT "<table border=0 width=100%>";
PRINT "<tr>";
#PRINT "<td align=center><h4><form method=post 
#		action=\"$USERPREFIX/computers-software-batch.php\"><input type=hidden 
#		name=aquery value=\"$tempquery\"><input type=submit 
#		value=\"Batch Add Software with this Query\"></form>";
#PRINT "</h4></td>";
if($cfg_groups == 1)
{
PRINT "<td align=center><h4><form method=get 
		action=\"$USERPREFIX/computers-groups-batch.php\"> <input type=hidden 
		name=aquery value=\"$tempquery\"><input type=submit 
		value=\"Setup groups with this query\"></form>";
PRINT "</h4></td>";
}
PRINT "</tr>";
PRINT "</table>";
PRINT "<hr noshade>";


if ($style == "full")
{
  $query = "SELECT * FROM computers WHERE ($field LIKE '$newcontains') ORDER BY $sort";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		for($i = 0; $i < $numRows; $i++)
  	{
			$result = $sth->fetchrow_hash();
			if($i < $goto)
			{
    		$ID = $result["ID"];
    		showComputer($ID, 0);
    		if (($goto + 4 - $i) < 1)
    		{
      		break;
    		}
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
    PRINT "<form><input type=hidden name=sort value=\"sort\">
		<input type=hidden name=field value=\"$field\">
		<input type=hidden name=phrasetype value=\"$phrasetype\">
		<input type=hidden name=contains value=\"$contains\">
		<input type=hidden name=style value=\"$style\">
		<input type=hidden name=goto value=$backgoto>
		<input type=submit value=\"Previous 5\"></form>";
  }
  PRINT "</td><td>";
  PRINT "<form><input type=hidden name=sort value=\"$sort\">
		<input type=hidden name=field value=\"$field\">
		<input type=hidden name=phrasetype value=\"$phrasetype\">
		<input type=hidden name=contains value=\"$contains\">
		<input type=hidden name=style value=\"$style\">
		<input type=hidden name=goto value=$forgoto>
		<input type=submit value=\"Next 5\"></form>";
  PRINT "</td></tr></table>";
} elseif ($style == "list")
{
  $query = "SELECT * FROM computers WHERE ($field LIKE '$newcontains') 
		ORDER BY $sort";
  computerListView($query, $sort, $phrasetype);
}
commonFooter();
?>
