package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.PerFactory
<li> <b>Source File</b> INetSolv/PerFactory.java
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
public interface PerFactory extends com.inprise.vbroker.CORBA.Object {
  /**
  <p>
  Operation: <b>::INetSolv::PerFactory::CreateNPObj</b>.
  <pre>
    #pragma prefix "INetSolv/PerFactory"
    ::INetSolv::NPObj CreateNPObj();
  </pre>
  </p>
  */
  public INetSolv.NPObj CreateNPObj();
  /**
  <p>
  Operation: <b>::INetSolv::PerFactory::dosomeThing</b>.
  <pre>
    #pragma prefix "INetSolv/PerFactory"
    void dosomeThing();
  </pre>
  </p>
  */
  public void dosomeThing();
}
