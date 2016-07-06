

 #include<fstream.h>
 #include<string.h>

 class Emp
   {

     char empno[10];
     char name[20];
     char desig[20];
     int  sal;
      public :
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

   };

   void main()
     {

       char  ch;
       Emp  A;

       fstream   F;

       F.open("c:\\pavan\\Emp1.txt",ios::in|ios::out|ios::app);

       do
       {
	 A.Read();
	 F.write((char*)&A,sizeof(Emp));

	 cout<<"\n Continue..[Y/N]  : ";
         cin>>ch;
	}
      while(ch=='y');   

       Emp  B;

       F.seekg(0);
		
       while(F.read((char*)&B,sizeof(Emp))!=0)
       {
	     if(F.gcount()==sizeof(Emp))
			 B.Show();
	   }
       F.close();

      }












