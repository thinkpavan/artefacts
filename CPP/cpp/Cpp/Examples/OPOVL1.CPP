 #include<iostream.h>
 #include<string.h>

  class Player
    {
      char   id[10];
      char   *name;
      float  avg;

      public :
		  Player(char vname):name(new char[10])
		  {
			  strcpy(name,vname);
		  }

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

  //   int Greater(Player  P)
       int operator > (Player  P)
	 {
	    if(avg > P.avg)
	     return 1;

	     return 0;
	 }
     /*int operator = (Player  P)
	 {
	    
	 }*/

//     int Equal(Player  P)
       bool operator ==(Player  P)
	 {
	    if(avg == P.avg)
	     return true;

	     return false;
	 }

    };

    void main()
      {

	Player  P1,P2;

	P1.Read("BCCI23","Ravi",75.6);
	P2.Read("BCCI55","Daniel",85.89);

	cout<<"\n Player with Highest Average";
	 if(P1==P2)
	   cout<<"\n Both Area Same ";
	 else
	 if( P1 > P2 )
	    P1.Show();
	  else
	    P2.Show();

          cout<<"\n  Finished...";

	}



