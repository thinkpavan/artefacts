<?php
#    IRM - The Information Resource Manager
#    Copyright (C) 2001 Yann Ramin
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
#    $Id: login.php,v 1.17.2.1 2003/02/24 02:53:24 racer Exp $
#


$cfg_dbdb = $dbuse;

require("./include/irm.inc");

# kludge for sessions
#$_SESSION['cfg_dbdb'] = $cfg_dbdb;
$cfg_dbdb = $dbuse;
#error_reporting(16);

// Why are there two "new" calls here?  Is there some issue with creating a 
// User object with an invalid username?  If that's the case, then we should
// be able to solve the problem using the "exists()" method of the user class.
$user = new User();

$user = new User($name);

if($user->authenticate($name, $password))
{
	commonHeader("Login");
 	print "Bad username or password.";
 	commonFooter();
 	logevent(-1, "IRM", 1, "login", "Failed login: $name");
} else
{
 	$password = md5($password);

	$IRMName = $name;
	$IRMPass = $password;
	if ($f_req=='yes')
	{
		header("Location: users/faq-index.php");
		// Can we pull this out yet?!?!  I guess we need to modify the update
		// script to search through all users and set up these prefs before we
		// do.
		$user->initPrefs();
	} else 
	{
		header("Location: users/");
		// Can we pull this out yet?!?!  I guess we need to modify the update
		// script to search through all users and set up these prefs before we
		// do.
		$user->initPrefs();
	}
}
?>
