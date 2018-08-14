package circularQueue;

import java.lang.reflect.Array;

/**
 * This class implements circular implementation of IQueue interface using
 * array.
 *
 * @param <T> is generic type.
 */
public class CircularQueue<T> implements IQueue<T> {
	private int front;
	private int rear;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public CircularQueue(Class<T> type, int capacity) {
		front = -1;
		rear = -1;
		queue = (T[]) Array.newInstance(type, capacity);
	}

	@Override
	public boolean enqueue(T element) {
		boolean isEnqueue = false;
		boolean isFull = isFull();
		if (isFull) {
			return isEnqueue;
		}
		if (rear == -1) {
			front = 0;
		}
		if (rear == queue.length - 1) {
			rear = -1;
		}
		rear++;
		queue[rear] = element;
		isEnqueue = true;
		return isEnqueue;
	}

	@Override
	public T dequeue() {
		boolean isEmpty = isEmpty();
		if (isEmpty) {
			throw new AssertionError("Queue is empty");
		}
		T element = queue[front];
		if (front == rear) {
			front = rear = -1;
		} else {
			front++;
			if (front == queue.length) {
				front = 0;
			}
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether queue is full or not.
	 * 
	 * @return returns true if queue is full otherwise false.
	 */
	public boolean isFull() {
		if ((rear == (queue.length - 1) && front == 0) || (rear + 1) == front) {
			return true;
		}
		return false;
	}

}
