package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.Company
<li> <b>Source File</b> INetMod/Company.java
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
final public class Company {
  public java.lang.String name;
  public int yoe;
  public java.lang.String ceo;
  public java.lang.String otherattrib;
  public Company() {
  }
  public Company(
    java.lang.String name,
    int yoe,
    java.lang.String ceo,
    java.lang.String otherattrib
  ) {
    this.name = name;
    this.yoe = yoe;
    this.ceo = ceo;
    this.otherattrib = otherattrib;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    INetMod.CompanyHelper.insert(any, this);
    return any.toString();
  }
}
