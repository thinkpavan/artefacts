
/* Shows how to create new events of our own
this interface shows how to define listener interface
Version -1.0
Author Team -J
*/

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

interface CustListener extends EventListener{
  void CustAction1(CustEvent e);
  void CustAction2(CustEvent e);

 } 