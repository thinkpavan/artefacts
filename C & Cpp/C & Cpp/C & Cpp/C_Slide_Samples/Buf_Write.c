/*******************************************************************

SourceName         : Buf_Write.c                                       

Description        : This program demonstrates fopen, fprintf and
                     fclose functions.
			 . 
*******************************************************************/

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE* fptr = NULL;
	char cName[] = "Rahul", cAddr[]= "India";
	int nAge = 28;

	fptr = fopen ("A.txt", "w");
	if (NULL == fptr)
	{
		printf("\nError Opening File");
		exit(1);
	}
	fprintf(fptr,"Name:%s\tAddr:%s\tAge:%d\n", cName, cAddr, nAge);
	fclose(fptr);
	return(0);
}
