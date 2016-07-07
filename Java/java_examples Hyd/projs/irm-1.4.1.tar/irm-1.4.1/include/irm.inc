<?php


# $root_path: The root path of the IRM installation.
# Set this to the actual path of where IRM is installed: this information
# is needed to find the configuration files. 
# Default: $root_path = "/full/path/to/irm";

$root_path = "/home/atrus/public_html/irm";

# The background color tuneables. Leave at their defaults

$bgcd = "BGCOLOR=#BBBBBB";
$bgcl = "BGCOLOR=#DDDDDD";


# ****************************************************************************
#
#
# There is NOTHING else to configure here.  EVERYTHING is in config.inc.php
# 
# ****************************************************************************


#    IRM - The Information Resource Manager
#    Copyright (C) 1999-2002 Yann Ramin & Keith Schoenefeld
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
#    $Id: irm.inc,v 1.55.2.2 2003/07/07 05:16:03 theatrus Exp $
#
###############################################################################


$include_path = "$root_path/include";
include("$include_path/config.inc.php");
ini_set("include_path", $include_path."/DBI");


#
# Start and register session variables
session_start();

#

session_register("IRMName", "IRMPass", "cfg_dbdb");




require("$root_path/include/DBI/class.DBI");



//$dbstr = "dbi:" . $cfg_dbtype . ":" . $cfg_dbdb . ";" . $cfg_dbname;
$adb = new DBI($cfg_dbtype, $cfg_dbdb, $cfg_dbname, $cfg_dbuser, $cfg_dbpasswd);

if( !$adb->dbh ){
  echo "Could not connect to the database.<BR>\n";
  exit();
}

# Setup config values.
$query = "select * from config";
$sth = $adb->prepare($query);
if($sth)
{
	$res = $sth->execute();
	$result = $sth->fetchrow_hash();
	$cfg_notifyassignedbyemail = $result["notifyassignedbyemail"];
	$cfg_notifynewtrackingbyemail = $result["notifynewtrackingbyemail"];
	$cfg_newtrackingemail = $result["newtrackingemail"];
	$cfg_groups = $result["groups"];
	$cfg_usenamesearch = $result["usenamesearch"];
	$cfg_userupdates = $result["userupdates"];
	$cfg_sendexpire = $result["sendexpire"];
	$cfg_showjobsonlogin = $result["showjobsonlogin"];
	$cfg_minloglevel = $result["minloglevel"];
	$LOGO = $result["logo"];
	$cfg_snmp = $result["snmp"];
	$cfg_snmp_rcommunity = $result["snmp_rcommunity"];
	$cfg_snmp_ping = $result["snmp_ping"];
	$cfg_knowledgebase = $result["knowledgebase"];
	$cfg_fasttrack = $result["fasttrack"];
        $cfg_anonymous = $result["anonymous"];
        $cfg_anon_faq = $result["anon_faq"];
         $cfg_anon_req = $result["anon_req"];
	$irm_version = $result["version"];
	#$irm_build = $result["build"];
	$sth->finish();
} else {
  PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
}

if ($cfg_snmp == 1) {
  include("$include_path/snmp.inc.php");
}

function SetupStyle()
{
	PRINT "  <STYLE TYPE=\"text/css\">\n";
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
	PRINT "	//-->\n";
	PRINT "	</STYLE>\n";
}

function commonHeader($title) 
{
  global $USERPREFIX, $IRMName, $adb, $cfg_knowledgebase, $cfg_fasttrack, $PREFIX, $LOGO, $bgcd, $bgcl;
  if ($cfg_sendexpire == 1) {
    header("Expires: Fri, Jun 12 1981 08:20:00 GMT\nPragma: no-cache");
  }
  PRINT "<!-- IRM is (c) 1999-2002 Atrus Trivalie Productions -->\n";
  PRINT "<!-- Yann Ramin atrus@atrustrivalie.org -->\n";
  PRINT "<!-- Keith Schoenefeld keith-p@schoenefeld.org -->\n";
  PRINT "<!-- Some code is (c) 1999 Brandon Neill bneill@learn2.com  -->\n";
  PRINT "<!-- http://www.atrustrivalie.org/irm/ -->\n";
  PRINT "<HTML>\n";
  PRINT "<HEAD>\n";
  PRINT "<TITLE>IRM: $title</TITLE>\n";
  if ($cfg_sendexpire == 1) {
    PRINT "<META HTTP-EQUIV=\"Expires\" CONTENT=\"Fri, Jun 12 1981 08:20:00 GMT\">\n";
    PRINT "<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n";
    PRINT "<META HTTP-EQUIV=\"Cache-Control\" CONTENT=\"no-cache\">\n";
  }
  SetupStyle();
  PRINT "</HEAD>\n";
  PRINT "<BODY BGCOLOR=\"#FFFFFF\" TEXT=\"#000000\" LINK=\"#054BBB\" VLINK=\"#006342\">\n";
  PRINT "<FONT FACE=\"arial, helvetica\">\n";
  PRINT "<!-- Main Information -->\n";
  PRINT "<BR>\n";
  PRINT "<TABLE CELLSPACING=0 BORDER=0 HEIGHT=20 WIDTH=100%>\n";
  PRINT "<TR HEIGHT=20 $bgcd>";

  $user = new User($IRMName);
  $usertype = $user->getType();

  PRINT "      <TD>";
  if($usertype == "tech" || $usertype == "admin")
    {
      PRINT "		<A HREF=\"$USERPREFIX/computers-index.php\"> ";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		Computers</FONT></A> | <A HREF=\"$USERPREFIX/networking-index.php\">";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		Networking </FONT></A> | <A HREF=\"$USERPREFIX/software-index.php\">";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		Software</FONT></A> | ";
    }
  PRINT "<A HREF=\"$USERPREFIX/tracking-index.php\">";
  PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
  PRINT "		Tracking</FONT></A> | ";
  if($usertype == "tech" || $usertype == "admin")
    {
      if($cfg_fasttrack == 1)
	{
	  PRINT "<A HREF=\"$USERPREFIX/tracking-fasttrack-autofill.php\">";
	  PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
	  PRINT "		FastTrack</FONT></A> | ";
	}
      PRINT "<A HREF=\"$USERPREFIX/reports-index.php\">";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		Reports</FONT></A> | ";
    }
  PRINT "<A HREF=\"$USERPREFIX/helper.php\">";
  PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
  PRINT "		Request Help</FONT></A> |";
  if($usertype == "tech" || $usertype == "admin")
    {
      PRINT "<A HREF=\"$USERPREFIX/setup-index.php\">";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		Setup</FONT></A> | <A HREF=\"$USERPREFIX/prefs-index.php\">";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		Preferences</FONT></A> | ";
      if($cfg_knowledgebase == 1)
	{
	  PRINT "<A HREF=\"$USERPREFIX/knowledgebase-index.php\">";
	  PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
	  PRINT "		Knowledge Base</FONT></A> | ";
	}
    }
  if($cfg_knowledgebase == 1)
    {
      PRINT "<A HREF=\"$USERPREFIX/faq-index.php\">";
      PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
      PRINT "		FAQ</FONT></A> | ";
    }
  PRINT "<A HREF=\"$USERPREFIX/logout.php\">";
  PRINT "		<FONT COLOR=#000000 FACE=\"Arial, Helvetica\">";
  PRINT "		Logout</FONT></A></TD>";
  
  PRINT "<TD ALIGN=right>\n";
  $datetime = date("M d H:i");
  PRINT $datetime;
  PRINT " </TD>\n";
  PRINT "</TR>\n";
  PRINT "</TABLE>\n";
  PRINT "  <A HREF=\"$USERPREFIX/index.php\"><IMG SRC=\"$PREFIX/$LOGO\" BORDER=0></A><BR>";
  
  PRINT "<h3> $title</h3>\n";
  PRINT "<HR NOSHADE>\n";
}

function commonFooter() 
{
  global $USERPREFIX, $irm_version, $irm_build, $PREFIX;
    ?>
    <HR NOSHADE>
       <BR>
       </FONT>	
       <?php
       PRINT "<i>IRM Version <b>$irm_version, build ($irm_build)</b>";
    ?>
       <A HREF="http://irm.schoenefeld.org/">IRM
	  Website</A>
	  <BR>IRM is protected by the 
	  <?php
	  PRINT "		<A HREF=\"$PREFIX/docs/COPYING\">GNU GPL License</A>.";
  PRINT "		&copy; 1999-2002 <A HREF=\"$PREFIX/docs/AUTHORS\">Atrus ";
  PRINT "Trivalie Productions</A>";
    ?>
    </BODY>
    </HTML>
	
<?php
}

function AuthCheck($authtype) 
{
  global $IRMName, $IRMPass, $USERPREFIX, $adb, $bgcl, $bgcd;
  
  $user = new User($IRMName);
  $type = $user->getType();
  if (IsSet($IRMName) == FALSE) 
    {
      commonHeader("Not Logged In");
      PRINT "  You were not logged in. (Check your browsers cookies)  ";
      PRINT "<A HREF=\"$PREFIX/index.php\">Go Back to the login screen</A>.";
      commonFooter();
      exit();
    } else 
      {
	if ($authtype == "normal") 
	  {
	    if ($type != "normal" && $type != "tech" && $type != "admin")
	      {
		commonHeader("Permission Denied");
		PRINT "You are not a Normal User!";
		commonFooter();
		exit();
	      }
	  } else if ($authtype == "tech") 
	    {
	      if ($type != "tech" && $type != "admin")
		{
		  commonHeader("Permission Denied");
		  PRINT "You are not an Technician!";
		  commonFooter();
		  exit();
		}
	    } else if ($authtype == "admin")
	      {
		if($type != "admin")
		  {
		    commonHeader("Permission Denied");
		    PRINT "You are not an Administrator!";
		    commonFooter();
		    exit();
		  }
	      }
	{
	  return 0;
	}
      }
}

function Dropdown($table,$myname) 
{
  global $USERPREFIX, $adb;
  $query = "SELECT * FROM $table ORDER BY name";
  $sth = $adb->prepare($query);
  if($sth)
    {
      $res = $sth->execute();
      //$numRows = $sth->rows();
      PRINT "<SELECT NAME=\"$myname\" SIZE=1>";
      while($result = $sth->fetchrow_hash()) {
	
	$output = $result["name"];
	PRINT "<OPTION VALUE=\"$output\">$output</OPTION>";
	
      }
      PRINT "</SELECT>\n";
      $sth->finish();
    } else
      {
	PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
      }
}

function Dropdown_groups($table,$myname) 
{
  global $USERPREFIX, $adb;
  $query = "SELECT * FROM $table ORDER BY name";
  $sth = $adb->prepare($query);
  if($sth)
    {
      $res = $sth->execute();
      
      PRINT "<SELECT NAME=\"$myname\" SIZE=1>";
      while($result = $sth->fetchrow_hash()) {
	
	$output = $result["name"];
	$output2 = $result["ID"];
	PRINT "<OPTION VALUE=\"$output2\">$output</OPTION>";
	
      }
      PRINT "</SELECT>";
      $sth->finish();
    } else
      {
	PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
      }
}

function Dropdown_value($table,$myname, $value) 
{
  global $USERPREFIX, $adb;
  $query = "SELECT * FROM $table ORDER BY name";
  $sth = $adb->prepare($query);
  if($sth) {
    $res = $sth->execute();
    
    PRINT "<SELECT NAME=\"$myname\" SIZE=1>";
    while($result = $sth->fetchrow_hash()) {
      
      $output = $result["name"];
      if ($output == $value) {
	PRINT "<OPTION VALUE=\"$output\" SELECTED>$output</OPTION>";
      } else {
	PRINT "<OPTION VALUE=\"$output\">$output</OPTION>";
      }
    }
    
    PRINT "</SELECT>";
    $sth->finish();
  } else {
    PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
  }
}

