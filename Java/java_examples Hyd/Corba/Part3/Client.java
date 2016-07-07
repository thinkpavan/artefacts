/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;

public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Locate Passval Server, for this we are using visigenic specific method.
    INetMod.Passval g = INetMod.PassvalHelper.bind(orb,"Server");
    g.passParam((short)22,(char)8888,890.90);//short,char,double
    System.out.println(g.passParam1('a',9999L));//char,long
  }
}