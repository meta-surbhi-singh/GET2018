package nQueen;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenProblemTest {

	@Test
	public void testNQueenProblem() {
		NQueenProblem nQueen = new NQueenProblem(4);

		int[][] expected = { {0,1,0,0},  { 0,  0,  0 , 1  },{ 1,  0,  0,  0  },{ 0,  0,  1,  0  }};
		int[][] actual = nQueen.getBoard();
		assertArrayEquals(expected, actual);
	}

}
