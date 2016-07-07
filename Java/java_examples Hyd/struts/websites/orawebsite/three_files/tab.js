//-- Copy data from the top
if (top.toprow) var toprow = top.toprow;
if (top.tab) var tab = top.tab;
if (top.TopMaxVal) var TopMaxVal = top.TopMaxVal;
if (top.TabMaxVal) var TabMaxVal = top.TabMaxVal;
if (top.strings) var strings = top.strings;
//if (top.c) var c = top.c;
if (top.c1) var c1 = top.c1;
if (top.CountriesMaxVal) var CountriesMaxVal = top.CountriesMaxVal;

var def_header      = '00'
var header          = top.header
var CMS_Menu  = true;
if (!header) header = def_header

var crumb = ""
if (top.crumb) crumb = top.crumb
var URL = top.location

function DrawLiveEdit() {
  var path    = top.location.pathname
  var file= path.substring(path.lastIndexOf("/") + 1, path.length) + top.location.search;
  var path= path.substring(0,path.lastIndexOf("/") + 1)
  var phost   = emkt_host
  var path    = 'http://emarketing.oraclecorp.com' + path
  var Edit_Menu = "";

  if (CMS_Menu && location.hostname.indexOf("www-stage.us.oracle.com") != -1 && top.user_info[FNAME] ) {
    Edit_Menu += '<br><br><table border="0" cellpadding="0" cellspacing="0" summary="" align="center"><tr><td height=19 nowrap valign="bottom" bgcolor="#FFFFFF">&nbsp;\n'
    Edit_Menu += '<A HREF="javascript:eval( &quot;goWin( \'' + phost + 'C.Live_List_Directory?p_Path=' + path + '\', 3 )&quot; );"><img src="http://oracleimg.com/admin/images/explorer.gif" alt="Explore the Directory" width=20 height=19 border=0></A>&nbsp;\n'
    Edit_Menu += '<A HREF="javascript:eval( &quot;goWin( \'' + phost + 'C.Live_Add_New_File?p_Path=' + path + '\', 3 )&quot; );"><img src="http://oracleimg.com/admin/images/add.gif" alt="Add or Load Files" width=20 height=19 border=0></A>&nbsp;\n'
    Edit_Menu += '<A HREF="javascript:eval( &quot;goWin( \'' + phost + 'C.Live_Directory_Details?p_Path=' + path + '\', 2, 640, 430 )&quot; );"><img src="http://oracleimg.com/admin/images/folder_prop.gif" alt="Edit the Directory Details" width=20 height=19 border=0></A>&nbsp;\n'
    Edit_Menu += '<A HREF="javascript:eval( &quot;goWin( \'' + phost + 'C.Live_Show_Page_Layout?p_Path=' + path + '&Edit=Y\', 3 )&quot; );"><img src="http://oracleimg.com/admin/images/page.gif" alt="Edit the Page Layout" width=20 height=19 border=0></A>&nbsp;\n'
    Edit_Menu += '<A HREF="javascript:eval( &quot;goWin( \'' + phost + 'C.Live_Page_Details?p_Path=' + path + '&p_Filename=' + file + '\', 3 )&quot; );"><img src="http://oracleimg.com/admin/images/properties.gif" alt="Edit the Page Properties" width=20 height=19 border=0></A>&nbsp;\n'
    Edit_Menu += '<A HREF="javascript:eval( &quot;goWin( \'' + phost + 'C.Live_Page_Edit?p_Path=' + path + '&p_Filename=' + file + '\', 3 )&quot; );"><img src="http://oracleimg.com/admin/images/edit.gif" alt="Edit the Page" width=20 height=19 border=0></A>&nbsp;\n'
    Edit_Menu += '</td></tr></table>\n'
  }

  block += Edit_Menu;
  document.write(block)
  document.close()
}

