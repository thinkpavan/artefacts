package otm;

public class OLPK implements java.io.Serializable 
{
  public String orderId;
  public String lineId; 

  public OLPK(){} // required according to spec.
  public OLPK(String ordid, String lineid) 
  {
    this.orderId= ordid;
    this.lineId= lineid;
  }

  public boolean equals(Object other) 
  {
    if (other == this) return true;

    if (!(other instanceof OLPK))
      return false;
 
    OLPK othersPK = (OLPK)other;

    if (( othersPK.orderId== this.orderId) && (this.lineId == othersPK.lineId )) 
	return true;
    else 
      return false;
    
  }
 
  public int hashCode(){
    int hashCode=100;
    return hashCode;
  }

  public String toString() {
    return  "(" + orderId+":"+lineId +")";
  }
}
