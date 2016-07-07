/*  shows how a button can hold another button
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class DbgGra {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		jframe.getRootPane().setDoubleBuffered(false);
            ImageIcon ic = new ImageIcon("ic.gif");
		JLabel jl = new JLabel(" j label",ic,SwingConstants.LEFT);
		System.out.println("icon height  ="+ ic.getIconHeight());
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1",new ImageIcon("ie.gif"));
System.out.println(button1.isDoubleBuffered());
            button1.setPreferredSize(new Dimension(100,100));
		JButton button2 = new JButton("Button2");
		cp.add(button1);
		cp.add(jl);
		button1.add(button2);
	//	button1.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION|DebugGraphics.LOG_OPTION);
	//	button1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
	//	button1.setDebugGraphicsOptions(DebugGraphics.BUFFER_OPTION);
	//	button1.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);

		cp.setLayout(new FlowLayout());
		jframe.pack();
		jframe.show();
	}
}




