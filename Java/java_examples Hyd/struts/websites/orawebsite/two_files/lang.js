//-- lang.js: Country/language specific JS data file
//-- last updated: 8/14/2003 3:58PM - john burbridge

readInfoCookie()
var uname = ORA_UCM_INFO.firstname; //getName(user_info)
var toprow = new Array(10)
for (var i = 0; i < toprow.length; i++ ) toprow[i] = new item(i);

var tab = new Array(15)
for (var i = 0; i < tab.length; i++ ) tab[i] = new item(i);

function item(Id){
  this.id = Id, this.label = '', this.url = '', this.image = '', this.target = '_top'
}

// for countries dropdown
//var c = Array(70);
//for (var i = 0; i < c.length; i++ ) c[i] = new option(i);

function option(i){
  this.id = i, this.label = '', this.url = '';
  return this;
}


///-- DON'T TOUCH ABOVE THIS LINE

var strings = new Object()
strings.language_root  	=  ""
strings.search_label    = "SEARCH"
strings.search_URL      = "http://www.oracle.com/ultrasearch/wwws/searchoc.jsp"
strings.print_label    	= "Printer View"
strings.mail_label     	= "Tell a Friend"
strings.mail_URL		    = "/admin/account/mail.html"
strings.rate_label     	= "Rate This Page"
strings.rate_URL		    = "/admin/account/rate.html"
strings.salesrep_label  = "Contact a Sales Rep"
strings.salesrep_URL	  = "/admin/account/sales.html"
strings.subscribe_label	= "Subscribe"
strings.subscribe_URL	  = "/subscribe/subscribe_smallwindow.html"
strings.glossary_label	= "Glossary"
strings.glossary_URL	  = "/glossary/index.html?axx.html"
strings.signin_label	  = "Register"
strings.signin_URL		  = "/admin/account/index.html"
strings.signout_label	  = "Sign Out"
strings.account_label	  = "Account"
strings.ident_label    	= "Welcome " + uname
strings.mem1_label     	= "If you are not " + uname + ", "
strings.mem2_label     	= "for a free Oracle Web account"
// footer
strings.copyright_label	  = "Copyright &copy; 2004, Oracle Corporation. All Rights Reserved"
strings.copyright_URL     = "#"
strings.aboutoracle_label	= "About Oracle"
strings.aboutoracle_URL   = "/corporate/"
strings.contactus_label	  = "Contact Us"
strings.contactus_URL     = "/corporate/contact/"
strings.legal_label		    = "Legal Notices and Terms of Use"
strings.legal_URL         = "/html/copyright.html"
strings.privacy_label		  = "Privacy Statement"
strings.privacy_URL       = "/html/privacy.html"

toprow[1].label     = "METALINK"
toprow[1].url       = "http://metalink.oracle.com/"
toprow[1].image     = "http://oracleimg.com/admin/header/metalink_icon.gif"
toprow[1].target    = "_top"
toprow[2].label     = "BUY"
toprow[2].url       = "/products/buy/"
toprow[2].image     = "http://oracleimg.com/admin/header/buy_icon.gif"
toprow[2].target    = "_top"
toprow[3].label     = "DOWNLOADS"
toprow[3].url       = "http://otn.oracle.com/software/content.html"
toprow[3].image     = "http://oracleimg.com/admin/header/download_icon.gif"
toprow[3].target    = "_top"
toprow[4].label     = "CONTACT US"
toprow[4].url       = "http://www.oracle.com/corporate/contact/"
toprow[4].image     = "http://oracleimg.com/admin/header/contact_icon.gif"
toprow[4].target    = "_top"
TopMaxVal = 4;

tab[1].label = "PRODUCTS"
tab[1].url = "/products/index.html"
tab[2].label = "SOLUTIONS"
tab[2].url = "/solutions/index.html"
tab[3].label = "SERVICES"
tab[3].url = "/services/index.html"
tab[4].label = "TECHNOLOGIES"
tab[4].url = "/technologies/index.html"
TabMaxVal = 4;

