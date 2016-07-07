package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.ArrayBasicHolder
<li> <b>Source File</b> INetSolv/ArrayBasicHolder.java
<li> <b>IDL Source File</b> ArrayBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::ArrayBasic
<li> <b>Repository Identifier</b> IDL:INetSolv/ArrayBasic:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface ArrayBasic {
      void modifyArray(
        inout ::INetSolv::larray inoutarr,
        in ::INetSolv::sarray inarr
      );
    };
</pre>
</p>
*/
final public class ArrayBasicHolder implements org.omg.CORBA.portable.Streamable {
  public INetSolv.ArrayBasic value;
  public ArrayBasicHolder() {
  }
  public ArrayBasicHolder(INetSolv.ArrayBasic value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.ArrayBasicHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.ArrayBasicHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.ArrayBasicHelper.type();
  }
}
