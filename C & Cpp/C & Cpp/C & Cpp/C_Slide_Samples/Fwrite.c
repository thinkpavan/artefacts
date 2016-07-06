/*******************************************************************

SourceName         : Fwrite.c                                       

Description        : This program demonstrates fwrite functions to
					 write set of records in the file.
			 . 
*******************************************************************/

#include<stdio.h>
#include<stdlib.h>
typedef struct
{
	char cName[20];
	char cAddress[20];
	int nAge;
} Person;

int main()
{
	
	Person p[] = {	{"Rahul", "India", 28},
					{"Hossam", "Jordan", 25},
					{"Raju", "India", 27}
				};
	FILE* fptr = fopen("A.txt", "w");
	
	if(NULL == fptr)
	{
		printf("Error Opening");
		exit(-1);
	}

	if(3 == fwrite(p, sizeof(p[0]), 3, fptr))
		printf("Wrote Successfully\n");
	else
		printf("Write Failed \n");
	fclose(fptr);
	return(0);
}
