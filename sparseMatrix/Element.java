package sparseMatrix;
public class Element {
	private int row;
	private int coloumn;
	private int nonZeroValue;
	
	public Element(int row, int coloumn, int nonZeroValue) {
		this.row = row;
		this.coloumn = coloumn;
		this.nonZeroValue = nonZeroValue;
	}
	
	public String toString() {
		return "( " + row + "," + coloumn + " ) Value : " + nonZeroValue;
	}
	
	public int getValue() {
		return nonZeroValue;
	}

	public int getRow() {
		return row;
	}

	public int getColoumn() {
		return coloumn;
	}

}
