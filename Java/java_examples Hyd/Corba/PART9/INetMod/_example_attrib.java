package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._example_attrib
<li> <b>Source File</b> INetMod/_example_attrib.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface attrib {
      attribute long count;
      void dooperation();
    };
</pre>
</p>
*/
public class _example_attrib extends INetMod._attribImplBase {
  /** Construct a persistently named object. */
  public _example_attrib(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_attrib() {
    super();
  }
  /**
  <p>
  Operation: <b>::INetMod::attrib::dooperation</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    void dooperation();
  </pre>
  </p>
  */
  public void dooperation() {
    // IMPLEMENT: Operation
  }
  /**
  <p>
  Writer for attribute: <b>::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public void count(
    int count
  ) {
    // IMPLEMENT: Writer for attribute
  }
  /**
  <p>
  Reader for attribute: <b>::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count() {
    // IMPLEMENT: Reader for attribute
    return 0;
  }
}
