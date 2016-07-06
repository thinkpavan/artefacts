#include <stdio.h>

int InputName1 (char** p)
{
	char cName[1024];
	scanf("%s", cName);
	*p = malloc(strlen(cName)+1);
	if(NULL == *p)
		return 1;
	strcpy(*p, cName);
	return 0;
}

int main()
{
	char* pName = NULL;

	if ( 0 == InputName1(&pName))
	{
		printf("%s", pName);
		free(pName);
	}
	else
}


char* InputName()
{
	char cName[1024];
	char* p;
	scanf("%s", cName);
	p = malloc(strlen(cName)+1);

	strcpy(p, cName);
	return p;
}

int main()
{
	char* pName = NULL;

	pName = InputName();

	printf("%s", pName);

	free(pName);
	return 0;
}
