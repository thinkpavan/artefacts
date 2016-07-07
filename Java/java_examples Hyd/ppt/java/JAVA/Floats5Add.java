// Floats5Add.java
// 2nd Feb 2005, Andrew Davison, ad@fivedots.coe.psu.ac.th

import java.io.*;
import java.util.Scanner;


public class Floats5Add
{
  public static void main(String[] args)
  {
    float num;
    float total = 0.0f;
    System.out.println("Openning " + args[0]);

    try {
      Scanner sc = new Scanner( new File(args[0]) );
      while ( sc.hasNextFloat() ) {
        num = sc.nextFloat();
        System.out.println(num);
        total += num;
      }
      sc.close();
    }
    catch(FileNotFoundException e)
    { System.out.println("Error: " + args[0] + " not found");  }

    System.out.println("Floats total = " + total );
  }
}  // end of Floats5Add class

