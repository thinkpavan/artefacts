 #include<iostream.h>
 #include<string.h>

 class Emp
   {

     char  empno[10];
     char  name[20];
     char  desig[20];
     float sal,hra,comm,nett;


     void Calculate()  // Private Method
      {
	hra  = sal * 0.1;
	comm = sal * 0.05;
        nett = sal + hra + comm;
      }

     public :
      Emp()
       {
	 strcpy(empno,"Unknown");
	 strcpy(name,"Unknown");
         strcpy(desig,"Unknown");
         sal = 0;
       }

   void Read(char vempno[],char vname[],
   			char vdesig[],float vsal)
       {
	 strcpy(empno,vempno);
	 strcpy(name,vname);
         strcpy(desig,vdesig);
         sal = vsal;
	 Calculate();
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
	Calculate();
      }

      void Show()
      {
        cout<<endl;
	cout<<"\n Empno  :  "<<empno;
	cout<<"\n Name   :  "<<name;
        cout<<"\n Desig  :  "<<desig;
      }

      void Show(int a)
      {
        cout<<endl;
	cout<<"\n Empno  :  "<<empno;
	cout<<"\n Salary :  "<<sal;
        cout<<"\n Hra    :  "<<hra;
	cout<<"\n Comm   :  "<<comm;
	cout<<"\n Nett   :  "<<nett;
	cout<<"\n Nett salary for "
	    <<a<<" months  :  "<<nett*a;
      }

   };

   void main()
     {

       Emp  A;

       A.Read();
       A.Show();
       A.Show(6);

	Emp  B;

	B.Read("JDM846945","Varun","Manager",28600);
	B.Show();
	B.Show(6);

     }

