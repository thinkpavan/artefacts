
class PrivateTest
{
  private  int a=10;
  private  int b=20;

  void set(int a,int b)
  {
    this.a=a;
    this.b=b;
  }

  void display()
  {
    System.out.println(" a = " + a);
    System.out.println(" b = " + b);
  }
}

class PrivateTestUse
{
  public static void main(String args[])
  {
    PrivateTest pt=new PrivateTest();
    pt.display();
  
    pt.set(100,200);
    pt.display();

    //  pt.a=9090;  wrong

  }
}


