import java.util.InputMismatchException;
import java.util.Scanner;

public class StackLinkedList
{   static Scanner sc=new Scanner(System.in);
	public Node top;
	public StackLinkedList() {
		top=null;
	}
	
	public void push(int element)
	{ Node node=new Node(element);
	  node.prev=top;
	  top=node;
	}
	
	public int pop() throws StackIsEmptyException
	{ if(isEmpty())
		throw new StackIsEmptyException();

	else
	 {  Node popped=top;
	    top=top.prev;
	   return popped.data;
	 }
	}
	
	public boolean isEmpty()
	{
		if(top==null)
			return true;
		else
		   return false;
	}
	public int top()
	{   if (isEmpty())
       {
        throw new StackIsEmptyException();
       }
	
		return top.data;
	
    }
   public void displayAll() throws StackIsEmptyException
   {       Node ptr=top;
	       if (isEmpty())
	       {
	           throw new StackIsEmptyException();
	          
	       }
	       else
	    	   
	    	   for(;ptr.prev!=null;ptr=ptr.prev)
	    	   {
	    		   System.out.println(ptr.data);
	    	   }
	       System.out.println(ptr.data); 
   }
	
	public static void main(String args[])
	{  StackLinkedList sll=new StackLinkedList();
	   try{
		   while(true)
		   {   System.out.println("Enter 1 to add elements into stack.");
		       System.out.println("Enter 2 to pop elements out of stack.");
		       System.out.println("Enter 3 to display all the elements of the stack.");
		       System.out.println("Enter 4 to display the element at top.");
		       System.out.println("Enter 0 to exit..");
		       int choice=sc.nextInt();
		       
		       
		       switch(choice)
		       { 
		       case 1:
		         {
			       System.out.println("Enter element to add into stack : ");
			       int element=sc.nextInt();
			       sll.push(element);
			       break;
		         }
		       case 2:
		         {
		           System.out.println("This element is popped : " +sll.pop());
		           break;
		         }
		       case 3:
		       {
		    	   System.out.println("Displaying elements of Stack.. : ");
		    	   sll.displayAll();
		    	   break;
		       }
		       case 4:
		       {
		    	   System.out.println("Element at top is : " + sll.top());
		    	   break;
		       }
		       case 0:
		       {
		    	   System.exit(0);
		    	   break;
		       }
		       default:
		    	   System.out.println("Please enter a valid choice");
		     }//end of switch
		   }//end of while
	  
	   }//end of try block
	   catch(StackIsEmptyException sie)
	   {
		   System.out.println("Stack is Empty");
	   }
	   catch(InputMismatchException ime)
	   {
		   System.out.println("Input is mismatched..please enter an integer value");
	   }
	   	
   }//end of main
}//end of class


class StackIsEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public StackIsEmptyException() {
		super();
		
	}
}