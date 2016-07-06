/*******************************************************************

SourceName         : Break_Cont.c                                       

Description        : Increment/Decrement Operator. 
*******************************************************************/
#include <stdio.h>
int main()
{
	int nNum1 = 10;
	printf("++nNum1 = %d\n", ++nNum1);	/*Pre increment*/
	
	printf("nNum1++ = %d\n", nNum1++);	/*Post Increment*/
	printf("nNum1 = %d\n", nNum1);
	return(0);
}
