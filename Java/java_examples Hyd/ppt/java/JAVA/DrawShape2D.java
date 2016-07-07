// DrawShape2D.java
// Andrew Davison, August 2002, dandrew@ratree.psu.ac.th

/* Show how to paint in an application by subclassing JPanel.
   Also includes some code for centering the window.

   Display some colours.
*/

import javax.swing.*;
import java.awt.*;

import java.awt.geom.*;  // for Java2D shapes


public class DrawShape2D extends JFrame 
{
   public DrawShape2D()
   {
     super( "Draw Shape2D" );
     Container c = getContentPane();
     c.setLayout( new BorderLayout() );   

     // A paint panel above a label
     DrawShape2DPanel pp = new DrawShape2DPanel();
	 c.add( pp, "Center");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     // setSize(300,200); 
     centerFrame();
 
     setVisible(true);
   } // end of DrawShape2D()


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
   { new DrawShape2D();  } 

} // end of DrawShape2D class



class DrawShape2DPanel extends JPanel
/* A panel used for as a 'paint' canvas
   Illustrates Shape2D drawing.

   This same class can be used in applets also.
*/
{
  private Ellipse2D.Double circle =
      new Ellipse2D.Double(10, 10, 300, 300);
  private Rectangle2D.Double square =
      new Rectangle2D.Double(10, 10, 300, 300);


  public DrawShape2DPanel()
  {
    setBackground(Color.white);
    // other initialisation stuff goes here
  } // end of DrawShape2DPanel() constructor


  public void paintComponent(Graphics g)
  { 
    super.paintComponent(g);   // repaint standard stuff first

    // painting operations go here....

    Graphics2D g2d = (Graphics2D)g;
    g2d.fill(circle);
    g2d.draw(square);
  }

} // end of DrawShape2DPanel

