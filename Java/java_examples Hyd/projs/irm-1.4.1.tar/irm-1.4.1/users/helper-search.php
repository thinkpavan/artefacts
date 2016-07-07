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
#    $Id: helper-search.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  7/24/99 - Keith Schoenefeld: Added the text "on computer's name". The       #
#				"click below" was confusing people.            #
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");
commonHeader("IRM Help Desk - Is this the computer?");
?>
Please confirm that you entered the correct IRM ID or name.  If the computer matches,
simply click on the computer's name below.
<hr noshade>
<?php
if ($typeofsearch == "id") 
{
	$query = "SELECT ID,name,type,location FROM computers WHERE (ID = $ID)";
} else 
{
	$query = "SELECT ID,name,type,location FROM computers WHERE (name LIKE '%$name%')";
}	
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	 
	if($numRows < 1) 
	{
  	PRINT "Bad IRM ID or search terms";
	} else if ($numRows > 5) 
	{
		# Security, can't list all computers
		PRINT "Your search terms were to vague, and yeilded more than 5 results.  Please try again.";
	} else 
	{
 		for ($i = 0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
  		$ID = $result["ID"];
  		$name = $result["name"];
  		$location = $result["location"];
  		$type = $result["type"];
  		PRINT "<a href=\"$USERPREFIX/helper-add.php?ID=$ID&is_group=no\">$name ($ID)</a>
			<br>Type: $type<br>Location: $location<br>";
 		}
	}	
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
?>

<?php
commonFooter();
?>
