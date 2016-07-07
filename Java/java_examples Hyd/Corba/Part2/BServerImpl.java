
public class BServerImpl extends INetMod._BServerImplBase {
  public BServerImpl(java.lang.String name) {
    super(name);
  }
  public BServerImpl() {
    super();
  }
 
  public short someShort() {
    // IMPLEMENT: Operation
    short s = 555;
    return s;
  }
 
  public float someFloat() {
    // IMPLEMENT: Operation
    return 22.22f;
  }
 
  public int someLong() {
    // IMPLEMENT: Operation
    return 78787;
  }

  public double someDouble() {
    // IMPLEMENT: Operation
    return 66.666;
  }

  public int someULong() {
    // IMPLEMENT: Operation
// here both server and client are in java so we have no problem
// if server is in c/c++ where we have a clean mapping for usigned longs
// we have to handle those cases on our own
    return 890897;
  }

  public char someChar() {
    // IMPLEMENT: Operation
// if we pass an unicode char then we will have a problem here
    return 0xf678;// some unicode char with hi byte set
  }

  public char someWChar() {
    // IMPLEMENT: Operation
    return 0xf678;
  }

  public boolean someBoolean() {
    // IMPLEMENT: Operation
    return false;
  }
}
