 #include<iostream.h>
 #include<string.h>

 class Emp
   {

     char empno[10];
     char name[20];
     char desig[20];
     float  sal,hra,comm,gross;

      public :
      Emp()
       {
	 strcpy(empno,"Unknown");
	 strcpy(name,"Unknown");
         strcpy(desig,"Unknown");
         gross = hra = comm = sal = 0;
       }

      Emp(char vempno[],char vname[],char vdesig[],int vsal)
       {
	 strcpy(empno,vempno);
	 strcpy(name,vname);
         strcpy(desig,vdesig);
	 sal = vsal;
	 hra = sal * 0.1;
	 comm = sal * 0.05;
         gross = sal + hra + sal + comm;
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

      void Show(int a)
      {
	cout<<endl;
	cout<<"\n Empno  :  "<<empno;
	cout<<"\n Salary :  "<<sal;
	cout<<"\n Hra    :  "<<hra;
	cout<<"\n Comm   :  "<<comm;
	cout<<"\n Gross  :  "<<gross;
	cout<<"\n Sal for "<<a
	    <<" months : "<<sal*a;
      }

   };

   void main()
     {

      Emp  A("AT1245","Krishna","Clerk",9500);

      A.Show();

      A.Show(6);

     }


