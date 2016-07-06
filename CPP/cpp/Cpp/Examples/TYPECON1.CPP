 #include<iostream.h>
 #include<string.h>

 /*
 1 . Built in Type To class Type :
	It is implemented using Consructor
 */
 class Emp
   {

     int  empno;
     char name[20];
     char desig[20];
     int  sal;
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

      void Read(int vempno,char vname[],char vdesig[],int vsal)
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

   };

   void main()
    {

    
	   Emp  A;
	   A = 1002;  //  A = Emp(1002);
	   A.Show();
	}

