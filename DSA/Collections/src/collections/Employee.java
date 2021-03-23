package collections;

public class Employee  implements Comparable<Employee>{
	private int empId;
	private String name;
	private String address;
	
	Employee(int id,String name,String address){
		this.address = address;
		this.name =  name;
		this.empId = id++;
	}

	@Override
	public int compareTo(Employee emp) {
		return emp.empId - this.empId;
	}
	
	@Override
	public int equals(){
		
	}
	
	
}

