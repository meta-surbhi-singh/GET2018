package circularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {
	CircularQueue<Integer> circularQueue;

	// test cases for enqueue()
	@Test
	public void testEnqueue() {
		circularQueue = new CircularQueue<Integer>(Integer.class, 10);
		boolean isEnqueue = circularQueue.enqueue(5);
		assertEquals(true, isEnqueue);
	}

	@Test
	public void testEnqueue2() {// Should Return True When Queue Not Full And Rear At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 4);
		circularQueue.enqueue(56);
		circularQueue.enqueue(7);
		circularQueue.enqueue(7);
		circularQueue.enqueue(7);
		circularQueue.dequeue();
		boolean isEnqueue = circularQueue.enqueue(5);
		assertEquals(true, isEnqueue);
	}

	@Test
	public void negativeTestEnqueue() { // Should Return False When Queue Full And Rear At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 2);
		circularQueue.enqueue(5);
		circularQueue.enqueue(20);
		boolean isEnqueue = circularQueue.enqueue(34);
		assertEquals(false, isEnqueue);
	}

	@Test
	public void testDequeue() { // Should Return Object When Queue Not Empty And Rear At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 4);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		circularQueue.dequeue();
		circularQueue.enqueue(20);
		circularQueue.enqueue(20);
		Integer actualOutput = circularQueue.dequeue();
		Integer expectedOutput = 47;
		assertEquals(expectedOutput, actualOutput);
	}

	@Test(expected = AssertionError.class)
	public void testDequeueE() {// Should Throw Exception When Queue Is Empty
		circularQueue = new CircularQueue<Integer>(Integer.class, 10);
		circularQueue.dequeue();
	}

	// test cases for isEmpty()
	@Test
	public void negativeTestIsEmpty() { // Should Return False When Queue Not Empty And Rear Not At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 10);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		circularQueue.enqueue(20);
		boolean actualOutput = circularQueue.isEmpty();
		assertEquals(false, actualOutput);
	}

	@Test
	public void negativeTestIsEmpty2() { // Should Return False When Queue Not Empty And Rear At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 4);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		circularQueue.dequeue();
		circularQueue.enqueue(20);
		circularQueue.enqueue(47);
		boolean actualOutput = circularQueue.isEmpty();
		assertEquals(false, actualOutput);
	}

	@Test
	public void testIsEmpty() { // Should Return True When Queue Is Empty
		circularQueue = new CircularQueue<Integer>(Integer.class, 10);
		boolean actualOutput = circularQueue.isEmpty();
		assertEquals(true, actualOutput);
	}

	// test cases for isFull()
	@Test
	public void negativeTestIsFull() { // Should Return False When Queue Not Full And Rear Not At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 10);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		circularQueue.enqueue(20);
		boolean actualOutput = circularQueue.isFull();
		assertEquals(false, actualOutput);
	}

	@Test
	public void negativeTestIsFull2() {// Should Return False When Queue Not Full And Rear At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 4);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		circularQueue.dequeue();
		circularQueue.enqueue(20);
		circularQueue.enqueue(47);
		boolean actualOutput = circularQueue.isFull();
		assertEquals(false, actualOutput);
	}

	@Test
	public void testIsFull3() {// Should Return True When Queue Is Full And Rear At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 2);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		boolean actualOutput = circularQueue.isFull();
		assertEquals(true, actualOutput);
	}

	@Test
	public void testIsFull4() {// Should Return True When Queue Is Full And Rear Not At End
		circularQueue = new CircularQueue<Integer>(Integer.class, 4);
		circularQueue.enqueue(5);
		circularQueue.enqueue(47);
		circularQueue.dequeue();
		circularQueue.enqueue(4);
		circularQueue.enqueue(7);
		circularQueue.enqueue(48);
		boolean actualOutput = circularQueue.isFull();
		assertEquals(true, actualOutput);
	}

}
