package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._example_Greeting
<li> <b>Source File</b> INetMod/_example_Greeting.java
<li> <b>IDL Source File</b> Greeting.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Greeting
<li> <b>Repository Identifier</b> IDL:INetMod/Greeting:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface Greeting {
      wstring TGreeting();
    };
</pre>
</p>
*/
public class _example_Greeting extends INetMod._GreetingImplBase {
  /** Construct a persistently named object. */
  public _example_Greeting(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_Greeting() {
    super();
  }
  /**
  <p>
  Operation: <b>::INetMod::Greeting::TGreeting</b>.
  <pre>
    #pragma prefix "INetMod/Greeting"
    wstring TGreeting();
  </pre>
  </p>
  */
  public java.lang.String TGreeting() {
    // IMPLEMENT: Operation
    return null;
  }
}
