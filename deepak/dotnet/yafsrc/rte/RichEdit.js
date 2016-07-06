function RichEdit(name,rich,gecko) {
	this.Name		= name;
	this.DataName	= name + '2';
	this.EditName	= name + '3';
	this.StyleSheet	= null;
	
	if(rich) {
		this.FormatText				= RichEdit_FormatText;
		this.AddImage				= RichEdit_AddImage;
		this.CheckSpell				= RichEdit_CheckSpell;
		this.Update					= RichEdit_Update;
		this.InsertSmiley			= RichEdit_InsertSmiley;
		this.FormatBlock			= RichEdit_FormatBlock;
		this.InsertNodeAtSelection	= RichEdit_InsertNodeAtSelection;
		this.OnEvent				= RichEdit_OnEvent;
		this.UpdateToolBar			= RichEdit_UpdateToolBar;
		this.UpdateTimer			= null;
		if(gecko) {
			this.Initialize			= RichEdit_InitializeGecko;
		} else {
			this.Initialize			= RichEdit_InitializeMSIE;
		}
	} else {
		this.FormatText				= TextArea_FormatText;
		this.AddImage				= TextArea_AddImage;
		this.InsertSmiley			= TextArea_InsertSmiley;
	}
}

function RichEdit_FormatBlock(select) {
	var cursel = select.selectedIndex;
	// First one is always a label
	if (cursel != 0) {
		var cmd = 'formatblock';
		var arg = select.options[cursel].value;
		select.selectedIndex = 0;
		if(arg=='removeformat') {
			cmd = 'removeformat';
			arg = '';
		}
		document.getElementById(this.EditName).contentWindow.document.execCommand(cmd, false, arg);
	}
	document.getElementById(this.EditName).contentWindow.focus();
	this.UpdateToolBar();
}

function Button_Load(img) {
	img.className	= "ButtonOut";
	img.onmouseover	= function(){Button_Over(this);}
	img.onmouseout	= function(){Button_Out(this);}
}

function Button_Over(img) {
	if(typeof(img._enabled)=="boolean" && !img._enabled)
		img.className = "ButtonOff";
	else
		img.className = "ButtonOver";
}

function Button_Out(img) {
	if(typeof(img._enabled)=="boolean" && !img._enabled)
		img.className = "ButtonOff";
	else if(typeof(img._selected)=="boolean" && img._selected)
		img.className = "ButtonChecked";
	else
		img.className = "ButtonOut";
}

function Button_SetState(doc,name,cmd) {
	var img = document.getElementById(name);
	try {
		img._selected = doc.queryCommandState(cmd);
	}
	catch(e) {
		img._selected = false;
	}
	img._enabled	= doc.queryCommandEnabled(cmd);

	if(!img._enabled)
		img.className = "ButtonOff";
	else if(img._selected)
		img.className = "ButtonChecked";
	else
		img.className = "ButtonOut";
}

function RichEdit_UpdateToolBar() {
	var doc = document.getElementById(this.EditName).contentWindow.document;
	Button_SetState(doc,this.Name+"_bold","bold");
	Button_SetState(doc,this.Name+"_italic","italic");
	Button_SetState(doc,this.Name+"_underline","underline");
	Button_SetState(doc,this.Name+"_justifyleft","justifyleft");
	Button_SetState(doc,this.Name+"_justifycenter","justifycenter");
	Button_SetState(doc,this.Name+"_justifyright","justifyright");
	Button_SetState(doc,this.Name+"_insertorderedlist","insertorderedlist");
	Button_SetState(doc,this.Name+"_insertunorderedlist","insertunorderedlist");
	Button_SetState(doc,this.Name+"_outdent","outdent");
	Button_SetState(doc,this.Name+"_indent","indent");

	var obj = document.getElementById(this.Name+'_formatblock');
	obj.selectedIndex = 0;
	var val = doc.queryCommandValue('formatblock');
	for(var i=0;i<obj.options.length;i++) {
		if(obj.options[i].value=='<'+val+'>') {
			obj.selectedIndex = i;
			break;
		}
	}

	this.UpdateTimer = null;
}

function RichEdit_OnEvent() {
	if(this.UpdateTimer)
		clearTimeout(this.UpdateTimer);
	
	this.UpdateTimer = setTimeout(this.Name + ".UpdateToolBar()",50);
}

function testevt(evt,name) {
	eval(name + '.OnEvent()');
}

