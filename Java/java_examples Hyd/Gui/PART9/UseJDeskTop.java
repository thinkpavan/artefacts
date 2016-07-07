/*  shows how to Use JDesktopPane
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
public class UseJDeskTop{
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);

		JFrame jf = new JFrame();
		DeskTop dt = new DeskTop(3);
		jf.getContentPane().add(dt);
		jf.pack();
		jf.show();
	}		
}

//JDeskTopPane is derived from JLayeredPane
class DeskTop extends JDesktopPane{
	JInternalFrame jif[];
	public DeskTop(int nof){
		super();
		setLayout(new FlowLayout());
		jif = new JInternalFrame[nof];
		for(int i =0;i <nof;i++){
			jif[i] = new JInternalFrame(" internal frame" +i);
			jif[i].setPreferredSize(new Dimension(200,150));
			add(jif[i]);
		}
	}

}


