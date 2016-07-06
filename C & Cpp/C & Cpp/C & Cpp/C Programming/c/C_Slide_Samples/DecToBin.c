#include <stdio.h>
int main()
{
	int nDec, nRes;
	scanf("%d", &nDec);
	printf("\n\t\t\t\t");
	while(nDec != 0)
	{
		nRes = nDec % 2;
		printf("%d\b\b", nRes);
		nDec /= 2;
	}
	printf("\n");
	return 0;
}