import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/
public class usecustcomp {
 public static void main(String args[]){
	Frame f = new Frame();
	f.setLayout(new FlowLayout());
	CustEvtComp b = new CustEvtComp("pressed.gif","released.gif");
	b.addCustListener(new ActList());
	f.add(b);
	f.pack();
	f.show();
 }

}

class ActList implements CustListener{
	public void CustAction1(CustEvent ae){

		System.out.println(" ....  custom event on button  ...");
         }
       public void CustAction2(CustEvent ae){

		System.out.println(" ....  custom event on button  ...");
         }

}