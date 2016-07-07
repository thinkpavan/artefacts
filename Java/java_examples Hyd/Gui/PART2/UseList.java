/* Demonstrates how to use List
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class UseList {
	public static void main(String args[]){
		MyFrame4 mywin = new MyFrame4("Employee Information");
		mywin.setLayout(new FlowLayout());
		mywin.pack();
		mywin.show();
	}
}
class MyFrame4 extends Frame {
	List mychoice;
	Panel p1,p2,p3;
	TextArea remarks;
	TextField name;
	public MyFrame4(String title){
		super(title);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		// to display 3 items and to allow multiple selection
		mychoice = new List(3,true);
		add(p1);
		add(p2);
		add(p3);
		p1.add(mychoice);
		mychoice.addItem(" Maths");
		mychoice.addItem(" Physics ");
		mychoice.addItem(" Chemistry ");
		mychoice.addItem(" Computers ");
		mychoice.addItem(" Statistics ");
		mychoice.addItem(" Law ");
		// prepare second panel
		name = new TextField("   empname    ");
		p2.add(new Label("Emp Name"));
		p2.add(name);
		// prepare third panel
		remarks= new TextArea("                         ",3,30,TextArea.SCROLLBARS_NONE);
		p3.add(new Label("Remarks"));
		p3.add(remarks);
	}
	
}


