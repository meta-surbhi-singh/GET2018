

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
	
	public void userInput() throws InputMismatchException{
		while(true)
    { 
   	     System.out.println("\n\n\n*****Please enter your choice..!!*****");
		 System.out.println("1.DISPLAY ITEMS IN STOCK");
		 System.out.println("2.ADD ITEMS TO THE CART");
		 System.out.println("3.REMOVE ITEMS FROM THE CART");
		 System.out.println("4.UPDATE QUANTITY");
		 System.out.println("5.DISPLAY MY SHOPPING CART");
		 System.out.println("6.GENERATE BILL");
	     System.out.println("7.EXIT");
	     n=sc.nextInt();
	     
	    switch(n){
	    case 1:
	     {
		 il.displayAllItems();
	   	  break;
	     }
	    case 2:
		 { 
		   System.out.println("ENTER THE S.NO OF THE ITEM TO ADD ");
		   int s_no=sc.nextInt();
		   System.out.println("ENTER QUANTITY ");
		   int quantity=sc.nextInt();
           cart.addInShoppinglist(il,s_no,quantity);
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
			cart.updateQuantity(s_no+1,quantity);
	    	break;
	     }
	    case 5:
	     {	
		    cart.displayShoppingList(il);
		    break;
	     }
	    case 6:
	    {  
	        System.out.println("\n"); 
		    System.out.println("HELLO..Your bill is "+ cart.generateBill(il));
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
	   } // end of switch block
    
	    
	}
   }
	public static void main(String args[]) {
		ShoppingCartTest cartTest=new ShoppingCartTest();		
		try {
		cartTest.userInput();
		}
		catch(InputMismatchException ime)
		{   System.out.println("please enter a valid response");
			sc.next();
			
		}
  }//end of main block
	
}//end of class block

