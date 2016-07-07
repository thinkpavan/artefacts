import java.util.*;
public class  ProductDet
{
 public int noOfItems=5;
 Product prodArray[];
 Product prod;
 Hashtable shelf;
 public  ProductDet()
 {
   shelf=new  Hashtable();
   prodArray=new Product[noOfItems];
   prod=new Product(101,"Close up Paste",45.50f,"CLOSE UP SMILE");
   shelf.put("101",prod);
   prodArray[0]=prod;
   prod=new Product(102,"Lux International",45.50f,"FOR FAIR AND LOVELY SKIN");
   shelf.put("102",prod);
   prodArray[3]=prod;
   prod=new Product(103,"Pears",15.50f,"THE WINTER SOAP TO KEEP YOUR SKIN GLOWINg");
   shelf.put("103",prod);
   prodArray[4]=prod;
   prod=new Product(104,"Frosties",100.50f,"ENERGY FOOD FOR BREAKFAST");
   shelf.put("104",prod);
   prodArray[2]=prod;
   prod=new Product(105,"Complan",100.50f,"THE COMPLETE PLAN FOOD");
   shelf.put("105",prod);
   prodArray[1]=prod;
 }
 public  Product  getDetail(String id)
 {
   return (Product)shelf.get(id);
 }
 public  Product[]  getAllDetails()
 {
   return prodArray;
 }
 public  int  getNoOfItems()
 {
   return noOfItems;
 }
}
