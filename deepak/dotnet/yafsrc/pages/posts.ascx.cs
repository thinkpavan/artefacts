/* Yet Another Forum.net
 * Copyright (C) 2003 Bj�rnar Henden
 * http://www.yetanotherforum.net/
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Text.RegularExpressions;

namespace yaf.pages
{
	/// <summary>
	/// Summary description for posts.
	/// </summary>
	public class posts : ForumPage
	{
		protected System.Web.UI.WebControls.LinkButton NewTopic1;
		protected System.Web.UI.WebControls.Repeater MessageList;
		protected System.Web.UI.WebControls.LinkButton PostReplyLink1;
		protected System.Web.UI.WebControls.Repeater Poll;
		protected controls.PageLinks PageLinks;
		protected controls.Pager Pager;

		private DataRow forum, topic;
		protected System.Web.UI.WebControls.LinkButton PrevTopic;
		protected System.Web.UI.WebControls.LinkButton NextTopic;
		protected System.Web.UI.WebControls.LinkButton PrintTopic;
		protected System.Web.UI.WebControls.LinkButton EmailTopic;
		protected System.Web.UI.WebControls.LinkButton DeleteTopic1;
		protected System.Web.UI.WebControls.LinkButton LockTopic1;
		protected System.Web.UI.WebControls.LinkButton UnlockTopic1;
		protected System.Web.UI.WebControls.Label TopicTitle;
		private DataTable dtPoll;
		protected System.Web.UI.WebControls.LinkButton PostReplyLink2;
		protected System.Web.UI.WebControls.LinkButton NewTopic2;
		protected System.Web.UI.WebControls.LinkButton DeleteTopic2;
		protected System.Web.UI.WebControls.LinkButton LockTopic2;
		protected System.Web.UI.WebControls.LinkButton UnlockTopic2;
		protected System.Web.UI.WebControls.LinkButton TrackTopic;
		protected System.Web.UI.WebControls.LinkButton MoveTopic1;
		protected System.Web.UI.WebControls.LinkButton MoveTopic2;
		protected LinkButton NormalView,ThreadView;
		protected HtmlTableCell ThreadViewCell;
		private bool m_bDataBound = false;

		public posts() : base("POSTS")
		{
		}

		private void posts_PreRender(object sender,EventArgs e)
		{
			if(!m_bDataBound)
				BindData();
		}

		private void Page_Load(object sender, System.EventArgs e)
		{
			topic = DataProvider.topic_info(PageTopicID);
			using(DataTable dt = DataProvider.forum_list(PageBoardID,PageForumID))
				forum = dt.Rows[0];

			if(!ForumReadAccess)
				Data.AccessDenied();

			if(!IsPostBack) 
			{
				PageLinks.AddLink(Config.BoardSettings.Name,Forum.GetLink(Pages.forum));
				PageLinks.AddLink(PageCategoryName,Forum.GetLink(Pages.forum,"c={0}",PageCategoryID));
				PageLinks.AddForumLinks(PageForumID);
				PageLinks.AddLink(PageTopicName,Forum.GetLink(Pages.posts,"t={0}",PageTopicID));
				TopicTitle.Text = (string)topic["Topic"];
				NormalView.Text = GetText("NORMAL");
				ThreadView.Text = GetText("THREADED");
				ThreadViewCell.Visible = Config.BoardSettings.AllowThreaded;

				if(!ForumPostAccess) 
				{
					NewTopic1.Visible = false;
					NewTopic2.Visible = false;
				}
			
				if(!ForumReplyAccess || (bool)topic["IsLocked"]) 
				{
					PostReplyLink1.Visible = false;
					PostReplyLink2.Visible = false;
				}

				if(ForumModeratorAccess) 
				{
					MoveTopic1.Visible = true;
					MoveTopic2.Visible = true;
				} 
				else 
				{
					MoveTopic1.Visible = false;
					MoveTopic2.Visible = false;
				}

				PostReplyLink1.Text = GetThemeContents("BUTTONS","POSTREPLY");
				PostReplyLink1.ToolTip = "Post reply";
				PostReplyLink2.Text = PostReplyLink1.Text;
				PostReplyLink2.ToolTip = PostReplyLink1.ToolTip;
				NewTopic1.Text = GetThemeContents("BUTTONS","NEWTOPIC");
				NewTopic1.ToolTip = "Post new topic";
				NewTopic2.Text = NewTopic1.Text;
				NewTopic2.ToolTip = NewTopic1.ToolTip;
				DeleteTopic1.Text = GetThemeContents("BUTTONS","DELETETOPIC");
				DeleteTopic1.ToolTip = "Delete this topic";
				DeleteTopic2.Text = DeleteTopic1.Text;
				DeleteTopic2.ToolTip = DeleteTopic1.ToolTip;
				LockTopic1.Text = GetThemeContents("BUTTONS","LOCKTOPIC");
				LockTopic1.ToolTip = "Lock this topic";
				LockTopic2.Text = LockTopic1.Text;
				LockTopic2.ToolTip = LockTopic1.ToolTip;
				UnlockTopic1.Text = GetThemeContents("BUTTONS","UNLOCKTOPIC");
				UnlockTopic1.ToolTip = "Unlock this topic";
				UnlockTopic2.Text = UnlockTopic1.Text;
				UnlockTopic2.ToolTip = UnlockTopic1.ToolTip;
				MoveTopic1.Text = GetThemeContents("BUTTONS","MOVETOPIC");
				MoveTopic1.ToolTip = "Move this topic";
				MoveTopic2.Text = MoveTopic1.Text;
				MoveTopic2.ToolTip = MoveTopic1.ToolTip;

				if(!ForumModeratorAccess) 
				{
					LockTopic1.Visible = false;
					UnlockTopic1.Visible = false;
					DeleteTopic1.Visible = false;
					LockTopic2.Visible = false;
					UnlockTopic2.Visible = false;
					DeleteTopic2.Visible = false;
				} 
				else 
				{
					LockTopic1.Visible = !(bool)topic["IsLocked"];
					UnlockTopic1.Visible = !LockTopic1.Visible;
					LockTopic2.Visible = !(bool)topic["IsLocked"];
					UnlockTopic2.Visible = !LockTopic2.Visible;
				}

			}
			/// Mark topic read
			SetTopicRead(PageTopicID,DateTime.Now);
			BindData();
		}

		protected void DeleteMessage_Load(object sender, System.EventArgs e) 
		{
			((LinkButton)sender).Attributes["onclick"] = String.Format("return confirm('{0}')",GetText("confirm_deletemessage"));
		}

		protected void DeleteTopic_Load(object sender, System.EventArgs e) 
		{
			((LinkButton)sender).Attributes["onclick"] = String.Format("return confirm('{0}')",GetText("confirm_deletetopic"));
		}

		private void Pager_PageChange(object sender, EventArgs e)
		{
			BindData();
		}

		private void NormalView_Click(object sender,EventArgs e)
		{
			IsThreaded = false;
			BindData();
		}
		private void ThreadView_Click(object sender,EventArgs e)
		{
			IsThreaded = true;
			BindData();
		}

		#region Web Form Designer generated code
		override protected void OnInit(EventArgs e)
		{
			Pager.PageChange += new EventHandler(Pager_PageChange);
			NormalView.Click += new EventHandler(NormalView_Click);
			ThreadView.Click += new EventHandler(ThreadView_Click);
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
			this.Poll.ItemCommand += new System.Web.UI.WebControls.RepeaterCommandEventHandler(this.Poll_ItemCommand);
			this.PostReplyLink1.Click += new System.EventHandler(this.PostReplyLink_Click);
			this.NewTopic1.Click += new System.EventHandler(this.NewTopic_Click);
			this.DeleteTopic1.Click += new System.EventHandler(this.DeleteTopic_Click);
			this.LockTopic1.Click += new System.EventHandler(this.LockTopic_Click);
			this.UnlockTopic1.Click += new System.EventHandler(this.UnlockTopic_Click);
			this.TrackTopic.Click += new System.EventHandler(this.TrackTopic_Click);
			this.PostReplyLink2.Click += new System.EventHandler(this.PostReplyLink_Click);
			this.NewTopic2.Click += new System.EventHandler(this.NewTopic_Click);
			this.DeleteTopic2.Click += new System.EventHandler(this.DeleteTopic_Click);
			this.LockTopic2.Click += new System.EventHandler(this.LockTopic_Click);
			this.UnlockTopic2.Click += new System.EventHandler(this.UnlockTopic_Click);
			this.MoveTopic1.Click += new System.EventHandler(this.MoveTopic_Click);
			this.MoveTopic2.Click += new System.EventHandler(this.MoveTopic_Click);
			this.PrevTopic.Click += new System.EventHandler(this.PrevTopic_Click);
			this.NextTopic.Click += new System.EventHandler(this.NextTopic_Click);
			this.PrintTopic.Click += new System.EventHandler(this.PrintTopic_Click);
			this.EmailTopic.Click += new System.EventHandler(this.EmailTopic_Click);
			this.Load += new System.EventHandler(this.Page_Load);
			this.PreRender += new EventHandler(posts_PreRender);

		}
		#endregion

		private void BindData() 
		{
			m_bDataBound = true;

			Pager.PageSize = 20;
			if(topic==null)
				Forum.Redirect(Pages.topics,"f={0}",PageForumID);

			PagedDataSource pds = new PagedDataSource();
			pds.AllowPaging = true;
			pds.PageSize = Pager.PageSize;

			using(DataTable dt0 = DataProvider.post_list(PageTopicID,IsPostBack?0:1)) 
			{
				DataView dt = dt0.DefaultView;
				if(IsThreaded)
					dt.Sort = "Position";
				else
					dt.Sort = "Posted";

				Pager.Count = dt.Count;
				pds.DataSource = dt;
				int nFindMessage = 0;
				try
				{
					if(Request.QueryString["m"]!=null)
					{
						// Show this message
						nFindMessage = int.Parse(Request.QueryString["m"]);
					}
					else if(Request.QueryString["find"]!=null && Request.QueryString["find"].ToLower()=="unread")
					{
						// Find next unread
						using(DataTable dtUnread = DataProvider.message_findunread(PageTopicID,Mession.LastVisit))
						{
							foreach(DataRow row in dtUnread.Rows)
							{
								nFindMessage = (int)row["MessageID"];
								break;
							}
						}
					}
				}
				catch(Exception)
				{
				}

				if(nFindMessage>0) 
				{
					CurrentMessage = nFindMessage;
					// Find correct page for message
					for(int foundRow=0;foundRow<dt.Count;foundRow++)
					{
						if((int)dt[foundRow]["MessageID"] == nFindMessage)
						{
							pds.CurrentPageIndex = foundRow / pds.PageSize;
							Pager.CurrentPageIndex = pds.CurrentPageIndex;
							break;
						}
					}
				}
				else
				{
					foreach(DataRow row in dt0.Rows)
					{
						CurrentMessage = (int)row["MessageID"];
						break;
					}
				}
			}

			pds.CurrentPageIndex = Pager.CurrentPageIndex;

			if(pds.CurrentPageIndex>=pds.PageCount) pds.CurrentPageIndex = pds.PageCount - 1;
				
			MessageList.DataSource = pds;

			if(topic["PollID"]!=DBNull.Value) 
			{
				Poll.Visible = true;
				dtPoll = DataProvider.poll_stats(topic["PollID"]);
				Poll.DataSource = dtPoll;
			}
			
			DataBind();
		}

		protected bool CanVote
		{
			get
			{
				string cookie = String.Format("poll#{0}#{1}",topic["PollID"],PageUserID);
				return ForumVoteAccess && Request.Cookies[cookie] == null;
			}
		}

		private void DeleteTopic_Click(object sender, System.EventArgs e)
		{
			if(!ForumModeratorAccess)
				Data.AccessDenied(/*"You don't have access to delete topics."*/);

			DataProvider.topic_delete(PageTopicID);
			Forum.Redirect(Pages.topics,"f={0}",PageForumID);
		}

		private void LockTopic_Click(object sender, System.EventArgs e)
		{
			DataProvider.topic_lock(PageTopicID,true);
			BindData();
			AddLoadMessage(GetText("INFO_TOPIC_LOCKED"));
			LockTopic1.Visible = !LockTopic1.Visible;
			UnlockTopic1.Visible = !UnlockTopic1.Visible;
			LockTopic2.Visible = LockTopic1.Visible;
			UnlockTopic2.Visible = UnlockTopic1.Visible;
			PostReplyLink1.Visible = false;
			PostReplyLink2.Visible = false;
		}

		private void UnlockTopic_Click(object sender, System.EventArgs e)
		{
			DataProvider.topic_lock(PageTopicID,false);
			BindData();
			AddLoadMessage(GetText("INFO_TOPIC_UNLOCKED"));
			LockTopic1.Visible = !LockTopic1.Visible;
			UnlockTopic1.Visible = !UnlockTopic1.Visible;
			LockTopic2.Visible = LockTopic1.Visible;
			UnlockTopic2.Visible = UnlockTopic1.Visible;
			PostReplyLink1.Visible = ForumReplyAccess;
			PostReplyLink2.Visible = ForumReplyAccess;
		}

		private void Poll_ItemCommand(object source, System.Web.UI.WebControls.RepeaterCommandEventArgs e) {
			if(e.CommandName=="vote" && ForumVoteAccess) {
				string cookie = String.Format("poll#{0}#{1}",topic["PollID"],PageUserID);

				if(Request.Cookies[cookie] != null) 
				{
					AddLoadMessage(GetText("WARN_ALREADY_VOTED"));
					return;
				}

				if((bool)topic["IsLocked"]) {
					AddLoadMessage(GetText("WARN_TOPIC_LOCKED"));
					return;
				}

				DataProvider.choice_vote(e.CommandArgument);
				HttpCookie c = new HttpCookie(cookie,e.CommandArgument.ToString());
				c.Expires = DateTime.Now.AddYears(1);
				Response.Cookies.Add(c);
				AddLoadMessage(GetText("INFO_VOTED"));
				BindData();
			}
		}

		protected string GetPollQuestion() {
			return (string)dtPoll.Rows[0]["Question"];
		}

		private void PostReplyLink_Click(object sender, System.EventArgs e) {
			if((bool)topic["IsLocked"]) {
				AddLoadMessage(GetText("WARN_TOPIC_LOCKED"));
				return;
			}

			if((bool)forum["Locked"]) {
				AddLoadMessage(GetText("WARN_FORUM_LOCKED"));
				return;
			}
					
			Forum.Redirect(Pages.postmessage,"t={0}&f={1}",PageTopicID,PageForumID);
		}

		private void NewTopic_Click(object sender, System.EventArgs e) {
			if((bool)forum["Locked"]) {
				AddLoadMessage(GetText("WARN_FORUM_LOCKED"));
				return;
			}
			Forum.Redirect(Pages.postmessage,"f={0}",PageForumID);
		}

		private void TrackTopic_Click(object sender, System.EventArgs e) {
			if(IsGuest) {
				AddLoadMessage(GetText("WARN_WATCHLOGIN"));
				return;
			}

			DataProvider.watchtopic_add(PageUserID,PageTopicID);
			AddLoadMessage(GetText("INFO_WATCH_TOPIC"));
			BindData();
		}
		
		private void MoveTopic_Click(object sender, System.EventArgs e) {
			if(!ForumModeratorAccess)
				Data.AccessDenied(/*"You are not a forum moderator."*/);

			Forum.Redirect(Pages.movetopic,"t={0}",PageTopicID);
		}

		private void PrevTopic_Click(object sender, System.EventArgs e) {
			using(DataTable dt = DataProvider.topic_findprev(PageTopicID)) {
				if(dt.Rows.Count==0) {
					AddLoadMessage(GetText("INFO_NOMORETOPICS"));
					return;
				}
				Forum.Redirect(Pages.posts,"t={0}",dt.Rows[0]["TopicID"]);
			}
		}

		private void NextTopic_Click(object sender, System.EventArgs e) {
			using(DataTable dt = DataProvider.topic_findnext(PageTopicID)) {
				if(dt.Rows.Count==0) {
					AddLoadMessage(GetText("INFO_NOMORETOPICS"));
					return;
				}
				Forum.Redirect(Pages.posts,"t={0}",dt.Rows[0]["TopicID"]);
			}
		}
		private void EmailTopic_Click(object sender, System.EventArgs e) {
			if(!User.IsAuthenticated) {
				AddLoadMessage(GetText("WARN_EMAILLOGIN"));
				return;
			}
			Forum.Redirect(Pages.emailtopic,"t={0}",PageTopicID);
		}
		private void PrintTopic_Click(object sender, System.EventArgs e) {
			Forum.Redirect(Pages.printtopic,"t={0}",PageTopicID);
		}

		protected int VoteWidth(object o) 
		{
			DataRowView row = (DataRowView)o;
			return (int)row["Stats"] * 80 / 100;
		}

		public bool IsThreaded
		{
			get
			{
				if(Request.QueryString["threaded"]!=null)
					Session["IsThreaded"] = bool.Parse(Request.QueryString["threaded"]);
				else if(Session["IsThreaded"]==null)
					Session["IsThreaded"] = false;

				return (bool)Session["IsThreaded"];
			}
			set
			{
				Session["IsThreaded"] = value;
			}
		}

		protected int CurrentMessage
		{
			get
			{
				if(ViewState["CurrentMessage"]!=null)
					return (int)ViewState["CurrentMessage"];
				else
					return 0;
			}
			set
			{
				ViewState["CurrentMessage"] = value;
			}
		}

		protected bool IsCurrentMessage(object o)
		{
			DataRowView row = (DataRowView)o;

			return !IsThreaded || CurrentMessage==(int)row["MessageID"];
		}

		protected string GetThreadedRow(object o)
		{
			DataRowView row = (DataRowView)o;
			if(!IsThreaded || CurrentMessage==(int)row["MessageID"])
				return "";

			System.Text.StringBuilder html = new System.Text.StringBuilder(1000);

			// Threaded
			string brief = row["Message"].ToString();
			
			RegexOptions options = RegexOptions.IgnoreCase /*| RegexOptions.Singleline | RegexOptions.Multiline*/;
			options |= RegexOptions.Singleline;
			while(Regex.IsMatch(brief,@"\[quote=(.*?)\](.*)\[/quote\]",options)) 
				brief = Regex.Replace(brief,@"\[quote=(.*?)\](.*)\[/quote\]","",options);
			while(Regex.IsMatch(brief,@"\[quote\](.*)\[/quote\]",options)) 
				brief = Regex.Replace(brief,@"\[quote\](.*)\[/quote\]","",options);
			
			while(Regex.IsMatch(brief,@"<.*?>",options))
				brief = Regex.Replace(brief,@"<.*?>","",options);

			if(brief.Length>42)
				brief = brief.Substring(0,40) + "...";

			html.AppendFormat("<tr class='post'><td colspan='3' nowrap>");
			html.AppendFormat(GetIndentImage(row["Indent"]));
			html.AppendFormat("\n<a href='{0}'>{2} ({1}",Forum.GetLink(Pages.posts,"m={0}#{0}",row["MessageID"]),row["UserName"],brief);
			html.AppendFormat(" - {0})</a>",FormatDateTimeShort(row["Posted"]));

			return html.ToString();
		}
		protected string GetIndentImage(object o) 
		{
			if(!IsThreaded)
				return "";

			int iIndent = (int)o;
			if(iIndent>0)
				return string.Format("<img src='{1}images/spacer.gif' width='{0}' height='2'/>",iIndent*32,Data.ForumRoot);
			else
				return "";
		}
	}
}
