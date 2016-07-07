package com.submersion.jspshop.adminbrowse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;
import java.net.*;

/** Java applet for browsing of trees (be it object or class)
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @changedBy: $Author$
 * @see com.submersion.jspshop.adminbrowse.NetConnect
 * @changed: $Date$
 * @created: September 4, 2001
 * @version $Revision$
 */

public class AdminBrowse extends JApplet
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    /** Contains a hashCode, ID lookup for JTree Nodes
     */
    private HashMap indices = new HashMap();
    /** A DefaultTreeModel for underlying data structure
     */
    private DefaultTreeModel treeModel;
    /** JTree object
     */
    private JTree tree;
    /** The Path parameter, passed from the html page.
     * Contains a comma seperated path to describe which node should be selected
     */
    private String path;
    /** The ClickURL parameter, passed from the html page.
     * Contains a URL that should be called when a node is opened
     */
    private String clickURL;
    /** The ClickParam parameter, passed from the html page.
     * Contains the name of the parameter that should be passed when a Node is opened
     */
    private String clickParam;
    /** The ModeParam parameter, passed from the html page.
     * Contains the name of the parameter that should represent the mode passed to the clickURL
     */
    private String modeParam;
    /** The DeleteMode parameter, passed from the html page.
     * Contains the value of the mode for deletion.
     */
    private String deleteMode;
    /** The AddMode parameter, passed from the html page.
     * Contains the value of the mode for adding
     */
    private String addMode;    
    /** The Context parameter, passed from the html page.
     * Contains the ID from which the tree should be built.
     */
    private String context;
    /** The RootName parameter, passed from the html page.
     * Contains the name of the Root node (In case you don't want to use the default -1)
     */
    private String rootName;
    /** The URL parameter, passed from the html page.
     * Contains the URL from which to get Data from.
     */
    private String url;
    /** The URLParam parameter, passed from the html page.
     * Contains the parameter that should be passed to get new data.
     */
    private String urlParam;

/*  ================================================
		APPLET SPECIFIC
    ================================================ */
    
    /** Initialisation sequence starts here. Create the initial view of the tree, add the listeners, and display.
     */
    public void init()
    {
        // get the properties from the html page
        initialiseProperties();
        // create a new root node
        DefaultMutableTreeNode rootNode = createRootNode();
        // use a DefaultTreeModel with new node
        treeModel = new DefaultTreeModel(rootNode);
        // create the new JTree
        tree = new JTree(treeModel);
        // set the selection mode
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        // turn on root handles        
        tree.setShowsRootHandles(true);

        // get a pane
        JScrollPane pane = new JScrollPane(tree);
                
        // remove the border
        pane.setBorder(BorderFactory.createEmptyBorder());
        
        // add to content pane using a scroll pane
        getContentPane().add(pane);        
        
        // get an instance of our listener wrapper class
        TreeHandler treeHandler = new TreeHandler();
        
        // add the wrapper class as a listener to the tree
        tree.addTreeExpansionListener(treeHandler);
        tree.addMouseListener(treeHandler);
        
        // if a path was passed, move the tree to that selection
        if (path != null && !path.equals(""))
        {
            expandPath(path);
        }
    }

