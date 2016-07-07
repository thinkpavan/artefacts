package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.NPObjHolder
<li> <b>Source File</b> INetSolv/NPObjHolder.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::NPObj
<li> <b>Repository Identifier</b> IDL:INetSolv/NPObj:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface NPObj {
      attribute wstring name;
      void donothing();
    };
</pre>
</p>
*/
final public class NPObjHolder implements org.omg.CORBA.portable.Streamable {
  public INetSolv.NPObj value;
  public NPObjHolder() {
  }
  public NPObjHolder(INetSolv.NPObj value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.NPObjHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.NPObjHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.NPObjHelper.type();
  }
}
