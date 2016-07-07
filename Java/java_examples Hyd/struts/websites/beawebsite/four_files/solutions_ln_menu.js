// Copyright 2003 © BEA Systems, Inc. All rights reserved

// SOLUTIONS

var LN_MENU_ITEMS = ['ROOT', 'ROOT',
						['Industry Solutions', '/framework.jsp?CNT=index.htm&FP=/content/solutions/industry/',
							['Telecommunications', '/framework.jsp?CNT=index.htm&FP=/content/solutions/industry/communications/'],
							['Financial Services','/framework.jsp?CNT=index.htm&FP=/content/solutions/industry/financial/',
								['BEA in Financial Services','/framework.jsp?CNT=bea_fs.htm&FP=/content/solutions/industry/financial/'],
								['Securities Processing Solution','/framework.jsp?CNT=stp_solutions.htm&FP=/content/solutions/industry/financial/'],
								['Customers','/framework.jsp?CNT=customers.htm&FP=/content/solutions/industry/financial/'],
								['Press Releases','/framework.jsp?CNT=press.htm&FP=/content/solutions/industry/financial/'],
								['Events','/framework.jsp?CNT=events.htm&FP=/content/solutions/industry/financial/']
							],
							['Manufacturing', '/framework.jsp?CNT=index.htm&FP=/content/solutions/industry/manufacture/'],
							['Government', '/framework.jsp?CNT=index.htm&FP=/content/solutions/industry/govt/']
						],
						['Business Solutions', '/framework.jsp?CNT=index.htm&FP=/content/solutions/business/',
							['Customer Experience Management', '/framework.jsp?CNT=cust_ex_mgmt.htm&FP=/content/solutions/business/cust_ex_mgmt/'],
							['Workforce Productivity','/framework.jsp?CNT=wf_prod.htm&FP=/content/solutions/business/wf_prod/'],
							['Trading Partner Collaboration', '/framework.jsp?CNT=trading_ptnr.htm&FP=/content/solutions/business/trading_ptnr/']
						],
						['Technology Solutions', '/framework.jsp?CNT=index.htm&FP=/content/solutions/technical/',
							['BEA WebLogic Enterprise Platform', '/framework.jsp?CNT=index.htm&FP=/content/solutions/technical/platform/',
								['Business Challenge','/framework.jsp?CNT=business_challenge.htm&FP=/content/solutions/technical/platform/'],
								['Solution','/framework.jsp?CNT=solution.htm&FP=/content/solutions/technical/platform/'],
								['Product Fit','/framework.jsp?CNT=product_fit.htm&FP=/content/solutions/technical/platform/'],
								['Product Differentiation','/framework.jsp?CNT=product_diff.htm&FP=/content/solutions/technical/platform/']
							],
							['Portal Initiatives', '/framework.jsp?CNT=index.htm&FP=/content/solutions/technical/portal/',
								['Business Challenge','/framework.jsp?CNT=business_challenge.htm&FP=/content/solutions/technical/portal/'],
								['Solution','/framework.jsp?CNT=solution.htm&FP=/content/solutions/technical/portal/'],
								['Product Fit','/framework.jsp?CNT=product_fit.htm&FP=/content/solutions/technical/portal/'],
								['Product Differentiation','/framework.jsp?CNT=product_diff.htm&FP=/content/solutions/technical/portal/']
							],
							['Integration Projects', '/framework.jsp?CNT=index.htm&FP=/content/solutions/technical/integration/',
								['Business Challenge','/framework.jsp?CNT=business_challenge.htm&FP=/content/solutions/technical/integration/'],
								['Solution','/framework.jsp?CNT=solution.htm&FP=/content/solutions/technical/integration/'],
								['Product Fit','/framework.jsp?CNT=product_fit.htm&FP=/content/solutions/technical/integration/'],
								['Product Differentiation','/framework.jsp?CNT=product_diff.htm&FP=/content/solutions/technical/integration/']
							],
							['Custom Application Development', '/framework.jsp?CNT=index.htm&FP=/content/solutions/technical/building_apps/',
								['Business Challenge','/framework.jsp?CNT=business_challenge.htm&FP=/content/solutions/technical/building_apps/'],
								['Solution','/framework.jsp?CNT=solution.htm&FP=/content/solutions/technical/building_apps/'],
								['Product Fit','/framework.jsp?CNT=product_fit.htm&FP=/content/solutions/technical/building_apps/'],
								['Product Differentiation','/framework.jsp?CNT=product_diff.htm&FP=/content/solutions/technical/building_apps/']
							],
							['Web Services', '/framework.jsp?CNT=index.htm&FP=/content/solutions/technical/web_services/',
								['Overview','/framework.jsp?CNT=overview.htm&FP=/content/solutions/technical/web_services/'],
								['Business Benefits','/framework.jsp?CNT=bus_benefits.htm&FP=/content/solutions/technical/web_services/'],
								['Enterprise Requirements','/framework.jsp?CNT=enterprise_req.htm&FP=/content/solutions/technical/web_services/'],
								['Building Web Services','/framework.jsp?CNT=building_web_svcs.htm&FP=/content/solutions/technical/web_services/'],
								['Interoperability','/framework.jsp?CNT=interop.htm&FP=/content/solutions/technical/web_services/'],
								['Evaluation Resources','/framework.jsp?CNT=eval_resources.htm&FP=/content/solutions/technical/web_services/']
							]
						],
						['Technology Resource Centers', '/framework.jsp?CNT=index.htm&FP=/content/solutions/resource/',
							['Linux Resource Center', '/framework.jsp?CNT=index.htm&FP=/content/solutions/resource/linux/',
								['Products', '/framework.jsp?CNT=products.htm&FP=/content/solutions/resource/linux/'],
								['Services', '/framework.jsp?CNT=services.htm&FP=/content/solutions/resource/linux/'],
								['Customers','/framework.jsp?CNT=customers.htm&FP=/content/solutions/resource/linux/'],
								['Partners','/framework.jsp?CNT=partners.htm&FP=/content/solutions/resource/linux/'],
								['News and Events','/framework.jsp?CNT=news_and_events.htm&FP=/content/solutions/resource/linux/'],								
								['Frequently Asked Questions','/framework.jsp?CNT=faq.htm&FP=/content/solutions/resource/linux/']
							],
							['Business Integration Resource Center', '/framework.jsp?CNT=index.htm&FP=/content/solutions/resource/integration/',
								['Customers','/framework.jsp?CNT=customers.htm&FP=/content/solutions/resource/integration/'],								
								['News and Events','/framework.jsp?CNT=news_and_events.htm&FP=/content/solutions/resource/integration/']
							],
							['Security Resource Center', '/framework.jsp?CNT=index.htm&FP=/content/solutions/resource/security/']
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
