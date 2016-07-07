
/* Shows how to create new events of our own
Version -1.0
Author Team -J
*/

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class CustEvent extends AWTEvent{
  public static final int CUST_FIRST =  AWTEvent.RESERVED_ID_MAX  + 10;
  public static final int CUST_LAST =  AWTEvent.RESERVED_ID_MAX  + 11;
  public static final int CUST_ACTION1=  AWTEvent.RESERVED_ID_MAX  + 10;
  public static final int CUST_ACTION2=  AWTEvent.RESERVED_ID_MAX  + 11;

  public CustEvent(Object src ,int id) {
     super(src,id);
 } 
//we can provide additional methods here if needed
}