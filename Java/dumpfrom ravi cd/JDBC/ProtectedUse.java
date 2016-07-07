
import AccessPkg.ProtectedTest;

  class ProtectedUse
  {
    public static void main(String args[])
    {
      ProtectedTest p=new ProtectedTest();
      p.display();

      p.disp();  //  protected member cannot be accessed

    }
  }

