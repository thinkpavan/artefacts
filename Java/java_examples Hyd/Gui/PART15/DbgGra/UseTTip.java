/*  shows how to show a tool tip on a componenet
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class UseTTip {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
	      ImageIcon ic = new ImageIcon("ic.gif");
		JLabel jl = new JLabel(" j label",ic,SwingConstants.LEFT);
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1",new ImageIcon("ie.gif"));
            button1.setPreferredSize(new Dimension(100,100));
		JButton button2 = new JButton("Button2");
		cp.add(button1);
		cp.add(jl);
		button1.add(button2);
		cp.setLayout(new FlowLayout());
		jframe.pack();
		jframe.show();
			button1.setToolTipText(" this button contains another Button");
			jl.setToolTipText(" Label's tool tip");

	//	jframe.setToolTipText("this is a frame");  ?? not a subclass oj JComponent
	}
}




