// LinesRectsOvals.java
// Andrew Davison, August 2002, dandrew@ratree.psu.ac.th

/* Show how to paint in an application by subclassing JPanel.
   Also includes some code for centering the window.

   Illustrates the drawing of lines, rectangles, and ovals.
*/

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;  // not needed

public class LinesRectsOvals extends JFrame 
{
   public LinesRectsOvals()
   {
     super( "Lines, Rectangles, and Ovals" );
     Container c = getContentPane();
     c.setLayout( new BorderLayout() );   

     // A paint panel above a label
     LROPaintPanel pp = new LROPaintPanel();
	 c.add( pp, "Center");
     JLabel lab = new JLabel( "A Nice Label" );    // not necessary
	 c.add( lab, "South" );  // not necessary

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     // setSize(300,200); 
     centerFrame();
 
     show();
   } // end of LinesRectsOvals()


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
   { new LinesRectsOvals();  } 

} // end of LinesRectsOvals class



class LROPaintPanel extends JPanel
/* A panel used for as a 'paint' canvas
   Illustrates the drawing of lines, rectangles, and ovals.

   This same class can be used in applets also.
*/
{
  public LROPaintPanel()
  {
    setBackground(Color.white);
    // other initialisation stuff goes here
  } // end of LROPaintPanel() constructor


  public void paintComponent(Graphics g)
  { 
    super.paintComponent(g);   // repaint standard stuff first

    // painting operations go here....
    g.setColor( Color.red );
    g.drawLine( 5, 30, 350, 30 );

    g.setColor( Color.blue );
    g.drawRect( 5, 40, 90, 55 );
    g.fillRect( 100, 40, 90, 55 );

    g.setColor( Color.cyan );
    g.fillRoundRect( 195, 40, 90, 55, 50, 50 );
    g.drawRoundRect( 290, 40, 90, 55, 20, 20 );

    g.setColor( Color.yellow );   
    g.draw3DRect( 5, 100, 90, 55, true );
    g.fill3DRect( 100, 100, 90, 55, false );

    g.setColor( Color.magenta );
    g.drawOval( 195, 100, 90, 55 );
    g.fillOval( 290, 100, 90, 55 );
  }

} // end of LROPaintPanel

