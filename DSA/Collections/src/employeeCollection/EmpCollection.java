package employeeCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//this is the employeeCollection class contains the employee collection
public class EmpCollection {

	private List<Employee> list; //employee collection
	
	public EmpCollection() {
		list = new ArrayList<>();
	}
	
	
	//Add employee if not exists with same Id
	//@param - object of Employee
	void addEmployee(Employee emp){
		if(!contains(emp)){
			list.add(emp);
		}
		else{
			System.out.println("Employee with id "+emp.getId()+" Already Exist!!");
		}
	}


	//return true if the collection contains the same object with same id
	private boolean contains(Employee employee) {
		for(Employee emp:list){
			if(emp.getId()==employee.getId()) return true;
		}
		return false;
	}
	
	
	//sort the employees according to name alphabetically using comparator class
	void nameSort(){
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee firtEmployee, Employee secondEmployee) {
				
				return firtEmployee.getName().compareToIgnoreCase(secondEmployee.getName());
			}
		});
	}
	
	
	//perform natural order sorting on employee collection
	void naturalOrder(){
		Collections.sort(list, new Comparator<Employee>(){

			@Override
			public int compare(Employee firtEmployee, Employee secondEmployee) {
				return firtEmployee.getId()-secondEmployee.getId();
			}
			
		});
	}
	
	//display all the employees
	public void display(){
		if(list.size()!=0){
			System.out.println("ID \t Name \t\t Address");
		for(Employee emp:list){
			System.out.println(emp.getId()+" \t "+emp.getName()+" \t "+emp.getAddress());
		}
		}
	}
}
