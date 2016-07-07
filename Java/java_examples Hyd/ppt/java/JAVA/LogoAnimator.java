
// Fig. 16.5: LogoAnimator.java
// Andrew Davison, dandrew@ratreee.psu.ac.th, August 2002

/* Animates a series of images.
   Based on Fig. 16.5 in D&D 3rd edition, but
   adjusted to use my JFRame/JPanel coding style.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogoAnimator extends JFrame
{

  public LogoAnimator()
  {
    super("LogoAnimator");
    Container c = getContentPane();
    c.setLayout( new BorderLayout() );
    
    // a paint panel
    LogoAnimatorPanel pp = new LogoAnimatorPanel();
    c.add(pp, BorderLayout.CENTER);

    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setSize(170, 110);   // chosen by guesswork
    show();
  } // end of LogoAnimator()


// ---------------------------------

  public static void main(String args[])
  { new LogoAnimator();  }

} // end of LogoAnimator class



// -------------------------------------------------------

class LogoAnimatorPanel extends JPanel
                          implements ActionListener 
{
   private ImageIcon images[];
   private int totIms = 30, currImIdx = 0,
                 delay = 50; // 50 millisecond delay
   private Timer animTimer = null;

   public LogoAnimatorPanel()
   {
      images = new ImageIcon[totIms];
      for (int i = 0; i < images.length; i++) 
         images[i] = new ImageIcon("images/deitel" + i + ".gif");
      startAnimation();
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      images[currImIdx].paintIcon(this, g, 0, 0);
      currImIdx = (currImIdx + 1) % totIms;
   }

   public void actionPerformed( ActionEvent e )
   {  repaint();  }


   public void startAnimation()
   {
      if (animTimer == null) {
        currImIdx = 0;  
        animTimer = new Timer(delay, this);
        animTimer.start();
      }
      else  // continue from last image displayed
         if (!animTimer.isRunning())
           animTimer.restart();
   } // end of startAnimation()

   public void stopAnimation()
   { animTimer.stop();  }

}  // end of LogoAnimatorPanel class
