#include<iostream.h>
//Program for generating Bill no
// & Counting no of Objects Created

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
	cout<<"\n No of Objects Created :"
	    <<a;
      }
 };


 int Bill::a;

 void main()
   {
     Bill  A,B,C;

      A.Read();
      B.Read();
      C.Read();

      A.Show();
      B.Show();
      C.Show();


     A.ShowCount();

   }




