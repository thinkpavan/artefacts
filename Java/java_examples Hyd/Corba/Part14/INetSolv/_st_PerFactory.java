package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._st_PerFactory
<li> <b>Source File</b> INetSolv/_st_PerFactory.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::PerFactory
<li> <b>Repository Identifier</b> IDL:INetSolv/PerFactory:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface PerFactory {
      ::INetSolv::NPObj CreateNPObj();
      void dosomeThing();
    };
</pre>
</p>
*/
public class _st_PerFactory extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetSolv.PerFactory {
  protected INetSolv.PerFactory _wrapper = null;
  public INetSolv.PerFactory _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/PerFactory:1.0"
  };
  /**
  <p>
  Operation: <b>::INetSolv::PerFactory::CreateNPObj</b>.
  <pre>
    #pragma prefix "INetSolv/PerFactory"
    ::INetSolv::NPObj CreateNPObj();
  </pre>
  </p>
  */
  public INetSolv.NPObj CreateNPObj() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    INetSolv.NPObj _result;
    while(true) {
      _output = this._request("CreateNPObj", true);
      try {
        _input = this._invoke(_output, null);
        _result = INetSolv.NPObjHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::INetSolv::PerFactory::dosomeThing</b>.
  <pre>
    #pragma prefix "INetSolv/PerFactory"
    void dosomeThing();
  </pre>
  </p>
  */
  public void dosomeThing() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("dosomeThing", true);
      try {
        _input = this._invoke(_output, null);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
}
