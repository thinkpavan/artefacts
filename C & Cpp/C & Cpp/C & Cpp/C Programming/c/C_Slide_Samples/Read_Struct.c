/*******************************************************************

SourceName         : Read_Struct.c                                      

Description        : This program demonstrates to read structure
		     elements from the file. 
 
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
	Person p;

	int handle = 0, len = sizeof(p) * 2;
	handle = open("A.Txt", O_RDONLY, 0);
	
	if( -1 == handle)
	{
		printf("Error Creating File\n");
		exit(-1);
	}
	
	while (read(handle, &p, sizeof(p)))
	{
		printf("%s %s %d\n", p.cName, p.cAddr, p.nAge);
	}
	close(handle); /* close the file */
	return 0;
} 