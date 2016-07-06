#include<iostream.h>
//Program for Counting no of
// Active Objects

class Bill
 {
   static int a;
   int    billno;
   char   name[20];
   float  amt;
    public :
     Bill()
     {
       a++;
       billno = a;
     }
    ~Bill()
     { a--; }

   void Read()
     {
       cout<<"\n Bill no       : "<<billno;
       cout<<"\n Enter Name    : ";
       cin>>name;
       cout<<"\n Enter Amount  : ";
       cin>>amt;
     }

   void Show()
     {
       cout<<"\n  Bill no     : "<<billno;
       cout<<"\n  Name        : "<<name;
       cout<<"\n  Amount      : "<<amt;
     }

     void ShowCount()
      {
	cout<<"\n No of Objects Active :"
	    <<a;
      }
 };


 int Bill::a = 100 ;

  void Func()
    {
       Bill  D,E;

       D.ShowCount();
    }



 void main()
   {
     Bill  A,B,C;

      

		A.Read();
		B.Read();
		C.Read();
		A.Show();
		B.Show();
		C.Show();

   }

