package splitArray;

public class SplitArray {

	int getSplitIndex(int[] array,int size){
		int sum = 0;
		for(int index=0;index<size;index++){
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
			}
			return index;
		}
	}
	
}
