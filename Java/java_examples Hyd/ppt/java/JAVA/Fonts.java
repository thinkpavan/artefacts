// Fonts.java
// Andrew Davison, August 2002, dandrew@ratree.psu.ac.th

/* Show how to paint in an application by subclassing JPanel.
   Also includes some code for centering the window.

   Illustrates font manipulation.
*/

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;  // not needed

public class Fonts extends JFrame 
{
   public Fonts()
   {
     super( "Fonts Example" );
     Container c = getContentPane();
     c.setLayout( new BorderLayout() );   

     // A paint panel above a label
     FontsPaintPanel pp = new FontsPaintPanel();
	 c.add( pp, "Center");
     JLabel lab = new JLabel( "A Nice Label" );    // not necessary
	 c.add( lab, "South" );  // not necessary

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     // setSize(300,200); 
     centerFrame();
 
     show();
   } // end of Fonts()


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
   { new Fonts();  } 

} // end of Fonts class



class FontsPaintPanel extends JPanel
/* A panel used for as a 'paint' canvas
   Illustrates font manipulation.

   This same class can be used in applets also.
*/
{
  public FontsPaintPanel()
  {
    setBackground(Color.white);
    // other initialisation stuff goes here
  } // end of FontsPaintPanel() constructor


  public void paintComponent(Graphics g)
  { 
    super.paintComponent(g);   // repaint standard stuff first

    // painting operations go here....

    // set current font to Serif (Times), bold, 12pt
    // and draw a string 
    g.setFont( new Font( "Serif", Font.BOLD, 12 ) );
    g.drawString( "Serif 12 point bold.", 20, 50 );

    // set current font to Monospaced (Courier),
    // italic, 24pt and draw a string 
    g.setFont( new Font( "Monospaced", Font.ITALIC, 24 ) );
    g.drawString( "Monospaced 24 point italic.", 20, 70 );

    // set current font to SansSerif (Helvetica),
    // plain, 14pt and draw a string 
    g.setFont( new Font( "SansSerif", Font.PLAIN, 14 ) );
    g.drawString( "SansSerif 14 point plain.", 20, 90 );

    // set current font to Serif (times), bold/italic,
    // 18pt and draw a string
    g.setColor( Color.red );
    g.setFont(
       new Font( "Serif", Font.BOLD + Font.ITALIC, 18 ) );
    g.drawString( g.getFont().getName() + " " +
                  g.getFont().getSize() +
                  " point bold italic.", 20, 110 );
  }

} // end of FontsPaintPanel

