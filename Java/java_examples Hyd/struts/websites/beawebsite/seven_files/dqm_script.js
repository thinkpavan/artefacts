q18=0;q19=new Array();

dh=DQM_divider_height;
q61 =false;
if (navigator.userAgent.indexOf("Opera") != -1)
	var opera=true;
ns=navigator.appName==("Netscape");
ns4=(ns &&(navigator.appVersion.indexOf("4.")!=-1));
mac=(navigator.appVersion.indexOf("Mac")!=-1);
ie=(navigator.appName.toLowerCase().indexOf("microsoft")>-1);
ie5=(navigator.appVersion.toLowerCase().indexOf("msie 5.")!=-1);
ie6=(navigator.appVersion.toLowerCase().indexOf("msie 6.")!=-1);
ie4=((ie)&&(!ie5)&&(!ie6));
ns5=(navigator.vendor==("Netscape6")|| navigator.product==("Gecko"));
if((ns5)||(ie6)||(ie4))
	ie5=true;
	ie5only=((ie5)&&(!ns5)&&(!mac));
	(ie5only)? brn="ie":brn="ns";
	if((ns5)||((ie5)&&(mac)))
		brn="ns6";
	if(opera)
		brn="opera";
	document.write("<script language=\"JavaScript1.2\" src=\""+DQM_codebase+"dqm_"+brn+".js\"></script>");
	document.close();;

function DQM_handleOnload(){
	if(q61)
		return;
	q31();
	if(!ie5only){
		i=0;
		while(eval("window.DQM_rollover_image"+i)){
			q20=q20.concat(new Array(new Image()));
			q20[i].src=eval("DQM_rollover_image"+i);
			q21=q21.concat(new Array(q16("menu"+i).src));
			i++;
		}
	}
	q61=true;
	eval(DQM_onload_statement);
};

function q27(nid){
	if(eval("window.DQM_rollover_image"+nid)){
		if(ie5only)
			eval("q16(qmim"+nid+")."+q59);
		else q16("menu"+nid).src=q21[nid];}
};

function q30(menu){if((menu.lasthl!=null)&&(menu.q60==null))q4(menu);};

function q31(){for(i=0;i<q18;i++){if(eval("window.DQM_subdesc"+i+"_0"))q1(i,true);}for(i=0;i<q19.length;i++)q1(q19[i],false);};

function q32(index){

	if(!eval("window.DQM_url"+index))
		return;

	if(eval("window.DQM_urltarget"+index))
		where=eval("DQM_urltarget"+index);
	else where=DQM_urltarget;

	var currUrl = eval("DQM_url" + index);

	if((where.length<1)||(where.toLowerCase()=="_self")){
		window.location.href=eval("DQM_url"+index);
	} else {
		if(where.toLowerCase().indexOf("_parent")>-1) {
			eval("parent.window.location=DQM_url"+index);
		} else  if(where.toLowerCase().indexOf("_new")<0) {
			eval("parent."+where+".location=DQM_url"+index);
		} else {
			window.open(eval("DQM_url"+index));
		}
	}
	logCTT(currUrl);
};

function q33(coords){
	var q72=new Array(0,0);
	var txy=coords.indexOf(",");
	if(txy!=-1){
		q72[0]=parseInt(coords.substring(0,txy));
		q72[1]=parseInt(coords.substring(txy+1));
	}
	return q72;
};

function getLevelVal(id,endv,rt){
	level=0;k=0;
	while((k=id.indexOf("_",k+1))>-1)
		level++;
		if(eval("window.DQM_border"+endv+level))
			return eval("DQM_border"+endv+level);
		else return rt;
}

