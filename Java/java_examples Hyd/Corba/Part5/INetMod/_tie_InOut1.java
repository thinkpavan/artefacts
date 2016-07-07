package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._tie_InOut1
<li> <b>Source File</b> INetMod/_tie_InOut1.java
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
public class _tie_InOut1 extends INetMod._InOut1ImplBase {
  private INetMod.InOut1Operations _delegate;
  public _tie_InOut1(INetMod.InOut1Operations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_InOut1(INetMod.InOut1Operations delegate) {
    this._delegate = delegate;
  }
  public INetMod.InOut1Operations _delegate() {
    return this._delegate;
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
    return this._delegate.passParam(
      c
    );
  }
}
