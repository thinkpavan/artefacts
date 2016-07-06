/*******************************************************************

SourceName         : Relational.c                                       

Description        : Relational operator. 
*******************************************************************/
#include<stdio.h>
int main()
{
	char x = 'u';
	if('a' == x || 'e' == x || 'i' == x || 'o' == x || 'u' == x || 
		'A' == x || 'E' == x || 'I' == x || 'O' == x || 'U' == x) 
		
		printf("Vowel");
	else
		printf("Other Character");
	return(0);
}
