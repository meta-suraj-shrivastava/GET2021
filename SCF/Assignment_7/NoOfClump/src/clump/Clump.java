package clump;

public class Clump {

	//Count clumps logic taking array and size of array as argument
	int countClump(int[] array,int numberOfElements){
		int clumpCount = 0;
		int front = 0;
		int rear = 0;
		
		while(rear<numberOfElements){
			int count = 0;
			while(array[front]==array[rear]){
				count++;
				rear++;
				if(rear==numberOfElements){  //Condition for end of array
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
	
}
