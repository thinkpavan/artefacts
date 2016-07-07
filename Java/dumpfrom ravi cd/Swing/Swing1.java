//A Program on Label with JComponent.

import java.awt.*;
import javax.swing.*;
 class J_Label1 extends JComponent
{
     static JFrame mfrm;
     public void paint(Graphics g)
     {
          g.setColor(Color.cyan);
          g.drawString("A Presentation in JFrame",50,60);
      }
      public static void main(String args[])
      {
            mfrm=new JFrame("JFrame Window");
            J_Label1 obj=new J_Label1();
            mfrm.getContentPane().add("Center",obj);
            mfrm.setSize(500,500);
            mfrm.setVisible(true);
        }
}

