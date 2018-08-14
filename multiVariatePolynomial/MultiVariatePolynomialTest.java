package multiVariatePolynomial;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultiVariatePolynomialTest {
	MultiVariatePolynomial polynomial;

	@Test
	public void testGetMultiVariateTerm() {
		polynomial = new MultiVariatePolynomial(3);
		List<Variable> variableList = new ArrayList<>();
		variableList.add(new Variable('x',3));
		variableList.add(new Variable('y', 1));
		variableList.add(new Variable('z', 6));
        polynomial.addMultiVariateTerm(variableList, 9);
        variableList.add(new Variable('x', 1));
		variableList.add(new Variable('y', 0));
		variableList.add(new Variable('z', 5));
        polynomial.addMultiVariateTerm(variableList, 10);
        variableList.add(new Variable('x', 2));
		variableList.add(new Variable('y', 4));
		variableList.add(new Variable('z', 3));
        polynomial.addMultiVariateTerm(variableList, 2);
        String actual = polynomial.getPolynomial();
        String expected = "x^3y^1z^6x^1y^0z^5x^2y^4z^3+x^3y^1z^6x^1y^0z^5x^2y^4z^3+x^3y^1z^6x^1y^0z^5x^2y^4z^3+";
        assertEquals(expected,actual);

	}

}
