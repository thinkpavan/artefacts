// ShowColors.java
// Andrew Davison, August 2002, dandrew@ratree.psu.ac.th

/* Show how to paint in an application by subclassing JPanel.
   Also includes some code for centering the window.

   Display some colours.
*/

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;  // not needed

public class ShowColors extends JFrame 
{
   public ShowColors()
   {
     super( "Show Colors" );
     Container c = getContentPane();
     c.setLayout( new BorderLayout() );   

     // A paint panel above a label
     ColourPaintPanel pp = new ColourPaintPanel();
	 c.add( pp, "Center");
     JLabel lab = new JLabel( "A Nice Label" );    // not necessary
	 c.add( lab, "South" );  // not necessary

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     // setSize(300,200); 
     centerFrame();
 
     show();
   } // end of ShowColors()


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
   { new ShowColors();  } 

} // end of ShowColors class



class ColourPaintPanel extends JPanel
/* A panel used for as a 'paint' canvas
   Illustrates some Colour methods.

   This same class can be used in applets also.
*/
{
  public ColourPaintPanel()
  {
    setBackground(Color.white);
    // other initialisation stuff goes here
  } // end of ColourPaintPanel() constructor


  public void paintComponent(Graphics g)
  { 
    super.paintComponent(g);   // repaint standard stuff first

    // painting operations go here....

    // set new drawing color using integers
    g.setColor( new Color( 255, 0, 0 ) );
    g.fillRect( 25, 25, 100, 20 );
    g.drawString( "Current RGB: " + g.getColor(), 130, 40 );

    // set new drawing color using floats
    g.setColor( new Color( 0.0f, 1.0f, 0.0f ) );
    g.fillRect( 25, 50, 100, 20 );
    g.drawString( "Current RGB: " + g.getColor(), 130, 65 );

    // set new drawing color using static Color objects
    g.setColor( Color.blue );
    g.fillRect( 25, 75, 100, 20 );
    g.drawString( "Current RGB: " + g.getColor(), 130, 90 );
   
    // display individual RGB values
    Color c = Color.magenta;
    g.setColor( c );
    g.fillRect( 25, 100, 100, 20 );
    g.drawString( "RGB values: " + c.getRed() + ", " +
       c.getGreen() + ", " + c.getBlue(), 130, 115 );
  }

} // end of ColourPaintPanel

