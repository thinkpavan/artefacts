import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MyApplet extends Applet implements ActionListener
{
 AppletContext ctx;
 TextField uid,pwd;

 public void init()
 {
  String u=getParameter("uid");
  String p=getParameter("pwd");
  setLayout(new BorderLayout());
  Panel f=new Panel();
  Panel bp=new Panel();
  f.setLayout(new GridLayout(2,2,10,10));
  bp.setLayout(new FlowLayout());
  Button b;

  ctx=getAppletContext();

  f.add(new Label("Username:"));
  f.add(uid=new TextField(20));
  f.add(new Label("Password:"));
  f.add(pwd=new TextField(20));
  pwd.setEchoChar('*');
  bp.add(b=new Button("Show Servlet"));
  uid.setText(u);pwd.setText(p);
  add(new Label("  "),BorderLayout.NORTH);
  add(new Label("  "),BorderLayout.EAST);
  add(new Label("  "),BorderLayout.WEST);
  add(f,BorderLayout.CENTER);
  add(bp,BorderLayout.SOUTH);
  b.addActionListener(this);
 }

 public void actionPerformed(ActionEvent ae)
 {
  try
  {
  java.net.URL u=new java.net.URL("http://trendz:7001/Seetharam/MyServlet?uid="+uid.getText()+"&pwd="+pwd.getText());
  ctx.showDocument(u);
  }catch(Exception e){e.printStackTrace();}
 }
}
  