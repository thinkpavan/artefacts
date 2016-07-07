@set echo on

set classpath=%CLASSPATH%;C:\bea\weblogic81\server\lib\weblogic.jar

javac -d . *.java

jar -cvf trans.jar .




