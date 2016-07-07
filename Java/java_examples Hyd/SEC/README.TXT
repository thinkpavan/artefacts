In order to test the security provided by jre1.2 run the example following the steps given below.


1) Place u'r html and applet class file on webserver
(we have used our hwebserver which listens at 8080 by default)

2) run appletviewer http://localhost:8080/appperm.html , now
u can observe an exception thrown by applet while opening file.

3) create a policy file as explianed in class.

4) run appletviewer -J-Djava.security.policy=policy http://localhost:8080/appperm.html and observe what is going to happen.

by using the same concept u can test the remaining permissions
on applet/application.