/*******************************************************************

SourceName         : If.c                                       

Description        : if condition. 
*******************************************************************/
#include <stdio.h>

int main()
{
	int month = 2, days;

	if  ( 4 == month || 6 == month || 9 == month || 11 == month) 
		days = 30 ; 	/* Apr, Jun, Sept, Nov */ 
	else
		if  ( 2 == month)
			days = 28 ;	/* Feb*/
 		else
	 		days = 31;	/* All the rest*/
	printf("Days = %d\n", days);
	return 0;
}

