package com.submersion.jspshop.adminlist;

import java.io.*;
import java.net.*;
import java.util.*;

/** Does the underlying networking flow for the ListBrowse Applet
 * . Basically connects to a URL, reads the data there, and then constructs a HashMap of that data.
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @changedBy: $Author$
 * @see com.submersion.jspshop.adminlist.AdminList
 * @changed: $Date$
 * @created: September 08, 2001
 * @version $Revision$
 */

public class NetConnect
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    /** A HashMap containing the data created in the constructor.
     */
    HashMap data = new HashMap();

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    /** Calls the initialise function which connects to the URL, gets the data, and builds the HashMap
     * 
     * @param urlString The URL to connect to, to get the data required.
     */
    public NetConnect(String urlString)
    {        
        initialise(urlString);
    }

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --HashData---------------- */
    /** Accessor method to get HashMap of data.
     * 
     * @return Contains the data created by the Constructor method.
     */
    public HashMap getHashData()
    {
        return data;
    }

/*  ================================================
		PRIVATE METHODS
    ================================================ */
    /** Connects to the URL specified and returns a BufferedInputStream that buildData uses to construct the HashMap
     * 
     * @param urlString The URL from which to get Data from
     */
    private void initialise(String urlString)
    {
        try
        {
            // get a new URL object of the url
            URL url = new URL(urlString);

            // open the inputstream
            BufferedInputStream buff = new BufferedInputStream(url.openStream());
            
            // create hash
            buildData(buff);                               
        }
        catch (IOException e)
        {
            System.err.println("AdminList: Error opening input stream to url: " + urlString);
            e.printStackTrace();
        }
    }
    
    /** Reads the BufferedInputStream passed and creates a HashMap based on the data therein.
     * 
     * @param buff BufferedInputStream passed from initialise method.
     * @exception IOException See the BufferedInputStream IOException
     */
    private void buildData(BufferedInputStream buff) throws IOException
    {
        
        // for reading char by char
        int chr;
        // keeps the current name
        StringBuffer nameBuf = new StringBuffer();
        // keeps the current ID
        StringBuffer idBuf = new StringBuffer();
                
        // helps us figure out which one we're on
        boolean isID = true;
        // read until end of input stream
        while ((chr = buff.read()) != -1)
        {
            // ignore white spaces
            if (!(chr == 10 || chr == 13 || chr == 20))
            {                
                // each field is seperated by a null char
                if (chr != 0)
                {
                    // still building the buffer so continue
                    if (isID)
                    {
                        // build id buffer
                        idBuf.append((char)chr);
                    }
                    else
                    {
                        // build the name buffer
                        nameBuf.append((char)chr);
                    }
                }
                else
                {
                    // got a buffer built, so do something with it
                    if (isID)
                    {
                        // switch to name
                        isID = false;
                    }
                    else
                    {
                        // got it all done
                        // put in new data
                        data.put(idBuf.toString(), nameBuf.toString());
                        // switch back to ID
                        isID = true;
                        
                        // reset buffers
                        idBuf = new StringBuffer();
                        nameBuf = new StringBuffer();
                    }
                }
            }
        }
    }
}
