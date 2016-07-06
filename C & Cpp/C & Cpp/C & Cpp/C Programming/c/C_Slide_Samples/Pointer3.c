/*******************************************************************
SourceName			: Pointer3.c, 
	
Description			: Changing value of a local variable from other
					  function using pointer.
*******************************************************************/

#include<stdio.h>
void abc(int[]);
int main(void)
{
	int a[5];
	abc(a);
	printf("%d\n", a[1]);
	return(0);
}
void abc(int a[])
{
	a++;
	*a = 100;
}
