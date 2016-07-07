/*  shows how to Use JDesktopPane/JInernalFrame with constrained
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
public class UseJDeskTop3{
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);

		JFrame jf = new JFrame();
		DeskTop3 dt = new DeskTop3(3);
		jf.getContentPane().add(dt);
		jf.pack();
		jf.show();
	}		
}

//JDeskTopPane is derived from JLayeredPane
class DeskTop3 extends JDesktopPane implements VetoableChangeListener{
	JInternalFrame jif[];
	String jifnames[]={"Image Frame","Graph Frame","Description Frame"};
	public DeskTop3(int nof){
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
			jif[i].addVetoableChangeListener(this);
		}
	}
// implementation of vetoablechangeevent

public void vetoableChange(PropertyChangeEvent pce) throws
	PropertyVetoException	{
	System.out.println(pce.getPropertyName());
			System.out.println(pce.getOldValue() + "   "+pce.getNewValue());
		if (pce.getPropertyName().equals("closed")){
			throw new PropertyVetoException("This frame cannot be closed",pce);
				}
		throw new PropertyVetoException("operation not permitted on frame",pce);	}
}


