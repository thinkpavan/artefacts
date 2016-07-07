
// ConsoleAdd.java
// Slides3 Example

import corejava.* ;


public class ConsoleAdd
{ 
  public static void main(String[] args) 
  {  
    int x, y, z ;
    x = Console.readInt("Enter first integer:");
    y = Console.readInt("Enter second integer:");

	z = x + y;
   
    System.out.println("Adding them gives: " + z);
   }

} // end of ConsoleAdd.java  
