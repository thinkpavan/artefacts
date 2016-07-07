package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.InOut
<li> <b>Source File</b> INetMod/InOut.java
<li> <b>IDL Source File</b> inout.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut
<li> <b>Repository Identifier</b> IDL:INetMod/InOut:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut {
      void passParam(
        out short s,
        inout wchar w
      );
      void passParam1(
        inout string s,
        inout wstring ws
      );
    };
</pre>
</p>
*/
public interface InOut extends com.inprise.vbroker.CORBA.Object {
  /**
  <p>
  Operation: <b>::INetMod::InOut::passParam</b>.
  <pre>
    #pragma prefix "INetMod/InOut"
    void passParam(
      out short s,
      inout wchar w
    );
  </pre>
  </p>
  */
  public void passParam(
    org.omg.CORBA.ShortHolder s,
    org.omg.CORBA.CharHolder w
  );
  /**
  <p>
  Operation: <b>::INetMod::InOut::passParam1</b>.
  <pre>
    #pragma prefix "INetMod/InOut"
    void passParam1(
      inout string s,
      inout wstring ws
    );
  </pre>
  </p>
  */
  public void passParam1(
    org.omg.CORBA.StringHolder s,
    org.omg.CORBA.StringHolder ws
  );
}
