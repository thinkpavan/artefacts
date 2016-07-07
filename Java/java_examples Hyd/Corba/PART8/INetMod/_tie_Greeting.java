package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._tie_Greeting
<li> <b>Source File</b> INetMod/_tie_Greeting.java
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
public class _tie_Greeting extends INetMod._GreetingImplBase {
  private INetMod.GreetingOperations _delegate;
  public _tie_Greeting(INetMod.GreetingOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_Greeting(INetMod.GreetingOperations delegate) {
    this._delegate = delegate;
  }
  public INetMod.GreetingOperations _delegate() {
    return this._delegate;
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
    return this._delegate.TGreeting(
    );
  }
}
