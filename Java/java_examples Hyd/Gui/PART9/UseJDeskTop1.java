/*  shows how to Use JDesktopPane/JInernalFrame
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
public class UseJDeskTop1{
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);

		JFrame jf = new JFrame();
		DeskTop1 dt = new DeskTop1(3);
		jf.getContentPane().add(dt);
		jf.pack();
		jf.show();
	}		
}

//JDeskTopPane is derived from JLayeredPane
class DeskTop1 extends JDesktopPane implements InternalFrameListener{
	JInternalFrame jif[];
	String jifnames[]={"Image Frame","Graph Frame","Description Frame"};
	public DeskTop1(int nof){
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
			add(jif[i]);
			jif[i].addInternalFrameListener(this);
		}
	}
// implementation of internalframe events
	public void internalFrameActivated(InternalFrameEvent ife){
		System.out.println("internalFrameActivated");	
	}
	public void internalFrameClosed(InternalFrameEvent ife){
			System.out.println("internalFrameClosed");	
	}
	public void internalFrameClosing(InternalFrameEvent ife){
			System.out.println("internalFrameClosing");	
	}
	public void internalFrameDeactivated(InternalFrameEvent ife){
			System.out.println("internalFrameDeactivated");	
	}
	public void internalFrameDeiconified(InternalFrameEvent ife){
			System.out.println("internalFrameDeiconified");	
	}
	public void internalFrameIconified(InternalFrameEvent ife){
			System.out.println("internalFrameIconified");	
	}
	public void internalFrameOpened(InternalFrameEvent ife){
			System.out.println("internalFrameOpened");	
	}
}


