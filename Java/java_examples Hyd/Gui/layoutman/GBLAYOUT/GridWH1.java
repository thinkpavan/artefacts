/*  shows how to use Grid Bag layout manager (
Gridth height , grid width)
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class GridWH1 {
	public static void main(String args[])throws Exception{
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new GridBagLayout());
/*public GridBagConstraints(int gridx, int gridy, 
int gridwidth, int gridheight, double weightx, 
double weighty, int anchor, int fill, Insets insets,
 int ipadx, int ipady)*/

	mywin.add(new Button("Button 1"),new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
//	mywin.add(new Button("A very very big component"),new GridBagConstraints(GridBagConstraints.RELATIVE,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
//	mywin.add(new Button("A very very big component"),new GridBagConstraints(GridBagConstraints.RELATIVE,0,1,2,0,0,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL ,new Insets(0,0,0,0),0,0));
	mywin.add(new Button("A very very big component"),new GridBagConstraints(GridBagConstraints.RELATIVE,0,2,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));

	mywin.add(new Button("Button 2"),new GridBagConstraints(0,GridBagConstraints.RELATIVE,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
	mywin.add(new Button("Button 3"),new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
	mywin.add(new MyBut("Button 4444444"),new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
	mywin.add(new MyBut("Button 5555555"),new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));

	mywin.setSize(400,400);
		mywin.show();
	}
}
