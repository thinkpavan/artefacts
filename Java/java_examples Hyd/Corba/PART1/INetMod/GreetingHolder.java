package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.GreetingHolder
<li> <b>Source File</b> INetMod/GreetingHolder.java
<li> <b>IDL Source File</b> greeting.idl
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
final public class GreetingHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.Greeting value;
  public GreetingHolder() {
  }
  public GreetingHolder(INetMod.Greeting value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.GreetingHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.GreetingHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.GreetingHelper.type();
  }
}
