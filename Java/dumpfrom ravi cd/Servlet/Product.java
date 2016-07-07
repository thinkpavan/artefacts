public class  Product
{
 int id;
 String name;
 float price;
 String description;

 public Product()
 {
  id=0;
  name="";
  price=0.0f;
  description="";
 }
 public Product(int id,String name,float price,String description)
 {
  this.id=id;
  this.name=name;
  this.price=price;
  this.description=description;
 }
 public int getId()
 {
  return id;
 }
 public String getName()
 {
  return name;
 }
 public float getPrice()
 {
  return price;
 }
 public String getDescription()
 {
  return description;
 }
}
