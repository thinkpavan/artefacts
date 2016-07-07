package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.PassvalHolder
<li> <b>Source File</b> INetMod/PassvalHolder.java
<li> <b>IDL Source File</b> passval.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Passval
<li> <b>Repository Identifier</b> IDL:INetMod/Passval:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface Passval {
      void passParam(
        in short s,
        in wchar w,
        in double d
      );
      long passParam1(
        in char c,
        in long long ll
      );
    };
</pre>
</p>
*/
final public class PassvalHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.Passval value;
  public PassvalHolder() {
  }
  public PassvalHolder(INetMod.Passval value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.PassvalHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.PassvalHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.PassvalHelper.type();
  }
}
