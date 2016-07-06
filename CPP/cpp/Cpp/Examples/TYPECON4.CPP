 #include<iostream.h>
 #include<string.h>

 /*
 3 . Class Type To class Type :
	Implementation using Consructor
 */
 class Person
  {
     char  pname[20];
     char  loc[20];

     public :

      void GetName(char text[])
       {
          strcpy(text,pname);
       }

      void GetLocation(char text[])
       {
          strcpy(text,loc);
       }

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
  };

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

      Emp(Person  T)
       {
		 empno = 3453;
		 char  text[20];
		 T.GetName(text);
		 strcpy(name,text);
		 T.GetLocation(text);
		 strcpy(city,text);
		 strcpy(desig,"Clerk");
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

   };

   void main()
     {
		Emp E;
        Person  P;
		P.ReadPerson("Sirish","Mumbai");
		E = P ; //E = Emp(P);
		P.ShowPerson();
        E.Show();
     }