function RichEdit_InitializeGecko() {
	document.getElementById(this.EditName).contentDocument.designMode = 'on';
	var editName = this.EditName;
	var thisName = this.Name;
	// This one crashes Firebird at times... no idea why
	setTimeout(function(){
		document.getElementById(editName).contentWindow.document.execCommand("useCSS", false, true);
		eval(thisName+".UpdateToolBar()");
	},500);
	
	with(document.getElementById(this.EditName).contentWindow.document) {
		open();
		write("<html><head>");
		if(this.StyleSheet)
			write("<link type='text/css' rel='stylesheet' href='" + this.StyleSheet + "' />");
		write("</head><body>");
		write(document.getElementById(this.DataName).value);
		write("</body></html>");
		close();

		var thisName = this.Name;		
		addEventListener("keydown", function(evt){testevt(evt,thisName);}, true);
		addEventListener("keypress", function(evt){testevt(evt,thisName);}, true);
		addEventListener("mousedown", function(evt){testevt(evt,thisName);}, true);
		addEventListener("mouseup", function(evt){testevt(evt,thisName);}, true);
		addEventListener("drag", function(evt){testevt(evt,thisName);}, true);
	}
}

function RichEdit_InitializeMSIE() {
	document.getElementById(this.EditName).contentWindow.document.designMode = 'On';
	with(document.getElementById(this.EditName).contentWindow.document) {
		open();
		write("<html><head>");
		write("<link type='text/css' rel='stylesheet' href='theme.css' />");
		write("</head><body>");
		write(document.getElementById(this.DataName).value);
		write("</body></html>");
		close();

		var thisName = this.Name;		
		attachEvent("onkeydown", function(evt){testevt(evt,thisName);});
		attachEvent("onkeypress", function(evt){testevt(evt,thisName);});
		attachEvent("onmousedown", function(evt){testevt(evt,thisName);});
		attachEvent("onmouseup", function(evt){testevt(evt,thisName);});
		attachEvent("ondrag", function(evt){testevt(evt,thisName);});
	}
	this.UpdateToolBar();
}

function RichEdit_Update() {
	document.getElementById(this.DataName).value = document.getElementById(this.EditName).contentWindow.document.body.innerHTML;
}

function RichEdit_FormatText(command, option) {
	try {
		if (command == "createlink") {
			var szURL = prompt("Enter a URL:", "");
			
			var sztemp = szURL.toLowerCase();
			var i = sztemp.indexOf("http://");
			if(i<0) i = sztemp.indexOf("ftp://");
			
			if(i==-1)
				szURL = "http://" + szURL;
			
			document.getElementById(this.EditName).contentWindow.document.execCommand("Unlink",false,null)
			document.getElementById(this.EditName).contentWindow.document.execCommand("CreateLink",false,szURL)
		} else {
			document.getElementById(this.EditName).contentWindow.focus();
	  		document.getElementById(this.EditName).contentWindow.document.execCommand(command, false, option);
			document.getElementById(this.EditName).contentWindow.focus();
		}
		this.UpdateToolBar();
	}
	catch(e) {
		alert(e);
	}
}

function RichEdit_AddImage() {
	imagePath = prompt('Enter Image URL:', 'http://');				
	if ((imagePath != null) && (imagePath != "")) {
		document.getElementById(this.EditName).contentWindow.focus()
		document.getElementById(this.EditName).contentWindow.document.execCommand('InsertImage', false, imagePath);
	}
	document.getElementById(this.EditName).contentWindow.focus()
}

function RichEdit_CheckSpell() {
	try {
		var tmpis = new ActiveXObject("ieSpell.ieSpellExtension");
		tmpis.CheckAllLinkedDocuments(document);
	}
	catch(exception) {
		if(exception.number==-2146827859) {
			if (confirm("ieSpell not detected. Click Ok to go to download page."))
				window.open("http://www.iespell.com/download.php","DownLoad");
		}
		else
			alert("Error Loading ieSpell:\n\n" + exception);
	}
}

function RichEdit_InsertSmiley(code) {
	document.getElementById(this.EditName).contentWindow.focus()
	if(document.selection) {
		var sel = document.getElementById(this.EditName).contentWindow.document.selection;
		var range = sel.createRange();
		range.pasteHTML(code);
	} else {
		this.InsertNodeAtSelection(document.getElementById(this.EditName).contentWindow,document.createTextNode(code));
	}
}

