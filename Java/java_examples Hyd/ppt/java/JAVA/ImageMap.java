// Fig. 16.7: ImageMap.java
// Demonstrating an image map.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageMap extends JApplet {
   private ImageIcon mapImage;
   private int width, height;

   public void init()
   {
      addMouseListener(
         new MouseAdapter() {
            public void mouseExited( MouseEvent e )
            {
               showStatus( "Pointer outside applet" );
            }
         }
      );

      addMouseMotionListener(
         new MouseMotionAdapter() {
            public void mouseMoved( MouseEvent e )
            {
               showStatus( translateLocation( e.getX() ) );
            }
         }
      );

      mapImage = new ImageIcon( "icons2.gif" ); 
      width = mapImage.getIconWidth();
      height = mapImage.getIconHeight();
      setSize( width, height );
   }

   public void paint( Graphics g )
   {
      mapImage.paintIcon( this, g, 0, 0 );
   }

   public String translateLocation( int x )
   {
      // determine width of each icon (there are 6)
      int iconWidth = width / 6;

      if ( x >= 0 && x <= iconWidth ) 
         return "Common Programming Error";
      else if ( x > iconWidth && x <= iconWidth * 2 )
         return "Good Programming Practice";
      else if ( x > iconWidth * 2 && x <= iconWidth * 3 )
         return "Performance Tip";
      else if ( x > iconWidth * 3 && x <= iconWidth * 4 )
         return "Portability Tip";
      else if ( x > iconWidth * 4 && x <= iconWidth * 5 )
         return "Software Engineering Observation";
      else if ( x > iconWidth * 5 && x <= iconWidth * 6 )
         return "Testing and Debugging Tip";

      return ""; 
   }
} 
