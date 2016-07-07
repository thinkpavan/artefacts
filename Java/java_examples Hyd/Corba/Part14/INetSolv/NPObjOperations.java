package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.NPObjOperations
<li> <b>Source File</b> INetSolv/NPObjOperations.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::NPObj
<li> <b>Repository Identifier</b> IDL:INetSolv/NPObj:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface NPObj {
      attribute wstring name;
      void donothing();
    };
</pre>
</p>
*/
public interface NPObjOperations {
  /**
  <p>
  Operation: <b>::INetSolv::NPObj::donothing</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    void donothing();
  </pre>
  </p>
  */
  public void donothing();
  /**
  <p>
  Writer for attribute: <b>::INetSolv::NPObj::name</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    attribute wstring name;
  </pre>
  </p>
  */
  public void name(
    java.lang.String name
  );
  /**
  <p>
  Reader for attribute: <b>::INetSolv::NPObj::name</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    attribute wstring name;
  </pre>
  </p>
  */
  public java.lang.String name();
}
