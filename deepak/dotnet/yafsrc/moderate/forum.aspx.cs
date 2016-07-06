using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace yaf.moderate
{
	/// <summary>
	/// Summary description for _default.
	/// </summary>
	public class forum : BasePage
	{
		protected Repeater List;
		protected controls.PageLinks PageLinks;

		private void Page_Load(object sender, System.EventArgs e)
		{
			if(!IsModerator || !ForumModeratorAccess) Response.Redirect(BaseDir);

			if(!IsPostBack) 
			{
				PageLinks.AddLink(ForumName,BaseDir);
				PageLinks.AddLink(GetText("MODERATE_DEFAULT","TITLE"),String.Format("{0}moderate/",BaseDir));
				PageLinks.AddLink(PageForumName,Request.RawUrl);
				BindData();
			}
		}

		protected void Delete_Load(object sender, System.EventArgs e) 
		{
			((LinkButton)sender).Attributes["onclick"] = String.Format("return confirm('{0}')",GetText("MODERATE_FORUM","ASK_DELETE"));
		}

		private void BindData() 
		{
			List.DataSource = DB.message_unapproved(PageForumID);
			DataBind();
		}

		protected string FormatMessage(DataRowView row) 
		{
			string msg = row["Message"].ToString();
			
			if(msg.IndexOf('<')>=0)
				return msg;

			return FormatMsg.ForumCodeToHtml(this,row["Message"].ToString());
		}

		private void List_ItemCommand(object sender,RepeaterCommandEventArgs e) 
		{
			switch(e.CommandName.ToLower()) 
			{
				case "approve":
					DB.message_approve(e.CommandArgument);
					BindData();
					AddLoadMessage(GetText("MODERATE_FORUM","APPROVED"));
					Utils.CreateWatchEmail(this,e.CommandArgument);
					break;
				case "delete":
					DB.message_delete(e.CommandArgument);
					BindData();
					AddLoadMessage(GetText("MODERATE_FORUM","DELETED"));
					break;
			}
		}

		#region Web Form Designer generated code
		override protected void OnInit(EventArgs e)
		{
			List.ItemCommand += new RepeaterCommandEventHandler(List_ItemCommand);
			//
			// CODEGEN: This call is required by the ASP.NET Web Form Designer.
			//
			InitializeComponent();
			base.OnInit(e);
		}
		
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{    
			this.Load += new System.EventHandler(this.Page_Load);
		}
		#endregion
	}
}
