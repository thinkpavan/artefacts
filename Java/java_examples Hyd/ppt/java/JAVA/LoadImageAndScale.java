// Fig. 16.1: LoadImageAndScale.java
// Load an image and display it in its original size
// and scale it to twice its original width and height.
// Load and display the same image as an ImageIcon.

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class LoadImageAndScale extends JApplet {
   private Image logo1;  
   private ImageIcon logo2;   

   // load the image when the applet is loaded
   public void init()
   {
      logo1 = getImage( getDocumentBase(), "logo.gif" );
      logo2 = new ImageIcon( "logo.gif" );
   }

   // display the image
   public void paint( Graphics g )
   {
      // draw the original image
      g.drawImage( logo1, 0, 0, this );

      // draw the image scaled to fit the width of the applet
      // and the height of the applet minus 120 pixels
      g.drawImage( logo1, 0, 120,
                   getWidth(), getHeight() - 120, this );

      // draw the icon using its paintIcon method
      logo2.paintIcon( this, g, 180, 0 );
   }
}