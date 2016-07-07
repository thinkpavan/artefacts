  package com.INetMod.attribPackage;
  /**
  <p>
  <ul>
  <li> <b>Java Class</b> com.INetMod.attribPackage.corbaexception
  <li> <b>Source File</b> com/INetMod/attribPackage/corbaexception.java
  <li> <b>IDL Source File</b> attrib.idl
  <li> <b>IDL Absolute Name</b> ::com::INetMod::attrib::corbaexception
  <li> <b>Repository Identifier</b> IDL:com/INetMod/attrib/corbaexception:1.0
  </ul>
  <b>IDL definition:</b>
  <pre>
    #pragma prefix "com/INetMod/attrib"
    exception corbaexception {
      string exstr;
    };
  </pre>
  </p>
  */
  final public class corbaexception extends org.omg.CORBA.UserException {
    public java.lang.String exstr;
    public corbaexception() {
    }
    public corbaexception(
      java.lang.String exstr
    ) {
      this.exstr = exstr;
    }
    public java.lang.String toString() {
      org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
      com.INetMod.attribPackage.corbaexceptionHelper.insert(any, this);
      return any.toString();
    }
  }
