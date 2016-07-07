package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._st_ArrayBasic
<li> <b>Source File</b> INetSolv/_st_ArrayBasic.java
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
public class _st_ArrayBasic extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetSolv.ArrayBasic {
  protected INetSolv.ArrayBasic _wrapper = null;
  public INetSolv.ArrayBasic _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/ArrayBasic:1.0"
  };
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("modifyArray", true);
      INetSolv.larrayHelper.write(_output, inoutarr.value);
      INetSolv.sarrayHelper.write(_output, inarr);
      try {
        _input = this._invoke(_output, null);
        inoutarr.value = INetSolv.larrayHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
}
