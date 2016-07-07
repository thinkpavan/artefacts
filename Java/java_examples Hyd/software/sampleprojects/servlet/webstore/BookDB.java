/*
Copyright (c) 1998 Sun Microsystems, Inc. All Rights Reserved.

This software is the confidential and proprietary information of Sun
Microsystems, Inc. ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Sun.

SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR ANY DAMAGES
SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
THIS SOFTWARE OR ITS DERIVATIVES.

CopyrightVersion 1.0
*/



import java.io.*;
import javax.servlet.*;


/**
 * This is a simple example of a Generic Servlet.  Other servlets
 * call its public methods; it does not accept calls from clients.
 */
public class BookDB{

    private BookstoreDB books;
	public BookDB(){
		books = new BookstoreDB();
	}
    public BookDetails getBookDetails(String bookId) {
        return books.getBookDetails(bookId);
    }

    public BookDetails[] getBooksSortedByTitle() {
        return books.getBooksSortedByTitle();
    }

    public int getNumberOfBooks() {
        return books.getNumberOfBooks();
    }

}
