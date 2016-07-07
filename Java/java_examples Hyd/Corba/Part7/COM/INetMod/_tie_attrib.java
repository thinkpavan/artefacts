package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod._tie_attrib
<li> <b>Source File</b> com/INetMod/_tie_attrib.java
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
public class _tie_attrib extends com.INetMod._attribImplBase {
  private com.INetMod.attribOperations _delegate;
  public _tie_attrib(com.INetMod.attribOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_attrib(com.INetMod.attribOperations delegate) {
    this._delegate = delegate;
  }
  public com.INetMod.attribOperations _delegate() {
    return this._delegate;
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
    this._delegate.dooperation(
    );
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
    this._delegate.count(
      count
    );
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
    return this._delegate.count(
    );
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
    return this._delegate.ro(
    );
  }
}
