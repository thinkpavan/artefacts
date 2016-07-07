**********************************************
Bugs Online v 2.1 Readme
**********************************************

Thank you for using Bugs Online v 2.1

This version of the program is the result of
much effort and improvement to the original
system. This version has incorporated graphical
reporting tools as well as a "my bugs"

Please follow these instructions to install
Bugs Online:

Hardware Requirements:
Windows NT 4.0 SP3+
MS IIS 3 w/ ASP

To Install:
1. 	Copy directory "bugs" to a location
	accessible to http traffic
2.	In IIS manager create virtual site
	(or if this is the only site then
	set as default)
3.	Insure that index.asp can be used as
	default page in IIS manager
4.	Create system DSN through ODBC manger
	pointing to database "bugs"
5.	Name this system DSN "bugs"
6.	Bugs site should be ready to configure


To Configure:
1.	Enter bugs online using system manager
	login information:
	User Name:	bugsadmin
	Password:	bugsadmin
2.	Enter "Site Admin" section
3. 	From here create a project (these are
	the projects that will appear in the 
	initial login page)
4.	Create applicable Programs for that
	project
5.	Create applicable Program Areas for
	each Program
6.	Create user account
7.	Authorize users to that project (if 
	not already done)
8.	Specify which users will be considered
	developer. (These are the users that
	can be assigned bugs). Do this by
	clicking "[Developers]" and "[Unauth]"
	Then select the appropriate developers
	and click "Add"
	DEVELOPERS ARE PROGRAM SPECIFIC

*Please note:
This application can support an unlimited number of projects.
Users can be authorized to one or to multiple projects as
can developers. However, the user or developer will only see
the bugs for the project to which they are logged into.

Management level users are the only users with access to the 
"Site Admin" section, and only when logged into the "Management"
project. When logged into this project they will see all bugs
for every project.


Additional Improvements to v 2.1:

Version 2.1 added the status "Closed"
(currently only "Completed" was available).

"Closed" status can only be assigned by the user who
originally submits the bug. Here is why:

In using the system we encountered a problem in that when
a user created a bug, they would assign it to a developer.
This developer would then supposedly fix the bug and then
set it to a status of completed. However, situations arose
in which case the bug was not actually fixed. The user,
however, would not realize this until much later as he/she
assumed since it was completed, that it was fixed.

Hence, with the new system the user is responsible for 
making the final closing on a bug. When a developer believes
a bug to be fixed, they will set the status to "Completed"
The user will then see this by clicking on "My Bugs" and
at that time will verify that the bug is actually fixed.
If it is, the bug will be closed, if not, however, it will
be reassigned to the Developer to be fixed, with an explanation
as to why it is not fixed.

This addition will allow for improved "Accountability" for
bugs.



Version 2.1 also added an e-mail function.

Whenever a bug is assigned to a developer, that developer
will be sent an e-mail, stating that the bug has been assigned.
To enable this functionality please follow these instructions:

Purchase and install and ASP E-Mail Component:
You can try one for 30 days from:
http://www.aspemail.com/

Open file "process_submit_bug.inc" from "scripts" directory
and un-comment and change lines 189 - 202 to conform to
e-mail component functionality.



Misc. Information:

There is no database password.

If you want a custom graphic to appear in the upper righthand
corner for each project, you need only place an image with
the same name as that project into the directory "images/projects"

The default image is: "management.gif"

*** Any custom image should have a canvas size of 70x70 pixels ***


You should be ready to go.
Good luck!


Jason Read
Developer
jason@imalt.net


