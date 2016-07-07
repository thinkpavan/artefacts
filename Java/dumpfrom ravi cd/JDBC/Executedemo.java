import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class Executedemo extends Frame implements ActionListener
{
 Button b1;
 TextField tf;
 TextArea ta;
static  String str1,str2;
Executedemo()
    {
     b1=new Button("Click");
     tf=new TextField();
     ta=new TextArea(10,5);
     ta.setBackground(Color.yellow);
     add("North",tf);
     add("Center",ta);
     add("South",b1);
     b1.addActionListener(this);
    }
public static void main(String[] args)
 {
  Frame f= new Executedemo();
  f.setSize(300,300);
  f.setVisible(true);
  str1=args[0];
  str2=args[1];
 }
 public void actionPerformed(ActionEvent e)
 {
  try
  {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con=DriverManager.getConnection("Jdbc:Odbc:sreedevi","gscl","granada");
    String str=tf.getText();
    if(str.startsWith("select"))
    {
      Statement st=con.createStatement();
      ResultSet rs=st.executeQuery("select * from emprecord");
      while(rs.next())
      {
        int eno=rs.getInt(1);
        String ename=rs.getString(2);
        int sal=rs.getInt(3);
        ta.append(eno+" " +ename+ " "+ " " +sal + "\n");
        System.out.println("Eno is" +eno+"Ename is" +ename +"sal is" + sal);
      }
    }
    if(str.startsWith("delete"))
    {
      PreparedStatement pst=con.prepareStatement("delete from emprecord where eno=?");
      pst.setInt(1,Integer.parseInt(str1));
      pst.executeUpdate();
    }
    if(str.startsWith("update"))
    {
      Statement st=con.createStatement();
      int no= st.executeUpdate("update emprecord  set sal="+str1+" where eno="+str2);
      ta.append(no+"no of rows updated");
    }

   }catch(Exception ex){ex.printStackTrace();}
  }
 }

