package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod._example_attrib
<li> <b>Source File</b> com/INetMod/_example_attrib.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::com::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:com/INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/INetMod"
    interface attrib {
      attribute long count;
      readonly attribute short ro;
      exception corbaexception {
        string exstr;
      };
      void dooperation(
      )
      raises(
        ::com::INetMod::attrib::corbaexception
      );
    };
</pre>
</p>
*/
public class _example_attrib extends com.INetMod._attribImplBase {
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
  Operation: <b>::com::INetMod::attrib::dooperation</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    void dooperation(
    )
    raises(
      ::com::INetMod::attrib::corbaexception
    );
  </pre>
  </p>
  */
  public void dooperation(
  ) throws
    com.INetMod.attribPackage.corbaexception {
    // IMPLEMENT: Operation
  }
  /**
  <p>
  Writer for attribute: <b>::com::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
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
  Reader for attribute: <b>::com::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count() {
    // IMPLEMENT: Reader for attribute
    return 0;
  }
  /**
  <p>
  Reader for attribute: <b>::com::INetMod::attrib::ro</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    readonly attribute short ro;
  </pre>
  </p>
  */
  public short ro() {
    // IMPLEMENT: Reader for attribute
    return 0;
  }
}
