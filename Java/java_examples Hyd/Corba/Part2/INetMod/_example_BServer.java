package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._example_BServer
<li> <b>Source File</b> INetMod/_example_BServer.java
<li> <b>IDL Source File</b> BServer.idl
<li> <b>IDL Absolute Name</b> ::INetMod::BServer
<li> <b>Repository Identifier</b> IDL:INetMod/BServer:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface BServer {
      short someShort();
      float someFloat();
      long someLong();
      double someDouble();
      unsigned long someULong();
      char someChar();
      wchar someWChar();
      boolean someBoolean();
    };
</pre>
</p>
*/
public class _example_BServer extends INetMod._BServerImplBase {
  /** Construct a persistently named object. */
  public _example_BServer(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_BServer() {
    super();
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someShort</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    short someShort();
  </pre>
  </p>
  */
  public short someShort() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someFloat</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    float someFloat();
  </pre>
  </p>
  */
  public float someFloat() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someLong</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    long someLong();
  </pre>
  </p>
  */
  public int someLong() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someDouble</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    double someDouble();
  </pre>
  </p>
  */
  public double someDouble() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someULong</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    unsigned long someULong();
  </pre>
  </p>
  */
  public int someULong() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someChar</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    char someChar();
  </pre>
  </p>
  */
  public char someChar() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someWChar</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    wchar someWChar();
  </pre>
  </p>
  */
  public char someWChar() {
    // IMPLEMENT: Operation
    return 0;
  }
  /**
  <p>
  Operation: <b>::INetMod::BServer::someBoolean</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    boolean someBoolean();
  </pre>
  </p>
  */
  public boolean someBoolean() {
    // IMPLEMENT: Operation
    return false;
  }
}
