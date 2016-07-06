

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

    int Match(char vempno[])
      {
	 if(strcmp(empno,vempno)==0)
	   return 1;
           return 0;
      }

   };

   void main()
     {

       fstream   F;
       long  pos;

       F.open("d:\\Filedemo\\EmpDetails.txt",ios::in|ios::out);

       Emp  B;
       char  vempno[20];
       int flag=0;

       cout<<"\n Enter empno to display : ";
       cin>>vempno;

       F.seekg(0,ios::beg);

       while(F)
       {
         pos = F.tellg();
	 F.read((char*)&B,sizeof(Emp));
          if(F.gcount()==sizeof(Emp))
            {
	       if(B.Match(vempno))
	       {
		 B.Show();
		 B.Read();
                 F.seekp(pos,ios::beg);
                 F.write((char*)&B,sizeof(Emp));
		 flag = 1;
                 break;

		}
	    }

       }

       if(flag==0)
        cout<<"\ Record not found !!";
       F.close();

      }

