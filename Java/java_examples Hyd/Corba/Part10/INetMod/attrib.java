package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.attrib
<li> <b>Source File</b> INetMod/attrib.java
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
public interface attrib extends com.inprise.vbroker.CORBA.Object {
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
  );
  /**
  <p>
  Reader for attribute: <b>::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count();
  /**
  <p>
  Operation: <b>::INetMod::attrib::dooperation</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    void dooperation();
  </pre>
  </p>
  */
  public void dooperation();
}
