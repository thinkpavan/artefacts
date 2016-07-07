/* Program to show a simple window on the screen using 1.1 event model
This program demonstrates how to use a seperate inner class to implement 
an event listner
to mouse events.
Author : Team -J
Version : 1.0 
ToDO : This class needs to be modified in order to make it work 
*/
import java.awt.*;
import java.awt.event.*;

class awt7 extends Frame{
	 int curx=0,cury=0;
	awt7(String title){
		super(title);
		}
	
	public static void main(String agrs[]){
		 Button b1,b2;
		awt7 sampframe = new awt7("frame window");
		//sampframe.setLayout( new FlowLayout());
		sampframe.setLayout( new FlowLayout());
		b1= new Button("one");
		b2= new Button("two");
		sampframe.resize(500,400);
		System.out.println("before button size");
		//b.resize(new Dimension(10,20));
		b1.setSize(new Dimension(10,20));
		b2.setSize(new Dimension(10,20));
		sampframe.add(b1);
		sampframe.add(b2);
		System.out.println("after button size");
		// try to resize and see what happens
		sampframe.resize(500,400);
		sampframe.show();
		//System.out.println("before repaint");
		//sampframe.repaint();
		//sampframe.repaint();
		//System.out.println("before adding listener");
		// This following statement adds the mouse listener
		sampframe.addMouseListener(new awt7listener());
		System.out.println("after adding listener");
		//let us do something intresting here
		b1.addMouseListener(new awt7listener());
		//let us add a listener to b2 button also
		b2.addMouseListener(new awt7listener());
		//sampframe.resize(500,300);
		}

	/* inner class implementing event listener*/
class awt7listener implements MouseListener{
/* following mouseXXX implements MouseListener interface*/
	public void mouseClicked(MouseEvent e){
		
		System.out.println("mouse clicked" + e.getSource().toString());
		}
	public void mouseEntered(MouseEvent e){
		System.out.println("mouse enetered");
		} 
	public void mouseExited(MouseEvent e) {
		System.out.println("mouse exited");
		} 
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed");
		} 
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse released");
		} 

}
	
}
