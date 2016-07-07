package com.submersion.jspshop.adminbrowse;

import java.io.*;
import java.net.*;
import java.util.*;

/** Does the underlying networking flow for the AdminBrowse Applet
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @changedBy: $Author$
 * @see com.submersion.jspshop.adminbrowse.AdminBrowse
 * @changed: $Date$
 * @created: September 04, 2001
 * @version $Revision$
 */

public class NetConnect
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    /** HashMap containing the data returned from the URL.
     */
    HashMap data = new HashMap();

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    /** Calls the initialise() function that Connects to the URL passed, and constructs the HashMap for the data.
     * 
     * @param urlString The URL in String format of the Page that gives the 
     *     Data for the AdminBrowse applet.
     */
    public NetConnect(String urlString)
    {        
        initialise(urlString);
    }

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --HashData---------------- */
    /** Returns the HashMap
     * 
     * @return A HashMap of the data in the URL passed.
     */
    public HashMap getHashData()
    {
        return data;
    }

/*  ================================================
		PRIVATE METHODS
    ================================================ */
    /** This code is called by the constructor and actually does the data connection to the URL. It then calls BuidlData to construct a HashMap of the data.
     * 
     * @param urlString The URL where to connect to, to get the data required.
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
            System.err.println("AdminBrowse: Error opening input stream to url: " + urlString);
            e.printStackTrace();
        }
    }
    
    /** Takes the raw data from initialise, and builds it into a HashMap
     * 
     * @param buff BufferedInputStream containing URL data
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
        //keeps the fact if children exist
        StringBuffer childBuf = new StringBuffer();
                
        // helps us figure out which one we're on
        boolean isID = true;
        boolean isName = false;
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
                    else if (isName)
                    {
                        // build the name buffer
                        nameBuf.append((char)chr);
                    }
                    else
                    {
                        childBuf.append((char)chr);
                    }
                }
                else
                {
                    // got a buffer built, so do something with it
                    if (isID)
                    {
                        // switch to name
                        isID = false;
                        isName = true;                             
                    }
                    else if (isName)
                    {
                        isName = false;
                    }
                    else
                    {
                        // got it all done
                        String[] nameData = new String[2]; 
                        
                        nameData[0] = nameBuf.toString();
                        nameData[1] = childBuf.toString();
                        // put in new data
                        data.put(idBuf.toString(), nameData);
                        // switch back to ID
                        isID = true;
                        
                        // reset buffers
                        idBuf = new StringBuffer();
                        nameBuf = new StringBuffer();
                        childBuf = new StringBuffer();
                    }
                }
            }
        }
    }
/*  ================================================
		TEST METHODS
    ================================================ */
    
/*    public static void main( String[] args )
    {
        NetConnect app = new NetConnect(args[0]);
        
        Hashtable items = app.getHashData();
        System.out.println(items.size());
        for (Enumeration e = items.keys() ; e.hasMoreElements();)
        {
         String currElement = (String)e.nextElement();
         System.out.println(currElement + ":" + items.get(currElement));
        }
    }*/
}
