package evaluatePostfix;
import stack.*;
public class EvaluatePostfix {

	public String evaluation(String postfixExpression) {
		StackArray<String> myStack = new StackArray<String>(String.class,10) ;
		for (int i = 0; i < postfixExpression.length(); i++) {
			if(Character.isDigit(postfixExpression.charAt(i))) {
				myStack.push(Character.toString(postfixExpression.charAt(i)));
			}
			else if( postfixExpression.charAt(i) == '+' || postfixExpression.charAt(i) == '-' || postfixExpression.charAt(i) == '*' || postfixExpression.charAt(i) == '/') {
				int firstOperand = Integer.parseInt(myStack.pop());
				int SecondOperand = Integer.parseInt(myStack.pop());
				int result ;
				
				switch(postfixExpression.charAt(i)) {
				case '+':{
					result = firstOperand + SecondOperand;
					break;
				}
				case '-':{
					result = firstOperand - SecondOperand;			
					break;
				}
				case '*':{
					result = firstOperand * SecondOperand;		
					break;
				}
				case '/':{
					result = firstOperand / SecondOperand; 
					break;
				}
				default:{
					result=-1;
				}
			}
				myStack.push(Integer.toString(result));
			}
				else {
					continue;
				}
				}
		return myStack.getTop();
	}

	
	public static void main(String args[]) {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		System.out.println();
		System.out.println(evaluate.evaluation("2 3 4 + *"));
		
		
	}

}
