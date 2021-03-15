package queueImp;

//This class provide basic methods to perform operation on queue like enqueue,dequeue etc.
public class MyQueue {
	private int front = -1;
	private int MAXSIZE = 100;
	private int rear = -1;
	private int[] queue = new int[MAXSIZE];
	
	
	//return true if queue is Empty
	boolean isEmpty(){
		return front == -1?true:false;
	}
	
	
	//add the number to the queue ,takes a int number as a argument
	void enqueue(int number){
		if(isFull()){
			System.out.println("Overflow");
			return;
		}
		else{
			if(front > 0 && rear == MAXSIZE){
				rear = -1;
			}
			queue[++rear] = number;
			if(front == -1) front = 0;
		}
	}
	
	
	//return the deleted number from the queue
	int deQueue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		
		return queue[front++];
	}
	
	//return true if the queue is full
	boolean isFull(){
		if((front == 0 && rear == MAXSIZE) || (front > rear) ) return true;
		return false;
	}
	
	
	//Display the item in queue
	void display(){
		if(isFull()){
			System.out.println("Queue is Empty");
			return;
		}
		int front = this.front;
		int rear = this.rear;
		while(front <= rear){
			System.out.print(queue[front++]+" ");
			if(front == MAXSIZE && front != rear){
				front = 0;
			}
		}
		System.out.println();
	}
}
