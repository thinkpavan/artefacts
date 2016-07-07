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
#  $Id: knowledgebase-article-modify.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
#  8/20/99 - Yann Ramin: Preview features, nicer text, et al                   #
#  9/11/99 - Keith Schoenefeld:	Added stuff for group stuff.                   #
#  9/17/99 - Yann Ramin: ID error checking code                                #
# 11/03/99 - Keith Schoenefeld:	If a normal user or admin enters new tracking  #
#				it will automatically enter their name and     #
#				email address into the help request form.      #
# 11/03/99 - Keith Schoenefeld:	Added the ability for someone to request       #
#				updates to tracking they enter via email.      #
################################################################################

include("../include/irm.inc");

AuthCheck("tech");

commonHeader("IRM Knowledge Base - Modify Article");

$query = "select * from kbarticles where (ID = $ID)";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$answer = $result["answer"];
	$question = $result["question"];
	$faq = $result["faq"];
	$categorylist = $result["categoryID"];
} else
{
	PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
}

PRINT "Here is where you can modify an article that is in the knowledge base.\n";
PRINT "<hr noshade>\n<BR>\n";
PRINT "<form method=post action=\"$USERPREFIX/knowledgebase-article-preview.php\">";
PRINT "Select the category in which this article should be placed: ";
kbcategoryList($categorylist);
PRINT "<br>\n<br>\nModify the question here.  Please be as detailed as possible with the question, but don't repeat information that can be inferred by the category.\n<br>\n";
PRINT "<textarea cols=50 rows=14 wrap=soft name=question>$question</textarea>"; 
PRINT "<br>\nModify the answer here.  Please be as detailed as possible with the answer, including a step by step process.\n<br>";
PRINT "<textarea cols=50 rows=14 wrap=soft name=answer>$answer</textarea>\n"; 
PRINT "<br>\n";
	PRINT "<input type=checkbox name=faq value=\"yes\" ";
	if($faq == "yes")
	{
		PRINT "checked";
	}
	PRINT ">Place this Knowledge Base Article into the publicly viewable FAQ as well.<BR>\n";
PRINT "<input type=hidden name=modify value=1>\n";
PRINT "<input type=hidden name=ID value=$ID>\n";
PRINT "<input type=submit value=\"Preview Article\"> <input type=reset value=\"Reset\"></form>\n";
commonFooter();
?>
