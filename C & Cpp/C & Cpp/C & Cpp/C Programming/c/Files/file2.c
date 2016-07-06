#include<stdio.h>
#include<conio.h>
void main()
{
FILE *p;
char ch;
p=fopen("c:\\demo.txt","r");
if(p==NULL)
printf("Error in opening");
else
{
  while((ch=fgetc(p))!=EOF)
  {
  putchar(ch);
  }
}
getch();
}

