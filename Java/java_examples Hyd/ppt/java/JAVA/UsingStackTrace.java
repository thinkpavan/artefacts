// Fig. 14.10: UsingStackTrace.java
// Demonstrating the getMessage and printStackTrace
// methods inherited into all exception classes.
public class UsingStackTrace {
   public static void main( String args[] )
   {
      try {
         method1();
      }
      catch ( Exception e ) {
         System.err.println( e.getMessage() + "\n" );
         e.printStackTrace();
      }
   }

   public static void method1() // throws Exception
   {
      method2();
   }

   public static void method2() throws Exception
   {
      method3();
   }

   public static void method3() throws Exception
   {
      throw new Exception( "Exception thrown in method3" );
   }
}

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
