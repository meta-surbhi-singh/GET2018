package stack;

import java.lang.reflect.Array;

public class StackArray<T> implements Stack<T>{
	private final int capacity;
	private T stack[] ;
	int top;

	@SuppressWarnings("unchecked")
	public StackArray(Class<T> type, int capacity){
		this.capacity=capacity;
		stack = (T[]) Array.newInstance(type, capacity);
		top = -1;
	}
	
	/**
	 * pushes element into the stack
	 * @param element is the element to be pushed
	 * @return true if push operation is successful, else return false if not successful 
	 */
	public boolean push(T element) {
		if (top < capacity - 1) {
			top++;
			stack[top] = element;
			return  true;
		} 
			return false;
	}
	
    /**
     * pops element from the stack
     * @return element at top
     */
	public T pop() {
		if (!isEmpty()) {
			return stack[top--];
		}
			return null;
	}

	/**
	 * @return all the elements in the stack currently
	 */
	public T[] getElements() {
		if (!isEmpty()) {
			return stack;
		}
		else {
			return null;
		}
	}

	/**
	 * checks is stack is empty
	 * @return true if stack is empty, else return false
	 */
	public boolean isEmpty() {
			return top == -1;
	}
	
	/**
	 * @return the element at top on the stack
	 */
	public T getTop() {
		if(!isEmpty()) {
			return stack[top];
		}
			return null;
    }

}