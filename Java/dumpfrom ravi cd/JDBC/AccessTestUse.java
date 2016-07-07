
class AccessTest
{
  int a=10;
  int b=20;
  void display()
  {
    System.out.println(" a = " + a);
    System.out.println(" b = " + b);
  }
}

class AccessTestUse
{
  public static void main(String args[])
  {
   AccessTest at=new AccessTest();
   at.display();

   at.a=100;
   at.b=200;

   at.display();
  }
}


