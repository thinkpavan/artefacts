package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.InOut1Holder
<li> <b>Source File</b> INetMod/InOut1Holder.java
<li> <b>IDL Source File</b> inout1.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut1
<li> <b>Repository Identifier</b> IDL:INetMod/InOut1:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut1 {
      ::INetMod::Company passParam(
        inout ::INetMod::Company c
      );
    };
</pre>
</p>
*/
final public class InOut1Holder implements org.omg.CORBA.portable.Streamable {
  public INetMod.InOut1 value;
  public InOut1Holder() {
  }
  public InOut1Holder(INetMod.InOut1 value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.InOut1Helper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.InOut1Helper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.InOut1Helper.type();
  }
}
