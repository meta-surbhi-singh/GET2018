package queue;

public interface Queue<T> {

	public boolean isEmpty();
	public int getSize();
	public boolean enQueue(T data);
	public T deQueue();
	public T peek();	
}
