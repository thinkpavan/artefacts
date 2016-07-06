/*******************************************************************

SourceName         : Binary4.c                                       

Description        : Using Binary Operator. 
*******************************************************************/


#include <stdio.h>
int main( )
{
	int i = 32, j;
	printf("\nvalue of i = %d\n", i);
	j = i & 32 ;
	if ( 0 == j)
		printf("fifth bit is OFF\n");
	else
		printf("fifth bit is ON\n");
	return 0;
}
