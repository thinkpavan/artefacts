#include<iostream.h>

 float  Area(int  r)
   {
     float  a;
      a = 3.141593 * r * r;
      return a;
   }

 int  Area(int l,int  b)
    {
      int  a;
      a = l * b;
      return a;
    }

 int Area(int  l,int b,int h)
    {
      int a;
       a = l * b * h;
       return a;
    }
     
 void main()
   {
      int rad,len,brd,cublen,cubbrd,cubht;
      float  carea;
      int    rarea,cubarea;

      rad = 5;

      carea = Area(rad);
      cout<<"\n Area Of Circle is  :  "<<carea;

      len = 5;
      brd = 10;

      rarea = Area(len,brd);
      cout<<"\n Area Of Rectangle is  :  "<<rarea;

      cublen=40;
      cubbrd=50;
      cubht =10;

      cubarea = Area(cublen,cubbrd,cubht);
      cout<<"\n Area Of Cuboid  is  :  "<<cubarea;

   }

          