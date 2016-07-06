/*******************************************************************
SourceName			: Pointer10.c 
	
Description			: Pass by Pointer 
*******************************************************************/

#include <stdio.h>

void Swap(int* nP1, int* nP2) 
{
   int temp;
   temp = *nP1;
   *nP1 = *nP2;
   *nP2 = temp;
}
int main()
{
    int a = 20, b = 30;
   Swap(&a, &b);
   printf("a = %d\t b = %d\n", a, b); 
   return 0;
}