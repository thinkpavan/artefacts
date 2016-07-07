//A Program for Graphical File Handling.
import java.applet.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class ioprog10 extends Applet implements ActionListener
{
     TextArea ta;
     TextField tf;
     Label l1;
     Button b1,b2,b3;
     String msg=" ";
     public void init()
     {
           ta=new TextArea(15,70);
           l1=new Label("Enter File Name with Full Path ");
           tf=new TextField(20);      
           b1=new Button("Open");
           b2=new Button("Save");
           b3=new Button("Close");
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
           add(ta);
           add(l1);
           add(tf);
           add(b1);
           add(b2);
           add(b3);
          msg="Started  ";
      }
      public void actionPerformed(ActionEvent e)
      {
            int size=-1;
            InputStream ran;
           OutputStream out;
           msg="Nothing";
          
          try{
            if(e.getActionCommand().equals("Open"))
            { 
                 ran=new FileInputStream("NEWFILE.TXT");   
                 showStatus("Hello");  
                 while((size=ran.read())!=-1)
                      msg=msg+(char)size;
                 ta.setText(msg);
                 msg="Opened";
                 ran.close();
              }
             else if(e.getActionCommand().equals("Save"))
              { 
                 out=new FileOutputStream("NFILE.TXT");   
                 msg=ta.getText();
                 while(++size<msg.length())
                       out.write((int)msg.charAt(size));
               }
            }
          catch(IOException ex)
          {
              showStatus("Hello  :  " + ex);  
           }    
         }
         public void paint(Graphics g)
         {
             g.drawString(msg,0,10);
          }  
   }


                 
           

