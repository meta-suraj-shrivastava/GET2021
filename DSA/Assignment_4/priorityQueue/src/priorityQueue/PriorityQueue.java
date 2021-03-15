package priorityQueue;


//Interface provide the method which can be implement to any class
interface PriorityQueueInt{
	
	void enqueue(int element);  //insert element
	void deQueue(); //remove highest priority element
	int peek(); //return the highest priority elemnt
	void display(); //display all the elements in queue
}



//this class implements the methods provided by the ProiorityQueueInt
public class PriorityQueue implements PriorityQueueInt {

	int[] priorityQueue;
	int front = -1,rear = -1;

	//Constructor initialize the queue of the desired size
	////@param - size:int
	PriorityQueue(int size){
		priorityQueue = new int[size];
	}
	
	
	//return the index where the new element should be place 
	//@param - element:int
	private int getInsertIndex(int element){
		int index = front;
		if(front == -1) return 0;
		while(element < priorityQueue[index]){
			index++;
			if(index>rear){
				return index;
			}
		}
		return index;
	}
	
	//always put the highest priority element at the front of the queue
	//@param - element:int
	@Override
	public void enqueue(int element){
		if(front > rear && front != -1){
			System.out.println("OverFlow");
			return;
		}
		if(front == -1){
			priorityQueue[++rear] =  element;
			front = 0;
		}
		else{
			int index = getInsertIndex(element);
			int tempRear = rear++;
			while(index<=tempRear){
				priorityQueue[tempRear+1] = priorityQueue[tempRear];
				tempRear--;
			}
			priorityQueue[index] = element;
		}
	}
	
	//remove the highest priority element of queue 
	@Override
	public void deQueue(){
		if(front > rear) {
			System.out.println("UnderFlow");
		}
		front++;
	}
	
	
	//return front of the queue
	@Override
	public int peek(){
		return priorityQueue[front];
	}
	
	//Display all the queue elements
	public void display(){
		for(int index = front;index<=rear;index++)
			System.out.print(priorityQueue[index]+" ");
		System.out.println();
	}
	
	
	//Special Display function to display the queue for virat kohli problem
	public void displayForVkohli(){
		for(int index = front;index<=rear;index++)
			System.out.println("Bowler with "+priorityQueue[index]+" left");
		System.out.println();
	}
}
