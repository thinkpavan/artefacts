package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.InOutHolder
<li> <b>Source File</b> INetMod/InOutHolder.java
<li> <b>IDL Source File</b> inout.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut
<li> <b>Repository Identifier</b> IDL:INetMod/InOut:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut {
      void passParam(
        out short s,
        inout wchar w
      );
      void passParam1(
        inout string s,
        inout wstring ws
      );
    };
</pre>
</p>
*/
final public class InOutHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.InOut value;
  public InOutHolder() {
  }
  public InOutHolder(INetMod.InOut value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.InOutHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.InOutHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.InOutHelper.type();
  }
}
