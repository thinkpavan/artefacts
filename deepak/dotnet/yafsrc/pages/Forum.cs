using System;
using System.Web;
using System.Web.UI;

namespace yaf
{
	public enum Pages 
	{
		forum,
		topics,
		posts,
		profile,
		activeusers,
		moderate,
		postmessage,
		mod_forumuser,
		attachments,
		pmessage,
		movetopic,
		emailtopic,
		printtopic,
		members,
		cp_inbox,
		cp_profile,
		cp_editprofile,
		cp_signature,
		cp_subscriptions,
		cp_message,
		login,
		approve,
		info,
		rules,
		register,
		search,
		active,
		logout,
		moderate_index,
		moderate_forum,
		error,
		avatar,
		admin_admin,
		admin_hostsettings,
		admin_boards,
		admin_boardsettings,
		admin_forums,
		admin_bannedip,
		admin_smilies,
		admin_accessmasks,
		admin_groups,
		admin_users,
		admin_ranks,
		admin_mail,
		admin_prune,
		admin_pm,
		admin_attachments,
		admin_nntpservers,
		admin_nntpforums,
		admin_nntpretrieve,
		admin_version,
		admin_bannedip_edit,
		admin_editaccessmask,
		admin_editboard,
		admin_editcategory,
		admin_editforum,
		admin_editgroup,
		admin_editnntpforum,
		admin_editnntpserver,
		admin_editrank,
		admin_edituser,
		// Added BAI 07.01.2004		 
		admin_reguser,
		// Added BAI 07.01.2004
		admin_smilies_edit,
		admin_smilies_import,
		im_yim,
		im_aim,
		im_icq,
		im_email
	}

	/// <summary>
	/// Summary description for Forum.
	/// </summary>
	[ToolboxData("<{0}:Forum runat=\"server\"></{0}:Forum>")]
	public class Forum : System.Web.UI.UserControl
	{
		public Forum()
		{
			this.Load += new EventHandler(Forum_Load);
		}

