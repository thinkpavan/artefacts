/*******************************************************************

SourceName         : Conditional_Com.c                                 

Description        : This program demonstrates #if and #endif
			 . 
********************************************************************/

#include <stdio.h>

#define DEBUG1 78

int main()
{
	printf("One\n");

#if  DEBUG1
	printf("Two\n");
	printf("Three\n");
#endif
	printf("Fourth\n");
	return 0;
}

