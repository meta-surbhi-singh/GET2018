package sparseMatrix;
public class SparseMatrixRunner {

	public static void main(String args[]) {
		Element[] elementList = new Element[] {new Element(0,0,1), new Element (0,3,2), new Element(2, 2 ,5), new Element (3,1,10)};
		SparseMatrix sMatrix = new SparseMatrix(4, 4, elementList);
		System.out.println("The Sparse matrix");
		sMatrix.displaySparse();
		System.out.println("");
		sMatrix.display2DMatrix();
		System.out.println("");
		System.out.println("\nThe Transpose matrix");
		SparseMatrix stMatrix = sMatrix.transpose();
		stMatrix.displaySparse();
		System.out.println("");
		stMatrix.display2DMatrix();
		System.out.println("");
		System.out.println("The sum is..");
		SparseMatrix sum = sMatrix.addMatrices(stMatrix);
		sum.display2DMatrix();
		
		sMatrix.productMatrices(stMatrix);
	}
}