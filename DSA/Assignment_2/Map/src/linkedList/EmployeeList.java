package linkedList;


//Employee node  contains salary and age of employee
class EmployeeNode{
	int salary;
	int age;
	EmployeeNode next;
	EmployeeNode(int salary,int age){
		this.salary = salary;
		this.age = age;
		this.next = null;
	}
	
}


//this class provide method to sort linked list using insertion sort
public class EmployeeList {

	EmployeeNode head = null,tail = null,sortedList;
	
	
	//method to insert node in linked list 
	//@param - salary:int ,age:int
	public void insert(int salary,int age){
		EmployeeNode node = new EmployeeNode(salary,age);
		if(head == null){
			head = node;
			tail = node;
		}
		else{
			tail.next = node;
			tail = node;
		}
		
	}
	
	//display the linked list
	public void display(){
		EmployeeNode tempNode = head;
		while(tempNode != null){
			System.out.println("Salary :"+tempNode.salary+" Age :"+tempNode.age);
			tempNode = tempNode.next;
		}
	}
	
	
	//sort the linked list using insertion Sort
	  public void sort()  
	    { 
	        // Initialize sorted linked list 
	        sortedList = null; 
	        EmployeeNode current = head; 
	        
	        // Traverse the given linked list and insert every 
	        // node to sorted 
	        while (current != null)  
	        { 
	            // Store next for next iteration 
	        	EmployeeNode next = current.next; 
	            // insert current in sorted linked list 
	            sortedInsert(current); 
	            // Update current 
	            current = next; 
	        } 
	        // Update head_ref to point to sorted linked list 
	        head = sortedList; 
	    }

	private void sortedInsert(EmployeeNode newNode) {
		 /* Special case for the head end */
        if (sortedList == null || sortedList.salary < newNode.salary)  
        { 
            newNode.next = sortedList; 
            sortedList = newNode; 
        } 
        else 
        { 
            EmployeeNode current = sortedList; 
            /* Locate the node before the point of insertion */
            while (current.next != null && (current.next.salary > newNode.salary || 
            		(current.next.salary == newNode.salary  && newNode.age > current.next.age )))  
            { 
                current = current.next; 
            } 
            newNode.next = current.next; 
            current.next = newNode; 
        } 
		
	} 

}
