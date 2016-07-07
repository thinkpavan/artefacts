package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.PassvalOperations
<li> <b>Source File</b> INetMod/PassvalOperations.java
<li> <b>IDL Source File</b> passval.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Passval
<li> <b>Repository Identifier</b> IDL:INetMod/Passval:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface Passval {
      void passParam(
        in short s,
        in wchar w,
        in double d
      );
      long passParam1(
        in char c,
        in long long ll
      );
    };
</pre>
</p>
*/
public interface PassvalOperations {
  /**
  <p>
  Operation: <b>::INetMod::Passval::passParam</b>.
  <pre>
    #pragma prefix "INetMod/Passval"
    void passParam(
      in short s,
      in wchar w,
      in double d
    );
  </pre>
  </p>
  */
  public void passParam(
    short s,
    char w,
    double d
  );
  /**
  <p>
  Operation: <b>::INetMod::Passval::passParam1</b>.
  <pre>
    #pragma prefix "INetMod/Passval"
    long passParam1(
      in char c,
      in long long ll
    );
  </pre>
  </p>
  */
  public int passParam1(
    char c,
    long ll
  );
}
