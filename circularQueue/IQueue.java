package circularQueue;
/**
 * This interface declares various functions of queue.
 *
 * @param <T> is generic type.
 */
public interface IQueue<T> {
    /**
     * adds an element into queue.
     * @param element
     * @return returns true if element is added otherwise false.
     */
    public boolean enqueue(T element);
    
    /**
     * remove an element from queue.
     * @return returns element that is removed from queue.
     */
    public T dequeue();
    
    /**
     * Checks whether queue is empty or not.
     * @return return true if queue is empty otherwise false.
     */
    public boolean isEmpty();

}
