package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.CompanyHolder
<li> <b>Source File</b> INetMod/CompanyHolder.java
<li> <b>IDL Source File</b> inout1.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Company
<li> <b>Repository Identifier</b> IDL:INetMod/Company:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    struct Company {
      string name;
      long yoe;
      string ceo;
      string otherattrib;
    };
</pre>
</p>
*/
final public class CompanyHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.Company value;
  public CompanyHolder() {
  }
  public CompanyHolder(INetMod.Company value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.CompanyHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.CompanyHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.CompanyHelper.type();
  }
}
