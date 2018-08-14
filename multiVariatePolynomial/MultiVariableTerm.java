package multiVariatePolynomial;

import java.util.List;

public class MultiVariableTerm {
	List<Variable> variables ;
	int coefficient;
	
	public MultiVariableTerm(List<Variable> variables, int coefficient) {
		this.variables = variables;
		this.coefficient = coefficient;
	}
	
	public List<Variable> getVariables() {
		return variables;
	}
	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public String toString() {
		StringBuffer term = new StringBuffer();
		for(Variable variable : variables) {
			term.append(variable);
		}
		return term.toString();
	}

}
