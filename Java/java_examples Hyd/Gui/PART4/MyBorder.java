/*  shows how to develop custom borders
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;
import javax.swing.border.*;

public class MyBorder extends AbstractBorder {
	public Insets getBorderInsets(Component c){
		return (new Insets(5,5,5,5)); 
	}
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
		int i;
		int compwidth = c.getSize().width;
		int compheight = c.getSize().height;
		g.setColor(Color.blue);
		g.drawRect(0,0,compwidth-2,compheight -2);
		g.setColor(Color.red);
		g.drawRect(5,5,compwidth-11,compheight -11);
		
	}


}




