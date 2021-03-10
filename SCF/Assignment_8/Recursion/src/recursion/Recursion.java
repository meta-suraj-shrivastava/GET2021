package recursion;

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
	
	boolean linearSearch(int [] arr,int dataToSearch){
		
		for(int index=0;index<arr.length;index++){
			if(arr[index]==dataToSearch)
				return true;
		}
		return false;
	}
	
	boolean binarySearch(int arr[] ,int dataToSearch, int lowerBound ,int upperBound ){
		int mid = (lowerBound + upperBound)/2;
		
		if(lowerBound>upperBound) return false;
		if(arr[mid]==dataToSearch) return true;
		else{
			if(dataToSearch > arr[mid]) return binarySearch(arr,dataToSearch,mid+1,upperBound);
			else return binarySearch(arr,dataToSearch,lowerBound,mid-1);
		}
	}

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
	
	
}
