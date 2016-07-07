/*  shows how to add splits to the pane
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
public class UseJSP1 {
	public static void main(String args[])throws Exception{
		JSP jsb = new JSP();
		jsb.show();
	}		
}

class JSP extends JFrame {
	JSplitPane js;
	public JSP(){
		super("Split Pane Demo");
		js = new JSplitPane();
		getContentPane().add(js);
		setBounds(10,10,400,400);
		js.setContinuousLayout(true);//redraws components when the split is dragged
		js.setDividerSize(40);
	}
}

