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
#    $Id: setup-index.php,v 1.2 2001/06/29 04:07:13 theatrus Exp $
#
#    Modifyed to fit more on one page.
#    Mica Currie, Barton Insurance.

include("../include/irm.inc");

AuthCheck("tech");


commonHeader("IRM Setup");
?>
Welcome to IRM Setup.  Here we will administer new users, setup various 
computer types and operating systems, network card brands, and (almost) 
everything else relating to IRM.
<br><br>
<table border=0 width=100%>
<tr>
<?php
PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-users.php\">Setup Users</a></h4></td>";
PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-templates.php\">Manage Templates</a>";
?>
		</h4></td></tr>
		<tr>
<?php
PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-irm.php\">Configure IRM</A></h4></td>";
if($cfg_groups == 1)
{
  PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-groups.php\">Setup computer groups";
  PRINT "</a></h4></td>\n";
}
if($cfg_knowledgebase == 1 && $cfg_fasttrack == 1)
{
	PRINT "<tr>\n";
	PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-knowledgebase.php\">Setup the Knowledge Base";
	PRINT "</a></h4></td>\n";
	PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-fasttrack.php\">Setup the FastTrack Templates";
	PRINT "</a></h4></td>\n";
	PRINT "</tr>\n";
} else if($cfg_knowledgebase == 1)
{
	PRINT "<tr>\n";
	PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-knowledgebase.php\">Setup the Knowledge Base";
	PRINT "</a></h4></td></tr>\n";
} else if($cfg_fasttrack == 1)
{
	PRINT "<tr>\n";
	PRINT "<td align=center><h4><a href=\"$USERPREFIX/setup-fasttrack.php\">Setup the Knowledge Base";
	PRINT "</a></h4></td></tr>\n";
}
?>

</tr>
</table>
<table width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>Locations</font>
Use this to edit where equipment can be stored
</TD></TR>

<TR><TD width=50% valign=top>
<?php
PRINT "<FORM method=get action=\"$USERPREFIX/setup-del.php\">";
Dropdown("dropdown_locations", "name"); 
?>
<input type=hidden name=tablename value=dropdown_locations>
		<input type=submit value="Delete">
</FORM></TD>
<TD width=50% valign=top><form action="setup-add.php">
		<input type=text maxlength=100 name=name>
		<input type=hidden name=tablename value=dropdown_locations>
		<input type=submit value="Add">
</FORM></TD>
</TR>
</TABLE>
<hr noshade width="50%">
<!-- Computer Types -->

<TABLE width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>Computer Types</font> These list
the types of computers you can have 
(i.e. Dell, HP, IBM RS/6000, etc.)
</TD></TR>
<TR><TD valign top width=50%>
<form method=get action="setup-del.php">
<?php  Dropdown("dropdown_type", "name"); ?>
<input type=hidden name=tablename value=dropdown_type>
		<input type=submit value="Delete"></form></td>
<TD valign=top size=50%>
<form action="setup-add.php"><input type=text maxlength=100 name=name>
		<input type=hidden name=tablename value=dropdown_type>
		<input type=submit value="Add"></form>
</TD></TR></TABLE>

<hr noshade width="50%">
<!-- OSs -->


<table width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>Operating
Systems</font>This is a list of Operating Systems your computers can run.
</TD></TR><TR><TD valign=top width=50%>
<form method=get action="setup-del.php">
<?php  Dropdown("dropdown_os", "name"); ?>
<input type=hidden name=tablename value=dropdown_os>
    <input type=submit value="Delete"></form>
</TD><TD valign=top width=50%>
<form action="setup-add.php"><input type=text maxlength=100 name=name>
    <input type=hidden name=tablename value=dropdown_os>
    <input type=submit value="Add"></form>
</TD></TR></TABLE>


<!-- RAM Types -->

<table width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>RAM Types</font>This is the
types of RAM your systems can have
(i.e. Unbuffered DIMMS, SDRAM DIMMS, ECC DIMMS, etc)
</TD></TR><TR><TD valign=top width=50%>
<form method=get action="setup-del.php">
<?php  Dropdown("dropdown_ram", "name"); ?>
<input type=hidden name=tablename value=dropdown_ram>
    <input type=submit value="Delete"></form>
</TD><TD valign=top width=50%>
<form action="setup-add.php"><input type=text maxlength=100 name=name>
    <input type=hidden name=tablename value=dropdown_ram>
    <input type=submit value="Add"></form>
</TD></TR></TABLE>

<!-- Processor Types -->

<table width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>Processor Types</font> This
is a list of valid processors, i.e. Intel
    Pentium, Pentium II, DEC Alpha, EverSlow WinChip, etc.
</TD></TR><TR><TD valign=top width=50%>
<form method=get action="setup-del.php">
<?php  Dropdown("dropdown_processor", "name"); ?>
<input type=hidden name=tablename value=dropdown_processor>
    <input type=submit value="Delete"></form>
</TD><TD valign=top width=50%>
<form action="setup-add.php"><input type=text maxlength=100 name=name>
    <input type=hidden name=tablename value=dropdown_processor>
    <input type=submit value="Add"></form>
</TD></TR></TABLE>


<!-- Network Interfaces -->

<table width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>Network Interfaces</font>
</TD></TR><TR><TD valign=top width=50%>
<form method=get action="setup-del.php">
<?php  Dropdown("dropdown_iface", "name"); ?>
<input type=hidden name=tablename value=dropdown_iface>
                <input type=submit value="Delete"></form>
</TD><TD valign=top width=50%>
<form action="setup-add.php"><input type=text maxlength=100 name=name>
                <input type=hidden name=tablename value=dropdown_iface>
                <input type=submit value="Add"></form>
</TD></TR></TABLE>

<!-- Network Types -->

<table width=100%><TR><TD valign=top colspan=2>
<font face=arial size=+1>Network Card
Brands/Types</font>This is a list of some possible network cards and
their speed.
</TD></TR><TR><TD valign=top width=50%>
<form method=get action="setup-del.php">
<?php  Dropdown("dropdown_network", "name"); ?>
<input type=hidden name=tablename value=dropdown_network>
    <input type=submit value="Delete"></form>
</TD><TD valign=top width=50%>
<form action="setup-add.php"><input type=text maxlength=100 name=name>
    <input type=hidden name=tablename value=dropdown_network>
    <input type=submit value="Add"></form>
</TD></TR></TABLE>


<?php
commonFooter();
?>
