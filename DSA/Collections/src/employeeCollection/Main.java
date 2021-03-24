package employeeCollection;

import java.util.Scanner;
import noOfUniqueChar.UniqueChar;
import massCalculator.MassCalculator;


//Driver class
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee employee;
		UniqueChar uniChar = new UniqueChar();
		EmpCollection collection = new EmpCollection();
		MassCalculator massCalc = new MassCalculator();
		while(true){
			//All functionalities given in the assignment
			System.out.println("1.Add employee");
			System.out.println("2.natural Order sort");
			System.out.println("3.Sort acc. to name");
			System.out.println("4.Display Employees");
			System.out.println("5.Find unique character in String");
			System.out.println("6.Mass calculator");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee ID");
				int id  = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name");
				String name = sc.nextLine();
				System.out.println("Enter Address");
				String address = sc.nextLine();
				employee = new Employee(id, name, address);
				collection.addEmployee(employee);
				break;
			case 2:
				collection.naturalOrder();
				break;
			case 3:
				collection.nameSort();
				break;
			case 4:
				collection.display();
				break;
			case 5:
				System.out.println("Enter a String");
				String str = sc.next();
				System.out.println("Total Unique character are :"+uniChar.numberOfUniqueChar(str));
				break;
			case 6:
				System.out.println("Enter molecular formula");
				String formula = sc.next();
				System.out.println("Mass is "+ massCalc.getMass(formula));
				break;
			default:
				sc.close();
				return;
			}
		}
	}
}
