package sparseMatrixOp;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixOpTest {

	SparseMatrixOp matrix;
	
	//test the transpose of Matrix logic
	@Test
	public void transposeTest() {
		int[][] origMatrix = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
		matrix = new SparseMatrixOp(origMatrix);
		int [][] transpose ={{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] actual = matrix.transposeOfMatrix();
		for(int row=0;row<origMatrix.length;row++){
			assertArrayEquals(transpose[row],actual[row]);
		}
	}
	
	//test the isSymmetric method logic 
	@Test
	public void isSymmetricTest() {
		int[][] origMatrix = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		matrix = new SparseMatrixOp(origMatrix);
		assertTrue(matrix.isSymmetric());
	}
	
	//check the negative test case of symmetric matrix
	@Test
	public void isSymmetricNegativeTest() {
		int[][] origMatrix = {{1,0,3,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		matrix = new SparseMatrixOp(origMatrix);
		assertFalse(matrix.isSymmetric());
	}
	
	//test the addition logic of two matrix
	@Test
	public void additionPositiveTest() {
		int[][] origMatrix = {{1,0,3,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		matrix = new SparseMatrixOp(origMatrix);
		int[][] matrixTwo = {{1,2,3,4},{4,2,1,4},{0,1,0,0},{0,0,1,1}};
		int[][] expected = {{2,2,6,4},{4,3,1,4},{0,1,1,0},{0,0,1,2}};
		int[][] actual= matrix.addTwoMatrix(matrixTwo);
		for(int row=0;row<origMatrix.length;row++){
			assertArrayEquals(expected[row],actual[row]);
		}
	}

	//test output when false input is given to add matrix
	@Test
	public void additionNegativeTest() {
		int[][] origMatrix = {{1,0,3,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		matrix = new SparseMatrixOp(origMatrix);
		int[][] matrixTwo = {{1,2,3,},{4,2,1,},{0,1,0,},{0,0,1,}};
		int[][] actual= matrix.addTwoMatrix(matrixTwo);
		assertNull(actual);
	}
	
	//test the multiplication logic
	@Test
	public void multiplicationPositiveTest() {
		int[][] origMatrix = {{1,0,3,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		matrix = new SparseMatrixOp(origMatrix);
		int[][] matrixTwo = {{1,2,3,4},{4,2,1,4},{0,1,0,0},{0,0,1,1}};
		int[][] expected = {{1,5,3,4},{4,2,1,4},{0,1,0,0},{0,0,1,1}};
		int[][] actual= matrix.multiply(matrixTwo);
		for(int row=0;row<origMatrix.length;row++){
			assertArrayEquals(expected[row],actual[row]);
		}
	}
	
	//test output when false input is given to multiply matrix
	@Test
	public void multiplicationNegativeTest() {
		int[][] origMatrix = {{1,0,3,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		matrix = new SparseMatrixOp(origMatrix);
		int[][] matrixTwo = {{1,2,3,4},{4,2,1,4},{0,1,0,0}};
		int[][] actual= matrix.multiply(matrixTwo);
		assertNull(actual);
	}

}