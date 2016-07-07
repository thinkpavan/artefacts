/*  shows how to get the list of frames and manuplate them
		  using desktop methods
properties
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
public class UseJDeskTop4{
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);

		JFrame jf = new JFrame();
		DeskTop4 dt = new DeskTop4(3);
		jf.getContentPane().add(dt);
		jf.pack();
		jf.show();
		Thread.currentThread().sleep(5000);
		JInternalFrame jfs[] = dt.getAllFrames();
		for(int i =0;i<jfs.length;i++)
			jfs[i].setIcon(true);
		Thread.currentThread().sleep(5000);
		jfs = dt.getAllFrames();
		for(int i =0;i<jfs.length;i++)
			jfs[i].setIcon(false);
	}		
}

//JDeskTopPane is derived from JLayeredPane
class DeskTop4 extends JDesktopPane {
	JInternalFrame jif[];
	String jifnames[]={"Image Frame","Graph Frame","Description Frame"};
	public DeskTop4(int nof){
		super();
		setLayout(new FlowLayout());
		jif = new JInternalFrame[nof];
		for(int i =0;i <nof;i++){
			jif[i] = new JInternalFrame(jifnames[i],
			true, // this frame can be resized
			true, //this can be closed			
			true, // this can be maximized
			true);// this can be iconified
			jif[i].setFrameIcon(new ImageIcon("lock.gif"));
			jif[i].setPreferredSize(new Dimension(200,150));
			jif[i].getContentPane().setLayout(new FlowLayout());
			jif[i].getContentPane().add(new JLabel("any lwcomp can be added"));
			add(jif[i]);
		}
	}
}
