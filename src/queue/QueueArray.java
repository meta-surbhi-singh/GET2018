package queue;

import java.lang.reflect.Array;
import java.util.*;

public class QueueArray<T> implements Queue<T> {
	private T queue[];
	private int front, rear, noOfElements;
	private int arraySize;

	/* Constructor */
	@SuppressWarnings("unchecked")
	public QueueArray(Class<T> type, int arraySize) {
		this.arraySize = arraySize;
		noOfElements = 0;
		queue = (T[]) Array.newInstance(type, arraySize);
		front = -1;
		rear = -1;
	}

	/**
	 * Function to check if queue is empty
	 * 
	 * @return true if queue is empty, else false
	 */
	public boolean isEmpty() {
		return front == -1;
	}

	/* Function to check if queue is full */
	public boolean isFull() {
		return front == 0 && rear == arraySize - 1;
	}

	/* Function to get the size of the queue */
	public int getSize() {
		return noOfElements;
	}

	/* Function to check the front element of the queue */
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow Exception");
		}
		return queue[front];
	}

	/**
	 * Function to insert an element to the queue
	 * 
	 * @param element which has to be added in queue
	 * @return true if value is added
	 */
	public boolean enQueue(T element) {
		boolean isAdded = false;
		if (rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = element;
			isAdded = true;
		} 
		else if (rear >= arraySize - 1) {
			throw new IndexOutOfBoundsException(); //queue array overflow
		}
		else if (rear < arraySize - 1) {
			queue[++rear] = element;
			isAdded = true;
		}
		noOfElements++;
		return isAdded;
	}

	/**
	 * Function to remove front element from the queue
	 * 
	 * @return element that is removed from the queue
	 */
	public T deQueue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow Exception");
		}
		noOfElements--;
		T element = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} 
		else {
			front++;
		}
		return element;
	}

}
