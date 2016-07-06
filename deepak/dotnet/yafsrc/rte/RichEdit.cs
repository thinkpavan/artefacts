using System;
using System.Data;
using System.Drawing;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace yaf
{
	/// <summary>
	/// Summary description for RichEdit.
	/// </summary>
	public class RichEdit : Control
	{
		private string	m_text				= string.Empty;
		private	string	m_baseDir			= string.Empty;
		private	bool	m_enableRichEdit	= true;
		private	bool	m_isRichMSIE		= false;
		private bool	m_isRichGecko		= false;
		private	bool	m_detected			= false;
		private	string	m_styleSheet		= string.Empty;

		private string SafeID
		{
			get
			{
				return UniqueID.Replace(":","_");
			}
		}

		public new string ResolveUrl(string relativeUrl)
		{
			if(m_baseDir!=string.Empty)
				return m_baseDir + relativeUrl;
			else
				return base.ResolveUrl(relativeUrl);
		}

		private void RenderButton(HtmlTextWriter writer,string id,string cmd,string title,string image)
		{
			writer.WriteLine("		<td><img id='{1}_{4}' onload='Button_Load(this)' src='{0}' width='21' height='20' alt='{2}' title='{2}' onclick=\"{1}.{3}\"></td>",ResolveUrl(image),SafeID,title,cmd,id);
		}

		protected override void Render(HtmlTextWriter writer)
		{
			writer.WriteLine("");
			if(IsRichBrowser)
				writer.WriteLine("<input type='hidden' id='{0}2' name='{0}2' value='{1}'/>",SafeID,Page.Server.HtmlEncode(m_text).Replace("'","&#39"));
			writer.WriteLine("<script language='javascript'>");
			writer.WriteLine("var {0}=new RichEdit('{0}',{1},{2});",SafeID,IsRichBrowser.ToString().ToLower(),IsRichGecko.ToString().ToLower());
			if(m_styleSheet!=string.Empty)
				writer.WriteLine("{0}.StyleSheet = '{1}';",SafeID,m_styleSheet);
			writer.WriteLine("</script>");

			writer.WriteLine("<table border='0' cellpadding='0' cellspacing='2' width='100%' height='300'>");
			writer.WriteLine("<tr><td valign='top'>");
			writer.WriteLine("	<table border='0' cellpadding='1' cellspacing='0'>");
			writer.WriteLine("	<tr>");

			writer.WriteLine("			<td><select id='{0}_formatblock' onchange='{0}.FormatBlock(this)'>",SafeID);
			writer.WriteLine("				<option value='<p>'>Normal</option>");
			writer.WriteLine("				<option value='<pre>'>Formatted</option>");
			writer.WriteLine("				<option value='<p>'>Paragraph</option>");
			writer.WriteLine("				<option value='<h1>'>Heading 1</option>");
			writer.WriteLine("				<option value='<h2>'>Heading 2</option>");
			writer.WriteLine("				<option value='<h3>'>Heading 3</option>");
			writer.WriteLine("				<option value='<h4>'>Heading 4</option>");
			writer.WriteLine("				<option value='<h5>'>Heading 5</option>");
			writer.WriteLine("				<option value='<h6>'>Heading 6</option>");
			writer.WriteLine("				<option value='<address>'>Address</option>");
			writer.WriteLine("				<option value='removeformat'>Remove Formatting</option>");
			writer.WriteLine("			</select></td>");
			writer.WriteLine("			<td>&nbsp;</td>");
			RenderButton(writer,"bold","FormatText('bold','')","Bold","images/bold.gif");
			RenderButton(writer,"italic","FormatText('italic','')","Italic","images/italic.gif");
			RenderButton(writer,"underline","FormatText('underline','')","Underline","images/underline.gif");
			if(IsRichBrowser)
			{
				writer.WriteLine("		<td>&nbsp;</td>");
				RenderButton(writer,"justifyleft","FormatText('justifyleft','')","Justify Left","images/justifyleft.gif");
				RenderButton(writer,"justifycenter","FormatText('justifycenter','')","Justify Center","images/justifycenter.gif");
				RenderButton(writer,"justifyright","FormatText('justifyright','')","Justify Right","images/justifyright.gif");
				writer.WriteLine("		<td>&nbsp;</td>");
				RenderButton(writer,"insertorderedlist","FormatText('insertorderedlist','')","Ordered List","images/orderedlist.gif");
				RenderButton(writer,"insertunorderedlist","FormatText('insertunorderedlist','')","Unordered List","images/unorderedlist.gif");
				writer.WriteLine("		<td>&nbsp;</td>");
				RenderButton(writer,"outdent","FormatText('outdent','')","Outdent","images/outdent.gif");
				RenderButton(writer,"indent","FormatText('indent','')","Indent","images/indent.gif");
			}
			writer.WriteLine("		<td>&nbsp;</td>");
			RenderButton(writer,"link","FormatText('createlink','')","Link","images/link.gif");
			RenderButton(writer,"image","AddImage()","Image","images/image.gif");
			if(IsRichMSIE)
				RenderButton(writer,"spell","CheckSpell()","Spell Check","images/spellcheck.gif");
			writer.WriteLine("	</tr>");
			writer.WriteLine("	</table>");
			writer.WriteLine("</td></tr><tr><td height='99%'>");
			if(IsRichBrowser)
				writer.WriteLine("	<iframe id='{0}3' width='100%' height='100%' style='background-color:window;border:1px solid #7F9DB9' frameborder='no'></iframe>",SafeID);
			else
				writer.WriteLine("	<textarea name='{0}2' id='{0}2' style='width:100%;height:100%' onkeyup='storeCaret(this)' onclick='storeCaret(this)' onchange='storeCaret(this)' onselect='storeCaret(this)'>{1}</textarea>",SafeID,Page.Server.HtmlEncode(m_text).Replace("'","&#39"));
			writer.WriteLine("</td></tr></table>");

			// scripts
			if(IsRichBrowser)
			{
				writer.WriteLine("<script language='javascript'>");
				writer.WriteLine("{0}.Initialize();",SafeID);
				// Make sure we save text when calling __doPostBack
				writer.WriteLine("{0}.PostBack = __doPostBack;",SafeID);
				writer.WriteLine("__doPostBack=function(eventTarget,eventArgument) {");
				writer.WriteLine("	{0}.Update();",SafeID);
				writer.WriteLine("	{0}.PostBack(eventTarget,eventArgument);",SafeID);
				writer.WriteLine("}");
				writer.WriteLine("</script>");
			}
		}

		protected override void OnInit(EventArgs e)
		{
			Load += new EventHandler(RichEdit_Load);
			base.OnInit(e);
		}

		private void RichEdit_Load(object sender,EventArgs e)
		{
			BrowserDetectLite();

			if(Page.IsPostBack)
			{
				m_text = Page.Request[string.Format("{0}2",SafeID)];
			}

			if(this.Visible)
			{
				Page.RegisterClientScriptBlock("richeditstyles",
					"<style>\n"+
					".ButtonOut\n"+
					"{\n"+
					"	filter: alpha(opacity=70);\n"+
					"	border: #7F9DB9 1px solid;\n"+
					"}\n"+
					".ButtonOver\n"+
					"{\n"+
					"	background-color: #FFE1AC;\n"+
					"	border: #FFAD55 1px solid;\n"+
					"}\n"+
					".ButtonChecked\n"+
					"{\n"+
					"	background-color: #FFCB7E;\n"+
					"	border: #FFAD55 1px solid;\n"+
					"}\n"+
					".ButtonOff\n"+
					"{\n"+
					"	filter: gray() alpha(opacity=30);\n"+
					"	background-color: #C0C0C0;\n"+
					"	border: #7F9DB9 1px solid;\n"+
					"}\n"+
					"</style>\n");
				
				Page.RegisterClientScriptBlock("richeditjs",string.Format("<script language='javascript' src='{0}'></script>",ResolveUrl("richedit.js")));
				if(IsRichBrowser)
				{
					Page.RegisterOnSubmitStatement(SafeID + "_submit",string.Format("{0}.Update();",SafeID));
					// Force __doPostBack function to avoid js error
					Page.GetPostBackClientHyperlink(this,"");
				}

				Page.RegisterClientScriptBlock("insertsmiley",
					"<script language='javascript'>\n"+
					"function insertsmiley(code) {\n"+
					"	" + SafeID + ".InsertSmiley(code);\n"+
					"}\n"+
					"</script>\n");
			}
		}

		#region Properties
		public string Text
		{
			get
			{
				if(Page.IsPostBack)
					return Page.Request[string.Format("{0}2",SafeID)];
				else
					return m_text;
			}
			set
			{
				m_text = value;
			}
		}
		public bool IsRichMSIE
		{
			get
			{
				BrowserDetectLite();
				return m_enableRichEdit && m_isRichMSIE;
			}
		}
		public bool IsRichGecko
		{
			get
			{
				BrowserDetectLite();
				return m_enableRichEdit && m_isRichGecko;
			}
		}
		public bool IsRichBrowser
		{
			get
			{
				BrowserDetectLite();
				return m_enableRichEdit && (m_isRichGecko || m_isRichMSIE);
			}
		}
		public bool EnableRTE
		{
			set
			{
				m_enableRichEdit = value;
			}
			get
			{
				return m_enableRichEdit;
			}
		}
		public string BaseDir
		{
			set
			{
				m_baseDir = value;
				if(!m_baseDir.EndsWith("/"))
					m_baseDir += "/";
			}
		}
		public string StyleSheet
		{
			set
			{
				m_styleSheet = value;
			}
		}
		#endregion

		#region Browser Detection
		private void BrowserDetectLite() 
		{
			if(!m_enableRichEdit || m_detected)
				return;

			int pos;
			string ua = Page.Request.UserAgent.ToLower();

			m_isRichGecko = false;
			m_isRichMSIE = false;
			
			pos = ua.IndexOf("gecko/");
			if(pos>=0) 
			{
				string gecko = ua.Substring(pos+6,8);
#if true
				// Enable rich edit for anything Gecko after October 1st, 2003
				m_isRichGecko = gecko.CompareTo("20031001")>=0;
#else
				if(ua.IndexOf("firebird")>=0)
					// Firebird got Midas later?
					m_isRichGecko = gecko.CompareTo("20030210")>=0;
				else
					m_isRichGecko = gecko.CompareTo("20030210")>=0;
#endif
			} 
			pos = ua.IndexOf("msie ");
			if(pos>=0 && ua.IndexOf("opera")<0 && ua.IndexOf("webtv")<0) 
			{
				m_isRichMSIE = Page.Request.Browser.MajorVersion>=5;
			}
			m_detected = true;
		}
		#endregion
	}
}
