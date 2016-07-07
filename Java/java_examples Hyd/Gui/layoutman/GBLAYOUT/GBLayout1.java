/*  shows how to use Grid Bag layout manager
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class GBLayout1 {
	public static void main(String args[])throws Exception{
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new GridBagLayout());
/*public GridBagConstraints(int gridx, int gridy, 
int gridwidth, int gridheight, double weightx, 
double weighty, int anchor, int fill, Insets insets,
 int ipadx, int ipady)*/

		for(int i = 0;i<10;i++){
			if(i< 5)// in this grid x is relative o the previous component
			mywin.add(new Button("Button "+i),new GridBagConstraints(GridBagConstraints.RELATIVE,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0));
			else if(i< 8)// in this grid x is relative to the previous component
			mywin.add(new Button("Button "+i),new GridBagConstraints(GridBagConstraints.RELATIVE,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));

			else //effect of modifying grid width -- see above
			mywin.add(new Button("Button "+i),new GridBagConstraints(0,GridBagConstraints.RELATIVE,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		}
		mywin.pack();
		mywin.show();
	}
}

