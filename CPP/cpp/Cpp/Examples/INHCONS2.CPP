#include<iostream.h>

// Constructors in Inheritance

class Base
  {
     int   a;
     float b;
     public :

     Base()
      {
        cout<<"\n Base Default Constructor"; 
      }

     Base(int ax,float bx)
      {
	a = ax;
        b = bx;
	cout<<"\n Base Parameterized Constructor";
      }

     void ShowBase()
      {
       cout<<"\n  A  is  :  "<<a;
       cout<<"\n  B  is  :  "<<b;
     }
  };

  class Derived : public Base
   {
     int  val;

     public :
     Derived(int x1,float x2,int x3):Base(x1,x2) 
      {
	 val = x3;
	 cout<<"\n Derived Constructor";
      }

    void Show()
      {
        ShowBase();
        cout<<"\n  Val is  : "<<val;
      }
   };

 void main()
   {

     Derived  D(11,45.57,90);

     D.Show();
   }
