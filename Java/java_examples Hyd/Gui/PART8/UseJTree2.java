/*  shows how to Use JTree
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
public class UseJTree2{
	public static void main(String args[]){
		TreeFrame tf = new TreeFrame();
		tf.show();
	}		
}
class TreeFrame extends JFrame implements TreeSelectionListener{
	public TreeFrame(){
		super("Frame with tree");
		Container cp = getContentPane();
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
		jt.addTreeSelectionListener(this);
		setBounds(20,20,400,400);
		jt.setEditable(true);
	}
	// implementation of TreeSelectionListener
	public void valueChanged(TreeSelectionEvent tse){
		System.out.println(" Tree Selection Changed");
		// let us find out the newely selected item
		TreePath tp = tse.getNewLeadSelectionPath();
		System.out.println("Path of selected component = "+ tp);
		System.out.println(" componenet selected = " + tp.getLastPathComponent());	
		System.out.println(tp.getPathCount());	
	}
/* JTree generates treemodelevents,treeexpansionevents,changeevents also
TreeModelEvents are fired when nodes are inserted,removed and when nodes
are changed.
TreeExpansionEvents are fired when nodes are expanded and collapsed
ChangeEvents are fired when editing is stopped or canceled.*/
// implement changeevent listener to capture change events

}


