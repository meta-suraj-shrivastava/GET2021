package linkedList;

import java.util.HashMap;

//Node class contains the data and address of the next node
class Node{
	int data;
	Node nextNode ;
	Node(int data){
		this.data = data;
		nextNode = null;
	}
}


/*
 * this class provide basic methods to perform different operation on linked list
 * 1. addData to list @param data:int
 * 2.DisplayList
 * 3.Rotate a sublinkList @param left ,right and numberOfroation
 */
public class MyLinkedList {
   private Node start=null;
   
   //add data to the linked list
	void add(int data){
		Node newNode = new Node(data);
		if(start == null){
			start = newNode;
		}
		else{
			Node temp = start;
			while(temp.nextNode!=null){
				temp = temp.nextNode;
			}
			temp.nextNode = newNode;
		}
	}
	
	//Display the data in the linked List
	void displayList(){
		if(start == null){
			System.out.println("List is Empty");
			return;
		}
		
		Node temp = start;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.nextNode;
		}
		System.out.println();
	}
	
	//this function rotates the sublist by numberOfRotation
	void rotateSubList(int left,int right,int numberOfRotation){
		Node leftAddr = start;
		Node rightAddr =  start;
		Node rotationAddr = start;
		int rotationIndex = right - (numberOfRotation%(right-left));
		while(--left>1){
			leftAddr = leftAddr.nextNode;
		}
		while(--right>0){
			rightAddr = rightAddr.nextNode;
		}		
		while(--rotationIndex>0){
			rotationAddr = rotationAddr.nextNode;
		}
		
		Node tempAddr = rotationAddr.nextNode;
		rotationAddr.nextNode = rightAddr.nextNode;
		rightAddr.nextNode = leftAddr.nextNode;
		leftAddr.nextNode = tempAddr;
		
			}
	
	
	boolean detectLoop(){
		HashMap<Node,Integer> map =  new HashMap();
		Node start  = this.start;
		while(start.nextNode!=null){
			if(map.containsKey(start)){
				return true;
			}
			map.put(start, 1);
			start = start.nextNode;
		}
		return false;
	}
}
