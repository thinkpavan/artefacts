/* Shows how we started working with ORB's. Java docs says that
any ORB can be plugged. Here we are more practicle oriented, so instead
of looking for furthur info we started delving deep into impl details
to find how to replace Java IDL ORB with other ORB.We have a strong 
intention of showing how ORB's can be developed for our students in future.

We know that we can develop app's using existing ORB's, but we strongly
believe that one can do better programming by learning internals.
Author : Team - J
Version : 1.0
*/
import org.omg.CORBA.*;
public class OrbHack{
public static void main(String args[])throws Exception{
// find out where to create orb.props file
	System.out.println(" Java Home Directory =  "+System.getProperty("java.home"));  
	System.out.println(" orb class name = " +com.visigenic.vbroker.orb.ORB.init());
	//ORB o = org.omg.CORBA.ORB.init();
com.visigenic.vbroker.orb.ORB o;
 //o =(com.visigenic.vbroker.orb.ORB) org.omg.CORBA.ORB.init();
 o =(com.visigenic.vbroker.orb.ORB) com.visigenic.vbroker.orb.ORB.init();

	org.omg.CORBA.BOA b =  o.BOA_init();	
	String s [] = o.list_initial_services();
//org.omg.CORBA.Object  o1 =  o.resolve_initial_references("NameService");
System.out.println(" services ..");
	for(int i = 0; i < s.length;i++){
		System.out.println(s[i]);
	}
}
}
