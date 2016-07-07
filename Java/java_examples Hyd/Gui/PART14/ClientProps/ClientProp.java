
/* Shows how to create use bound properties
Version -1.0
Author Team -J
*/

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
// now we are extending from Jcomponent to get support for client properties
public class ClientProp extends JComponent {
  Image img1,img2; 
  String label = "Button";
  ActionListener al;
// we want to take advantage of client property so we store the property pressed as
//client property , now we need not fire property events
//  protected boolean pressed = false;

  public ClientProp(String i1, String i2) {
     img1 = Toolkit.getDefaultToolkit().getImage(i1);
       img2 = Toolkit.getDefaultToolkit().getImage(i2);
      enableEvents(AWTEvent.MOUSE_EVENT_MASK);
	putClientProperty("myprop1",new Boolean(false));
  } 

  public void paint(Graphics g) {
      //if(pressed) {
	Boolean b = (Boolean)getClientProperty("myprop1");
	// donot use b == false directly
	if( b.equals( new Boolean(true))){
	  g.setColor(Color.orange);
	  g.fillRect(0, 0, getSize().width,getSize().height); 
          g.drawImage(img1,0,0,this);
      }
	else {
	  g.setColor(Color.blue);
	  g.fillRect(0, 0, getSize().width,getSize().height); 
          g.drawImage(img2,0,0,this);
	    }
      g.setFont(new Font("SansSerif",Font.BOLD,12));
      g.setColor(Color.black);
      g.drawString(label,5,20);    

  }  					

  public Dimension getPreferredSize() {
          return new Dimension(60, 60); 
  } 

public Dimension getMinimumSize() {
      return new Dimension(30, 30);
  }   


public void processMouseEvent(MouseEvent e) {
       Graphics g;
       switch(e.getID()) { 
         case MouseEvent.MOUSE_PRESSED:
       //  pressed = true;// here we are changing the property
	putClientProperty("myprop1",new Boolean(true));	
        repaint(); 
            break;  
        case MouseEvent.MOUSE_RELEASED:
    	//	if(pressed == true) {
               // pressed = false;
	Boolean b = (Boolean)getClientProperty("myprop1");
	// donot use b == false directly
	if( b.equals( new Boolean(true))){
		putClientProperty("myprop1",new Boolean(false));
            repaint();
     	 }   
	         break;
          case MouseEvent.MOUSE_ENTERED: // rectify the bug ????
	//	 pressed = true;
	putClientProperty("myprop1",new Boolean(true));	
       		 repaint(); 
	           break;
          case MouseEvent.MOUSE_EXITED:
	          //  if(pressed == true) {
	            //    pressed = false;
	 b = (Boolean)getClientProperty("myprop1");
	// donot use b == false directly
	if( b.equals( new Boolean(true))){
		putClientProperty("myprop1",new Boolean(false));	
            repaint();
      }
		break;
	   case MouseEvent.MOUSE_CLICKED:
		ActionEvent a = new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"but");
    //       System.out.println(this);
		  processEvent(a);
                break; 
      }
       super.processMouseEvent(e);
 }

public void addActionListener(ActionListener l){
	al = l;
	enableEvents(AWTEvent.ACTION_EVENT_MASK);
//	System.out.println(" action Listener added");
}

public void processEvent(AWTEvent e){
//	System.out.println(" in process event");
	if( e instanceof ActionEvent){
		processActionEvent((ActionEvent) e);
	}
	  super.processEvent(e);
}
public void processActionEvent(ActionEvent e){
	//System.out.println(" in process action event");
	al.actionPerformed(e);
}

}