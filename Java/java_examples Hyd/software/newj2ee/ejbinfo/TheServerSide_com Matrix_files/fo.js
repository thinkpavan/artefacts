//  Copyright (c) 2000-2004 ZEDO Inc. All Rights Reserved.
function U2(){
var n2=navigator.userAgent.toLowerCase();var i6=(n2.indexOf('mac')!=-1);var z6=(!i6&&(n2.indexOf('msie 5')!=-1)||(n2.indexOf('msie 6')!=-1));
document.writeln('<scr'+'ipt language=VBS'+'cript>');
document.writeln('on error resume next');
document.writeln('r0=IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.5"))');
document.writeln('if(r0<=0)then r0=IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.4"))');
document.writeln('</scr'+'ipt>');
var x3=navigator.javaEnabled();
c0=1;
if(x3){c0 |=4;}
if(r0){c0 |=8;}
if(z6){
if(document.body){
document.body.style.behavior='url(#default#clientCaps)';
if(document.body.connectionType=='lan'){
c0 |=16;
}}}
return c0;
}
var p0=0;var q0=0;var d0='0';var o0=0;var c4='';var r0=0;var n0='';
if(typeof zflag_nid!='undefined'){
p0=zflag_nid;
zflag_nid=0;
}
if(typeof zflag_sid!='undefined'){
q0=zflag_sid;
zflag_sid=0;
}
if(typeof zflag_cid!='undefined'){
d0=zflag_cid;
zflag_cid=0;
}
if(typeof zflag_sz!='undefined'){
o0=zflag_sz;
zflag_sz=0;
}
if(typeof zflag_kw!='undefined'){
zflag_kw=zflag_kw.replace(/&/g,'zzazz');
c4=escape(zflag_kw);
zflag_kw="";
}
var zzStr='';var zzCountry=255;var zzMetro=0;var zzState=0;var zzSection=q0;var zzD=window.document;var zzRand=(Math.floor(Math.random()* 1000000)% 10000);var zzCustom='';
n0=U2();
n0=((o0<<8)|n0);
i0='<scr'+'ipt language="JavaScript" src="http://c7.zedo.com/bar/v10-300/c7/jsc/fm.js?c='+d0+'&n='+p0+'&x='+n0+'&d='+o0+'&q='+c4+'&s='+q0+'&z='+Math.random()+'"></scr'+'ipt>';
document.write(i0);
