This shows how to sign an applet.

1) generate u'r public/private key using keygen tool.
  Use keytool -genkey command and follow the instructions 
of the tool to generate keys.


2) send CSR to C.A (here we will not send it to C.A,
we will using self signing technique here, typically
C.A. charges around 100 to 200 USD per certificate).


if u want to send a certificate request to a ca use keytool - certreq option which creates csr.


3) create jar file using jar tool.

4) use jarsigner  yourjarfile keyalias


5) export u'r public key using

keytool -export -alias keyalias -file mycert.cer

6) if u are intrested in finding about the content of certificate
issue the command keytool -printcert -file mycert.cer

now when u send this file to some body he need to verify 
the files by using digital signature.


In order to test this u can assume the role of reciever
and follow the steps given below

1) use the following command in order to store the public key of sender
in a new keystore (let it be recvks)

keytool -import -alias sender -file mycert.cer -keystore recvks

The above command store the certificate as trusted certificate with an alias
sender.

if u want to test what is there in newely created key store u can use
keytool -list -keystore recvks

2) use policy tool and specify the permission u want to give to the 
applet/application and save the policy file.

Note: in policy tool u need to give the address of keystore, For this
we cannot directly use some thing like c:\xyz\recvks, instead of this u
have to use file:/c:/xyz/recvks

3) run the applet using appletviewer

appletviewer -J-Djava.security.policy=policyfile appperm.html

(Note: observe the change in html file).



Note : if u want to test permission on applications use the following command

java -Djava.security.manager -Djava.security.policy=policy2
  -classpath APP.jar APP 



U need to follow the steps carefully in order to test the security features.

















