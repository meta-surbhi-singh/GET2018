package sparseMatrix;
import java.util.*;

public final class SparseMatrix {

	
	private int noOfRows;
	private int noOfColoumns;
	private Element[] elementList;
	private int noOfNonZeroValues;
	Scanner sc = new Scanner(System.in);

	/**
	 * initializes the sparse matrix
	 * 
	 * @param ElementList
	 */
	public SparseMatrix(int noOfRows, int noOfColoumns, Element[] elementList) {
		this.noOfRows = noOfRows;
		this.noOfColoumns = noOfColoumns;
		this.elementList = elementList;
		this.noOfNonZeroValues = elementList.length;
	}

	/**
	 * displays the sparse representation of the matrix
	 * 
	 */
	public void displaySparse() {
		for (int index = 0; index < noOfNonZeroValues; index++) {
			System.out.println(elementList[index]);
		}
	}

	/**
	 * get 2D-representation of the matrix
	 */
	private int[][] getMatrixArray() {
		int matrixArray[][] = new int[noOfRows][noOfColoumns];
		for (int i = 0 ,index = 0; i < matrixArray.length ; i++) {
			for (int j = 0; j < matrixArray.length && index < noOfNonZeroValues; j++) {
				if (i == elementList[index].getRow() && j == elementList[index].getColoumn()) {
				matrixArray[i][j] = elementList[index++].getValue();
					}
			else {
				matrixArray[i][j] = 0;
			}
			}
		}
		return matrixArray;
	}
	
	/**
	 * display the 2D-representation of the matrix
	 */
	public void display2DMatrix() {
		int[][] matrixArray = getMatrixArray();
		for (int i = 0; i < matrixArray.length; i++) {
			for (int j = 0; j < matrixArray.length; j++) {
				System.out.print(matrixArray[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * transposes a matrix
	 * 
	 * @return
	 */
	public SparseMatrix transpose() {
        Element[] transposeElementList = new Element[noOfNonZeroValues];
		for (int index = 0; index < noOfNonZeroValues; index++) {
			transposeElementList[index] = new Element (elementList[index].getColoumn(), elementList[index].getRow(),elementList[index].getValue());
 		}
		SparseMatrix transposeMatrix = new SparseMatrix(noOfColoumns, noOfRows, transposeElementList);
		return transposeMatrix;
	}
	
	public SparseMatrix addMatrices(SparseMatrix matrix1) {
		if (noOfRows != matrix1.noOfRows && noOfColoumns != matrix1.noOfColoumns) {
			return null;
		}
		int noOfValues = 0;
		int sumValue;
		int index1, index2, tempIndex;
		Element[] tempElementList = new Element [this.noOfNonZeroValues + matrix1.noOfNonZeroValues];
		SparseMatrix sumMatrix;
		for (index1 = 0, index2 = 0, tempIndex = 0; index1 < noOfNonZeroValues && index2 < matrix1.noOfNonZeroValues && tempIndex < tempElementList.length; tempIndex++) {
			if (this.elementList[index1].getRow() > matrix1.elementList[index2].getRow() || this.elementList[index1].getColoumn() > matrix1.elementList[index2].getColoumn()) {
				// if b's row and col is smaller; add smaller value into result
				tempElementList[tempIndex] = new Element(matrix1.elementList[index2].getRow(), matrix1.elementList[index2].getColoumn(), matrix1.elementList[index2].getValue());
				index2++;
				noOfValues++;
			} 
			else if (this.elementList[index1].getRow() < matrix1.elementList[index2].getRow() || this.elementList[index1].getColoumn() < matrix1.elementList[index2].getColoumn()) {
				// if a's row and col is smaller; add smaller value into result
				tempElementList[tempIndex] = new Element(this.elementList[index2].getRow(), this.elementList[index2].getColoumn(), this.elementList[index2].getValue());
				index1++;
				noOfValues++;
			} 
			else {
				// add the values as row and col is same;then ElementList.add
				sumValue = this.elementList[index1].getValue() + matrix1.elementList[index2].getValue();
				if (sumValue != 0) {
					tempElementList[tempIndex] = new Element(this.elementList[index1].getRow(), matrix1.elementList[index2].getColoumn(), sumValue);
				}
				index1++;
				index2++;
				noOfValues++;
			}
		}
		// add remaining elements
		while (index1 < noOfNonZeroValues) {
			tempElementList[index1] = new Element(this.elementList[index1].getRow(), this.elementList[index1].getColoumn(), this.elementList[index1++].getValue());
		}
		while (index2 < matrix1.noOfNonZeroValues) {
			tempElementList[index2] = new Element(matrix1.elementList[index2].getRow(), matrix1.elementList[index2].getColoumn(), matrix1.elementList[index2].getValue());
		}
		Element[] sumElementList = new Element [noOfValues];
		for(int index = 0; index < noOfValues; index++) {
			sumElementList[index] = tempElementList[index];
		}
		sumMatrix = new SparseMatrix(noOfRows, noOfColoumns, sumElementList);
		sumMatrix.displaySparse();
		return sumMatrix;
	}

	public SparseMatrix productMatrices(SparseMatrix matrix1) {
		if (this.noOfColoumns != matrix1.noOfRows) {
			// Invalid multiplication
			System.out.println("Can't multiply, Invalid dimensions");
			return null;
		}
		SparseMatrix productMatrix;
		Element[] tempElementList = new Element[this.noOfNonZeroValues + matrix1.noOfNonZeroValues];
		// transpose matrix1 to compare row and col values and to add them at the end
		matrix1 = matrix1.transpose();
		int index1, index2;
		int tempIndex = 0;
		int noOfValues = 0;
		// iterate over all elements of A
		for (index1 = 0; index1 < noOfNonZeroValues;) {
			// current row of result matrix
			int row = this.elementList[index1].getRow();
			// iterate over all elements of matrix1
			for (index2 = 0; index2 < matrix1.noOfNonZeroValues;) {
				// current column of result matrix; getRow() is used as matrix1 is transposed
				int coloumn = matrix1.elementList[index2].getRow();
				int sum = 0;
				for (int temp1 = index1, temp2 = index2; temp1 < noOfNonZeroValues && this.elementList[temp1].getRow() == row && temp2 < matrix1.noOfNonZeroValues && matrix1.elementList[temp2].getRow() == coloumn && tempIndex < tempElementList.length ; tempIndex++) {
					if (this.elementList[temp1].getColoumn() < matrix1.elementList[temp2].getColoumn()) {
						temp1++;
					}
					else if (this.elementList[temp1].getColoumn() > matrix1.elementList[temp2].getColoumn()) {
						temp2++; 
					}
					else
						sum += this.elementList[temp1++].getValue() * matrix1.elementList[temp2++].getValue(); // same col, so multiply and increment
				}
				if (sum != 0) {
					tempElementList[tempIndex] = new Element(row, coloumn, sum);
				    noOfValues++;
				}
			while (index2 < matrix1.noOfNonZeroValues && matrix1.elementList[index2].getRow() == coloumn) {
				// jump to next column
				index2++;
				}
			}
			while (index1 < noOfNonZeroValues && this.elementList[index1].getRow() == row) {
				// jump to next row
				index1++;
			}
			}
		// result matrix of dimension row X matrix1.col
		// however matrix1 has matrix1 been transposed, hence row X matrix1.row
		Element[] productElementList = new Element [noOfValues];
		for(int index = 0; index < noOfValues; index++) {
			productElementList[index] = tempElementList[index];
		}
		productMatrix = new SparseMatrix(noOfRows, matrix1.noOfRows, productElementList);
		productMatrix.displaySparse();
		return productMatrix;
	}

}
