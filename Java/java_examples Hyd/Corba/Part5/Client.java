/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;
import org.omg.CORBA.*;
import INetMod.*;
public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Locate Passval Server, for this we are using visigenic specific method.
    INetMod.InOut1 g = INetMod.InOut1Helper.bind(orb,"IO1Server");
    // set inout params
	Company c = new Company();
	c.name = new String("old Company");
	c.yoe =111111; // some no indicating a date
	c.ceo = new String("unknown");
	c.otherattrib = new String("xyz");
	CompanyHolder ch = new CompanyHolder(c);
	g.passParam(ch);
	Company c1 = ch.value; // comment this and see ???
	System.out.println("----Company Received By Client----");
	System.out.println(c1.name);
	System.out.println(c1.yoe);
	System.out.println(c1.ceo);
	System.out.println(c1.otherattrib);
  }
}