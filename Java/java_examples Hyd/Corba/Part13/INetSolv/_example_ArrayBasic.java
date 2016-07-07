package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._example_ArrayBasic
<li> <b>Source File</b> INetSolv/_example_ArrayBasic.java
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
public class _example_ArrayBasic extends INetSolv._ArrayBasicImplBase {
  /** Construct a persistently named object. */
  public _example_ArrayBasic(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_ArrayBasic() {
    super();
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
    // IMPLEMENT: Operation
  }
}
