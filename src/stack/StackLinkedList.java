package stack;

import java.util.Scanner;

import Node.Node;

public class StackLinkedList<T> implements Stack<T> {
	static Scanner sc = new Scanner(System.in);
	public Node<T> top;

	public StackLinkedList() {
		top = null;
	}

	/**
	 * pushes element into the stack
	 * 
	 * @param pushedElement is the element to be pushed
	 * @return true if push operation is successful, else return false if not
	 *         successful
	 */
	public boolean push(T element) {
		Node<T> node = new Node<T>(element);
		node.setLink(top);
		top = node;
		return true;
	}

	/**
	 * pops element from the stack
	 * 
	 * @return element at top
	 */
	public T pop() throws StackIsEmptyException {
		if (isEmpty()) {
			throw new StackIsEmptyException();
		}
			Node<T> popped = top;
			top = top.getLink();
			return popped.getData();
	}

	/**
	 * checks is stack is empty
	 * 
	 * @return true if stack is empty, else return false
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * pops element from the stack
	 * 
	 * @return element at top
	 */
	public T getTop() {
		if (isEmpty()) {
			throw new StackIsEmptyException();
		}
		return top.getData();
	}

	/**
	 * display all the elements in the stack currently
	 */
	public void displayAll() throws StackIsEmptyException {
		Node<T> ptr = top;
		if (isEmpty()) {
			throw new StackIsEmptyException();
		}
		for (; ptr.getLink() != null; ptr = ptr.getLink()) {
			System.out.println(ptr.getData());
		}
		System.out.println(ptr.getData());
	}
}
