/*  shows how to Use JTabbedPane
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.beans.*;
import java.io.*;
import java.util.*;
public class UseJTabbedPane{
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);

		JFrame jf = new JFrame("Tabbed Frame Demo");
	//	JTabbedPane jtb= new JTabbedPane(SwingConstants.TOP);
	//	JTabbedPane jtb= new JTabbedPane(SwingConstants.BOTTOM);
		JTabbedPane jtb= new JTabbedPane(SwingConstants.LEFT);
	//	JTabbedPane jtb= new JTabbedPane(SwingConstants.RIGHT);

// this is very much similar to JLayeredPane here in this componenet
// tabs are purely logical
	//construct tabs now
	JPanel jp = new JPanel();
	jp.setLayout(new FlowLayout());
	jp.add(new JButton("Button one"));
	jp.add(new JButton("Button two"));
	jp.add(new JButton("Button three"));
	jtb.addTab("This is tab no 1",jp);
	jtb.addTab("This is second tab",new JButton("This is button"));
	jtb.addTab("This is tab no 3",new JPanel());
	jtb.addTab("This is fourth tab",new JButton("This is button"));
	jtb.addTab("This is tab no 5",new ImageIcon("lock.gif"),new JPanel());
	jtb.insertTab("This is inserted tab",new ImageIcon("lock.gif"),
		new JButton("This is on it")," This is a tip",2);

		jf.getContentPane().add(jtb);
		jf.getContentPane().setLayout(new FlowLayout());
		jtb.setPreferredSize(new Dimension(400,400));
		
		jf.pack();
		jf.show();
	}		
}

