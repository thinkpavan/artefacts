Steps:

1) create remote interface

2) create home interface.

3) create EJB class

4) copy the above files to c:\weblogic\classes directory
under appropriate directoy structure that reflects package structure.

5) open ejbdeployer and create a new jar file(hw.jar) adding the above three
files. ( set the deployment parameters as required).

6) run ejbc compiler using the following command.

java -Dweblogic.home=%WL_HOME% weblogic.ejbc
 -compiler javac .\hw.jar .\hwnew.jar

7) make appropriate modifications to weblogic.properties file and start the server.


