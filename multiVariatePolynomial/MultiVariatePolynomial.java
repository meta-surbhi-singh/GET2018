package multiVariatePolynomial;

import java.util.ArrayList;
import java.util.List;

public class MultiVariatePolynomial {
	final int noOfVariables;
	List<MultiVariableTerm> PolynomialTerms = new ArrayList<MultiVariableTerm>();

	public MultiVariatePolynomial(int noOfVariables) {
		this.noOfVariables = noOfVariables;
	}

	/**
	 * add a multivariable term to the polynomial
	 * 
	 * @param coefficient
	 * @param listOfVariable
	 */
	public void addMultiVariateTerm(List<Variable> listOfVariables, int coefficient) {
		MultiVariableTerm term = new MultiVariableTerm(listOfVariables, coefficient);
		PolynomialTerms.add(term);
	}

	public String getPolynomial() {
		StringBuffer polynomial = new StringBuffer();
		for(MultiVariableTerm term : PolynomialTerms) {
			polynomial.append(term);
			polynomial.append("+");
		}
		return polynomial.toString();
	}

	public void setPolynomial(List<MultiVariableTerm> polynomial) {
		this.PolynomialTerms = polynomial;
	}

	public int getNoOfVariables() {
		return noOfVariables;
	}

}
