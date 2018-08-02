package testClass;

import static org.junit.Assert.*;

import org.junit.Test;
import stack.*;

public class StackTest {
	StackArray<Integer> stackArray = new StackArray<Integer>(Integer.class, 4);
	StackLinkedList<Character> stackLinkedList = new StackLinkedList<Character>();

	@Test
	public void testPushArray() {
		boolean actual = stackArray.push(5);
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	public void testPopArray() {
		stackArray.push(5);
		int actual = stackArray.pop();
		int expected = 5;
		assertEquals(actual, expected);
	}

	@Test
	public void testIsEmptyArray() {
		boolean actual = stackArray.isEmpty();
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	public void testGetTop() {
		stackArray.push(5);
		int actual = stackArray.getTop();
		int expected = 5; 
		assertEquals(actual, expected);
	}

	@Test
	public void testPopLinkedList() {
		boolean actual = stackLinkedList.push('s');
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIsEmptyLinkedList() {
		boolean actual = stackLinkedList.isEmpty();
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	public void testGetTopLinkedList() {
		stackArray.push(5);
		int actual = stackArray.getTop();
		int expected = 5; 
	    assertEquals(actual,expected);
	}
	
}