function showComputer($ID, $expand) 
{
  global $cfg_snmp, $cfg_snmp_ping, $USERPREFIX, $adb, $bgcd, $bgcl;
  $query = "SELECT * FROM computers WHERE (ID = $ID)";
  $sth = $adb->prepare($query);
  if($sth) {
    $res = $sth->execute();
    $result = $sth->fetchrow_hash();
    
    $name = $result["name"];
    $type = $result["type"];
    $os = $result["os"];
    $osver = $result["osver"];
    $processor = $result["processor"];
    $processor_speed = $result["processor_speed"];
    $location = $result["location"];
    $serial = $result["serial"];
    $otherserial = $result["otherserial"];
    $ramtype = $result["ramtype"];
    $ram = $result["ram"];
    $network = $result["network"];
    $ip = $result["ip"];
    $mac = $result["mac"];
    $hdspace = $result["hdspace"];
    $comments = $result["comments"];
    $contact = $result["contact"];
    $contact_num = $result["contact_num"];
    $date_mod = $result["date_mod"];
    $flags_server = $result["flags_server"];
    $sth->finish();
  } else {
    PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
  }
  
  $new_date = date("Y-m-d H:i:s");
  $comments = stripslashes($comments);
  PRINT "<TABLE WIDTH=100% BORDER=1 noshade>
		<form method=post action=\"$USERPREFIX/computers-update.php\">
		<input type=hidden name=ID value=\"$ID\">
		<tr $bgcd><td colspan=2>
		<FONT face=\"Arial, Helvetica\">";
  
  if ($cfg_snmp == 1) {
    
    if ($cfg_snmp_ping == 1) {
      if ($ip != "" OR $ip != "DHCP" OR $ip != "dhcp") {
	$out = exec(EscapeShellCmd("ping -c 1 -n -i 1 -w 3 $ip"),$dummy_array, $ping_return);
      }
      if ($ping_return == 2) {
	$hstatus = "| Host: <FONT COLOR=red>DOWN</FONT>";
      } else if ($ping_return == 0) {
	$hstatus = "| Host: <FONT COLOR=green>UP</FONT>";
      } else {
	$hstatus = "| Host: UNKNOWN ERROR";
      }
    }
    $snmp_link = " | <A HREF=\"$USERPREFIX/snmp-stat.php?ID=$ID\">Runtime Information (SNMP)</A> $hstatus";
  }
  if ($expand == 1)
    {
      PRINT "<strong>$name ($ID)</strong> 
		<A HREF=\"$USERPREFIX/helper-add.php?ID=$ID&is_group=no\">Add Tracking</A>$snmp_link";
    } else if ($expand == 0) {
      PRINT "<strong><A HREF=\"$USERPREFIX/computers-info.php?ID=$ID\">$name 
		($ID)</strong></A> 
		<A HREF=\"$USERPREFIX/tracking-add-form.php?ID=$ID\">Add Tracking</A>$snmp_link";
    }
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Name:<BR><input type=text name=name value=\"$name\" 
		size=24></FONT></TD><TD><FONT face=\"Arial, Helvetica\">
		Type:<BR>";
  Dropdown_value("dropdown_type", "type", $type);
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">Location:<BR>";
  Dropdown_value("dropdown_locations", "location", $location);
  PRINT "</FONT></TD><TD><FONT face=\"Arial, Helvetica\">OS:<BR>";
  Dropdown_value("dropdown_os", "os", $os);
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		OS Version:<BR><input type=text size=5 name=osver 
		value=\"$osver\"></FONT></TD><TD><FONT face=\"Arial, 
		Helvetica\">Processor:<BR>";
  Dropdown_value("dropdown_processor", "processor", $processor);
  
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Processor Speed:<BR><input type=text name=processor_speed 
		size=4 value=\"$processor_speed\"></FONT></TD><TD>
		<FONT face=\"Arial, Helvetica\">Serial Number:<BR>
		<input type=text name=serial size=35 value=\"$serial\">
		</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Other Serial Number:<BR><input type=text size=25 
		name=otherserial value=\"$otherserial\"></FONT></TD>
		<TD><FONT face=\"Arial, Helvetica\">Hard Drive Space 
		(in gigabytes):<BR><input type=text name=hdspace size=5 
		value=\"$hdspace\"></FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">RAM Type:<BR>";
  Dropdown_value("dropdown_ram", "ramtype", $ramtype);
  PRINT "</FONT></TD><TD><FONT face=\"Arial, Helvetica\">
		RAM Amount (in MB):<BR><input type=text name=ram 
		value=\"$ram\" size=5></FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Network Card Brand/Type:<BR>";
  Dropdown_value("dropdown_network", "network", $network);
  PRINT "</FONT></TD><TD><FONT face=\"Arial, Helvetica\">
		IP Address:<BR><input type=text name=ip value=\"$ip\" 
		size=16></FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		MAC/Network Address:<BR><input type=text name=mac 
		value=\"$mac\"></FONT></TD><TD>Comments:<BR><textarea 
		cols=20 rows=5 name=comments wrap=soft>$comments</textarea>
		</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Contact Person:<BR><input type=text name=contact size=20 
		value=\"$contact\"></FONT></TD><TD><FONT face=\"Arial, 
		Helvetica\">Contact Number:<BR><input type=text 
		name=contact_num value=\"$contact_num\"></FONT></TD></TR>";
  PRINT "<tr $bgcl ><td colspan=2><FONT face=\"Arial, Helvetica\">
  		Flags: ";
  if ($flags_server == 1) {
    PRINT "<INPUT TYPE=CHECKBOX NAME=flags_server VALUE=yes CHECKED>";
  } else {
    PRINT "<INPUT TYPE=CHECKBOX NAME=flags_server VALUE=yes>";
  }
  
  PRINT " Server (constant running)</FONT></TD></TR>";
  PRINT "<TR BGCOLOR=#DDDDD0><td colspan=2 align=center><FONT 
		face=\"Arial, Helvetica\">Last Updated: $date_mod 
		<input type=hidden name=date_mod value=\"$new_date\"></TD>
		</TR>";
  PRINT "<tr $bgcd><TD><input type=submit value=Update></form>
		<form method=post action=\"$USERPREFIX/computers-del.php\">
		<input type=hidden name=ID value=$ID></TD><TD>
		<input type=submit value=Delete></form></TD></TR></TABLE>";
  PRINT "<BR>";
}

function find_license($ID) {
  # Added March 12th, 2001 (micajc)
  # This function attempts to find an lID of an unassigned 
  # license for the passwd software ID. Remember
  # to lock the inst_software table if your going to use this
  # to assign a license.
  global $adb, $bgcl, $bgcd;

  $query = "SELECT software_licenses.*,inst_software.lID,count(lID) AS cnt
		FROM software_licenses
		LEFT JOIN inst_software
 		ON software_licenses.ID=inst_software.lID
		WHERE software_licenses.sID=$ID
		GROUP BY software_licenses.ID
		HAVING cnt<entitlement 
		ORDER BY lID DESC";

   $sth = $adb->prepare($query);
   if ($sth) {
		$res = $sth->execute();
		if ($result = $sth->fetchrow_hash()) {

			$sth->finish;
			$lID = $result[ID];
			return $lID;
		}
   } else {
      print "Could not prepare $query Got $sth->errstr find_licenses<BR>";
   }   
	$sth->finish;
   return 0;
}

function showSoftware($ID) 
{
  # Modifyed March 8th, 2001 to reflect removal of some data items.
  # (micajc)
  global $USERPREFIX, $adb, $bgcl, $bgcd;
  $query = "SELECT * FROM software WHERE (ID = $ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
  	$name = $result["name"];
  	$platform = $result["platform"];
  	$comments = $result["comments"];
	$class = $result["class"];
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
  $comments = stripslashes($comments);
  PRINT "<TABLE WIDTH=100% BORDER=1 noshade><form method=post 
		action=\"$USERPREFIX/software-update.php\">
		<input type=hidden name=ID value=\"$ID\">
		<input type=hidden name=class value=\"$class\">
		<tr $bgcd><td colspan=2><FONT face=\"Arial, Helvetica\" size=+1>";

  PRINT "$class: $name ($ID)";
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, 
		Helvetica\">Name:<BR><input type=text name=name 
		value=\"$name\" size=24></FONT></TD><TD><FONT face=\"Arial,
		 Helvetica\">Platform:<BR>";

  Dropdown_value("dropdown_os", "platform", $platform);

  PRINT "</FONT></TD></TR>";

  PRINT "<tr $bgcl ><td VALIGN=TOP>Licenses: ";
  $licensed = Count_licenses($ID);
  $installed = Count_installations($ID);
  $remaining = $licensed - $installed;
  if ($remaining <= 0) {
		$remaining =  "<FONT COLOR=red>$remaining</FONT>";
  } 
	PRINT "<TABLE>
		<TR><TD>Licenses</TD><TD><B>$licensed</B></TD></TR>
		<TR><TD>Installed</TD><TD><B>$installed</b></TD></TR>
		<TR><TD>Remaining:</TD><TD><B>$remaining</B></TD></TR>
		</TABLE>";

  PRINT "<TD><FONT face=\"Arial, 
		Helvetica\">Comments:<BR><textarea cols=80 rows=5 
		name=comments wrap=soft>$comments</textarea></FONT></TD></TR>";
  PRINT "<tr $bgcd><TD>
		<input type=submit value=Update></form></TD><TD>
		<form method=post action=\"$USERPREFIX/software-del.php\">
		<input type=submit value=Delete valign=top>
		<input type=hidden name=ID value=$ID>
		</form></TD></TR></TABLE>";
  PRINT "<BR>";
}
function showBundled($ID) { 
	global $adb, $bgcl, $bgcd;
	print "<B>Software Bundle Information ($numRows) </B>
				 <TABLE WIDTH=100% BORDER=1>
				<TR $bgcd><TD>Software ID</TD><TD>Name</TD></TR>
				<Form method=post  action=software-bundle-add-software.php>
				<input type=hidden name=bID value=$ID>
				<TR $bgcl><TD><input type=submit value=Add></TD><TD>"; 
		SoftwareDropdown("WHERE class!='Application Bundle'");
		print "</TD></TR></form>";

	$query = "SELECT software_bundles.*,software.name FROM software_bundles
					LEFT JOIN software ON software.ID=sID
					WHERE software_bundles.bID=$ID ORDER by software.name";
	$sth = $adb->prepare($query);
	if ($sth) {
		$res = $sth->execute();

		while (	$result = $sth->fetchrow_hash()) {

			$sID=$result[sID];
			$name=$result[name];
			print "<TR $bgcl><TD>$sID</TD><TD>$name</TD></TR>";
		}
		print "</TABLE><BR>";
	}
}

function showLicenses($ID) {
   global $USERPREFIX, $adb, $bgcl, $bgcd;
   $query = "SELECT * FROM software_licenses WHERE ( sID = $ID)";
	$sth =  $adb->prepare($query);
	if ($sth) {
		$res = $sth->execute();


		print "<TABLE WIDTH=100% BORDER=1>
			<TR $bgcd><TD><B>ID</B></TD>
				<TD><B>License Key</B></TD>
				<TD><B>Entitlement</B></TD>
				<TD><B>Oem Sticker</B></TD></TR>";
		print "<TR $bgcl><Form method=post action=license-add.php>
			<input type=hidden name=sID value=$ID>
			<TD><input type=submit value=Add></TD>
			<TD><input type=text name=licensekey size=40></TD>
			<TD><input type=text name=entitlement size=4></TD>
			<TD><input type=checkbox name=oem_sticker></TD></TR>
			</form>
			<Form method=post action=license-del.php>";

	        while($result = $sth->fetchrow_hash()) {
               
					$sID = $result[sID];
					$lID = $result[ID];
					$licensekey = $result[licensekey];
					$entitlement = $result[entitlement];
					$oem_sticker = $result[oem_sticker];
					print "<TR $bgcl ><TD>
					<input type=radio name=lID value=$lID>$lID</TD>
					<TD>$licensekey</TD>
					<TD>$entitlement</TD>
					<TD>$oem_sticker</TD></TR>";
		}
		print "</TABLE>
		<input type=submit value=Del></form>";

	}
}
function showNetworking($ID)
{
  global $USERPREFIX, $adb, $bgcd, $bgcl;
  $query = "SELECT * FROM networking WHERE (ID = $ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
  	$name = $result["name"];
  	$type = $result["type"];
  	$ram = $result["ram"];
  	$serial = $result["serial"];
  	$otherserial = $result["otherserial"];
  	$location = $result["location"];
  	$ip = $result["ip"];
  	$mac = $result["mac"];
  	$datemod = $result["datemod"];
  	$contact = $result["contact"];
  	$contact_num = $result["contact_num"];
  	$comments = $result["comments"];
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
  $comments = stripslashes($comments);
  PRINT "<TABLE WIDTH=100% BORDER=1 noshade><form method=post
		action=\"$USERPREFIX/networking-update.php\"><input type=hidden
		name=ID value=\"$ID\"><tr $bgcd><td
		colspan=2><FONT face=\"Arial, Helvetica\">";

  PRINT "<strong>$name ($ID)</strong>";
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial,
		Helvetica\">Name:<BR><input type=text name=name
		value=\"$name\" size=24></FONT></TD><TD><FONT face=\"Arial,
		 Helvetica\">Type:<BR>";

  Dropdown_value("dropdown_type", "type", $type);

  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Location:<BR>";

  Dropdown_value("dropdown_locations", "location", $location);

  PRINT "</FONT></TD><TD>RAM amount: <BR><input type=text name=ram
		value=\"$ram\" size=5>";
  PRINT "</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD><FONT face=\"Arial, Helvetica\">
		Serial Number:<BR><input type=text name=serial size=35
		value=\"$serial\"></FONT></TD><TD><FONT face=\"Arial,
		Helvetica\">Other Serial Number:<BR><input type=text
		size=25 name=otherserial value=\"$otherserial\">
		</FONT></TD></TR>";
  PRINT "<tr $bgcl ><TD>IP:<BR><input type=text name=ip value=\"$ip\"
size=20></TD><TD>MAC:<BR><input
  	type=text size=20 name=mac value=\"$mac\"></TD></TR>";
  PRINT "<tr $bgcl ><TD>Contact:<BR><input type=text name=contact
value=\"$contact\" size=20>";

  PRINT "</TD>";
  PRINT "<TD>Contact Number:<BR><input type=text name=contact_num size=20 value=\"$contact_num\"></TD></TR>";
  PRINT "<tr $bgcl ><td colspan=2><FONT face=\"Arial,
		Helvetica\">Comments:<BR><textarea cols=40 rows=5
		name=comments wrap=soft>$comments</textarea></FONT></TD></TR>";
  PRINT "<tr $bgcd ><TD><input type=submit value=Update></form>
		<form method=post action=\"$USERPREFIX/networking-del.php\">
		<input type=hidden name=ID value=$ID></TD><TD>
		<input type=submit value=Delete></form></TD></TR></TABLE>";
  PRINT "<BR>";
  showPortsOnDevice($ID, 2);
}
function Count_Installations($sID)
{
	global $adb;
	$query = "SELECT * FROM inst_software 
		  WHERE (sID=$sID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		return $sth->rows();
	} else {
		print "Failure to prepare query $query in Count_Installations";
		return 0 ;
	}
}
function Count_licenses($sID) 
{
	global $adb;	
	$query = "SELECT * FROM software_licenses WHERE (sID = $sID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();

		$total_entitlement=0;
		while($record = $sth->fetchrow_hash()) {
			
			$total_entitlement+= $record[entitlement];		
		}
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	return $total_entitlement;
}

function Checked($field)
{
  if (($field == "yes") || ($field == 1))
  {
    return("checked");
  } else
  {
    return("");
  }
}

