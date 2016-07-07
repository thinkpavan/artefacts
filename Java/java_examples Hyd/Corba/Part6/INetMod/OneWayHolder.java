package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.OneWayHolder
<li> <b>Source File</b> INetMod/OneWayHolder.java
<li> <b>IDL Source File</b> OneWay.idl
<li> <b>IDL Absolute Name</b> ::INetMod::OneWay
<li> <b>Repository Identifier</b> IDL:INetMod/OneWay:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface OneWay {
      oneway void owmethod(
        in short s
      );
      void normalmethod();
      long normalmethod1();
      oneway void owmethod1(
        inout short s
      );
    };
</pre>
</p>
*/
final public class OneWayHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.OneWay value;
  public OneWayHolder() {
  }
  public OneWayHolder(INetMod.OneWay value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.OneWayHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.OneWayHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.OneWayHelper.type();
  }
}
