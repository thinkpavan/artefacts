#include<iostream.h>

// Friend class

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

       // Declaring a class as friend
       friend class Data;
	   void AcceptFromData(Data T)
	  {
		 a = T.c;
         b = T.d;
	  }
   };

 class Data
   {
     float  c;
     int    d;

     public :
      void Accept(float cx,int  dx)
       {
		  c = cx;
		  d = dx; 
	  }
      void Display()
       {
		 cout<<"\n C  is  :  "<<c;
		 cout<<"\n D  is  :  "<<d;
       }

      void AcceptFromSample(Sample  T)
	  {
		 c = T.a;
         d = T.b;
	  }
       friend class Sample;

 };

 void main()
   {
     Sample  S;
     Data    D;

     S.Read(1,2);
     D.AcceptFromSample(S);

     S.Show();
     D.Display();

   }
