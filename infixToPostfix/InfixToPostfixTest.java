package infixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {
	InfixToPostfix infixToPostfixInstance = new InfixToPostfix();

	// test cases for convertInfixToPostfix()
	@Test
	public void testShouldReturnPostfixForValidInfixExpression() {
		String infixExpression = "( A + B ) * C - ( D - E ) * ( F + G )";
		String actualOutput = infixToPostfixInstance.convertInfixToPostfix(infixExpression);
		String expectedOutput = " A B + C * D E - F G + * -";
		assertEquals(expectedOutput, actualOutput);
	}

	@Test(expected = AssertionError.class)
	public void testShouldThrowExceptionForMissingBrackets() {
		String infixExpression = "( A + B ) * C - ( D - E * ( F + G )";
		infixToPostfixInstance.convertInfixToPostfix(infixExpression);
	}

	@Test(expected = AssertionError.class)
	public void testShouldThrowExceptionForInvalidSymbols() {
		String infixExpression = "( A + B ) * C - ( D - E ) } * ( F + G )";
		infixToPostfixInstance.convertInfixToPostfix(infixExpression);
	}

}
