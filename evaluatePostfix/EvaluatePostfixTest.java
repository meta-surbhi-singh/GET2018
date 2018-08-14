package evaluatePostfix;
import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluatePostfixTest {
  
	@Test
	public void testEvaluatePostfix() {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		String actual = evaluate.evaluation("234+*");
		String expected = "14";
		assertEquals(expected,actual);
	}

}
