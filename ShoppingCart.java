
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
	public float bill;
	public List<Item> shoppingList;

	public ShoppingCart() {
		shoppingList = new ArrayList<Item>();
		bill = 0.0f;

	}

	public void addInShoppinglist(ItemList il, int index, int quantity) {
		if (index < il.itemList.size()) {
			shoppingList.add(il.itemList.get(index));
			shoppingList.get(index).quantity = quantity;
		} else {
			System.out.println("Sorry.. Item index out of bounds..");
		}
	}

	public void removeFromShoppinglist(int index) {
		if (!shoppingList.isEmpty()) {
			if (index <= shoppingList.size()) {
				shoppingList.remove(index);
				System.out.println("This item has been removed from our shopping list..");
			} else
				System.out.println("Product not in the shopping list");
		} else {
			System.out.println("Your ShoppingList is empty..");
		}
	}

	public void displayShoppingList(ItemList il) {
		if (!shoppingList.isEmpty()) {
			for (int i = 0; i < shoppingList.size(); i++) {
				System.out.println("S.NO." + shoppingList.get(i).s_no + " ITEM NAME: " + shoppingList.get(i).itemName
						+ "\n ITEM PRICE: " + shoppingList.get(i).itemPrice + "\n QUANTITY: "
						+ shoppingList.get(i).quantity);
			}
		} else {
			System.out.println("Your ShoppingList is empty..");
		}
	}

	public float generateBill(ItemList il) {
		if (!shoppingList.isEmpty()) {
			for (int i = 0; i < shoppingList.size(); i++) {
				bill += shoppingList.get(i).itemPrice * shoppingList.get(i).quantity;
			}
			System.out.println("bill without discount" + bill);
		} else {
			bill = 0;
		}
		return bill;
	}

   public void updateQuantity(int index,int quantity){
	if(!shoppingList.isEmpty()){
		if(index<=shoppingList.size()) {
			 shoppingList.get(index).quantity=quantity;
			 System.out.println("Quantity updated...");
	    }
	    else {
	    System.out.println("Product not in the shopping list");
	    }
	}
	 else{
		 System.out.println("Your ShoppingList is empty..");
	 }
   }
	
}