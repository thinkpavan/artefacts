
// drinks.java

public class drinks 
{
   public static void main(String[] a) 
   {
      Coffee cof1 = new Coffee(300);
      cof1.start();

	  new Coffee(270).start(); // an anonymous thread

      new Tea(250).start();  // another anonymous thread
   }
}
 
class Coffee extends Thread 
{
  private int numCups;

  public Coffee(int n)
  { numCups = n; }

   public void run() 
   {
     while(numCups > 0) {
       System.out.println(numCups + ". " +
						getName() + " likes coffee");
       numCups--;
       yield();  // must appear for solaris; optional in Win9x
     }
   }
}
 
class Tea extends Thread 
{
  private int numCups;  

  public Tea(int n)
  { numCups = n; }

   public void run() 
   {
      while(numCups > 0) {
        System.out.println(numCups + ". I like tea");
        numCups--;
        yield();   // must appear for solaris; optional in Win9x
      }
   }
}
 
