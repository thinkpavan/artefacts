package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._tie_ArrayBasic
<li> <b>Source File</b> INetSolv/_tie_ArrayBasic.java
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
public class _tie_ArrayBasic extends INetSolv._ArrayBasicImplBase {
  private INetSolv.ArrayBasicOperations _delegate;
  public _tie_ArrayBasic(INetSolv.ArrayBasicOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_ArrayBasic(INetSolv.ArrayBasicOperations delegate) {
    this._delegate = delegate;
  }
  public INetSolv.ArrayBasicOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::INetSolv::ArrayBasic::modifyArray</b>.
  <pre>
    #pragma prefix "INetSolv/ArrayBasic"
    void modifyArray(
      inout ::INetSolv::larray inoutarr,
      in ::INetSolv::sarray inarr
    );
  </pre>
  </p>
  */
  public void modifyArray(
    INetSolv.larrayHolder inoutarr,
    short[][] inarr
  ) {
    this._delegate.modifyArray(
      inoutarr,
      inarr
    );
  }
}
