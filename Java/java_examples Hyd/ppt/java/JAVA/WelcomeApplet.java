// Fig. 3.6: WelcomeApplet.java
// A first applet in Java 
import javax.swing.JApplet;  // import class JApplet
import java.awt.Graphics;    // import class Graphics

public class WelcomeApplet extends JApplet {  
   public void paint( Graphics g )
   {
      g.drawString( "Welcome Andrew", 25, 25 );
   }
}
