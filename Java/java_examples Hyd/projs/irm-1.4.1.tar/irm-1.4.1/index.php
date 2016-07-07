<?php
#    IRM - The Information Resource Manager
#    Copyright (C) 2003 Yann Ramin
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
#    $Id: index.php,v 1.5.2.1 2003/02/24 01:20:07 theatrus Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Added CHANGELOG                                #
#  8/20/99 - Yann Ramin: Added infonational prompts                            #
#  5/24/01 - Martin Skjöldebrand: Added dynamic link to guest login for irm.   #
#  6/14/01 - Keith Schoenefed:	Swapped the FAQ and the Help buttons to try    #
#            and force people to read the FAQ before                           #
#            entering a work request.                                          #
#  6/15/01 - Martin Skjöldebrand: Removed debugging code.                      #
#  7/18/01 - Martin Skjöldebrand: Changed autologin from guest to IRMConnect   #
################################################################################
?>
<HTML><HEAD><TITLE>IRM - The Information Resource Manager</TITLE>
</HEAD>
<BODY BGCOLOR="#FFFFFF" onload="document.login.name.focus()">
<FONT FACE="Arial, Helvetica">
<img src="irm-jr1.jpg">
<br>
  

<table border="0">
<tr>
<td valign='top'><h3>IRM Login</h3>
<form method="post" action="login.php" name="login">
Username: <input type="text" name="name">
<br>Password: <input type="password" name="password">
<br>Database: 
<select name="dbuse" size="1">

<!-- Multiple database selection options.  The default is to use a database called 'irm'. -->
<!-- To add more, simply add more option value=dbname lines here. -->

<option value="irm">IRM</option>

<!-- End Multi-Database -->

</select>
<br>
<input type="submit" value="Login">
</form>
<br><br>
</td>
<td>
<h3>Introduction to IRM</h3>
<p>IRM is a multi-user computer, software, periphial and problem tracking system.
You can use IRM, depending on your user-level, to view, edit, and add
computer systems to a database with an extensive list of fields.  You can
also view and post jobs if you have a problem with a computing resource.</p>

<h4>Frequently Asked Questions</h4>
<p>Helpdesk personel get many questions - many of which are repeated many times. A FAQ, which is a list of frequently asked questions -
and their answers, intends to provide a quick and easy way to help you get an answer to a questions. If your query isn't in this list, feel
free to post a request for help.
<form method=post action=login.php><select name=dbuse size=1>

<!-- Multiple database selection options.  The default is to use a database called 'irm'. -->
<!-- To add more, simply add more option value=dbname lines here. -->

<option value=irm>IRM</option>

<!-- End Multi-Database -->

</select><input type='hidden' name='password' value='irmconnect'><input type='hidden' name='name' value='IRMConnect'>
<input type='hidden' name='f_req' value='yes'>
<input type=submit value=Read FAQ></form>

<h4>Request help</h4>
You can request help without loging in to IRM. To do this you need to select the appropriate department, click the <b>Help</b> button below and then follow the
instructions. Your request will be filed under the user name of <b>guest</b> so you will need to ensure that the contact information is correct if you wish to recieve updates and keep in touch with the helpdesk.
<form method=post action=login.php><select name=dbuse size=1>

<!-- Multiple database selection options.  The default is to use a database called 'irm'. -->
<!-- To add more, simply add more option value=dbname lines here. -->

<option value=irm>IRM</option>

<!-- End Multi-Database -->

</select><input type='hidden' name='password' value='irmconnect'><input type='hidden' name='name' value='IRMConnect'><input type=submit value=Help Request></form>
</td>
</tr>
</table></form>
<hr width="50%">
<P>More information can be found at the IRM Website: <a href="http://irm.schoenefeld.org/">http://irm.schoenefeld.org</a>.</P>
<br>   
</BODY>
</HTML>

