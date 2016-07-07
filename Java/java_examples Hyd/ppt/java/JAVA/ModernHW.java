// ModernHW.java
// Andrew Davison, August 2002, dandrew@ratree.psu.ac.th

/* Show how to paint in an application by subclassing JPanel.
   Also includes some code for centering the window.

   This code will be used as the basis of our paint examples.
*/

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;  // not needed

public class ModernHW extends JFrame 
{
   public ModernHW()
   {
     super( "Application Description in Title Bar" );
     Container c = getContentPane();
     c.setLayout( new BorderLayout() );   

     // A paint panel above a label
     HWPaintPanel pp = new HWPaintPanel();
	 c.add( pp, "Center");
     JLabel lab = new JLabel( "A Nice Label" );    // not necessary
	 c.add( lab, "South" );  // not necessary

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     // setSize(300,200); 
     centerFrame();
 
     show();
   } // end of ModernHW()


   private void centerFrame()
   /* Place the frame in the center of the screen, and make it
      quarter size. 
      Add a nice icon in the top-left of the frame.
   */
   {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setSize(screenWidth / 2, screenHeight / 2);
      setLocation(screenWidth / 4, screenHeight / 4);
      Image img = tk.getImage("sface.gif");
      setIconImage(img);
   }  // end of centerFrame()


// ------------------------------------------------------

   public static void main( String args[] )
   { new ModernHW();  } 

} // end of ModernHW class



class HWPaintPanel extends JPanel
/* A panel used for as a 'paint' canvas
   This class will be made more complex later.

   This same class can be used in applets also.
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

