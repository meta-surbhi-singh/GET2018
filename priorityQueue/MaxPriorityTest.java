package priorityQueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class MaxPriorityTest {
	MaxPriorityQueue priorityQueue = new MaxPriorityQueue(15);
	@Test
	public void testEnqueue() {
		boolean expected = true;
		boolean actual = priorityQueue.enQueue("job 1", 5);
		assertEquals(expected, actual);
	}
	
	@Test(expected=AssertionError.class)
	public void negativeTestDeQueue() {
		priorityQueue.deQueueHighestPriority();
	}
	
	@Test
	public void testDequeue() {
		priorityQueue.enQueue("job 1", 2);
		priorityQueue.enQueue("job 2", 6);
		priorityQueue.enQueue("job 3", 8);
		priorityQueue.enQueue("job 4", 10);
		priorityQueue.enQueue("job 5", 3);
		priorityQueue.enQueue("job 6", 2);
	    priorityQueue.enQueue("job 7", 12);
		priorityQueue.enQueue("job 8", 1);
		priorityQueue.enQueue("job 9", 9);
		priorityQueue.enQueue("job 10", 8);
		
		String expected = new Item("job 7", 12).toString();
		String actual = priorityQueue.deQueueHighestPriority();
		assertEquals(expected, actual);
		
		String expected1 = new Item("job 4", 10).toString();
		String actual1 = priorityQueue.deQueueHighestPriority();
		assertEquals(expected1, actual1);
	}

	@Test
	public void testgetHighestPriority() {
		priorityQueue.enQueue("job 1", 2);
		priorityQueue.enQueue("job 2", 6);
		priorityQueue.enQueue("job 3", 8);
		priorityQueue.enQueue("job 4", 10);
		priorityQueue.enQueue("job 5", 3);
		priorityQueue.enQueue("job 6", 2);
	    priorityQueue.enQueue("job 7", 12);
	    
	    String expected = new Item("job 7", 12).toString();
		String actual = priorityQueue.getHighestPriority();
		assertEquals(expected, actual);
	}
	@Test(expected=AssertionError.class)
	public void negativeTestgetHighestPriorityQueue() {
		priorityQueue.getHighestPriority();
	}

	
}
