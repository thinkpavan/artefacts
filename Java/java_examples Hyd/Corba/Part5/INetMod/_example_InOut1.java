package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._example_InOut1
<li> <b>Source File</b> INetMod/_example_InOut1.java
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
public class _example_InOut1 extends INetMod._InOut1ImplBase {
  /** Construct a persistently named object. */
  public _example_InOut1(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_InOut1() {
    super();
  }
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
  ) {
    // IMPLEMENT: Operation
    return null;
  }
}
