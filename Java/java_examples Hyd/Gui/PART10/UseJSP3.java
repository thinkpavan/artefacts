/*  shows how to add split to splitpanes
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
public class UseJSP3 {
	public static void main(String args[])throws Exception{
		JSP3 jsb = new JSP3();
		jsb.show();
	}		
}

class JSP3 extends JFrame{
	JPanel rp;
	JSplitPane hsp,vsp;//horizontal and verticle split panes
	public JSP3(){
		super("Split Pane Demo");
		rp = new JPanel();
		vsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rp.setMinimumSize(new Dimension(50,50));
		getContentPane().add(vsp);
		setBounds(10,10,400,400);
		vsp.setRightComponent(rp);
		vsp.setLeftComponent(hsp = new JSplitPane());
		hsp.setRightComponent(new JLabel("Rlable"));
		hsp.setLeftComponent(new JLabel("Llabel"));
		rp.add(new Label("U can add any comp here"));
		hsp.setOneTouchExpandable(true);
//use ONE_TOUCH_EXPANDABLE_PROPERTY  property to detect when the user selects 
// epandable buttons
	}
}

