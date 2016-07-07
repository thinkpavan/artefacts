import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/
public class lwcomp extends Component {
  String label;  
  protected boolean pressed = false;
 // true if the button is detented.    /**

  public lwcomp(String label) {
      this.label = label;
      enableEvents(AWTEvent.MOUSE_EVENT_MASK);
  } 

  public void paint(Graphics g) {

      if(pressed) {
          g.setColor(Color.blue);
      }
	else {
          g.setColor(Color.orange);  
	    }
      g.fillRect(0, 0, getSize().width,getSize().height);  
      g.setColor(Color.white);
      g.drawString(label,30,60);    

  }  					

  public Dimension getPreferredSize() {
          return new Dimension(100, 100); 
  } 

public Dimension getMinimumSize() {
      return new Dimension(100, 100);
  }   


public void processMouseEvent(MouseEvent e) {
       Graphics g;
       switch(e.getID()) { 
         case MouseEvent.MOUSE_PRESSED:
         pressed = true;
        repaint(); 
            break;  
        case MouseEvent.MOUSE_RELEASED:
    		if(pressed == true) {
                pressed = false;
                repaint();
           	 }   
	         break;
          case MouseEvent.MOUSE_ENTERED: 
		 pressed = true;
       		 repaint(); 
	           break;
          case MouseEvent.MOUSE_EXITED:
	            if(pressed == true) {
	                pressed = false;
                     repaint();
         	 }   
         break;       }
       super.processMouseEvent(e);
 }
}