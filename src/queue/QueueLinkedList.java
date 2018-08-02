package queue;
 
import java.util.*;
import Node.Node;

 
public class QueueLinkedList<T> implements Queue<T>
{
    private Node<T> front, rear;
    public int size;
 
    /* Constructor */
    public QueueLinkedList()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element to the queue */
    public boolean enQueue(T data)
    {
        Node<T> newNode = new Node<T>(data);
        if (rear == null)
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.setLink(newNode);
            rear = rear.getLink();
        }
        size++ ;
        return true;
    }    
    /*  Function to remove front element from the queue */
    public T deQueue()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node<T> deQueuedNode = front;
        front = deQueuedNode.getLink();        
        if (front == null)
            rear = null;
        size-- ;        
        return deQueuedNode.getData();
    }    
    /*  Function to check the front element of the queue */
    public T peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }    
    /*  Function to display the status of the queue */
    public void display(){
        if (isEmpty()) {
            return ;
        }
        Node<T> ptr = front;
        while (ptr != rear.getLink() )
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
	
}
