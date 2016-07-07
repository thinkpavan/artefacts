package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.InOut1
<li> <b>Source File</b> INetMod/InOut1.java
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
public interface InOut1 extends com.inprise.vbroker.CORBA.Object {
  /**
  <p>
  Operation: <b>::INetMod::InOut1::passParam</b>.
  <pre>
    #pragma prefix "INetMod/InOut1"
    ::INetMod::Company passParam(
      inout ::INetMod::Company c
    );
  </pre>
  </p>
  */
  public INetMod.Company passParam(
    INetMod.CompanyHolder c
  );
}
