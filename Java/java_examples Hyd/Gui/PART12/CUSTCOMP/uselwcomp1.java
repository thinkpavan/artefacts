import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/
public class uselwcomp1 {
 public static void main(String args[]){
	Frame f = new Frame();
	f.setLayout(new FlowLayout());
	lwcomp1 b = new lwcomp1("pressed.gif","released.gif");
	b.addActionListener(new ActList());
	f.add(b);
	f.pack();
	f.show();
 }

}

class ActList implements ActionListener{
	public void actionPerformed(ActionEvent ae){

		System.out.println(" ....  action performed on button  ...");
         }
}