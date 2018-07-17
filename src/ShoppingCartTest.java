
import java.util.Scanner;

public class ShoppingCartTest {	
	 
	public static void main(String args[])
	{
	    int n;
		Scanner sc=new Scanner(System.in);
		ItemList il=new ItemList();
		il.createItems();
		il.addItems();
		
		ShoppingCart cart=new ShoppingCart();
		 
		while(true)
		{      System.out.println("/n/n/n/n/nPlease enter your choice..!!");
			   System.out.println("1.DISPLAY ITEMS IN STOCK");
			   System.out.println("2.ADD ITEMS TO THE CART");
			   System.out.println("3.REMOVE ITEMS FROM THE CART");
			   System.out.println("4.UPDATE QUANTITY");
			   System.out.println("5.DISPLAY MY SHOPPING CART");
			   System.out.println("6.GENERATE BILL");
		       System.out.println("7.EXIT");
		    
		    	n=sc.nextInt();
			
		    switch(n)
		   {
		    case 1:
			 il.displayAllItems();
		   	  break;
		    case 2:
			 { 
			   System.out.println("ENTER THE S.NO OF THE ITEM TO ADD ");
			   int s_no=sc.nextInt();
             cart.addInShoppinglist(il,s_no-1);
		     }
			  break;
		    case 3:
			   System.out.println("ENTER THE S.NO OF ITEM TO BE REMOVED: ");
			   int x=sc.nextInt();
			   cart.removeFromShoppinglist(x-1);
			 break;
		    case 4:
		    	System.out.println("ENTER THE S.NO OF ITEM WHOSE QUANTITY IS TO BE UPDATED ");
				int s_no=sc.nextInt();
				System.out.println("ENTER THE QUANTITY OF ITEM YOU WANT NOW.. ");
				int quantity=sc.nextInt();
		    	il.itemList.get(s_no+1).updateQuantity(quantity);
		    	break;
		    case 5:
		    	
			  cart.displayShoppingList(il);
			  break;
		    case 6:
			  System.out.println("HELLO..Your bill is "+ cart.generateBill(il));
			  break;
		    case 7:
		    {
		    	 System.exit(0);
		         break;
		     }
		    default:
		    	System.out.println("SORRY WRONG INPUT.. TRY AGAIN");
		}
		    sc.close();
		}  
		
	}	
}
