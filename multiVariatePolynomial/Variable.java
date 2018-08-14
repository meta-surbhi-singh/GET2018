package multiVariatePolynomial;

public class Variable {
	char notation;
	int power;

	public Variable(char notation, int power) {
		this.notation = notation;
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public char getNotation() {
		return notation;
	}

	public void setNotation(char notation) {
		this.notation = notation;
	}
	
	public String toString() {
		return notation + "^" + power;
	}
}
