package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.PerFactoryHolder
<li> <b>Source File</b> INetSolv/PerFactoryHolder.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::PerFactory
<li> <b>Repository Identifier</b> IDL:INetSolv/PerFactory:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface PerFactory {
      ::INetSolv::NPObj CreateNPObj();
      void dosomeThing();
    };
</pre>
</p>
*/
final public class PerFactoryHolder implements org.omg.CORBA.portable.Streamable {
  public INetSolv.PerFactory value;
  public PerFactoryHolder() {
  }
  public PerFactoryHolder(INetSolv.PerFactory value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.PerFactoryHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.PerFactoryHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.PerFactoryHelper.type();
  }
}
