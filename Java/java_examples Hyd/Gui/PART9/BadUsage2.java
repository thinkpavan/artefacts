/*  shows why we cannot use show on light weight containers
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
public class BadUsage2{
	public static void main(String args[])throws Exception{
		JFrame jf = new JFrame();
		JLayeredPane jlp = new JLayeredPane();
		JDesktopPane jdp = new JDesktopPane();
		JInternalFrame jif = new JInternalFrame("internal frame");
		jf.getContentPane().add(jdp);
		jdp.add(jif);
		jlp.show();
		jdp.show();
		jif.show();
		jf.show();
// add layoutmanager and set preffered sizes of jif 
//we cannot show internalframes by using show method
	}		
}

