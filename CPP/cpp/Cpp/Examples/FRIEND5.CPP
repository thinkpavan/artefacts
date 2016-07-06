
 #include<iostream.h>
 #include<string.h>

 // Operator Overloading with friend function

 class Emp
   {

     char empno[10];
     char name[20];
     int  sal;

      public :
      Emp()
       {
	 strcpy(empno,"JC23456");
	 strcpy(name,"Unknown");
         sal = 6000;
       }

      void Read(char vempno[],char vname[],int vsal)
       {
	 strcpy(empno,vempno);
	 strcpy(name,vname);
         sal = vsal;
      }

      void Show()
      {
        cout<<endl;
	cout<<"\n Empno  :  "<<empno;
	cout<<"\n Name   :  "<<name;
	cout<<"\n Salary :  "<<sal;
      }

     friend Emp  operator + (Emp&  ,int  );
     friend Emp  operator + (Emp&  ,Emp&  );

   };

 // Overloading (+) Operator with friend function
   Emp  operator + (Emp&  T,int  val)
      {
	 Emp  E;

	   E.sal = T.sal + val;

           return E;
      }

 // Overloading (+) Operator with friend function
   Emp  operator + (Emp&  T1,Emp&  T2)
       {
	 Emp  T3;

	   T3.sal = T1.sal + T2.sal;

           return T3;
       }

   void main()
     {

       Emp  A,B,C,D;

       A.Read("AT1245","Krishna",9500);
       B.Read("AT1259","Nikhil",7800);

       C = A + 1000;

       D = A + B;

       A.Show();
       B.Show();
       C.Show();
       D.Show();

     }

