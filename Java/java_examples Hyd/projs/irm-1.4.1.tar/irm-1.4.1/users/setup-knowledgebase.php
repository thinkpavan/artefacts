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
#    $Id: setup-knowledgebase.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  8/16/99 - Keith Schoenefeld:	Added file so we could add categories to the   #
#							Knowledge Base.                                                  #
################################################################################
include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Knowledge Base Setup");
?>
Welcome to the IRM Knowledge Base Setup utility.  Here you can add, modify,
or delete a category from the IRM Knowledge Base.
<hr noshade>
<?php
$query = "SELECT * FROM kbcategories";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$numRows = $sth->rows();
	for($i = 0; $i < $numRows; $i++)
	{
		$result = $sth->fetchrow_hash();
  	$id = $result["ID"];
  	$categoryname = $result["name"];
  	$parentID = $result["parentID"];
	$fullcategoryname  = kbcategoryname($id);
  	PRINT "<form method=post action=\"$USERPREFIX/setup-knowledgebase-update.php\">
			<table width=100% border=1 noshade bordercolor=#000000>
			<tr bgcolor=#CCCCCC><td colspan=2><strong>$fullcategoryname
			</strong></td></tr>";
  	PRINT "<tr bgcolor=#DDDDDD>";
  	PRINT "<td><font face=\"arial, helvetica\">Category Name:
			<br><input type=text size=\"65%\" 
			name=categoryname value=\"$categoryname\">";
  	PRINT "</font></td>";
		PRINT "<td><font face=\"arial, helvetica\">As a subcategory of: ";
		$query2 = "select * from kbcategories where (ID = $parentID)";
		$sth2 = $adb->prepare($query2);
		if($sth2)
		{
			$res2 = $sth2->execute();
			$result2 = $sth2->fetchrow_hash();
			$current = $result2["ID"];
			kbcategoryList($current);
		} else
		{
			PRINT "Could not prepare query: ".$sth2->errstr."<br>\n";
		}
		PRINT "</font></td>\n";
		PRINT "\n</tr>\n";
  	PRINT "<tr bgcolor=#CCCCCC><td valign=center><input type=hidden 
			name=id value=\"$id\"><input type=submit 
			value=Update></form></td><td valign=center><form method=get 
			action=\"$USERPREFIX/setup-knowledgebase-del.php\"><input type=hidden 
			name=id value=\"$id\"><input type=hidden name=categoryname 
			value=\"$categoryname\"><input type=submit 
			value=Delete></form></td></tr></table>";
  	PRINT "<br>";
	}
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
}
PRINT "<a name=\"add\"></a><hr noshade><h4>Add a Category</h4>";
PRINT "<form method=post action=\"$USERPREFIX/setup-knowledgebase-add.php\"><table width=100% 
		border=1 noshade bordercolor=#000000><tr bgcolor=#CCCCCC>
		<td colspan=2><strong>New Category</strong></td></tr>";
PRINT "<tr bgcolor=#DDDDDD> <td><font face=\"arial, helvetica\">Name:<br> 
		<input type=text size=\"65%\" name=categoryname></td>";
		PRINT "<td><font face=\"arial, helvetica\">As a subcategory of: ";
		kbcategoryList(0);
		PRINT "</td>";
PRINT "</tr>";
PRINT "<tr bgcolor=#CCCCCC><td colspan=2><input type=submit value=Add>
		</td></tr></table></form>";

?>
<?php
commonFooter();
?>
