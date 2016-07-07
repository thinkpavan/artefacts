// Copyright 2003 © BEA Systems, Inc. All rights reserved

// SERVICES - AMERICAS

var LN_MENU_ITEMS = ['ROOT', 'ROOT',
						['Consulting', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/',
							['Solutions', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/solutions/',
								['Solutions Office','/framework.jsp?CNT=solutions_office.htm&FP=/content/services/consulting/solutions/'],
								['BEA Migration Express Solution','/framework.jsp?CNT=wl_consolidation.htm&FP=/content/services/consulting/solutions/']
							],
							['Standard Offerings', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/standard_offerings/',
								['Assessments','/framework.jsp?CNT=so_assessments.htm&FP=/content/services/consulting/standard_offerings/'],
								['RightStarts','/framework.jsp?CNT=so_rightstarts.htm&FP=/content/services/consulting/standard_offerings/'],
								['HealthChecks','/framework.jsp?CNT=so_healthchecks.htm&FP=/content/services/consulting/standard_offerings/'],
								['Linux Migration Services','/framework.jsp?CNT=so_linux.htm&FP=/content/services/consulting/standard_offerings/'],
								['Integration Readiness Services','/framework.jsp?CNT=so_integration.htm&FP=/content/services/consulting/standard_offerings/']
							],
							['Custom Offerings', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/custom_offerings/'],
							['Business Consulting Units', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/bcu/'],
							['Success Stories', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/success_stories/'],
							['Best Practices', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/best_practices/'],
							['Contact Consulting', '/framework.jsp?CNT=index.htm&FP=/content/services/consulting/contact/']
						],
						['Customer Support', '/framework.jsp?CNT=index.htm&FP=/content/services/customer_support/',
							['Support Services', '/framework.jsp?CNT=index.htm&FP=/content/services/customer_support/supp_services/',
								['Mission Critical Support','/framework.jsp?CNT=mission_critical.htm&FP=/content/services/customer_support/supp_services/'],
								['Development Support', '/framework.jsp?CNT=dev_support.htm&FP=/content/services/customer_support/supp_services/'],
								['Production Support', '/framework.jsp?CNT=prod_support.htm&FP=/content/services/customer_support/supp_services/'],
								['BEA dev2dev Support', '/framework.jsp?CNT=dev2dev_support.htm&FP=/content/services/customer_support/supp_services/'],
								['Customized Support', '/framework.jsp?CNT=custom_support.htm&FP=/content/services/customer_support/supp_services/']
							],
							['Additional Programs', '/framework.jsp?CNT=index.htm&FP=/content/services/customer_support/add_programs/',
								['WebLogic Guru Contest','/framework.jsp?CNT=weblogic_guru.htm&FP=/content/services/customer_support/add_programs/'],
								['3rd Party Product Support', '/framework.jsp?CNT=third_party.htm&FP=/content/services/customer_support/add_programs/']
							],
							['Glossary', '/framework.jsp?CNT=index.htm&FP=/content/services/customer_support/glossary/'],
							['Contact Us', '/framework.jsp?CNT=index.htm&FP=/content/services/customer_support/contacts/']
						],
						['Education', '/framework.jsp?CNT=index.htm&FP=/content/services/education/',
							['Find Training', '/framework.jsp?CNT=find_training.htm&FP=/content/services/education/'],
							['Curriculum Tracks', '/framework.jsp?CNT=index.htm&FP=/content/services/education/tracks/',
								['Developer', '/framework.jsp?CNT=dev_index.htm&FP=/content/services/education/tracks/'],
								['Administrator', '/framework.jsp?CNT=admin_index.htm&FP=/content/services/education/tracks/'],
								['Architects', '/framework.jsp?CNT=arch_index.htm&FP=/content/services/education/tracks/'],
								['Business Analyst', '/framework.jsp?CNT=ba_index.htm&FP=/content/services/education/tracks/']
							],
							['Certification', 'http://certification.bea.com/certification/index.jsp'],
							['Packaged Offerings', '/framework.jsp?CNT=index.htm&FP=/content/services/education/packages/'],
							['Accelerated Knowledge Transfer Solution', '/framework.jsp?CNT=index.htm&FP=/content/services/education/akt_solution/',
								['Analysis', '/framework.jsp?CNT=akt_analysis.htm&FP=/content/services/education/akt_solution/'],
								['Training', '/framework.jsp?CNT=akt_training.htm&FP=/content/services/education/akt_solution/'],
								['Mentoring', '/framework.jsp?CNT=akt_mentoring.htm&FP=/content/services/education/akt_solution/'],
								['Management', '/framework.jsp?CNT=akt_management.htm&FP=/content/services/education/akt_solution/']
							],
							['Contact Information', '/framework.jsp?CNT=index.htm&FP=/content/services/education/contact/']
						]
					];
					
var LN_IMG_LOC = '/content/images/';

function LN_drawMenu() {
		
	menu = new LN_menuItem(LN_MENU_ITEMS, -1);

	menu.LN_findItems();
	
	document.write('<table width="150" border="0" cellspacing="0" cellpadding="0" bgcolor="#d9d8d8">');
	document.write('<tr>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="10" height="1"></td>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="10" height="1"></td>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="120" height="1"></td>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="10" height="1"></td>');
	document.write('</tr>');   
	menu.LN_drawItems(true, false);
	document.write('<tr>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="10" height="20"></td>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="10" height="20"></td>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="120" height="20"></td>');
	document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="10" height="20"></td>');
	document.write('</tr>'); 
	document.write('</table>');
}

function LN_findItems(){
	
	for(var i = 0; i < this.subMenus.length; i++)
		if(this.subMenus[i].level < LN_MENU_ACTIV.length)
			if(this.subMenus[i].name == LN_MENU_ACTIV[this.subMenus[i].level])
			{
				LN_MENU_ACTIV[this.subMenus[i].level] = i;
				this.subMenus[i].LN_findItems();				
				break;
			}
}

function LN_drawItems(open, activ) {
	
	if(this.level >= 0)
	{
		var i = activ ? 1 : 0;
		indic = ['<img src="' + LN_IMG_LOC + 'spacer.gif" alt="bea" width="10" height="10">',
		         '<img src="' + LN_IMG_LOC + 'common/nav_indicator.gif" alt="navigation arrow" width="10" height="10">'];
		
		switch(this.level) {
		
			case 0 :			
			document.write('<tr><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="8"></td></tr>');
			document.write('<tr valign="top">');
			document.write('<td>' + indic[i] + '</td>');
			document.write('<td colspan="2"><a href="' + this.link + '" class="nav1">' + this.name + '</a></td>');
			document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="1"></td>');
			document.write('</tr>');
			document.write('<tr><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="8"></td></tr>');
			document.write('<tr bgcolor="#ffffff"><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="1"></td></tr>');
			if(open && this.subMenus.length > 0)
			document.write('<tr bgcolor="#f7f7f7"><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="7"></td></tr>');
			break;
			 
			case 1 :
			document.write('<tr bgcolor="#f7f7f7" valign="top">');
			document.write('<td>' + indic[i] + '</td>');
			document.write('<td colspan="2"><a href="' + this.link + '" class="nav2">' + this.name + '</a></td>');
			document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="1"></td>');
			document.write('</tr>');
			document.write('<tr bgcolor="#f7f7f7"><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="7"></td></tr>');
			break;
			
			case 2 :
			document.write('<tr bgcolor="#f7f7f7" valign="top">');
			document.write('<td colspan="2">' + indic[i] + '</td>');
			document.write('<td ><a href="' + this.link + '" class="nav3">' + this.name + '</a></td>');
			document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="1"></td>');
			document.write('</tr>');
			break;
		}
	}
	
	if(!open) return;
	
	for(var i = 0; i < this.subMenus.length; i++)
	{
		if(i > 0 && this.level == 1)
			document.write('<tr bgcolor="#f7f7f7"><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="3"></td></tr>');
		
		this.open = (i == LN_MENU_ACTIV[this.subMenus[i].level]) ? true : false;
		this.activ = (this.open && LN_MENU_ACTIV.length == this.subMenus[i].level + 1) ? true : false;
		this.subMenus[i].LN_drawItems(this.open, this.activ);
	}

	if(this.subMenus.length > 0 && this.level == 1)
		document.write('<tr bgcolor="#f7f7f7"><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="7"></td></tr>');
}

function LN_menuItem(input, level) {

	this.name = input[0];
	this.link = input[1];
	this.level = level;
	this.subMenus = new Array();
		
	for(var i = 2; i < input.length; i++)
		this.subMenus[i - 2] = new LN_menuItem(input[i], level + 1);
	
	this.LN_drawItems = LN_drawItems;
	this.LN_findItems = LN_findItems;
}
