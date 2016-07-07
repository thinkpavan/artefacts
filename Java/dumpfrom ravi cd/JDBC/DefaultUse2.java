
import AccessPkg.DefaultTest;

  class DefaultUse2 extends DefaultTest
  {
    public static void main(String args[])
    {
      DefaultUse2 p=new DefaultUse2();

      p.display();

   /*   p.disp();
      cannot be access out of the package
      even if we make a sub class of them

      p.i=200;
      p.disp(); */
      



    }
  }

