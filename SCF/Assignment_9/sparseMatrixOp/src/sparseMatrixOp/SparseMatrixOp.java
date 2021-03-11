package sparseMatrixOp;

import java.util.Arrays;
/*
 * This class provide different method to perform operation on a matrix like transpose, addition 
 * ,multiplication etc.
 */
public final class SparseMatrixOp {
	
	int[][] sparseMatrix;
	
	//initializing the matrix
	public SparseMatrixOp(int[][] matrix){
		sparseMatrix = matrix;
	}
	
	//return the transpose of Matrix
	int[][] transposeOfMatrix(){
		int [][] result = new int[sparseMatrix.length][sparseMatrix.length];

        for (int row = 0; row < sparseMatrix.length; row++) 
            for (int col = 0; col < sparseMatrix.length; col++) 
                result[row][col] = sparseMatrix[col][row]; 
        
        return result;
	}
	
	
	//return true if matrix is symmetric or not
	boolean isSymmetric(){
		int[][] transpose = transposeOfMatrix();
		for(int row=0;row<transpose.length;row++){
			if(!Arrays.equals(sparseMatrix[row], transpose[row])){
				return false;
			}
		}
		return true;
	}
	
	
	//return addition of two matrix
	int[][] addTwoMatrix(int[][] matrix){
		if(matrix.length!=sparseMatrix.length || matrix[0].length!=sparseMatrix[0].length ) return null;
		int[][] result = new int[matrix.length][matrix.length];
		
		for(int row=0;row<matrix.length;row++){
			for(int col=0;col<matrix[0].length;col++){
				result[row][col] = matrix[row][col] + sparseMatrix[row][col];
			}
		}
		return result;
		
		
	}
	
	
	//return multiplication of two matrix
	int[][] multiply(int matrix[][]){
		if(sparseMatrix[0].length!=matrix.length) return null;
		int row, col, index;
		int[][] result = new int[sparseMatrix.length][matrix[0].length];
		for (row = 0; row < sparseMatrix.length; row++) {
			for (col = 0; col < matrix[0].length; col++) {
				result[row][col] = 0;
				for (index = 0; index < sparseMatrix.length; index++)
					result[row][col] += sparseMatrix[row][index]* matrix[index][col];
			}
		}
		return result;
	}
	
}
