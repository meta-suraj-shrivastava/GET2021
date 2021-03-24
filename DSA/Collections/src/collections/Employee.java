package collections;

public class Employee{
	private int empId;
	private String name;
	private String address;
	
	Employee(int id,String name,String address){
		this.address = address;
		this.name =  name;
		this.empId = id;
	}
	
	int getId(){
		return this.empId;
	}
	
	String getName(){
		return this.name;
	}
	
	String getAddress(){
		return this.address;
	}
}

