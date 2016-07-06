 #include<iostream.h>
   class Complex
     {
       int  real;
       int  imag;

	 public :
	   void Read(int  vreal,int vimag)
	    {
	      real = vreal;
	      imag = vimag;
	    }

	   void Read()
	    {
	       cout<<"\n Enter Real Part ";
               cin>>real;
	       cout<<"\n Enter Imaginary Part ";
               cin>>imag;
	    }

	   void Show()
	    {
	      cout<<"\n   ";
              cout<<real<<" + ( "<<imag<<" )i";
	    }

//	Complex  Add(Complex&  T)
	Complex  operator + (Complex&  T)
	  {

	    Complex   R;

	     R.real = real + T.real;
             R.imag = imag + T.imag;

             return  R;
	  }

//	Complex  Difference (Complex&  T)
	Complex  operator - (Complex&  T)
	  {

	    Complex   R;

	     R.real = real - T.real;
             R.imag = imag - T.imag;

             return  R;
	  }

//       Complex Product(int  a)
       Complex	operator *(int  a)
	 {
	   Complex  R;

	    R.real = real * a;
	    R.imag = imag * a;

            return R;
	 }

//       Complex  Product(Complex  T)
       Complex	operator *(Complex  T)
	 {
	   Complex  R;

	    R.real = (real * T.real) - (imag * T.imag);
	    R.imag = (real * T.imag) + (imag * T.real);

            return R;
	 }

     };

   void main()
     {
       Complex   C1,C2;
       Complex   S,D,P,M;

	 C1.Read(5,-7);
	 C2.Read(6,4);


	 S = C1 + C2;

         cout<<"\n  Sum Is : ";
	 S.Show();

	 D = C1 - C2;

	 cout<<"\n  Difference Is : ";
	 D.Show();

	 M = C1 * C2;

	 cout<<"\n  Product Is : ";
	 M.Show();

	 int  n;
	 cout<<"\n Enter Number to multiply ";
         cin>>n;
	 P = C1 * n;

	 cout<<"\n Multiplied with "<<n;
         P.Show();


     }