 #include<iostream.h>
 #include<string.h>
 #include<conio.h>

 const int size=3;

  class  BookList
    {
       char   refno[size][5];
       char   name[size][20];
       char   author[size][20];
       int    count;

	public :
	 BookList()
	  {
            count=0;
	  }         

	 void Read();
	 void Show();

	 void Read(char  vrefno[],char vname[],char vauthor[])
	   {
	      if(count<size)
		{
		   strcpy(refno[count],vrefno);
		   strcpy(name[count],vname);
		   strcpy(author[count],vauthor);

                   count++;
		}
	       else
                cout<<"Unable To Input Values ";
	   }
     };

    void BookList::Show()
	 {
	    for(int  i=0;i<count;i++)
	     {
	       cout<<"\n  Ref No :  "<<refno[i];
	       cout<<"\n  Name   :  "<<name[i];
	       cout<<"\n  Author :  "<<author[i];
	     }
	 }

    void BookList::Read()
	 {
	    for(int  i=0;i<size;i++)
	     {
	       cout<<"\n  Enter Ref No :  ";
	       cin>>refno[i];
	       cout<<"\n  Enter Name   :  ";
	       cin>>name[i];
	       cout<<"\n  Enter Author :  ";
	       cin>>author[i];

               count++;
	     }
	 }


    void main()
     {
	BookList   A;

	A.Read("4566","Power Electr","Thomson");
	A.Read("4256","Circut Analysis","Kriss");

	A.Show();
	 getch();

	 BookList  B;

	 B.Read();
	 B.Show();

     }