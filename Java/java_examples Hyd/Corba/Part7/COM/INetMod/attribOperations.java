package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod.attribOperations
<li> <b>Source File</b> com/INetMod/attribOperations.java
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
public interface attribOperations {
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
    com.INetMod.attribPackage.corbaexception;
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
  );
  /**
  <p>
  Reader for attribute: <b>::com::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count();
  /**
  <p>
  Reader for attribute: <b>::com::INetMod::attrib::ro</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    readonly attribute short ro;
  </pre>
  </p>
  */
  public short ro();
}
