/*******************************************************************
SourceName			: Pointer1.c, 
	
Description			: Assign pointer and display values. 
*******************************************************************/
#include <stdio.h>
/*
int main()
{
	int i;
	int j = 20;
	int* p = &i;
	
	i = 200;

	printf("i = %d\n", i);

	printf("&i = %x\n", &i);

	printf(" p = %x\n", p);

	printf("&p = %x\n", &p);

	printf("*p = %d\n", *p);

	return 0;
}*/

int main()
{
	int a[][3] = {1,2,3,4,5,6,7,8,9};

	printf("%d", *a[2]);
	return 0;
}