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


class MultiVariableNode{
	int coeff;
	char var;
	int exp;
	MultiVariableNode nextNode ;
	MultiVariableNode downNode;
	MultiVariableNode(int coeff,char var,int exp){
		this.coeff = coeff;
		this.exp = exp;
		this.var = var;
		downNode = null;
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
   private Node start=null,tail=null;
   //add data to the linked list
	void add(int data){
		Node newNode = new Node(data);
		if(start == null){
			start = newNode;
			tail = newNode;
		}
		else{
			tail.nextNode = newNode;
			tail = newNode;
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
		HashMap<Node,Integer> map =  new HashMap<>();
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


//This class handle work related to multivariable polynomial
/*
 * This class provide following methods:
 * 1. addterm - add the term to the existing polynomail
 * 2. display Node - return the single term as string
 * 3. displayPoly -  add all the return term by displayNode and return the whole polyNomial
 */

class MultiVariablePolynomial{
	
	private MultiVariableNode tail = null ,head = null;
	char[] availableVar = {'X','Y','Z','A','B','C','P'};
	int len = 0;
	private int degree=0;
	
	
	
	//add term to the polynomial 
	//@param - coefficient ,  exponent array of all the variable
	void addterm(int coeff,int[] expo) {
		if(coeff == 0){
			return;
		}
		MultiVariableNode node = new MultiVariableNode(coeff,availableVar[0],expo[0]);
		int degree = expo[0];
		for(int index=1;index<expo.length;index++){
				MultiVariableNode tempNode = node;
				while(tempNode.downNode!=null){
					tempNode = tempNode.downNode;
			}
				tempNode.downNode = new MultiVariableNode(1,availableVar[index],expo[index]);
				degree+=expo[index];
				
		}
		if(this.degree < degree) this.degree = degree;
		if(head==null){
			head = node;
			tail = node;
		}
		else{
			tail.nextNode = node;
			tail = node;
		}
		
		len++;
	}
	
	
	//return the degree of the polynomial
	int getDegree(){
		return degree;
	}
	
	
	//return the string representaion of single Node
	String displayNode(MultiVariableNode node){
		MultiVariableNode tempNode = node;
		MultiVariableNode tempDownNode = tempNode.downNode;
			String term ="";
			term +=""+tempNode.coeff+tempNode.var+"^"+tempNode.exp;
			while(tempDownNode!=null){
				term += tempDownNode.var+"^"+tempDownNode.exp;
				tempDownNode = tempDownNode.downNode;
			}
//			term = term.replaceAll("^1","");
			if(!term.contains("-") && tempNode!=head){
				return "+"+term;
			}
			else{
				return term;
			}
			
		}
	
	
	//return the representation of polynomial
	String displayPoly(){
		MultiVariableNode tempNode = head;
		String resultPoly = "";
		if(head == null){
			return "First Add terms";
		}
		else{
			while(tempNode!=null){
				resultPoly += displayNode(tempNode);
				tempNode = tempNode.nextNode;
			}
		}
		return resultPoly;
	}
	
}
