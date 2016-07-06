#include<stdio.h>
#include<conio.h>
struct stu
{
int roll,clas;
};

void read(struct stu *x)
{
printf("Enter roll Number of a student:");
scanf("%d",&x->roll);
printf("Enter class of a student:");
scanf("%d",&x->clas);
}
void show(struct stu *x)
{
printf("The details entered of the student are \n\n");
printf("\nRoll  = %d",x->roll);
printf("\nclass  = %d",x->clas);
}
void main()
{
struct stu a;
FILE *p;
char ch;
p=fopen("c:\\demo.txt","r");
if(p==NULL)
printf("Error in opening");
else
{
   fread(p,
}
read(&a);
show(&a);

getch();
}