/*  ================================================
		PRIVATE METHODS
    ================================================ */
    /** Expands the JTree to the path specified.
     * 
     * @param path A comma seperated path containing the Objects to expand. 
     *     For example, Object,User,Anonymous would expand first the Object 
     *     node, then the User node, then select the Anonymous node
     */
    private void expandPath(String path)
    {
        // get a string array back on the delimiter
        String[] paths = split(path, ",");
        
        // work node
        DefaultMutableTreeNode currentNode = null;

        // go through each instance (except the last instance
        for (int i = 0; i < paths.length - 1; i++)
        {            
            currentNode = findNodeByID(paths[i]);
                        
            // something odd happend, so exit out
            if (currentNode == null)
            {
                break;
            }
                        
            // expand to that node
            tree.expandPath(new TreePath(currentNode.getPath()));
        }
        // get the last node
        currentNode = findNodeByID(paths[paths.length -1]);
        
        // something odd happened, ignore
        if (currentNode == null)
        {
            return;
        }
        // select the last node
        tree.addSelectionPath(new TreePath(currentNode.getPath()));
    }

    /** Uses the indices field to find a node by it's ID (from the context passed, or from the data provided by the corresponding JSP page)
     * 
     * @param id The ID to look for.
     * @return A TreeNode that represents the ID passed
     */
    private DefaultMutableTreeNode findNodeByID(String id)
    {
            // our work node
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)treeModel.getRoot();

            // get the current items hashcode from the hashtable
            Iterator iterator = indices.keySet().iterator();

            // our hashcode key
            Integer key = null;
            // iterate through all our current keys
            while (iterator.hasNext())
            {
                // get the current key
                key = (Integer)iterator.next();
                // check if it's ID matches ours
                if (id.equals((String)indices.get(key)))
                {
                    // it's what we want
                    break;
                }
            }
            
            // go find that item somewhere in the tree
            currentNode = findNode(currentNode, key.intValue());    
            
            return currentNode;
    }
    /** Finds a node by it's hashCode
     * 
     * @param node The node to start searching at.
     * @param key The hashcode for the node to look for.
     * @return A TreeNode matching the hashcode specified
     */
    private DefaultMutableTreeNode findNode(DefaultMutableTreeNode node, int key)
    {
        // check if the node passed matches (ie: Root)
        if (node.hashCode() == key)
        {
            return node;
        }
        // initialise to null
        DefaultMutableTreeNode currentNode = null;
        for (Enumeration e = node.children(); e.hasMoreElements();)
        {
            currentNode = (DefaultMutableTreeNode)e.nextElement();
            // check if this child matches the key
            if (currentNode.hashCode() == key)
            {
                return currentNode;
            }
            // recurse
            currentNode = findNode(currentNode, key);
            // it was found below
            if (currentNode != null)
            {
                // return it
                return currentNode;
            }
        }
        return currentNode;        
    }
    
	/** Helper function that splits apart a String by it's delimiter and returns an Array of that string.
	 * 
	 * @param str String to split.
	 * @param delim Delimiter to split by.
	 * @return An array containing the seperate peices that were delimited by the
	 *      delimiter
	 */
	private String[] split(String str, String delim) 
	{	
        // for temporarily storing our data
		ArrayList v = new ArrayList();
		
        // initialise current pos
		int cpos = 0;

        // keep going while more delimiters
		while(str.indexOf(delim,cpos) != -1)
		{	
            // delimiter point is where
			int pnt = str.indexOf(delim,cpos);
            // get a substring of the string using current pos and that point
			v.add(str.substring(cpos,pnt));
            // move the current pos past that point
			cpos = pnt + delim.length();
		}
        // add in last element
		v.add(str.substring(cpos,str.length()));

        // create return array
		String[] ret = new String[v.size()];
		for (int i = 0; i < ret.length; i++) 
		{
			ret[i] = (String) v.get(i);
		}
		
		return ret;
	}
    
    /** Using the netConnect and the URL parameter, creates a Layer under specified node, using context as a starting ID.
     * 
     * @param node The node of which to create the layer under
     * @param context The ID of the object to look for children for.
     */
    private void createLayer(DefaultMutableTreeNode node, String context)
    {
        // get an instance of net connect
        NetConnect net = new NetConnect(createURL(context));

        // clear the layer
        node.removeAllChildren();
        
        // return the data for this context
        HashMap nodes = net.getHashData();
        // initialise a work node
        DefaultMutableTreeNode currentNode = null;
        // get key iterator
        Iterator iterator = nodes.keySet().iterator();
        // iterate through all nodes
        while (iterator.hasNext())
        {
            // get the objectID
            String currElement = (String)iterator.next();
            // create this new node
            String[] data = (String[])nodes.get(currElement);
            currentNode = new DefaultMutableTreeNode(data[0]);

            // do children exist?
            if (new Boolean(data[1]).booleanValue())
            {
                // create a ghost node underneath it
                currentNode.add(new DefaultMutableTreeNode("loading..."));
            } 
            // add a lookup to the hashtable for the objectID of the node using it's hashCode
            indices.put(new Integer(currentNode.hashCode()), currElement);                    
            
            // add this to the current layer
            node.add(currentNode);
        }
    }
    
    /** Creates the root Node depending on what sort of data setup there is.
     * 
     * @return The new RootNode
     */
    private DefaultMutableTreeNode createRootNode()
    {
        // initialise the root node
        DefaultMutableTreeNode rootNode = null;
        
        // if it's something other than the top
        if (!context.equals("-1"))
        {
            // verify the name has been set
            if (rootName == null || rootName.equals(""))
            {
                throw new NullPointerException("RootName parameter was empty.");
            }
            // create the new node
            rootNode = new DefaultMutableTreeNode(rootName);

            // add a lookup to the hashtable for the objectID of the noprivatede using it's hashCode
            indices.put(new Integer(rootNode.hashCode()), context);
                        
            // create the layer underneath this one
            createLayer(rootNode, context);
        }
        else
        {
            // NetConnect is helper class that calls special servlet to get data
            NetConnect net = new NetConnect(createURL(context));
            // return data from NetConnect
            HashMap nodes = net.getHashData();            
            
            if (nodes.size() > 1)
            {
                // since with our current TreeModel we can't have more than one root, create a "fake" root
                rootNode = new DefaultMutableTreeNode("Root");
                
                // add a lookup to the hashtable for the objectID of the node using it's hashCode
                indices.put(new Integer(rootNode.hashCode()), context);                    

                // create all layers underneath this "fake" root
                createLayer(rootNode, context);
            }
            else
            {
                // get the element from nodes
                String element = (String)nodes.keySet().iterator().next();
                
                String[] data = (String[])nodes.get(element);
                // create a root node using it
                rootNode = new DefaultMutableTreeNode(data[0]);
                // add a lookup to the hashtable for the objectID of the node using it's hashCode
                indices.put(new Integer(rootNode.hashCode()), element);                    
                
                // create all layers of this context                
                createLayer(rootNode, element);
            }                        
        }
        return rootNode;
    }
    
    /** Concatenates a new String containing the URL that is used to get data from.
     * 
     * @param context The ID of the object that the URL is getting created 
     *     for.
     * @return A String containing a URL
     */
    private String createURL(String context)
    {
        // create stringbuffer for url
        StringBuffer sbuf = new StringBuffer();
        
        // create url
        sbuf.append(url);
        sbuf.append("?");
        sbuf.append(urlParam);
        sbuf.append("=");
        sbuf.append(context);
        
        // return it
        return sbuf.toString();
    }
    
    /** Read the properties from the Applet tags, validate them, and store them in local variables
     */
    private void initialiseProperties()
    {
        // get properties from <PARAM> tags
        context = getParameter("Context");
        rootName = getParameter("RootName");
        url = getParameter("URL");
        urlParam = getParameter("URLParam");
        path = getParameter("Path");
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
        // if context wasn't passed, set it to -1
        if (context == null || context.equals(""))
        {
            context = "-1";
        }
        // url is required
        if (url == null || url.equals(""))
        {
            throw new NullPointerException("URL parameter was empty.");
        }
        // urlParam is required
        if (urlParam == null || urlParam.equals(""))
        {
            throw new NullPointerException("URLParam parameter was empty.");
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

    /** Creates A URL using the ClickURL and ClickParam parameters, then goes to that URL.
     * 
     * @param treeNode The node selected.
     * @param treePath The TreePath to the node selected.
     */
    private void openNode(DefaultMutableTreeNode treeNode, TreePath treePath)
    {
        // get the id of the node dbl-clicked on
        String id = (String)indices.get(new Integer(treeNode.hashCode()));
        
        // build a path to the node for reconstruction
        Object[] nodes = treePath.getPath();

        // for holding the path
        StringBuffer sbuf = new StringBuffer();
        // go through each node
        for (int i = 0; i < nodes.length; i++)
        {
            // apend the id for that node
            sbuf.append(indices.get(new Integer(nodes[i].hashCode())));
            // don't add comma to end
            if (i != nodes.length - 1)
            {
                // comma seperate it
                sbuf.append(",");
            }                            
        }
        // create URL
        StringBuffer newURL = new StringBuffer();
        newURL.append(clickURL);
        newURL.append("?");
        newURL.append(clickParam);
        newURL.append("=");
        newURL.append(id);
        newURL.append("&");
        newURL.append("path=");
        newURL.append(sbuf.toString());
        
        URL url = null;
        try
        {
            url = new URL(newURL.toString());
        }
        catch (MalformedURLException ex)
        {
            System.err.println("AdminBrowse: Error creating url on double-click event in TreeHandler class. " + ex.getMessage());
            ex.printStackTrace();
        }
        
        getAppletContext().showDocument(url);                
    }
                        
    /** Creates A URL using the ClickURL and Mode parameters, then goes to that URL.
     * 
     * @param treeNode The TreeNode selected.
     * @param mode The Mode to use, for example add,delete.
     * @param treePath The path to the TreeNode selected.
     */
    private void openMode(DefaultMutableTreeNode treeNode, String mode, TreePath treePath)
    {
        // get the id of the node right-clicked on
        String id = (String)indices.get(new Integer(treeNode.hashCode()));

        // build a path to the node for reconstruction
        Object[] nodes = treePath.getPath();

        // for holding the path
        StringBuffer sbuf = new StringBuffer();
        // go through each node
        for (int i = 0; i < nodes.length; i++)
        {
            // apend the id for that node
            sbuf.append(indices.get(new Integer(nodes[i].hashCode())));
            // don't add comma to end
            if (i != nodes.length - 1)
            {
                // comma seperate it
                sbuf.append(",");
            }                            
        }
        
        // create URL
        StringBuffer newURL = new StringBuffer();
        newURL.append(clickURL);
        newURL.append("?");
        newURL.append(clickParam);
        newURL.append("=");
        newURL.append(id);
        newURL.append("&");
        newURL.append(modeParam);                    
        newURL.append("=");
        newURL.append(mode);
        newURL.append("&");
        newURL.append("path=");
        newURL.append(sbuf.toString());
        URL url = null;
        try
        {
            url = new URL(newURL.toString());
        }
        catch (MalformedURLException ex)
        {
            System.err.println("AdminBrowse: Error creating url on select event in PopupHandler class. " + ex.getMessage());
            ex.printStackTrace();
        }
        
        getAppletContext().showDocument(url);
    }    
    
/*  ================================================
		PRIVATE CLASS
    ================================================ */
    private class PopupHandler implements MouseListener
    {
	/** Check to see what JMenuItem was selected.
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

                if (selection.equals("Open"))
                {
                    // figure out which node is selected
                    TreePath treePath = tree.getSelectionPath();
                    
                    // get instance of that node
                    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                    // open the url
                    openNode(treeNode, treePath);
                }
                else if (selection.equals("Add Sub"))
                {
                    // figure out which node is selected
                    TreePath treePath = tree.getSelectionPath();
                    
                    // get an instance of that node
                    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                    
                    openMode(treeNode, addMode, treePath);
                    
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
                        // figure out which node is selected
                        TreePath treePath = tree.getSelectionPath();
                        
                        // get an instance of that node
                        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                        
                        openMode(treeNode, deleteMode, treePath);
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
    
    private class TreeHandler implements  TreeExpansionListener, MouseListener
    {        
	/** When expanded, populate the data below the object expanded.
	 * 
	 * @param e TreeExpansionEvent
	 */
        public void treeExpanded(TreeExpansionEvent e)
        {         
            // get the path of the node collapsing
            TreePath treePath = e.getPath();
            // get an instance of it's node
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
            
            // figure out the context for this node.
            String context = (String)indices.get(new Integer(treeNode.hashCode()));
                        
            // create the layer
            createLayer(treeNode,context);           
            
            // refresh tree
            treeModel.nodeStructureChanged(treeNode);
        }
        
	/** If a double-click, open the mode, if a Right-Click, select the node right-clicked.
	 * 
	 * @param e MouseEvent
	 */
        public void mousePressed(MouseEvent e)
        {
            // get the row clicked on
            int clickedRow = tree.getRowForLocation(e.getX(), e.getY());
            
            // if it was a valid click
            if (clickedRow != -1)
            {    
                // only left clicks
                if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK)
                {
                    // only if they double-clicked
                    if (e.getClickCount() == 2)
                    {
                        // get the path to that node
                        TreePath treePath = tree.getPathForRow(clickedRow);
                        // get instance of the node
                        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                        
                        openNode(treeNode, treePath);
                    }
                }
                else if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK)
                {
                    if (e.getClickCount() == 1)
                    {
                        // get the path
                        TreePath treePath = tree.getPathForRow(clickedRow);
                        // clear current selection
                        tree.clearSelection();
                        // add this path to selection
                        tree.addSelectionPath(treePath);
                    }       
                }
            }
        }

	/** Display the PopupMenu
	 * 
	 * @param e MouseEevent
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
                int clickedRow = tree.getRowForLocation(e.getX(), e.getY());

                if (clickedRow != -1)
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
                    item = new JMenuItem("Add Sub");
                    item.addMouseListener(handler);
                    popupMenu.add(item);
                    item = new JMenuItem("Delete");
                    item.addMouseListener(handler);
                    popupMenu.add(item);
                    
                    
                    // add it to the listener
                    popupMenu.addMouseListener(handler);
                    
                    popupMenu.show(tree, e.getX(), e.getY());
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
