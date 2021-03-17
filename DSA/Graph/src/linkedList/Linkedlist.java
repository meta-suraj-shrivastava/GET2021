package linkedList;


//Employee node  contains salary and age of employee
class Node{
	int salary;
	int age;
	Node next;
	Node(int salary,int age){
		this.salary = salary;
		this.age = age;
		this.next = null;
	}
	
}


//this class provide method to sort linked list using insertion sort
public class Linkedlist {

	Node head = null,tail = null,sortedList;
	
	
	//method to insert node in linked list 
	//@param - salary:int ,age:int
	public void insert(int salary,int age){
		Node node = new Node(salary,age);
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
		Node tempNode = head;
		while(tempNode != null){
			System.out.println("Salary :"+tempNode.salary+" Age :"+tempNode.age);
			tempNode = tempNode.next;
		}
	}
	
	
	// takes first and last node,
	// but do not break any links in
    // the whole linked list
    private Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;
 
        Node pivotPrev = start;
        Node curr = start;
        int pivotSalary = end.salary;
        int pivotAge = end.age;
 
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.salary > pivotSalary) {
                // keep tracks of last modified item
                pivotPrev = curr;
                int temp = curr.salary;
                int tempAge = curr.age;
                curr.salary = start.salary;
                curr.age = start.age;
                start.salary = temp;
                start.age = tempAge;
                curr = curr.next;
            }
            else if(start.salary == pivotSalary){
            	if(start.age<=pivotAge){
            		pivotPrev = curr;
            		int temp = curr.age;
            		curr.age = start.age;
            		start.age = temp;
            		curr = curr.next;
            	}
            }
            start = start.next;
        }
 
        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.salary;
        int tempAge = curr.age;
        curr.salary = pivotSalary;
        curr.age = pivotAge;
        end.age = tempAge;
        end.salary = temp;
 
        // return one previous to current
        // because current is now pointing to pivot
        return pivotPrev;
    }

    private void sort(Node start, Node end)
    {
        if(start == null || start == end|| start == end.next )
            return;
 
        // split list and partion recurse
        Node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);
 
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);
 
        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                 && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }
    
    void sort(){
    	sort(head,tail);
    }

}
