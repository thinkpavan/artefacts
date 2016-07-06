#include<stdio.h>
#include<conio.h>
void main()
{
FILE *p;
char ch;
p=fopen("c:\\demo.txt","w");
if(p==NULL)
printf("Error in opening");
else
{
  while((ch=getchar())!=EOF)
  {
  fputc(ch,p);
  }
}
getch();
}

