<?php

$submit = $_GET['submit'];

$cfg_dbdb = $_GET['cfg_dbdb'];

if($submit == "Upgrade" || $submit == "Install")
{
	include('./include/irm.inc');

}

PRINT "<HTML>\n";
PRINT "<HEAD>\n";
PRINT "<TITLE> Setup IRM version 1.4.0</TITLE>\n";
PRINT "  <style type=\"text/css\">\n";
PRINT "  //<!-- \n";
PRINT "  body \n";
PRINT "  {  \n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  th   \n";
PRINT "  {  \n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt; \n";
PRINT "    font-weight: bold;\n";
PRINT "    background-color: #D3DCE3;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  td\n";
PRINT "  {\n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt;\n";
PRINT "  }\n";
PRINT " \n";
PRINT "  form\n";
PRINT "  {\n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  h1\n";
PRINT "  {\n";
PRINT "    font-family: Verdana, Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 16pt;\n";
PRINT "    font-weight: bold;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  A:link\n";
PRINT "  {\n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt;\n";
PRINT "    text-decoration: none;\n";
PRINT "    color: blue;\n";
PRINT "  }\n";
PRINT "  A:visited\n";
PRINT "  {\n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt;\n";
PRINT "    text-decoration: none;\n";
PRINT "    color: blue;\n";
PRINT "  }\n";
PRINT "  A:hover\n";
PRINT "  {\n";
PRINT "    font-family: Arial, Helvetica, sans-serif;\n";
PRINT "    font-size: 10pt;\n";
PRINT "    text-decoration: underline;\n";
PRINT "    color: red;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  A:link.nav\n";
PRINT "  {\n";
PRINT "    font-family: Verdana, Arial, Helvetica, sans-serif;\n";
PRINT "    color: #000000;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  A:visited.nav\n";
PRINT "  {\n";
PRINT "    font-family: Verdana, Arial, Helvetica, sans-serif;\n";
PRINT "     color: #000000;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  A:hover.nav\n";
PRINT "  {\n";
PRINT "    font-family: Verdana, Arial, Helvetica, sans-serif;\n";
PRINT "     color: red;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  .nav\n";
PRINT "  {\n";
PRINT "    font-family: Verdana, Arial, Helvetica, sans-serif;\n";
PRINT "    color: #000000;\n";
PRINT "  }\n";
PRINT "\n";
PRINT "  //-->\n";
PRINT "  </style>\n";
PRINT "</head>\n";
PRINT "<BODY BGCOLOR=\"#FFFFFF\" TEXT=\"#000000\" LINK=\"#054BBB\" VLINK=\"#006342\">\n";
PRINT "  <FONT FACE=\"arial, helvetica\">\n";
PRINT "	<img src=irm-jr1.jpg>\n";
PRINT "<BR>\n";

	if($submit == "Upgrade")
	{
		$upgrade_09a4 = array();
		$upgrade_09a4[0] = "ALTER TABLE tracking ADD assign VARCHAR(200) AFTER author";
		$upgrade_09a4[1] = "ALTER TABLE tracking ADD closedate DATETIME AFTER date";
		$upgrade_09a4[2] = "ALTER TABLE software ADD license INT AFTER location";
		$upgrade_09a4[3] = "ALTER TABLE computers ADD KEY (location)";
		$upgrade_09a4[4] = "CREATE TABLE templ_inst_software (ID INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(ID), cID INT NOT NULL, INDEX(cID), sID INT NOT NULL, INDEX(sID))";
		
		$upgrade_09b = array();
		$upgrade_09b[0] = "ALTER TABLE prefs ADD advanced_tracking ENUM ('no','yes') DEFAULT 'no' not null";
	
		$upgrade_09b3 = array();
		$upgrade_09b3[0] = "CREATE TABLE groups (ID INT not null AUTO_INCREMENT, name VARCHAR (200) not null , PRIMARY KEY (ID), INDEX (ID), UNIQUE (ID))";
		$upgrade_09b3[1] = "CREATE TABLE comp_group (comp_id INT not null , group_id INT not null , INDEX (group_id))";
		$upgrade_09b3[2] = "ALTER TABLE tracking ADD is_group ENUM ('no','yes') DEFAULT 'no' not null";
		$upgrade_09b3[3] = "ALTER TABLE tracking ADD uemail VARCHAR(100) AFTER is_group";
		$upgrade_09b3[4] = "ALTER TABLE tracking ADD emailupdates varchar(4) AFTER uemail"; 
		
		$upgrade_09c3 = array();
		$upgrade_09c3[0] = "ALTER TABLE prefs ADD tracking_order ENUM ('no','yes') DEFAULT 'no' not null";
		
		$upgrade_09c4 = array();
		$upgrade_09c4[0] = "ALTER TABLE computers ADD flags_server TINYINT NOT NULL AFTER type";
		$upgrade_09c4[1] = "ALTER TABLE computers ADD KEY(flags_server)";
		$upgrade_09c4[2] = "ALTER TABLE templates ADD flags_server TINYINT NOT NULL AFTER type";
		$upgrade_09c4[3] = "INSERT INTO dropdown_type VALUES ('Router')";
		$upgrade_09c4[4] = "INSERT INTO dropdown_type VALUES ('Hub')";
		$upgrade_09c4[5] = "INSERT INTO dropdown_type VALUES ('Switch')";
		$upgrade_09c4[6] = "CREATE TABLE dropdown_iface ( name char(30))";
		$upgrade_09c4[7] = "INSERT INTO dropdown_iface VALUES ('10Mbps Ethernet (UTP)')";
		$upgrade_09c4[8] = "INSERT INTO dropdown_iface VALUES ('100Mbps Ethernet (UTP)')";
		$upgrade_09c4[9] = "INSERT INTO dropdown_iface VALUES ('100Mbps FDDI')";
		$upgrade_09c4[10] = "INSERT INTO dropdown_iface VALUES ('ISDN/Frame')";
		$upgrade_09c4[11] = "INSERT INTO dropdown_iface VALUES ('T1/E1 or above')";
		$upgrade_09c4[12] = "CREATE TABLE event_log ( ID int(11) DEFAULT '0' NOT NULL auto_increment, item int(11) DEFAULT '0' NOT NULL, itemtype char(10) DEFAULT '' NOT NULL, date datetime DEFAULT '0000-00-00 00:00:00' NOT NULL, service varchar(20), level tinyint(4) DEFAULT '0' NOT NULL, message text NOT NULL, PRIMARY KEY (ID), KEY item (item), KEY date (date))";
		$upgrade_09c4[13] = "CREATE TABLE networking ( ID int(11) DEFAULT '0' NOT NULL auto_increment, name char(30) NOT NULL, type char(30) NOT NULL, ram char(10) NOT NULL, ip char(20) NOT NULL, mac char(30) NOT NULL, location char(40) NOT NULL, serial char(50) NOT NULL, otherserial char(50) NOT NULL, contact char(30) NOT NULL, contact_num char(30) NOT NULL, datemod datetime DEFAULT '0000-00-00 00:00:00' NOT NULL, comments TEXT NOT NULL, PRIMARY KEY (ID))";
		$upgrade_09c4[14] = "CREATE TABLE networking_ports ( ID int(11) DEFAULT '0' NOT NULL auto_increment, device_on int(11) DEFAULT '0' NOT NULL, device_type tinyint(4) DEFAULT '0' NOT NULL, iface char(40) NOT NULL, ifaddr char(30) NOT NULL, ifmac char(30) DEFAULT '0' NOT NULL, logical_number int(11) DEFAULT '0' NOT NULL, name char(30) NOT NULL, PRIMARY KEY (ID))";
		$upgrade_09c4[15] = "CREATE TABLE networking_wire ( ID int(11) DEFAULT '0' NOT NULL auto_increment, end1 int(11) DEFAULT '0' NOT NULL, end2 int(11) DEFAULT '0' NOT NULL, PRIMARY KEY (ID))";
		$upgrade_09c4[16] = "alter table templates add iface CHAR(100) AFTER comments"; 
		$upgrade_100[0] = "CREATE TABLE version (number varchar(80) DEFAULT '' NOT NULL, build varchar(80), PRIMARY KEY (number))";

		$upgrade_100[1] = "INSERT INTO version values(\"$irm_version\", \"$irm_build\")";
		$upgrade_130[0] = "ALTER TABLE tracking CHANGE status status ENUM ('new', 'old', 'wait', 'assigned', 'active', 'complete')";
		$upgrade_130[1] = "UPDATE version SET number = '1.3.1', build = '2001022501' WHERE number = '1.3.0'";
		$upgrade_131[0] = "CREATE TABLE config (ID int(11) NOT NULL default '0', notifyassignedbyemail tinyint(4) NOT NULL default '1', notifynewtrackingbyemail tinyint(4) NOT NULL default '0', newtrackingemail char(200) NOT NULL default 'user@host.com', groups tinyint(4) NOT NULL default '1', usenamesearch tinyint(4) NOT NULL default '1', userupdates tinyint(4) NOT NULL default '1', sendexpire tinyint(4) NOT NULL default '0', showjobsonlogin tinyint(4) NOT NULL default '1', minloglevel tinyint(4) NOT NULL default '5', logo char(50) NOT NULL default 'irm-jr1.jpg', snmp tinyint(4) NOT NULL default '0', snmp_rcommunity char(50) NOT NULL default 'public', snmp_ping tinyint(4) NOT NULL default '0', version char(50) NOT NULL default '1.3.2', build char(50) NOT NULL default '2001041201', PRIMARY KEY  (ID), UNIQUE KEY ID_2 (ID), KEY ID (ID))";
	$upgrade_131[1] = "ALTER table inst_software ADD lID int default '0' not null";
	$upgrade_131[2] = "ALTER table inst_software ADD index(lID)";
	$upgrade_131[3] = "ALTER table inst_software ADD gID int(11)";
	$upgrade_131[4] = "ALTER table software drop version";
	$upgrade_131[5] = "ALTER table software drop serial";
	$upgrade_131[6] = "ALTER table software drop otherserial";
	$upgrade_131[7] = "ALTER table software drop location";
	$upgrade_131[8] = "ALTER table software drop license";
	$upgrade_131[9] = "ALTER table software add class enum('Operating System', 'Application', 'CAL', 'Application Bundle') default 'Application' after platform";
	$upgrade_131[10] = "CREATE TABLE software_bundles ( bID int(11) unsigned DEFAULT '0' NOT NULL, sID int(11) unsigned DEFAULT '0' NOT NULL, KEY sID_ndx (sID), KEY bID_ndx (bID), PRIMARY KEY (sID,bID))";
	$upgrade_131[11] = "CREATE TABLE software_licenses ( sID int(11) NOT NULL, licensekey varchar(200), entitlement int(11) DEFAULT '0' NOT NULL, ID int(11) NOT NULL auto_increment, oem_sticker enum ('Yes', 'No') DEFAULT 'No' NOT NULL, PRIMARY KEY (ID), KEY sID_ndx (sID), KEY ID_ndx (ID))";
	$upgrade_131[12] = "DROP table version";
	$upgrade_131[13] = "INSERT INTO config (ID, notifyassignedbyemail, notifynewtrackingbyemail, newtrackingemail, groups, usenamesearch, userupdates, sendexpire,
 showjobsonlogin, minloglevel, logo, snmp, snmp_rcommunity, snmp_ping, version, build) VALUES ('0', '1', '0', 'user@host.com', '1', '1', '1', '0', '1', '5', 'irm-jr1.jpg', '0', 'public', '0', '1.3.2', '2001041201')";
	$upgrade_132[0] = "ALTER TABLE config ADD knowledgebase tinyint(4) AFTER build";
	$upgrade_132[1] = "REPLACE config set ID=0, version=\"1.3.3\", build=\"20010516\", knowledgebase=1";
	$upgrade_132[2] = "CREATE TABLE kbcategories ( ID int(11) NOT NULL auto_increment, parentID int(11) NOT NULL default '0', name text NOT NULL, PRIMARY KEY (ID), KEY ID (ID))";
	$upgrade_132[3] = "CREATE TABLE kbarticles (ID int(11) NOT NULL auto_increment, categoryID int(11) NOT NULL default '0', question text NOT NULL, answer text NOT NULL, faq enum('yes','no') NOT NULL default 'no', PRIMARY KEY (ID), KEY ID (ID))";
	$upgrade_132[4] = "INSERT INTO kbcategories VALUES (1, 0, 'IRM')";
	$upgrade_132[5] = "INSERT INTO kbcategories VALUES (2, 1, 'Computers')";
	$upgrade_132[6] = "INSERT INTO kbcategories VALUES (3, 1, 'Networking')";
	$upgrade_132[7] = "INSERT INTO kbcategories VALUES (4, 1, 'Software')";
	$upgrade_132[8] = "INSERT INTO kbcategories VALUES (5, 1, 'Tracking')";
	$upgrade_132[9] = "INSERT INTO kbcategories VALUES (6, 1, 'Reports')";
	$upgrade_132[10] = "INSERT INTO kbcategories VALUES (7, 1, 'Request Help')";
	$upgrade_132[11] = "INSERT INTO kbcategories VALUES (8, 1, 'Setup')";
	$upgrade_132[12] = "INSERT INTO kbcategories VALUES (9, 1, 'Preferences')";
	$upgrade_132[13] = "INSERT INTO kbcategories VALUES (10, 1, 'Knowledge Base')";
	$upgrade_132[14] = "INSERT INTO kbcategories VALUES (11, 1, 'FAQ')";
	$upgrade_132[15] = "INSERT INTO kbcategories VALUES (12, 1, 'Logout')";
	$upgrade_133[0] = "ALTER TABLE users RENAME usersbak";
	$upgrade_133[1] = "CREATE TABLE users (name char(255) DEFAULT '' NOT NULL, password char(255), fullname char(200), email char(100), location char(200), phone char(100), type enum('post-only','normal','tech','admin') DEFAULT 'post-only' NOT NULL, comments text, PRIMARY KEY(name), KEY (type))";
	$u133count = 2;
	$query = "select * from users";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		for($i=0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
			$username = $result["name"]; 
			$password = $result["password"]; 
			$email = $result["email"]; 
			$location = $result["location"]; 
			$phone = $result["phone"]; 
			$type = $result["type"]; 
			$comments = $result["comments"];
			$comments = AddSlashes($comments);
			$upgrade_133[$u133count] = "INSERT INTO users VALUES ('$username', '$password', '$username', '$email', '$location', '$phone', '$type', '$comments')";
			$u133count = $u133count + 1;
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
	}
	$upgrade_133[$u133count] = "alter table config add fasttrack int default '1'";
	$u133count = $u133count + 1;
	$upgrade_133[$u133count] = "create table fasttracktemplates (ID INT NOT NULL auto_increment, name char(100), priority int(11), request text, response text, PRIMARY KEY (ID))";
	$u133count = $u133count + 1;
	$upgrade_133[$u133count] = "INSERT INTO fasttracktemplates VALUES (1, 'Default',3, '', '')";
	$u133count = $u133count + 1;
	$upgrade_133[$u133count] = "INSERT INTO fasttracktemplates VALUES (2, 'Reset Password',3, 'User forgot password', 'Reset password on the system')";
	$u133count = $u133count + 1;
	$upgrade_133[$u133count] = "INSERT INTO fasttracktemplates VALUES (3, 'Floppy Disk in Drive',3, 'Computer will not boot, it says something about NTLDR not found', 'There was a floppy disk in the drive, once user removed it and rebooted system it started up just fine.')";
	$u133count = $u133count +1;
	$upgrade_133[$u133count] = "REPLACE config set ID=0, version=\"1.3.4\", build=\"2001071101\"";
	$upgrade_134[0] = "ALTER TABLE config ADD anonymous tinyint(4) AFTER fasttrack";
	$upgrade_134[1] = "ALTER TABLE config ADD anon_faq tinyint(4) AFTER anonymous";
	$upgrade_134[2] = "ALTER TABLE config ADD anon_tt tinyint(4) AFTER anon_faq";

		if($old_version == "0.9a.4")
		{
			$result_upgrade_09a4 = setup_db($upgrade_09a4);
			if($result_upgrade_09a4 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9a.4<BR>\n";
			}
			$result_upgrade_09b = setup_db($upgrade_09b);
			if($result_upgrade_09b == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9b<BR>\n";
			}
			$result_upgrade_09b3 = setup_db($upgrade_09b3);
			if($result_upgrade_09b3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9b.3<BR>\n";
			}
			$result_upgrade_09c3 = setup_db($upgrade_09c3);
			if($result_upgrade_09c3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c.3<BR>\n";
			}
			$result_upgrade_09c4 = setup_db($upgrade_09c4);
			if($result_upgrade_09c4 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c4<BR>\n";
			}

			$result_upgrade_100 = setup_db($upgrade_100);
			if($result_upgrade_100 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.0.0<BR>\n";
			}
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
	
		if($old_version == "0.9b")
		{
			$result_upgrade_09b = setup_db($upgrade_09b);
			if($result_upgrade_09b == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9b<BR>\n";
			}
			$result_upgrade_09b3 = setup_db($upgrade_09b3);
			if($result_upgrade_09b3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9b.3<BR>\n";
			}
			$result_upgrade_09c3 = setup_db($upgrade_09c3);
			if($result_upgrade_09c3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c.3<BR>\n";
			}
			$result_upgrade_09c4 = setup_db($upgrade_09c4);
			if($result_upgrade_09c4 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c4<BR>\n";
			}
			$result_upgrade_100 = setup_db($upgrade_100);
			if($result_upgrade_100 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.0.0<BR>\n";
			}
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
	
		if($old_version == "0.9b.3")
		{
			$result_upgrade_09b3 = setup_db($upgrade_09b3);
			if($result_upgrade_09b3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9b.3<BR>\n";
			}
			$result_upgrade_09c3 = setup_db($upgrade_09c3);
			if($result_upgrade_09c3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c.3<BR>\n";
			}
			$result_upgrade_09c4 = setup_db($upgrade_09c4);
			if($result_upgrade_09c4 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c4<BR>\n";
			}
			$result_upgrade_100 = setup_db($upgrade_100);
			if($result_upgrade_100 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.0.0<BR>\n";
			}
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
	
		if($old_version == "0.9c.3")
		{
			$result_upgrade_09c3 = setup_db($upgrade_09c3);
			if($result_upgrade_09c3 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c.3<BR>\n";
			}
			$result_upgrade_09c4 = setup_db($upgrade_09c4);
			if($result_upgrade_09c4 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c4<BR>\n";
			}
			$result_upgrade_100 = setup_db($upgrade_100);
			if($result_upgrade_100 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.0.0<BR>\n";
			}
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
	
		if($old_version == "0.9c.4")
		{
			$result_upgrade_09c4 = setup_db($upgrade_09c4);
			if($result_upgrade_09c4 == 0)
			{
				PRINT "Error during incrimental upgrade from 0.9c4<BR>\n";
			}
			$result_upgrade_100 = setup_db($upgrade_100);
			if($result_upgrade_100 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.0.0<BR>\n";
			}
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}

		if($old_version == "1.0.0")
		{
			$result_upgrade_100 = setup_db($upgrade_100);
			if($result_upgrade_100 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.0.0<BR>\n";
			}
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
		if($old_version == "1.3.0")
		{
			$result_upgrade_130 = setup_db($upgrade_130);
			if($result_upgrade_130 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.0<BR>\n";
			}
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
		if($old_version == "1.3.1")
		{
			$result_upgrade_131 = setup_db($upgrade_131);
			if($result_upgrade_131 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.1<BR>\n";
			}
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
		if($old_version == "1.3.2")
		{
			$result_upgrade_132 = setup_db($upgrade_132);
			if($result_upgrade_132 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.2<BR>\n";
			}
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
		if($old_version == "1.3.3")
		{
			$result_upgrade_133 = setup_db($upgrade_133);
			if($result_upgrade_133 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.3<BR>\n";
			}
		}
		if($old_version == "1.3.4")
		{
			$result_upgrade_134 = setup_db($upgrade_134);
			if($result_upgrade_134 == 0)
			{
				PRINT "Error during incrimental upgrade from 1.3.4<BR>\n";
			}
		}
	}
	
	if($submit == "Install")
	{
		$comp_group = array();

	
		$comp_group[0] = "CREATE TABLE comp_group ( comp_id int(11) DEFAULT '0' NOT NULL, group_id int(11) DEFAULT '0' NOT NULL, KEY lab_id (group_id))";

		$comp_group[1] = "INSERT INTO comp_group VALUES (1,1)";
	
		$computers = array();
		$computers[0] = "CREATE TABLE computers ( ID int(11) DEFAULT '0' NOT NULL auto_increment, name varchar(200), type varchar(100), flags_server tinyint(4) DEFAULT '0' NOT NULL, os varchar(100), osver varchar(20), processor varchar(30), processor_speed varchar(30), location varchar(200) DEFAULT '' NOT NULL, serial varchar(200) DEFAULT '' NOT NULL, otherserial varchar(200) DEFAULT '' NOT NULL, ramtype varchar(200) DEFAULT '' NOT NULL, ram varchar(6) DEFAULT '' NOT NULL, network varchar(200) DEFAULT '' NOT NULL, ip varchar(20), mac varchar(30), hdspace varchar(6), contact varchar(90), contact_num varchar(90), comments text NOT NULL, date_mod datetime, PRIMARY KEY (ID), KEY location (location), KEY flags (flags_server))";

		$computers[1] = "INSERT INTO computers VALUES (1,'Ants','iMac DV',0,'Mac OS','9.0.4','PowerPC G3','400','Library Back Room','','','SDRAM DIMMs (<10ns)','192','Generic 100Mbps Card','DHCP','00 50 E4','13','','','','2000-05-03 17:50:08')";
	
		$dropdown_iface = array();
		$dropdown_iface[0] = "CREATE TABLE dropdown_iface ( name char(30))";
	
		$dropdown_iface[1] = "INSERT INTO dropdown_iface VALUES ('10Mbps Ethernet (UTP)')";
		$dropdown_iface[2] = "INSERT INTO dropdown_iface VALUES ('100Mbps Ethernet (UTP)')";
		$dropdown_iface[3] = "INSERT INTO dropdown_iface VALUES ('100Base FL')";
		$dropdown_iface[4] = "INSERT INTO dropdown_iface VALUES ('100Mbps FDDI')";
		$dropdown_iface[5] = "INSERT INTO dropdown_iface VALUES ('Frame Relay')";
		$dropdown_iface[6] = "INSERT INTO dropdown_iface VALUES ('ISDN')";
		$dropdown_iface[7] = "INSERT INTO dropdown_iface VALUES ('T1/E1 +')";
		$dropdown_iface[8] = "INSERT INTO dropdown_iface VALUES ('Serial Link')";
	
		$dropdown_locations = array();
		$dropdown_locations[0] = "CREATE TABLE dropdown_locations (name char(200))";
		
		$dropdown_locations[1] = "INSERT INTO dropdown_locations VALUES ('Library Back Room')";
		$dropdown_locations[2] = "INSERT INTO dropdown_locations VALUES ('Room 34')";
		$dropdown_locations[3] = "INSERT INTO dropdown_locations VALUES ('MAOS Lab')";
		$dropdown_locations[4] = "INSERT INTO dropdown_locations VALUES ('Office')";
		
		$dropdown_network = array();
		
		$dropdown_network[0] = "CREATE TABLE dropdown_network ( name char(200))";
		
		$dropdown_network[1] = "INSERT INTO dropdown_network VALUES ('3Com (100Mbps)')";
		$dropdown_network[2] = "INSERT INTO dropdown_network VALUES ('3Com (10Mbps)')";
		$dropdown_network[3] = "INSERT INTO dropdown_network VALUES ('Intel (100Mbps)')";
		$dropdown_network[4] = "INSERT INTO dropdown_network VALUES ('Intel (10Mbps)')";
		$dropdown_network[5] = "INSERT INTO dropdown_network VALUES ('Generic 100Mbps Card')";
		$dropdown_network[6] = "INSERT INTO dropdown_network VALUES ('Generic 10Mbps Card')";
		$dropdown_network[7] = "INSERT INTO dropdown_network VALUES ('None')";
		$dropdown_network[8] = "INSERT INTO dropdown_network VALUES ('AMD 10Mbps')";
		$dropdown_network[9] = "INSERT INTO dropdown_network VALUES ('Realtek 10Mbps')";
		$dropdown_network[10] = "INSERT INTO dropdown_network VALUES ('Realtek 100Mbps')";
		
		$dropdown_os = array();
		$dropdown_os[0] = "CREATE TABLE dropdown_os (name char(100))";
		$dropdown_os[1] = "INSERT INTO dropdown_os VALUES ('Linux (Debian)')";
		$dropdown_os[2] = "INSERT INTO dropdown_os VALUES ('Linux (RedHat)')";
		$dropdown_os[3] = "INSERT INTO dropdown_os VALUES ('Linux (Caldera)')";
		$dropdown_os[4] = "INSERT INTO dropdown_os VALUES ('DOS')";
		$dropdown_os[5] = "INSERT INTO dropdown_os VALUES ('FreeBSD')";
		$dropdown_os[6] = "INSERT INTO dropdown_os VALUES ('Linux (Other)')";
		$dropdown_os[7] = "INSERT INTO dropdown_os VALUES ('Windows')";
		$dropdown_os[8] = "INSERT INTO dropdown_os VALUES ('Other')";
		$dropdown_os[9] = "INSERT INTO dropdown_os VALUES ('Mac OS')";
		$dropdown_os[10] = "INSERT INTO dropdown_os VALUES ('IRIX')";
		$dropdown_os[11] = "INSERT INTO dropdown_os VALUES ('Solaris')";
		$dropdown_os[12] = "INSERT INTO dropdown_os VALUES ('Max OS X')";
		
		$dropdown_processor = array();
		$dropdown_processor[0] = "CREATE TABLE dropdown_processor ( name varchar(30))";
		$dropdown_processor[1] = "INSERT INTO dropdown_processor VALUES ('Intel Pentium')";
		$dropdown_processor[2] = "INSERT INTO dropdown_processor VALUES ('Intel Pentium II')";
		$dropdown_processor[3] = "INSERT INTO dropdown_processor VALUES ('AMD K6-1')";
		$dropdown_processor[4] = "INSERT INTO dropdown_processor VALUES ('AMD K6-2')";
		$dropdown_processor[5] = "INSERT INTO dropdown_processor VALUES ('AMD K6-3')";
		$dropdown_processor[6] = "INSERT INTO dropdown_processor VALUES ('PowerPC G3')";
		$dropdown_processor[7] = "INSERT INTO dropdown_processor VALUES ('Intel Pentium III')";
		$dropdown_processor[8] = "INSERT INTO dropdown_processor VALUES ('AMD Athlon')";
		$dropdown_processor[9] = "INSERT INTO dropdown_processor VALUES ('68k (Motorola)')";
		$dropdown_processor[10] = "INSERT INTO dropdown_processor VALUES ('486 SX')";
		$dropdown_processor[11] = "INSERT INTO dropdown_processor VALUES ('486 DX')";
		$dropdown_processor[12] = "INSERT INTO dropdown_processor VALUES ('486 DX2/4')";
		$dropdown_processor[13] = "INSERT INTO dropdown_processor VALUES ('Intel Itanium')";
		$dropdown_processor[14] = "INSERT INTO dropdown_processor VALUES ('PowerPC G4')";
		$dropdown_processor[15] = "INSERT INTO dropdown_processor VALUES ('RS3000')";
		$dropdown_processor[16] = "INSERT INTO dropdown_processor VALUES ('RS10k')";
		$dropdown_processor[17] = "INSERT INTO dropdown_processor VALUES ('Alpha EV6.7')";
		$dropdown_processor[18] = "INSERT INTO dropdown_processor VALUES ('PowerPC 603ev')";
		$dropdown_processor[19] = "INSERT INTO dropdown_processor VALUES ('PowerPC 603')";
		$dropdown_processor[20] = "INSERT INTO dropdown_processor VALUES ('PowerPC 601')";
		$dropdown_processor[21] = "INSERT INTO dropdown_processor VALUES ('68040')";
		$dropdown_processor[22] = "INSERT INTO dropdown_processor VALUES ('68040')";
		
		$dropdown_ram = array();
		$dropdown_ram[0] = "CREATE TABLE dropdown_ram ( name char(200))";
		$dropdown_ram[1] = "INSERT INTO dropdown_ram VALUES ('36pin SIMMS')";
		$dropdown_ram[2] = "INSERT INTO dropdown_ram VALUES ('72pin SIMMS (Fast Page)')";
		$dropdown_ram[3] = "INSERT INTO dropdown_ram VALUES ('72pin SIMMS (EDO)')";
		$dropdown_ram[4] = "INSERT INTO dropdown_ram VALUES ('Unbuffered DIMMs')";
		$dropdown_ram[5] = "INSERT INTO dropdown_ram VALUES ('DIMMs w/EEPROM')";
		$dropdown_ram[6] = "INSERT INTO dropdown_ram VALUES ('SDRAM DIMMs (<10ns)')";
		$dropdown_ram[7] = "INSERT INTO dropdown_ram VALUES ('ECC DIMMs')";
		$dropdown_ram[8] = "INSERT INTO dropdown_ram VALUES ('Other')";
		$dropdown_ram[9] = "INSERT INTO dropdown_ram VALUES ('iMac DIMMS')";
		
		$dropdown_type = array();
		$dropdown_type[0] = "CREATE TABLE dropdown_type ( name char(200))";
		$dropdown_type[1] = "INSERT INTO dropdown_type VALUES ('Generic PC')";
		$dropdown_type[2] = "INSERT INTO dropdown_type VALUES ('Macintosh PPC (other)')";
		$dropdown_type[3] = "INSERT INTO dropdown_type VALUES ('Macintosh 68K (68030)')";
		$dropdown_type[4] = "INSERT INTO dropdown_type VALUES ('Macintosh 68K (68040)')";
		$dropdown_type[5] = "INSERT INTO dropdown_type VALUES ('Other')";
		$dropdown_type[6] = "INSERT INTO dropdown_type VALUES ('IBM RS/6000')";
		$dropdown_type[7] = "INSERT INTO dropdown_type VALUES ('Indy')";
		$dropdown_type[8] = "INSERT INTO dropdown_type VALUES ('Octane')";
		$dropdown_type[9] = "INSERT INTO dropdown_type VALUES ('O2')";
		$dropdown_type[10] = "INSERT INTO dropdown_type VALUES ('Onyx 2')";
		$dropdown_type[11] = "INSERT INTO dropdown_type VALUES ('iMac')";
		$dropdown_type[12] = "INSERT INTO dropdown_type VALUES ('iMac DV')";
		$dropdown_type[13] = "INSERT INTO dropdown_type VALUES ('Blue and White G3')";
		$dropdown_type[14] = "INSERT INTO dropdown_type VALUES ('G4')";
		$dropdown_type[15] = "INSERT INTO dropdown_type VALUES ('Homebrew')";
		$dropdown_type[16] = "INSERT INTO dropdown_type VALUES ('Cisco Catalyst 2900 XL')";
		$dropdown_type[17] = "INSERT INTO dropdown_type VALUES ('Cisco 2600')";
		$dropdown_type[18] = "INSERT INTO dropdown_type VALUES ('3Com AccessBuilder')";
		$dropdown_type[19] = "INSERT INTO dropdown_type VALUES ('3Com LinkBuilder Hub')";
		$dropdown_type[20] = "INSERT INTO dropdown_type VALUES ('Cisco 400-series Fast Hub')";
		
		$event_log = array();
		$event_log[0] = "CREATE TABLE event_log (ID int(11) DEFAULT '0' NOT NULL auto_increment, item int(11) DEFAULT '0' NOT NULL, itemtype varchar(10) DEFAULT '' NOT NULL, date datetime DEFAULT '0000-00-00 00:00:00' NOT NULL, service varchar(20), level tinyint(4) DEFAULT '0' NOT NULL, message text NOT NULL, PRIMARY KEY (ID), KEY comp (item), KEY date (date))";
		
		#
		# Table structure for table 'followups'
		#
		$followups = array();
		$followups[0] = "CREATE TABLE followups ( ID int(11) DEFAULT '0' NOT NULL auto_increment, tracking int(11), date datetime, author varchar(200), contents text, PRIMARY KEY (ID))";
		
		#
		# Table structure for table 'groups'
		#
		$groups = array();
		$groups[0] = "CREATE TABLE groups ( ID int(11) DEFAULT '0' NOT NULL auto_increment, name varchar(200) DEFAULT '' NOT NULL, PRIMARY KEY (ID), KEY ID (ID), UNIQUE ID_2 (ID))";
		$groups[1] = "INSERT INTO groups VALUES (1,'test')";
		
		#
		# Table structure for table 'inst_software'
		#
		$inst_software = array();
		$inst_software[0] = "CREATE TABLE inst_software ( ID int(11) DEFAULT '0' NOT NULL auto_increment, cID int(11) DEFAULT '0' NOT NULL, sID int(11) DEFAULT '0' NOT NULL, lID int(11) NOT NULL default '0', gID int(11), PRIMARY KEY (ID), KEY cID (cID), KEY sID (sID), KEY lID (lID))";
		
		#
		# Table structure for table 'networking'
		#
		$networking[0] = "CREATE TABLE networking ( ID int(11) DEFAULT '0' NOT NULL auto_increment, name varchar(30) DEFAULT '' NOT NULL, type varchar(30) DEFAULT '' NOT NULL, ram varchar(10), ip varchar(20) DEFAULT '' NOT NULL, mac varchar(30), location varchar(40) DEFAULT '' NOT NULL, serial varchar(50), otherserial varchar(50), contact varchar(30) DEFAULT '' NOT NULL, contact_num varchar(30) DEFAULT '' NOT NULL, datemod datetime DEFAULT '0000-00-00 00:00:00' NOT NULL, comments text NOT NULL, PRIMARY KEY (ID))";
		
		#
		# Table structure for table 'networking_ports'
		#
		$networking_ports = array();
		$networking_ports[0] = "CREATE TABLE networking_ports ( ID int(11) DEFAULT '0' NOT NULL auto_increment, device_on int(11) DEFAULT '0' NOT NULL, device_type tinyint(4) DEFAULT '0' NOT NULL, iface char(40) DEFAULT '' NOT NULL, ifaddr char(30) DEFAULT '' NOT NULL, ifmac char(30) DEFAULT '0' NOT NULL, logical_number int(11) DEFAULT '0' NOT NULL, name char(30) DEFAULT '' NOT NULL, PRIMARY KEY (ID))";
		
		#
		# Dumping data for table 'networking_ports'
		#
		
		$networking_ports[1] = "INSERT INTO networking_ports VALUES (1,1,1,'100Mbps Ethernet (UTP)','DHCP','00 50 E4',1,'Port 1')";
		
		#
		# Table structure for table 'networking_wire'
		#
		
		$networking_wire = array();
		$networking_wire[0] = "CREATE TABLE networking_wire ( ID int(11) DEFAULT '0' NOT NULL auto_increment, end1 int(11) DEFAULT '0' NOT NULL, end2 int(11) DEFAULT '0' NOT NULL, PRIMARY KEY (ID))";
		
		#
		# Table structure for table 'prefs'
		#
		$prefs = array();
		$prefs[0] = "CREATE TABLE prefs ( user varchar(80) DEFAULT '' NOT NULL, type enum('no','yes') DEFAULT 'no' NOT NULL, os enum('no','yes') DEFAULT 'no' NOT NULL, osver enum('no','yes') DEFAULT 'no' NOT NULL, processor enum('no','yes') DEFAULT 'no' NOT NULL, processor_speed enum('no','yes') DEFAULT 'no' NOT NULL, location enum('no','yes') DEFAULT 'no' NOT NULL, serial enum('no','yes') DEFAULT 'no' NOT NULL, otherserial enum('no','yes') DEFAULT 'no' NOT NULL, ramtype enum('no','yes') DEFAULT 'no' NOT NULL, ram enum('no','yes') DEFAULT 'no' NOT NULL, network enum('no','yes') DEFAULT 'no' NOT NULL, ip enum('no','yes') DEFAULT 'no' NOT NULL, mac enum('no','yes') DEFAULT 'no' NOT NULL, hdspace enum('no','yes') DEFAULT 'no' NOT NULL, contact enum('no','yes') DEFAULT 'no' NOT NULL, contact_num enum('no','yes') DEFAULT 'no' NOT NULL, comments enum('no','yes') DEFAULT 'no' NOT NULL, date_mod enum('no','yes') DEFAULT 'no' NOT NULL, advanced_tracking enum('no','yes') DEFAULT 'no' NOT NULL, tracking_order enum('no','yes') DEFAULT 'no' NOT NULL, PRIMARY KEY (user))";
		
		#
		# Dumping data for table 'prefs'
		#
		
		$prefs[1] = "INSERT INTO prefs VALUES ('Admin','yes','','','','','','','','','','','','','','','','','','yes','')";
		
		#
		# Table structure for table 'software'
		#
		$software = array();
		$software[0] = "CREATE TABLE software (ID int(11) DEFAULT '0' NOT NULL auto_increment, name varchar(200), platform varchar(200), class enum('Operating System', 'Application', 'CAL', 'Application Bundle') default 'Application', comments text, PRIMARY KEY (ID))";
		
		#
		# Dumping data for table 'software'
		#
		
		$software[1] = "INSERT INTO software VALUES (1,'Test Software','FreeBSD','Application', 'This one is in the Back Room')";
		$software[2] = "INSERT INTO software VALUES (2,'Windows 95','Mac OS','Operating System', 'This one is in the Back Room')";
		$software[3] = "INSERT INTO software VALUES (3,'BlackWidowExplorer','DOS', 'Application', 'Comment Here')";
		
		#
		# Table structure for table 'templ_inst_software'
		#
		$templ_inst_software = array();
		$templ_inst_software[0] = "CREATE TABLE templ_inst_software ( ID int(11) DEFAULT '0' NOT NULL auto_increment, cID int(11) DEFAULT '0' NOT NULL, sID int(11) DEFAULT '0' NOT NULL, PRIMARY KEY (ID), KEY cID (cID), KEY sID (sID))";
		
		#
		# Dumping data for table 'templ_inst_software'
		#
		
		$templ_inst_software[1] = "INSERT INTO templ_inst_software VALUES (1,2,3)";
		$templ_inst_software[2] = "INSERT INTO templ_inst_software VALUES (2,2,2)";
		
		#
		# Table structure for table 'templates'
		#
		$templates = array();
		$templates[0] = "CREATE TABLE templates ( ID int(11) DEFAULT '0' NOT NULL auto_increment, templname varchar(200), name varchar(200), type varchar(200), flags_server tinyint(4) DEFAULT '0' NOT NULL, os varchar(200), osver varchar(20), processor varchar(200), processor_speed varchar(100), location varchar(200), serial varchar(200), otherserial varchar(200), ramtype varchar(200), ram varchar(20), network varchar(200), ip varchar(20), mac varchar(40), hdspace varchar(10), contact varchar(200), contact_num varchar(200), comments text, iface varchar(100), PRIMARY KEY (ID))";
	
		#
		# Dumping data for table 'templates'
		#
		
		$templates[1] = "INSERT INTO templates VALUES (1,'Blank Template','','Generic PC',0,'Windows','','Intel Pentium','','Library Back Room','','','72pin SIMMS (EDO)','','Generic 10Mbps Card','','','','','','',NULL)";
		$templates[2] = "INSERT INTO templates VALUES (2,'Mac G3 All-in-One','','Macintosh PPC (other)',1,'Mac OS','8.1','486 DX','266','MAOS Lab','','','SDRAM DIMMs (<10ns)','96','Generic 100Mbps Card','205.155.38','','3','','','','100Mbps Ethernet (UTP)')";
		$templates[3] = "INSERT INTO templates VALUES (3,'iMac','','iMac',0,'Mac OS','8.6','PowerPC G3','333','Library Back Room','','','iMac DIMMS','32','Generic 100Mbps Card','','00 50 E4','6','','','','100Mbps Ethernet (UTP)')";
		$templates[4] = "INSERT INTO templates VALUES (4,'iMac DV','','iMac DV',0,'Mac OS','9.0.4','PowerPC G3','400','Library Back Room','','','SDRAM DIMMs (<10ns)','64','Generic 100Mbps Card','','','13','','','','100Mbps Ethernet (UTP)')";

		#
		# Table structure for table 'tracking'
		#
		$tracking = array();
		$tracking[0] = "CREATE TABLE tracking ( ID int(11) DEFAULT '0' NOT NULL auto_increment, date datetime, closedate datetime, status enum('new','old', 'wait', 'assigned', 'active', 'complete'), author varchar(200), assign varchar(200), computer int(11), contents text, priority tinyint(4) DEFAULT '1' NOT NULL, is_group enum('no','yes') DEFAULT 'no' NOT NULL, uemail varchar(100), emailupdates varchar(4), PRIMARY KEY (ID))";

		#
		# Table structure for table 'users'
		#
		$users = array();
		$users[0] = "CREATE TABLE users (name char(255) DEFAULT '' NOT NULL, password char(255), fullname char(200), email char(100), location char(200), phone char(100), type enum('post-only','normal','tech','admin') DEFAULT 'post-only' NOT NULL, comments text, PRIMARY KEY(name), KEY (type))";
		
		#
		# Dumping data for table 'users'
		#

		$users[1] = "INSERT INTO users VALUES ('Admin','admin','Administrator Guy','root@localhost','Admin Place (in front of the computer)','Use e-mail','admin','')";
		$users[2] = "INSERT INTO users VALUES ('Guest','guest','Guest User','','','','post-only','')";
		$users[3] = "INSERT INTO users VALUES ('Normal','normal','Normal User','user@localhost','','','normal','')";
		$users[4] = "INSERT INTO users VALUES ('Tech','tech','Technician User','tech@localhost','','','tech','')";
                $users[5] = "INSERT INTO users VALUES ('IRMConnect','irmconnect','Special account','','','','post-only','')";
		#
		# Table structure for table 'config'
		#
		$config = array();
		$config[0] = "CREATE TABLE config ( ID int(11) NOT NULL default '0', notifyassignedbyemail tinyint(4) NOT NULL default '1', notifynewtrackingbyemail tinyint(4) NOT NULL default '0', newtrackingemail char(200) NOT NULL default 'user@host.com', groups tinyint(4) NOT NULL default '1', usenamesearch tinyint(4) NOT NULL default '1', userupdates tinyint(4) NOT NULL default '1', sendexpire tinyint(4) NOT NULL default '0', showjobsonlogin tinyint(4) NOT NULL default '1', minloglevel tinyint(4) NOT NULL default '5', logo char(50) NOT NULL default 'irm-jr1.jpg', snmp tinyint(4) NOT NULL default '0', snmp_rcommunity char(50) NOT NULL default 'public', snmp_ping tinyint(4) NOT NULL default '0', version char(50) NOT NULL default '1.3.2', build char(50) NOT NULL default '2001041201', knowledgebase tinyint(4) NOT NULL default '1', fasttrack tinyint(4) NOT NULL default '1', anonymous tinyint(4) NOT NULL default '0', anon_faq tinyint(4) NOT NULL default '0', anon_tt tinyint(4) NOT NULL default '0', PRIMARY KEY  (ID), UNIQUE KEY ID_2 (ID), KEY ID (ID))";
		$config[1] = "INSERT INTO config (ID, notifyassignedbyemail, notifynewtrackingbyemail, newtrackingemail, groups, usenamesearch, userupdates, sendexpire, showjobsonlogin, minloglevel, logo, snmp, snmp_rcommunity, snmp_ping, version, build, knowledgebase, fasttrack, anonymous, anon_faq, anon_tt) VALUES ('0', '1', '0', 'user@host.com', '1', '1', '1', '0', '1', '5', 'irm-jr1.jpg', '0', 'public', '0', '1.4.0', '2003020901', '1','1', '0', '0', '0')";

	#
	# Table structure for table 'software_bundles'
	#
	$software_bundles =  array();
	$software_bundles[0] = "CREATE TABLE software_bundles (bID int(11) unsigned DEFAULT '0' NOT NULL, sID int(11) unsigned DEFAULT '0' NOT NULL, KEY sID (sID), KEY bID (bID), PRIMARY KEY (sID,bID))";

	#
	# Table structure for table 'software_licenses'
	#
	$software_licenses = array();
	$software_licenses[0] = "CREATE TABLE software_licenses ( sID int(11) NOT NULL, licensekey varchar(200), entitlement int(11) DEFAULT '0' NOT NULL, ID int(11) NOT NULL auto_increment, oem_sticker enum ('Yes', 'No') DEFAULT 'No' NOT NULL, PRIMARY KEY (ID), KEY sID (sID), KEY ID (ID))";


	#
	# Table structure for table 'kbarticles'
	#
	$kbarticles = array();
	$kbarticles[0] = "CREATE TABLE kbarticles (ID int(11) NOT NULL auto_increment, categoryID int(11) NOT NULL default '0', question text NOT NULL, answer text NOT NULL, faq enum('yes','no') NOT NULL default 'no', PRIMARY KEY (ID), KEY ID (ID))";

	#
	# Table structure for table 'kbcategories'
	#
	$kbcategories = array();
	$kbcategories[0] = "CREATE TABLE kbcategories (ID int(11) NOT NULL auto_increment, parentID int(11) NOT NULL default '0', name text NOT NULL, PRIMARY KEY (ID), KEY ID (ID))";
	$kbcategories[1] = "INSERT INTO kbcategories VALUES (1, 0, 'IRM')";
	$kbcategories[2] = "INSERT INTO kbcategories VALUES (2, 1, 'Computers')";
	$kbcategories[3] = "INSERT INTO kbcategories VALUES (3, 1, 'Networking')";
	$kbcategories[4] = "INSERT INTO kbcategories VALUES (4, 1, 'Software')";
	$kbcategories[5] = "INSERT INTO kbcategories VALUES (5, 1, 'Tracking')";
	$kbcategories[6] = "INSERT INTO kbcategories VALUES (6, 1, 'Reports')";
	$kbcategories[7] = "INSERT INTO kbcategories VALUES (7, 1, 'Request Help')";
	$kbcategories[8] = "INSERT INTO kbcategories VALUES (8, 1, 'Setup')";
	$kbcategories[9] = "INSERT INTO kbcategories VALUES (9, 1, 'Preferences')";
	$kbcategories[10] = "INSERT INTO kbcategories VALUES (10, 1, 'Knowledge Base')";
	$kbcategories[11] = "INSERT INTO kbcategories VALUES (11, 1, 'FAQ')";
	$kbcategories[12] = "INSERT INTO kbcategories VALUES (12, 1, 'Logout')";
	
	$fasttracktemplates[0] = "CREATE TABLE fasttracktemplates (ID INT NOT NULL auto_increment, name char(100), priority int(11), request text, response text, PRIMARY KEY (ID))";
	$fasttracktemplates[1] = "INSERT INTO fasttracktemplates VALUES (1, 'Default',3, '', '')";
	$fasttracktemplates[2] = "INSERT INTO fasttracktemplates VALUES (2, 'Reset Password',3, 'User forgot password', 'Reset password on the system')";
	$fasttracktemplates[3] = "INSERT INTO fasttracktemplates VALUES (3, 'Floppy Disk in Drive',3, 'Computer will not boot, it says something about NTLDR not found', 'There was a floppy disk in the drive, once user removed it and rebooted system it started up just fine.')";


		$comp_group_return = setup_db($comp_group);
		if($comp_group_return == 0)
		{
			PRINT "Error creating table comp_group<BR>\n";
		}
	
		$computers_return = setup_db($computers);
		if($computers_return == 0)
		{
			PRINT "Error creating table computers<BR>\n";
		}
		
		$dropdown_iface_return = setup_db($dropdown_iface);
		if($dropdown_iface_return == 0)
		{
			PRINT "Error creating table dropdown_iface<BR>\n";
		}
		
		$dropdown_locations_return = setup_db($dropdown_locations);
		if($dropdown_locations_return == 0)
		{
			PRINT "Error creating table dropdown_locations<BR>\n";
		}
		
		$dropdown_network_return = setup_db($dropdown_network);
		if($dropdown_network_return == 0)
		{
			PRINT "Error creating table dropdown_network<BR>\n";
		}
		
		$dropdown_os_return = setup_db($dropdown_os);
		if($dropdown_os_return == 0)
		{
			PRINT "Error creating table dropdown_os<BR>\n";
		}
		
		$dropdown_processor_return = setup_db($dropdown_processor);
		if($dropdown_processor_return == 0)
		{
			PRINT "Error creating table dropdown_processor<BR>\n";
		}
		
		$dropdown_ram_return = setup_db($dropdown_ram);
		if($dropdown_ram_return == 0)
		{
			PRINT "Error creating table dropdown_ram<BR>\n";
		}
		
		$dropdown_type_return = setup_db($dropdown_type);
		if($dropdown_type_return == 0)
		{
			PRINT "Error creating table dropdown_type<BR>\n";
		}
		
		$event_log_return = setup_db($event_log);
		if($event_log_return == 0)
		{
			PRINT "Error creating table event_log<BR>\n";
		}
		
		$followups_return = setup_db($followups);
		if($followups_return == 0)
		{
			PRINT "Error creating table followups<BR>\n";
		}
		
		$groups_return = setup_db($groups);
		if($groups_return == 0)
		{
			PRINT "Error creating table groups<BR>\n";
		}
		
		$inst_software_return = setup_db($inst_software);
		if($inst_software_return == 0)
		{
			PRINT "Error creating table inst_software<BR>\n";
		}
		
		$networking_return = setup_db($networking);
		if($networking_return == 0)
		{
			PRINT "Error creating table networking<BR>\n";
		}
		
		$networking_ports_return = setup_db($networking_ports);
		if($networking_ports_return == 0)
		{
			PRINT "Error creating table networking_ports<BR>\n";
		}
		
		$networking_wire_return = setup_db($networking_wire);
		if($networking_wire_return == 0)
		{
			PRINT "Error creating table networking_wire<BR>\n";
		}
		
		$prefs_return = setup_db($prefs);
		if($prefs_return == 0)
		{
			PRINT "Error creating table prefs<BR>\n";
		}
		
		$software_return = setup_db($software);
		if($software_return == 0)
		{
			PRINT "Error creating table software<BR>\n";
		}
		
		$templ_inst_software_return = setup_db($templ_inst_software);
		if($templ_inst_software_return == 0)
		{
			PRINT "Error creating table templ_inst_software<BR>\n";
		}
		
		$templates_return = setup_db($templates);
		if($templates_return == 0)
		{
			PRINT "Error creating table templates<BR>\n";
		}
		
		$tracking_return = setup_db($tracking);
		if($tracking_return == 0)
		{
			PRINT "Error creating table tracking<BR>\n";
		}
		
		$users_return = setup_db($users);
		if($users_return == 0)
		{
			PRINT "Error creating table users<BR>\n";
		}
	
		$config_return = setup_db($config);
		if($config_return == 0)
		{
			PRINT "Error creating table config<BR>\n";
		}

		$software_bundles_return = setup_db($software_bundles);
		if($software_bundles_return == 0)
		{
			PRINT "Error creating table software_bundles<BR>\n";
		}

		$software_licenses_return = setup_db($software_licenses);
		if($software_licenses_return == 0)
		{
			PRINT "Error creating table software_licenses<BR>\n";
		}

		$kbarticles_return = setup_db($kbarticles);
		if($kbarticles_return == 0)
		{
			PRINT "Error creating table kbarticles<BR>\n";
		}

		$kbcategories_return = setup_db($kbcategories);
		if($kbcategories_return == 0)
		{
			PRINT "Error creating table kbcategories<BR>\n";
		}
		$fasttracktemplates_return = setup_db($fasttracktemplates);
		if($fasttracktemplates == 0)
		{
			PRINT "Error creating table fasttracktemplates<BR>\n";
		}
	}

	if($running == "yes")
	{
		PRINT "<BR>\n";
		PRINT "If you don't see any errors above, the task completed successfully.\n";
		PRINT "<BR>\n";
	} else
	{

		
		PRINT "<hr>\n";
		PRINT "<CENTER><H2>Upgrade</H2></CENTER>\n";
		PRINT "<form method=post action=\"setup.php\" >\n";
		PRINT "If you are upgrading from an old version of IRM, select your version";
		PRINT " from the following list: ";
		PRINT "<SELECT NAME=\"old_version\" SIZE=1>\n";
		PRINT "<OPTION VALUE=\"0.9a.4\">0.9a.x</OPTION>\n";
		PRINT "<OPTION VALUE=\"0.9b\">0.9b - 0.9b.2</OPTION>\n";
		PRINT "<OPTION VALUE=\"0.9b.3\">0.9b.3 - 0.9c.2</OPTION>\n";
		PRINT "<OPTION VALUE=\"0.9c.3\">0.9c.3</OPTION>\n";
		PRINT "<OPTION VALUE=\"0.9c.4\">0.9c.4</OPTION>\n";
		PRINT "<OPTION VALUE=\"1.0.0\">1.0.0 - 1.0.2</OPTION>\n";
		PRINT "<OPTION VALUE=\"1.3.0\">1.3.0</OPTION>\n";
		PRINT "<OPTION VALUE=\"1.3.1\">1.3.1</OPTION>\n";
		PRINT "<OPTION VALUE=\"1.3.2\">1.3.2</OPTION>\n";
		PRINT "<OPTION VALUE=\"1.3.3\">1.3.3</OPTION>\n";
		PRINT "<OPTION VALUE=\"1.3.4\">1.3.4, 1.4.0pre1, or 1.4.0pre2</OPTION>\n";
		PRINT "</SELECT>\n";
		PRINT "Please enter the name of the database that should be upgraded: ";
		PRINT "<input type=\"text\" name=\"cfg_dbdb\">\n";
		PRINT "<input type=\"hidden\" name=\"running\" value=\"yes\">\n";
		PRINT "<input type=\"hidden\" name=\"submit\" value=\"Upgrade\">\n";
		PRINT "<input type=\"submit\" name=\"submit\" value=\"Upgrade\">\n";
		PRINT "</form>\n";
		PRINT "<hr>\n";
		PRINT "<CENTER><H2>New Install</H2></CENTER>\n";
		PRINT "<form method=get action=\"setup.php\">\n";
		PRINT "If this is a new install, enter the name of your database";
		PRINT " here: ";
		PRINT "<input type=\"text\" name=\"cfg_dbdb\">\n";
		PRINT "<input type=\"hidden\" name=\"running\" value=\"yes\">\n";
		PRINT "<input type=\"hidden\" name=\"submit\" value=\"Install\">\n";
		PRINT "<input type=\"submit\" name=\"submit\" value=\"Install\">\n";
		PRINT "</form>\n";
	}

PRINT "<hr noshade>\n";
PRINT "<br>\n";
PRINT "</font>\n";
PRINT "<i>IRM Version <b>$irm_version</b></i> ";
PRINT "<a href=\"http://irm.schoenefeld.org/\">IRM Website</a>\n";
PRINT "<br>IRM is protected by the \n";
PRINT "		<a href=\"$PREFIX/docs/COPYING\">GNU GPL License</a>.";
PRINT "		&copy; 1999,2000,2001 <a href=\"$PREFIX/docs/AUTHORS\">Atrus ";
PRINT "Trivalie Productions</a> ";
PRINT "<a href=\"mailto:atrus@atrustrivalie.eu.org\">atrus@atrustrivalie.eu.org</a>.<br>\n";
PRINT "</body>\n";
PRINT "</html>\n";
?>
