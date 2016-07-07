<?php
include "../include/irm.inc";
AuthCheck("admin");
PRINT "<html><body>";
print "This script is encrypting your passwords. Use this only on Pre 1.3.5 releases";
print "<p>";
$getall = $adb->prepare("SELECT * FROM users");
$getall->execute();
while($res = $getall->fetchrow_hash()) {
	$password = md5($res["password"]);
	print "User $res[name] has new password $password<br>";
	if (!$doupdate) { print "Update not done, yet.<br>"; }
}

if (!$doupdate) {
print "<a href=convert_passwd.php?doupdate=1>Preform actual update</a>";
} else {
print "<h1>IMPORTANT!</h1><h2>Remove the following file: $root_path /users/convert_passwd.php!";
}
?>

