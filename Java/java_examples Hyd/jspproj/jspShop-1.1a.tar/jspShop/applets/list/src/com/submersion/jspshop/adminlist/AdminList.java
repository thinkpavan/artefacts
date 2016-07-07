package com.submersion.jspshop.adminlist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;
import java.net.*;


/** An applet using a JList to show a representation of data in a list. Such as TypeNames.
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @changedBy: $Author$
 * @see com.submersion.jspshop.adminlist.NetConnect
 * @changed: $Date$
 * @created: September 8, 2001
 * @version $Revision$
 */

public class AdminList extends JApplet
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    /** Contains the index of the List, and the ID of the actual ListItem.
     */
    private HashMap indices = new HashMap();
    /** The ClickURL parameter from the Applet tag.
     * Contains the URL that is used when a List Item is opened.
     */
    private String clickURL;
    /** The ClickParam parameter from the Applet tag.
     * Contains the parameter name that is used to represnt the List item being opened.
     */
    private String clickParam;
    /** Used for the underlying data structure.
     */
    private DefaultListModel listModel = new DefaultListModel();
    /** The actual Swing object used for the List
     */
    private JList list = new JList(listModel);    
    /** The URL for NetConnect to get data from.
     */
    private String url;
    /** The AddMode parameter from the Applet tag.
     * Contains the Mode value for Adding new Items.
     */
    private String addMode;
    /** The ModeParam parameter from the Applet tag.
     * Contains the parameter name for specifying the mode of the call.
     */
    private String modeParam;
    /** The DeleteMode parameter from the Applet tag.
     * Contains the Mode value for deleting.
     */
    private String deleteMode;

/*  ================================================
		APPLET SPECIFIC
    ================================================ */
    /** Gets the parameters from the Applet tags, populates the default data, adds the listeners for the JList, and displays the JList in the applet.
     */
    public void init()
    {
        // get the properties from the html page
        initialiseProperties();

        // initialise table        
        populateData();
        
        // grab instance of our handler
        ListHandler handler = new ListHandler();
        
        // add it to mouselistener
        list.addMouseListener(handler);
        
        // get a pane
        JScrollPane pane = new JScrollPane(list);
                
        // remove the border
        pane.setBorder(BorderFactory.createEmptyBorder());
        
        // add to content pane using a scroll pane
        getContentPane().add(pane);        
        
    }

/*  ================================================
		PRIVATE METHODS
    ================================================ */

    /** Using NetConnect, connects to the URL (specified by the URL parameter), and tries to retrieve the data there.
     * Then populates the List with that data.
     */
    private void populateData()
    {
        // grab a new instance of our data getter
        NetConnect net = new NetConnect(url);
        
        // get data back from netConnect
        HashMap items = net.getHashData();
        
        // get iterator of keys back
        Iterator iterator = items.keySet().iterator();
        
        int i = 0;
        // iterate through everything        
        while (iterator.hasNext())
        {
            String id = (String)iterator.next();
            listModel.add(i,items.get(id));
            indices.put(new Integer(i++), id);
        }
    }
    
    /** Reads all the properties passed in the Applet tag, validates them, and then stores them locally.
     */
    private void initialiseProperties()
    {
        // get properties from <PARAM> tags
        url = getParameter("URL");
        clickURL = getParameter("ClickURL");
        clickParam = getParameter("ClickParam");
        modeParam = getParameter("ModeParam");
        addMode = getParameter("AddMode");
        deleteMode = getParameter("DeleteMode");
    
        // modeParam is required
        if (modeParam == null || modeParam.equals(""))
        {
            throw new NullPointerException("ModeParam parameter was empty.");
        }        
        // addMode is required
        if (addMode == null || addMode.equals(""))
        {
            throw new NullPointerException("AddMode param was empty.");
        }        
        // deleteMode is required
        if (deleteMode == null || deleteMode.equals(""))
        {
            throw new NullPointerException("DeleteMode param was empty.");
        }
        
        // url is required
        if (url == null || url.equals(""))
        {
            throw new NullPointerException("URL parameter was empty.");
        }
        // clickURL is required
        if (clickURL == null || clickURL.equals(""))
        {
            throw new NullPointerException("ClickURL parameter was empty.");
        }
        // click param is required
        if (clickParam == null || clickParam.equals(""))
        {
            throw new NullPointerException("ClickParam parameter was empty.");
        }     
    }

    /** Called to create the URL for an Open event and the sends the browser to that URL.
     * 
     * @param selectedIndex The index of the item that was selected.
     */
    private void openNode(int selectedIndex)
    {
        //create new URL path to update to
        StringBuffer newURL = new StringBuffer();
        newURL.append(clickURL);
        newURL.append("?");
        newURL.append(clickParam);
        newURL.append("=");
        newURL.append(indices.get(new Integer(selectedIndex)));
    
        URL url = null;
        try
        {
            url = new URL(newURL.toString());
        }
        catch (MalformedURLException ex)
        {
            System.err.println("AdminList: Error creating url in openMode method" + ex.getMessage());
            ex.printStackTrace();
        }
        
        getAppletContext().showDocument(url);
    }
    
    /** Called to create the URL for a Mode event and the sends the browser to that URL.
     * 
     * @param selectedIndex Index of the item selected.
     * @param mode Mode to be constructed. For example: add,delete
     */
    private void openMode(int selectedIndex, String mode)
    {

        // create URL
        StringBuffer newURL = new StringBuffer();
        newURL.append(clickURL);
        newURL.append("?");
        newURL.append(clickParam);
        newURL.append("=");
        newURL.append(indices.get(new Integer(selectedIndex)));
        newURL.append("&");
        newURL.append(modeParam);                    
        newURL.append("=");
        newURL.append(mode);

        URL url = null;
        try
        {
            url = new URL(newURL.toString());
        }
        catch (MalformedURLException ex)
        {
            System.err.println("AdminList: Error creating url in openMode method. " + ex.getMessage());
            ex.printStackTrace();
        }
        
        getAppletContext().showDocument(url);
    }    
