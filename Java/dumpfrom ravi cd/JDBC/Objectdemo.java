import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class Objectdemo 
{
 Button b1;
 TextField tf;
 TextArea ta;
 Objectdemo()
 {
  b1=new Button("Click");
  tf=new TextField();
  ta=new TextArea();
  add("North",tf);
  add("Centre",ta);
  add("South",b1);
 }
 public static void main(String[] args)
 {
  Frame f= new Objectdemo();
  f.setSize(300,300);
  f.setVisible(true);
 }
}

