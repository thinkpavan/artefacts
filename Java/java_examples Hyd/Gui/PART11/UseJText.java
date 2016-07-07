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
public class UseJText {
	public static void main(String args[])throws Exception{
		JTP jsp = new JTP();
		jsp.show();
	}		
}

class JTP extends JFrame {
	JTextPane jtp;
	JMenuBar jb;
	public JTP(){
		super("Text Pane Demo");
		jb = new JMenuBar();
		setJMenuBar(jb);
		JMenu jm=new JMenu("Some Menu");
		jb.add(jm);
		getContentPane().add(jtp = new JTextPane());
		getContentPane().setLayout(new FlowLayout());
		jm.add( new DefaultEditorKit.PasteAction());
//so many actions are associated with defaulteditor, we need not
// write any code to take these action as every thing can be done
// as show above. Really Great Design trick at the cost of Performance
		jtp.setText("InetSolv \n Hyderabad \n A.P.,India");
		jtp.setPreferredSize(new Dimension(500,300));
	//	jtp.setBorder(BorderFactory.createEtchedBorder());
	//	jtp.setEditable(false);
		Action actions[] = jtp.getActions();
		for(int i =0;i <actions.length;i++){
			System.out.println(actions[i]);
		}
		pack();
	}
}

