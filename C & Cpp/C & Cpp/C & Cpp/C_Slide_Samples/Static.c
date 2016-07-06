/*******************************************************************
SourceName			: Pointer1.c, 
	
Description			: static variable
*******************************************************************/
#include <stdio.h>

char Digit_to_Hex(int  digit)
{
	static const char hex_chars[15] =  {'1', '2', '3', '4', '5',
					'6', '7', '8', '9', 'A',
					'B', 'C', 'D', 'E', 'F'
										};
	return hex_chars[digit];
}


int main()
{
	printf("%c\n", Digit_to_Hex(12));
	
	printf("%c\n", Digit_to_Hex(10));
	
	return 0;
}

	