package otm;

public class OrderPK implements java.io.Serializable 
{
  public String ordId;

  public OrderPK (){} // required according to spec.
  public OrderPK (String ordid) 
  {
    this.ordId= ordid;
  }

  public boolean equals(Object other) 
  {
    if (other == this) return true;

    if (!(other instanceof OLPK))
      return false;
 
    OrderPK othersPK = (OrderPK )other;

    if (( othersPK.ordId== this.ordId)) 
	return true;
    else 
      return false;
    
  }
 
  public int hashCode(){
    int hashCode=100;
    return hashCode;
  }

  public String toString() {
    return  ordId;
  }
}