		private void Forum_Load(object sender,EventArgs e) 
		{
			Pages page;
			string m_baseDir = Config.ConfigSection["root"];

			switch(Request.QueryString["g"])
			{
				default:
					//throw new ApplicationException(Request.QueryString["g"]);
				case "forum":
				case null:
					page = Pages.forum;
					break;
				case "moderate":
					page = Pages.moderate;
					break;
				case "topics":
					page = Pages.topics;
					break;
				case "posts":
					page = Pages.posts;
					break;
				case "movetopic":
					page = Pages.movetopic;
					break;
				case "profile":
					page = Pages.profile;
					break;
				case "cp_profile":
					page = Pages.cp_profile;
					break;
				case "cp_editprofile":
					page = Pages.cp_editprofile;
					break;
				case "postmessage":
					page = Pages.postmessage;
					break;
				case "activeusers":
					page = Pages.activeusers;
					break;
				case "attachments":
					page = Pages.attachments;
					break;
				case "approve":
					page = Pages.approve;
					break;
				case "rules":
					page = Pages.rules;
					break;
				case "register":
					page = Pages.register;
					break;
				case "logout":
					page = Pages.logout;
					break;
				case "login":
					page = Pages.login;
					break;
				case "members":
					page = Pages.members;
					break;
				case "printtopic":
					page = Pages.printtopic;
					break;
				case "pmessage":
					page = Pages.pmessage;
					break;
				case "cp_inbox":
					page = Pages.cp_inbox;
					break;
				case "cp_message":
					page = Pages.cp_message;
					break;
				case "emailtopic":
					page = Pages.emailtopic;
					break;
				case "cp_signature":
					page = Pages.cp_signature;
					break;
				case "cp_subscriptions":
					page = Pages.cp_subscriptions;
					break;
				case "active":
					page = Pages.active;
					break;
				case "mod_forumuser":
					page = Pages.mod_forumuser;
					break;
				case "info":
					page = Pages.info;
					break;
				case "moderate_index":
					page = Pages.moderate_index;
					break;
				case "moderate_forum":
					page = Pages.moderate_forum;
					break;
				case "search":
					page = Pages.search;
					break;
				case "error":
					page = Pages.error;
					break;
				case "avatar":
					page = Pages.avatar;
					break;
				case "admin_admin":
					page = Pages.admin_admin;
					break;
				case "admin_hostsettings":
					page = Pages.admin_hostsettings;
					break;
				case "admin_boards":
					page = Pages.admin_boards;
					break;
				case "admin_boardsettings":
					page = Pages.admin_boardsettings;
					break;
				case "admin_forums":
					page = Pages.admin_forums;
					break;
				case "admin_bannedip":
					page = Pages.admin_bannedip;
					break;
				case "admin_smilies":
					page = Pages.admin_smilies;
					break;
				case "admin_accessmasks":
					page = Pages.admin_accessmasks;
					break;
				case "admin_groups":
					page = Pages.admin_groups;
					break;
				case "admin_users":
					page = Pages.admin_users;
					break;
				case "admin_ranks":
					page = Pages.admin_ranks;
					break;
				case "admin_mail":
					page = Pages.admin_mail;
					break;
				case "admin_prune":
					page = Pages.admin_prune;
					break;
				case "admin_pm":
					page = Pages.admin_pm;
					break;
				case "admin_attachments":
					page = Pages.admin_attachments;
					break;
				case "admin_nntpservers":
					page = Pages.admin_nntpservers;
					break;
				case "admin_nntpforums":
					page = Pages.admin_nntpforums;
					break;
				case "admin_nntpretrieve":
					page = Pages.admin_nntpretrieve;
					break;
				case "admin_version":
					page = Pages.admin_version;
					break;
				case "admin_bannedip_edit":
					page = Pages.admin_bannedip_edit;
					break;
				case "admin_editaccessmask":
					page = Pages.admin_editaccessmask;
					break;
				case "admin_editboard":
					page = Pages.admin_editboard;
					break;
				case "admin_editcategory":
					page = Pages.admin_editcategory;
					break;
				case "admin_editforum":
					page = Pages.admin_editforum;
					break;
				case "admin_editgroup":
					page = Pages.admin_editgroup;
					break;
				case "admin_editnntpforum":
					page = Pages.admin_editnntpforum;
					break;
				case "admin_editnntpserver":
					page = Pages.admin_editnntpserver;
					break;
				case "admin_editrank":
					page = Pages.admin_editrank;
					break;
				case "admin_edituser":
					page = Pages.admin_edituser;
					break;
				case "admin_smilies_edit":
					page = Pages.admin_smilies_edit;
					break;
				case "admin_smilies_import":
					page = Pages.admin_smilies_import;
					break;
				case "im_yim":
					page = Pages.im_yim;
					break;
				case "im_aim":
					page = Pages.im_aim;
					break;
				case "im_icq":
					page = Pages.im_icq;
					break;
				case "im_email":
					page = Pages.im_email;
					break;
					// ADDED BAI 07.01.2004
				case "admin_reguser":
					page = Pages.admin_reguser;
					break;
					// ADDED BAI 07.01.2004	
			}

			string src = string.Format("{0}pages/{1}.ascx",m_baseDir,page);
			if(src.IndexOf("/moderate_")>=0)
				src = src.Replace("/moderate_","/moderate/");
			if(src.IndexOf("/admin_")>=0)
				src = src.Replace("/admin_","/admin/");

			try
			{
				pages.ForumPage ctl = (pages.ForumPage)LoadControl(src);
				ctl.ForumControl = this;
				this.Controls.Add(ctl);
			}
			catch(System.IO.FileNotFoundException)
			{
				throw new ApplicationException("Failed to load " + src + ".");
			}
		}

		private	yaf.Header	m_header	= null;
		private yaf.Footer	m_footer	= null;

		public yaf.Header Header
		{
			set
			{
				m_header = value;
			}
			get
			{
				return m_header;
			}
		}

		public yaf.Footer Footer
		{
			set
			{
				m_footer = value;
			}
			get
			{
				return m_footer;
			}
		}

		static public string GetLink(Pages page)
		{
			return Config.UrlBuilder.BuildUrl(string.Format("g={0}",page));
		}

		static public string GetLink(Pages page,string format,params object[] args)
		{
			return Config.UrlBuilder.BuildUrl(string.Format("g={0}&{1}",page,string.Format(format,args)));
		}

		static public void Redirect(Pages page)
		{
			System.Web.HttpContext.Current.Response.Redirect(GetLink(page));
		}

		static public void Redirect(Pages page,string format,params object[] args)
		{
			System.Web.HttpContext.Current.Response.Redirect(GetLink(page,format,args));
		}
	}
}
