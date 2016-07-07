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
#  $Id: knowledgebase-article-add.php,v 1.2.4.1 2003/02/24 16:48:10 racer Exp $
#
################################################################################

include("../include/irm.inc");

AuthCheck("tech");
if($commit != 1)
{
	commonHeader("IRM Knowledge Base - Add Article");
	if(isset($from_tracking))
	{
		$track = new Tracking($from_tracking);
		$question = $track->getWorkRequest();
		$answer = $track->getFollowupsInfo();
		if($answer == "")
		{
			$answer = "No followups were added, please put something here in the answer!\n";
		} 
	}
	?>
	Here is where you can add an article to the knowledge base.
	<hr noshade>
	<BR>
	<?php
	PRINT "<form method=post action=\"$USERPREFIX/knowledgebase-article-preview.php\">";
	PRINT "Select the category in which this article should be placed: ";
	kbcategoryList($categorylist);
	?>
	<br>
	<br>
	Enter the question here.  Please be as detailed as possible with the question, but don't repeat information that can be inferred by the category.
	<br>
	<?php
	PRINT "<textarea cols=50 rows=14 wrap=soft name=question>$question</textarea>"; 
	?>
	<br>
	Enter the answer here.  Please be as detailed as possible with the answer, including a step by step process.
	<br>
	<?php
	PRINT "<textarea cols=50 rows=14 wrap=soft name=answer>$answer</textarea>"; 
	PRINT "<br>\n";
	PRINT "<input type=checkbox name=faq value=\"yes\"> Place this Knowledge Base Article into the publicly viewable FAQ as well. <BR>\n";
	PRINT "<input type=submit value=\"Preview Article\"> <input type=reset value=\"Reset\"></form>";
} else
{
	$question = addslashes($question);
	$answer = addslashes($answer);
	if($modify == 1)
	{
		commonHeader("IRM Knowledge Base - Article Modified");
		$query = "REPLACE kbarticles VALUES('$ID', '$categorylist', '$question', '$answer', '$faq')";
		$adb->dbh_do($query);
		PRINT "Article has been modified, <A HREF=\"$USERPREFIX/knowledgebase-detail.php?ID=$ID\">Go Back</A>\n";
	} else
	{
		commonHeader("IRM Knowledge Base - Article Added");
		$query = "INSERT INTO kbarticles VALUES (NULL, '$categorylist', '$question', '$answer', '$faq')";
		$adb->dbh_do($query);
		PRINT "Article has been added, <A HREF=\"$USERPREFIX/knowledgebase-index.php\">Go Back</A>\n";
	}
}
commonFooter();
?>
