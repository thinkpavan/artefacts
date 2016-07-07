package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.ArrayBasic
<li> <b>Source File</b> INetSolv/ArrayBasic.java
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
public interface ArrayBasic extends com.inprise.vbroker.CORBA.Object {
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
