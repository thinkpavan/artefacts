
 #include<iostream.h>
 #include<string.h>

 class Emp
   {

     char empno[10];
     char name[20];
     char desig[20];
     int  sal;
      public :
      Emp()
       {
	 strcpy(empno,"Unknown");
	 strcpy(name,"Unknown");
         strcpy(desig,"Unknown");
         sal = 0;
       }

      Emp(char vempno[],char vname[],char vdesig[],int vsal)
       {
	 strcpy(empno,vempno);
	 strcpy(name,vname);
         strcpy(desig,vdesig);
         sal = vsal;
      }

      // Copy Constructor
      Emp(Emp&  E)
       {
	 strcpy(empno,"Unknown");
	 strcpy(name,"Unknown");
         strcpy(desig,E.desig);
         sal = E.sal;
      }

      void Read()
      {
        cout<<endl;
	cout<<"\n Enter Empno  :  ";
	cin>>empno;
	cout<<"\n Enter Name   :  ";
	cin>>name;
	cout<<"\n Enter Desig  : ";
        cin>>desig;
	cout<<"\n Enter Salary :  ";
	cin>>sal;
      }
      void Show()
      {
        cout<<endl;
	cout<<"\n Empno  :  "<<empno;
	cout<<"\n Name   :  "<<name;
        cout<<"\n Desig  :  "<<desig;
	cout<<"\n Salary :  "<<sal;
      }

   };

   void main()
     {

       Emp  A,B("AT1245","Krishna","Clerk",9500);

       A.Read();

       Emp  C(A),D(B);


       A.Show();
       B.Show();
       C.Show();
       D.Show();
     }

