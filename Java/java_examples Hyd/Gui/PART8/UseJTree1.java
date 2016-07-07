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
import java.util.*;
public class UseJTree1{
	public static void main(String args[]){
			JFrame jf = new JFrame("Frame with tree");
			Container cp = jf.getContentPane();
		/* create tree hierarchy*/
	/*DefaultMutableTreeNode implements MutableTreeNode interface which extends TreeNode interface*/
			DefaultMutableTreeNode world = new DefaultMutableTreeNode("World");
			DefaultMutableTreeNode india,japan,us;
			//create country list
			india = new DefaultMutableTreeNode("India");
			japan = new DefaultMutableTreeNode("Japan");
			us = new DefaultMutableTreeNode("US");
			world.insert(india,0);
			world.insert(japan,1);
			world.insert(us,2);
			//create state list
			DefaultMutableTreeNode ap;
			india.insert(ap = new DefaultMutableTreeNode("AP"),0);
			india.insert(new DefaultMutableTreeNode("Karnataka"),1);
			india.insert(new DefaultMutableTreeNode("Tamil Nadu"),2);
			india.insert(new DefaultMutableTreeNode("Goa"),3);
			//add districts to states
		//	india.setUserObject(" this is India map");
			JTree jt = new JTree(world);
			cp.add(jt);
			jf.setBounds(20,20,400,400);
			jf.show();
			// below logic can be used to get the list of sub nodes of a node
			Enumeration e = world.children();
			for(int i = 0;i <world.getChildCount();i++){
				DefaultMutableTreeNode d = (DefaultMutableTreeNode)e.nextElement();
				System.out.println(d+ "    " + d.getChildCount() +"  "+ d.isLeaf());
				System.out.println(d.getUserObject());
			}
	}		
}


