
 #include<iostream.h>
 #include<string.h>

// Overloading prefix and Postfix

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

      void Read(char vempno[],char vname[],char vdesig[],int vsal)
       {
	 strcpy(empno,vempno);
	 strcpy(name,vname);
         strcpy(desig,vdesig);
         sal = vsal;
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

     // Overloading Prefix Increment Operator
     Emp  operator ++() 
	{
          Emp  T;

	  sal = sal + 1000;

           strcpy(T.desig,desig);
	   T.sal = sal;

            return T;
	}

     // Overloading Postfix Increment Operator
     Emp  operator ++(int) 
	{
          Emp  T;

	   strcpy(T.desig,desig);
	   T.sal = sal;

	   sal = sal + 1000;

            return T;
	}
   };

   void main()
     {

       Emp  A,B;

       A.Read("AT1245","Krishna","Clerk",9500);

       B = ++A;

       A.Show();
       B.Show();

     }

