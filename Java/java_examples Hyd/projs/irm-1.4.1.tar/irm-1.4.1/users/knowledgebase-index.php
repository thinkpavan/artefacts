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
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
################################################################################

include("../include/irm.inc");

AuthCheck("post-only");

commonHeader("IRM Knowledge Base");
?>
This is the IRM Knowledge Base system. It allows you to view all of the 
knowledge base articles that have been entered.
<br>
<BR>
<table border=0 width=100%>
<tr>
<?php
PRINT "<td align=center><h4><a href=\"$USERPREFIX/knowledgebase-article-add.php\">Add an Article</a>";
?>
		</h4></td></tr>
</TABLE>
<?php
kbdisplaycategories();
commonFooter();
?>
