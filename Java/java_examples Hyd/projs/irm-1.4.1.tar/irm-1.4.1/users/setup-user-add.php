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
#    $Id: setup-user-add.php,v 1.3 2001/07/03 03:06:28 racer Exp $
#
################################################################################
#                                  CHANGELOG                                   #
################################################################################
#  7/22/99 - Keith Schoenefeld:	Cleaned up code, converted all IF(): to if(){. #
################################################################################

include("../include/irm.inc");

AuthCheck("admin");
$user = new User();
$user->setName($username);
$user->setPassword($password);
$user->setFullname($fullname);
$user->setEmail($email);
$user->setLocation($location);
$user->setPhone($phone);
$user->setType($type);
$user->setComments($comments);
$user->add();
logevent(-1, "IRM", 5, "setup", "$IRMName add user $username.");
header("Location: $HTTP_REFERER");

?>
