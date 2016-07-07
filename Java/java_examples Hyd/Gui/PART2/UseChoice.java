/* Demonstrates how to use Choice
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class UseChoice {
	public static void main(String args[]){
		MyFrame3 mywin = new MyFrame3("Employee Information");
		mywin.setLayout(new FlowLayout());
		mywin.pack();
		mywin.show();
	}
}
class MyFrame3 extends Frame{
	Choice mychoice;
	Panel p1,p2;
	Checkbox regularemp,female,above30,abovenormalheight;
	public MyFrame3(String title){
		super(title);
		p1 = new Panel();
		p2 = new Panel();
		mychoice = new Choice();
		p1.add(mychoice);
		mychoice.addItem(" Bsc : Mpc ");
		mychoice.addItem(" Bsc : Bpc ");
		mychoice.addItem(" Bsc : Bzc ");
		mychoice.addItem(" Bcom : Maths ");
		mychoice.addItem(" Bsc : Stat ");
		mychoice.addItem(" Bsc : Comp ");
		female= new Checkbox("Female",true);
		above30 =new Checkbox("above30"); //we need not explicitly set value to false
		abovenormalheight = new Checkbox("Above Normal Height");
		p2.add(female);
		p2.add(above30);
		p2.add(abovenormalheight);
		add(p1);
		add(p2);
		}
		
}

