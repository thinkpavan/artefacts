/*******************************************************************

SourceName         : Function.c                                       

Description        : Function Definition and calling 
*******************************************************************/
#include <stdio.h>

int sum(int a, int b);

int main()
{
	printf("%d\n", sum(10,20));
	return 0;
}
int sum1(int a, int b)
{
	return(a + b);
}
