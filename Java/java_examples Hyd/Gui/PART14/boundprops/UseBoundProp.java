import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*; //this is to use bound props

/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/
public class UseBoundProp {
 public static void main(String args[]){
	Frame f = new Frame();
	f.setLayout(new FlowLayout());
	BoundProp b = new BoundProp("pressed.gif","released.gif");
	b.addActionListener(new ActList());
//	b.addPropertyChangeListener(new mypropChangeList());
b.addPropertyChangeListener("myprop1",new mypropChangeList());

	f.add(b);
	f.pack();
	f.show();
 }

}

class mypropChangeList implements PropertyChangeListener{
public void propertyChange(PropertyChangeEvent pce){
	System.out.println("Property changed");
}
}

class ActList implements ActionListener{
	public void actionPerformed(ActionEvent ae){

		System.out.println(" ....  action performed on button  ...");
         }
}