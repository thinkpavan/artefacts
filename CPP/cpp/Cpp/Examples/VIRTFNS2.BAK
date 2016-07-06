 #include<iostream.h>
  class Employee
   {
      int   empno;
      char  name[20];
      float  sal;

      public :
	void Read()
	 {
	   cout<<"\n Enter Empno  : ";
           cin>>empno;
	   cout<<"\n Enter Name   : ";
           cin>>name;
	   cout<<"\n Enter Salary : ";
           cin>>sal;
	 }

	void Show()
	 {
	   cout<<"\n Empno  : "<<empno;
	   cout<<"\n Name   : "<<name;
	   cout<<"\n Salary : "<<sal;
	 }

       virtual void RaiseSalary(float  per)
	 {
           cout<<"\n Employee Version ";
	   sal = sal + (sal * per/100);
	 }
   };

   class Manager : public Employee
    {
      char  secr_name[20];

       public :

	void RaiseSalary(float  per)
	 {
	   cout<<"\n Manager Version ";
	    Employee::RaiseSalary(per + 2 );

	 } 

    };

    void main()
     {

       Employee  *staff[3];

       staff[0] = new Employee;
       staff[1] = new Employee;
       staff[2] = new Manager;


       for(int i=0;i<3;i++)
        staff[i]->Read();

       for(i=0;i<3;i++)
        staff[i]->RaiseSalary(3);

       for(i=0;i<3;i++)
        staff[i]->Show();

     }
