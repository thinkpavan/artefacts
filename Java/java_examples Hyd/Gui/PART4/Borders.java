/*  shows how to use Different borders
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;
import javax.swing.border.*;

public class Borders {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		Container cp = jframe.getContentPane();
		cp.setLayout(new FlowLayout());
		JButton b1 = new JButton("Empty Border");
		b1.setBorder(new EmptyBorder(5,5,5,5));
		b1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		cp.add(b1);
		JButton b2 = new JButton("Bevel (3d) lowered Border");
		b2.setBorder(BorderFactory.createLoweredBevelBorder());
		cp.add(b2);
		JButton b3 = new JButton("Bevel (3d) raised Border");
		b3.setBorder(BorderFactory.createRaisedBevelBorder());
		cp.add(b3);
		JButton b4 = new JButton("Line Border");
		b4.setBorder(BorderFactory.createLineBorder(Color.blue,5));
		cp.add(b4);
		JButton b5 = new JButton("Etched Border");
		b4.setBorder(BorderFactory.createEtchedBorder(Color.black,Color.red));
		cp.add(b5);
		JButton b6 = new JButton("Matte (withot icon) Border");
		ImageIcon ic = new ImageIcon("Bic.gif");
		b6.setBorder(BorderFactory.createMatteBorder(5,5,5,10,Color.red));
		cp.add(b6);
		JButton b7 = new JButton("Soft Bevel Border");
	//	b7.setBorder(BorderFactory.createEtchedBorder(Color.black,Color.red));
		b7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		cp.add(b7);
		JButton b8 = new JButton("Custom  Border");
		b8.setBorder(new MyBorder());
		cp.add(b8);
	// ADD A BUTTON AND SET IT'S BORDER TYPE TO TITLEDBORDER

		jframe.setBounds(10,10,400,400);
		jframe.show();
	}
}




