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
#    $Id: passwd-change.php,v 1.3 2001/07/10 18:44:06 racer Exp $
#
include("../include/irm.inc");

AuthCheck("normal");

commonHeader("IRM - Change Password");
if($IRMPass != md5($oldpassword))
{
  PRINT "You have incorrectly entered your old password.";
} elseif ($newpassword != $confirm)
{
	PRINT "Your new password does not match the confirmation password.  They must be the same.";
} else
{
	$user = new User($IRMName);
	$user->setPassword($newpassword);
	$user->commit();
}

commonFooter();
?>
