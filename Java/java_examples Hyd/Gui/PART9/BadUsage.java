/*  shows why we should not add internal frame to
frame directly
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
public class BadUsage{
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);

		JFrame jf = new JFrame();
		Container cp = jf.getContentPane();
		cp.setLayout(new FlowLayout());
	JInternalFrame	jif[]= new JInternalFrame[3];
		for(int i =0;i <3;i++){
			jif[i] = new JInternalFrame(" internal frame" +i);
			jif[i].setPreferredSize(new Dimension(200,150));
			cp.add(jif[i]);
			jif[i].getContentPane().add(new JButton("button"));
		}

		jf.pack();
		jf.show();
	}		
}

