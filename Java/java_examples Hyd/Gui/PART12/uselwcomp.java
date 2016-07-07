import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/* Shows how to create a lightweight component
Version -1.0
Author Team -J
*/
public class uselwcomp{
 public static void main(String args[]){
	Frame f = new Frame();
	f.setLayout(new FlowLayout());
	lwcomp b = new lwcomp("fdggf");
	f.add(b);
	f.pack();
	f.show();
 }

}