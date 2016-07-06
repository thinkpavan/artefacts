 #include<iostream.h>
 #include<string.h>

 /*
 2 . Class Type To Built in Type :
	It is implemented by
	overloading casting operator

	operator <cast operator> ()
	 {
	   ----
	   ----
	 } 

 */
 class Emp
   {

     int    empno;
     char   name[20];
     char   desig[20];
     float  sal;
      public :

      Emp()
       {
	 empno = 0;
	 strcpy(name,"Unknown");
         strcpy(desig,"Unknown");
         sal = 0;
       }

      Emp(int  vempno)
       {
	 empno = vempno;
	 strcpy(name,"Unknown");
         strcpy(desig,"Unknown");
         sal = 0;
       }

      void Read(int vempno,char vname[],
			char vdesig[],float  vsal)
       {
	 empno = vempno;
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

      operator int()
       {
          return empno;
       }

      operator float()
       {
         return sal;
       }

   };

   void main()
     {
       int  vempno;
       float vsal;
       Emp   A;

       A.Read(2355,"Sanjay","Designer",25400);

       vempno  = A;    // vempno  = int(A);
       vsal    = A;   // vsal    = float(A);

       cout<<"\n Empno   is  :  "<<vempno;
       cout<<"\n Salary  is  :  "<<vsal;

     }

