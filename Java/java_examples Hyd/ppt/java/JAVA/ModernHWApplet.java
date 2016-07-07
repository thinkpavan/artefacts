// ModernHWApplet.java
// Andrew Davison, March 2002, dandrew@ratree.psu.ac.th

/* Show how to paint in an applet by subclassing JPanel. */


import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;   // not needed

public class ModernHWApplet extends JApplet 
{
   public void init()
   {
     Container c = getContentPane();
     c.setLayout( new BorderLayout() );   

     // A paint panel above a label
     HWPaintPanel pp = new HWPaintPanel();
	 c.add( pp, "Center");
     JLabel lab = new JLabel( "A Nice Label" );      // not necessary
	 c.add( lab, "South" );      // not necessary
   } // end of init()

} // end of ModernHWApplet class



class HWPaintPanel extends JPanel
/* A panel used for as a 'paint' canvas
   This class will be made more complex later,
   to deal with animation, user interaction, etc.

   This same class can be used in applications also.
*/
{
  public HWPaintPanel()
  {
    setBackground(Color.white);
    // other initialisation stuff goes here
  } // end of HWPaintPanel() constructor


  public void paintComponent(Graphics g)
  { 
    super.paintComponent(g);   // repaint standard stuff first

    // painting operations go here....
    g.drawString("Hello World... in a JPanel", 75, 100);
  }

} // end of HWPaintPanel

