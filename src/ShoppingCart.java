
import java.util.List;
import java.util.ArrayList;
public class ShoppingCart 
{
public float bill;
public List<Item> shoppingList;

public ShoppingCart()
{   shoppingList=new ArrayList<Item>();
    bill=0.0f;
}

public void addInShoppinglist(ItemList il,int index)
{
	
  if(index<il.itemList.size()) 
    shoppingList.add(il.itemList.get(index));
  else
	System.out.println("Sorry.. Item index out of bounds..");
	
}


public void removeFromShoppinglist(int index)
{   if(index<shoppingList.size())
    { shoppingList.remove(index);
	System.out.println("This item has been removed from our shopping list..");
    }
    else
    System.out.println("Product not in the shopping list");
 		
}

public void displayShoppingList(ItemList il)
{
	for(int i=0;i<shoppingList.size();i++)
		 System.out.println("S.NO." + (i+1) + "ITEM NAME: " + il.itemList.get(i).itemName + "\n ITEM PRICE" + il.itemList.get(i).itemPrice );
		
}

public float generateBill(ItemList il)
{  
	for(Item items:il.itemList)
		bill+=items.itemPrice*items.quantity;
	
	return bill;
}
}

