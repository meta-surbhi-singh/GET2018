package infixToPostfix;

import stack.*;

public class InfixToPostfix {
	String postfixExpression = "";
	Stack<String> stack = new StackLinkedList<String>();

	/**
	 * Converts infix expression into postfix expression.
	 * 
	 * @param infixExpression
	 * @return returns postfix expression.
	 */
	public String convertInfixToPostfix(String infixExpression) {
		// intialize Expression for conversion
		infixExpression = "( " + infixExpression + " )";
		boolean isContainOnlyAlphaNumeric = isContainOnlyAlphaNumeric(infixExpression);
		if (isContainOnlyAlphaNumeric) {
			throw new AssertionError("Infix expression must have operators");
		}
		String[] tokenArray = infixExpression.split(" ");
		for (String token : tokenArray) {
			if ("(".equals(token)) {
				stack.push(token);
			} else if (")".equals(token)) {
				solveBrackets();
			} else if (isContainOnlyAlphaNumeric(token)) {
				// adds an operand to the postfix operation
				postfixExpression = postfixExpression + " " + token;
			}
			// operates on operator
			else {
				// check for the prcedence of operator at top of stack to token
				boolean isHigherOrSamePrecedence = checkPrecedence(token);
				// if token has lower precedence than operator at top of stack then operator of
				// higher precedence is popped from stack and added to the postfix expression.
				while (isHigherOrSamePrecedence) {
					postfixExpression = postfixExpression + " " + stack.pop();
					isHigherOrSamePrecedence = checkPrecedence(token);
				}
				stack.push(token);
			}

		}
		boolean isStackEmpty = stack.isEmpty();
		if (!isStackEmpty) {
			throw new AssertionError("invalid Postfix Expression");
		}
		return postfixExpression;
	}

	/**
	 * Private helper method to solve brackets when ")" is encountered.
	 */
	private void solveBrackets() {
		String tokenAtTopOfStack = stack.getTop();
		// Pop elements from stack until "(" is encounterd.
		while (!("(".equals(tokenAtTopOfStack))) {
			boolean isStackEmpty = stack.isEmpty();
			if (isStackEmpty) {
				throw new AssertionError("Invalid Infix Expression");
			}
			postfixExpression = postfixExpression + " " + stack.pop();
			tokenAtTopOfStack = stack.getTop();
		}
		stack.pop();
	}

	/**
	 * private helper method to check precedence
	 * 
	 * @param token
	 * @return returns true if operator at top of stack has higher precedence than
	 *         token otherwise false
	 */
	private boolean checkPrecedence(String token) {
		int precedenceOfToken = getPrecedence(token);
		boolean isStackEmpty = stack.isEmpty();
		if (isStackEmpty) {
			throw new AssertionError("Invalid Infix Expression");
		}
		String tokenAtTopOfStack = stack.getTop();
		int precedenceOfTokenAtTopOfStack = getPrecedence(tokenAtTopOfStack);
		if (precedenceOfToken == -1 || precedenceOfTokenAtTopOfStack == -1) {
			throw new AssertionError("Either operator is invalid or unary operator is used.");
		}
		if (precedenceOfTokenAtTopOfStack >= precedenceOfToken) {
			return true;
		}
		return false;
	}

	/**
	 * return precedence of operator according to precedence order
	 * 
	 * @param token
	 * @return
	 */
	private int getPrecedence(String token) {
		int precedence = -1;
		if ("(".equals(token)) {
			precedence = 0;
			return precedence;
		}
		if ("||".equals(token)) {
			precedence = 1;
			return precedence;
		}
		if ("&&".equals(token)) {
			precedence = 2;
			return precedence;
		}
		if ("==".equals(token) || "!=".equals(token)) {
			precedence = 3;
			return precedence;
		}
		if ("<".equals(token) || "<=".equals(token) || ">".equals(token) || ">=".equals(token)) {
			precedence = 4;
			return precedence;
		}
		if ("+".equals(token) || "-".equals(token)) {
			precedence = 5;
			return precedence;
		}
		if ("*".equals(token) || "/".equals(token) || "%".equals(token)) {
			precedence = 6;
			return precedence;
		}
		return precedence;
	}

	/**
	 * Check whether token contain only alpha numeric character
	 * 
	 * @param token
	 * @return returns true if token contain only alpha numeric character otherwise
	 *         false
	 */
	private boolean isContainOnlyAlphaNumeric(String token) {
		boolean isContain = true;
		for (int i = 0; i < token.length(); i++) {
			char currentCharacter = token.charAt(i);
			boolean isDigit = Character.isDigit(currentCharacter);
			boolean isLetter = Character.isLetter(currentCharacter);
			if ((!isDigit) && (!isLetter)) {
				isContain = false;
				return isContain;
			}
		}
		return isContain;
	}

}
