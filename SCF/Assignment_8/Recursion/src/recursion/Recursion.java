package recursion;


/*
 * This class provide various methods to solve recursive problem like NQueen,gcd etc.
 */
public class Recursion {

	
	// Recursive method to return gcd of a and b
    int gcd(int numberOne, int numberTwo)
    {
        if (numberOne == 0)
            return numberTwo; 
        return gcd(numberTwo % numberOne, numberOne); 
    }
	
    //recursive method to find LCM
	int findLcm(int numberOne,int numberTwo){
		
		return (numberOne / gcd(numberOne, numberTwo)) * numberTwo;
	}
	
	
	//linear search to find an element in array
	boolean linearSearch(int [] arr,int dataToSearch){
		
		for(int index=0;index<arr.length;index++){
			if(arr[index]==dataToSearch)
				return true;
		}
		return false;
	}
	
	
	//return true if the data found in array else return false , implemented binary search
	boolean binarySearch(int arr[] ,int dataToSearch, int lowerBound ,int upperBound ){
		int mid = (lowerBound + upperBound)/2;
		
		if(lowerBound>upperBound) return false;
		if(arr[mid]==dataToSearch) return true;
		else{
			if(dataToSearch > arr[mid]) return binarySearch(arr,dataToSearch,mid+1,upperBound);
			else return binarySearch(arr,dataToSearch,lowerBound,mid-1);
		}
	}

	//sort the array for binary search , insertion sort implemented
	void sort(int[] arr) {
		for(int index=1;index<arr.length;index++){
			
			int currentNumber = arr[index];
			int indexJ = index-1;
			for(indexJ=index-1;indexJ>=0;indexJ--){
				if(currentNumber<arr[indexJ]){
					arr[indexJ+1] = arr[indexJ];
				}
				else{
					break;
				}
			}
			arr[indexJ+1]=currentNumber;
		}
		
	}
	
	//return true if the current place is safe or not for the queen
	 private boolean isSafe(int board[][], int row, int col,int numberOfQueens) 
	    { 
	        int indexI, indexJ; 
	  
	        //Check this row on left side 
	        for (indexI = 0; indexI < col; indexI++) 
	            if (board[row][indexI] == 1) 
	                return false; 
	  
	        //Check upper diagonal on left side
	        for (indexI = row, indexJ = col; indexI >= 0 && indexJ >= 0; indexI--, indexJ--) 
	            if (board[indexI][indexJ] == 1) 
	                return false; 
	  
	        //Check lower diagonal on left side
	        for (indexI = row, indexJ = col; indexJ >= 0 && indexI < numberOfQueens; indexI++, indexJ--) 
	            if (board[indexI][indexJ] == 1) 
	                return false; 
	  
	        return true; 
	    } 
	
	//return true when all the queens placed successfully else return false
	private boolean solveNQueen(int [][] board,int numberOfQueens,int col){
		
		 if (col >= numberOfQueens) 
	            return true; 
	  
	        /* Consider this column and try placing 
	           this queen in all rows one by one */
	        for (int index = 0; index < numberOfQueens; index++) { 
	            
	        	//checking of the queen is safe at board[index][col]
	            if (isSafe(board, index, col,numberOfQueens)) { 
	                //Place this queen in board[index][col] 
	                board[index][col] = 1; 
	  
	                //recur to place rest of the queens
	                if (solveNQueen(board,numberOfQueens, col + 1) == true) 
	                    return true; 
	  
	                /* If placing queen in board[index][col] 
	                   doesn't lead to a solution then 
	                   remove queen from board[index][col] */
	                board[index][col] = 0; // BACKTRACK 
	            } 
	        } 
	  
	        // If the queen can not be placed in any row in this colum col, then return false
	        return false; 
	    } 
	
	
	//function which can be accessible through object and take number of queens as argument
	boolean nQueen(int numberOfQueens){
		int [][] board = new int[numberOfQueens][numberOfQueens];
		return solveNQueen(board,numberOfQueens,0);
	}
	  
	
	
}
