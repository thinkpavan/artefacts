/*******************************************************************

SourceName         : Write_Struct.c 

Description        : This program demonstrates to write a structure
		     in the file. 

*******************************************************************/

#include <sys/types.h>
#include <sys/stat.h>
#include <io.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct 
{
	char cName[20];
	char cAddr[20];
	int nAge;
} Person;

int main(void)
{
	Person p[] = {
		{"Rahul", "Bangalore", 65},
		{"a", "b", 66}
	};
	int i;			

	int handle = 0, len = sizeof(p[0]);
	
	handle = open("A.Txt", O_CREAT | O_WRONLY, S_IREAD | S_IWRITE);
	
	if( -1 == handle)
	{
		printf("Error Creating File\n");
		exit(-1);
	}
	for(i= 0; i < 2; i++)
	{
		if(len != write(handle, &p[i], len))
		{
	   		printf("Write Error\n"); 
		} 
		else
			printf("Write Successful\n");
	}
	close(handle); /* close the file */
	return 0;
}