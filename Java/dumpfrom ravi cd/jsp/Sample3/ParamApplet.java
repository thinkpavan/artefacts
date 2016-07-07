import  java.applet.*;
import  java.awt.*;
public  class  ParamApplet  extends  Applet
{
 String s;
 int x,y;
 public void init()
 {
 s=getParameter("p");
 x=Integer.parseInt(getParameter("x"));
 y=Integer.parseInt(getParameter("y"));
 }
 public  void  paint(Graphics g)
 {
   g.setFont(new Font("TimesNewRoman",Font.BOLD+Font.ITALIC,30));
   g.setColor(Color.red);
   g.drawString(s,x,y);
 }
}
