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

namespace yaf.pages
{
	/// <summary>
	/// Summary description for active.
	/// </summary>
	public class im_aim : ForumPage
	{
		protected controls.PageLinks PageLinks;
		protected HyperLink Msg, Buddy;

		public im_aim() : base("IM_AIM")
		{
		}

		private void Page_Load(object sender, System.EventArgs e)
		{
			if(!User.IsAuthenticated)
				Data.AccessDenied();

			if(!IsPostBack) {
				using(DataTable dt=DataProvider.user_list(PageBoardID,Request.QueryString["u"],null)) 
				{
					foreach(DataRow row in dt.Rows) 
					{
						PageLinks.AddLink(Config.BoardSettings.Name,Forum.GetLink(Pages.forum));
						PageLinks.AddLink(row["Name"].ToString(),Forum.GetLink(Pages.profile,"u={0}",row["UserID"]));
						PageLinks.AddLink(GetText("TITLE"),Forum.GetLink(Pages.im_aim,"u={0}",row["UserID"]));

						Msg.NavigateUrl = string.Format("aim:goim?screenname={0}&message=Hi.+Are+you+there?",row["AIM"]);
						Buddy.NavigateUrl = string.Format("aim:addbuddy?screenname={0}",row["AIM"]);
						break;
					}
				}
			}
		}

		override protected void OnInit(EventArgs e)
		{
			this.Load += new System.EventHandler(this.Page_Load);
			base.OnInit(e);
		}
	}
}
