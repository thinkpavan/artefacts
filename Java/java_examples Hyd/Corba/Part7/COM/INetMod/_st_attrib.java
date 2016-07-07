package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod._st_attrib
<li> <b>Source File</b> com/INetMod/_st_attrib.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::com::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:com/INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/INetMod"
    interface attrib {
      attribute long count;
      readonly attribute short ro;
      exception corbaexception {
        string exstr;
      };
      void dooperation(
      )
      raises(
        ::com::INetMod::attrib::corbaexception
      );
    };
</pre>
</p>
*/
public class _st_attrib extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.INetMod.attrib {
  protected com.INetMod.attrib _wrapper = null;
  public com.INetMod.attrib _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/INetMod/attrib:1.0"
  };
  /**
  <p>
  Operation: <b>::com::INetMod::attrib::dooperation</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    void dooperation(
    )
    raises(
      ::com::INetMod::attrib::corbaexception
    );
  </pre>
  </p>
  */
  public void dooperation(
  ) throws
    com.INetMod.attribPackage.corbaexception {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("dooperation", true);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.INetMod.attribPackage.corbaexceptionHelper.id())) {
            throw com.INetMod.attribPackage.corbaexceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
  /**
  <p>
  Writer for attribute: <b>::com::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public void count(
    int count
  ) {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("_set_count", true);
      _output.write_long(count);
      try {
        _input = this._invoke(_output, null);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
  /**
  <p>
  Reader for attribute: <b>::com::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    int _result;
    while(true) {
      _output = this._request("_get_count", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_long();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
	System.out.println("In client stub count = " + _result);
    return _result;
  }
  /**
  <p>
  Reader for attribute: <b>::com::INetMod::attrib::ro</b>.
  <pre>
    #pragma prefix "com/INetMod/attrib"
    readonly attribute short ro;
  </pre>
  </p>
  */
  public short ro() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    short _result;
    while(true) {
      _output = this._request("_get_ro", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_short();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
