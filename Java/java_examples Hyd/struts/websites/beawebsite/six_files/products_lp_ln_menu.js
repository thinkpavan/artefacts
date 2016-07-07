// Copyright 2003 © BEA Systems, Inc. All rights reserved

// PRODUCTS

var LN_MENU_ITEMS = ['ROOT', 'ROOT',
						['BEA WebLogic Platform', '/framework.jsp?CNT=index.htm&FP=/content/products/platform/'],
						['BEA WebLogic Server', '/framework.jsp?CNT=index.htm&FP=/content/products/server/'],
						['BEA WebLogic Workshop','/framework.jsp?CNT=index.htm&FP=/content/products/workshop/'],
						['BEA WebLogic Integration','/framework.jsp?CNT=index.htm&FP=/content/products/integrate/'],
						['BEA WebLogic Portal','/framework.jsp?CNT=index.htm&FP=/content/products/portal/'],
						['BEA WebLogic Enterprise Security','/framework.jsp?CNT=index.htm&FP=/content/products/security/'],
						['BEA WebLogic JRockit', '/framework.jsp?CNT=index.htm&FP=/content/products/jrockit/'],
						['BEA Liquid Data for WebLogic', '/framework.jsp?CNT=index.htm&FP=/content/products/liquid_data/'],
						['BEA Tuxedo', '/framework.jsp?CNT=index.htm&FP=/content/products/tux/'],
						['More BEA Products', '/framework.jsp?CNT=index.htm&FP=/content/products/more/'],
						['Third Party Tools','/framework.jsp?CNT=index.htm&FP=/content/products/third/'],
						['All Products','/framework.jsp?CNT=all.htm&FP=/content/products/']
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
