/*******************************************************************

SourceName         : Macro.c                                       

Description        : This program demonstrates code substitution 
					 done by #define 
*******************************************************************/

#include<stdio.h>
#define COLUMN 80
int main()
{
	printf("%d", COLUMN);
	return(0);
}