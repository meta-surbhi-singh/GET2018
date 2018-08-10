package testClasses;
import uniqueCharacter.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest {

	@Test
	public void testcountUniqueCharacter() {
		UniqueCharacter uc = new UniqueCharacter();
		int actual = uc.countUniqueCharacter("happy birthday to you");
		int expected = 12;
		assertEquals(expected, actual);
	}

}
