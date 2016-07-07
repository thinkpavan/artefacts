/*  shows how to Use JTree
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.beans.*;
import java.io.*;
public class UseJTree{
	public static void main(String args[]){
			JFrame jf = new JFrame("Frame with tree");
			Container cp = jf.getContentPane();
			JTree jt = new JTree();
			cp.add(jt);
			jf.setBounds(20,20,400,400);
			jf.show();
	}		
}


