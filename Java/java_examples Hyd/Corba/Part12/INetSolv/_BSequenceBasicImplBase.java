package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._BSequenceBasicImplBase
<li> <b>Source File</b> INetSolv/_BSequenceBasicImplBase.java
<li> <b>IDL Source File</b> BSequenceBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::BSequenceBasic
<li> <b>Repository Identifier</b> IDL:INetSolv/BSequenceBasic:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface BSequenceBasic {
      void modifySequence(
        inout ::INetSolv::seq1 inoutSeq,
        in ::INetSolv::seq2 inSeq
      );
    };
</pre>
</p>
*/
abstract public class _BSequenceBasicImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetSolv.BSequenceBasic {
  protected INetSolv.BSequenceBasic _wrapper = null;
  public INetSolv.BSequenceBasic _this() {
    return this;
  }
  protected _BSequenceBasicImplBase(java.lang.String name) {
    super(name);
  }
  public _BSequenceBasicImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetSolv.BSequenceBasic";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/BSequenceBasic:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("modifySequence", 0, 0),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetSolv._BSequenceBasicImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetSolv.BSequenceBasic _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      INetSolv.seq1Holder inoutSeq = new INetSolv.seq1Holder();
      inoutSeq.value = INetSolv.seq1Helper.read(_input);
      short[] inSeq;
      inSeq = INetSolv.seq2Helper.read(_input);
      _self.modifySequence(inoutSeq,inSeq);
      INetSolv.seq1Helper.write(_output, inoutSeq.value);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
