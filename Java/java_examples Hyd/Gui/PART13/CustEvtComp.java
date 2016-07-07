
/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class CustEvtComp extends Component {
  Image img1,img2; 
  String label = "Button";
  CustListener cl;
  protected boolean pressed = false;


  public CustEvtComp(String i1, String i2) {
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
		break;
	   case MouseEvent.MOUSE_CLICKED:
		CustEvent a = new CustEvent(this,CustEvent.CUST_ACTION1);
           System.out.println(this);
		this.dispatchEvent(a);
		  //processEvent(a);
                break; 
      }
       super.processMouseEvent(e);
 }

public void addCustListener(CustListener l){
	cl = l;
	System.out.println(" Cust Listener added");
}

public void processEvent(AWTEvent e){
	System.out.println(" in process event");
	if( e instanceof CustEvent){
		processCustEvent((CustEvent) e);
	}
	  super.processEvent(e);
}
public void processCustEvent(CustEvent e){
	System.out.println(" in process cust  event");
      if (e.getID() == CustEvent.CUST_ACTION1)
		cl.CustAction1(e);
}

}