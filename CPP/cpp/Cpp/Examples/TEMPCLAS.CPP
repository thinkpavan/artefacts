#include<iostream.h>

 class Emp
   {
     char empno[10];
     char name[20];
      public :
    friend istream& operator>>(istream&  ,Emp& );
    friend ostream&  operator<<(ostream&  ,Emp&  );
   };


    istream& operator>>(istream&  Min,Emp& T)
      {
        cout<<endl;
	cout<<"\n Enter Empno  :  ";
	Min>>T.empno;
	cout<<"\n Enter Name   :  ";
	Min>>T.name;

         return Min;
      }

   ostream&  operator<<(ostream&  Mout,Emp&  T)
      {
        cout<<endl;
	Mout<<"\n Empno  :  "<<T.empno;
	Mout<<"\n Name   :  "<<T.name;

         return Mout;
      }

 // Template Class 

 template <class T>
 class Array
   {
     T  *list;
     int  size;
     public :
      Array(int n=5)
	{
	  size = n;
          list = new T[size];
	}
       void Read();
       void Show()	{
	  for(int i=0;i<size;i++)
           cout<<"\n Value is : "<<list[i];
	}

   };
             
   template <class T>
   void Array<T>::Read()
	 {
	   for(int i=0;i<size;i++)
	     {
	       cout<<"\n Enter value : ";
               cin>>list[i];
	     }
	 }
/*
   template <class T>
   void Array<T>::Show()
	{
	  for(int i=0;i<size;i++)
           cout<<"\n Value is : "<<list[i];
	}

*/
   void main()
     {
       Array<int>  S(5);

	S.Read();
        S.Show();

       Array<Emp>  T(3);

	T.Read();
        T.Show();

     }