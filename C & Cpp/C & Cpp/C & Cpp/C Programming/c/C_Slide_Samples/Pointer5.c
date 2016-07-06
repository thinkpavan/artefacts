/*******************************************************************
SourceName			: Pointer5.c, 
	
Description			: Allocating dynamic memory
*******************************************************************/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

typedef int ANYTYPE;

int main()
{
	ANYTYPE* p = NULL;

	p = (ANYTYPE*) malloc(sizeof(ANYTYPE)); /* Memory Allocated */
	if ( NULL == p)
	{
		printf("Insufficient heap space\n");
		exit(0);
	}
	//The object is initialized and used here via the pointer.
	*p = 100;
	printf("Data stored is %d\n", *p);
	
	free(p);					/* Memory Deallocated.*/

	return 0;
}
