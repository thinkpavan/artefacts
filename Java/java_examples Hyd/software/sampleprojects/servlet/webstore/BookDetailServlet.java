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
import javax.servlet.http.*;


/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * and HEAD methods of the HTTP protocol.  This servlet calls other
 * servlets.
 */
public class BookDetailServlet extends HttpServlet {

    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException
    {
        // Get the user's session and shopping cart
        HttpSession session = request.getSession(true);
        ShoppingCart cart =
            (ShoppingCart)session.getValue(session.getId());
        
        // If the user has no cart, create a new one
        if (cart == null) {
            cart = new ShoppingCart();
            session.putValue(session.getId(), cart);
        }

	// set content-type header before accessing the Writer
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

	// then write the response
        out.println("<html>" +
                    "<head><title>Book Description</title></head>" +

                    "<body  bgcolor=\"#FFFFFF\">" +
                    "<center>" +
                    "<hr> <br> &nbsp;" +
                    "<h1>" +
                    "<font size=\"+3\" color=\"red\">Duke's </font>" +
                    "<font size=\"+3\" color=\"purple\">Bookstore</font>" +
                    "</h1>" +
                    "</center>" +
                    "<br> &nbsp; <hr> <br> &nbsp;");

        //Get the identifier of the book to display
        String bookId = request.getParameter("bookId");
        if (bookId != null) {
	System.out.print(" trying to get reference of the servlet bookdb <BR>");
            // and the information about the book
System.out.print(" ..."+getServletConfig().getServletContext().getServlet("bookdb"));

            BookDB database = (BookDB)
                getServletContext().getAttribute("bkstore");
            BookDetails bd = database.getBookDetails(bookId);

            //Print out the information obtained
            out.println("<h2>" + bd.getTitle() + "</h2>" +

                        "&nbsp; By <em>" + bd.getFirstName() + ", " +
                        bd.getSurname() + "</em> &nbsp; &nbsp; " +
                        "(" + bd.getYear() + ")<br> &nbsp; <br>" +

                        "<h4>Here's what the critics say: </h4>" +
                        "<blockquote>" + bd.getDescription() +
                        "</blockquote>" +

                        "<h4>Our price: $" + bd.getPrice() + "</h4>" +

                        "<center>" +
                        "<p><a href=\"" +
                        response.encodeUrl("/servlet/catalog?Buy=" + bookId) +
                        "\"> Add this item to your shopping cart.</a></p>" +
                        "</center>");
        }
        out.println("</body></html>");
        out.close();
    }

    public String getServletInfo() {
        return "The BookDetail servlet returns information about" +
               "any book that is available from the bookstore.";
    }
}
