package sparseMatrix;
/*import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SparseMatrixTest {


    //test cases for getTranspose()
    @Test
    public void testgetTranspose() {
        int[][] element={{0,2,3},
                            {0,4,4},
                            {1,2,5},
                            {1,3,7},
                            {3,1,2},
                            {3,2,6}};
        SparseMatrix matrixInstance=new SparseMatrix(inputArray,4,5);
        SparseMatrix transposeInstance=matrixInstance.getTranspose();
        int[][] actualOutput=transposeInstance.getMatrixArray();
        int[][] expectedOutput={{2,0,3},
                                {4,0,4},
                                {2,1,5},
                                {3,1,7},
                                {1,3,2},
                                {2,3,6}};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    //test cases for isSymmetric()
    @Test
    public void testIsSymmetricWithSymmetricMatrix()
    {
        int[][] inputArray={{0,1,1},
                            {1,0,1},
                            {1,2,2},
                            {2,1,2},
                            {3,3,4}};
        SparseMatrix matrixInstance=new SparseMatrix(inputArray,4,4);
        boolean actualOutput=matrixInstance.isSymmetric();
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSymmetricWithNonSymmetricMatrix()
    {
        int[][] inputArray={{0,2,3},
                            {0,4,4},
                            {1,2,5},
                            {1,3,7},
                            {3,1,2},
                            {3,2,6}};
        SparseMatrix matrixInstance=new SparseMatrix(inputArray,5,5);
        boolean actualOutput=matrixInstance.isSymmetric();
        boolean expectedOutput=false;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testIsSymmetricWithUnequalRowAndColumn()
    {
        int[][] inputArray={{0,2,3},
                             {0,4,4},
                             {1,2,5},
                             {1,3,7},
                             {3,1,2},
                             {3,2,6}};
         SparseMatrix matrixInstance=new SparseMatrix(inputArray,4,5);
         matrixInstance.isSymmetric();
    }
    
    //test cases for add()
    @Test
    public void testAdd()
    {
        int[][] inputArray1={{0,2,3},
                             {0,4,4},
                             {1,2,5},
                             {1,3,7},
                             {3,1,2},
                             {3,2,6}};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,4,5);
        int[][] inputArray2={{0,1,2},
                             {1,3,6},
                             {2,2,4},
                             {2,4,8},
                             {3,0,1},
                             {3,2,9}};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,4,5);
        SparseMatrix resultMatrix=firstMatrix.add(secondMatrix);
        int[][] actualOutput=resultMatrix.getMatrixArray();
        int[][] expectedOutput={{0,1,2},
                                {0,2,3},
                                {0,4,4},
                                {1,2,5},
                                {1,3,13},
                                {2,2,4},
                                {2,4,8},
                                {3,0,1},
                                {3,1,2},
                                {3,2,15}};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testAddWithDifferentDimensionsOfMatrices()
    {
        int[][] inputArray1={{0,2,3},
                             {0,4,4},
                             {1,2,5},
                             {1,3,7},
                             {3,1,2},
                             {3,2,6}};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,4,5);
        int[][] inputArray2={{0,1,2},
                             {1,3,6},
                             {2,2,4},
                             {2,4,8},
                             {3,5,9}};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,4,6);
        firstMatrix.add(secondMatrix);
    }
    
    @Test(expected=AssertionError.class)
    public void testAddWithOneEmptyArray()
    {
        int[][] inputArray1={};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,0,0);
        int[][] inputArray2={{0,1,2},
                             {1,3,6},
                             {2,2,4},
                             {2,4,8},
                             {3,0,1},
                             {3,2,9}};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,4,5);
        firstMatrix.add(secondMatrix);
    }
    
    @Test
    public void testAddWithBothEmptyArray()
    {
        int[][] inputArray1={};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,0,0);
        int[][] inputArray2={};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,0,0);
        SparseMatrix resultMatrix=firstMatrix.add(secondMatrix);
        int[][] actualOutput=resultMatrix.getMatrixArray();
        int[][] expectedOutput= {};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    //test cases for multiply()
    @Test
    public void testMultiply()
    {
        int[][] inputArray1={{0,2,1},
                             {1,0,1},
                             {2,1,2},
                             {3,1,5}};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,4,3);
        int[][] inputArray2={{0,2,6},
                             {1,0,3},
                             {1,3,1},
                             {2,1,4}};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,3,4);
        SparseMatrix resultMatrix=firstMatrix.multiply(secondMatrix);
        int[][] actualOutput=resultMatrix.getMatrixArray();
        int[][] expectedOutput={{0,1,4},
                                {1,2,6},
                                {2,0,6},
                                {2,3,2},
                                {3,0,15},
                                {3,3,5}};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testMultiplyWithInvalidDimension()
    {
        int[][] inputArray1={{0,2,1},
                             {1,0,1},
                             {2,1,2},
                             {3,4,5}};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,4,4);
        int[][] inputArray2={{0,2,6},
                             {1,0,3},
                             {1,3,1},
                             {2,1,4}};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,3,4);
        firstMatrix.multiply(secondMatrix);
    }
    
    @Test(expected=AssertionError.class)
    public void testMultiplyWithOneEmptyArray()
    {
        int[][] inputArray1={{0,2,1},
                             {1,0,1},
                             {2,1,2},
                             {3,4,5}};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,4,4);
        int[][] inputArray2={};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,0,0);
        firstMatrix.multiply(secondMatrix);
    }
    
    @Test
    public void testMultiplyWithBothEmptyArray()
    {
        int[][] inputArray1={};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1,0,0);
        int[][] inputArray2={};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2,0,0);
        SparseMatrix resultMatrix=firstMatrix.multiply(secondMatrix);
        int[][] actualOutput=resultMatrix.getMatrixArray();
        int[][] expectedOutput={};
        assertArrayEquals(expectedOutput, actualOutput);
    }

}
*/