function computerListView($compquery, $sort, $phrasetype) 
{
  global $IRMName, $field, $goto, $contains, $style, $USERPREFIX, $adb, $bgcl, $bgcd;
   $query = "SELECT * FROM prefs WHERE (user = '$IRMName')";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
	  	$stype = $result["type"];
	  	$sos = $result["os"];
  		$sosver = $result["osver"];
  		$sprocessor = $result["processor"];
  		$sprocessor_speed = $result["processor_speed"];
  		$slocation = $result["location"];
  		$sserial = $result["serial"];
  		$sotherserial = $result["otherserial"];
  		$sramtype = $result["ramtype"];
  		$snetwork = $result["network"];
  		$sram = $result["ram"];
  		$sip = $result["ip"];  				
		$smac = $result["mac"];
  		$shdspace = $result["hdspace"];  
		$scontact = $result["contact"];
  		$scontact_num = $result["contact_num"];
  		$scomments = $result["comments"];
  		$sdate_mod = $result["date_mod"];
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
  $stype = Checked($stype);
  $sos = Checked($sos);
  $sosver = Checked($sosver);
  $sprocessor = Checked($sprocessor);
  $sprocessor_speed = Checked($sprocessor_speed);
  $slocation = Checked($slocation);
  $sserial = Checked($sserial);
  $sotherserial = Checked($sotherserial);
  $sramtype = Checked($sramtype);
  $sram = Checked($sram);
  $snetwork = Checked($snetwork);
  $sip = Checked($sip);
  $smac = Checked($smac);
  $shdspace = Checked($shdspace);
  $scontact = Checked($scontact);
  $scontact_num = Checked($scontact_num);
  $scomments = Checked($scomments);
  $sdate_mod = Checked($sdate_mod);
	  
	
  PRINT "<TABLE BORDER=1 WIDTH=100%><tr $bgcd>";
	
  PRINT "<th>Name</th>";
	  
  if ($stype == "checked") 
  {
    PRINT "<th>Type</th>";
  }
  if ($sos == "checked") 
  {
    PRINT "<th>OS</th>";
  }
  if ($sosver == "checked") 
  {
    PRINT "<th>OS Version</th>";
  }
  if ($sprocessor == "checked") 
  {
    PRINT "<th>Processor</th>";
  }
  if ($sprocessor_speed == "checked") 
  {
    PRINT "<th>Proc. Speed</th>";
  }
  if ($slocation == "checked") 
  {
    PRINT "<th>Location</th>";
  }
  if ($sserial == "checked") 
  {
    PRINT "<th>SN</th>";
  }
  if ($sotherserial == "checked") 
  {
    PRINT "<th>Other Serial</th>";
  }
  if ($sramtype == "checked") 
  {
    PRINT "<th>RAM Type</th>";
  }
  if ($sram == "checked") 
  {
    PRINT "<th>RAM</th>";
  }
  if ($snetwork == "checked") 
  {
    PRINT "<th>Network</th>";
  }
  if ($sip == "checked")
  {
    PRINT "<th>IP</th>";
  }
  if ($smac == "checked")
  {
    PRINT "<th>Net/MAC Addr.</th>";
  }
  if ($shdspace == "checked") 
  {
    PRINT "<th>HD Space</th>";
  }
  if ($scontact == "checked") 
  {
    PRINT "<th>Contact Person</th>";
  }
  if ($scontact_num == "checked") 
  {
    PRINT "<th>Contact Num.</th>";
  }
  if ($scomments == "checked") 
  {
    PRINT "<th>Comments</th>";
  }
  if ($sdate_mod == "checked") 
  {
    PRINT "<th>Date Modified</th>";
  }
	  
  PRINT "</TR>";

	$sth2 = $adb->prepare($compquery);
	if($sth2)
	{
		$res = $sth2->execute();
		$numRows = $sth2->rows();
		for($i = 0; $i < $goto; $i++)
		{
			$sth2->fetchrow_hash();
		}
		while($i < $numRows)
		{
			$result = $sth2->fetchrow_hash();
    	$ID = $result["ID"];
    	$name = $result["name"];
    	$type = $result["type"];
    	$os = $result["os"];
    	$osver = $result["osver"];
    	$processor = $result["processor"];
    	$processor_speed = $result["processor_speed"];
    	$location = $result["location"];
    	$serial = $result["serial"];
    	$otherserial = $result["otherserial"];
    	$ramtype = $result["ramtype"];
    	$ram = $result["ram"];
    	$network = $result["network"];
    	$ip = $result["ip"];
    	$mac = $result["mac"];
    	$hdspace = $result["hdspace"];
    	$comments = $result["comments"];
    	$date_mod = $result["date_mod"];
    	$contact = $result["contact"];
    	$contact_num = $result["contact_num"];	
    	$comments = $comments;
    	PRINT "<TR BGCOLOR=#DDDDDD><TD><A HREF=\"$USERPREFIX/computers-info.php?ID=$ID\">
			$name ($ID)</A></TD>";
			
    	if ($stype == "checked")
    	{
      	PRINT "<TD>$type</TD>";
    	}
    	if ($sos == "checked")
    	{
      	PRINT "<TD>$os</TD>";
    	}
    	if ($sosver == "checked")
    	{
      	PRINT "<TD>$osver</TD>";
    	}
    	if ($sprocessor == "checked") 
    	{
      	PRINT "<TD>$processor</TD>";
    	}
    	if ($sprocessor_speed == "checked")
    	{
      	PRINT "<TD>$processor_speed</TD>";
    	}
    	if ($slocation == "checked") 
    	{
      	PRINT "<TD>$location</TD>";
    	}
    	if ($sserial == "checked") 
    	{
      	PRINT "<TD>$serial</TD>";
    	}
    	if ($sotherserial == "checked")
    	{
      	PRINT "<TD>$otherserial</TD>";
    	}
    	if ($sramtype == "checked") 
    	{
      	PRINT "<TD>$ramtype</TD>";
    	}
    	if ($sram == "checked") 
    	{
      	PRINT "<TD>$ram</TD>";
    	}
    	if ($snetwork == "checked") 
    	{
      	PRINT "<TD>$network</TD>";
    	}
    	if ($sip == "checked") 
    	{
      	PRINT "<TD>$ip</TD>";
    	}
    	if ($smac == "checked")
    	{ 
      	PRINT "<TD>$mac</TD>";
    	}
    	if ($shdspace == "checked")
    	{
      	PRINT "<TD>$hdspace</TD>";
    	}
    	if ($scontact == "checked") 
    	{
      	PRINT "<TD>$contact</TD>";
    	}
    	if ($scontact_num == "checked") 
    	{
      	PRINT "<TD>$contact_num</TD>";
    	}
    	if ($scomments == "checked") 
    	{
      	PRINT "<TD>$comments</TD>";
    	}
    	if ($sdate_mod == "checked") 
    	{
      	PRINT "<TD>$date_mod</TD>";
    	}
				
    	PRINT "</TR>";
    	if (($goto + 24 - $i) < 1)
    	{
      	break;
    	}
    	$i++;
  	}
		$sth2->finish();
	} else
	{	
		PRINT "Could not prepare query: ".$sth2->errstr."<BR>\n";
	}
  $backgoto = $goto - 25;
  $forgoto = $goto + 25;
  PRINT "</TABLE>";
  PRINT "<TABLE BORDER=0><TR><TD>";
  if ($backgoto > -1)
  {
    PRINT "<form><input type=hidden name=sort value=\"$sort\">
		<input type=hidden name=phrasetype value=\"$phrasetype\"> 
		<input type=hidden name=field value=\"$field\">
		<input type=hidden name=contains value=\"$contains\">
		<input type=hidden name=style value=\"$style\">
		<input type=hidden name=goto value=$backgoto>
		<input type=submit value=\"Previous 25\"></form>";
  }
  PRINT "</TD><TD>";
  if ($forgoto < $numRows)
  {		
    PRINT "<form><input type=hidden name=sort value=\"$sort\">
		<input type=hidden name=phrasetype value=\"$phrasetype\"> 
		<input type=hidden name=field value=\"$field\">
		<input type=hidden name=contains value=\"$contains\">
		<input type=hidden name=style value=\"$style\">
		<input type=hidden name=goto value=$forgoto>
		<input type=submit value=\"Next 25\"></form>";
  }
  PRINT "</TD></TR></TABLE>";
}

function templcompsoftShow($showID) {
	global $USERPREFIX, $adb, $bgcl, $bgcd;
	$query = "SELECT * FROM templ_inst_software WHERE (cID = $showID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		PRINT "<TABLE BORDER=1 WIDTH=100%><TR $bgcd><th colspan=2>Installed Software</th></TR>";

		for ($i =0; $i < $numRows; $i++) 
  	{
			$result = $sth->fetchrow_hash();
			$sID = $result["sID"];
			$ID = $result["ID"];
			$query = "SELECT * FROM software WHERE (ID = $sID)";
			$sth2 = $adb->prepare($query);
			if($sth2)
			{
				$res2 = $sth2->execute();
				$result2 = $sth2->fetchrow_hash();
				$name = $result2["name"];
				$sth2->finish();
			} else
			{
				PRINT "Could not prepare query: ".$sth2->errstr."<BR>\n";
			}
			PRINT "<tr $bgcl ><TD><i><A HREF=\"$USERPREFIX/software-info.php?ID=$sID\">$name</A></i></TD><td WIDTH=10%><A HREF=\"$USERPREFIX/setup-templates-software-del.php?ID=$ID\">[Delete]</A></TD></TR>";
		}
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	
	PRINT "<tr $bgcd><TD><form method=post action=\"$USERPREFIX/setup-templates-software-add.php\"><input type=hidden name=cID value=$showID>Add software:";
SoftwareDropdown();
PRINT " to template.</TD><TD><input type=submit value=Add></form></TD></TR>";
	PRINT "</TABLE>";
}


function compsoftShow($showID) 
{
	global $USERPREFIX, $adb, $bgcl, $bgcd;
	$query = "SELECT * FROM inst_software WHERE (cID = $showID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		PRINT "<TABLE BORDER=1 WIDTH=100%><TR BGCOLOR=#BBBBB><th colspan=2>Installed Software</th></TR>";
		
		for ($i=0; $i < $numRows; $i++) 
		{
			$result = $sth->fetchrow_hash();
			$sID = $result["sID"];
			$ID = $result["ID"];
			$query = "SELECT * FROM software WHERE (ID = $sID)";
			$sth2 = $adb->prepare($query);
			if($sth2)
			{
				$res2 = $sth2->execute();
				$result2 = $sth2->fetchrow_hash();
				$name = $result2["name"];
			
				$sth2->finish();
			} else
			{
				PRINT "Could not prepare query: ".$sth2->errstr."<BR>\n";
			}
			PRINT "<tr $bgcl><TD><i><A HREF=\"$USERPREFIX/software-info.php?ID=$sID\">$name</A></i></TD><td WIDTH=10%><A HREF=\"$USERPREFIX/computers-software-del.php?ID=$ID\">[Delete]</A></TD></TR>";
		}
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	PRINT "<tr $bgcd><TD><form method=post action=\"$USERPREFIX/computers-software-add.php\"><input type=hidden name=cID value=$showID>Add software ";
	SoftwareDropdown();
	PRINT " to computer.</TD><TD><input type=submit value=Add></form></TD></TR>";
	PRINT "</TABLE>";
}

