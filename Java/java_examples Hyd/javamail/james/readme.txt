James is an open source project. Visit http://james.apache.org for details.

Both smtp and pop3 servers are implemented in this protocol.

Procedure for installation.


1) extract james-2.1.3.zip to a folder.

2) read install.html for details on how to install and configure james available
   in docs directory of newely created james-2.1.3 directory.


If you are using any other smtp/pop servers then you need to stop them before using
james as james using the same port as that of other servers.


Use telnet to add users.

Telnet 127.0.0.1 4555

username root password root.

To add users 

adduser stud1 pass1
adduser stud2 pass2

Note To Students:

To show how to use java mail api we are using james server. There are so
many pop and smtp servers available in market which are much more efficient
and flexible that this server.


ICEMail is a mail client implemented in java. Try microsoft outlook
express and ice mail to send/receive mails.


check http://www.icemail.org for details on the above product.