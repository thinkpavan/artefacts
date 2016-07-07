// env.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdlib.h>
# include <string.h>
int main(int argc, char* argv[])
{
	// let us follow protocol here

		char *reqmethod;
		char *qstr;
		char *contype;
		char *conlen;

		reqmethod= getenv("REQUEST_METHOD");
		printf("REQUEST_METHOD    = %s\n",reqmethod);
		qstr= getenv("QUERY_STRING");
		printf("QUERY_STRING    = %s\n",qstr);
		contype= getenv("CONTENT_TYPE");
		printf("CONTENT_TYPE    = %s\n",contype);
		conlen= getenv("CONTENT_LENGTH");
		printf("CONTENT_LENGTH     = %s\n",conlen);
		// here we will check whether the request method is get or not
		// we have to check whether the pointer is pointing to null or not her
		if(strcmp(reqmethod,"GET") !=0){
				printf("HTTP/1.1 500 BAD REQUEST \r\n We cannot process POST requests\r\n\r\n");
		}
		else{
		printf("HTTP/1.1 200 OK \r\n Connection:Close \r\n\r\n data sent to me = %s ",qstr);
		}
		return 0;
}

