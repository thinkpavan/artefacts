
 #include<iostream.h>
 #include<string.h>

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

//   Emp  ExcessOf(int val)
     Emp  operator + (int val)
       {
          Emp  T;
		   T.sal = sal + val;
           return T;
       }

//     Emp  Add(Emp  E)
       Emp  operator + (Emp  E)
	 {
		 Emp  T;
	     T.sal = sal + E.sal;
         return T;
	 }
   };

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
