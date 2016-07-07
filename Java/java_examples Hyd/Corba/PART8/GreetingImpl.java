/* A sample corba server 
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;
public class GreetingImpl extends INetMod._GreetingImplBase {
  /** Construct a persistently named object. */
  public GreetingImpl(java.lang.String name) {
    super(name);
  }
  public GreetingImpl() {
    super();
  }
  
  public java.lang.String TGreeting() {
        return (" Hi Good Morining, Date:" + new Date());
  }
}
