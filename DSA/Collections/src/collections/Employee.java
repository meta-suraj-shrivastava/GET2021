package collections;

public class Employee  implements Comparable<Employee>{
	private int empId;
	private String name;
	private String address;
	static int id = 0;
	
	Employee(String name,String address){
		this.address = address;
		this.name =  name;
		this.empId = id++;
	}

	@Override
	public int compareTo(Employee emp) {
		return emp.empId - this.empId;
	}
	
	
	
}

