/*  shows how swing uses UIResouce interface
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*; //for uiresource
// javax signifies that this package is an extension to java core packages
import javax.swing.*;
import javax.swing.border.*;

public class UseUIR{
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		jframe.getRootPane().setDoubleBuffered(false);
            ImageIcon ic = new ImageIcon("ic.gif");
		JLabel jl = new JLabel(" j label");
		jl.setForeground(Color.red);

	//	jl.setForeground(new ColorUIResource(Color.red));
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1",new ImageIcon("ie.gif"));
	//	button1.setForeground(new ColorUIResource(Color.red));
		button1.setForeground(Color.red);
	//	button1.setBorder( new BevelBorder(1));
		button1.setBorder( new BorderUIResource.BevelBorderUIResource(1));
		button1.setPreferredSize(new Dimension(100,100));
		cp.add(jl);
		cp.add(button1);
	
		cp.setLayout(new FlowLayout());
		jframe.pack();
		jframe.show();
Thread.currentThread().sleep(4000);
System.out.println("after changing lf");
	LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);
		SwingUtilities.updateComponentTreeUI(cp);

	}
}




