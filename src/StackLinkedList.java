
public class StackLinkedList
{
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
	{
		return top.data;
	
    }
   public void displayAll() throws StackIsEmptyException
   {
	       if (isEmpty())
	       {
	           throw new StackIsEmptyException();
	          
	       }
	       else
	    	   for(Node ptr=top;ptr.prev!=null;ptr=ptr.prev)
	    	   {
	    		   System.out.println(ptr.data);
	    	   }
   }
	
	public static void main(String args[])
	{  StackLinkedList sll=new StackLinkedList();
	   try{
	   sll.push(2); 
	   sll.push(5);
	   sll.push(6);
	   sll.push(10);
	   sll.displayAll();
	   sll.pop();
	   sll.pop();
	   sll.displayAll();
	}
	   catch(StackIsEmptyException sie)
	   {
		   System.out.println("Stack is Empty");
	   }
	   	
   }
}
class StackIsEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public StackIsEmptyException() {
		super();
		
	}
}