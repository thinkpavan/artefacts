/*******************************************************************

SourceName         : Binary3.c                                       

Description        : Test a Bit if its on or off. 
*******************************************************************/
#include <stdio.h>

int main()
{
	int bits = 64;

	if ((bits & 64) != 0) /* Check to see if bit 6 is set.*/
		printf("6th bit is ON\n");
	else
		printf("6th bit is OFF\n");
	return 0;
}




