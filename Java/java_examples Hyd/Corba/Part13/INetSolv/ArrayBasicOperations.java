package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.ArrayBasicOperations
<li> <b>Source File</b> INetSolv/ArrayBasicOperations.java
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
public interface ArrayBasicOperations {
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
  );
}
