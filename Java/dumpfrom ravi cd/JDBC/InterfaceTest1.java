
import AccessPkg.Interface1;

class InterfaceTest1 implements Interface1
{
  public void display()
  {
    System.out.println(" hai how are you ");
  }

  public static void main(String args[])
  {

   InterfaceTest1 it=new InterfaceTest1();
   it.display();

  }
}

