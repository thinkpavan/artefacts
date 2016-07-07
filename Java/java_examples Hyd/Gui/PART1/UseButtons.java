/*  shows how to respond to  button events
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class UseButtons {
	public static void main(String args[]){
		MyFrame1 mywin = new MyFrame1("My own Frame");
		mywin.setSize(new Dimension(400,400));
		mywin.show();
	}
}



class MyFrame1 extends Frame{
	Button b1,b2;
	Label l1;
	public MyFrame1(String s){
		super(s);
		b1 = new Button("button1");
		b2 = new Button("button2");
		setLayout( new FlowLayout());  // what is this !!
		add(b1);
		add(b2);
		add(l1 = new Label (" this is a lable componenet"));
		
	}
}
