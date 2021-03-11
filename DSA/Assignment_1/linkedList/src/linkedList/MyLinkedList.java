package linkedList;

//Node class contains the data and address of the next node
class Node{
	int data;
	Node nextNode = null;
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
		Node newNode = new Node();
		newNode.data = data;
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
	
	void rotateSubList(int left,int right,int numberOfroation){
		
	}
}
