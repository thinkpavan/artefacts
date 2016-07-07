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
public class UseJText2 {
	public static void main(String args[])throws Exception{
		JTP2 jsp = new JTP2();
		jsp.show();
	}		
}

class JTP2 extends JFrame implements HyperlinkListener{
	JTextPane jtp;
	JMenuBar jb;
	JScrollPane jsp;
	public JTP2()throws Exception{
		super("Text Pane Demo");
	jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS 
,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		jtp = new JTextPane();
		getContentPane().add(jsp);
		getContentPane().setLayout(new FlowLayout());
		jtp.setPage("file:"+ System.getProperty("user.dir") +"\\Readme.html");
		jtp.addHyperlinkListener(this);
		jsp.setPreferredSize(new Dimension(500,300));
	//	jtp.setPreferredSize(new Dimension(500,300));
		jtp.setEditable(false);
		jsp.setViewportView(jtp);
		pack();
	}
	// implementation of hyperlink listener
		public void hyperlinkUpdate(HyperlinkEvent hle) {
			JTextPane jt = (JTextPane) hle.getSource();
			try { 
				jt.setPage(hle.getURL());
				}
				catch(Exception ex) {  }
			System.out.println(hle.getURL());
//we can't do anything for the bugs that are still in swing classes
			}
//enhance 
}

