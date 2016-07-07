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
#    $Id: knowledgebase-article-preview.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#
################################################################################

include("../include/irm.inc");

AuthCheck("tech");
commonHeader("IRM Knowledge Base Article - Preview");

/* Start error checking */

if ($question == "") 
{
	$error = 1;
	PRINT "The following error occured with your request for help:  You did not enter any question.<br>";
}

if ($answer == "") 
{
	$error = 1;
	PRINT "The following error occured with your request for help:  You did not enter any answer.<br>";
}

$categoryname = kbcategoryname($categorylist);

if ($categoryname == "") 
{
	$error = 1;
	PRINT "The following error occured with your request for help:  You did not enter any category (You may not post Knowledge Base Articles in Main).<br>";
}

if ($error != 1) 
{
	PRINT "Please check that the article you are about to submit is correct.  If it is not, use the provided links to re-edit it.";
} else {
	PRINT "<br><b>Errors occured with your request for help.  Your only option is to re-edit the article.</b><br>";
}
$question = htmlspecialchars($question);
$answer = htmlspecialchars($answer);
?>
<hr noshade>

<?php
PRINT "<form method=post action=\"$USERPREFIX/knowledgebase-article-add.php\">";
PRINT "<input type=hidden name=categorylist value=\"$categorylist\">";
PRINT "<input type=hidden name=question value=\"$question\">";
PRINT "<input type=hidden name=answer value=\"$answer\">";
PRINT "<input type=hidden name=faq value=\"$faq\">";
?>
<input type=submit value="Re-edit Article"></form> 

<br>
<?php
$htmlquestion = nl2br($question);
$htmlanswer = nl2br($answer);
$categoryname = kbcategoryname($categorylist);
PRINT "Category Selected was: $categoryname\n<BR><HR>";
PRINT "<br><strong>Question:</strong><br>$htmlquestion<br><hr>";
PRINT "<br><strong>Answer:</strong><br>$htmlanswer<br>";

if ($error != 1) 
{
	PRINT "<form method=post action=\"$USERPREFIX/knowledgebase-article-add.php\">";
  PRINT "<input type=hidden name=categorylist value=\"$categorylist\">";
  PRINT "<input type=hidden name=modify value=\"$modify\">";
  PRINT "<input type=hidden name=commit value=\"1\">";
  PRINT "<input type=hidden name=ID value=\"$ID\">";
  PRINT "<input type=hidden name=question value=\"$question\">";
	PRINT "<input type=hidden name=answer value=\"$answer\">";
	PRINT "<input type=hidden name=faq value=\"$faq\">";
	PRINT "<input type=submit value=\"Add Article\"></form>";
}

 
PRINT "<br>";
commonFooter();
?>
