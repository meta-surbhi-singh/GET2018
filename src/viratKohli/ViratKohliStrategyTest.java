package viratKohli;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class ViratKohliStrategyTest {
	ViratKohliStrategy strategy;

	// test cases for getSequenceOfBowlers()
	// test case when virat's balls are equal to total balls of bowlers
	@Test
	public void testShouldReturnSequenceWhenBallsAreEqual() {
		Bowler[] bowlerArray = new Bowler[4];
		bowlerArray[0] = new Bowler("bowler1", 3);
		bowlerArray[1] = new Bowler("bowler2", 2);
		bowlerArray[2] = new Bowler("bowler3", 1);
		bowlerArray[3] = new Bowler("bowler4", 2);
		strategy = new ViratKohliStrategy(4, 8, bowlerArray);
		List<String> actualOutput = strategy.getSequenceOfBowlers();
		String[] expectedOutput = { "bowler1", "bowler2", "bowler4", "bowler1", "bowler3", "bowler2", "bowler4",
				"bowler1" };
		for (int i = 0; i < actualOutput.size(); i++) {
			assertEquals(expectedOutput[i], actualOutput.get(i));
		}
	}

	// test case when virat's balls are less than total balls of bowlers
	@Test
	public void testShouldReturnSequenceWhenViratBallsAreLess() {
		Bowler[] bowlerArray = new Bowler[4];
		bowlerArray[0] = new Bowler("bowler1", 3);
		bowlerArray[1] = new Bowler("bowler2", 2);
		bowlerArray[2] = new Bowler("bowler3", 4);
		bowlerArray[3] = new Bowler("bowler4", 2);
		strategy = new ViratKohliStrategy(4, 8, bowlerArray);
		List<String> actualOutput = strategy.getSequenceOfBowlers();
		String[] expectedOutput = { "bowler3", "bowler1", "bowler3", "bowler2", "bowler4", "bowler1", "bowler3",
				"bowler2" };
		for (int i = 0; i < actualOutput.size(); i++) {
			assertEquals(expectedOutput[i], actualOutput.get(i));
		}
	}
}
