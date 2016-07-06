
 #include<iostream.h>
  class Point
   {
     int  x;
     int  y;

      public :
	Point()
	 {
           x=y=0;
	 }

	Point(int ax,int ay)
	 {
	   x = ax;
           y = ay;
	 }

	Point(int n)
	 {
	   x = y = n;
	 }

	void Show()
	 {
	    cout<<"\n The point is :"
	    	<<"("<<x<<","<<y<<")";
	 }
    };

    void main()
      {

	 Point   P;
	 Point   D(5,3);
         Point   F(7);

	 P.Show();
	 D.Show();
	 F.Show();
      }