package testClass;

import static org.junit.Assert.*;
import org.junit.Test;
import queue.*;

public class QueueTest {
    QueueArray<Integer> queueArray = new QueueArray<Integer>(Integer.class, 4);
    QueueLinkedList<Character> queueLinkedList = new QueueLinkedList<Character>();
    
	@Test
	public void testEnQueueArray() {
		boolean actual = queueArray.enQueue(4);
		boolean expected = true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testDeQueueArray() {
		queueArray.enQueue(4);
		int actual = queueArray.deQueue();;
		int expected = 4;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testIsEmptyArray() {
		boolean actual = queueArray.isEmpty();
		boolean expected = true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPeek() {
		queueArray.enQueue(4);
		int actual = queueArray.peek();
		int expected = 4;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testEnQueueLinkedList() {
		boolean actual = queueLinkedList.enQueue('c');
		boolean expected = true;
		assertEquals(actual,expected);
	}
	
	
	@Test
	public void testDeQueueLinkedList() {
		queueLinkedList.enQueue('c');
		char actual = queueLinkedList.deQueue();;
		char expected = 'c';
		assertEquals(actual,expected);
	}
	
	@Test
	public void testIsEmptyLinkedList() {
		boolean actual = queueLinkedList.isEmpty();
		boolean expected = true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPeekLinkedList() {
		queueLinkedList.enQueue('n');
		char actual = queueLinkedList.peek();
		char expected = 'n';
		assertEquals(actual,expected);
	}
}