function SoftwareDropdown($where = "")
{
	global $USERPREFIX, $adb;
	$query = "SELECT name,ID FROM software $where ORDER BY name";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		PRINT "<SELECT NAME=sID SIZE=1>\n";
		for($i = 0; $i < $numRows; $i++) 
		{
			$result = $sth->fetchrow_hash();
			$version = $result["version"];
			$name = $result["name"];
			$sID = $result["ID"];
			PRINT "<OPTION VALUE=$sID>$name</OPTION>\n";
		}
		PRINT "</SELECT>\n";
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function Tech_list($value, $myname) 
{
  global $USERPREFIX, $adb;
  $query = "SELECT * FROM users WHERE (type = 'admin' || type = 'tech') ORDER BY name";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
  	$numRows = $sth->rows();
  	PRINT "<SELECT NAME=\"$myname\" SIZE=1>";
  	if ($numRows > 0)
  	{
    	PRINT "<OPTION VALUE=\"\">[ Nobody ]</OPTION>\n";
    	for($i = 0; $i < $numRows; $i++)
    	{
				$result = $sth->fetchrow_hash();
      	$output = $result["name"];
				$fullname = $result["fullname"];
      	if ($output == $value)
      	{
        	PRINT "<OPTION VALUE=\"$output\" SELECTED>$fullname</OPTION>\n";
      	} else
      	{
        	PRINT "<OPTION VALUE=\"$output\">$fullname</OPTION>\n";
      	}
    	}
  	}
  	PRINT "</SELECT>";
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function showPortsOnDevice($device, $device_type) {
	global $USERPREFIX, $adb;
	$query = "SELECT * FROM networking_ports WHERE (device_on = $device AND device_type = $device_type) ORDER BY logical_number";
	$sth = $adb->prepare($query);
	# 1 is computer, 2 networking device
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		PRINT "<TABLE BORDER=1 WIDTH=100%>";
		PRINT "<TR><th>Port #</th><th>Name</th><th>Interface</th><th>Iface Addr</th><th>If MAC</th><th>Connected to...</th></TR>";
	
		if ($numRows < 1) 
		{
			PRINT "<TR><td colspan=6>Looks like a lonley device to me.  No ports found.</TD></TR>";
		
		} else {
			for ($i=0; $i < $numRows; $i++) 
			{
				$result = $sth->fetchrow_hash();
				$ID = $result["ID"];
				$name = $result["name"];
				$logical_number = $result["logical_number"];
				$iface = $result["iface"];
				$ifaddr = $result["ifaddr"];
				$ifmac = $result["ifmac"];
				$wquery = "SELECT * FROM networking_wire WHERE (end1 = $ID OR end2 = $ID)";
				$sth2 = $adb->prepare($wquery);
				if($sth2)
				{
					$res = $sth2->execute();
					$numRows2 = $sth2->rows();	
					$wresult = $sth2->fetchrow_hash();
					if ($numRows2 > 0) 
					{
						$wID = $wresult["ID"];
						$wend1 = $wresult["end1"];
						$wend2 = $wresult["end2"];
						if ($wend1 == $ID) 
						{
							$pquery = "SELECT * FROM networking_ports WHERE (ID = $wend2)";
						} else 
						{
							$pquery = "SELECT * FROM networking_ports WHERE (ID = $wend1)";
						}
						$sth3 = $adb->prepare($pquery);
						if($sth3)
						{
							$res = $sth3->execute();
							$presult = $sth3->fetchrow_hash();
							$pID = $presult["ID"];
							$pNum = $presult["logical_number"];
							$pOn = $presult["device_on"];
							$pType = $presult["device_type"];
							if ($pType == 1) 
							{
								$nquery = "SELECT ID,name FROM computers WHERE (ID = $pOn)";
							} else if ($pType == 2) {
								$nquery = "SELECT ID,name FROM networking WHERE (ID = $pOn)";
							}
							$sth4 = $adb->prepare($nquery);
							if($sth4)
							{
								$res = $sth4->execute();
								$nresult = $sth4->fetchrow_hash();
								$nname = $nresult["name"];
								$nID = $nresult["ID"];
								$sth4->finish();
							} else
							{
								PRINT "Could not prepare query: ".$sth4->errstr."<BR>\n";
							}
							$sth3->finish();
						} else
						{
							PRINT "Could not prepare query: ".$sth3->errstr."<BR>\n";
						}
						$found = 1;
					} else 
					{
						$found = 0;
						$pType = 0;
					}
		
					PRINT "<TR><TD><A HREF=\"$USERPREFIX/networking-port.php?ID=$ID\">$logical_number</A></TD><TD>$name</TD><TD>$iface</TD><TD>$ifaddr</TD><TD>$ifmac</TD>";
					PRINT "<TD>";
					if ($pType == 1) 
					{
						PRINT "Port <A HREF=\"$USERPREFIX/networking-port.php?ID=$pID\">$pNum</A> on computer <A HREF=\"$USERPREFIX/computers-info.php?ID=$nID\">$nname ($nID)</A> | <A HREF=\"$USERPREFIX/networking-port-discon.php?ID=$ID\">Disconnect</A>.";
					} else if ($pType == 2) 
					{
						PRINT "Port <A HREF=\"$USERPREFIX/networking-port.php?ID=$pID\">$pNum</A> on network device <A HREF=\"$USERPREFIX/networking-info.php?ID=$nID\">$nname ($nID)</A> | <A HREF=\"$USERPREFIX/networking-port-discon.php?ID=$ID\">Disconnect</A>.";
					} else if ($found != 1) 
					{
						PRINT "Nothing Connected. <A HREF=\"$USERPREFIX/networking-connecter.php?ID=$ID\">Connect</A>";
					}
					PRINT "</TD></TR>";
					$found = 0;
					$pType=0;
					$sth2->finish();
				} else
				{
					PRINT "Could not prepare query: ".$sth2->errstr."<BR>\n";
				}
			}
		}
		PRINT "<TR><td colspan=6 align=right><A HREF=\"$USERPREFIX/networking-port-add-form.php?device=$device&device_type=$device_type\">Add Port</A></TD></TR>";
		PRINT "</TABLE><BR>";
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}

}

function logevent($item, $itemtype, $level, $service, $event) {
  global $cfg_minloglevel, $adb;
  if ($level <= $cfg_minloglevel) 
	{ 
	  $query = "INSERT INTO event_log VALUES (NULL, $item, '$itemtype', NOW(), '$service', $level, '$event')";
		$adb->dbh_do($query);		
  }
}

function show_events($sth) 
{
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		if ($numRows < 1) 
		{
			PRINT "<p>No events<BR>";
			return;
		}
		PRINT "<TABLE WIDTH=100% BORDER=1>";
		PRINT "<TR><th>Item</th><th>Date</th><th>Service</th><th WIDTH=5%>Level</th><th WIDTH=70%>Message</th></TR>";
		for($i = 0; $i < $numRows; $i++) 
		{
			$result = $sth->fetchrow_hash();
			$ID = $result["ID"];
			$item = $result["item"];
			$itemtype = $result["itemtype"];
			$date = $result["date"];
			$service = $result["service"];
			$level = $result["level"];
			$message = $result["message"];
			PRINT "<TR><TD>$itemtype: $item</TD><TD>$date</TD><TD>$service</TD><TD>$level</TD><TD>$message</TD></TR>";
		}
		PRINT "</TABLE>";
		$sth->finish();
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function setup_db($tablearray) 
{
	global $adb;
	if(is_array($tablearray) == false)
	{
		PRINT "Error: non-array variable was passed to create_table function\n";
		return(0);
	}
	
	$array_size = sizeof($tablearray);

	if($array_size > 0)
	{
		$sth = $adb->prepare($tablearray[0]);
		if($sth)
		{
			$res = $sth->execute();
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
			return(0);
		}
		if($res == 0)
		{
			PRINT "<FONT COLOR=red> Could not create table - </FONT>\n";
			return(0);
		}
		if($array_size > 1)
		{
			for($i = 1; $i < $array_size; $i++)
			{
				$sth2 = $adb->prepare($tablearray[$i]);
				if($sth2)
				{
					$res = $sth2->execute();
				} else
				{
					PRINT "Could not prepare query: ".$sth2->errstr."<BR>\n";
					return(0);
				}
				if($res == 0)
				{
					PRINT "Error adding data to table\n";
					return(0);
				}
			}
		}
	} else
	{
		PRINT "function create_table received an empty array\n";
		return(0);
	}
	return(1);
}

function kbdisplaycategories($parentID=0)
{
	global $adb;
	$query = "select * from kbcategories where (parentID = $parentID) order by name asc";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		if($numRows > 0)
		{	
			PRINT "<ul>\n";
			for($i=0; $i < $numRows; $i++)
			{
				$result = $sth->fetchrow_hash();
				$name = $result["name"];
				PRINT "<li><B>$name</B>\n";
				$ID = $result["ID"];
		  		kbdisplayarticles($ID);
				kbdisplaycategories($ID);
			}
			PRINT "</ul>\n";
		} 
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function kbdisplayarticles($parentID)
{
	global $adb;
	$query = "select * from kbarticles where (categoryID = $parentID) order by question asc";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		PRINT "<ul>\n";
		for($i=0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
			$ID = $result["ID"];
			kbdisplayarticle($ID);
		}
		PRINT "</ul>\n";
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function kbdisplayarticle($ID)
{
	global $adb, $USERPREFIX;
	$query = "select * from kbarticles where (ID=$ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$question = $result["question"];
		PRINT "<li><A HREF=\"$USERPREFIX/knowledgebase-detail.php?ID=$ID\">$question</A>\n";
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function kbdisplayfullarticle($ID)
{
	global $adb, $USERPREFIX;
	$query = "select * from kbarticles where (ID=$ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$question = $result["question"];
		$categoryID = $result["categoryID"];
		$fullcategoryname = kbcategoryname($categoryID);
		PRINT "<H2>Question ($fullcategoryname):</H2>$question\n";
		PRINT "<HR>\n";
		PRINT "<H2>Answer:</H2>\n";
		$answer = nl2br($result["answer"]);
		PRINT "$answer";
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function kbcategoryList($current=0)
{
	global $adb;
	PRINT "<SELECT NAME=categorylist size=1>\n";
	PRINT "<OPTION VALUE=0>Main</OPTION>\n";
	kbcategoryListSelect($current, 0, "Main\\");
	PRINT "</SELECT>\n";
}
function kbisfaq($ID)
{
	global $adb, $USERPREFIX;
	$query = "select * from kbarticles where (ID=$ID)";
	$sth = $adb->prepare($query);
	PRINT "<BR><HR>";
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$isFAQ = $result["faq"];
		if($isFAQ == "yes")
		{
			PRINT "This Knowledge Base entry is part of the FAQ.";
		} else
		{
			PRINT "This Knowledge Base entry is not part of the FAQ.";
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	PRINT "<BR><BR>\n";
	PRINT "<TABLE BORDER=0 WIDTH=100%>\n";
	PRINT "<TR>\n";
	if($isFAQ == "yes")
	{
		PRINT "<TD ALIGN=left WIDTH=\"33%\"><H4><A HREF=\"$USERPREFIX/knowledgebase-detail.php?ID=$ID&removefromfaq=yes\">Remove Article from the FAQ</A></H4></TD>\n";
	} else
	{
		PRINT "<TD ALIGN=left WIDTH=\"33%\"><H4><A HREF=\"$USERPREFIX/knowledgebase-detail.php?ID=$ID&addtofaq=yes\">Add Article to the FAQ</A></H4></TD>\n";
	}
	PRINT "<TD ALIGN=left WIDTH=\"34%\"><H4><A HREF=\"$USERPREFIX/knowledgebase-article-modify.php?ID=$ID\">Modify Article</A></H4></TD>\n";
	PRINT "<TD ALIGN=left WIDTH=\"33%\"><H4><A HREF=\"$USERPREFIX/knowledgebase-article-delete.php?ID=$ID\">Delete Article</A>";
	PRINT "		</H4></TD></TR>\n";
	PRINT "</TABLE>\n";
	PRINT "<BR>";
}

function kbcategoryListSelect($current, $parentID=0, $categoryname="")
{
	global $adb;
	$query = "select * from kbcategories where (parentID = $parentID) order by name desc";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		for($i = 0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
			$ID = $result["ID"];
			$name = $categoryname . $result["name"];
			PRINT "<OPTION VALUE=$ID";
			if($current == $ID)
			{
				PRINT " SELECTED";
			}
			PRINT ">$name</OPTION>\n";
			$name = $name . "\\";
			kbcategoryListSelect($current, $ID, $name);
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function kbcategoryname($ID, $wholename="")
{
	global $adb;
	$query = "select * from kbcategories where (ID = $ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		if($numRows > 0)
		{
			$result = $sth->fetchrow_hash();
			$parentID = $result["parentID"];
			if($wholename == "")
			{
				$name = $result["name"];
			} else
			{
				$name = $result["name"] . "\\";
			}
			$name = kbcategoryname($parentID, $name) . $name;
			if($parentID == 0)
			{
				$name = "Main\\" . $name;
			}
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	return ($name);
}

function getFAQCategories()
{
	global $adb;
	$query = "select * from kbarticles where (faq = 'yes')";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		$catNumbers = array();
		for($i=0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
			getFAQParentCategories($result["categoryID"], $catNumbers);
		#	$catNumbers[$i] = $result["categoryID"];
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	return($catNumbers);
}	

function getFAQParentCategories($ID, &$catNumbers)
{
	global $adb;
	$query = "select * from kbcategories where (ID = '$ID')";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		if($numRows > 0)
		{
			$result = $sth->fetchrow_hash();
			$parentID = $result["parentID"];
			if(!in_array($parentID, $catNumbers))
			{
				getFAQParentCategories($parentID, $catNumbers);
			}
			if(!in_array($ID, $catNumbers))
			{
				$szecatNumbers = sizeof($catNumbers);
				$catNumbers[$szecatNumbers] = $ID;
			}
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function faqdisplaycategories($parentID=0)
{
	global $adb;
	$catNumbers = array();
	$catNumbers = getFAQCategories();
	$query = "select * from kbcategories where (parentID = $parentID) order by name asc";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		if($numRows > 0)
		{	
			PRINT "<ul>\n";
			for($i=0; $i < $numRows; $i++)
			{
				$result = $sth->fetchrow_hash();
				$name = $result["name"];
				$ID = $result["ID"];
				if(in_array($ID, $catNumbers))
				{
					PRINT "<li><B>$name</B>\n";
		  			faqdisplayarticles($ID);
					faqdisplaycategories($ID);
				}
			}
			PRINT "</ul>\n";
		} 
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function faqdisplayarticles($parentID)
{
	global $adb;
	$query = "select * from kbarticles where (categoryID = $parentID) and (faq = 'yes') order by question asc";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		PRINT "<ul>\n";
		for($i=0; $i < $numRows; $i++)
		{
			$result = $sth->fetchrow_hash();
			$ID = $result["ID"];
			faqdisplayarticle($ID);
		}
		PRINT "</ul>\n";
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function faqdisplayarticle($ID)
{
	global $adb, $USERPREFIX;
	$query = "select * from kbarticles where (ID=$ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$question = $result["question"];
		PRINT "<li><A HREF=\"$USERPREFIX/faq-detail.php?ID=$ID\">$question</A>\n";
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
}

function kbaddtofaq($ID)
{
	global $adb;
	$query = "select * from kbarticles where (ID=$ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$categoryID = $result["categoryID"];
		$question = addslashes($result["question"]);
		$answer = addslashes($result["answer"]);
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	$query = "REPLACE kbarticles VALUES ('$ID', '$categoryID', '$question', '$answer', 'yes')";
	$adb->dbh_do($query);
}

function kbremovefromfaq($ID)
{
	global $adb;
	$query = "select * from kbarticles where (ID=$ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();
		$question = addslashes($result["question"]);
		$categoryID = $result["categoryID"];
		$answer = addslashes($result["answer"]);
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	$query = "REPLACE kbarticles VALUES ('$ID', '$categoryID', '$question', '$answer', 'no')";
	$adb->dbh_do($query);
}

function computerInGroup($ID)
{
	global $adb;
	$query = "select * from comp_group where (comp_id = $ID)";
	$sth = $adb->prepare($query);
	if($sth)
	{
		$res = $sth->execute();
		$numRows = $sth->rows();
		if($numRows > 0)
		{
			return(1);
		} else
		{
			return(0);
		}
	} else
	{
		PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
	}
	return(0);
}

function namepriority($priority)
{
	if($priority == 5)
	{
		return("<FONT COLOR=\"red\">Very High</FONT>");
	} else if ($priority == 4)
	{
		return("<FONT COLOR=\"purple\">High</FONT>");
	} else if ($priority == 3)
	{
		return("Normal");
	} else if ($priority == 2)
	{
		return("<FONT COLOR=\"blue\">Low</FONT>");
	} else if ($priority == 1)
	{
		return("<FONT COLOR=\"green\">Very Low</FONT>");
	}
}

class Followup
{
	
	var $ID;
	var $TrackingID;
	var $Author;
	var $FollowupInfo;
	var $DateEntered;

	function Followup($ID=0)
	{
		if($ID != 0)
		{
			$this->setID($ID);
			$this->retrieve();
		}
	}
	
	function retrieve()
	{
		global $adb;
		$query = "select * from followups where(ID=$this->ID)";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$result = $sth->fetchrow_hash();
			$this->setID($this->ID);
			$tempTrackingID = $result["tracking"];
			$this->setTrackingID($tempTrackingID);
			$tempAuthor = $result["author"];
			$this->setAuthor($tempAuthor);
			$tempFollowupInfo = $result["contents"];
			$this->setFollowupInfo($tempFollowupInfo);
			$tempDateEntered = $result["date"];
			$this->setDateEntered($tempDateEntered);
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
	}

	function add()
	{
		global $adb;
		if($this->ID != 0)
		{
			PRINT "Error adding Followup, ID != 0<BR>\n";
		}
		if($this->TrackingID == 0)
		{
			PRINT "Error adding Followup, trackingID is invalid<BR>\n";
		}
		if($this->Author == "")
		{
			PRINT "Error adding Followup, author not specified<BR>\n";
		}
		if($this->FollowupInfo == "")
		{
			PRINT "Error adding Followup, followupInfo not added<BR>\n";
		}
		$this->resetDateEntered();
		$slashFollowupInfo = addslashes($this->FollowupInfo);
		$query = "INSERT INTO followups VALUES(NULL, '$this->TrackingID', '$this->DateEntered', '$this->Author', '$slashFollowupInfo')";
		$res = $adb->dbh_do($query);
	}

	function displayAddForm()
	{
		global $IRMName;
		PRINT "<TR BGCOLOR=#BBBBBB><TD><FONT COLOR=\"yellow\">Add Followup</FONT>";
		PRINT "</TD><TD><FONT FACE=\"Arial, Helvetica\">$IRMName</FONT></TD>\n";
		PRINT "<TD><FONT FACE=\"Arial, Helvetica\"><TEXTAREA COLS=40 ";
		PRINT "ROWS=3 NAME=newfollowup WRAP=soft></TEXTAREA></FONT>\n";
	}
	
	function delete()
	{
		global $adb;
		$query = "DELETE FROM followups WHERE (ID='$this->ID')";
		$count = $adb->dbh_do($query);
	}

	function getID()
	{
		return($this->ID);
	}

	function getTrackingID()
	{
		return($this->TrackingID);
	}

	function getAuthor()
	{
		return($this->Author);
	}

	function getFollowupInfo()
	{
		return($this->FollowupInfo);
	}

	function getDateEntered()
	{
		return($this->DateEntered);
	}

	function setID($sID)
	{
		$this->ID = $sID;
	}

	function setTrackingID($tID)
	{
		$this->TrackingID = $tID;
	}

	function setAuthor($sAuthor)
	{
		$this->Author = $sAuthor;
	}

	function setFollowupInfo($sFI)
	{
		$this->FollowupInfo = $sFI;
	}

	function setDateEntered($DE)
	{
		$this->DateEntered = $DE;
	}

	function resetDateEntered()
	{
		$this->DateEntered = date("Y-m-d H:i:s");
	}

	function displayHeader()
	{
		PRINT "<TABLE BORDER=1 WIDTH=100%><TR><th colspan=3>Followups</th></TR><TR BGCOLOR=#DDCCBB><TD><b>Date</b></TD><TD><b>Author</b></TD><TD><b>Description</b></TD></TR>";
	}

	function displayFooter()
	{
		PRINT "</TABLE>";
	}

	function display()
	{
		global $bgcd;
		$contents = nl2br($this->FollowupInfo);
		PRINT "<TR $bgcd>";
		PRINT "<TD><FONT face=\"Arial, Helvetica\">";
		list($year,$month,$day,$hour,$minute,$second) = split("([^0-9])", $this->DateEntered);
		$timestamp = mktime($hour,$minute,$second,$month,$day,$year);
		$dateopened = date("h:iA - F j, Y", $timestamp);
		PRINT "$dateopened</FONT></TD><TD><FONT face=\"Arial, ";
		PRINT "Helvetica\">$this->Author</FONT></TD><TD><FONT ";
		PRINT "face=\"Arial, Helvetica\">$contents</FONT></TD>";
		PRINT "</TR>";
	}

	function commit()
	{
		global $adb;
		if($this->ID == 0)
		{
			PRINT "Error committing Followup. ID = 0. Use \"add\" to add new ";
			PRINT "Followups and \"commit\" to commit changes to Followups<BR>\n";
			return (0);
		}
		if($this->TrackingID == 0)
		{
			PRINT "Error committing Followup, trackingID is invalid<BR>\n";
			return (0);
		}
		if($this->Author == "")
		{
			PRINT "Error committing Followup, author not specified<BR>\n";
			return (0);
		}
		if($this->FollowupInfo == "")
		{
			PRINT "Error committing Followup, followupInfo not added<BR>\n";
			return (0);
		}
		$slashFollowupInfo = addslashes($this->FollowupInfo);
		$query = "REPLACE followups set ID='$this->ID', tracking='$this->TrackingID', date='$this->DateEntered', author='$this->Author', contents='$slashFollowupInfo'";
		$res = $adb->dbh_do($query);
	}
	
	function getByTrackingID($tID)
	{
		global $adb;
		$query = "select ID from followups where (tracking = $tID)";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			$followupIDs = array();
			for($i = 0; $i < $numRows; $i++)
			{
				$result = $sth->fetchrow_hash();
				$IDs[$i] = $result["ID"];
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
		return($IDs);
	}

	function addBody(&$mail)
	{
    list($year,$month,$day,$hour,$minute,$second) = split("([^0-9])", $this->DateEntered);
    $timestamp = mktime($hour,$minute,$second,$month,$day,$year);
    $dateopened = date("h:iA - F j, Y", $timestamp);
		$mail = $mail . "Followup added on: $dateopened\n";
		$mail = $mail . "Followup added by: $this->Author\n";
		$mail = $mail . "Followup information: $this->FollowupInfo\n\n";
	}
}

class Tracking
{
	var $ID;
	var $DateEntered;
	var $CloseDate;
	var $Status;
	var $Assign;
	var $ComputerID;
	var $WorkRequest;
	var $Priority;
	var $IsGroup;
	var $Author;
	var $AuthorEmail;
	var $EmailUpdatesToAuthor;
	var $Followups;
	var $newFollowups;

	function Tracking($ID=0)
	{
		if($ID != 0)
		{
			$this->setID($ID);
			$this->retrieve();
		}
	}
	
	function retrieve()
	{
		global $adb;
		$query = "SELECT * FROM tracking WHERE (ID=$this->ID)";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$result = $sth->fetchrow_hash();
			$tempDateEntered = $result["date"];
			$this->setDateEntered($tempDateEntered);
			$tempCloseDate = $result["closedate"];
			$this->setCloseDate($tempCloseDate);
			$tempStatus = $result["status"];
			$this->setStatus($tempStatus);
			$tempAssign = $result["assign"];
			$this->setAssign($tempAssign);
			$tempComputerID = $result["computer"];
			$this->setComputerID($tempComputerID);
			$tempWorkRequest = $result["contents"];
			$this->setWorkRequest($tempWorkRequest);
			$tempPriority = $result["priority"];
			$this->setPriority($tempPriority);
			$tempIsGroup = $result["is_group"];
			$this->setIsGroup($tempIsGroup);
			$tempAuthor = $result["author"];
			$this->setAuthor($tempAuthor);
			$tempAuthorEmail = $result["uemail"];
			$this->setAuthorEmail($tempAuthorEmail);
			$tempEmailUpdatesToAuthor = $result["emailupdates"];
			$this->setEmailUpdatesToAuthor($tempEmailUpdatesToAuthor);
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
		$this->setFollowups();
	}

	function setFollowups()
	{
		if($this->ID == 0)
		{
			PRINT "Error setting followup information in Tracking Class: ";
			PRINT "Tracking ID has not been set yet\n";
		}
		$fol = new Followup();
		$FollowupIDs = $fol->getByTrackingID($this->ID);
		for($i = 0; $i < sizeof($FollowupIDs); $i++)
		{
			$this->Followups[$i] = new Followup($FollowupIDs[$i]);
		}
	}

	function setDateEntered($DE)
	{
		$this->DateEntered = $DE;
	}

	function setCloseDate($CD)
	{
		$this->CloseDate = $CD;
	}

	function setStatus($Stat)
	{
		$this->Status = $Stat;
	}

	function setAssign($As)
	{
		$this->Assign = $As;
	}

	function setComputerID($CompID)
	{
		$this->ComputerID = $CompID;
	}

	function setWorkRequest($WR)
	{
		$this->WorkRequest = $WR;
	}

	function setPriority($Pri)
	{
		$this->Priority = $Pri;
	}

	function setIsGroup($IG)
	{
		$this->IsGroup = $IG;
	}

	function setAuthor($Auth)
	{
		$this->Author = $Auth;
	}

	function setAuthorEmail($AE)
	{
		$this->AuthorEmail = $AE;
	}

	function setEmailUpdatesToAuthor($EUTA)
	{
		$this->EmailUpdatesToAuthor = $EUTA;
	}

	function setID($Ident)
	{
		$this->ID = $Ident;
	}

	function getID()
	{
		return($this->ID);
	}

	function getDateEntered()
	{
		return($this->DateEntered);
	}

	function getCloseDate()
	{
		return($this->CloseDate);
	}

	function getStatus()
	{
		return($this->Status);
	}

	function getAssign()
	{
		return($this->Assign);
	}

	function getComputerID()
	{
		return($this->ComputerID);
	}

	function getWorkRequest()
	{
		return($this->WorkRequest);
	}

	function getPriority()
	{
		return($this->Priority);
	}

	function getIsGroup()
	{
		return($this->IsGroup);
	}

	function getAuthor()
	{
		return($this->Author);
	}

	function getAuthorEmail()
	{
		return($this->AuthorEmail);
	}

	function getEmailUpdatesToAuthor()
	{
		return($this->EmailUpdatesToAuthor);
	}

	function getNotClosed($Advanced, $Show, $Order, $username = "")
	{
		global $adb, $IRMName;
	
		if($username == "")
		{
			$username = $IRMName;
		}
		if($Advanced == "yes" && (($Show == "individual") || 
				($Show == "unassigned")))
		{
  		if($Show == "individual")
  		{
    		$query = "SELECT ID FROM tracking WHERE (status != 'old') and 
					(status != 'complete') and (assign = '$username') ORDER BY 
					date $Order";
  		} else if ($Show == "unassigned")
  		{
    		$query = "SELECT ID FROM tracking WHERE (status != 'old') and 
					(status != 'complete') and ((assign is null) or (assign = \"\"))
					ORDER BY date $Order";
  		}
		} else
		{
  		$query = "SELECT ID FROM tracking WHERE (status != 'old') and 
				(status != 'complete') ORDER BY date $Order";
		}
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			for($i = 0; $i < $numRows; $i++)
			{
				$result = $sth->fetchrow_hash();
  			$tempID[$i] = $result["ID"];
			}
			$sth->finish();
		} else
		{
  		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
		}
		return($tempID);
	}

	function getNotClosedBy($Order, $username = "")
	{
		global $adb, $IRMName;
	
		if($username == "")
		{
			$username = $IRMName;
		}
  	$query = "SELECT ID FROM tracking WHERE (status != 'old') and 
				(status != 'complete') and (author = '".$username."') ORDER 
				BY date $Order";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			for($i = 0; $i < $numRows; $i++)
			{
				$result = $sth->fetchrow_hash();
  			$tempID[$i] = $result["ID"];
			}
			$sth->finish();
		} else
		{
  		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
		}
		return($tempID);
	}

	function display($withFollowups = 0)
	{
		global $adb, $USERPREFIX, $IRMName, $cfg_userupdates;
		if($this->ID == 0)
		{
			PRINT "Error displaying Tracking:  ID is not set.<BR>\n";
		}

		if($this->DateEntered == 0)
		{
			PRINT "Error displaying Tracking: DateEntered is not set.<BR>\n";
		}

		if($this->Status == "")
		{
			PRINT "Error displaying Tracking: Status is not set.<BR>\n";
		}

		if($this->Author == "")
		{
			PRINT "Error displaying Tracking: Author is not set.<BR>\n";
		}

		if($this->ComputerID == 0)
		{
			PRINT "Error displaying Tracking: ComputerID is not set.<BR>\n";
		}

		if($this->WorkRequest == "")
		{
			PRINT "Error displaying Tracking: WorkRequest is not set.<BR>\n";
		}

		if($this->Priority == 0)
		{
			PRINT "Error displaying Tracking: Priority is not set.<BR>\n";
		}

		if($this->IsGroup == "")
		{
			PRINT "Error displaying Tracking: IsGroup is not set.<BR>\n";
		}

		if($this->AuthorEmail == "")
		{
			PRINT "Error displaying Tracking: AuthorEmail is not set.<BR>\n";
		}

		if($this->EmailUpdatesToAuthor == "")
		{
			PRINT "Error displaying Tracking: EmailUpdatesToAuthor is not set.<BR>\n";
		}

		$user = new User();
		$authExists = $user->exists($this->Author);
		if($authExists)
		{
			$user2 = new User($this->Author);
			$authorfullname = $user2->getFullname();
		} else
		{
			$authorfullname = $this->Author;
		}

		$assignExists = $user->exists($this->Assign);
		if($assignExists)
		{
			$user2 = new User($this->Assign);
			$assignfullname = $user2->getFullname();
		} else
		{
			$assignfullname = $this->Assign;
		}

		if($this->IsGroup == "yes")
		{
			$query = "SELECT name FROM groups WHERE (ID = $this->ComputerID)";
		} else
		{
			$query = "SELECT name FROM computers WHERE (ID = $this->ComputerID)";
		}

		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$result = $sth->fetchrow_hash();
			$computername = $result["name"];
		} else
		{
  		PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
		}

		PRINT "<TR BGCOLOR=#EEEEEE><TD><B>$this->ID</B></TD>\n";
		if($this->Status == "new")
		{
			PRINT "<TD><FONT COLOR=\"blue\"<B>NEW</B></FONT></TD>\n";
		} else if($this->Status == "wait")
		{
			PRINT "<TD><FONT COLOR=\"red\"<B>WAIT</B></FONT></TD>\n";
		} else if ($this->Status == "active")
		{
			PRINT "<TD><FONT COLOR=\"green\"<B>ACTIVE</B></FONT></TD>\n";
		} else if ($this->Status == "assigned")
		{
			PRINT "<TD><FONT COLOR=\"purple\"<B>ASSIGNED</B></FONT></TD>\n";
		} else if ($this->Status == "old")
		{
			PRINT "<TD><B>OLD</B></TD>";
		} else
		{
			PRINT "<TD><B>COMPLETE</B></TD>";
		}

		if (($this->Status != "old") && ($this->Status != "complete"))
		{
			list($year,$month,$day,$hour,$minute,$second) = split("([^0-9])", $this->DateEntered);
			$timestamp = mktime($hour,$minute,$second,$month,$day,$year);
			$dateopened = date("h:iA n/j/y", $timestamp);
	
			PRINT "<TD><FONT FACE=\"Arial, Helvetica\"><B>Opened: $dateopened</B></FONT></TD>";
		} else
		{
			list($year,$month,$day,$hour,$minute,$second) = split("([^0-9])", $this->DateEntered);
			$timestamp = mktime($hour,$minute,$second,$month,$day,$year);
			$dateopened = date("h:iA n/j/y", $timestamp);
			list($year,$month,$day,$hour,$minute,$second) = split("([^0-9])", $this->CloseDate);
			$timestamp = mktime($hour,$minute,$second,$month,$day,$year);
			$dateclosed = date("h:iA n/j/y", $timestamp);
			PRINT "<TD><FONT FACE=\"Arial, Helvetica\"><B>Opened: $dateopened <BR>Closed: $dateclosed</B></FONT></TD>";
		}

		$priorityname = namepriority($this->Priority);
		PRINT "<TD><FONT FACE=\"Arial, Helvetica\"><B>$priorityname</B></FONT></TD>";
		PRINT "<TD><FONT FACE=\"Arial, Helvetica\"><B>";
		if($authExists)
		{
			PRINT "<A HREF=\"$USERPREFIX/users-info.php?ID=$this->Author\">\n";
		}
		PRINT "$authorfullname";
		if($authExists)
		{
			PRINT "</A>";
		}

		if(($cfg_userupdates == 1) && ($this->EmailUpdatesToAuthor == "yes"))
		{
			PRINT "(U)";
		}

		PRINT "</B></FONT></TD>";

		if($this->Assign == "")
		{
			PRINT "<TD>[Nobody]</TD>";
		} else
		{
      PRINT "<TD><B>\n";
      if($assignExists)
      {
        PRINT "<A HREF=\"$USERPREFIX/users-info.php?ID=$this->Assign\">\n";
      }
      PRINT "$assignfullname";
      if($assignExists)
      {
        PRINT "</B></TD>";
      }
		}

		PRINT "<TD><FONT FACE=\"Arial, Helvetica\">";
		if($this->IsGroup != "yes")
		{
		PRINT "<A HREF=\"$USERPREFIX/computers-info.php?ID=$this->ComputerID\">";
		}
		PRINT "<B>$computername ($this->ComputerID)</B>";
		if($this->IsGroup != "yes")
		{
			PRINT "</A>\n";
		}
		PRINT "</FONT></TD>";
		PRINT "<TD WIDTH=\"70%\"><FONT face=\"Arial, Helvetica\">";
		$numFollowups = sizeof($this->Followups);
		if(($withFollowups == 1) && ($numFollowups > 0))
		{
			PRINT "<TABLE BORDER=0 WIDTH=\"100%\">\n";
			PRINT "<TR><TD>\n";
		}	
		$text = nl2br($this->WorkRequest);
    PRINT "<B>$text</B></FONT></TD>";
		if(($withFollowups == 1) && ($numFollowups > 0))
		{
			PRINT "</TR>\n";
			PRINT "<TR><TD>";
			Followup::displayHeader();
			for($i=0; $i < $numFollowups; $i++)
			{
				$this->Followups[$i]->display();
			}
			Followup::displayFooter();
			PRINT "</TD></TR></TABLE></TD>\n";
		}


		PRINT "<TD><A HREF=\"$USERPREFIX/tracking-followups.php?ID=$this->ID\">";
		PRINT "More Info</A> ($numFollowups) <BR>";
		PRINT "<A HREF=\"$USERPREFIX/tracking-assign-form.php?ID=$this->ID\">";
		PRINT "Assign</A></TD>";
    PRINT "</TR>";
	}
	
	function displayDetail()
	{
		global $adb, $USERPREFIX;
		PRINT "<TABLE BORDER=1 WIDTH=100%><TR><TH COLSPAN=2>Job Number ";
		PRINT "$this->ID</TH></TR>";
		PRINT "<TR BGCOLOR=#DDDDDD><TD WIDTH=50%><B>Status:</B><BR>";
		PRINT "<SELECT NAME=status SIZE=1>";
		PRINT "<OPTION VALUE=\"active\"";
		if($this->Status == "active")
		{
			PRINT " selected";
		}
		PRINT ">Active</OPTION>";
		PRINT "<OPTION VALUE=\"assigned\"";
		if($this->Status == "assigned")
		{
			PRINT " selected";
		}
		PRINT ">Assigned</OPTION>";
		PRINT "<OPTION VALUE=\"complete\"";
		if($this->Status == "complete")
		{
			PRINT " selected";
		}
		PRINT ">Complete</OPTION>";
		PRINT "<OPTION VALUE=\"new\"";
		if($this->Status == "new")
		{
			PRINT " selected";
		}
		PRINT ">New</OPTION>";
		PRINT "<OPTION VALUE=\"old\"";
		if($this->Status == "old")
		{
			PRINT " selected";
		}
		PRINT ">Old</OPTION>";
		PRINT "<OPTION VALUE=\"wait\"";
		if($this->Status == "wait")
		{
			PRINT " selected";
		}
		PRINT ">Wait</OPTION>";
		PRINT "</SELECT>";
		list($year,$month,$day,$hour,$minute,$second) = split("([^0-9])", $this->DateEntered);
		$timestamp = mktime($hour,$minute,$second,$month,$day,$year);
		$dateopened = date("h:iA - F j, Y", $timestamp);

		PRINT "</td><td><B>Date Opened:</B><br>$dateopened<BR>";
		if(($this->CloseDate != "0000-00-00 00:00:00") && ($this->CloseDate != ""))
		{
			PRINT "<BR><B>Date Closed:</B><br>";
// CHECK HERE FOR MORE CORRECT WAY TO DO THIS!!!!!
			$query = "SELECT SEC_TO_TIME(UNIX_TIMESTAMP('$this->CloseDate') - UNIX_TIMESTAMP('$this->DateEntered'))";
			$sth = $adb->prepare($query);
			if($sth)
			{
				$res = $sth->execute();
				$result = $sth->fetchrow_array();
				$opentime = $result[0]; # There has got to be a better way...
				$sth->finish();
			} else
			{
				PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
			}
			PRINT "$this->CloseDate<br>This job was open for: $opentime";
		}
		PRINT "</td></tr>";

		$user = new User();
		$authExists = $user->exists($this->Author);
		if($authExists)
		{
			$user2 = new User($this->Author);
			$fullname = $user2->getFullname();
		} else
		{
			$fullname = $this->Author;
		}

		if($this->IsGroup == "yes")
		{
			$query = "select * from groups where (ID=$this->ComputerID)";
		} else
		{
			$query = "select * from computers where (ID=$this->ComputerID)";
		}
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$result = $sth->fetchrow_hash();
			$computername = $result["name"];
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
		}

		$priorityname = namepriority($this->Priority);
		PRINT "<tr bgcolor=#DDDDDD><td><B>Priority:</B><br>$priorityname</td>";
		PRINT "<td><B>Author:</B><br><a href=\"$USERPREFIX/users-info.php?";
		PRINT "ID=$this->Author\">$fullname</a></td></tr>";
		PRINT "<tr bgcolor=#DDDDDD><td><B>\n";
		if($this->IsGroup != "yes")
		{
			PRINT "Computer:";
		} else
		{
			PRINT "Group:";
		}
		PRINT "</B><br>";
		if($this->IsGroup != "yes")
		{
			PRINT "<a href=\"$USERPREFIX/computers-info.php?ID=$this->ComputerID\">";
		}
			PRINT "$computername ($this->ComputerID)";
		if($this->IsGroup != "yes")
		{
			PRINT "</a>";
		}
		PRINT "</td><td><B>Assigned to:</B><br>";

		Tech_list($this->Assign, "user");

		PRINT "</td></tr>";
		PRINT "<tr bgcolor=#DDDDDD><td colspan=2><B>Problem Description:</B><br>";
		$text = nl2br($this->WorkRequest);
		PRINT "$text</td></tr>";
		PRINT "</table>";
		$numFollowups = sizeof($this->Followups);
		Followup::displayHeader();
		if($numFollowups > 0)
		{
			for($i=0; $i < $numFollowups; $i++)
			{
				$this->Followups[$i]->display();
			}
		} else
		{
			PRINT "<TR><TD COLSPAN=3>No Followups on this request</TD></TR>\n";
		}
		Followup::displayAddForm();
		Followup::displayFooter();
	}
	
	function displayHeader()
	{
		PRINT "<CENTER><TABLE BORDER=1 WIDTH=\"100%\">";
		PRINT "<TR BGCOLOR=#DDDDDD><TH>ID</TH><TH>Status</TH><TH>Date</TH>";
    PRINT "<TH WIDTH=5>Pri</TH><TH>Author</TH><TH>Assigned</TH>";
    PRINT "<TH>Computer</TH><TH COLSPAN=2 WIDTH=70%>Description</TH></TR>";
	}

	function displayFooter()
	{
		PRINT "</TABLE></CENTER>";
	}

	function search($field, $information)
	{
		global $adb;
		$query = "SELECT * FROM tracking WHERE ($field LIKE \"%$information%\") ORDER BY date DESC";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			for( $i=0; $i < $numRows; $i++)
			{
				$result = $sth->fetchrow_hash();
				$tempIDs[$i] = $result["ID"];
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<br>\n";
		}
		return($tempIDs);
	}

	function commit()
	{
		global $adb, $cfg_notifyassignedbyemail, $IRMName, $cfg_userupdates;
		if($this->ID == 0)
		{
			PRINT "Error committing Work Request. ID has not been set. Use \"add()\"";
			PRINT " to add new Work Requests and \"commit\" to commit changes to ";
			PRINT "Work Requests<BR>\n";
			return (0);
		}
		if($this->DateEntered == "")
		{
			PRINT "Error committing Work Request.  DateEntered has not been set.<BR>\n";
			return (0);
		}
		if($this->Status == "")
		{
			PRINT "Error committing Work Request.  Status has not been set.<BR>\n";
			return (0);
		}
		if($this->ComputerID == 0)
		{
			PRINT "Error committing Work Request.  ComputerID has not been set.<BR>\n";
			return (0);
		}
		if($this->WorkRequest == "")
		{
			PRINT "Error committing Work Request.  WorkRequest has not been set.<BR>\n";
			return (0);
		}
		if($this->Priority == 0)
		{
			PRINT "Error committing Work Request.  Priority has not been set.<BR>\n";
			return (0);
		}
		if($this->IsGroup == "")
		{
			PRINT "Error committing Work Request.  IsGroup has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->Author))
		{
			PRINT "Error committing Work Request.  Author has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->AuthorEmail))
		{
			return (0);
			PRINT "Error committing Work Request.  AuthorEmail has not been set.<BR>\n";
			return (0);
		}
		if($this->EmailUpdatesToAuthor == "") 
		{
			PRINT "Error committing Work Request.  EmailUpdatesToAuthor has not been set.<BR>\n";
			return (0);
		}

		if(($this->Status == "complete") || ($this->Status == "old"))
		{
			$tempCloseDate = date("Y-m-d H:i:s");
			$this->setCloseDate($tempCloseDate);
		}

		$slashWorkRequest = addslashes($this->WorkRequest);
		$query = "REPLACE tracking set ID='$this->ID', date='$this->DateEntered', closedate='$this->CloseDate', status='$this->Status', assign='$this->Assign', computer='$this->ComputerID', contents='$slashWorkRequest', priority='$this->Priority', is_group='$this->IsGroup', author='$this->Author', uemail='$this->AuthorEmail', emailupdates='$this->EmailUpdatesToAuthor'";
		$res = $adb->dbh_do($query);
	
		$numFollowups = sizeof($this->Followups);
		for($i=0;$i<$numFollowups;$i++)
		{
			$tempVal = $this->Followups[$i]->getID();
			if($tempVal > 0)
			{
				$this->Followups[$i]->commit();
			} else
			{
				$this->Followups[$i]->setTrackingID($this->ID);
				$this->Followups[$i]->add();
			}
		}	
	
		$this->sendEmail("yes");	
	}
	
	function sendEmail($mod="no")
	{
		global $cfg_notifyassignedbyemail, $cfg_userupdates, $IRMName, $cfg_newtrackingemail, $cfg_notifynewtrackingbyemail;

		// If we are notifying, via email, people that get work requests assigned 
		// to them, or we are updating, via email, users who originally entered
		// the work requests, or we are notifying, via email, someone that a new
		// request has been entered, enter this if statement.
		if(($cfg_notifyassignedbyemail == 1) || ($cfg_userupdates == 1) ||
			($cfg_notifynewtrackingbyemail == 1))
		{
			// Get all the email addresses we need
			if($cfg_notifyassignedbyemail == 1)
			{
				$assignUser = new User($this->Assign);
				$assignEmail = $assignUser->getEmail();
			}
			if(($cfg_userupdates == 1) && ($this->EmailUpdatesToAuthor == "yes"))
			{
				$authorUser = new User($this->Author);
				$authorEmail = $authorUser->getEmail();
				//PRINT "authorEmail: $authorEmail<BR>\n";
			}
			if($cfg_notifynewtrackingbyemail == 1)
			{
				$newTrackingEmail = $cfg_newtrackingemail;
			}
			$currentUser = new User($IRMName);
			$currentEmail = $currentUser->getEmail();
			$priorityname = namepriority($this->Priority);
			$body = "Tracking job information:\n";
			$body = $body . "Tracking ID: $this->ID\n";
			$body = $body . "Status: $this->Status\n";
			$body = $body . "Priority: $priorityname\n\n";
			$body = $body . "Work Request:\n $this->WorkRequest\n\n";
			$numFollowups = sizeof($this->Followups);
			if($numFollowups == 0)
			{
				$body = $body . "No Followups have been added.\n";
			} else
			{
				$body = $body . "Followups:\n";
				for($i = 0; $i < $numFollowups; $i++)
				{
					$this->Followups[$i]->addBody($body);
				}
			}

			if($mod == "no")
			{
				$subject = "IRM: New Job $this->ID has been added to the work request system.";
				if(($cfg_userupdates == 1) && ($this->EmailUpdatesToAuthor == "yes"))
				{
					// new work request email to user here
				//	PRINT "In new send email to user<BR>\n";
						mail("$authorEmail", "$subject", "$body", "From: $newTrackingEmail\n");
				}
				if(($this->Status != "old") && ($this->Status != "complete"))
				{
					if($cfg_notifynewtrackingbyemail == 1)
					{
						// new work request email to newtrackingemail here
						mail("$newTrackingEmail", "$subject", "$body", "From: $authorEmail\n");
					}
				}
			} else
			{
				$subject = "IRM: Job $this->ID has been modified by $IRMName";
				if(($cfg_userupdates == 1) && ($this->EmailUpdatesToAuthor == "yes") && 
					($this->Author != $IRMName))
				{
					PRINT "In modify send email to user<BR>\n";
					// update work request email to user
					mail("$authorEmail", "$subject", "$body", "From: $currentEmail\n");
				}
				if(($cfg_notifyassignedbyemail == 1) && ($this->Assign != $IRMName))
				{
					// update work request email to assigned user if the assigned user
					// is not the current user.
					mail("$assignEmail", "$subject", "$body", "From: $currentEmail\n");
				}
			}
		}
	}

	function add()
	{
		global $adb;
		if(isset($this->ID))
		{
			PRINT "Error committing Work Request. ID has not been set. Use \"add()\"";
			PRINT " to add new Followups and \"commit\" to commit changes to ";
			PRINT "Followups<BR>\n";
		}
		if(!isset($this->DateEntered))
		{
			PRINT "Error committing Work Request.  DateEntered has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->Status))
		{
			PRINT "Error committing Work Request.  Status has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->ComputerID))
		{
			PRINT "Error committing Work Request.  ComputerID has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->WorkRequest))
		{
			PRINT "Error committing Work Request.  WorkRequest has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->Priority))
		{
			PRINT "Error committing Work Request.  Priority has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->IsGroup))
		{
			PRINT "Error committing Work Request.  IsGroup has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->Author))
		{
			PRINT "Error committing Work Request.  Author has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->AuthorEmail))
		{
			PRINT "Error committing Work Request.  AuthorEmail has not been set.<BR>\n";
			return (0);
		}
		if(!isset($this->EmailUpdatesToAuthor))
		{
			PRINT "Error committing Work Request.  EmailUpdatesToAuthor has not been set.<BR>\n";
			return (0);
		}

		$slashWorkRequest = addslashes($this->WorkRequest);

		$query = "INSERT INTO tracking VALUES (NULL, '$this->DateEntered', '$this->CloseDate', '$this->Status', '$this->Author', '$this->Assign', '$this->ComputerID', '$slashWorkRequest', '$this->Priority', '$this->IsGroup', '$this->AuthorEmail', '$this->EmailUpdatesToAuthor')";

		$res = $adb->dbh_do($query);
		$theID = $adb->insert_id();
		$this->setID($theID);

		$numFollowups = sizeof($this->Followups);
		for($i=0;$i<$numFollowups;$i++)
		{
			$this->Followups[$i]->setTrackingID($this->ID);
			$this->Followups[$i]->add();
		}

		$this->sendEmail();
	}

	function addFollowup($newFollowup)
	{
		$this->newFollowups = 1;
		$numFollowups = sizeof($this->Followups);
		$this->Followups[$numFollowups] = $newFollowup;
	}

	function getFollowupsInfo()
	{
		$numFollowups = sizeof($this->Followups);
		$returnVal = "";
		for($i=0; $i<$numFollowups; $i++)
		{	
			$returnVal = $returnVal . $this->Followups[$i]->getFollowupInfo();
		}
		return($returnVal);
	}

	function delete()
	{
		global $adb;
		$numFollowups = sizeof($this->Followups);
		for($i=0;$i<$numFollowups;$i++)
		{
			$this->Followups[$i]->delete();
		}
		$query = "DELETE FROM tracking WHERE (ID = '$this->ID')";
		$count=$adb->dbh_do($query);
	}

	function getByComputerID($cID)
	{
		global $adb;
		$query = "SELECT * FROM tracking WHERE (computer = \"$cID\") and (is_group != \"yes\")";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			for($i=0;$i<$numRows;$i++)
			{
				$result = $sth->fetchrow_hash();
				$trackIDs[$i] = $result["ID"];
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
		return($trackIDs);	
	}

	function getByGroupID($gID)
	{
		global $adb;
		$query = "SELECT * FROM tracking WHERE (computer = \"$gID\") and (is_group = \"yes\")";
		$sth = $abd->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			for($i=0;$i<$numRows;$i++)
			{
				$result = $sth->fetchrow_hash();
				$trackIDs[$i] = $result["ID"];
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
		return($trackIDs);	
	}

	function isStatus($status)
	{
		if($this->Status == $status)
		{
			return(TRUE);
		} else
		{
			return(FALSE);
		}
	}

	function isAssign($assign)
	{
		if($this->Assign == $assign)
		{
			return(TRUE);
		} else
		{
			return(FALSE);
		}
	}
}

class Configuration
{
	var $notifyassignedbyemail;
	var $notifynewtrackingbyemail;
	var $newtrackingemail;
	var $groups;
	var $usenamesearch;
	var $userupdates;
	var $sendexpire;
	var $showjobsonlogin;
	var $minloglevel;
	var $logo;
	var $snmp;
	var $snmp_rcommunity;
	var $snmp_ping;
	var $knowledgebase;
	var $fasttrack;
	var $version;
	var $build;

	function Configuration()
	{
	}
}

include("$root_path/include/user.db.inc.php");

class User
{

	var $driver; # the user driver - not used, didn't work, thrown away, see XIRM :)
	var $udata; # user data

	# Preferences Variables
	var $DisplayComputerType;
	var $DisplayOperatingSystem;
	var $DisplayOperatingSystemVersion;
	var $DisplayProcessor;
	var $DisplayProcessorSpeed;
	var $DisplayLocation;
	var $DisplaySerial;
	var $DisplayOtherSerial;
	var $DisplayRamType;
	var $DisplayRam;
	var $DisplayNetwork;
	var $DisplayIP;
	var $DisplayMachineAddress;
	var $DisplayHardDriveSize;
	var $DisplayContact;
	var $DisplayContactNumber;
	var $DisplayComments;
	var $DisplayDateMod;
	var $AdvancedTracking;
	var $TrackingOrder;

# maybe move the above to a hash?

	function User($name = "")
	{

		#$this->driver = new UserDriver();

		#if (!isSet($this->driver)) 
		#{
		#	print "We had a booboo, I couldn't load the UserDriver class!";
		#	exit();
		#}

		if($name != "")
		{
			$this->setName($name);
			$this->retrieve();
		}
	}
	
	function authenticate($u, $p) 
	{
		global $adb, $AUTHSOURCE, $cfg_ldapserver, $cfg_serverroot, $cfg_ldapserver;

		# TODO: MD5 Password hashes, encryption

		if($AUTHSOURCE == "DB")
		{
			$q = $adb->prepare("SELECT name,password FROM users WHERE name = '$u'");
			$q->execute();
			$r = $q->fetchrow_hash();
			if ($r[name] == $u && $r[password] == $p) 
			{
				return(0);
			} else 
			{
				return(1); # error!
			}
	
			#return $this->driver->authenticate($name, $password);
		} else if ($AUTHSOURCE == "LDAP")
		{
			if(!($u) || !($p))
			{
				PRINT "Sorry, you must enter a username and a password.<BR>\n";
				return(1);
			}

			// Generate a DN from a uid
			$dn = "uid=$u, " . $cfg_serverroot;

			// Connect to ldap server
			$dsCon = ldap_connect($cfg_ldapserver);

			// Make sure we connected
			if (!($dsCon))
			{
				PRINT "Sorry, cannot contact LDAP server\n";
				return(1);
			}
			
			// Attempt to bind, if it works, the password is acceptable
			$bind = ldap_bind($dsCon, $dn, $p);

			if(!($bind))
			{
				PRINT "Sorry, your username/password were not accepted.<BR>\n";
				PRINT "Hit the \"back\" button on your browser, and try again.<BR>\n";
				return(1);
			}

			// If we got here, the username/password worked.


			ldap_close($dsCon);

			// If LDAP user does not exist in mysql database, create it.
			$this->ldapAddUser($u);
			return (0);
		} else
		{
			PRINT "Error: No proper authorization source entered in config.inc.php";
		}
	}

	function ldapAddUser($u)
	{
		global $cfg_ldapfullname, $cfg_ldapemail, $cfg_ldapserver, $cfg_serverroot, $cfg_ldaplocation, $cfg_ldapphone;
		if(!($this->exists($u)))
		{
			// Before this will work, we need to have the Full Name.
			// We should also need to set the email address in most cases.

			// Generate a DN from a uid
			$dn = "uid=$u, $cfg_serverroot";

			// Connect to ldap server
			$dsCon = ldap_connect($cfg_ldapserver);

			// Make sure we connected
			if (!($dsCon))
			{
				PRINT "Sorry, cannot contact LDAP server\n";
				exit;
			}

			$bind = ldap_bind($dsCon);
			if(!($bind))
			{
				PRINT "Sorry, could not do an anonymous bind to your ldap server.<BR>\n";
				exit;
			}

			$pieces[0] = $cfg_ldapemail;
			$pieces[1] = $cfg_ldapfullname;
			$pieces[2] = $cfg_ldapphone;
			$pieces[3] = $cfg_ldaplocation;
			$searchResult = ldap_search($dsCon, $cfg_serverroot, "uid=".$u, $pieces);
			$info = ldap_get_entries($dsCon, $searchResult);

			$fullname = $info[0][$cfg_ldapfullname][0];
			$email = $info[0][$cfg_ldapemail][0];
			$officephone = $info[0][$cfg_ldapphone][0];
			$officelocation = $info[0][$cfg_ldaplocation][0];
			$this->setEmail($email);
			$this->setFullname($fullname);
			$this->setLocation($officelocation);
			$this->setPhone($officephone);
			$this->setType("normal");
			$this->add(true);
		}
	}

	function retrieve()
	{
		global $adb;	

		$query = "SELECT fullname,email,location,phone,type,comments FROM users WHERE (name = '".$this->udata[Name]."')";
		$sth = $adb->prepare($query);
		$res = $sth->execute();
		$result = $sth->fetchrow_hash();

		$this->udata[Fullname] = $result["fullname"];
		$this->udata[Email] = $result["email"];
		$this->udata[Location] = $result["location"];
		$this->udata[Phone] = $result["phone"];
		$this->udata[Type] = $result["type"];
		$this->udata[Comments] = $result["comments"];

		$query = "SELECT * FROM prefs WHERE (user = \"".$this->udata[Name]."\")";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRowstemp = $sth->rows();
			$result = $sth->fetchrow_hash();
			$this->setDisplayComputerType($result["type"]);
			$this->setDisplayOperatingSystem($result["os"]);
			$this->setDisplayOperatingSystemVersion($result["osver"]);
			$this->setDisplayProcessor($result["processor"]);
			$this->setDisplayProcessorSpeed($result["processor_speed"]);
			$this->setDisplayLocation($result["location"]);
			$this->setDisplaySerial($result["serial"]);
			$this->setDisplayOtherSerial($result["otherserial"]);
			$this->setDisplayRamType($result["ramtype"]);
			$this->setDisplayRam($result["ram"]);
			$this->setDisplayNetwork($result["network"]);
			$this->setDisplayIP($result["ip"]);
			$this->setDisplayMachineAddress($result["mac"]);
			$this->setDisplayHardDriveSize($result["hdspace"]);
			$this->setDisplayContact($result["contact"]);
			$this->setDisplayContactNumber($result["contact_num"]);
			$this->setDisplayComments($result["comments"]);
			$this->setDisplayDateMod($result["date_mod"]);
			$this->setAdvancedTracking($result["advanced_tracking"]);
			$this->setTrackingOrder($result["tracking_order"]);
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
	}

	function add($isLDAP = false)
	{
		global $adb;
		if($this->udata[Name] == "")
		{
			PRINT "Error adding user: username not set<BR>\n";
		}
		if($this->udata[Password] == "" && ($isLDAP == false))
		{
			PRINT "Error adding user: password not set<BR>\n";
		}
		if($this->udata[Fullname] == "")
		{
			PRINT "Error adding user: password not set<BR>\n";
		}
		if($this->udata[Type] == "")
		{
			PRINT "Error adding user: type not set<BR>\n";
		}

		$query = "INSERT INTO users VALUES ('".$this->udata[Name]."', '".$this->udata[Password]."', '".$this->udata[Fullname]."', '".$this->udata[Email]."', '".$this->udata[Location]."', '".$this->udata[Phone]."', '".$this->udata[Type]."', '".$this->udata[Comments]."')";
		$adb->dbh_do($query);
		$this->initPrefs();
	}

	function initPrefs()
	{
		global $adb;
		$query = "SELECT * FROM prefs WHERE (user = '".$this->udata[Name]."')";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			if ($numRows == 0)
			{
				$query = "INSERT INTO prefs VALUES ('".$this->udata[Name]."', 'yes',";
				$query = $query." 'no','no', 'no', no', 'no', 'no', 'no', 'no', 'no',";
				$query = $query." 'no', 'no', no', 'no', 'no', 'no', 'no', 'no',";
				$query = $query." 'yes', 'no')"; 
				$adb->dbh_do($query);
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
	}

	function delete()
	{
		global $adb;
		if($this->udata[Name] == "")
		{
			PRINT "Error deleting user: name not set<BR>\n";
		}

		$query = "DELETE FROM users WHERE (name = \"".$this->udata[Name]."\")";
		$adb->dbh_do($query);

		$query = "DELETE FROM prefs WHERE (user = \"".$this->udata[Name]."\")";
	}

	function commit()
	{
		global $adb;
		if($this->udata[Name] == "")
		{
			PRINT "Error updating user: name not set<BR>\n";
			return (0);
		}
		$query = "REPLACE users VALUES('".$this->udata[Name]."', '".$this->udata[Password]."', '".$this->udata[Fullname]."', '".$this->udata[Email]."', '".$this->udata[Location]."', '".$this->udata[Phone]."','".$this->udata[Type]."', '".$this->udata[Comments]."')";
		$adb->dbh_do($query);




	//PRINT "Name: ".$this->udata[Name]."<BR>\n";
	//PRINT "DisplayComputerType: $this->DisplayComputerType<BR>\n";
	//PRINT "DisplayOperatingSystem: $this->DisplayOperatingSystem<BR>\n";
	//PRINT "DisplayOperatingSystemVersion: $this->DisplayOperatingSystemVersion<BR>\n";
	//PRINT "DisplayProcessor: $this->DisplayProcessor<BR>\n";
	//PRINT "DisplayProcessorSpeed: $this->DisplayProcessorSpeed<BR>\n";
	//PRINT "DisplayLocation: $this->DisplayLocation<BR>\n";
	//PRINT "DisplaySerial: $this->DisplaySerial<BR>\n";
	//PRINT "DisplayOtherSerial: $this->DisplayOtherSerial<BR>\n";
	//PRINT "DisplayRamType: $this->DisplayRamType<BR>\n";
	//PRINT "DisplayRam: $this->DisplayRam<BR>\n";
	//PRINT "DisplayNetwork: $this->DisplayNetwork<BR>\n";
	//PRINT "DisplayIP: $this->DisplayIP<BR>\n";
	//PRINT "DisplayMachineAddress: $this->DisplayMachineAddress<BR>\n";
	//PRINT "DisplayHardDriveSize: $this->DisplayHardDriveSize<BR>\n";
	//PRINT "DisplayContact: $this->DisplayContact<BR>\n";
	//PRINT "DisplayContactNumber: $this->DisplayContactNumber<BR>\n";
	//PRINT "DisplayComments: $this->DisplayComments<BR>\n";
	//PRINT "DisplayDateMod: $this->DisplayDateMod<BR>\n";
	//PRINT "AdvancedTracking: $this->AdvancedTracking<BR>\n";
	//PRINT "TrackingOrder: $this->TrackingOrder<BR>\n";


		$query = "REPLACE prefs VALUES('".$this->udata[Name]."', 
			'".$this->DisplayComputerType."', '".$this->DisplayOperatingSystem."',
			'".$this->DisplayOperatingSystemVersion."',
			'".$this->DisplayProcessor."', '".$this->DisplayProcessorSpeed."',
			'".$this->DisplayLocation."', '".$this->DisplaySerial."',
			'".$this->DisplayOtherSerial."', '".$this->DisplayRamType."',
			'".$this->DisplayRam."', '".$this->DisplayNetwork."', 
			'".$this->DisplayIP."', '".$this->DisplayMachineAddress."', 
			'".$this->DisplayHardDriveSize."',
			'".$this->DisplayContact."', '".$this->DisplayContactNumber."',
			'".$this->DisplayComments."', '".$this->DisplayDateMod."', 
			'".$this->AdvancedTracking."', '".$this->TrackingOrder."')";
		$adb->dbh_do($query);
	}

	function getName()
	{
		return($this->udata[Name]);
	}

	function getPassword()
	{
		return($this->udata[Password]);
		# this doesn't make sense anymore
	}

	function getFullname()
	{
		return($this->udata[Fullname]);
	}

	function getEmail()
	{

		return($this->udata[Email]);
	}

	function getLocation()
	{
		return($this->udata[Location]);
	}

	function getPhone()
	{
		return($this->udata[Phone]);
	}

	function getType()
	{
		#print "Type: -".$this->udata["Type"]."-";
		return($this->udata[Type]);
	}

	function getComments()
	{
		return($this->udata[Comments]);
	}

	function setName($name)
	{
		$this->udata[Name] = $name;
	}

	function setPassword($pass)
	{	
		$this->udata[Password] = $pass;
	}

	function setFullname($fname)
	{
		$this->udata[Fullname] = $fname;
	}

	function setEmail($email)
	{
		$this->udata[Email] = $email;
	}

	function setLocation($loc)
	{
		$this->udata[Location] = $loc;
	}

	function setPhone($phone)
	{
		$this->udata[Phone] = $phone;
	}

	function setType($type)
	{
		$this->udata[Type] = $type;
	}

	function setComments($comment)
	{
		$this->udata[Comments] = $comment;
	}

	function displayHeader()
	{
		PRINT "<TABLE WIDTH=\"100%\" BORDER=1 NOSHADE>\n";
		PRINT "<TR><TH><STRONG>Users</STRONG></TH></TR>\n";
	}

	function displayFooter()
	{
		PRINT "</TABLE>\n";
	}

	function display()
	{
		global $USERPREFIX;
		PRINT "<TR BGCOLOR=\"#DDDDDD\">\n";
		PRINT "<TD>";
		if($this->udata[Name] == "")
		{
			PRINT "Error displaying user: Name not set<BR>\n";
		}
		$username_enc = str_replace(" ","%20", $this->udata[Name]);
		PRINT $this->udata['Name']." (".$this->udata['Fullname'].")";
		PRINT " <A HREF=\"$USERPREFIX/setup-user-update.php?username=$username_enc&update=edit\">";
		PRINT "[edit]</A>";
    PRINT "<A HREF=\"$USERPREFIX/setup-user-update.php?update=delete&username=$username_enc\">";
    PRINT " [delete]</A>";
    PRINT "</TD>\n";
    PRINT "</TR>\n";
	}

	function displayLong()
	{
		$uExists = $this->exists($this->udata[Name]);
		if(!$uExists)
		{
			PRINT "User \"".$this->udata[Name]."\" is no longer a registered user on this system<BR>\n";
			return(0);
		}
		PRINT "<table width=100% border=1 noshade bordercolor=#000000>\n";
		PRINT "<tr bgcolor=#CCCCCC><td colspan=2><strong>".$this->udata[Name]."</strong>\n";
		PRINT "</td></tr>\n";
		PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">Name:\n";
		PRINT "<br> ".$this->udata[Fullname]." </font></td><td><font face=\"arial,\n";
		PRINT "helvetica\">&nbsp;</td></tr>";
		PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">E-mail:\n";
		PRINT "<br>".$this->udata[Email]." </font></td><td><font face=\"arial, helvetica\">Phone:<br>\n";
		PRINT "".$this->udata[Phone]." </td></tr>";
		PRINT "<tr bgcolor=#DDDDDD><td><font face=\"arial, helvetica\">Location:\n";
		PRINT "<br> ".$this->udata[Location]."</font></td><td><font face=\"arial,\n";
		PRINT "helvetica\">User Type:<br>\n";
		PRINT "".$this->udata[Type]."</td></tr>";
		PRINT "</table><br>";
	}

	function displayAllUsers()
	{
		global $adb;
		User::displayHeader();
		$query = "SELECT name FROM users ORDER BY name ASC";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();

			while($result = $sth->fetchrow_hash())
			{
				
				$name = $result["name"];

				$user = new User($name);
				$user->display();
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
		User::displayFooter();
	}

	function exists($name)
	{
		global $adb;
		$query = "SELECT * FROM users WHERE (name='$name')";
		$sth = $adb->prepare($query);
		if($sth)
		{
			$res = $sth->execute();
			$numRows = $sth->rows();
			if($numRows > 0)
			{
				return(TRUE);
			} else
			{
				return(FALSE);
			}
		} else
		{
			PRINT "Could not prepare query: ".$sth->errstr."<BR>\n";
		}
	}

	function permissionCheck($priv)
	{


		if($priv == "admin")
		{
			if($this->udata[Type] == "admin")
			{
				return(TRUE);
			} else
			{
				return(FALSE);
			}
		} else if($priv == "tech")
		{
			if(($this->udata[Type] == "admin") || ($this->udata[Type] == "tech"))
			{

				return(TRUE);

			} else
			{
				return(FALSE);
			}
		} else if($priv == "normal")
		{
			if(($this->udata[Type] == "admin") || ($this->udata[Type] == "tech") || ($this->udata[Type] == "normal"))
			{
				return(TRUE);
			} else
			{
				return(FALSE);
			}
		} else if($priv == "post-only")
		{
			if(($this->udata[Type] == "admin") || ($this->udata[Type] == "tech") || ($this->udata[Type] == "normal") || ($this->udata[Type] == "post-only"))
			{
				return(TRUE);
			} else
			{
				return(FALSE);
			}
		} else
		{
			return(FALSE);
		}
	}

	function getDisplayComputerType()
	{
		return($this->DisplayComputerType);
	}

	function setDisplayComputerType($dct)
	{
		$this->DisplayComputerType = $dct;
	}

	function getDisplayOperatingSystem()
	{
		return($this->DisplayOperatingSystem);
	}

	function setDisplayOperatingSystem($dos)
	{
		$this->DisplayOperatingSystem = $dos;
	}

	function getDisplayOperatingSystemVersion()
	{
		return($this->DisplayOperatingSystemVersion);
	}

	function setDisplayOperatingSystemVersion($dosv)
	{
		$this->DisplayOperatingSystemVersion = $dosv;
	}

	function getDisplayProcessor()
	{
		return($this->DisplayProcessor);
	}

	function setDisplayProcessor($dp)
	{
		$this->DisplayProcessor = $dp;
	}

	function getDisplayProcessorSpeed()
	{
		return($this->DisplayProcessorSpeed);
	}

	function setDisplayProcessorSpeed($dps)
	{
		$this->DisplayProcessorSpeed = $dps;
	}

	function getDisplayLocation()
	{
		return($this->DisplayLocation);
	}

	function setDisplayLocation($dl)
	{
		$this->DisplayLocation = $dl;
	}

	function getDisplaySerial()
	{
		return($this->DisplaySerial);
	}

	function setDisplaySerial($ds)
	{
		$this->DisplaySerial = $ds;
	}

	function getDisplayOtherSerial()
	{
		return($this->DisplayOtherSerial);
	}

	function setDisplayOtherSerial($dos)
	{
		$this->DisplayOtherSerial = $dos;
	}

	function getDisplayRamType()
	{
		return($this->DisplayRamType);
	}

	function setDisplayRamType($drt)
	{
		$this->DisplayRamType = $drt;
	}

	function getDisplayRam()
	{
		return($this->DisplayRam);
	}

	function setDisplayRam($dr)
	{
		$this->DisplayRam = $dr;
	}

	function getDisplayNetwork()
	{
		return($this->DisplayNetwork);
	}

	function setDisplayNetwork($dn)
	{
		$this->DisplayNetwork = $dn;
	}

	function getDisplayIP()
	{
		return($this->DisplayIP);
	}

	function setDisplayIP($dip)
	{
		$this->DisplayIP = $dip;
	}

	function getDisplayMachineAddress()
	{
		return($this->DisplayMachineAddress);
	}

	function setDisplayMachineAddress($dma)
	{
		$this->DisplayMachineAddress = $dma;
	}

	function getDisplayHardDriveSize()
	{
		return($this->DisplayHardDriveSize);
	}

	function setDisplayHardDriveSize($hds)
	{
		$this->DisplayHardDriveSize = $hds;
	}

	function getDisplayContact()
	{
		return($this->DisplayContact);
	}

	function setDisplayContact($dc)
	{
		$this->DisplayContact = $dc;
	}

	function getDisplayContactNumber()
	{
		return($this->DisplayContactNumber);
	}

	function setDisplayContactNumber($dcn)
	{
		$this->DisplayContactNumber = $dcn;
	}

	function getDisplayComments()
	{
		return($this->DisplayComments);
	}

	function setDisplayComments($dc)
	{
		$this->DisplayComments = $dc;
	}

	function getDisplayDateMod()
	{
		return($this->DisplayDateMod);
	}

	function setDisplayDateMod($dm)
	{
		$this->DisplayDateMod = $dm;
	}

	function getAdvancedTracking()
	{
		return($this->AdvancedTracking);
	}

	function setAdvancedTracking($at)
	{
		$this->AdvancedTracking = $at;
	}

	function getTrackingOrder()
	{
		return($this->TrackingOrder);
	}

	function setTrackingOrder($to)
	{
		$this->TrackingOrder = $to;
	}

}

?>
