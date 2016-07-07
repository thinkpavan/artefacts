
import AccessPkg.DefaultTest;

  class DefaultUse1
  {
    public static void main(String args[])
    {
      DefaultTest p=new DefaultTest();

      p.display();

     /* p.disp();   cannot be accessed out of the package

      p.i=200;
      p.disp();
      */



    }
  }

