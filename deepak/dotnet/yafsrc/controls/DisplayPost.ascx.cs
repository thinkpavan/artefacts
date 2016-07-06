namespace yaf.controls
{
	using System;
	using System.Data;
	using System.Drawing;
	using System.Web;
	using System.Web.UI.WebControls;
	using System.Web.UI.HtmlControls;

	/// <summary>
	///		Summary description for DisplayPost.
	/// </summary>
	public class DisplayPost : BaseUserControl
	{
		protected HyperLink		Attach, Edit, Quote;
		protected LinkButton	Delete;
		protected HyperLink		Pm, Home, Yim, Aim, Icq, Email, Msn, Blog;

		private void Page_Load(object sender, System.EventArgs e)
		{
			if(!IsPostBack || true) 
			{
			}
		}
		private void DisplayPost_PreRender(object sender,EventArgs e)
		{
			Attach.Visible		= CanAttach;
			Attach.Text			= ForumPage.GetThemeContents("BUTTONS","ATTACHMENTS");
			Attach.ToolTip		= "Attachments";
			Attach.NavigateUrl	= Forum.GetLink(Pages.attachments,"m={0}",DataRow["MessageID"]);
			Edit.Visible		= CanEditPost;
			Edit.Text			= ForumPage.GetThemeContents("BUTTONS","EDITPOST");
			Edit.ToolTip		= "Edit this post";
			Edit.NavigateUrl	= Forum.GetLink(Pages.postmessage,"m={0}",DataRow["MessageID"]);
			Delete.Visible		= CanDeletePost;
			Delete.Text			= ForumPage.GetThemeContents("BUTTONS","DELETEPOST");
			Delete.ToolTip		= "Delete this post";
			Delete.Attributes["onclick"] = string.Format("return confirm('{0}')",ForumPage.GetText("confirm_deletemessage"));
			Quote.Visible		= CanReply;
			Quote.Text			= ForumPage.GetThemeContents("BUTTONS","QUOTEPOST");
			Quote.ToolTip		= "Reply with quote";
			Quote.NavigateUrl	= Forum.GetLink(Pages.postmessage,"t={0}&f={1}&q={2}",ForumPage.PageTopicID,ForumPage.PageForumID,DataRow["MessageID"]);

			Pm.Visible			= ForumPage.User.IsAuthenticated && ForumPage.User.IsAuthenticated;
			Pm.Text				= ForumPage.GetThemeContents("BUTTONS","PM");
			Pm.NavigateUrl		= Forum.GetLink(Pages.pmessage,"u={0}",DataRow["UserID"]);
			Email.Visible		= ForumPage.User.IsAuthenticated;
			Email.NavigateUrl	= Forum.GetLink(Pages.im_email,"u={0}",DataRow["UserID"]);
			Email.Text			= ForumPage.GetThemeContents("BUTTONS","EMAIL");
			Home.Visible		= DataRow["HomePage"]!=DBNull.Value;
			Home.NavigateUrl	= DataRow["HomePage"].ToString();
			Home.Text			= ForumPage.GetThemeContents("BUTTONS","WWW");
			Blog.Visible		= DataRow["Weblog"]!=DBNull.Value;
			Blog.NavigateUrl	= DataRow["Weblog"].ToString();
			Blog.Text			= ForumPage.GetThemeContents("BUTTONS","WEBLOG");
			Msn.Visible			= ForumPage.User.IsAuthenticated && DataRow["MSN"]!=DBNull.Value;
			Msn.Text			= ForumPage.GetThemeContents("BUTTONS","MSN");
			Msn.NavigateUrl		= Forum.GetLink(Pages.im_email,"u={0}",DataRow["UserID"]);
			Yim.Visible			= ForumPage.User.IsAuthenticated && DataRow["YIM"]!=DBNull.Value;
			Yim.NavigateUrl		= Forum.GetLink(Pages.im_yim,"u={0}",DataRow["UserID"]);
			Yim.Text			= ForumPage.GetThemeContents("BUTTONS","YAHOO");
			Aim.Visible			= ForumPage.User.IsAuthenticated && DataRow["AIM"]!=DBNull.Value;
			Aim.Text			= ForumPage.GetThemeContents("BUTTONS","AIM");
			Aim.NavigateUrl		= Forum.GetLink(Pages.im_aim,"u={0}",DataRow["UserID"]);
			Icq.Visible			= ForumPage.User.IsAuthenticated && DataRow["ICQ"]!=DBNull.Value;
			Icq.Text			= ForumPage.GetThemeContents("BUTTONS","ICQ");
			Icq.NavigateUrl		= Forum.GetLink(Pages.im_icq,"u={0}",DataRow["UserID"]);
		}

		override protected void OnInit(EventArgs e)
		{
			this.Load += new System.EventHandler(this.Page_Load);
			this.PreRender += new EventHandler(DisplayPost_PreRender);
			Delete.Click += new EventHandler(Delete_Click);
			base.OnInit(e);
		}

		private DataRowView	m_row = null;
		public DataRowView DataRow
		{
			get
			{
				return m_row;
			}
			set
			{
				m_row = value;
			}
		}

		protected bool CanEditPost
		{
			get
			{
				return !(bool)DataRow["ForumLocked"] && !(bool)DataRow["TopicLocked"] && ((int)DataRow["UserID"]==ForumPage.PageUserID || ForumPage.ForumModeratorAccess) && ForumPage.ForumEditAccess;
			}
		}

		protected bool CanAttach
		{
			get
			{
				return !(bool)DataRow["ForumLocked"] && !(bool)DataRow["TopicLocked"] && ((int)DataRow["UserID"]==ForumPage.PageUserID || ForumPage.ForumModeratorAccess) && ForumPage.ForumUploadAccess;
			}
		}

		protected bool CanDeletePost
		{
			get
			{
				return !(bool)DataRow["ForumLocked"] && !(bool)DataRow["TopicLocked"] && ((int)DataRow["UserID"]==ForumPage.PageUserID || ForumPage.ForumModeratorAccess) && ForumPage.ForumDeleteAccess;
			}
		}
		protected bool CanReply
		{
			get
			{
				return !(bool)DataRow["ForumLocked"] && !(bool)DataRow["TopicLocked"] && ForumPage.ForumReplyAccess;
			}
		}

		private bool m_isThreaded = false;
		public bool IsThreaded
		{
			get
			{
				return m_isThreaded;
			}
			set
			{
				m_isThreaded = value;
			}
		}

		protected string GetIndentCell() 
		{
			if(!IsThreaded)
				return "";

			int iIndent = (int)DataRow["Indent"];
			if(iIndent>0)
				return string.Format("<td rowspan='3' width='1%'><img src='{1}images/spacer.gif' width='{0}' height='2'/></td>",iIndent*32,Data.ForumRoot);
			else
				return "";
		}
		protected string GetIndentSpan() 
		{
			if(!IsThreaded || (int)DataRow["Indent"]==0)
				return "2";
			else
				return "1";
		}

		protected string FormatUserBox() 
		{
			System.Data.DataRowView row = DataRow;
			string html = "";

			// Avatar
			if(Config.BoardSettings.AvatarUpload && row["HasAvatarImage"]!=null && long.Parse(row["HasAvatarImage"].ToString())>0) 
			{
				html += String.Format("<img src='{1}image.aspx?u={0}'><br clear=\"all\"/>",row["UserID"],Data.ForumRoot);
			} 
			else if(Config.BoardSettings.AvatarRemote && row["Avatar"].ToString().Length>0) 
			{
				//html += String.Format("<img src='{0}'><br clear=\"all\"/>",row["Avatar"]);
				html += String.Format("<img src='{3}image.aspx?url={0}&width={1}&height={2}'><br clear=\"all\"/>",
					Server.UrlEncode(row["Avatar"].ToString()),
					Config.BoardSettings.AvatarWidth,
					Config.BoardSettings.AvatarHeight,
					Data.ForumRoot
					);
			}

			// Rank Image
			if(row["RankImage"].ToString().Length>0)
				html += String.Format("<img align=left src=\"{0}images/ranks/{1}\"/><br clear=\"all\"/>",Data.ForumRoot,row["RankImage"]);

			// Rank
			html += String.Format("{0}: {1}<br clear=\"all\"/>",ForumPage.GetText("rank"),row["RankName"]);

			// Groups
			if(Config.BoardSettings.ShowGroups) 
			{
				using(DataTable dt = ForumPage.DataProvider.usergroup_list(yaf.pages.ForumPage.PageBoardID,row["UserID"])) 
				{
					html += String.Format("{0}: ",ForumPage.GetText("groups"));
					bool bFirst = true;
					foreach(DataRow grp in dt.Rows) 
					{
						if(bFirst) 
						{
							html += grp["Name"].ToString();
							bFirst = false;
						} 
						else 
						{
							html += String.Format(", {0}",grp["Name"]);
						}
					}
					html += "<br/>";
				}
			}

			// Extra row
			html += "<br/>";

			// Joined
			html += String.Format("{0}: {1}<br/>",ForumPage.GetText("joined"),ForumPage.FormatDateShort((DateTime)row["Joined"]));

			// Posts
			html += String.Format("{0}: {1:N0}<br/>",ForumPage.GetText("posts"),row["Posts"]);

			// Location
			if(row["Location"].ToString().Length>0)
				html += String.Format("{0}: {1}<br/>",ForumPage.GetText("location"),row["Location"]);

			return html;
		}
		protected string FormatBody() 
		{
			DataRowView row = DataRow;
			string html = row["Message"].ToString();
			bool isHtml = html.IndexOf('<')>=0;
		
			if(long.Parse(row["HasAttachments"].ToString())>0) 
			{
				html += String.Format("<p><b class='smallfont'>{0}</b><br/>",ForumPage.GetText("ATTACHMENTS"));
				string stats = ForumPage.GetText("ATTACHMENTINFO");
				using(DataTable dt = ForumPage.DataProvider.attachment_list(row["MessageID"],null)) 
				{
					foreach(DataRow dr in dt.Rows) 
					{
						int kb = (1023 + (int)dr["Bytes"]) / 1024;
						html += String.Format("<a href=\"{0}image.aspx?a={1}\">{2}</a> <span class='smallfont'>- {3}</span><br/>",Data.ForumRoot,dr["AttachmentID"],dr["FileName"],String.Format(stats,kb,dr["Downloads"]));
					}
				}
				html += "</p>";
			}
			
			if(row["Signature"] != DBNull.Value)
				html += "<br/><hr noshade/>" + FormatMsg.ForumCodeToHtml(ForumPage,row["Signature"].ToString());

			if(!isHtml)
				html = FormatMsg.ForumCodeToHtml(ForumPage,html);

			return FormatMsg.FetchURL(ForumPage,html);
		}

		private void Delete_Click(object sender,EventArgs e)
		{
			if(!CanDeletePost)
				return;

			// CHANGED BAI 30.01.2004
      
			//Create objects for easy access
			object tmpMessageID = DataRow["MessageID"];
			object tmpForumID   = DataRow["ForumID"];
			object tmpTopicID   = DataRow["TopicID"];
			
			// Delete message. If it is the last message of the topic, the topic is also deleted
			ForumPage.DataProvider.message_delete(tmpMessageID);
			
			// retrieve topic information.
			DataRow topic = ForumPage.DataProvider.topic_info(tmpTopicID);
			
			//If topic has been deleted, redirect to topic list for active forum, else show remaining posts for topic
			if (topic == null)
				Forum.Redirect(Pages.topics,"f={0}",tmpForumID);
			else
				Forum.Redirect(Pages.posts,"t={0}",tmpTopicID);
      
			// END CHANGED BAI 30.01.2004
		}
	}
}