// define the country list
var c1 = [
     [ "SELECT COUNTRY", "" ],
     [ "Argentina", "/ar/" ],
     [ "Australia", "/au/" ],
     [ "Austria", "/at/" ],
     [ "Bahrain", "/me/" ],
     [ "Bangladesh", "/pk/" ],
     [ "Belgium & Luxembourg", "/be/" ],
     [ "Bosnia", "/ba/" ],
     [ "Bhutan", "/pk/" ],
     [ "Brasil", "/br/" ],
     [ "Bulgaria", "/bg/" ],
     [ "Brunei", "/pk/" ],
     [ "Cambodia", "/pk/" ],
     [ "Canada - English", "/ca-en/" ],
     [ "Canada - French", "/ca-fr/" ],
     [ "Chile", "/cl/" ],
     [ "China", "/cn/" ],
     [ "Colombia", "/co/" ],
     [ "Costa Rica", "/cr/" ],
     [ "Croatia", "/hr/" ],
     [ "Czech Republic", "/cz/" ],
     [ "Denmark", "/dk/" ],
     [ "Ecuador", "/ec/" ],
     [ "Egypt", "/me/" ],
     [ "Estonia", "/ee/" ],
     [ "Finland", "/fi/" ],
     [ "France", "/fr/" ],
     [ "Germany", "/de/" ],
     [ "Greece", "/gr/" ],
     [ "Hong Kong", "/hk/" ],
     [ "Hungary", "/hu/" ],
     [ "India", "/in/" ],
     [ "Indonesia", "/ea/" ],
     [ "Ireland", "/ie/" ],
     [ "Israel", "/il/" ],
     [ "Itlay", "/it/" ],
     [ "Japan", "http://www.oracle.co.jp" ],
     [ "Jordan", "/me/" ],
     [ "Korea", "/kr/" ],
     [ "Kuwait", "/me/" ],
     [ "Laos", "/pk/" ],
     [ "Latvia", "/lv/" ],
     [ "Lebanon", "/me/" ],
     [ "Lithuania", "/lt/" ],
     [ "Malaysia", "/my/" ],
     [ "Maldives", "/pk/" ],
     [ "Mexico", "/mx/" ],
     [ "Nepal", "/pk/" ],
     [ "Netherlands", "/nl/" ],
     [ "New Zealand", "/nz/" ],
     [ "Norway", "/no/" ],
     [ "Oman", "/me/" ],
     [ "Pakistan", "/pk/" ],
     [ "Peru", "/pe/" ],
     [ "Philippines", "/ea/" ],
     [ "Poland", "/pl/" ],
     [ "Portugal", "/pt/" ],
     [ "Puerto Rico", "/pr/" ],
     [ "Qatar", "/me/" ],
     [ "Romania", "/ro/" ],
     [ "Russia", "/ru/" ],
     [ "Saudi Arabia", "/me/" ],
     [ "Singapore", "/ea/" ],
     [ "Slovakia", "/sk/" ],
     [ "Slovenia", "/si/" ],
     [ "South Africa", "/za/" ],
     [ "Spain", "/es/" ],
     [ "Sri Lanka", "/pk/" ],
     [ "Sweden", "/se/" ],
     [ "Switzerland -- French", "/ch-fr/" ],
     [ "Switzerland -- German", "/ch-de/" ],
     [ "Taiwan", "/tw/" ],
     [ "Thailand", "/th/" ],
     [ "Turkey", "/tr/" ],
     [ "United Arab Emirates", "/me/" ],
     [ "United Kingdom", "/uk/" ],
     [ "United States", "/" ],
     [ "Venezuela", "/ve/" ],
     [ "Yemen", "/me/" ]
];   
var CountriesMaxVal = 69;

var langjsLoad = true
//alert("Language File Loaded")

