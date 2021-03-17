package linkedList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Linkedlist list = new Linkedlist();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.Add Node");
			System.out.println("2.Sort");
			System.out.println("3.Display");
			System.out.println("4.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter salary");
				int salary = sc.nextInt();
				System.out.println("Enter age");
				int age = sc.nextInt();
				list.insert(salary, age);
				break;
			case 2:
				list.sort();
				break;
			case 3:
				list.display();
				break;
			default:
				sc.close();
				return;
			}
		}

	}

}
