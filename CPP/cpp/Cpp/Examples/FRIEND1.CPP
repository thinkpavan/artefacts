#include<iostream.h>

 // Friend Function
 class Sample
   {
     int  a;
     int  b;

     public :
      void Read(int  ax,int  bx)
       {
		  a = ax;
		  b = bx; 
	  }
      void Show()
       {
		 cout<<"\n A  is  :  "<<a;
		 cout<<"\n B  is  :  "<<b;
       }

     // Declaring function as friend
     friend int  Cube(Sample  T);
   };

  int  Cube(Sample  T)
    {
      int  res;

	  res = T.a * T.a * T.a;

      return  res;
    }

 void main()
   {
     Sample S;

     S.Read(10,20);
     S.Show();
	 int  c;
	 c = Cube(S);
     cout<<"\n  Cube  is  :  "<<c;

   }
