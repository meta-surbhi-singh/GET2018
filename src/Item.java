
public class Item 
{
  public static int s_no=0;
  public String itemName;
  public float itemPrice;
  public int quantity;


public Item(String itemName, float itemPrice )
{
    s_no++;
	this.itemName=itemName;
	this.itemPrice=itemPrice;
	
}
public void updateQuantity(int quantity)
{
	this.quantity=quantity;
}
}



