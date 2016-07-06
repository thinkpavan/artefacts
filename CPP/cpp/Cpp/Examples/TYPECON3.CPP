 #include<iostream.h>
 #include<string.h>

 /*
 3 . Class Type To class Type :
	Implementation using
	overloading casting operator
 */

 class Emp
   {

     int  empno;
     char  name[20];
     char desig[20];
     char  city[20];

      public :

      Emp()
       {
	 empno = 0;
	 strcpy(name,"Unknown");
	 strcpy(desig,"Unknown");
	 strcpy(city,"Unknown");
       }

      void Read(int vempno,char vname[],
      	 		char vdesig[],char vcity[])
       {
	 empno = vempno;
	 strcpy(name,vname);
         strcpy(desig,vdesig);
	 strcpy(city,vcity);
      }

      void Show()
      {
        cout<<endl;
	cout<<"\n Empno  :  "<<empno;
	cout<<"\n Name   :  "<<name;
	cout<<"\n Desig  :  "<<desig;
	cout<<"\n City   :  "<<city;
      }

    friend class Person;

   };

 class Person
  {
     char  pname[20];
     char  loc[20];

     public :

      void ReadPerson(char vname[],char  vloc[])
       {
	 strcpy(pname,vname);
	 strcpy(loc,vloc);
       }

     void ShowPerson()
      {
	cout<<"\n Name      :  "<<pname;
	cout<<"\n Location  :  "<<loc;
      }

       operator Emp()
	{
	  Emp   T;

	    T.empno  = 4362;

	    strcpy(T.name,pname);
	    strcpy(T.city,loc);

	    strcpy(T.desig,"Clerk");

            return T;
	}
  };

   void main()
     {

	Emp     E;
        Person  P;

	P.ReadPerson("Sirish","Mumbai");


	E  =  P;  // E  = Emp(P);

	P.ShowPerson();
        E.Show();
     }

