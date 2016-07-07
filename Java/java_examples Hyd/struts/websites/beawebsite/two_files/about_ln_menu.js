// Copyright 2003 © BEA Systems, Inc. All rights reserved

// ABOUT US
/*
*/

var LN_MENU_ITEMS = ['ROOT', 'ROOT',
						['Corporate Information', '/framework.jsp?CNT=corporate.htm&FP=/content/about/corporate/',
							['At-a-Glance', '/framework.jsp?CNT=ataglance.htm&FP=/content/about/corporate/'],
							['Milestones', '/framework.jsp?CNT=milestones_index.jsp&FP=/content/about/corporate/'],
							['Management', '/framework.jsp?CNT=management.htm&FP=/content/about/corporate/'],
							['2003 Annual Review', '/framework.jsp?CNT=annual_review.htm&FP=/content/about/corporate/',
								['Introduction', '/framework.jsp?CNT=main.html&FP=/content/about/corporate/annual_review/'],
								['Shareholder Letter', '/framework.jsp?CNT=shareholder_letter.html&FP=/content/about/corporate/annual_review/'],
								['Accomplishments', '/framework.jsp?CNT=mission_critical.html&FP=/content/about/corporate/annual_review/'],
								['Technology', '/framework.jsp?CNT=proof_potential.html&FP=/content/about/corporate/annual_review/'],
								['Vision', '/framework.jsp?CNT=develop_integrate.html&FP=/content/about/corporate/annual_review/'],
								['Financial Charts', '/framework.jsp?CNT=financial_charts.html&FP=/content/about/corporate/annual_review/'],
								['Corporate Information', '/framework.jsp?CNT=corporate_info.html&FP=/content/about/corporate/annual_review/']
							]
						],
						['Investor Information', 'http://ir.bea.com',
							['FAQs', 'http://ir.bea.com/ireye/ir_site.zhtm?ticker=BEAS&script=1801'],
							['Current Stock Quote', 'http://ir.bea.com/ireye/ir_site.zhtm?ticker=BEAS&script=200'],
							['SEC Filings', 'http://ir.bea.com/ireye/ir_site.zhtm?ticker=BEAS&script=1901'],
							['Financial Releases', 'http://www.bea.com/investors/releases.shtm'],
							['Securities Analysis', 'http://www.corporate-ir.net/ireye/ir_site.zhtm?ticker=BEAS&script=500'],
							['Request Investor Materials', 'http://ir.bea.com/ireye/ir_site.zhtm?ticker=BEAS&script=2300'],
							['Contact Investor Relations', 'http://ir.bea.com/ireye/ir_site.zhtm?ticker=BEAS&script=1850']
						],
						['BEA in the Community', '/framework.jsp?CNT=index.htm&FP=/content/about/community/',
							['Community Programs', '/framework.jsp?CNT=programs.htm&FP=/content/about/community/'],
							['Grant Programs', '/framework.jsp?CNT=grant_program.htm&FP=/content/about/community/grant/',
								['Eligibility Quiz', '/framework.jsp?CNT=foundation.htm&FP=/content/about/community/grant/'],
								['Application Guidelines', '/framework.jsp?CNT=grant_application.htm&FP=/content/about/community/grant/'],
								['Recipients', '/framework.jsp?CNT=grant_recipients_index.jsp&FP=/content/about/community/grant/']
							],
							['Special Programs', '/framework.jsp?CNT=special_programs.htm&FP=/content/about/community/']
						],
						['Careers', '/framework.jsp?CNT=index.htm&FP=/content/about/careers/',
							['Find a Job', '/framework.jsp?CNT=find.jsp&FP=/content/about/careers/'],
							['Submit your Resume', '/framework.jsp?CNT=apply.jsp&FP=/content/about/careers/'],
							['Working at BEA', '/framework.jsp?CNT=working_at_bea.htm&FP=/content/about/careers/'],
							['Benefits', '/framework.jsp?CNT=benefits.htm&FP=/content/about/careers/'],
							['College Recruiting', '/framework.jsp?CNT=college_recruiting.htm&FP=/content/about/careers/']
						],
						['Executive Briefing Center', '/framework.jsp?CNT=index.htm&FP=/content/about/ebc/',
							['Why Visit BEA', '/framework.jsp?CNT=why.htm&FP=/content/about/ebc/'],
							['Transportation', '/framework.jsp?CNT=trans.htm&FP=/content/about/ebc/'],
							['Lodging', '/framework.jsp?CNT=lodging.htm&FP=/content/about/ebc/'],
							['Dining', '/framework.jsp?CNT=dining.htm&FP=/content/about/ebc/'],
							['Activities', '/framework.jsp?CNT=activities.htm&FP=/content/about/ebc/']
						],
						['Contact BEA', '/framework.jsp?CNT=contactus.htm&FP=/content/about/contact/',
							['BEA Sales', '/framework.jsp?CNT=sales1.htm&FP=/content/about/contact/'],
							['Customer Support', '/framework.jsp?CNT=index.htm&FP=/content/services/customer_support/contacts/'],
							['Education Services', '/framework.jsp?CNT=index.htm&FP=/content/services/education/contact/'],
							['Public Relations', '/framework.jsp?CNT=contact_pr.htm&FP=/content/about/contact/'],
							['Worldwide Offices', '/framework.jsp?CNT=worldwide_offices.htm&FP=/content/about/contact/',
								['Canada', '/framework.jsp?CNT=contact_canada.htm&FP=/content/about/contact/'],
								['Latin America', '/framework.jsp?CNT=contact_lat_am.htm&FP=/content/about/contact/'],
								['United States', '/framework.jsp?CNT=contact_north_america.htm&FP=/content/about/contact/'],
								['Europe, Middle East, Africa', '/framework.jsp?CNT=contact_emea.htm&FP=/content/about/contact/'],
								['Asia-Pacific', '/framework.jsp?CNT=contact_apac.htm&FP=/content/about/contact/']							
							]
						],
						['FAQs', '/content/about/faq/faq.jsp']
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
			document.write('<tr valign="top" bgcolor="#f7f7f7">');
			document.write('<td>' + indic[i] + '</td>');
			document.write('<td colspan="2"><a href="' + this.link + '" class="nav2">' + this.name + '</a></td>');
			document.write('<td><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="1"></td>');
			document.write('</tr>');
			document.write('<tr bgcolor="#f7f7f7"><td colspan="4"><img src="' + LN_IMG_LOC + 'spacer.gif" width="1" height="7"></td></tr>');
			break;
			
			case 2 :
			document.write('<tr valign="top" bgcolor="#f7f7f7">');
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
