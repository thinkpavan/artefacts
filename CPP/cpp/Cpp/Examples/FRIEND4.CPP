 #include<iostream.h>
 #include<string.h>

 // Operator Overloading with friend function

  class Player
    {
      char   id[10];
      char   name[20];
      float  avg;

      public :

       void Read(char vid[],char vname[],float vavg)
	{
	 strcpy(id,vid);
	 strcpy(name,vname);
         avg = vavg;
	}

      void Show()
	{
	  cout<<"\n ID       :  "<<id;
	  cout<<"\n Name     :  "<<name;
	  cout<<"\n Average  :  "<<avg;
	}

    friend int operator==(Player T1,Player  T2);

    };

    //Overloading (==) operator with friend function

    int operator ==(Player T1,Player  T2)
     {
	if(T1.avg == T2.avg)
	  return 1;

          return 0;
     }

    void main()
      {

	Player  P1,P2;

	P1.Read("BCCI23","Ravi",75.6);
	P2.Read("BCCI55","Daniel",85.89);

	cout<<"\n Player with Highest Average";

	 if( P1==P2 )
	   cout<<"\n Both Area Same ";
	 else
           cout<<"\n Not Same  ";


          cout<<"\n  Finished...";

	}



