package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.GreetingOperations
<li> <b>Source File</b> INetMod/GreetingOperations.java
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
public interface GreetingOperations {
  /**
  <p>
  Operation: <b>::INetMod::Greeting::TGreeting</b>.
  <pre>
    #pragma prefix "INetMod/Greeting"
    wstring TGreeting();
  </pre>
  </p>
  */
  public java.lang.String TGreeting();
}
