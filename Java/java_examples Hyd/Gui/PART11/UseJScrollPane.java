/*  shows how to Use ScrollPane
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
public class UseJScrollPane {
	public static void main(String args[])throws Exception{
		JSP jsp = new JSP();
		jsp.show();
	}		
}

class JSP extends JFrame {
	JPanel jp;
	JButton jb;
	JScrollPane jsp,jsp2;
	public JSP(){
		super("Scroll Pane Demo");
		jb = new JButton("a gfhgfhgfhgfhgfhgfhfhgfhgfghfhfhfghfhjjgthjghjghjgfjgfjfghfghfdghdhdghddgfdgfdgfddddgfddgfdgfdgfdgfgfvery big button");
		jb.setPreferredSize(new Dimension(1000,1000));
		jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS 
,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		jsp.setPreferredSize(new Dimension(100,100));

		getContentPane().add(jsp);
		jsp.setViewportView(jb);
		getContentPane().setLayout(new FlowLayout());
		setBounds(10,10,400,400);
	jsp2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS 
,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		jsp2.setPreferredSize(new Dimension(100,100));
		jsp2.setViewportView(new JButton("button with image", new ImageIcon("iislogo.gif")));
		getContentPane().add(jsp2);


	}
}

