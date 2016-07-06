 #include<iostream.h>
 #include<string.h>

  class Bank_Account
   {

     char   acno[10];
     char   name[20];
     char   actype;
     float  amt;
     float   interest;

     public :
    // Method with Default Arguments
   void Read(char vacno[],char vname[])
	  {
	  strcpy(acno,vacno);
	  strcpy(name,vname);
	  actype = 'S';
	  amt = 5000;
          interest= 5.6;
	  }

   void Read(char vacno[],char vname[],
   			char vactype,float vamt)
	  {
	  strcpy(acno,vacno);
	  strcpy(name,vname);
          actype=vactype;
	  amt = vamt;
	   if(actype=='C' && amt>50000)
	      interest = 11.5;
	   else
	   if(actype=='C' && amt>20000)
	      interest=8.5;
	   else
	      interest=5.6;      
	  }


    void Show()
	    {
            cout<<endl;
	    cout<<"\n Acno         : "<<acno;
	    cout<<"\n Name         : "<<name;
	    cout<<"\n Account Type : "<<actype;
	    cout<<"\n Amt          : "<<amt;
	    cout<<"\n Rate of Intr : "<<interest;
	    }
    };


    void main()
     {

	Bank_Account   A1,A2;

	A1.Read("IC117756","Vikram",'C',25000);
        A2.Read("IC113478","Sanjay");

	A1.Show();
	A2.Show();

     }









































/*
         // Default Constructor
       Bank_Account()
	{
	  strcpy(acno,"IC558899");
	  strcpy(name,"Unknown");
	  actype = 'S';
          amt = 5000;
	}

	// Parameterized Constructors
	Bank_Account(char vacno[],char vname[])
	  {
	  strcpy(acno,vacno);
	  strcpy(name,vname);
	  actype = 'S';
	  amt = 5000;

	  }

	Bank_Account(char vacno[],char vname[],
					int vamt)
	  {
	  strcpy(acno,vacno);
	  strcpy(name,vname);
	  actype = 'S';
          amt = vamt;

	  }

         // Copy Constructor 
	Bank_Account(Bank_Account&  B)
	  {
	  strcpy(acno,"IC446286");
	  strcpy(name,B.name);
	  actype = B.actype;
          amt = B.amt;
	  }

	  ~Bank_Account()
	    {
              cout<<acno<<endl;
	    }
      void Read()
	 {
	    cout<<"\n Enter Acno         : ";
	    cin>>acno;
	    cout<<"\n Enter Name         : ";
	    cin>>name;
	    cout<<"\n Enter Account Type : ";
	    cin>>actype;
	    cout<<"\n Enter Amt          : ";
	    cin>>amt;
	 }


*/