function RichEdit_InsertNodeAtSelection(win, insertNode) {
	// get current selection
	var sel = win.getSelection();

	// get the first range of the selection
	// (there's almost always only one range)
	var range = sel.getRangeAt(0);

	// deselect everything
	sel.removeAllRanges();

	// remove content of current selection from document
	range.deleteContents();

	// get location of current selection
	var container = range.startContainer;
	var pos = range.startOffset;

	// make a new range for the new selection
	range=document.createRange();
	{
		var afterNode;
		if (container.nodeType==3) {
			// when inserting into a textnode
			// we create 2 new textnodes
			// and put the insertNode in between

			var textNode = container;
			container = textNode.parentNode;
			var text = textNode.nodeValue;

			// text before the split
			var textBefore = text.substr(0,pos);
			// text after the split
			var textAfter = text.substr(pos);

			var beforeNode = document.createTextNode(textBefore);
			var afterNode = document.createTextNode(textAfter);

			// insert the 3 new nodes before the old one
			container.insertBefore(afterNode, textNode);
			container.insertBefore(insertNode, afterNode);
			container.insertBefore(beforeNode, insertNode);

			// remove the old node
			container.removeChild(textNode);
		} else {
			// else simply insert the node
			afterNode = container.childNodes[pos];
			container.insertBefore(insertNode, afterNode);
		}

		range.setEnd(afterNode, 0);
		range.setStart(afterNode, 0);
	}
	sel.addRange(range);
}

function TextArea_FormatText(command, option) {
	var textObj = document.getElementById(this.DataName);
	switch(command) {
		case "bold":
			wrapSelection(textObj,"[b]","[/b]");
			break;
		case "italic":
			wrapSelection(textObj,"[i]","[/i]");
			break;
		case "underline":
			wrapSelection(textObj,"[u]","[/u]");
			break;
		case "createlink":
			var url = prompt('Enter URL:','http://');
			if(url!='' && url!=null) {
				if(getSelection(textObj))
					wrapSelection(textObj,'[url="'+url+'"]','[/url]');
				else
					replaceSelection(textObj,'[url]'+url+'[/url]');
			}
			break;
	}
}

function TextArea_AddImage() {
	var textObj = document.getElementById(this.DataName);
	var img = prompt('Enter image URL:','http://');
	if(img!='' && img!=null)
		replaceSelection(textObj,'[img]'+img+'[/img]');
}

function TextArea_InsertSmiley(code) {
	var textObj = document.getElementById(this.DataName);
	replaceSelection(textObj,code);
}

function storeCaret(input) {
	if(input.createTextRange) {
		input.caretPos = document.selection.createRange().duplicate();
	}
}

function setSelectionRange(input, selectionStart, selectionEnd) {
	if (input.setSelectionRange) {
		input.focus();
		input.setSelectionRange(selectionStart, selectionEnd);
	} else if(input.createTextRange) {
		var range = input.createTextRange();
		range.collapse(true);
		range.moveEnd('character', selectionEnd);
		range.moveStart('character', selectionStart);
		range.select();
	}
}

function setCaretToPos (input, pos) {
	setSelectionRange(input, pos, pos);
}

function replaceSelection (input, replaceString) {
	if (input.setSelectionRange) {
		var selectionStart = input.selectionStart;
		var selectionEnd = input.selectionEnd;
		input.value = input.value.substring(0, selectionStart)
					+ replaceString
					+ input.value.substring(selectionEnd);
		if (selectionStart != selectionEnd) // has there been a selection
			setSelectionRange(input, selectionStart, selectionStart + 
				replaceString.length);
		else // set caret
			setCaretToPos(input, selectionStart + replaceString.length);
	} else if (document.selection) {
		if(input.caretPos) {
			var caretPos = input.caretPos;
			caretPos.text = caretPos.text.charAt(caretPos.text.length - 1) == ' ' ? text + ' ' : replaceString;
			if(caretPos.text!='') {
				caretPos.moveStart('character', -replaceString.length);
				caretPos.select();
			}
		} else {
			input.value += replaceString;
		}
	} else {
		input.value += replaceString;
		input.focus();
	}
}

function wrapSelection (input, preString, postString) {
	if (input.setSelectionRange) {
		var selectionStart = input.selectionStart;
		var selectionEnd = input.selectionEnd;
		input.value = input.value.substring(0, selectionStart)
					+ preString
					+ input.value.substring(selectionStart,selectionEnd)
					+ postString
					+ input.value.substring(selectionEnd);
		if (selectionStart != selectionEnd) // has there been a selection
			setSelectionRange(input, selectionStart, preString.length + postString.length + selectionEnd);
		else // set caret
			setCaretToPos(input, selectionStart + replaceString.length);
	} else if (document.selection) {
		if(input.caretPos) {
			var caretPos = input.caretPos;
			var isCollapsed = caretPos.text == '';
			var len = preString.length + caretPos.text.length + postString.length;
			caretPos.text = preString + caretPos.text + postString;
			if(!isCollapsed) {
				caretPos.moveStart('character', -len);
				caretPos.select();
			}
		} else {
			input.value += preString + postString;
		}
	} else {
		input.value += preString + postString;
		input.focus();
	}
}

function getSelection(input) {
	if(input.setSelectionRange) {
		return input.selectionStart != input.selectionEnd;
	} else if(document.selection) {
		var range = document.selection.createRange();
		return range.parentElement()==input && range.text!='';
	} else {
		return false;
	}
}