function DrawTabs( Label, URL, Target, Type ) {

  var tmp = '';
  tmp += '<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" summary="">';
  tmp += '<TR>';
  tmp += '<TD nowrap  WIDTH="1" HEIGHT="16"><img src="http://oracleimg.com/admin/header/bar_left1.gif" BORDER="0" WIDTH="1" HEIGHT="16" ALT=""></TD>';
  tmp += '<TD nowrap WIDTH="9" HEIGHT="16"><img src="http://oracleimg.com/admin/header/bar_background1.gif" BORDER="0" WIDTH="9" HEIGHT="16" ALT=""></TD>';

  var tmp2 = '';
  tmp2 += '<TD nowrap WIDTH="8" HEIGHT="16"><img src="http://oracleimg.com/admin/header/bar_stepdown1.gif" BORDER="0" WIDTH="8" HEIGHT="16" ALT=""></TD>';
  tmp2 += '</TR><TR>';
  tmp2 += '<TD nowrap WIDTH="1" HEIGHT="18"><img src="http://oracleimg.com/admin/header/bar_left2.gif" BORDER="0" WIDTH="1" HEIGHT="18" ALT=""></TD>';
  tmp2 += '<TD nowrap WIDTH="9" HEIGHT="18"><img src="http://oracleimg.com/admin/header/bar_background2.gif" BORDER="0" WIDTH="9" HEIGHT="18" ALT=""></TD>';


  for (var i = 0; i <= TabMaxVal; i++) {
    if (tab[i].label != null && tab[i].label != "") {

      // set correct color for tab text on selection
      var textClass = (header == i) ? "textB" : "textC";

      tmp += '<TD nowrap WIDTH="2" HEIGHT="16"><img src="http://oracleimg.com/admin/header/button_left1.gif" BORDER=0 WIDTH="2" HEIGHT="16" ALT=""></TD>';
      tmp += '<TD nowrap background="http://oracleimg.com/admin/header/button_middle1.gif" HEIGHT="16" VALIGN="bottom" CLASS="' + textClass + '"><a href="' + tab[i].url + '" CLASS="' + textClass + '" target="_top"><span CLASS="' + textClass + '">&nbsp; &nbsp; ' + tab[i].label + ' &nbsp; &nbsp;</span></A></TD>';
      tmp += '<TD nowrap WIDTH="2" HEIGHT="16"><img src="http://oracleimg.com/admin/header/button_right1.gif" BORDER=0 WIDTH="2" HEIGHT="16" ALT=""></TD>';
      tmp += '<TD nowrap WIDTH="8" HEIGHT="16"><img src="http://oracleimg.com/admin/header/bar_background1.gif" BORDER=0 WIDTH="8" HEIGHT="16" ALT=""></TD>';

      tmp2 += '<TD nowrap WIDTH="2" HEIGHT="18"><img src="http://oracleimg.com/admin/header/button_left2.gif" BORDER="0" WIDTH="2" HEIGHT="18" ALT=""></TD>';
      tmp2 += '<TD nowrap background="http://oracleimg.com/admin/header/button_middle2.gif"><img src="http://oracleimg.com/admin/header/button_middle2.gif"></TD>';
      tmp2 += '<TD nowrap WIDTH="2" HEIGHT="18"><img src="http://oracleimg.com/admin/header/button_right2.gif" BORDER="0" WIDTH="2" HEIGHT="18" ALT=""></TD>';
      tmp2 += '<TD nowrap WIDTH="8" HEIGHT="18"><img src="http://oracleimg.com/admin/header/bar_background2.gif" BORDER="0" WIDTH="8" HEIGHT="18" ALT=""></TD>';
    }
  }

  var tmp3 = '';
  tmp3 += '<TD nowrap WIDTH="8" HEIGHT="18"><img src="http://oracleimg.com/admin/header/bar_stepdown2.gif" BORDER="0" WIDTH="8" HEIGHT="18" ALT=""></TD>';
  tmp3 += '</TR></TABLE>';

  tmp = tmp + tmp2 + tmp3;

  document.write(tmp);
  document.close();

}

function DrawLogo() {
  var tl = top.location.href;
  var lr = strings.language_root;
  var hp = ((lr && (tl.indexOf(lr) != -1)) &! (tl.indexOf("lang") != -1)) ? lr : '/';
  var tmp = '<a href="' + hp + '" target="_top"><img src="http://oracleimg.com/admin/header/ora_logo.gif" width="248" height="33" border="0" alt="Oracle Corporation Global HomePage"></A>';
  document.write(tmp);
  document.close();
}

function DrawWelcome() {
  var tmp = '';
  if (top.user_info[FNAME]) {
    tmp += '<span class="profile">' + strings.ident_label + ' ( <a class="profile" href="javascript:signout(\'' + URL + '\');">' + strings.signout_label + '</a> | <a class="profile" target="_top" href="' + strings.signin_URL + '">' + strings.account_label + '</a> )</span>';
  } else {
    tmp += "<a class=\"profile\" href=\"" + strings.signin_URL + "\" target=\"_top\">(" + strings.signin_label + '&nbsp;' +strings.mem2_label + ")</a>";
  }
  document.write(tmp);
  document.close();
}

function DrawTopRow() {

  var tmp = '<table border=0 cellpadding=0 cellspacing=0 align="right" summary=""><tr>';

  // loop through 1st row
  for (var i = 1; i <= TopMaxVal; i++ ) {
    tmp += '<td align="center" valign="bottom" nowrap><a href="' + toprow[i].url + '" target="'+toprow[i].target+'">';
    tmp += '<img src="' + toprow[i].image + '" align="absmiddle" width="32" height="33" border="0" alt="' + toprow[i].label + '"></a></td>';
    if (i != TopMaxVal) {
      tmp += '<td rowspan="2" width="20">&nbsp;</td>';
    }
  }
  tmp += '</tr><tr>';

  // loop through 2nd row
  for (var i = 1; i <= TopMaxVal; i++ ) {
    tmp += '<td align="center" valign="top" nowrap><a href="' + toprow[i].url + '" class="legalese" target="'+toprow[i].target+'">' + toprow[i].label + '</a></td>'
  }

  tmp += '</tr></table>';


  document.write(tmp);
  document.close();
}

function DrawCountryDropdown() {
  c1 = sortList(c1);
  var tmp = '<select class="legalese" size="1" onChange="top.location.href=this.options[selectedIndex].value">';
  for (var i = 0; i < c1.length; i++) {
    if (c1[i][0]) {
      tmp += '<option value="' + c1[i][1] + '">' + c1[i][0] + '</option>';
    }
  }
  tmp += '</select>';
  document.write(tmp);
  document.close();
}

function sortList(i) {
  var tmp = i.shift();
  i.sort(sortOptions);
  i.unshift(tmp);
  return(i);
}

function sortOptions(a,b) {
  return ((a[0] < b[0]) ? -1 : (a[0] == b[0]) ? 0 : 1);
}

function checkSearch(field) {
  if (field.value == "" || field.value == null) return false;
  else return true;
}


