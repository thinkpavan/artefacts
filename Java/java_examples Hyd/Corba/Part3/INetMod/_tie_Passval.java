package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._tie_Passval
<li> <b>Source File</b> INetMod/_tie_Passval.java
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
public class _tie_Passval extends INetMod._PassvalImplBase {
  private INetMod.PassvalOperations _delegate;
  public _tie_Passval(INetMod.PassvalOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_Passval(INetMod.PassvalOperations delegate) {
    this._delegate = delegate;
  }
  public INetMod.PassvalOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::INetMod::Passval::passParam</b>.
  <pre>
    #pragma prefix "INetMod/Passval"
    void passParam(
      in short s,
      in wchar w,
      in double d
    );
  </pre>
  </p>
  */
  public void passParam(
    short s,
    char w,
    double d
  ) {
    this._delegate.passParam(
      s,
      w,
      d
    );
  }
  /**
  <p>
  Operation: <b>::INetMod::Passval::passParam1</b>.
  <pre>
    #pragma prefix "INetMod/Passval"
    long passParam1(
      in char c,
      in long long ll
    );
  </pre>
  </p>
  */
  public int passParam1(
    char c,
    long ll
  ) {
    return this._delegate.passParam1(
      c,
      ll
    );
  }
}
