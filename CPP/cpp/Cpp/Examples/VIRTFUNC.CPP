#include<iostream.h>
#include<iostream.h>
 class Base
  {
     protected :
     int  a,b;

     public :
       void Read(int ax,int bx)
	{
	  a = ax;
          b = bx;
	}
       void Show()
	{
	  cout<<"\n A  is  :  "<<a;
	  cout<<"\n B  is  :  "<<b;
	}
  };

  class Derived : public Base
   {
     int  s;
     public :
      void Show()
       {
	 s = a + b;
         cout<<"\n Sum  is  :  "<<s;
       }
   };

   void main()
     {

     }

   