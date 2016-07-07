/*  shows how to drag a component
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class DragListBox {
	public static void main(String args[]){
		DragFrame df = new DragFrame();
	//	df.show();
	}		
}

class DragFrame implements MouseMotionListener{
	 JList jlb;
	 JButton button1;
	  JLayeredPane jl;
	public DragFrame(){
		JFrame jframe = new JFrame(" This is a Swing Frame");
		String list[] = {"1","2","3","4","5","6","7","8","9"};
		jlb = new JList(list);
		Container cp = jframe.getContentPane();
		button1 = new JButton("Button1");
		cp.add(jlb);
		jlb.setBounds(30,30,200,200);
		button1.setBounds(230,230,200,200);
		cp.add(button1);
		cp.setLayout(new FlowLayout());
		jframe.setBounds(100,100,400,400);
		jframe.show();
		jl = jframe.getRootPane().getLayeredPane();
		button1.addMouseMotionListener(this);
		jlb.addMouseMotionListener(this);
		}
//fix the bug in program by finding out when the mouse dragging is finished
// Note: use mousepressed,mousereleased methods
	public void mouseDragged(MouseEvent e){
		int x = e.getX();
		int y=  e.getY();
		jl.setLayer((Component)e.getSource(),JLayeredPane.DRAG_LAYER.intValue());
		Component c = (Component) e.getSource();
		c.setBounds(x,y,200,200);
		c.getParent().repaint();
	
	}
	public void mouseMoved(MouseEvent e){
	
	}
}



