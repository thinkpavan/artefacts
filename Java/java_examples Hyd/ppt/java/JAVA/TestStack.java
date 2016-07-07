
// TestStack.java
// Andrew Davison, dandrew@ratree.psu.ac.th, October 2000

import java.io.*;
import coe.ad.ds.Stack;

public class TestStack 
{  
  public static void main(String args[])
  { int el;
    Stack stk = new Stack();
    
    stk.push(42);
    stk.push(17);
    stk.pop();
    System.out.println("Top value is " + stk.topOf());
  }
  
} // end of TestStack.java
