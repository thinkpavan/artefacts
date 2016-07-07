/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;
import org.omg.CORBA.*;
public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Locate Passval Server, for this we are using visigenic specific method.
    INetMod.InOut g = INetMod.InOutHelper.bind(orb,"IOServer");
    // set inout params
	StringHolder s = new StringHolder();
	StringHolder ws = new StringHolder();
	CharHolder c = new CharHolder();
	ShortHolder sh = new ShortHolder();
	sh.value = (short)22; // can we set a value to out variable
	c.value='z';
	g.passParam(sh,c);
	System.out.println("short = "+sh.value+"  "+"char "+c.value);
	s.value = new String("String value passed by Client");
	ws.value = new String("wString value passed by Client");
	g.passParam1(s,ws);
	System.out.println("String = "+s.value+"  "+"WString "+ws.value);

  }
}