/*  shows how to Use JTextPane
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
import javax.swing.text.*;
import javax.swing.text.html.*;
public class UseJText1 {
	public static void main(String args[])throws Exception{
		JTP1 jsp = new JTP1();
		jsp.show();
	}		
}

class JTP1 extends JFrame {
	JTextPane jtp;
	JMenuBar jb;
	JScrollPane jsp;
	public JTP1()throws Exception{
		super("Text Pane Demo");
	jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS 
,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		jtp = new JTextPane();
		getContentPane().add(jsp);
		getContentPane().setLayout(new FlowLayout());
		jtp.setPage("file:"+ System.getProperty("user.dir") +"\\Readme.html");
		jsp.setPreferredSize(new Dimension(500,300));
	//	jtp.setPreferredSize(new Dimension(500,300));
		jsp.setViewportView(jtp);
		pack();
	}
}

