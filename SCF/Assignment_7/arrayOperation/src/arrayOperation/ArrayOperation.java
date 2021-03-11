package arrayOperation;

public class ArrayOperation {
	
	//Return the size of the largest mirror section found in the input array.
    int largestMirror(int[] arr){
	      int max=0;
	      if(arr.length == 0)
	    	  throw new ArrayIndexOutOfBoundsException("Array is empty");
	      for(int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
	              int count = 0;
	              for(int innerIndex = arr.length - 1; innerIndex >= 0 && outerIndex + count < arr.length; innerIndex--) {
	                      if(arr[outerIndex + count] == arr[innerIndex]) {
	                             count++;
	                      } 
	                      else {
	                             max = Math.max(max, count);
	                             count = 0;
	                      }
	                }                                                    
	        }
	        return max;
	}
	
    
  //Return an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
	void fixXY(int[] array,int x,int y){
		int countX=0,countY=0;
		for(int index=0;index<array.length;index++){
			if(array[index]==x){
				countX++;
			}
			if(array[index]==y){
				countY++;
			}
		}
		if(countX!=countY){
			throw new IllegalStateException("X and Y are unequal");
		}
		if(array.length==0){
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		}
		
		int xIndex=-1, yIndex=-1;
		while(xIndex<array.length-1 && yIndex<array.length-1){
			while(++xIndex<array.length && array[xIndex]!=x);
			if(xIndex==array.length-1 && array[xIndex]==x){
				throw new IllegalStateException("X is the at the last Index");
			}
			if(xIndex<array.length-1 && array[xIndex]==x && array[xIndex+1]==x){
				throw new IllegalStateException("Two Adjacent X values are there");
			}
			while(++yIndex<array.length && array[yIndex]!=y);
			if(xIndex!=yIndex-1 && (xIndex<array.length && yIndex<array.length)){
				int swapElement = array[xIndex+1];
				array[xIndex+1] = array[yIndex];
				array[yIndex] = swapElement;
			}
			xIndex += 1;
			yIndex = xIndex;
		}
	}
	
	
	//Count clumps logic taking array and size of array as argument
	int countClump(int[] array){
		int clumpCount = 0;
		int front = 0;
		int rear = 0;
		if(array.length==0){
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		}
		while(rear<array.length){
			int count = 0;
			while(array[front]==array[rear]){
				count++;
				rear++;
				if(rear==array.length){  //Condition for end of array
					break;
				}
			}
			if(count>=2){
				clumpCount++;
			}
			front = rear;
		}
		return clumpCount;
	}

	//Return the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
	int getSplitIndex(int[] array){
		int sum = 0;
		if(array.length == 0 ){
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		}
		for(int index=0;index<array.length;index++){
			sum += array[index];
		}
		if(sum%2!=0){
			return -1;
		}
		else{
			int halfSum = 0;
			int index=0;
			while(halfSum != sum/2){
				halfSum += array[index++];
				if(index==array.length){
					return -1;
				}
			}
			return index;
		}
	}
	
}
