/*******************************************************************
SourceName			: Pointer11.c
	
Description			: Function Pointer 
*******************************************************************/
#include<stdio.h>
int Sum(int, int);
int Subtract(int, int);

int main()
{
	int nChoice, nA = 40, nB = 20;

	int (*Call[2])(int, int) = { Sum, Subtract };
	printf("\nEnter 0 for Sum and 1 for Sub :");
	scanf("%d", &nChoice);

	printf("\n%d\n" , (*Call[nChoice])(nA,nB));
	return 0;
}

int Sum(int a, int b)
{
	return (a+b);
}

int Subtract(int a, int b)
{
	return(a-b);
}
