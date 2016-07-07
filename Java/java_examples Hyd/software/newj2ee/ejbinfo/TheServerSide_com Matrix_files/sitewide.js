var currentSection;

// -- Preload the mouseover images
var menuIcon_news_mo = new Image();
menuIcon_news_mo.src = '/images/tab_news_mo.gif'; 
var menuIcon_discussions_mo = new Image(); 
menuIcon_discussions_mo.src = '/images/tab_discussions_mo.gif';
var menuIcon_techtalks_mo = new Image();
menuIcon_techtalks_mo.src = '/images/tab_techtalks_mo.gif'; 
var menuIcon_patterns_mo = new Image(); 
menuIcon_patterns_mo.src = '/images/tab_patterns_mo.gif';
var menuIcon_reviews_mo = new Image(); 
menuIcon_reviews_mo.src = '/images/tab_reviews_mo.gif';
var menuIcon_articles_mo = new Image();
menuIcon_articles_mo.src = '/images/tab_articles_mo.gif';
var menuIcon_casestudies_mo = new Image();
menuIcon_casestudies_mo.src = '/images/tab_casestudies_mo.gif';

// -- right hand side
var menuIcon_about_mo = new Image();
menuIcon_about_mo.src = '/images/tab_about_mo.gif';
var menuIcon_myprofile_mo = new Image();
menuIcon_myprofile_mo.src = '/images/tab_myprofile	_mo.gif';
var menuIcon_mythreads_mo = new Image();
menuIcon_mythreads_mo.src = '/images/tab_mythreads_mo.gif';
var menuIcon_logout_mo = new Image();
menuIcon_logout_mo.src = '/images/tab_logout_mo.gif';
var menuIcon_feeds_mo = new Image();
menuIcon_feeds_mo.src = '/images/tab_feeds_mo.gif';

// -- highlight methods
function mouseOver(theObj, theSectionName) {
	if (theSectionName != currentSection) {
		theObj.src = '/images/tab_' + theSectionName + '_mo.gif';
	}
}

function mouseOut(theObj, theSectionName) {
	if (theSectionName != currentSection) {
		theObj.src = '/images/tab_' + theSectionName + '.gif';
	}
}

function highlightSection(theSectionName) {
	currentSection = theSectionName;
    
	if (document.getElementById) {
		var targetElement = document.getElementById('menuIcon_' + theSectionName);
		targetElement.src = '/images/tab_' + theSectionName + '_sel.gif';
	}
}

// -- clear and fill the input
function cl(inp, val) {
	if (inp.value == val) inp.value = "";
}

function fl(inp, val) {
	if (inp.value == "") inp.value = val;
}
