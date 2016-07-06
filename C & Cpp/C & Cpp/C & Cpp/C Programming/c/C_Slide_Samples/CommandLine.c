#include<stdio.h>
/*
int main(int argc, char* argv[])
{
	int nI;
	printf("Parameters are:");
	for (nI = 0; nI < argc; nI++)
		printf("%s\n", argv[nI]);
	return(0);
}
*/
#pragma pack(2)

struct Abc
{
	int a;
	char b;
	float c;
};

int main()
{
	struct Abc x ;
	x.a = 100;
	x.b = 65;

	printf("%d", sizeof(x));
	
	return 0;
}
