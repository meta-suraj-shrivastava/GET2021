package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpCollection {

	private List<Employee> list;
	public EmpCollection() {
		list = new ArrayList<>();
	}
	
	
	void addEmployee(Employee emp){
		if(!contains(emp)){
			list.add(emp);
		}
		else{
			System.out.println("Employee with id "+emp.getId()+" Already Exist!!");
		}
	}


	private boolean contains(Employee employee) {
		for(Employee emp:list){
			if(emp.getId()==employee.getId()) return true;
		}
		return false;
	}
	
	void naturalOrder(){
		Collections.sort(list, new Comparator<Employee>(){

			@Override
			public int compare(Employee firtEmployee, Employee secondEmployee) {
				return firtEmployee.getId()-secondEmployee.getId();
			}
			
		});
	}
}
