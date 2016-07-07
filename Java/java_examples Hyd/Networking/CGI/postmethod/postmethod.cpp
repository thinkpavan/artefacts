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
		if(strcmp(reqmethod,"POST") !=0){
				printf("HTTP/1.1 500 BAD REQUEST \r\n We cannot process POST requests\r\n\r\n");
		}
	/*	else{
						char buf[1000];
			// let us see how difficult is it to debug this cgi program
			FILE *fp = fopen("debug.txt","w");
			fprintf(fp,"before reading info from stdin");
			fgets(buf,1000,stdin);
			fprintf(fp,"%s",buf);
		printf("HTTP/1.1 200 OK \r\n Connection:Close\r\nContetnt-Length:30 \r\nContent-Type=text/html \r\n\r\n");
			// we know that query string will not have the form data
			printf(" data u have sent to me is %s ",buf);
		}*/
			char buf[1000];
		FILE *fp = fopen("debug.txt","w");
			fprintf(fp,"before reading info from stdin");
			fflush(fp);
			printf("HTTP/1.1 200 OK \r\nContetnt-Type:text/html\r\nContent-Length:10 \r\n\r\n We can process POST requests\r\n");
			//we have to use content-length instead of 50
			fgets(buf,50,stdin);
			printf("Content is received from u in %s format\r\n",contype);
			fprintf(fp,"after sending data to client %s ",buf);
			printf(" info sent by client %s \r\n",buf);
			fflush(fp);
			fclose(fp);
		return 0;
}
