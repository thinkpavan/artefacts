/*  shows how to create an useful form 
EmpForm
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class EmpForm {
	public static void main(String args[])throws Exception{
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new GridBagLayout());
/*public GridBagConstraints(int gridx, int gridy, 
int gridwidth, int gridheight, double weightx, 
double weighty, int anchor, int fill, Insets insets,
 int ipadx, int ipady)*/
// we need not know about text boxes and labels to understand this example
// assume that textbox and label all also componenets like buttons
	mywin.add(new Label("Employee Name"),new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
	mywin.add(new TextField("                         "),new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
	mywin.add(new Label("Emp No"),new GridBagConstraints(0,GridBagConstraints.RELATIVE,1,1,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
	mywin.add(new TextField("               "),new GridBagConstraints(GridBagConstraints.RELATIVE,1,1,1,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
// observe the change in top insets
	mywin.add(new Button("Submit"),new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.NONE,new Insets(10,0,0,0),0,0));
	mywin.add(new Button("Cancel"),new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(10,0,0,0),0,0));
//observe change in grid width
	mywin.add(new Label("We  can add any no of comp/containers as shown above"),new GridBagConstraints(0,GridBagConstraints.RELATIVE,3,1,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));


		mywin.pack();
		mywin.show();
	}
}

