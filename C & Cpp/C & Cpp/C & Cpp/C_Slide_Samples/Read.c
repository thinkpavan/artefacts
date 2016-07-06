/*******************************************************************

SourceName         : Read.c                                       

Description        : This program demonstrates the use of 
                     read function. 
*******************************************************************/

#include <sys/types.h>
#include <sys/stat.h>
#include <io.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	char buf[6];
	int handle = 0, len = 1, res = 0;
	handle = open("A.Txt", O_RDONLY, 0);
	
	if( -1 == handle)
	{
		printf("Error Creating File\n");
		exit(-1);
	}
	
	while(0 !=  (res = read(handle, buf, 5)))
	{
		buf[res] = '\0';

	   	printf("%s", buf);
	} 
	close(handle); /* close the file */
	return 0;
}