/*******************************************************************

SourceName         : Operator_Precedence.c                                       

Description        : This program demonstrates the armithmetic 
					 operator precedence. 
*******************************************************************/

#include<stdio.h>
int main()
{
	int nRes;
	nRes = 2 + 3 * 4 - 2;
	printf("2 + 3 * 4 - 4 / 2 = %d", nRes);
	return(0);
}
