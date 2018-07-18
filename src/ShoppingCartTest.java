

import java.util.InputMismatchException;
import java.util.Scanner;



public class ShoppingCartTest {	
	public int n;
	public static Scanner sc;
	public ShoppingCart cart;
	public ItemList il;
	public ShoppingCartTest() {
		sc=new Scanner(System.in);
		il=new ItemList();
		il.createItems();
		il.addItems();
		cart=new ShoppingCart();
	}
	
	public void userInput() throws InputMismatchException
	{
		while(true)
    { 
   	     System.out.println("Please enter your choice..!!");
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
	     {
		 il.displayAllItems();
	   	  break;
	     }
	    case 2:
		 { 
		   System.out.println("ENTER THE S.NO OF THE ITEM TO ADD ");
		   int s_no=sc.nextInt();
         cart.addInShoppinglist(il,s_no-1);
	       break;
		 }
	    case 3:
	     {  System.out.println("ENTER THE S.NO OF ITEM TO BE REMOVED: ");
		    int x=sc.nextInt();
		    cart.removeFromShoppinglist(x-1);
		    break;
	     }
	    case 4:
	     { 	System.out.println("ENTER THE S.NO OF ITEM WHOSE QUANTITY IS TO BE UPDATED ");
			int s_no=sc.nextInt();
			System.out.println("ENTER THE QUANTITY OF ITEM YOU WANT NOW.. ");
			int quantity=sc.nextInt();
	    	il.itemList.get(s_no+1).updateQuantity(quantity);
	    	break;
	     }
	    case 5:
	     {	
		    cart.displayShoppingList(il);
		    break;
	     }
	    case 6:
	    {   System.out.println("ENTER ANY ONE PROMO CODE..- \n" );
	        for(int i=0;i<5;i++)
	      {
	    	 System.out.println(PromotionEnum.values()[i]);
	      }
	        System.out.println("\n");
	        String code=sc.next();
	        System.out.println("You entered code" + code);
		    System.out.println("HELLO..Your bill is "+ cart.generateBill(il,code));
		    break;
	    }
	    case 7:
	    {   sc.close();
	    	System.exit(0);
	        break;
	    }
	    default:
	    {	
	    	System.out.println("SORRY WRONG INPUT.. TRY AGAIN"); 
	    }
	  System.out.println("\n\n\n");
	   } //switch block
    
	    
	}
   }
	public static void main(String args[]) 
	{
		ShoppingCartTest cartTest=new ShoppingCartTest();		
		try {
		cartTest.userInput();
		}
		catch(InputMismatchException ime)
		{   System.out.println("please enter a valid response");
			sc.next();
			
		}
  }//main block
}//class block

