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
public class UseJSP2 {
	public static void main(String args[])throws Exception{
		JSP2 jsb = new JSP2();
		jsb.show();
	}		
}
// split panes fires property change events when ever the bound properties
// are changed
class JSP2 extends JFrame implements PropertyChangeListener{
	JPanel rp,lp;
	JSplitPane js;
	public JSP2(){
		super("Split Pane Demo");
		rp = new JPanel();
		lp = new JPanel();
		js = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rp.setMinimumSize(new Dimension(50,50));
		lp.setMinimumSize(new Dimension(50,50));
		getContentPane().add(js);
		setBounds(10,10,400,400);
		js.setRightComponent(rp);
		js.setLeftComponent(lp);
		lp.add(new Label("I am in lp"));
		rp.add(new Label("U can add any comp here"));//may be a bug
		js.addPropertyChangeListener(this);
	}
//impl of property listener methods
	public void propertyChange(PropertyChangeEvent pce){
		if(pce.getPropertyName().equals(JSplitPane.LAST_DIVIDER_LOCATION_PROPERTY)){
			Component rc,lc;
			JSplitPane jsp = (JSplitPane) pce.getSource();
			rc = jsp.getRightComponent();
			lc = jsp.getLeftComponent();
			System.out.println(lc.getClass() + "  "+ rc.getClass());
			int ldl;
			System.out.println(ldl = jsp.getLastDividerLocation());
			jsp.setDividerLocation(ldl);// this may be a bug
			System.out.println(jsp.getDividerLocation());
		}
	}
}

