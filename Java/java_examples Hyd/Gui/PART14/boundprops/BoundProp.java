
/* Shows how to create use bound properties
Version -1.0
Author Team -J
*/

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class BoundProp extends Component {
  Image img1,img2; 
  String label = "Button";
  ActionListener al;
// let us consider the property pressed as bound property
// i.e when ever we change this property we need to intimate
// PropertyChange event
  protected boolean pressed = false;


  public BoundProp(String i1, String i2) {
     img1 = Toolkit.getDefaultToolkit().getImage(i1);
       img2 = Toolkit.getDefaultToolkit().getImage(i2);
      enableEvents(AWTEvent.MOUSE_EVENT_MASK);
  } 

  public void paint(Graphics g) {
      if(pressed) {
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
         pressed = true;// here we are changing the property
// which in this case is a bound property so we can use
// firepropertychange(propname,object  old value,Object new value)
	firePropertyChange("myprop1",new Boolean(true),new Boolean(false));
        repaint(); 
            break;  
        case MouseEvent.MOUSE_RELEASED:
    		if(pressed == true) {
                pressed = false;
firePropertyChange("myprop1",new Boolean(false),new Boolean(true));

                repaint();
           	 }   
	         break;
          case MouseEvent.MOUSE_ENTERED: // rectify the bug ????
		 pressed = true;
       		 repaint(); 
	           break;
          case MouseEvent.MOUSE_EXITED:
	            if(pressed == true) {
	                pressed = false;
                     repaint();
// we can use any name for property name here but the general convention
// is use the same name which we have used for the variable (pressed)
		firePropertyChange("myprop1",new Boolean(true),new Boolean(false));
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