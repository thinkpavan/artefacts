package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.Greeting
<li> <b>Source File</b> INetMod/Greeting.java
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
public interface Greeting extends com.inprise.vbroker.CORBA.Object {
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