/*  ================================================
		PRIVATE CLASSES
    ================================================ */
    private class PopupHandler implements MouseListener
    {
	/** Figure out which JMenuItem was selected from the PopupMenu, and do something about it.
	 * 
	 * @param e MouseEvent
	 */
        public void mouseReleased(MouseEvent e)
        {
            if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != InputEvent.BUTTON1_MASK)
            {
                return;
            }
            
            // single click only
            if (e.getClickCount() == 1)
            {
                // get the popupmenu back
                JMenuItem selectedItem = (JMenuItem)e.getSource();
                
                // get the label name
                String selection = selectedItem.getText();

                int selectedIndex = list.getSelectedIndex();
                
                if (selection.equals("Open"))
                {                    
                    // open the url
                    openNode(selectedIndex);
                }
                else if (selection.equals("Add"))
                {                    
                    // open the url
                    openMode(selectedIndex, addMode);                    
                }
                else if (selection.equals("Delete"))
                {
                    // prompt the user to make sure they really meant to delete that
                    JOptionPane optionPane = new JOptionPane("Are you really sure you wish to delete this object? This will remove any object related to it.", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);                    
                    JDialog dialog = optionPane.createDialog(getContentPane(), "Delete?");
                    dialog.show();
                    // figure out which value they selected
                    Integer valueSelected = (Integer)optionPane.getValue();
                    
                    if (valueSelected != null && valueSelected.intValue() == 0)
                    {                                        
                        //open url                        
                        openMode(selectedIndex, deleteMode);
                    }
                }
            }
        }
        
	/** @param e 
	 */
        public void mousePressed(MouseEvent e)
        {        
            // do nothing
        }
	/** @param e 
	 */
        public void mouseClicked(MouseEvent e)
        {
            // do nothing
        }        
	/** @param e 
	 */
        public void mouseEntered(MouseEvent e)
        {
            // do nothing
        }
	/** @param e 
	 */
        public void mouseExited(MouseEvent e)
        {
            // do nothing
        }   
    }
    
    private class ListHandler implements MouseListener
    {
	/** If it's a double-click left event, do an Open event, if it's a right-click single-click select the item underneath the mouse pointer, if releveant.
	 * 
	 * @param e MouseEvent
	 */
        public void mousePressed(MouseEvent e)
        {
            if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK)
            {   
                // if it was a double-click
                if (e.getClickCount() == 2)
                {
                    int selectedIndex = list.locationToIndex(e.getPoint());
                    
                    if (selectedIndex != -1)
                    {
                        openNode(selectedIndex);                                                
                    }
                }
            }
            else if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK)
            {
                // if it was single click
                if (e.getClickCount() == 1)
                {
                    // figure out which one we're over
                    int clickedIndex = list.locationToIndex(e.getPoint());
                    
                    if (clickedIndex != -1)
                    {                        
                        // clear selected items
                        list.clearSelection();
                        
                        // select one over top of
                        list.setSelectedIndex(clickedIndex);
                    }
                }
            }
        }        
        
	/** If the right mouse button is released, show the PopupMenu. Only show part of it if the right-mouse button isn't over a ListItem however.
	 * 
	 * @param e MouseEvent
	 */
        public void mouseReleased(MouseEvent e)
        {
            // only left clicks
            if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK)
            {
                return;
            }
            
            // single click only
            if (e.getClickCount() == 1)
            {
                
                // get the row clicked on
                int clickedIndex = list.locationToIndex(e.getPoint());
                if (clickedIndex != -1)
                {
                    // gonna show popup
                    JPopupMenu popupMenu = new JPopupMenu();

                    // get our new mouselistener handler for popup        
                    PopupHandler handler = new PopupHandler();
     
                   // create the popupMenus
                    JMenuItem item = new JMenuItem("Open");
                    item.addMouseListener(handler);
                    popupMenu.add(item);                    
                    popupMenu.add(new JSeparator());
                    item = new JMenuItem("Add");
                    item.addMouseListener(handler);
                    popupMenu.add(item);
                    item = new JMenuItem("Delete");
                    item.addMouseListener(handler);
                    popupMenu.add(item);
                    
                    
                    // add it to the listener
                    popupMenu.addMouseListener(handler);
                    
                    popupMenu.show(list, e.getX(), e.getY());
                }
                else
                {
                    // gonna show popup
                    JPopupMenu popupMenu = new JPopupMenu();

                    // get our new mouselistener handler for popup        
                    PopupHandler handler = new PopupHandler();
     
                   // create the popupMenus
                    JMenuItem item = new JMenuItem("Add");
                    item.addMouseListener(handler);
                    popupMenu.add(item);                    
                    
                    // add it to the listener
                    popupMenu.addMouseListener(handler);
                    
                    popupMenu.show(list, e.getX(), e.getY());			
                }
            }            
        }
        
	/** @param e 
	 */
        public void treeCollapsed(TreeExpansionEvent e)
        {            
            // do nothing
        }

	/** @param e 
	 */
        public void mouseClicked(MouseEvent e)
        {
            // do nothing
        }
        
	/** @param e 
	 */
        public void mouseEntered(MouseEvent e)
        {
            // do nothing
        }
	/** @param e 
	 */
        public void mouseExited(MouseEvent e)
        {
            // do nothing
        }   
    }                     
}
