package handler;


public class WSrv {

  public String GetMsg(String s) {
    System.out.println("In webservice method");
    return "Hello   " + s;
  }

}
