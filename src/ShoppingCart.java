
import java.util.List;
import java.util.ArrayList;
public class ShoppingCart 
{
public float bill;
public List<Item> shoppingList;
public FixedProductPromotion fpp;
public FixedOrderPromotion fop;

public ShoppingCart()
{   shoppingList=new ArrayList<Item>();
    bill=0.0f;
    fpp=new FixedProductPromotion();
    fop=new FixedOrderPromotion();
}


public void addInShoppinglist(ItemList il,int index)
{
	
  if(index<il.itemList.size()) 
    shoppingList.add(il.itemList.get(index));
  else
	System.out.println("Sorry.. Item index out of bounds..");
	
}


public void removeFromShoppinglist(int index)
{   if(index<=shoppingList.size())
    { shoppingList.remove(index);
	System.out.println("This item has been removed from our shopping list..");
    }
    else
    System.out.println("Product not in the shopping list");
 		
}

public void displayShoppingList(ItemList il)
{
	for(int i=0;i<shoppingList.size();i++)
		 System.out.println("S.NO." + shoppingList.get(i).s_no + " ITEM NAME: " + shoppingList.get(i).itemName + "\n ITEM PRICE" + shoppingList.get(i).itemPrice );
		
}

public float generateBill(ItemList il, String code)
{
	for(int i=0;i<shoppingList.size();i++)
		{bill+=shoppingList.get(i).itemPrice*shoppingList.get(i).quantity;}
		System.out.println("bill without discount" + bill);
		
	    fop.setMinimumPrice(2000);
        fop.setFixedDiscount(200);
        fpp.setMinimumPrice(1500);
        fpp.setFixedDiscount(200);
	
 
 	     if(fop.isPromotionApplicable(code))
	          {if(bill>fop.getMinimumPrice())
	                  {
		                    bill=bill-fop.getFixedDiscount();
	                   }
	          }
 	    if(fpp.isPromotionApplicable(code))
        {if((shoppingList.contains(il.item2)||shoppingList.contains(il.item5))&&bill>fpp.getMinimumPrice())
                {
	                    bill=bill-fpp.getFixedDiscount();
                 }
        }
    
return bill;
}
}

