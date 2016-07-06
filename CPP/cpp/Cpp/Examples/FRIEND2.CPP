#include<iostream.h>

 // Declaring a Function as friend
 // for more than one class

 class Data;

 class Sample
   {
     int  a;
     int  b;

     public :
      void Read(int  ax,int  bx)
       {a = ax;b = bx; }
      void Show()
       {
	 cout<<"\n A  is  :  "<<a;
	 cout<<"\n B  is  :  "<<b;
       }
   friend void SumOfCubes(Sample ,Data );

   };

 class Data
   {
     float  c;
     int    d;

     public :
      void Accept(float cx,int  dx)
       {c = cx;d = dx; }
      void Display()
       {
	 cout<<"\n C  is  :  "<<c;
	 cout<<"\n D  is  :  "<<d;
       }

   friend void SumOfCubes(Sample ,Data );

   };

   void SumOfCubes(Sample  T,Data  P)
      {
	 float  res1,res2;

	 res1=(T.a * T.a * T.a) + (P.c * P.c * P.c);
	 res2=(T.b * T.b * T.b) + (P.d * P.d * P.d);

	 cout<<"\n Result 1  :  "<<res1;
	 cout<<"\n Result 2  :  "<<res2;

      }

 void main()
   {
     Sample  S;
     Data    D;

     S.Read(1,2);
     D.Accept(3,4);

     S.Show();
     D.Display();

     SumOfCubes(S,D);

   }
