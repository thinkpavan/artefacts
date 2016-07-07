
/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class lwcomp1 extends Component {
  Image img1,img2; 
  String label = "Button";
  ActionListener al;
  protected boolean pressed = false;


  public lwcomp1(String i1, String i2) {
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
		ActionEvent a = new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"but");
           System.out.println(this);
		  processEvent(a);
                break; 
      }
       super.processMouseEvent(e);
 }

public void addActionListener(ActionListener l){
	al = l;
	enableEvents(AWTEvent.ACTION_EVENT_MASK);
	System.out.println(" action Listener added");
}

public void processEvent(AWTEvent e){
	System.out.println(" in process event");
	if( e instanceof ActionEvent){
		processActionEvent((ActionEvent) e);
	}
	  super.processEvent(e);
}
public void processActionEvent(ActionEvent e){
	System.out.println(" in process action event");
	al.actionPerformed(e);
}

}