// env.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdlib.h>
int main(int argc, char* argv[])
{
	printf("cgi variables \n");
		char *env;
		char *pwd;
		env= getenv("SERVER_SOFTWARE");
		printf("SERVER_SOFTWARE  = %s\n",env);
		env= getenv("SERVER_NAME");
		printf("SERVER_NAME  = %s\n",env);
		env= getenv("GATEWAY_INTERFACE");
		printf("GATEWAY_INTERFACE   = %s\n",env);
		env= getenv("SERVER_PROTOCOL");
		printf("SERVER_PROTOCOL  = %s\n",env);
		env= getenv("SERVER_PORT");
		printf("SERVER_PORT   = %s\n",env);
		env= getenv("REQUEST_METHOD");
		printf("REQUEST_METHOD    = %s\n",env);
				env= getenv("HTTP_ACCEPT");
		printf("HTTP_ACCEPT   = %s\n",env);
		env= getenv("SCRIPT_NAME");
		printf("SCRIPT_NAME   = %s\n",env);
		env= getenv("QUERY_STRING");
		printf("QUERY_STRING    = %s\n",env);
		env= getenv("REMOTE_HOST");
		printf("REMOTE_HOST  = %s\n",env);
		env= getenv("CONTENT_TYPE");
		printf("CONTENT_TYPE    = %s\n",env);
		env= getenv("CONTENT_LENGTH");
		printf("CONTENT_LENGTH     = %s\n",env);
	return 0;
}

