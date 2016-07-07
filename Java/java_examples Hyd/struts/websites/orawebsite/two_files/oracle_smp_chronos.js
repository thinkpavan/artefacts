<!--
//Copyright Oracle Corporation 2001(v0.822)
var orig_onL4p6e1;
var orig_onUL5qb812;
var orig_onEr65xp6ec;
var oem_isNS45pu382 = false;
var oem_isNS45pu3826 = false;
var oem_isIE5qb812 = false;
var oem_so4p6e1 = false;
var oem_scrld45pu382;
var oem_screrr65xp6ec = false;
function get_fC45pu382() { return top.frames.length; }
function incr_pC5qb812()
{
if (isNaN(top.oem_pld45pu382))
{
top.oem_pld45pu382 = 0;
}
++top.oem_pld45pu382;
}
function decr_pC5qb812()
{
if (isNaN(top.oem_pld45pu382))
{
top.oem_pld45pu382 = 0;
}
--top.oem_pld45pu382;
}
function get_pC5qb812()
{
if (isNaN(top.oem_pld45pu382))
{
top.oem_pld45pu382 = 0;
}
return top.oem_pld45pu382;
}
function oem_gil65xp6ec(ctx)
{
var curHost = document.location.host;
if (ctx.href)
{
if ((ctx.protocol != null &&
ctx.protocol.toLowerCase() == 'javascript:') ||
(ctx.host !=null && curHost == ctx.host) ||
(ctx.hostname != null && curHost == ctx.hostname))
return true;
else
return false;
}
return true;
}
function oem_csc4p6e1()
{
document.cookie = 'ORACLE_SMP_CHRONOS_LT=x;path=/';
document.cookie = 'ORACLE_SMP_CHRONOS_ST=x;path=/';
}
function oem_onUL5qb812(evt)
{
decr_pC5qb812();
if (orig_onUL5qb812)
return orig_onUL5qb812(evt);
}
function oem_onL4p6e1(evt)
{
var retVal = true;
if (oem_isIE5qb812 && orig_onL4p6e1)
{
window.onload=orig_onL4p6e1;
retVal =  orig_onL4p6e1(evt);
}
if (oem_isNS45pu382 && orig_onL4p6e1)
{
window.onload=orig_onL4p6e1;
retVal = orig_onL4p6e1(evt);
}
incr_pC5qb812();
if (oem_so4p6e1 == false)
{
for (var i=0; i < document.links.length; i++)
{ var m_l = document.links[i];
if (m_l.onclick)
{
if (m_l.onclick.toString() !=
oem_onS5qb812.toString())
{
m_l.orig_onS5qb812 = m_l.onclick;
}
}
m_l.onclick = oem_onS5qb812;
}
}
for (var x=0; x < document.forms.length; x++)
{
var m_f = document.forms[x];
if (m_f.onsubmit)
{
if (m_f.onsubmit.toString() !=
oem_onS5qb812.toString())
{
m_f.orig_onS5qb812 = m_f.onsubmit;
}
}
m_f.onsubmit = oem_onS5qb812;
}
img = new Image();
var pC5qb812  = get_pC5qb812();
var fC45pu382 = get_fC45pu382();
var fdone = (pC5qb812 >= fC45pu382);
var pg2Report = "-";
if ((top.oem_dne45pu382 == null || top.oem_dne45pu382 == false) && fC45pu382 > 1)
pg2Report = top.location;
top.oem_dne45pu382 = top.oem_dne45pu382?top.oem_dne45pu382:fdone;
var d = new Date();
document.cookie = 'ORACLE_SMP_CHRONOS_LT=' + d.getTime()+';path=/';
img.src =
'/oracle_smp_chronos/oracle_smp_chronos.gif?ORACLE_SMP_CHRONOS='+
new Date().getTime()+ '|' + top.oem_dne45pu382 + '|' + pg2Report;
if (!fdone)
{
return;
}
window.setTimeout("oem_csc4p6e1()",500);
return retVal;
}
function oem_onS5qb812(evt)
{
if (oem_gil65xp6ec(this))
{
var d = new Date();
document.cookie = 'ORACLE_SMP_CHRONOS_ST=' + d.getTime()+ '?' +
document.location +';path=/';
}
if (oem_isNS45pu382)
{
if (oem_isNS45pu3826)
{
if (this.orig_onS5qb812)
return this.orig_onS5qb812(evt);
}
if (evt.target.orig_onS5qb812)
return evt.target.orig_onS5qb812(evt);
}
if (oem_isIE5qb812)
{ if (this.orig_onS5qb812)
return this.orig_onS5qb812();
}
return true;
}
function get_fnn5qb812(f)
{
var s = f.toString().match(/function (\w*)/)[1];
if ((s==null) || (s.length == 0)) return "anonymous";
return s;
}
function get_st45pu382()
{
var s = "";
for (var a= arguments.caller; a!=null; a=a.caller)
{
if (s=="")
s = ":";
else
s+= get_fnn5qb812(a.callee) + ":"
if (a.caller == a) break;
}
return s;
}
function oem_onEr65xp6ec(msg, url, line)
{
var stack_str = get_st45pu382();
if (stack_str.indexOf("oem_etrypt45pu382") != -1)
{
oem_screrr65xp6ec = true;
window.onerror = orig_onEr65xp6ec;
return true;
}
if (orig_onEr65xp6ec)
return orig_onEr65xp6ec(msg, url, line);
return false;
}
function oem_isbrok45pu382()
{
var nav = navigator.appName;
var ms  = nav.indexOf("Microsoft");
var ns  = nav.indexOf("Netscape");
var ver = navigator.appVersion;
var major = ver.charAt(0);
if(ns > -1 )
{ if (major >= 5)
{
oem_isNS45pu382 = true;
oem_isNS45pu3826 = true;
return true;
}
else if (major >= 4)
{
oem_isNS45pu382 = true;
return true;
}
}
if(ms > -1 && major >= 4)
{
oem_isIE5qb812 = true;
return true;
}
return false;
}
function oem_etrypt45pu382()
{
oem_scrld45pu382 = true;
if (window.onerror)
{
if (window.onerror.toString() !=  oem_onEr65xp6ec.toString())
{
orig_onEr65xp6ec = window.onerror;
}
}
window.onerror = oem_onEr65xp6ec;
top.oem_tstop45pu382 = true;
if (oem_screrr65xp6ec == true)
{
return;
}
if (window.onload)
{
if (window.onload.toString() !=  oem_onL4p6e1.toString())
{
orig_onL4p6e1 = window.onload;
}
}
if (window.onunload)
{
if (window.onunload.toString() !=  oem_onUL5qb812.toString())
{
orig_onUL5qb812 = window.onunload;
}
}
window.onload   = oem_onL4p6e1;
window.onunload = oem_onUL5qb812;
}
if (oem_isbrok45pu382())
{
if (!oem_scrld45pu382)
oem_etrypt45pu382();
}
//-->
